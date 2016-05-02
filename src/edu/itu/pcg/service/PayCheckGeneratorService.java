package edu.itu.pcg.service;

import edu.itu.pcg.dao.FederalTaxBracketDao;
import edu.itu.pcg.dao.StateTaxBracketDao;
import edu.itu.pcg.dto.FederalTaxBracket;
import edu.itu.pcg.dto.StateTaxBracket;
import edu.itu.pcg.model.PayCheckRequest;
import edu.itu.pcg.model.PayCheckResponse;
import edu.itu.pcg.util.PayCheckGrossCalculatorUtil;

/**
 * @author Kavya and Varsha
 *
 */
public class PayCheckGeneratorService {

	public PayCheckGeneratorService() {
		
	}
	
	public PayCheckResponse generatePayCheck(PayCheckRequest request) {
		PayCheckResponse response = new PayCheckResponse(request);
		FederalTaxBracketDao federalTaxDao = new FederalTaxBracketDao();
		StateTaxBracketDao stateTaxDao = new StateTaxBracketDao();
		
		double grossPay = PayCheckGrossCalculatorUtil.calculatePaycheckGrossPay(request.getAnnualGrossPay(), request.getPayFrequency());
		response.setGrossPay(grossPay);
		
		double medicareTaxDeduction = 0d;
		if (!request.isMedicareExcempt()) {
			//medicare tax for the year 2016 is 1.45% or 3.8% depending of annual gross and filing status
			double medicareTaxPercent = getMedicareTaxPercent(request.getAnnualGrossPay(), request.getFilingStatus()) / 100;
			medicareTaxDeduction = grossPay * medicareTaxPercent;
			response.setMedicareTax(medicareTaxDeduction);
		}
		
		//SDI/SUI tax for the year 2016 is 0.9%
		double sdiTaxPercent = 0.9d / 100; 
		double sdiTaxDuduction = grossPay * sdiTaxPercent;
		response.setSdisuiTax(sdiTaxDuduction);

		//social security tax for the year 2016 is 0.9%
		double socialSecurityTaxPercent = 6.2d / 100; 
		double socialSecurityTaxDuduction = grossPay * socialSecurityTaxPercent;
		response.setSocialSecurityTax(socialSecurityTaxDuduction);
		
		double federalTaxDeduction = 0d;
		if (!request.isFederalExcempt()) {
			String[] federalTaxQueryParams = {request.getFilingStatus(), String.valueOf(request.getAnnualGrossPay())};
			FederalTaxBracket federalTaxDto = federalTaxDao.retrieve(federalTaxQueryParams);
			double federatlTaxPercent = federalTaxDto.getRate()/100;
			federalTaxDeduction = grossPay * federatlTaxPercent;
			response.setFederalTax(federalTaxDeduction);
		}
		
		double stateTaxDeduction = 0d;
		if (!request.isExemptState()) {
			String[] stateTaxQueryParams = {request.getState(), request.getFilingStatus(), String.valueOf(request.getAnnualGrossPay())};
			StateTaxBracket stateTaxDto = stateTaxDao.retrieve(stateTaxQueryParams);
			double statelTaxPercent = stateTaxDto.getRate()/100;
			stateTaxDeduction = grossPay * statelTaxPercent;
			response.setStateTax(stateTaxDeduction);	
		}
			
		double netPay = grossPay - federalTaxDeduction - stateTaxDeduction - socialSecurityTaxDuduction - medicareTaxDeduction - sdiTaxDuduction;
		response.setNetPay(netPay);
		return response;
	}
	
	/**
	 * Medicare tax = 3.8% when Single -> 200k or Married ->250k, otherwise 1.45%
	 * 
	 * @param annualGrossPay
	 * @param filingStatus
	 * @return
	 */
	private float getMedicareTaxPercent(double annualGrossPay, String filingStatus) {
		float medicareTaxPercent = 1.45f;
		
		if ((annualGrossPay > 200000 && "Single".equals(filingStatus)) || (annualGrossPay > 250000 && "Married".equals(filingStatus))) {
			medicareTaxPercent = 3.8f;
		}
		
		return medicareTaxPercent;
	}
	
	/*
	public static void main(String[] args) {
		PayCheckGeneratorService srvc = new PayCheckGeneratorService();
		
		PayCheckRequest request = new PayCheckRequest();
		request.setAnnualGrossPay(130000D);
		request.setExcemptionStatus("Federal");
		request.setFilingStatus("Single");
		request.setGrossPayType("Annual");
		request.setPayFrequency("Bi-Weekly");
		request.setState("California");
		
		PayCheckResponse response = srvc.generatePayCheck(request);
		System.out.println("pay check response: "+response);
	}
	*/
}
