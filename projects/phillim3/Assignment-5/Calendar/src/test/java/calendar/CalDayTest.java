package calendar;

/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01() throws Throwable {
		CalDay test = new CalDay();
		assertFalse(test.isValid());
		GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
		CalDay validDay = new CalDay(cal);
		assertTrue(validDay.isValid());
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		validDay.addAppt(appt);
		validDay.iterator();
		test.iterator();
		assertEquals(1, validDay.getSizeAppts());
		assertEquals(1, validDay.getDay());
		assertEquals(1, validDay.getMonth());
		assertEquals(1, validDay.getYear());
		validDay.toString();
		test.toString();
		Appt appt2 = new Appt(-1, startMinute, startDay, startMonth, startYear, title, description);
		test.addAppt(appt2);
	}

	@Test
	public void test02() throws Throwable {
		CalDay test = new CalDay();
		assertFalse(test.isValid());
		GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
		CalDay validDay = new CalDay(cal);
		assertTrue(validDay.isValid());
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
		validDay.addAppt(appt);
		assertNotEquals(null,validDay.iterator());
	}

	@Test
	public void test03() throws Throwable {
		CalDay test = new CalDay();
		assertFalse(test.isValid());
		GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
		CalDay validDay = new CalDay(cal);
		assertTrue(validDay.isValid());
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
		validDay.addAppt(appt);
		assertNotEquals(null,validDay.iterator());
		assertEquals("\t --- 1/1/1 --- \n --- -------- Appointments ------------ --- \n\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n",validDay.toString());
	}

	@Test
	public void test04() throws Throwable {
		CalDay test = new CalDay();
		assertFalse(test.isValid());
		GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
		CalDay validDay = new CalDay(cal);
		assertTrue(validDay.isValid());
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
		validDay.addAppt(appt);
		assertNotEquals(null,validDay.iterator());
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
		validDay.addAppt(appt2);
		assertEquals("\t --- 1/1/1 --- \n --- -------- Appointments ------------ --- \n\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \t1/15/2018 at 9:31pm ,Birthday Party, This is my birthday parti.\n \n",validDay.toString());
	}

	@Test
	public void test05() throws Throwable {
		CalDay test = new CalDay();
		assertFalse(test.isValid());
		GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
		CalDay validDay = new CalDay(cal);
		assertTrue(validDay.isValid());
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
		validDay.addAppt(appt);
		assertNotEquals(null,validDay.iterator());
		startHour = 20;
		startMinute = 31;
		startDay = 15;
		startMonth = 01;
		startYear = 2018;
		title = "Birthday Party";
		description = "This is my birthday parti.";
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		appt2.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		validDay.addAppt(appt2);
		assertEquals(2,validDay.getSizeAppts());
	}
}