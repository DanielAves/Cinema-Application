package sample;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.text.DecimalFormat;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.io.IOException;



/**
*
*
* The payment screen simulates card and cash payment for the till operator.
* The total amount payable is passed into the class to be used.

*
* @author Dan Aves,Matt Cutts
* @version 1.1 (2018-04-22)
*/


public class PaymentScreenController {
  //FXML element importing
  @FXML
  private Label changeDue;
  public Text totalAmount;
  private Button five,ten,fithteen,twenty,thirty,forty,cash,card;
  private TextField quantity;

  double grandTotal;                    //Used to store passed total
  boolean cashBol = false;              //Used to determine if user selects "cash"
  List seatsPayment = new ArrayList();  //Local list to store seats passed to method
  int screenIDLocal;                    //Stores passed screenID

  /**
  * This method sets the local variable grandTotal to the passed total from
  * seatingScreenController.
  * @param totalNew.
  * @return Nothing.
  */
  public void setTotal(double total){
    grandTotal = total;
    totalAmount.setText("Total £ " + String.format("%.2f", total));
  }

  /**
  * This method updates the local list for the passed seats
  * @param seats.
  * @return Nothing.
  */
  public void setSeats(List seats)
  {
    seatsPayment = seats;
  }

  /**
  * This method updates the local screenID for the passed ID dependent on
  * previous selections.
  * @param screenID.
  * @return Nothing.
  */
  public void setScreenID(int screenID){
    screenIDLocal = screenID; //Update local version for access in other functions
    System.out.println(screenIDLocal);
  }


  public void backButtonClicked(ActionEvent event) throws IOException {
    Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/filmScreen.fxml"));
    Scene filmScreen = new Scene(secondaryroot);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(filmScreen);
    window.show();

  }

  public void logoutButtonClicked(ActionEvent event) throws IOException{
    Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/loginScreen.fxml"));
    Scene filmScreen = new Scene(secondaryroot);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(filmScreen);
    window.show();

  }

  public void cardClicked(ActionEvent event) throws Exception{
    AlertBox.display("Please wait", "Processing payment");
    bookSeats();
  }

  public void bookSeats() throws Exception{
    RestClient client = new RestClient("localhost", 5000);
    // create screening obj for appropriate screening
    int seatsPaymentSize = seatsPayment.size();
    //Loop through seat array
    for(int i =0; i<seatsPaymentSize; i++)
    {
      Screening screening = client.getScreening(screenIDLocal);
      //create seat obj for appropraite seat
      Seat seat = client.getSeat(Integer.parseInt(seatsPayment.get(i).toString()));
      //till is customer 5
      Customer c = new Customer(5);
      //Create a ticket for each seat
      client.createTicket(c,screening,seat);
    }

  }

  public void cashClicked(ActionEvent event) throws Exception{
    cashBol = true;
    System.out.println(cashBol);
  }

  public void quantityEntered(ActionEvent event) throws Exception{
    String input = quantity.getText();
    if (cashBol = true){
      grandTotal -= Double.parseDouble(input);
      change();
    }
  }

  public void fiveClicked(ActionEvent event) throws Exception{
    if (cashBol = true){
      grandTotal -=5;
      change();
    }
  }

  public void tenClicked(ActionEvent event) throws Exception{
    if (cashBol = true){
      grandTotal -=10;
      change();
    }
  }

  public void fithteenClicked(ActionEvent event) throws Exception{
    if (cashBol = true){
      grandTotal -=15;
      change();
    }
  }

  public void twentyClicked(ActionEvent event) throws Exception{
    if (cashBol = true){
      grandTotal -=20;
      change();
    }
  }

  public void thirtyClicked(ActionEvent event) throws Exception{
    if (cashBol = true){
      grandTotal -=30;
      change();
    }
  }

  public void fortyClicked(ActionEvent event) throws Exception{
    if (cashBol = true){
      grandTotal -=40;
      change();
    }
  }

  public void change() throws Exception{
    if (grandTotal < 0){
      grandTotal = Math.abs(grandTotal);
      totalAmount.setText("Total £ " + ("0.00"));
      changeDue.setText("Change £ " + String.format("%.2f", grandTotal));
      bookSeats();



    }
    else{
      totalAmount.setText("Total £ " + String.format("%.2f", grandTotal));
    }
  }


}
