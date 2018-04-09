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


public class timetableController{

  @FXML
  public Button film1,film2,film3,film4,film5,film6,film7,film8,film9,film10;

  LocalDate inputDate;

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

  public void setDate(LocalDate date){
    inputDate = date;
  }



  public void setTime(int filmID) throws Exception{
    RestClient client = new RestClient("localhost", 5000);
    List screeningsList = new ArrayList();

    //Populate screeningsList
    screeningsList = client.getScreenings();

    //Check amount of screenings in db
    int screeningAmount = screeningsList.size();


    System.out.println(screeningAmount);
    System.out.println(filmID);
    System.out.println(inputDate);


    for(int i =1; i<=screeningAmount; i++){
      //int temp2 = Integer.parseInt(filmIdList.get(1).toString());
      Screening s = client.getScreening(i);
      LocalTime screenTime = s.getScreening_time();
      LocalDate dateScreening = s.getScreening_date();
      int screenID = s.getScreen_id();
      if(s.getFilm_id() == filmID && dateScreening.equals(inputDate)){
        System.out.println(screenTime);
        System.out.println(screenID);
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
  }

//    @FXML
//    public Label timeFor;


//    public void setFilmName(String filmName){
//        this.timeFor.setText(filmName);
//
//    }



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

        Parent p = Loader.getRoot();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(p));
        window.show();
    }









}
