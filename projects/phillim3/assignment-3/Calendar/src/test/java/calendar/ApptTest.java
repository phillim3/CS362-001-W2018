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
		appt.setStartMonth(1);
		assertTrue(appt.getValid());
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
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertNotEquals(jack,appt.getRecurDays());
	}

	@Test
	public void test03() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 12;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(true,appt.getValid());
	}

	@Test
	public void test04() throws Throwable {
		int startHour = 100;
		int startMinute = 1;
		int startDay = 1;
		int startMonth = 1;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(false,appt.getValid());
		appt.setStartHour(-100);
		assertEquals(false,appt.getValid());
		appt.setStartHour(10);
		assertEquals(true,appt.getValid());
	}

	@Test
	public void test05() throws Throwable {
		int startHour = 1;
		int startMinute = 100;
		int startDay = 1;
		int startMonth = 1;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(false,appt.getValid());
		appt.setStartMinute(-100);
		assertEquals(false,appt.getValid());
	}

	@Test
	public void test06() throws Throwable {
		int startHour = 1;
		int startMinute = 1;
		int startDay = 100;
		int startMonth = 1;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(false,appt.getValid());
		appt.setStartDay(-100);
		assertEquals(false,appt.getValid());
	}


	@Test
	public void test07() throws Throwable {
		int startHour = 1;
		int startMinute = 1;
		int startDay = 1;
		int startMonth = 12;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(true,appt.getValid());
	}

	@Test
	public void test08() throws Throwable {
		int startHour = 1;
		int startMinute = 1;
		int startDay = 1;
		int startMonth = 1;
		int startYear = -2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(false,appt.getValid());
	}

	@Test
	public void test09() throws Throwable {
		int startHour = 1;
		int startMinute = 1;
		int startDay = 1;
		int startMonth = 1;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(true,appt.getValid());
		appt.setStartMonth(13);
		assertEquals(false, appt.getValid());
	}

	@Test
	public void test10() throws Throwable {
		int startHour = 1;
		int startMinute = 1;
		int startDay = 1;
		int startMonth = 1;
		int startYear = 2018;
		int[] jack = null;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		
		// assertions
		assertEquals(true,appt.getValid());
		appt.setStartYear(-100);
		assertEquals(false, appt.getValid());
		appt.setStartYear(0);
		assertEquals(true,appt.getValid());
	}

	@Test
	public void test11() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		int[] jack;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
	}

	@Test
	public void test12() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		int[] jack;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt2=new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertEquals(0,appt.compareTo(appt2));
	}

	@Test
	public void test13() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		startHour = 22;
		startMinute = 31;
		startDay = 16;
		startMonth = 02;
		startYear = 2019;
		Appt appt2=new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertNotEquals(0,appt.compareTo(appt2));
		assertEquals(-5,appt.compareTo(appt2));
	}
}