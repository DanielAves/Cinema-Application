package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.text.DecimalFormat;
import java.util.logging.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class bookingScreenController {

  @FXML
  private ComboBox child,student,adult,vip;
  @FXML
  private Label childTotal,studentTotal,adultTotal,vipTotal,grandTotal;

  //private static DecimalFormat df2 = new DecimalFormat(".##");

  double childTotal2,studentTotal2,adultTotal2,vipTotal2;

  Double grandTotal2 = 0.0;

  int selectedChild,selectedStudent,selectedAdult,selectedVip =0;

  LocalDate inputDate;
  String inputTime;
  int screeningID;

  public void setDate(LocalDate date){
    inputDate = date;
  }

  public void setTime(String time){
    inputTime = time;
  }

  public void setScreeningID(int id){
    screeningID = id;
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

  public void comboBoxChild(ActionEvent event) throws IOException{
    if (selectedChild > 0){
      grandTotal2 += -childTotal2;
    }
    String amount = child.getValue().toString();
    childTotal2 = Double.parseDouble(amount) *6.00;
    childTotal.setText("Total   £ "+ String.format("%.2f",childTotal2));
    grandTotal2 +=childTotal2;
    grandTotal();
    selectedChild++;
  }
  public void comboBoxStudent(ActionEvent event) throws IOException {
    if (selectedStudent > 0){
      grandTotal2 += -studentTotal2;
    }
    String amount = student.getValue().toString();
    studentTotal2 = Double.parseDouble(amount) *7.50;
    studentTotal.setText("Total   £ "+ String.format("%.2f",studentTotal2));
    grandTotal2 +=studentTotal2;
    grandTotal();
    selectedStudent++;
  }
  public void comboBoxAdult(ActionEvent event) throws IOException{
    if (selectedChild > 0){
      grandTotal2 += -adultTotal2;
    }
    String amount = adult.getValue().toString();
    adultTotal2 = Double.parseDouble(amount) *8.00;
    adultTotal.setText("Total   £ "+ String.format("%.2f",adultTotal2));
    grandTotal2 += adultTotal2;
    grandTotal();
    selectedChild++;

  }
  public void comboBoxVip(ActionEvent event) throws IOException{
    if (selectedVip > 0){
      grandTotal2 += -vipTotal2;
    }
    String amount = vip.getValue().toString();
    vipTotal2 = Double.parseDouble(amount) *10.00;
    vipTotal.setText("Total   £ "+ String.format("%.2f",vipTotal2));
    grandTotal2 += vipTotal2;
    grandTotal();
    selectedVip++;

  }

  public void grandTotal(){
    grandTotal.setText("Grand total   £ " + String.format("%.2f", grandTotal2));
  }


  public void selectSeats(ActionEvent event) throws Exception{
    FXMLLoader Loader = new FXMLLoader();
    Loader.setLocation(getClass().getResource("resources/seatingScreen.fxml"));
    try{
      Loader.load();
    }catch (IOException ex){
      Logger.getLogger(seatingScreenController.class.getName());
    }

    seatingScreenController display = Loader.getController();
    display.setTotal(grandTotal2);
    display.populateSeats(screeningID);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }

  public void initialize() {
    child.getItems().addAll(0,1,2,3,4);
    student.getItems().addAll(0,1,2,3,4);
    adult.getItems().addAll(0,1,2,3,4);
    vip.getItems().addAll(0,1,2,3,4);











  }


}
