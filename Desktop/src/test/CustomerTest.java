/**
 * CustomerTest.java
 */

package sample;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.time.LocalDate;
import java.time.Month;

public class CustomerTest {

  private Customer testCustomer;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {

      testCustomer = new Customer();
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testCustomerIDSet() {

      int testID = 123;

      testCustomer.setCustomer_id(testID);

      assertThat(testCustomer.getCustomer_id(), is(testID));
    }

    @Test
    public void testCustomerFNameSet() {

      String testFName = "Steve";

      testCustomer.setCustomer_f_name(testFName);

      assertThat(testCustomer.getCustomer_f_name(), is(testFName));
    }

    @Test
    public void testCustomerSNameSet() {

      String testSName = "Smith";

      testCustomer.setCustomer_s_name(testSName);

      assertThat(testCustomer.getCustomer_s_name(), is(testSName));
    }

    @Test
    public void testCustomerDobSet() {

      LocalDate testDob = LocalDate.of(2018, Month.JANUARY, 1);

      testCustomer.setCustomer_dob(testDob);

      assertThat(testCustomer.getCustomer_dob(), is(testDob));
    }

    @Test
    public void testCustomerMobileSet() {

      String testMobile = "07123456789";

      testCustomer.setCustomer_mobile(testMobile);

      assertThat(testCustomer.getCustomer_mobile(), is(testMobile));
    }

    @Test
    public void testCustomerAddressSet() {

      String testAddress = "1 Downing Street";

      testCustomer.setCustomer_address(testAddress);

      assertThat(testCustomer.getCustomer_address(), is(testAddress));
    }

    @Test
    public void testCustomerPostcodeSet() {

      String testPostcode = "LS11AA";

      testCustomer.setCustomer_postcode(testPostcode);

      assertThat(testCustomer.getCustomer_postcode(), is(testPostcode));
    }

    @Test
    public void testToString() {

      String testPostcode = "LS11AA";
      testCustomer.setCustomer_postcode(testPostcode);

      String testAddress = "1 Downing Street";
      testCustomer.setCustomer_address(testAddress);

      String testMobile = "07123456789";
      testCustomer.setCustomer_mobile(testMobile);

      LocalDate testDob = LocalDate.of(2018, Month.JANUARY, 1);
      testCustomer.setCustomer_dob(testDob);

      int testID = 123;
      testCustomer.setCustomer_id(testID);

      String testFName = "Steve";
      testCustomer.setCustomer_f_name(testFName);

      String testSName = "Smith";
      testCustomer.setCustomer_s_name(testSName);

      String expectedOut = "Customer [customer_id=" + testID + ", customer_f_name=" + testFName + ", customer_s_name=" + testSName + ", customer_dob=" + testDob + ", customer_mobile=" + testMobile + ", customer_address=" + testAddress + ", customer_postcode=" + testPostcode + "]";

      assertThat(testCustomer.toString(), is(expectedOut));
    }

}
