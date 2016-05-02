package edu.itu.pcg.util;

/**
 * @author Kavya and Varsha
 *
 */
public class PayCheckGrossCalculatorUtil {

	private static final String Daily = "Daily";
	private static final String Weekly = "Weekly";
	private static final String BiWeekly = "Bi-Weekly";
	private static final String SemiMonthly = "Semi-Monthly";
	private static final String Monthly = "Monthly";
	private static final String Quarterly = "Quarterly";
	private static final String SemiAnnually = "Semi-Annually";
	private static final String Annually = "Annually";
	
	private PayCheckGrossCalculatorUtil() {
		
	}
	
	public static double calculatePaycheckGrossPay(double annualGrossPay, String payFrequency) {
		double paycheckGrossPay = 0d;
		int workingDaysInYear = CalendarUtil.getWorkingDaysInYear();
		int weeksInYear = CalendarUtil.getNumberOfWeeksInYear();
		
		switch(payFrequency) {
		
		case Daily:
			paycheckGrossPay = annualGrossPay / workingDaysInYear;
			break;
		case Weekly:
			paycheckGrossPay = annualGrossPay / weeksInYear;
			break;
		case BiWeekly:
		case SemiMonthly:
			paycheckGrossPay = annualGrossPay / weeksInYear;
			paycheckGrossPay = paycheckGrossPay * 2;
			break;
		case Monthly:
			paycheckGrossPay = annualGrossPay / 12;
			break;
		case Quarterly:
			paycheckGrossPay = annualGrossPay / 12;
			paycheckGrossPay = paycheckGrossPay * 3;
			break;
		case SemiAnnually:
			paycheckGrossPay = annualGrossPay / 6;
			break;
		case Annually:
			paycheckGrossPay = annualGrossPay;
			break;
		default:
			throw new IllegalArgumentException("Invalid pay frequency type - "+payFrequency);
		}
		
		return paycheckGrossPay;
	}
	
}
