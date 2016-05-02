package edu.itu.pcg.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Kavya and Varsha
 *
 */
public class FederalTaxBracket implements BaseDto {

	private float rate;
	private String status;
	private float min;
	private float max;
	
	public FederalTaxBracket() {
		
	}
	
	public FederalTaxBracket(float rate, String status, float min, float max) {
		this();
		this.rate = rate;
		this.status = status;
		this.min = min;
		this.max = max;
	}

	@Override
	public void setResultSetData(ResultSet rs) throws SQLException {
		rate = rs.getFloat("rate");
		status = rs.getString("status");
		min = rs.getFloat("min");
		max = rs.getFloat("max");
	}
	
	/**
	 * @return the rate
	 */
	public float getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the min
	 */
	public float getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(float min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public float getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(float max) {
		this.max = max;
	}
	
	@Override
	public String toString() {
		return "Rate: "+rate+"; Status: "+status+"; Min: "+min+"; Max: "+max;
	}
}
