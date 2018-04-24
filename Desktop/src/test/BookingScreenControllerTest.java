/**
 * BookingScreenControllerTest.java
 */

package sample;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

/**
 * Test class for ...
 */
public class BookingScreenControllerTest {

  /** BSC test object. */
  private BookingScreenController testBSC;

  /**
   * Sets up the test fixture. (Called before every test case method)
   */
  @Before
  public void setUp() {
    testBSC = new BookingScreenController();
  }

  /**
   * Tears down the test fixture. (Called after every test case method)
   */
  @After
  public void tearDown() {

  }

  /**
   *
   */
  @Test
  public void testDateSet() {

    LocalDate testDate = LocalDate.of(2018, Month.JANUARY, 1);

    testBSC.setDate(testDate);

    assertThat(testBSC.getDate(), is(testDate));
  }

  @Test
  public void testTimeSet() {

    String testTime = "12:30";

    testBSC.setTime(testTime);

    assertThat(testBSC.getTime(), is(testTime));
  }

  @Test
  public void testScreeningIDSet() {

    int testScreeningID = 123;

    testBSC.setScreeningID(testScreeningID);

    assertThat(testBSC.getScreeningID(), is(testScreeningID));
  }

}
