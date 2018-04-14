package sample;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import java.time.format.DateTimeFormatter;
import javafx.scene.text.Text;


public class timetableController{

  @FXML
  public Button film1,film2,film3,film4,film5,film6,film7,film8,film9,film10;
  public Text filmDate;

  LocalDate inputDate;
  String filmName;
  int[] screeningID = new int[10];

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
  DateTimeFormatter time = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public void setDate(LocalDate date){
    inputDate = date;

  }
  public void setFilmName(String name){
    filmName = name;
    filmDate.setText("Showing times for " + filmName + " on " + time.format(inputDate));

  }
  public void setTime(int filmID) throws Exception{
    RestClient client = new RestClient("localhost", 5000);
    List screeningsList = new ArrayList();
    List timeList = new ArrayList();
    int j = 0; //Used for storing screeningID for specific time

    //Populate screeningsList
    screeningsList = client.getScreenings();

    //Check amount of screenings in db
    int screeningAmount = screeningsList.size();

    for(int i =1; i<=screeningAmount; i++){

      //int temp2 = Integer.parseInt(filmIdList.get(1).toString());
      Screening s = client.getScreening(i);
      LocalTime screenTime = s.getScreening_time();
      LocalDate dateScreening = s.getScreening_date();
      int screenID = s.getScreen_id();
      if(s.getFilm_id() == filmID && dateScreening.equals(inputDate)){
        timeList.add(screenTime);
        screeningID[j] = s.getScreening_id();
        j++;
        switch (screenID) {
          case 1: film1.setText(dtf.format(screenTime));
          break;
          case 2: film2.setText(dtf.format(screenTime));
          break;
          case 3: film3.setText(dtf.format(screenTime));
          break;
          case 4: film4.setText(dtf.format(screenTime));
          break;
          case 5: film5.setText(dtf.format(screenTime));
          break;
          case 6: film6.setText(dtf.format(screenTime));
          break;
          case 7: film7.setText(dtf.format(screenTime));
          break;
          case 8: film8.setText(dtf.format(screenTime));
          break;
          case 9: film9.setText(dtf.format(screenTime));
          break;
          case 10: film10.setText(dtf.format(screenTime));
          break;
        }
      }
    }
    // Collections.sort(timeList);
    // int size = timeList.size();
    // if (size > 0 && timeList.get(0) != null){
    //   film1.setText(timeList.get(0).toString());
    // }
    // if (size > 1 && timeList.get(1) != null){
    //   film2.setText(timeList.get(1).toString());
    // }
    // if (size > 2 && timeList.get(2) != null){
    //   film3.setText(timeList.get(2).toString());
    // }
    // if (size > 3 && timeList.get(3) != null){
    //   film4.setText(timeList.get(3).toString());
    // }
    // if (size > 4 && timeList.get(4) != null){
    //   film5.setText(timeList.get(4).toString());
    // }
    // if (size > 5 && timeList.get(5) != null){
    //   film6.setText(timeList.get(5).toString());
    // }
    // if (size > 6 && timeList.get(6) != null){
    //   film7.setText(timeList.get(6).toString());
    // }
    // if (size > 7 && timeList.get(7) != null){
    //   film8.setText(timeList.get(7).toString());
    // }
    // if (size > 8 && timeList.get(8) != null){
    //   film9.setText(timeList.get(8).toString());
    // }
    // if (size > 9 && timeList.get(9) != null){
    //   film10.setText(timeList.get(9).toString());
    // }
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

  public void time1Clicked(javafx.event.ActionEvent event) throws IOException{



    FXMLLoader Loader = new FXMLLoader();
    Loader.setLocation(getClass().getResource("resources/bookingScreen.fxml"));
    try{
      Loader.load();
    }catch (IOException ex){
      Logger.getLogger(filmScreenController.class.getName());
    }

    bookingScreenController display = Loader.getController();
    String time = film1.getText();
    display.setDate(inputDate); //pass date to next controller
    display.setTime(time); //pass film ID
    display.setScreeningID(screeningID[0]);
    //System.out.println(screeningID[0]);


    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }









}
