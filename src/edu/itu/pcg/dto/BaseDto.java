package edu.itu.pcg.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Kavya and Varsha
 *
 */
public interface BaseDto {

	void setResultSetData(ResultSet rs) throws SQLException;
	
}
