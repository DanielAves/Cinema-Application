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
  public Button seat1, seat10;

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

    PaymentScreenController total = Loader.getController();
    total.setTotal(totalNew);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }
  public void populateSeats(int screeningID) throws Exception{
    RestClient client = new RestClient("localhost", 5000);
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
            case 2:;
            break;
            case 3:;
            break;
            case 4:;
            break;
            case 5:;
            break;
            case 6:;
            break;
            case 7: ;
            break;
            case 8:;
            break;
            case 9: ;
            break;
            case 10: seat10.setText("Taken"); ;
            break;
          }

        }



      }
    }
  }
  public void seatSelection(ActionEvent event) throws Exception {
    //Pass ticket total to here and define array based on the amount of seats to be selected based on tickets
    int counter = 0;
    List seats = new ArrayList();
    seats.add(((Button)event.getSource()).getText());
    ((Button)event.getSource()).setText("Selected");

    // RestClient client = new RestClient("localhost", 5000);
    // Customer s = client.getCustomers();
    // client.createTicket(s);



}
}
