package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Random Test Generator  for Appt class.
 */

public class TimeTableRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS = 100;

    /**
     * Return a randomly selected method to be tests !.
     */
    public static String RandomSelectMethod(Random random) {
        String[] methodArray = new String[] { "setTitle", "setRecurrence" };// The list of the of methods to be tested in the Appt class

        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n]; // return the method name 
    }

    /**
     * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
     */
    public static int RandomSelectRecur(Random random) {
        int[] RecurArray = new int[] { Appt.RECUR_BY_WEEKLY, Appt.RECUR_BY_MONTHLY, Appt.RECUR_BY_YEARLY };// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n]; // return the value of the  appointments to recur 
    }

    /**
     * Return a randomly selected appointments to recur forever or Never recur  !.
     */
    public static int RandomSelectRecurForEverNever(Random random) {
        int[] RecurArray = new int[] { Appt.RECUR_NUMBER_FOREVER, Appt.RECUR_NUMBER_NEVER };// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n]; // return appointments to recur forever or Never recur 
    }

    @Test
    public void radnomtest() throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start testing...");

        try {
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed = System.currentTimeMillis(); //10
                //			System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);
                float probability = 0.5f;
                int startHour = ValuesGenerator.getRandomIntBetween(random, -1, 24);
                int startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 60);
                int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 32);
                int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear = ValuesGenerator.getRandomIntBetween(random, -1, 2019);
                int[] recurDays = { ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random),
                        ValuesGenerator.RandInt(random) };
                String title = "Birthday Party";
                String description = "This is my birthday party.";
                //Construct a new Appointment object with the initial data	 
                Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
                appt.getValid();
                if (ValuesGenerator.getBoolean(probability, random)) {
                    appt.setRecurrence(null, ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random),
                            ValuesGenerator.RandInt(random));
                } else {
                    appt.setRecurrence(recurDays, ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random),
                            ValuesGenerator.RandInt(random));
                }
                CalDay mrTest = new CalDay();
                if (ValuesGenerator.getBoolean(probability, random)) {
                    GregorianCalendar cal = new GregorianCalendar(ValuesGenerator.getRandomIntBetween(random, -1, 2019),
                            ValuesGenerator.getRandomIntBetween(random, 0, 13),
                            ValuesGenerator.getRandomIntBetween(random, 0, 32));
                    mrTest = new CalDay(cal);
                }

                LinkedList<Appt> listAppts = null;
                TimeTable tt = new TimeTable();
                Appt deleteMe = null;
                if (ValuesGenerator.getBoolean(probability, random)) {
                    if (ValuesGenerator.getBoolean(probability, random)) {
                        tt.deleteAppt(listAppts, deleteMe);
                    } else {
                        if (ValuesGenerator.getBoolean(probability, random)) {
                            listAppts = new LinkedList<Appt>();
                            tt.deleteAppt(listAppts, deleteMe);
                        } else {
                            if (ValuesGenerator.getBoolean(probability, random)) {
                                deleteMe = appt;
                                tt.deleteAppt(listAppts, deleteMe);
                            }
                        }
                    }
                } else {
                    listAppts = new LinkedList<Appt>();
                    boolean heyYa = false;
                    int meh = ValuesGenerator.getRandomIntBetween(random, 10, 100);
                    for (int i = 0; i < meh; i++) {
                        startHour = ValuesGenerator.getRandomIntBetween(random, -1, 24);
                        startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 60);
                        startHour = ValuesGenerator.getRandomIntBetween(random, -1, 24);
                        startDay = ValuesGenerator.getRandomIntBetween(random, 0, 32);
                        startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                        startYear = ValuesGenerator.getRandomIntBetween(random, -1, 2019);
                        //Construct a new Appointment object with the initial data	 
                        appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
                        if (ValuesGenerator.getBoolean(probability, random)) {
                            appt.setRecurrence(null, ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random),
                                    ValuesGenerator.RandInt(random));
                        } else {
                            appt.setRecurrence(recurDays, ValuesGenerator.RandInt(random),
                                    ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random));
                        }
                        listAppts.add(appt);
                        if (heyYa == false && ValuesGenerator.getBoolean(0.02f, random)) {
                            heyYa = true;
                            deleteMe = appt;
                        }
                    }
                    tt.deleteAppt(listAppts, deleteMe);
                    int year = ValuesGenerator.getRandomIntBetween(random, 1, 2019);
                    int month = ValuesGenerator.getRandomIntBetween(random, 0, 10);
                    int day = ValuesGenerator.getRandomIntBetween(random, 0, 30);
                    GregorianCalendar cal = new GregorianCalendar(year, month, day);
                    GregorianCalendar cal2 = new GregorianCalendar(year + 1, month + 1, day + 1);
                    tt.getApptRange(listAppts, cal, cal2);
                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

            }
        } catch (

        NullPointerException e) {

        }

        System.out.println("Done testing...");
    }

}