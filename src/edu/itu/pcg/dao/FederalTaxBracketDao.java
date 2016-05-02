package edu.itu.pcg.dao;

import edu.itu.pcg.dto.FederalTaxBracket;
import edu.itu.pcg.util.ConnectionUtil;

/**
 * @author Kavya and Varsha
 *
 */
public class FederalTaxBracketDao {
	
	private static final String DDL_FILE_PATH = "resources/DBScripts/FederalTaxBracket_DDL.sql";
	private static final String DML_FILE_PATH = "resources/DBScripts/FederalTaxBracket_DML.sql";
	private static final String DROP_FILE_PATH = "resources/DBScripts/FederalTaxBracket_DROP.sql";
	private static final String DEL_FILE_PATH = "resources/DBScripts/FederalTaxBracket_DEL.sql";
	
	private static final String SELECT_QUERY = "SELECT RATE, STATUS, MIN, MAX FROM FEDERAL_TAX_BRACKET WHERE STATUS = '?0' AND MIN <= ?1 AND MAX >= ?1";
	
	public FederalTaxBracketDao() {
		
	}
	
	public FederalTaxBracket retrieve(String[] queryParams) {
		String query = SELECT_QUERY;
		
		for (int i = 0; i < queryParams.length; i++) {
			query = query.replace("?"+i, queryParams[i]);
		}
		
		FederalTaxBracket ftb = null;
		try {
			ftb = new FederalTaxBracket();
			ConnectionUtil.executeQuery(query, ftb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ftb;
	}
	
	public void createTable() {
		ConnectionUtil.executeUpdateQuery(DDL_FILE_PATH);
	}
	
	public void insertAllData() {
		ConnectionUtil.executeUpdateQuery(DML_FILE_PATH);
	}
	
	public void removeAllData() {
		ConnectionUtil.executeUpdateQuery(DEL_FILE_PATH);
	}
	
	public void dropTable() {
		ConnectionUtil.executeUpdateQuery(DROP_FILE_PATH);
	}

}
