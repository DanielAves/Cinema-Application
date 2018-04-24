/**
 * GenericWrapperTest.java
 */

package sample;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class GenericWrapperTest {

  private GenericWrapper testGenericWrapper;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {

      testGenericWrapper = new GenericWrapper();
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testObjectsSet() {

      List<String> testObjects = new ArrayList<String>();
      testObjects.add("obj1");
      testObjects.add("obj2");
      testObjects.add("obj3");

      testGenericWrapper.setObjects(testObjects);

      assertThat(testGenericWrapper.getObjects(), is(testObjects));

      assertThat(testGenericWrapper.getObjects().size(), is(3));

      assertThat(testGenericWrapper.getObjects().get(1), is("obj2"));
    }

    @Test
    public void testNumResultsSet() {

      int testNumResults = 99;

      testGenericWrapper.setNum_results(testNumResults);

      assertThat(testGenericWrapper.getNum_results(), is(testNumResults));
    }

    @Test
    public void testTotalPagesSet() {

      int testTotalPages = 100;

      testGenericWrapper.setTotal_pages(testTotalPages);

      assertThat(testGenericWrapper.getTotal_pages(), is(testTotalPages));
    }

    @Test
    public void testPageSet() {

      int testPage = 5;

      testGenericWrapper.setPage(testPage);

      assertThat(testGenericWrapper.getPage(), is(testPage));
    }

}
