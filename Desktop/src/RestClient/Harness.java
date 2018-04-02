
import java.util.List;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate ;

public class Harness {

  public static void main(String[] args) throws Exception {
      RestClient client = new RestClient("localhost", 5000);
      LocalDate d = LocalDate.of(1997 , 12, 20);
      Customer c = new Customer(5 , "Mitch" , "Gladstone" , d, "0007999977", "archery rd" , "Ls2 9au");
      // Seat seat = client.getSeat(2);
      // Screening s = client.getScreening(5);
      // Screening s = client.getScreening(5);
       // Film f = client.getFilm(1);
       // String filmName = f.getFilm_name();
       // System.out.println(filmName);




      for(int i =1; i<=10 ;i++){ //client.getFilm(i) != null
        Film f = client.getFilm(i);
        String filmName = f.getFilm_name();
        System.out.println(filmName);
      }




      //String filmName = f.getFilm_name();
      // for(Field field : client.getFilm().getDeclaredFields()) {
      //   field.setAccessible(true);
      //   String name = field.getFilm_name();
      //   System.out.println(name);
      // }


      // for(f.getFilm_name){
      //
      // }



      // Ticket t = client.createTicket(c , s , seat );
      //
      // ObjectMapper mapper = new ObjectMapper();
      //
      // System.out.println(mapper.writeValueAsString(t));
  }
}
