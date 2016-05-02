package edu.itu.pcg.util;

import java.util.Calendar;

/**
 * @author Kavya and Varsha
 *
 */
public class CalendarUtil {

	private CalendarUtil() {
		
	}
	
	public static boolean isLeapYear() {
		Calendar cal = Calendar.getInstance();
		int maxDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		return maxDays > 365;
	}

	public static int getNumberOfWeeksInYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		return cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
	}
	
	public static int getWorkingDaysInYear() {
		Calendar start = Calendar.getInstance();
		start.set(Calendar.YEAR, start.get(Calendar.YEAR));
		start.set(Calendar.MONTH, Calendar.JANUARY);
		start.set(Calendar.DAY_OF_MONTH, 1);

		while (start.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY 
				|| start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			start.add(Calendar.DAY_OF_WEEK, 1);
		}
		//System.out.println(start.getTime());
		int startWeek = start.get(Calendar.WEEK_OF_YEAR);
		//System.out.println("Adjusted start week of year - "+startWeek);
		
		Calendar end = Calendar.getInstance();
		end.set(Calendar.YEAR, start.get(Calendar.YEAR));
		end.set(Calendar.MONTH, Calendar.DECEMBER);
		end.set(Calendar.DAY_OF_MONTH, 31);

		while (end.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY 
				|| end.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			end.add(Calendar.DAY_OF_WEEK, -1);
		}
		//System.out.println(end.getTime());
		int endWeek = end.get(Calendar.WEEK_OF_YEAR);
		//System.out.println("Adjusted end week of year - "+endWeek);
		
		int adjDaysOfYear = end.get(Calendar.DAY_OF_YEAR) - start.get(Calendar.DAY_OF_YEAR) + 1;
		//System.out.println("Adjusted days of year - "+adjDaysOfYear);
		int adjWeekendsOfYear = endWeek - startWeek;
		//System.out.println("Adjusted weekends of year - "+adjWeekendsOfYear);
		int adjWeekdays = adjDaysOfYear - adjWeekendsOfYear*2;
		//System.out.println("Weekdays of year - "+adjWeekdays);
		return adjWeekdays;
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(isLeapYear());
		System.out.println(getNumberOfWeeksInYear());
		System.out.println(getWorkingDaysInYear());
	}
	*/
}
