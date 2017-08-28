package com.adroit.data.container;

import java.util.Map;

import com.adroit.data.sp.SQLStoredProcedure;

/**
 * This contains the compiled stored procedure after it has been successfully
 * read from the yml file, properly defined and compiled.
 * 
 * <code>
 * <br>
 * Usage:
 * SQLStoredProcedure procedure = storeProcContainer.get("Name_of_stored_procedure");
 * 
 * </code>
 * 
 * @author Adroit
 *
 */
public class StoredProcedureContainer {

	private Map<String, SQLStoredProcedure> storeProcContainer;

	/**
	 * @return the storeProcContainer
	 */
	public Map<String, SQLStoredProcedure> getStoreProcContainer() {
		return storeProcContainer;
	}

	/**
	 * @param storeProcContainer
	 *            the storeProcContainer to set
	 */
	public void setStoreProcContainer(Map<String, SQLStoredProcedure> storeProcContainer) {
		this.storeProcContainer = storeProcContainer;
	}

}
