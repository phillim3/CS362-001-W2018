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

	}
	//add more unit tests as you needed	
}
