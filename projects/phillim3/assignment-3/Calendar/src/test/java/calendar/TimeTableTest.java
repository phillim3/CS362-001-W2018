package calendar;

/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test
	public void test01() throws Throwable {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		/** the month the user is currently viewing **/
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

		int startHour = 15;
		int startMinute = 30;
		int startDay = thisDay + 1;
		int startMonth = thisMonth;
		int startYear = thisYear;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		listAppts.add(appt);

		// create another appointment
		startHour = 14;
		startMinute = 30;
		startDay = thisDay;
		startMonth = thisMonth;
		startYear = thisYear;
		title = "Class";
		description = "Rescheduled class.";
		//Construct a new Appointment object with the initial data	 
		appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		listAppts.add(appt);
		// create another appointment
		startHour = 13;
		startMinute = 30;
		startDay = thisDay;
		startMonth = thisMonth;
		startYear = thisYear;
		title = "Meeting Today";
		description = "Meeting with the students.";
		//Construct a new Appointment object with the initial data	 
		appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		listAppts.add(appt);
		// create another appointment
		startHour = 16;
		startMinute = 30;
		startDay = thisDay + 1;
		startMonth = thisMonth + 1;
		startYear = thisYear;
		title = "Visit";
		description = "Visiting my parents!";
		//Construct a new Appointment object with the initial data	 
		appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		int[] recurDaysArr = { 1, 2, 3, 4, 5, 6 };
		appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);
		//get a list of appointments for one day, which is today
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		String todatDate = today.get(Calendar.MONTH) + "/" + today.get(Calendar.DAY_OF_MONTH) + "/"
				+ today.get(Calendar.YEAR);
		String tomorrowDate = tomorrow.get(Calendar.MONTH) + "/" + tomorrow.get(Calendar.DAY_OF_MONTH) + "/"
				+ tomorrow.get(Calendar.YEAR);
		TimeTable timeTable = new TimeTable();
		//Create a linked list of calendar days to return
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		GregorianCalendar longTimeAgo = new GregorianCalendar(1, 1, 1);
		calDays = timeTable.getApptRange(listAppts, longTimeAgo, tomorrow);
		assertNotEquals(null, calDays);
		//timeTable.getApptRange(listAppts, tomorrow, longTimeAgo);//threw exception
		timeTable.deleteAppt(listAppts, appt);
		LinkedList<Appt> listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(2));
		assertNotEquals(null, listDeletedAppts);
		int[] uhg = { 2, 0, 1, 3 };
		//timeTable.permute(listAppts, uhg);
		listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(1));
		//listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(0));
		//listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(3));
		LinkedList<Appt> listAppts2 = null;
		Appt appt2 = null;
		timeTable.deleteAppt(listAppts2, appt2);
		timeTable.deleteAppt(listAppts2, appt);
		timeTable.deleteAppt(listAppts, appt2);
		listAppts2 = new LinkedList<Appt>();
		appt2 = new Appt(startHour, startMinute, 1, 1, 2018, title, description);
		appt2.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		listAppts2.add(appt2);
		GregorianCalendar meh = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar meh2 = new GregorianCalendar(2019, 1, 1);
		timeTable.getApptRange(listAppts2, meh, meh2);
		CalDay testMeh = new CalDay(meh);
		testMeh.addAppt(appt2);
		for (int i = 0; i < listAppts.size() - 1; i++) {
			testMeh.addAppt(listAppts.get(i));
		}
	}

	@Test
	public void test02() throws Throwable {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		/** the month the user is currently viewing **/
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

		int startHour = 15;
		int startMinute = 30;
		int startDay = thisDay + 1;
		int startMonth = thisMonth;
		int startYear = thisYear;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		listAppts.add(appt);

		CalDay meh = new CalDay();
		assertEquals(null, meh.getAppts());
	}

	@Test
	public void test03() throws Throwable {

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
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		int[] recurDaysArr = { 1, 2, 3, 4, 5, 6 };
		appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);
		validDay.addAppt(appt);
		startHour = 21;
		startMinute = 31;
		startDay = 15;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday parti.";
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		appt2.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt2);
		validDay.addAppt(appt2);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(1, calDays.size());
	}

	@Test
	public void test04() throws Throwable {

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
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		int[] recurDaysArr = { 1, 2, 3, 4, 5, 6 };
		appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);
		validDay.addAppt(appt);
		startHour = 21;
		startMinute = 31;
		startDay = 15;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday parti.";
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		appt2.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt2);
		validDay.addAppt(appt2);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(1, calDays.size());
	}

	@Test
	public void test05() throws Throwable {
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
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(
				"[\t --- 2/12/2018 --- \n --- -------- Appointments ------------ --- \n\t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n]",
				calDays.toString());
	}

	@Test
	public void test06() throws Throwable {
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
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(
				"[\t --- 2/12/2018 --- \n --- -------- Appointments ------------ --- \n\t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n]",
				calDays.toString());
		today.add(Calendar.DAY_OF_MONTH, 1);
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals("[\t --- 2/13/2018 --- \n --- -------- Appointments ------------ --- \n\n]", calDays.toString());
	}

	@Test
	public void test07() throws Throwable {
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
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(
				"[\t --- 2/12/2018 --- \n --- -------- Appointments ------------ --- \n\t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n]",
				calDays.toString());
		today.add(Calendar.DAY_OF_MONTH, 1);
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals("[\t --- 2/13/2018 --- \n --- -------- Appointments ------------ --- \n\n]", calDays.toString());
	}

	@Test
	public void test08() throws Throwable {
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
		assertEquals(
				"[\t --- 2/12/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n"
						+ " \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" + " \n"
						+ ", \t --- 2/13/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/14/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/15/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/16/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/17/2018 --- \n" + " --- -------- Appointments ------------ --- \n" + "\n"
						+ ", \t --- 2/18/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/19/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n"
						+ " \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" + " \n" + "]",
				calDays.toString());
	}

	@Test
	public void test09() throws Throwable {
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
		assertEquals(
				"[\t --- 2/12/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n"
						+ " \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" + " \n"
						+ ", \t --- 2/13/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/14/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/15/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/16/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/17/2018 --- \n" + " --- -------- Appointments ------------ --- \n" + "\n"
						+ ", \t --- 2/18/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/19/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n"
						+ " \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" + " \n" + "]",
				calDays.toString());
		startHour = 17;
		startMinute = 31;
		startDay = 12;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday part2.";
		//Construct a new Appointment object with the initial data	 
		Appt appt5 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		int[] one = { 1, 2, 3, 4, 5, 6, 7 };
		appt5.setRecurrence(one, Appt.RECUR_BY_WEEKLY, 1, 2);
		listAppts.add(appt5);
		validDay.addAppt(appt5);
		tomorrow.add(Calendar.DAY_OF_MONTH, 8);
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(16, calDays.size());
		assertEquals(4, calDays.get(0).getSizeAppts());
		assertEquals(1, calDays.get(1).getSizeAppts());
		assertEquals(1, calDays.get(2).getSizeAppts());
		assertEquals(1, calDays.get(3).getSizeAppts());
		assertEquals(1, calDays.get(4).getSizeAppts());
		assertEquals(0, calDays.get(5).getSizeAppts());
		assertEquals(1, calDays.get(6).getSizeAppts());
		assertEquals(4, calDays.get(7).getSizeAppts());
		assertEquals(1, calDays.get(8).getSizeAppts());
		assertEquals(1, calDays.get(9).getSizeAppts());
		assertEquals(1, calDays.get(10).getSizeAppts());
		assertEquals(1, calDays.get(11).getSizeAppts());
		assertEquals(0, calDays.get(12).getSizeAppts());
		assertEquals(1, calDays.get(13).getSizeAppts());
		assertEquals(4, calDays.get(14).getSizeAppts());
		assertEquals(1, calDays.get(15).getSizeAppts());
	}

	@Test
	public void test10() throws Throwable {
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
		assertEquals(
				"[\t --- 2/12/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n"
						+ " \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" + " \n"
						+ ", \t --- 2/13/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/14/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/15/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/16/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/17/2018 --- \n" + " --- -------- Appointments ------------ --- \n" + "\n"
						+ ", \t --- 2/18/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n" + " \n"
						+ ", \t --- 2/19/2018 --- \n" + " --- -------- Appointments ------------ --- \n"
						+ "\t1/12/2018 at 6:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 7:31pm ,Birthday Party, This is my birthday part2.\n"
						+ " \t1/12/2018 at 8:31pm ,Birthday Party, This is my birthday parti.\n"
						+ " \t1/12/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" + " \n" + "]",
				calDays.toString());
		startHour = 17;
		startMinute = 31;
		startDay = 12;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday part2.";
		//Construct a new Appointment object with the initial data	 
		Appt appt5 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		int[] one = { 1, 2, 3, 4, 5, 6, 7 };
		appt5.setRecurrence(one, Appt.RECUR_BY_WEEKLY, 1, 2);
		listAppts.add(appt5);
		validDay.addAppt(appt5);
		tomorrow.add(Calendar.DAY_OF_MONTH, 8);
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(16, calDays.size());
		assertEquals(4, calDays.get(0).getSizeAppts());
		assertEquals(1, calDays.get(1).getSizeAppts());
		assertEquals(1, calDays.get(2).getSizeAppts());
		assertEquals(1, calDays.get(3).getSizeAppts());
		assertEquals(1, calDays.get(4).getSizeAppts());
		assertEquals(0, calDays.get(5).getSizeAppts());
		assertEquals(1, calDays.get(6).getSizeAppts());
		assertEquals(4, calDays.get(7).getSizeAppts());
		assertEquals(1, calDays.get(8).getSizeAppts());
		assertEquals(1, calDays.get(9).getSizeAppts());
		assertEquals(1, calDays.get(10).getSizeAppts());
		assertEquals(1, calDays.get(11).getSizeAppts());
		assertEquals(0, calDays.get(12).getSizeAppts());
		assertEquals(1, calDays.get(13).getSizeAppts());
		assertEquals(4, calDays.get(14).getSizeAppts());
		assertEquals(1, calDays.get(15).getSizeAppts());
		int[] two = { 2, 3, 4, 0, 1 };
		assertEquals(5, listAppts.size());
		assertNotEquals(4, listAppts.size());
		LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
		listAppts2 = timeTable.permute(listAppts, two);
		for (int i = 1; i < listAppts.size(); i++) {
			assertNotEquals(listAppts2.get(i), listAppts.get(i));
		}
	}

	@Test
	public void test11() throws Throwable {
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
		int startDay = 31;
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
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertEquals(1, calDays.size());
	}

	@Test
	public void test12() throws Throwable {
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
		int startDay = 31;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		int[] recurDaysArr = { 1, 2, 3, 4, 5, 6 };
		appt.setRecurrence(null, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);
		validDay.addAppt(appt);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 90);
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		System.out.println(calDays.size());
		assertEquals(90, calDays.size());
	}
}
