package com.adroit.data.sp;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.util.StringUtils;

/**
 * The actual pojo representation of stored procedure inside database <br>
 * procName: Name of the stored procedure <br>
 * input: list of the parameters required by the stored procedure along with its
 * datatype [format: name_of_parameter, datatype]
 * 
 * @author Adroit
 *
 */
public class SQLStoredProcedure extends StoredProcedure {

	private String procName;

	private List<String> input;

	private String output;

	/**
	 * @return the procName
	 */
	public String getProcName() {
		return procName;
	}

	/**
	 * @param procName
	 *            the procName to set
	 */
	public void setProcName(String procName) {
		this.procName = procName;
	}

	/**
	 * @return the input
	 */
	public List<String> getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(List<String> input) {
		this.input = input;
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param output
	 *            the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	public void initialize(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
		setSql(procName);
		for (int index = 0; index < input.size(); index++) {
			String sp = input.get(index);
			if (StringUtils.isEmpty(sp)) {
				throw new IllegalArgumentException(
						"Empty parameter provided at position " + index + " for procedure " + procName);
			}
			sp = sp.trim();
			String pName = null;
			String pType = null;
			if (sp.contains(",")) {
				pName = sp.substring(0, sp.indexOf(",")).trim();
				pType = sp.substring(sp.indexOf(",") + 1, sp.length()).trim();
			} else if (sp.contains(" ")) {
				pName = sp.substring(0, sp.indexOf(" ")).trim();
				pType = sp.substring(sp.indexOf(" ") + 1, sp.length()).trim();
			} else {
				throw new IllegalArgumentException(
						"Empty parameter provided at position " + index + " for procedure " + procName);
			}
			declareParameter(new SqlParameter(pName, getType(pType)));
		}
		compile();
	}

	private int getType(String type) {
		if (ParamType.TIMESTAMP.toString().equalsIgnoreCase(type)) {
			return Types.TIMESTAMP;
		} else {
			return Types.NVARCHAR;
		}
	}

}
