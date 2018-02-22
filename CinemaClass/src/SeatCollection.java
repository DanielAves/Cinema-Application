import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * A class to represent a collection of seats.
 *
 * <p>The intent is that this should form the basis for new classes
 * that represent screens.  
 *
 *
 * @author Mitchell Gladstone
 */
public abstract class SeatCollection {

  protected List<Seat> seats;

  /**
   * Creates an empty SeatCollection.
   */
  public SeatCollection() {
    seats = new LinkedList<>();
  }

  /**
   * @return Number of seats in this collection
   */
  public int size() {
    return seats.size();
  }

  /**
   * @return True if this collection is empty, false otherwise
   */
  public boolean isEmpty() {
    return seats.isEmpty();
  }

  /**
   * Indicates whether a particular seat is present in this collection.
   *
   * @param seat Seat we are looking for
   * @return True if the seat is present, false otherwise
   */
  public boolean contains(Seat seat) {
    return seats.contains(seat);
  }

  /**
   * Adds the given seat to this collection.
   *
   * @param seat seat to be added
   */
  public void add(Seat seat) {
    seats.add(seat);
  }

  /**
   * Discards all the seats from this collection.
   */
  public void discard() {
    seats.clear();
  }

  /**
   * Sorts this collection's seats into their natural order.
   */
  public void sort() {
    //Collections.sort(seats);
  }
}
