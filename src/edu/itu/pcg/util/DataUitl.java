package edu.itu.pcg.util;

import edu.itu.pcg.dao.FederalTaxBracketDao;
import edu.itu.pcg.dao.StateTaxBracketDao;
import edu.itu.pcg.dto.FederalTaxBracket;
import edu.itu.pcg.dto.StateTaxBracket;

/**
 * Remove and create data in database.
 *  
 * @author Kavya and Varsha
 *
 */
public class DataUitl {

	private DataUitl() {
		
	}
	
	public static void createFederalTaxData() {
		// re-create data of FEDERAL_TAX_BRACKET table
		FederalTaxBracketDao federalTaxDao = new FederalTaxBracketDao();
		federalTaxDao.removeAllData();
		federalTaxDao.dropTable();
		federalTaxDao.createTable();
		federalTaxDao.insertAllData();	
		// test
		FederalTaxBracket federalTaxDto = federalTaxDao.retrieve(new String[]{"Single", "100"});
		System.out.println(federalTaxDto);
	}
	
	public static void createStateTaxData() {
		// re-create data of STATE_TAX_BRACKET table
		StateTaxBracketDao stateTaxDao = new StateTaxBracketDao();
		stateTaxDao.removeAllData();
		stateTaxDao.dropTable();
		stateTaxDao.createTable();
		stateTaxDao.insertAllData();
		// test
		StateTaxBracket stateTaxDto = stateTaxDao.retrieve(new String[]{"California", "Single", "10000"});
		System.out.println(stateTaxDto);
	}
	
	public static void main(String[] args) {
		createFederalTaxData();
		createStateTaxData();
		ConnectionUtil.closeConnection();
	}
}
