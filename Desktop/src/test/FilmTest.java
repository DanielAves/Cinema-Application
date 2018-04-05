import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FilmTest {

  private Film testFilm;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {

      testFilm = new Film();
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testFilmIDSet() {

      Integer testID = 123;

      testFilm.setFilmID(testID);

      assertThat(testFilm.getFilmID(), is(testID));
    }

    @Test
    public void testFilmNameSet() {

      String testFilmName = "alpha";

      testFilm.setFilmName(testFilmName);

      assertThat(testFilm.getFilmName(), is(testFilmName));
    }

    @Test
    public void testFilmDescriptionSet() {

      String testFilmDesc = "Lorem Ipsum";

      testFilm.setFilmDescription(testFilmDesc);

      assertThat(testFilm.getFilmDescription(), is(testFilmDesc));
    }

    @Test
    public void testFilmRuntimeSet() {

      Integer testFilmRuntime = 100;

      testFilm.setFilmRuntime(testFilmRuntime);

      assertThat(testFilm.getFilmRuntime(), is(testFilmRuntime));
    }

    @Test
    public void testFilmDirectorSet() {

      String testFilmDirector = "spielberg";

      testFilm.setFilmDirector(testFilmDirector);

      assertThat(testFilm.getFilmDirector(), is(testFilmDirector));
    }

    @Test
    public void testFilmAgeRatingSet() {

      Integer testFilmAgeRating = 18;

      testFilm.setFilmAgeRating(testFilmAgeRating);

      assertThat(testFilm.getFilmAgeRating(), is(testFilmAgeRating));
    }

}
