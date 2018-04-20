package sample;

import java.util.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Button;

public class seatingScreenController {

  double totalNew;
  @FXML
  public Button seat1, seat2, seat3, seat4, seat5, seat6 ,seat7, seat8, seat9, seat10;

  int screenID;
  List seats = new ArrayList();
  int counter =0;

  public void setTotal(double grandTotal2){
    totalNew = grandTotal2;
  }
  public void payClicked(ActionEvent event)throws IOException{
    FXMLLoader Loader = new FXMLLoader();
    Loader.setLocation(getClass().getResource("resources/PaymentScreen.fxml"));
    try{
      Loader.load();
    }catch (IOException ex){
      Logger.getLogger(filmScreenController.class.getName());
    }

    PaymentScreenController display = Loader.getController();
    display.setTotal(totalNew);
    display.setSeats(seats);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }
  public void populateSeats(int screeningID) throws Exception{
    RestClient client = new RestClient("localhost", 5000);
    screenID = screeningID;
    //List<Ticket> tickets;
    List tickets = new ArrayList();
    if (client.getTickets() == null){
      //Do nothing, prevents errors.
    }
    else{
      tickets = client.getTickets();
      int ticketAmount = tickets.size();
      List screeningsList = new ArrayList();
      screeningsList = client.getScreenings();

      //System.out.println(ticketAmount);

      for(int i =1; i <=ticketAmount; i++){
        //Ticket ticket = (Ticket) ticket.getScreening_id();

        System.out.println(screeningID);

        Ticket ticket = client.getTicket(i);
        int ticketScreenID = ticket.getScreening_id();

        if (screeningID == ticketScreenID){
          int seat = ticket.getSeat_id();
          // System.out.println(seat);

          switch (seat) {
            case 1: seat1.setText("Taken");
            break;
            case 2: seat2.setText("Taken");
            break;
            case 3: seat3.setText("Taken");
            break;
            case 4: seat4.setText("Taken");
            break;
            case 5: seat5.setText("Taken");
            break;
            case 6: seat6.setText("Taken");
            break;
            case 7: seat7.setText("Taken");
            break;
            case 8: seat8.setText("Taken");
            break;
            case 9: seat9.setText("Taken");
            break;
            case 10: seat10.setText("Taken");
            break;
          }

        }



      }
    }
  }
  public void seatSelection(ActionEvent event) throws Exception {
    //Pass ticket total to here and define array based on the amount of seats to be selected based on tickets

    seats.add(((Button)event.getSource()).getText());
    //int seatNum = Integer.parseInt((((Button)event.getSource()).getText()));
    //String seatNum = (((Button)event.getSource()).getId());
    //int seats2 = Integer.parseInt(seats.get(0).toString());

    ((Button)event.getSource()).setText("Selected");

    RestClient client = new RestClient("localhost", 5000);
    // create screening onj for appropriate screening
    Screening screening = client.getScreening(screenID);
    //create seat obj for appropraite seat
    Seat seat = client.getSeat(Integer.parseInt(seats.get(counter).toString()));
    //till is customer 5
    Customer c = new Customer(5);

    client.createTicket(c,screening,seat);

    counter++;



}
}
