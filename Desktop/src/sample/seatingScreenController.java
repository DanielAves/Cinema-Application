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
  public Button seat11, seat12, seat13, seat14, seat15, seat16, seat17, seat18, seat19, seat20;
  public Button seat21, seat22, seat23, seat24, seat25, seat26, seat27, seat28, seat29, seat30;
  public Button seat31, seat32, seat33, seat34, seat35, seat36, seat37, seat38, seat39, seat40;
  public Button seat41, seat42, seat43, seat44, seat45, seat46, seat47, seat48, seat49, seat50;
  public Button seat51, seat52, seat53, seat54, seat55, seat56, seat57, seat58, seat59, seat60;
  public Button seat61, seat62, seat63, seat64, seat65, seat66, seat67, seat68, seat69, seat70;
  public Button seat71, seat72, seat73, seat74, seat75, seat76, seat77, seat78, seat79, seat80;
  public Button seat81, seat82, seat83, seat84, seat85, seat86, seat87, seat88, seat89, seat90;
  public Button seat91, seat92, seat93, seat94, seat95, seat96 ,seat97, seat98, seat99, seat100;

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
    display.setScreenID(screenID);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }
  public void populateSeats(int screeningID) throws Exception{
    RestClient client = new RestClient("localhost", 5000);
    screenID = screeningID;
    List tickets = new ArrayList();
    if (client.getTickets() == null){
      //Do nothing, prevents errors.
    }
    else{
      tickets = client.getTickets();
      int ticketAmount = tickets.size();
      List screeningsList = new ArrayList();
      screeningsList = client.getScreenings();

      for(int i =1; i <=ticketAmount; i++){
        //Ticket ticket = (Ticket) ticket.getScreening_id();

        Ticket ticket = client.getTicket(i);
        int ticketScreenID = ticket.getScreening_id();

        if (screeningID == ticketScreenID){
          int seat = ticket.getSeat_id();

          takenSeats(seat);
        }
      }
    }
  }
  public void seatSelection(ActionEvent event) throws Exception {
    //Pass ticket total to here and define array based on the amount of seats to be selected based on tickets
    String seatText = (((Button)event.getSource()).getText());

    if(seatText.equals("Taken")){
      System.out.println("Seat is already taken");
    }
    else{
      seats.add(seatText);
      ((Button)event.getSource()).setText("Selected");



    }

    //int seatNum = Integer.parseInt((((Button)event.getSource()).getText()));
    //String seatNum = (((Button)event.getSource()).getId());
    //int seats2 = Integer.parseInt(seats.get(0).toString());

  }

  public void takenSeats(int seat){
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
      seat7.setStyle("-fx-background-color: #4286f4");
      break;
      case 8: seat8.setText("Taken");
      break;
      case 9: seat9.setText("Taken");
      break;
      case 10: seat10.setText("Taken");
      break;
      case 11: seat11.setText("Taken");
      break;
      case 12: seat12.setText("Taken");
      break;
      case 13: seat13.setText("Taken");
      break;
      case 14: seat14.setText("Taken");
      break;
      case 15: seat15.setText("Taken");
      break;
      case 16: seat16.setText("Taken");
      break;
      case 17: seat17.setText("Taken");
      break;
      case 18: seat18.setText("Taken");
      break;
      case 19: seat19.setText("Taken");
      break;
      case 20: seat20.setText("Taken");
      break;
      case 21: seat21.setText("Taken");
      break;
      case 22: seat22.setText("Taken");
      break;
      case 23: seat23.setText("Taken");
      break;
      case 24: seat24.setText("Taken");
      break;
      case 25: seat25.setText("Taken");
      break;
      case 26: seat26.setText("Taken");
      break;
      case 27: seat27.setText("Taken");
      break;
      case 28: seat28.setText("Taken");
      break;
      case 29: seat29.setText("Taken");
      break;
      case 30: seat30.setText("Taken");
      break;
      case 31: seat31.setText("Taken");
      break;
      case 32: seat32.setText("Taken");
      break;
      case 33: seat33.setText("Taken");
      break;
      case 34: seat34.setText("Taken");
      break;
      case 35: seat35.setText("Taken");
      break;
      case 36: seat36.setText("Taken");
      break;
      case 37: seat37.setText("Taken");
      break;
      case 38: seat38.setText("Taken");
      break;
      case 39: seat39.setText("Taken");
      break;
      case 40: seat40.setText("Taken");
      break;
      case 41: seat41.setText("Taken");
      break;
      case 42: seat42.setText("Taken");
      break;
      case 43: seat43.setText("Taken");
      break;
      case 44: seat44.setText("Taken");
      break;
      case 45: seat45.setText("Taken");
      break;
      case 46: seat46.setText("Taken");
      break;
      case 47: seat47.setText("Taken");
      break;
      case 48: seat48.setText("Taken");
      break;
      case 49: seat49.setText("Taken");
      break;
      case 50: seat50.setText("Taken");
      break;
      case 51: seat51.setText("Taken");
      break;
      case 52: seat52.setText("Taken");
      break;
      case 53: seat53.setText("Taken");
      break;
      case 54: seat54.setText("Taken");
      break;
      case 55: seat55.setText("Taken");
      break;
      case 56: seat56.setText("Taken");
      break;
      case 57: seat57.setText("Taken");
      break;
      case 58: seat58.setText("Taken");
      break;
      case 59: seat59.setText("Taken");
      break;
      case 60: seat60.setText("Taken");
      break;
      case 61: seat61.setText("Taken");
      break;
      case 62: seat62.setText("Taken");
      break;
      case 63: seat63.setText("Taken");
      break;
      case 64: seat64.setText("Taken");
      break;
      case 65: seat65.setText("Taken");
      break;
      case 66: seat66.setText("Taken");
      break;
      case 67: seat67.setText("Taken");
      break;
      case 68: seat68.setText("Taken");
      break;
      case 69: seat69.setText("Taken");
      break;
      case 70: seat70.setText("Taken");
      break;
      case 71: seat71.setText("Taken");
      break;
      case 72: seat72.setText("Taken");
      break;
      case 73: seat73.setText("Taken");
      break;
      case 74: seat74.setText("Taken");
      break;
      case 75: seat75.setText("Taken");
      break;
      case 76: seat76.setText("Taken");
      break;
      case 77: seat77.setText("Taken");
      break;
      case 78: seat78.setText("Taken");
      break;
      case 79: seat79.setText("Taken");
      break;
      case 80: seat80.setText("Taken");
      break;
      case 81: seat81.setText("Taken");
      break;
      case 82: seat82.setText("Taken");
      break;
      case 83: seat83.setText("Taken");
      break;
      case 84: seat84.setText("Taken");
      break;
      case 85: seat85.setText("Taken");
      break;
      case 86: seat86.setText("Taken");
      break;
      case 87: seat87.setText("Taken");
      break;
      case 88: seat88.setText("Taken");
      break;
      case 89: seat89.setText("Taken");
      break;
      case 90: seat90.setText("Taken");
      break;
      case 91: seat91.setText("Taken");
      break;
      case 92: seat92.setText("Taken");
      break;
      case 93: seat93.setText("Taken");
      break;
      case 94: seat94.setText("Taken");
      break;
      case 95: seat95.setText("Taken");
      break;
      case 96: seat96.setText("Taken");
      break;
      case 97: seat97.setText("Taken");
      break;
      case 98: seat98.setText("Taken");
      break;
      case 99: seat99.setText("Taken");
      break;
      case 100: seat100.setText("Taken");

    }

  }
}
