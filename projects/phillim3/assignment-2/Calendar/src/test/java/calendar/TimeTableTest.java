package calendar;

/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

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
		thisMonth = rightnow.get(Calendar.MONTH) + 1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

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
		timeTable.getApptRange(listAppts, longTimeAgo, tomorrow);
		//timeTable.getApptRange(listAppts, tomorrow, longTimeAgo);
		timeTable.deleteAppt(listAppts, appt);
		//LinkedList<Appt> listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(2));
		assertEquals(null, listDeletedAppts);
		int[] uhg = { 2, 0, 1, 3 };
		timeTable.permute(listAppts, uhg);
		listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(1));
		listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(0));
		listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(3));
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
		for(int i=0;i<listAppts.size()-1;i++)
		{
			testMeh.addAppt(listAppts.get(i));
		}
	}

	@Test
	public void test02() throws Throwable {

	}
	//add more unit tests as you needed
}
