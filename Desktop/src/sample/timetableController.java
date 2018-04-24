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
import javafx.scene.control.Label;



public class timetableController{

  @FXML
  public Button film1,film2,film3,film4,film5,film6,film7,film8,film9,film10;
  public Label screen1,screen2,screen3,screen4,screen5,screen6,screen7,screen8,screen9,screen10;
  public Text filmDate;

  LocalDate inputDate;
  String filmName;
  List<LocalTime> filmTimes = new ArrayList<LocalTime>();
  List<Integer> orderedScreeningIds = new ArrayList<Integer>();
  List<Screening> screeningsList = new ArrayList<Screening>();
  //Stores reduced size of screenings for more efficient searching
  List<Screening> usedScreeningsList = new ArrayList<Screening>();
  //List<Integer> orderedFilmIds = new ArrayList<Integer>();

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
  DateTimeFormatter time = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public void setDate(LocalDate date){
    inputDate = date;
  }
  public void setFilmName(String name){
    filmName = name;
    filmDate.setText("Showing times for " + filmName + " on " + time.format(inputDate));
  }
  public void calculateShowingTimes(int filmID) throws Exception{
    RestClient client = new RestClient("localhost", 5000);

    screeningsList = client.getScreeningsByDate(inputDate);

    for (Screening s : screeningsList){
      if (s.getFilm_id() == filmID){
        filmTimes.add(s.getScreening_time());
        usedScreeningsList.add(s);
      }
    }


    Collections.sort(filmTimes);







    for (int i= 0 ; i< filmTimes.size();i++){
      for (Screening s : usedScreeningsList){
        if (s.getScreening_time() == filmTimes.get(i)){
          int fid = s.getFilm_id();
          int sid = s.getScreening_id();
          int screenNum  =s.getScreen_id();
          //orderedFilmIds.add(fid);
          orderedScreeningIds.add(sid);
          populateScreen(i,screenNum);
        }
      }
    }
  }

  public void populateScreen(int value,int screenNum){
    value = value +1;//swith statement starts at 1
    switch (value) {
      case 1: film1.setText(filmTimes.get(0).toString());
      screen1.setText("Screen " + Integer.toString(screenNum));
      break;
      case 2: film2.setText(filmTimes.get(1).toString());
      screen2.setText("Screen " + Integer.toString(screenNum));
      break;
      case 3: film3.setText(filmTimes.get(2).toString());
      screen3.setText("Screen " + Integer.toString(screenNum));
      break;
      case 4: film4.setText(filmTimes.get(3).toString());
      screen4.setText("Screen " + Integer.toString(screenNum));
      break;
      case 5: film5.setText(filmTimes.get(4).toString());
      screen5.setText("Screen " + Integer.toString(screenNum));
      break;
      case 6: film6.setText(filmTimes.get(5).toString());
      screen6.setText("Screen " + Integer.toString(screenNum));
      break;
      case 7: film7.setText(filmTimes.get(6).toString());
      screen7.setText("Screen " + Integer.toString(screenNum));
      break;
      case 8: film8.setText(filmTimes.get(7).toString());
      screen8.setText("Screen " + Integer.toString(screenNum));
      break;
      case 9: film9.setText(filmTimes.get(8).toString());
      screen9.setText("Screen " + Integer.toString(screenNum));
      break;
      case 10: film10.setText(filmTimes.get(9).toString());
      screen10.setText("Screen " + Integer.toString(screenNum));
      break;
    }
  }






    public void backButtonClicked(ActionEvent event) throws Exception {
      FXMLLoader Loader = new FXMLLoader();
      Loader.setLocation(getClass().getResource("resources/filmScreen.fxml"));
      try{
        Loader.load();
      }catch (IOException ex){
        Logger.getLogger(filmScreenController.class.getName());
      }

      LocalDate localDate = LocalDate.now();
      filmScreenController display = Loader.getController();
      display.setDate(inputDate);
      display.setScreen(inputDate);

      Parent p = Loader.getRoot();
      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.setScene(new Scene(p));
      window.show();
    }



    public void logoutButtonClicked(ActionEvent event) throws IOException{
      Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/loginScreen.fxml"));
      Scene filmScreen = new Scene(secondaryroot);
      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.setScene(filmScreen);
      window.show();

    }

    public void timeClicked(javafx.event.ActionEvent event) throws IOException{

      FXMLLoader Loader = new FXMLLoader();
      Loader.setLocation(getClass().getResource("resources/bookingScreen.fxml"));
      try{
        Loader.load();
      }catch (IOException ex){
        Logger.getLogger(filmScreenController.class.getName());
      }

      BookingScreenController display = Loader.getController();
      String time = (((Button)event.getSource()).getText());
      String buttonID = (((Button)event.getSource()).getId());

      int filmID =0;


      if (buttonID.equals("film1")){
        filmID = 0;
      }
      if (buttonID.equals("film2")){
        filmID = 1;
      }
      if (buttonID.equals("film3")){
        filmID = 2;
      }
      if (buttonID.equals("film4")){
        filmID = 3;
      }
      if (buttonID.equals("film5")){
        filmID = 4;
      }
      if (buttonID.equals("film6")){
        filmID = 5;
      }
      if (buttonID.equals("film7")){
        filmID = 6;
      }
      if (buttonID.equals("film8")){
        filmID = 7;
      }
      if (buttonID.equals("film9")){
        filmID = 8;
      }
      if (buttonID.equals("film10")){
        filmID = 9;
      }

      display.setDate(inputDate); //pass date to next controller
      display.setTime(time); //pass film ID
      display.setScreeningID(orderedScreeningIds.get(filmID));

      Parent p = Loader.getRoot();
      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.setScene(new Scene(p));
      window.show();
    }

    // public void time2Clicked(javafx.event.ActionEvent event) throws IOException{
    //
    //   FXMLLoader Loader = new FXMLLoader();
    //   Loader.setLocation(getClass().getResource("resources/bookingScreen.fxml"));
    //   try{
    //     Loader.load();
    //   }catch (IOException ex){
    //     Logger.getLogger(filmScreenController.class.getName());
    //   }
    //
    //   BookingScreenController display = Loader.getController();
    //   String time = film1.getText();
    //   display.setDate(inputDate); //pass date to next controller
    //   display.setTime(time); //pass film ID
    //   display.setScreeningID(screeningID[1]);
    //
    //   Parent p = Loader.getRoot();
    //   Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //   window.setScene(new Scene(p));
    //   window.show();
    // }
    //
    // public void time9Clicked(javafx.event.ActionEvent event) throws IOException{
    //
    //   FXMLLoader Loader = new FXMLLoader();
    //   Loader.setLocation(getClass().getResource("resources/bookingScreen.fxml"));
    //   try{
    //     Loader.load();
    //   }catch (IOException ex){
    //     Logger.getLogger(filmScreenController.class.getName());
    //   }
    //
    //   BookingScreenController display = Loader.getController();
    //   String time = film9.getText();
    //   display.setDate(inputDate); //pass date to next controller
    //   display.setTime(time); //pass film ID
    //   display.setScreeningID(screeningID[8]);
    //
    //   Parent p = Loader.getRoot();
    //   Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //   window.setScene(new Scene(p));
    //   window.show();
    // }




  }
