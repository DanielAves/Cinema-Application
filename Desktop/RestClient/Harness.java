
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate ;

public class Harness {

  public static void main(String[] args) throws Exception {
      RestClient client = new RestClient("localhost", 5000);
      LocalDate d = LocalDate.of(1997 , 12, 20);
      Customer c = new Customer(5 , "Mitch" , "Gladstone" , d, "0007999977", "archery rd" , "Ls2 9au");
      Seat seat = client.getSeat(2);
      Screening s = client.getScreening(5);

      System.out.println(s);

      Ticket t = client.createTicket(c , s , seat );

      ObjectMapper mapper = new ObjectMapper();

      System.out.println(mapper.writeValueAsString(t));
  }
}
