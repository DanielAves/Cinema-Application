package sample;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

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

      testScreening.setScreening_id(testScreeningID);

      assertThat(testScreening.getScreening_id(), is(testScreeningID));
    }

    @Test
    public void testScreeningTimeSet() {

      LocalTime testTime = LocalTime.of(12,30,45,50);

      testScreening.setScreening_time(testTime);

      assertThat(testScreening.getScreening_time(), is(testTime));
    }

    @Test
    public void testScreeningDateSet() {

      LocalDate testDate = LocalDate.of(2018, Month.JANUARY, 1);

      testScreening.setScreening_date(testDate);

      assertThat(testScreening.getScreening_date(), is(testDate));
    }

    @Test
    public void testFilmIDSet() {

      Integer testFilmID = 456;

      testScreening.setFilm_id(testFilmID);

      assertThat(testScreening.getFilm_id(), is(testFilmID));
    }

    @Test
    public void testScreenIDSet() {

      Integer testScreenID = 789;

      testScreening.setScreen_id(testScreenID);

      assertThat(testScreening.getScreen_id(), is(testScreenID));
    }

    @Test
    public void testToString() {

      Integer testScreeningID = 123;
      testScreening.setScreening_id(testScreeningID);

      LocalTime testTime = LocalTime.of(12,30,45,50);
      testScreening.setScreening_time(testTime);

      LocalDate testDate = LocalDate.of(2018, Month.JANUARY, 1);
      testScreening.setScreening_date(testDate);

      Integer testFilmID = 456;
      testScreening.setFilm_id(testFilmID);

      Integer testScreenID = 789;
      testScreening.setScreen_id(testScreenID);

      String expectedOut = "Screening [screening_id=" + testScreeningID + ", film_id=" + testFilmID + ", screening_time=" + testTime + ", screening_date=" + testDate + ", screen_id=" + testScreenID + "]";

      assertThat(testScreening.toString(), is(expectedOut));
    }



}
