package edu.itu.pcg.model;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kavya and Varsha
 *
 */
public class PayCheckRequest {

	private String state;
	private double annualGrossPay;
	private String grossPayType;
	private String payFrequency;
	private String filingStatus;
	private String[] exemptionStatus;
	private boolean isExemptState;
	private boolean isFederalExcempt;
	private boolean isMedicareExcempt;
	private boolean isFICAExempt;
	
	public PayCheckRequest() {
		
	}
	
	public PayCheckRequest(HttpServletRequest request) {
        state = request.getParameter("state");
        annualGrossPay = Double.parseDouble(request.getParameter("annual_Gross_Pay"));
        grossPayType = request.getParameter("gross_pay_type");
        payFrequency = request.getParameter("pay_frequency");
        filingStatus = request.getParameter("filing_status");       
        
        if ("yes".equals(request.getParameter("exempt_state"))) {
        	isExemptState = true;
        }
        
        exemptionStatus = request.getParameterValues("tax_exempt");
        if (exemptionStatus != null && exemptionStatus.length > 0) {
        	List<String> exemptsAsList = Arrays.asList(exemptionStatus);
        	if (exemptsAsList.contains("Federal")) {
        		isFederalExcempt = true;
        	}
        	if (exemptsAsList.contains("FICA")) {
        		isFICAExempt = true;
        	}
        	if (exemptsAsList.contains("Medicare")) {
        		isMedicareExcempt = true;
        	}
        }
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the annualGrossPay
	 */
	public double getAnnualGrossPay() {
		return annualGrossPay;
	}
	
	/**
	 * @param annualGrossPay the annualGrossPay to set
	 */
	public void setAnnualGrossPay(double annualGrossPay) {
		this.annualGrossPay = annualGrossPay;
	}
	
	/**
	 * @return the grossPayType
	 */
	public String getGrossPayType() {
		return grossPayType;
	}
	
	/**
	 * @param grossPayType the grossPayType to set
	 */
	public void setGrossPayType(String grossPayType) {
		this.grossPayType = grossPayType;
	}
	
	/**
	 * @return the payFrequency
	 */
	public String getPayFrequency() {
		return payFrequency;
	}
	
	/**
	 * @param payFrequency the payFrequency to set
	 */
	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}
	
	/**
	 * @return the filingStatus
	 */
	public String getFilingStatus() {
		return filingStatus;
	}
	
	/**
	 * @param filingStatus the filingStatus to set
	 */
	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}
	
	/**
	 * @return the exemptionStatus
	 */
	public String[] getExemptionStatus() {
		return exemptionStatus;
	}
	
	/**
	 * @param exemptionStatus the exemptionStatus to set
	 */
	public void setExemptionStatus(String[] exemptionStatus) {
		this.exemptionStatus = exemptionStatus;
	}
	
	/**
	 * @return the isExcemptState
	 */
	public boolean isExemptState() {
		return isExemptState;
	}

	/**
	 * @param isExcemptState the isExcemptState to set
	 */
	public void setExemptState(boolean isExcemptState) {
		this.isExemptState = isExcemptState;
	}
	
	/**
	 * @return the isFederalExcempt
	 */
	public boolean isFederalExcempt() {
		return isFederalExcempt;
	}

	/**
	 * @param isFederalExcempt the isFederalExcempt to set
	 */
	public void setFederalExcempt(boolean isFederalExcempt) {
		this.isFederalExcempt = isFederalExcempt;
	}

	/**
	 * @return the isMedicareExcempt
	 */
	public boolean isMedicareExcempt() {
		return isMedicareExcempt;
	}

	/**
	 * @param isMedicareExcempt the isMedicareExcempt to set
	 */
	public void setMedicareExcempt(boolean isMedicareExcempt) {
		this.isMedicareExcempt = isMedicareExcempt;
	}

	/**
	 * @return the isFICAExempt
	 */
	public boolean isFICAExempt() {
		return isFICAExempt;
	}

	/**
	 * @param isFICAExempt the isFICAExempt to set
	 */
	public void setFICAExempt(boolean isFICAExempt) {
		this.isFICAExempt = isFICAExempt;
	}

	@Override
	public String toString() {
		return "State: "+state+", AnnualGrossPay: "+annualGrossPay+", GrossPayType: "+grossPayType+
				", FilingStatus: "+filingStatus+", IsExemptState: "+isExemptState+", IsFederalExcempt: "+
				isFederalExcempt+", IsMedicareExcempt: "+isMedicareExcempt+", IsFICAExempt: "+isFICAExempt;
	}
	
}
