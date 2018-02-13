import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * A class to represent a collection of screenings.
 *
 * <p>The intent is that this should form the basis for new classes
 * useful in the cinema booking system.  It isn't meant to be instantiated itself and
 * is therefore declared as abstract.</p>
 *
 * 
 *
 * @author Mitchell Gladstone
 */
public abstract class ScreeningCollection {

  protected List<Screening> screenings;

  /**
   * Creates an empty ScreeningCollection.
   */
  public ScreeningCollection() {
    screenings = new LinkedList<>();
  }

  /**
   * @return Number of screenings in this collection
   */
  public int size() {
    return screenings.size();
  }

  /**
   * @return True if this collection is empty, false otherwise
   */
  public boolean isEmpty() {
    return screenings.isEmpty();
  }

  /**
   * Indicates whether a particular screening is present in this collection.
   *
   * @param screening we are looking for
   * @return True if the screening is present, false otherwise
   */
  public boolean contains(Screening screening) {
    return screenings.contains(screening);
  }

  /**
   * Adds the given screening to this collection.
   *
   * @param screening Screening to be added
   */
  public void add(Screening screening) {
    screenings.add(screening);
  }

  /**
   * Discards all the screening from this collection.
   */
  public void discard() {
    screening.clear();
  }

  /**
   * Sorts this collection's screenings into their natural order.
   */
  public void sort() {
    Collections.sort(screenings);
  }
}
