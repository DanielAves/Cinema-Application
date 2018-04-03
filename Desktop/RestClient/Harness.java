import java.util.List;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate ;

public class Harness {

  public static void main(String[] args) throws Exception {
      RestClient client = new RestClient("localhost", 5000);
      LocalDate d = LocalDate.of(1997 , 12, 20);
      Customer c = new Customer(5 , "Mitch" , "Gladstone" , d, "0007999977", "archery rd" , "Ls2 9au");
       List filmList = new ArrayList();

       filmList = client.getFilms();

       int filmAmount = filmList.size();

      for(int i =1; i<=filmAmount ;i++){ //client.getFilm(i) != null
        Film f = client.getFilm(i);
        String filmName = f.getFilm_name();
        System.out.println(filmName);
      }

      List screeningsList = new ArrayList();

      screeningsList = client.getScreenings();

      int screeningAmount = screeningsList.size();

      LocalDate inputDate = LocalDate.of(2018,04,03);
      System.out.println(inputDate);

      for(int i = 1; i<=screeningAmount; i++){
        Screening s = client.getScreening(i);
        LocalDate date = s.getScreening_date();
        if(date.equals(inputDate)){
          System.out.println("Entered");
          System.out.println(s.getFilm_id());
        }



      }

  }
}
