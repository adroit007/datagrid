package com.adroit.data.container;

import java.util.Map;

import com.adroit.data.sp.SQLStoredProcedure;

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
