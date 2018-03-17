import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ScreeningTest {

  private Screening testScreening;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {

      testScreening = new Screening();

    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testScreeningIDSet() {

      Integer testScreeningID = 123;

      testScreening.setScreeningID(testScreeningID);

      assertThat(testScreening.getScreeningID(), is(testScreeningID));
    }

    @Test
    public void testScreeningTimeSet() {

      String testTime = "18:00";

      testScreening.setScreeningTime(testTime);

      assertThat(testScreening.getScreeningTime(), is(testTime));
    }

    @Test
    public void testScreeningDateSet() {

      String testDate = "01/01/2018";

      testScreening.setScreeningDate(testDate);

      assertThat(testScreening.getScreeningDate(), is(testDate));
    }

    @Test
    public void testFilmIDSet() {

      Integer testFilmID = 456;

      testScreening.setFilmID(testFilmID);

      assertThat(testScreening.getFilmID(), is(testFilmID));
    }

    @Test
    public void testScreenIDSet() {

      Integer testScreenID = 789;

      testScreening.setScreenID(testScreenID);

      assertThat(testScreening.getScreenID(), is(testScreenID));
    }



}
