
import java.util.List;

public class Harness {

  public static void main(String[] args) throws Exception {
      RestClient client = new RestClient("localhost", 5000);
      List<Film> s = client.getFilms();

      System.out.println(s);
  }
}
