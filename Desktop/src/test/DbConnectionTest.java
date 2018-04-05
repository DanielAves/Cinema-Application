import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DbConnectionTest {

  private DbConnection dbCon;
  private Film testFilm1, testFilm2, testFilm3;
  private Screening testScreening1, testScreening2, testScreening3;


    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {

      dbCon = new DbConnection();

      testFilm1 = new Film();
      testFilm1.setFilmID(1);

      testFilm2 = new Film();
      testFilm2.setFilmID(2);

      testFilm3 = new Film();
      testFilm3.setFilmID(3);

      testScreening1 = new Screening();
      testScreening1.setScreeningID(4);

      testScreening2 = new Screening();
      testScreening2.setScreeningID(5);

      testScreening3 = new Screening();
      testScreening3.setScreeningID(6);

    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {

      //clear the arraylist
      dbCon.filmList.clear();
      dbCon.screeningList.clear();

    }

    @Test
    public void testAddToFilmList() {

      dbCon.filmList.add(testFilm1);
      dbCon.filmList.add(testFilm2);
      dbCon.filmList.add(testFilm3);

      assertThat(dbCon.filmList.size(), is(3));
      assertThat(dbCon.filmList.get(0).getFilmID(), is(testFilm1.getFilmID()));
      assertThat(dbCon.filmList.get(2).getFilmID(), is(testFilm3.getFilmID()));

    }

    @Test
    public void testAddToScreeningList() {

      dbCon.screeningList.add(testScreening1);
      dbCon.screeningList.add(testScreening2);
      dbCon.screeningList.add(testScreening3);

      assertThat(dbCon.screeningList.size(), is(3));
      assertThat(dbCon.screeningList.get(0).getScreeningID(), is(testScreening1.getScreeningID()));
      assertThat(dbCon.screeningList.get(2).getScreeningID(), is(testScreening3.getScreeningID()));

    }

}
