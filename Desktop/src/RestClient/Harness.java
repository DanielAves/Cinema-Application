
import java.util.List;

public class Harness {

  public static void main(String[] args) throws Exception {
      RestClient client = new RestClient("localhost", 5000);
      List<Seat> s = client.getSeats();

      System.out.println(s);
  }
}
