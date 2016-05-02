package edu.itu.pcg.dao;

import edu.itu.pcg.dto.StateTaxBracket;
import edu.itu.pcg.util.ConnectionUtil;

/**
 * @author Kavya and Varsha
 *
 */
public class StateTaxBracketDao {

	private static final String DDL_FILE_PATH = "resources/DBScripts/StateTaxBracket_DDL.sql";
	private static final String DML_FILE_PATH = "resources/DBScripts/StateTaxBracket_DML.sql";
	private static final String DROP_FILE_PATH = "resources/DBScripts/StateTaxBracket_DROP.sql";
	private static final String DEL_FILE_PATH = "resources/DBScripts/StateTaxBracket_DEL.sql";
	
	private static final String SELECT_QUERY = "SELECT STATE, RATE, STATUS, MIN, MAX FROM STATE_TAX_BRACKET WHERE STATE = '?0' AND STATUS = '?1' AND MIN <= ?2 AND MAX >= ?2";
	
	public StateTaxBracketDao() {
		
	}
	
	public StateTaxBracket retrieve(String[] queryParams) {
		String query = SELECT_QUERY;
		
		for (int i = 0; i < queryParams.length; i++) {
			query = query.replace("?"+i, queryParams[i]);
		}
		
		StateTaxBracket stb = null;
		try {
			stb = new StateTaxBracket();
			ConnectionUtil.executeQuery(query, stb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stb;
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
