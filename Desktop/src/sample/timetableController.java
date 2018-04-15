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
import java.time.LocalDateTime;
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
  int[] screenID = new int[10];

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

      LocalDateTime currentTime = LocalDateTime.now();
      Screening s = client.getScreening(i);
      LocalTime screenTime = s.getScreening_time();
      LocalDate dateScreening = s.getScreening_date();
      int screenID = s.getScreen_id();

      if(s.getFilm_id() == filmID && dateScreening.equals(inputDate)){
        timeList.add(screenTime);
      }
    }
    Collections.sort(timeList);
    for(int i =1; i<=screeningAmount; i++){

      Screening s = client.getScreening(i);
      LocalTime screenTime = s.getScreening_time();
      LocalDate dateScreening = s.getScreening_date();
      int size = timeList.size();
      if(size > 0 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(0)) && dateScreening.equals(inputDate)){
        screeningID[0] = s.getScreening_id();
        screenID[0] = s.getScreen_id();
        film1.setText(timeList.get(0).toString());
      }
      if(size > 1 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(1)) && dateScreening.equals(inputDate)){
        screeningID[1] = s.getScreening_id();
        screenID[1] = s.getScreen_id();
        film2.setText(timeList.get(1).toString());
      }
      if(size > 2 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(2)) && dateScreening.equals(inputDate)){
        screeningID[2] = s.getScreening_id();
        screenID[2] = s.getScreen_id();
        film3.setText(timeList.get(2).toString());
      }
      if(size > 3 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(3)) && dateScreening.equals(inputDate)){
        screeningID[3] = s.getScreening_id();
        screenID[3] = s.getScreen_id();
        film4.setText(timeList.get(3).toString());
      }
      if(size > 4 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(4)) && dateScreening.equals(inputDate)){
        screeningID[4] = s.getScreening_id();
        screenID[4] = s.getScreen_id();
        film5.setText(timeList.get(4).toString());
      }
      if(size > 5 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(5)) && dateScreening.equals(inputDate)){
        screeningID[5] = s.getScreening_id();
        screenID[5] = s.getScreen_id();
        film6.setText(timeList.get(5).toString());
      }
      if(size > 6 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(6)) && dateScreening.equals(inputDate)){
        screeningID[6] = s.getScreening_id();
        screenID[6] = s.getScreen_id();
        film7.setText(timeList.get(6).toString());
      }
      if(size > 7 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(7)) && dateScreening.equals(inputDate)){
        screeningID[7] = s.getScreening_id();
        screenID[7] = s.getScreen_id();
        film8.setText(timeList.get(7).toString());
      }
      if(size > 8 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(8)) && dateScreening.equals(inputDate)){
        screeningID[8] = s.getScreening_id();
        screenID[8] = s.getScreen_id();
        film9.setText(timeList.get(8).toString());
      }
      if(size > 9 && s.getFilm_id() == filmID && screenTime.equals(timeList.get(9)) && dateScreening.equals(inputDate)){
        screeningID[9] = s.getScreening_id();
        screenID[9] = s.getScreen_id();
        film10.setText(timeList.get(9).toString());
      }
    }
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

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }

  public void time2Clicked(javafx.event.ActionEvent event) throws IOException{

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
    display.setScreeningID(screeningID[1]);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }

  public void time9Clicked(javafx.event.ActionEvent event) throws IOException{

    FXMLLoader Loader = new FXMLLoader();
    Loader.setLocation(getClass().getResource("resources/bookingScreen.fxml"));
    try{
      Loader.load();
    }catch (IOException ex){
      Logger.getLogger(filmScreenController.class.getName());
    }

    bookingScreenController display = Loader.getController();
    String time = film9.getText();
    display.setDate(inputDate); //pass date to next controller
    display.setTime(time); //pass film ID
    display.setScreeningID(screeningID[8]);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }








}
