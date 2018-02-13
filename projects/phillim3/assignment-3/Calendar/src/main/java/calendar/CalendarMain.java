package calendar;

/*
 * CalendarMain.java
 *  Adapted from  Paul Miles
 */
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class CalendarMain {
	public static void main(String[] args) throws DateOutOfRangeException {
		int thisMonth;

		/** the year the user is currently viewing **/
		int thisYear;

		/** todays date **/
		int thisDay;

		//get todays date
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		thisMonth = 2;
		thisYear = 2018;
		thisDay = 12;
		CalDay test = new CalDay();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
		CalDay validDay = new CalDay(cal);
		int startHour = 21;
		int startMinute = 30;
		int startDay = 12;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		int[] recurDaysArr = { 1, 2, 3, 4, 5, 6 };
		appt.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);
		validDay.addAppt(appt);
		startHour = 20;
		startMinute = 31;
		startDay = 12;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday parti.";
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		appt2.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt2);
		validDay.addAppt(appt2);
		startHour = 19;
		startMinute = 31;
		startDay = 12;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday part2.";
		//Construct a new Appointment object with the initial data	 
		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		appt3.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt3);
		validDay.addAppt(appt3);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 8);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		startHour = 18;
		startMinute = 31;
		startDay = 12;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday part2.";
		//Construct a new Appointment object with the initial data	 
		Appt appt4 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		appt4.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt4);
		validDay.addAppt(appt4);
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		System.out.println(calDays.toString());
	}
}

