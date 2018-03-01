import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient implements CinemaApi {

      private HttpClient client;
      private ObjectMapper mapper;

      public RestClient(String host, int port){
        super();
        this.client = new HttpClient(host, port);
        this.mapper = new ObjectMapper();
      }
      /**
      * Customers methods
      */
      public Customer createCustomer(){
        return null;
      }

      public boolean deleteCustomer(Customer customer){
        return false;
      }

      public boolean updateCustomer(Customer customer){
        return false;
      }

      public List<Customer> getCustomers(){
        return null;
      }


      /**
      * Film methods
      */
      public Film createFilm(){
        return null;
      }

      public boolean deleteFilm(Film film){
        return false;
      }

      public boolean updateFilm(Film film){
        return false;
      }

      public List<Film> getFilms(){
        return null;
      }

      /**
      * Screen methods
      */
      public Screen createScreen(){
        return null;
      }

      public boolean deleteScreen(Screen screen){
        return false;
      }

      public boolean updateScreen(Screen screen){
        return false;
      }

      public Screen getScreen(int id) throws Exception {
        String json = this.client.get("screen/"+id);
        Screen screen = mapper.readValue(json, Screen.class);
        return screen;
      }

      public List<Screen> getScreens(){
        return null;
      }

      /**
      * Screenings methods
      */
      public Screening createScreening(){
        return null;
      }

      public boolean deleteScreening(Screening screening){
        return false;
      }

      public boolean updateScreening(Screening screening){
        return false;
      }

      public List<Screening> getScreening(){
        return null;
      }

      /**
      * Seat methods
      */
      public Seat createSeat(){
        return null;
      }

      public boolean deleteSeat(Seat seat){
        return false;
      }

      public boolean updateSeat(Seat seat){
        return false;
      }

      public Seat getSeat(int id) throws Exception{
        String json = this.client.get("seat/"+id);
        Seat seat = mapper.readValue(json, Seat.class);
        return seat;
      }

      public List<Seat> getSeats(){
        return null;
      }

      /**
      * Ticket methods
      */
      public Ticket createTicket(){
        return null;
      }

      public boolean deleteTicket(Ticket ticket){
        return false;
      }

      public boolean updateTicket(Ticket ticket){
        return false;
      }

      public List<Ticket> getTickets(){
        return null;
      }

}
