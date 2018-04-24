/**
 * FilmTest.java
 */

package sample;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Test class for ...
 */
public class FilmTest {

  /** Film test object. */
  private Film testFilm;

  /**
   * Sets up the test fixture (called before every test case method).
   */
  @Before
  public void setUp() {
    testFilm = new Film();
  }

  /**
   * Tears down the test fixture (called after every test case method).
   */
  @After
  public void tearDown() {

  }

  @Test
  public void testFilmID() {
    int testID = 123;
    testFilm.setFilm_id(testID);
    assertThat(testFilm.getFilm_id(), is(testID));
  }

  @Test
  public void testFilmName() {
    String testFilmName = "alpha";
    testFilm.setFilm_name(testFilmName);
    assertThat(testFilm.getFilm_name(), is(testFilmName));
  }

  @Test
  public void testFilmDescription() {
    String testFilmDesc = "Lorem Ipsum";
    testFilm.setFilm_description(testFilmDesc);
    assertThat(testFilm.getFilm_description(), is(testFilmDesc));
  }

  @Test
  public void testFilmRuntime() {
    int testFilmRuntime = 100;
    testFilm.setFilm_runtime(testFilmRuntime);
    assertThat(testFilm.getFilm_runtime(), is(testFilmRuntime));
  }

  @Test
  public void testFilmDirector() {
    String testFilmDirector = "spielberg";
    testFilm.setFilm_director(testFilmDirector);
    assertThat(testFilm.getFilm_director(), is(testFilmDirector));
  }

  @Test
  public void testFilmAgeRating() {
    String testFilmAgeRating = "18";
    testFilm.setFilm_age_rating(testFilmAgeRating);
    assertThat(testFilm.getFilm_age_rating(), is(testFilmAgeRating));
  }

  @Test
  public void testToString() {
    String testFilmAgeRating = "18";
    testFilm.setFilm_age_rating(testFilmAgeRating);

    String testFilmDirector = "spielberg";
    testFilm.setFilm_director(testFilmDirector);

    int testFilmRuntime = 100;
    testFilm.setFilm_runtime(testFilmRuntime);

    int testID = 123;

    testFilm.setFilm_id(testID);
    String testFilmName = "alpha";

    testFilm.setFilm_name(testFilmName);
    String testFilmDesc = "Lorem Ipsum";

    testFilm.setFilm_description(testFilmDesc);

    String expectedOut = "Film [film_id=" + testID + ", film_name=" + testFilmName + ", film_description=" + testFilmDesc + ", film_runtime=" + testFilmRuntime + ", film_director=" + testFilmDirector + ", film_age_rating=" + testFilmAgeRating + "]";

    assertThat(testFilm.toString(), is(expectedOut));
  }
}
