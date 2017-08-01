package com.adroit.data.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.adroit.data.container.StoredProcedureContainer;
import com.adroit.data.sp.SQLStoredProcedure;

public abstract class StoredProcedureConfiguration implements InitializingBean {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private List<SQLStoredProcedure> procedures;

	private Map<String, SQLStoredProcedure> storeProcContainer = new HashMap<>();

	private StoredProcedureContainer storedProcedureContainer = new StoredProcedureContainer();

	public Map<String, SQLStoredProcedure> loadStoreProcedures() {
		if (procedures != null) {
			procedures.forEach((sp) -> {
				sp.initialize(getJdbcTemplate());
				logger.debug("Registering store procedure: " + sp.getProcName());
				storeProcContainer.put(sp.getProcName(), sp);
			});
		}
		return storeProcContainer;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (procedures != null) {
			procedures.forEach((sp) -> {
				sp.initialize(getJdbcTemplate());
				logger.debug("Registering store procedure: " + sp.getProcName());
				storeProcContainer.put(sp.getProcName(), sp);
			});
			storedProcedureContainer.setStoreProcContainer(storeProcContainer);
		}
	}

	/**
	 * @return the storeProcContainer
	 */
	public StoredProcedureContainer getStoredProcedureContainer() {
		// StoredProcedureContainer container = new StoredProcedureContainer();
		// storedProcedureContainer.setStoreProcContainer(storeProcContainer);
		return storedProcedureContainer;
	}

	/**
	 * @return the procedures
	 */
	public List<SQLStoredProcedure> getProcedures() {
		return procedures;
	}

	/**
	 * @param procedures
	 *            the procedures to set
	 */
	public void setProcedures(List<SQLStoredProcedure> procedures) {
		this.procedures = procedures;
	}

	public abstract JdbcTemplate getJdbcTemplate();

}
