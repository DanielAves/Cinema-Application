package sample;

import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class seatingScreenController {

  double totalNew;

  public void setTotal(double grandTotal2){
    System.out.println(grandTotal2);
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
  public void populateSeats(double test) throws Exception{
    RestClient client = new RestClient("localhost", 5000);
    //List<Ticket> tickets;
    List tickets = new ArrayList();
    if (client.getTickets() == null){
      System.out.println("null");
    }
    else{
      tickets = client.getTickets();
      int ticketAmount = tickets.size();
      List screeningsList = new ArrayList();
      screeningsList = client.getScreenings();

      // for(Ticket ticket: tickets){
      //   // int id = ticket.getScreening_id();
      //   //System.out.println(ticket.getScreening_id());
      //
      // }

      for(int i =0; i <=ticketAmount; i++){
        //Ticket ticket = (Ticket) ticket.getScreening_id();



        //Currently using customer ID to reference ticket
        Ticket ticket = client.getTicket(1);
        int screenID = ticket.getScreening_id();
        System.out.println(screenID);


      }
    }
  }



}
