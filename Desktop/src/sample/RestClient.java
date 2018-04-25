package sample;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.text.SimpleDateFormat;
import java.time.LocalDate ;

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
        JsonNode jsonNode = mapper.readTree(json).get("objects");
        String foo = jsonNode.toString();

        TypeReference<List<Film>> mapType = new TypeReference<List<Film>>() {};
        List<Film> jsonToList = mapper.readValue(foo, mapType);


        return jsonToList;
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
        //GenericWrapper<Screen> myObjects = mapper.readValue(json, GenericWrapper.class);
      //  return myObjects.getObjects();
      JsonNode jsonNode = mapper.readTree(json).get("objects");
      String foo = jsonNode.toString();

      TypeReference<List<Screen>> mapType = new TypeReference<List<Screen>>() {};
      List<Screen> jsonToList = mapper.readValue(foo, mapType);


      return jsonToList;
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
        JsonNode jsonNode = mapper.readTree(json).get("objects");
        String foo = jsonNode.toString();

        TypeReference<List<Screening>> mapType = new TypeReference<List<Screening>>() {};
        List<Screening> jsonToList = mapper.readValue(foo, mapType);


        return jsonToList;
      }

      public List<Screening> getScreeningsByDate(LocalDate date) throws Exception {
        String filter =  "{%22filters%22:[{%22name%22:%22screening_date%22,%22op%22:%22eq%22,%22val%22:%22" +date.toString()+"%22}]}" ;
        String json = this.client.get("screening?q="+filter);

        JsonNode jsonNode = mapper.readTree(json).get("objects");
        String foo = jsonNode.toString();

        TypeReference<List<Screening>> mapType = new TypeReference<List<Screening>>() {};
        List<Screening> jsonToList = mapper.readValue(foo, mapType);


        return jsonToList;
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
        JsonNode jsonNode = mapper.readTree(json).get("objects");
        String foo = jsonNode.toString();

        TypeReference<List<Seat>> mapType = new TypeReference<List<Seat>>() {};
        List<Seat> jsonToList = mapper.readValue(foo, mapType);


        return jsonToList;
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

      public List<Ticket> getTickets() throws Exception{
        String json = this.client.get("ticket");
        JsonNode jsonNode = mapper.readTree(json).get("objects");
        String foo = jsonNode.toString();

        TypeReference<List<Ticket>> mapType = new TypeReference<List<Ticket>>() {};
        List<Ticket> jsonToList = mapper.readValue(foo, mapType);


        return jsonToList;
      }

      public List<Ticket> getTicketsByScreening(int screeningID) throws Exception {
        String filter =  "{%22filters%22:[{%22name%22:%22screening_id%22,%22op%22:%22eq%22,%22val%22:%22" +screeningID+"%22}]}" ;
        String json = this.client.get("ticket?q="+filter);

        JsonNode jsonNode = mapper.readTree(json).get("objects");
        String foo = jsonNode.toString();

        TypeReference<List<Ticket>> mapType = new TypeReference<List<Ticket>>() {};
        List<Ticket> jsonToList = mapper.readValue(foo, mapType);


        return jsonToList;
      }


}
