/**
 * PaymentScreenControllerTest.java
 */

package sample;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class PaymentScreenControllerTest {

  private PaymentScreenController testPSC;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {

      testPSC = new PaymentScreenController();

      //change(), setTotal(), setSeats(), setScreenID(),
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testSeatsSet() {

      List<String> testSeats = new ArrayList<String>();
      testSeats.add("seat1");
      testSeats.add("seat2");
      testSeats.add("seat3");

      testPSC.setSeats(testSeats);

      assertThat(testPSC.getSeats(), is(testSeats));

      assertThat(testPSC.getSeats().size(), is(3));

      assertThat(testPSC.getSeats().get(1), is("seat2"));
    }

    @Test
    public void testScreenIDSet() {

      int testScreenID = 123;

      testPSC.setScreenID(testScreenID);

      assertThat(testPSC.getScreenID(), is(testScreenID));
    }

/*
    @Test
    public void testChange() throws Exception{

      testPSC.grandTotal = -0.80;

      testPSC.change();

      assertThat(testPSC.grandTotal, is(0.80));


      testPSC.grandTotal = 5.50;

      testPSC.change();

      assertThat(testPSC.grandTotal, is(5.50));
    }
*/

}
