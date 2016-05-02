package edu.itu.pcg.model;

/**
 * @author Kavya and Varsha
 *
 */
public class PayCheckResponse {

	private String state;
	private double annualGrossPay;
	private String grossPayType;
	private String payFrequency;
	private String filingStatus;
	private String[] exemptionStatus;
	private double socialSecurityTax;
	private double medicareTax;
	private double sdisuiTax;
	private double federalTax;
	private double stateTax;
	private double grossPay;
	private double netPay;
	
	public PayCheckResponse() {
		
	}

	public PayCheckResponse(PayCheckRequest request) {
		this.state = request.getState();
		this.annualGrossPay = request.getAnnualGrossPay();
		this.grossPayType = request.getGrossPayType();
		this.payFrequency = request.getPayFrequency();
		this.filingStatus = request.getFilingStatus();
		this.exemptionStatus = request.getExemptionStatus();
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
	 * @return the socialSecurityTax
	 */
	public double getSocialSecurityTax() {
		return socialSecurityTax;
	}

	/**
	 * @param socialSecurityTax the socialSecurityTax to set
	 */
	public void setSocialSecurityTax(double socialSecurityTax) {
		this.socialSecurityTax = socialSecurityTax;
	}

	/**
	 * @return the medicareTax
	 */
	public double getMedicareTax() {
		return medicareTax;
	}

	/**
	 * @param medicareTax the medicareTax to set
	 */
	public void setMedicareTax(double medicareTax) {
		this.medicareTax = medicareTax;
	}

	/**
	 * @return the sdisuiTax
	 */
	public double getSdisuiTax() {
		return sdisuiTax;
	}

	/**
	 * @param sdisuiTax the sdisuiTax to set
	 */
	public void setSdisuiTax(double sdisuiTax) {
		this.sdisuiTax = sdisuiTax;
	}

	/**
	 * @return the federalTax
	 */
	public double getFederalTax() {
		return federalTax;
	}

	/**
	 * @param federalTax the federalTax to set
	 */
	public void setFederalTax(double federalTax) {
		this.federalTax = federalTax;
	}

	/**
	 * @return the stateTax
	 */
	public double getStateTax() {
		return stateTax;
	}

	/**
	 * @param stateTax the stateTax to set
	 */
	public void setStateTax(double stateTax) {
		this.stateTax = stateTax;
	}

	/**
	 * @return the grossPay
	 */
	public double getGrossPay() {
		return grossPay;
	}

	/**
	 * @param grossPay the grossPay to set
	 */
	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	/**
	 * @return the netPay
	 */
	public double getNetPay() {
		return netPay;
	}

	/**
	 * @param netPay the netPay to set
	 */
	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	
	@Override
	public String toString() {
		return "NetPay ("+netPay+") = GrossPay ("+grossPay+") - Taxes[FederalTax ("+federalTax+
				") + StateTax ("+stateTax+") + Medicare ("+medicareTax+") + SocialSecurityTax ("+
				socialSecurityTax+") + SDI/SUI ("+sdisuiTax+")]";
	}
}
