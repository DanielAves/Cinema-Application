import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;

public class RestClient implements CinemaApi {

      private HttpClient client;
      private ObjectMapper mapper;

      public RestClient(String host, int port){
        super();
        this.client = new HttpClient(host, port);
        this.mapper = new ObjectMapper();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        mapper.setDateFormat(df);
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

      public Film getFilm(int id) throws Exception {
        String json = this.client.get("film/"+id);
        Film film = mapper.readValue(json, Film.class);
        return film;


      }


      public List<Film> getFilms() throws Exception{
        String json = this.client.get("film");
        GenericWrapper<Film> myObjects = mapper.readValue(json, GenericWrapper.class);
        return myObjects.getObjects();
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

      public List<Screen> getScreens() throws Exception{
        String json = this.client.get("screen");
        GenericWrapper<Screen> myObjects = mapper.readValue(json, GenericWrapper.class);
        return myObjects.getObjects();
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

      public Screening getScreening(int id) throws Exception {
        String json = this.client.get("screening/"+id);
        Screening screening = mapper.readValue(json, Screening.class);
        return screening;
      }

      public List<Screening> getScreenings() throws Exception {
        String json = this.client.get("screening");
        GenericWrapper<Screening> myObjects = mapper.readValue(json, GenericWrapper.class);
        return myObjects.getObjects();
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

      public List<Seat> getSeats() throws Exception{
        String json = this.client.get("seat");
        GenericWrapper<Seat> myObjects = mapper.readValue(json, GenericWrapper.class);
        return myObjects.getObjects();
      }

      /**
      * Ticket methods
      */
      public Ticket createTicket(Customer customer, Screening screening, Seat seat) throws Exception{
        Ticket t = new Ticket(customer.getCustomer_id(), screening.getScreening_id(),seat.getSeat_id());
        String json = mapper.writeValueAsString(t);
        this.client.post("ticket",json);

        return null;
      }

      public boolean deleteTicket(Ticket ticket){
        return false;
      }

      public boolean updateTicket(Ticket ticket){
        return false;
      }

      public Ticket getTicket(int id) throws Exception{
        String json = this.client.get("ticket/"+id);
        Ticket ticket = mapper.readValue(json, Ticket.class);
        return ticket;
      }

      public List<Ticket> getTickets(){
        return null;
      }

}
