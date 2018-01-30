package calendar;

/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		int[] jack = { 1, 1 };
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		appt.setRecurrence(jack, 1, 1, 1);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(1, appt.getRecurNumber());
		assertEquals(1, appt.getRecurBy());
		assertEquals(jack, appt.getRecurDays());
		assertEquals(1, appt.getRecurBy());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
		//more tests
		appt.setStartHour(-1);
		assertFalse(appt.getValid());
		appt.setStartHour(0);
		appt.setStartMinute(-1);
		assertFalse(appt.getValid());
		appt.setStartMinute(0);
		appt.setStartDay(0);
		assertFalse(appt.getValid());
		appt.setStartDay(1);
		appt.setStartMonth(0);
		assertFalse(appt.getValid());
		appt.setStartYear(1);
		assertEquals(1, appt.getStartYear());
		appt.setTitle("Bob");
		assertEquals("Bob", appt.getTitle());
		String bob = null;
		appt.setTitle(bob);
		assertEquals("", appt.getTitle());
		appt.setStartHour(24);
		assertFalse(appt.getValid());
		appt.setStartMinute(60);
		assertFalse(appt.getValid());
		appt.setStartDay(45);
		assertFalse(appt.getValid());
		appt.setDescription(bob);
		assertEquals("", appt.getDescription());
		jack = null;
		appt.setRecurrence(jack, 1, 1, 1);
		assertTrue(appt.isRecurring());
		appt.setRecurrence(jack, 0, 0, 0);
		assertFalse(appt.isRecurring());
		appt.setRecurrence(jack, 1, 1, 1);
		assertEquals(1, appt.getRecurIncrement());
		assertEquals(null, appt.toString());
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		appt2.toString();
	}

	@Test
	public void test02() throws Throwable {

	}
	//add more unit tests as you needed

}
