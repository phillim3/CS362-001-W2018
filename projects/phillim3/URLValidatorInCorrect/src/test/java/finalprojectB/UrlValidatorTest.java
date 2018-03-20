
package finalprojectB;

import junit.framework.TestCase;
import java.util.concurrent.ThreadLocalRandom;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

public class UrlValidatorTest extends TestCase {

    public UrlValidatorTest(String testName) {
        super(testName);
    }

    public void testManualTest() {
        //You can use this function to implement your manual testing
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        //assertTrue(urlVal.isValid("http://www.google.com")); //works
        //assertTrue(urlVal.isValid("http://wwaw.google.com")); //doesn't work. should return false
        //assertFalse(urlVal.isValid("http://www.google.jom"));
        //assertTrue(urlVal.isValid("htatp://www.google.com")); // error
    }

    public void testYourFirstPartition() {
        //You can use this function to implement your First Partition testing	 
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        //assertTrue(urlVal.isValid("http://www.google.com")); //tests vaild url, pass

        //these test should return false, but often return true. i constructed these tests opposite of normal because it enabled me to see what was working correctly when most of the code was not working correctly.
        //schemes
        //assertTrue(urlVal.isValid("https://www.google.com")); //tests https part, returns false
        //assertTrue(urlVal.isValid("htatp://www.google.com")); //tests http part, error, found bug in regex-line 110
        //assertTrue(urlVal.isValid("jimmy://www.google.com")); //tests invalid scheme, returns true instead of false
        assertTrue(urlVal.isValid("file://host/path")); //error. found bug-line 315. does not recongize valid "file" scheme

        //authorities
        //assertTrue(urlVal.isValid("http:///www.google.com")); //tests :// part, returns true instead of false
        //assertFalse(urlVal.isValid("http///www.google.com")); //tests :// part, works correctly
        //assertTrue(urlVal.isValid("http:///www.!@#$%^&&*(.com")); //tests domain part, returns true instead of false

        //cheeseburgers
        //assertTrue(urlVal.isValid("cheeseburger")); //because

    }

    public void testYourSecondPartition() {
        //You can use this function to implement your Second Partition testing
        //i did all my parition testing in previous test	   

    }
    //You need to create more test cases for your Partitions if you need to 

   /* public void testIsValid() {
        //You can use this function for programming based testing
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String[] scheme = { "http", "https", "file", "jimmy" };
        String[] authority = { "www.google.com", "host/path" };
        //testing correct URLs
        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                assertTrue(urlVal.isValid(scheme[i] + "://" + authority[0]));
            } else if (i == 2) {
                assertTrue(urlVal.isValid(scheme[i] + "://" + authority[1]));
            } else {
                assertFalse(urlVal.isValid(scheme[i] + "://" + authority[0]));
            }
        }
        //testing incorrect schemes
        String[] scheme2 = { "hggp", "ht ps", "bile" };
        for (int i = 0; i < 3; i++) {
            if (i != 2) {
                assertFalse(urlVal.isValid(scheme2[i] + "://" + authority[0]));
            } else {
                assertFalse(urlVal.isValid(scheme2[i] + "://" + authority[1]));
            }
        }
        //testing incorrect authorities
        String[] authority2 = { "www.goo gle.com", "host/path pathypath" };
        for (int i = 0; i < 3; i++) {
            if (i != 2) {
                assertFalse(urlVal.isValid(scheme[i] + "://" + authority2[0]));
            } else {
                assertFalse(urlVal.isValid(scheme[i] + "://" + authority2[1]));
            }
        }
    }
*/
}
