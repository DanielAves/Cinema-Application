package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import java.util.List;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.time.LocalTime;

public class filmScreenController{



  @FXML
  public Button film1,film2,film3,film4,film5,film6,film7,film8,film9,film10;
  public Text filmDate;

  LocalDate inputDate;

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  public LocalDate test;

  public void setDate(LocalDate date){
    inputDate = date;
    filmDate.setText("Showing films for " + dtf.format(inputDate));
  }

  public void setScreen(LocalDate date) throws Exception{
    System.out.println("Showing films for " + dtf.format(inputDate));
    RestClient client = new RestClient("localhost", 5000);

    List filmList = new ArrayList();
    List<Screening> screeningsList = new ArrayList<Screening>();
    List filmIdList = new ArrayList();

    screeningsList = client.getScreeningsByDate(inputDate);




    for (int i = 0 ; i <screeningsList.size(); i++){
      int fid= screeningsList.get(i).getFilm_id();
      filmIdList.add(fid);
    }





    for(int i =0; i<filmIdList.size() ;i++){ //client.getFilm(i) != null
      int temp = Integer.parseInt(filmIdList.get(i).toString());
      Film f = client.getFilm(temp);
      String filmName = f.getFilm_name();
      int filmId = f.getFilm_id();
      switch (filmId) {
        case 1: film1.setText(filmName);
        break;
        case 2: film2.setText(filmName);
        break;
        case 3: film3.setText(filmName);
        break;
        case 4: film4.setText(filmName);
        break;
        case 5: film5.setText(filmName);
        break;
        case 6: film6.setText(filmName);
        break;
        case 7: film7.setText(filmName);
        break;
        case 8: film8.setText(filmName);
        break;
        case 9: film9.setText(filmName);
        break;
        case 10: film10.setText(filmName);
        break;
      }
    }
  }




  public void logoutButtonClicked(ActionEvent event) throws IOException{
    Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/loginScreen.fxml"));
    Scene filmScreen = new Scene(secondaryroot);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(filmScreen);
    window.show();

  }

  public void backButtonClicked(ActionEvent event) throws IOException{
    Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/homeScreen.fxml"));
    Scene filmScreen = new Scene(secondaryroot);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(filmScreen);
    window.show();

  }
  public void selectFilm(ActionEvent event) throws Exception{

    FXMLLoader Loader = new FXMLLoader();
    Loader.setLocation(getClass().getResource("resources/timetableScreen.fxml"));
    try{
      Loader.load();
    }catch (IOException ex){
      Logger.getLogger(filmScreenController.class.getName());
    }

    timetableController display = Loader.getController();
    String filmName = (((Button)event.getSource()).getText());
    String buttonID = (((Button)event.getSource()).getId());

    int filmID =0;


    if (buttonID.equals("film1")){
      filmID = 1;
    }
    if (buttonID.equals("film2")){
      filmID = 2;
    }
    if (buttonID.equals("film3")){
      filmID = 3;
    }
    if (buttonID.equals("film4")){
      filmID = 4;
    }
    if (buttonID.equals("film5")){
      filmID = 5;
    }
    if (buttonID.equals("film6")){
      filmID = 6;
    }
    if (buttonID.equals("film7")){
      filmID = 7;
    }
    if (buttonID.equals("film8")){
      filmID = 8;
    }
    if (buttonID.equals("film9")){
      filmID = 9;
    }
    if (buttonID.equals("film10")){
      filmID = 10;
    }

    display.setDate(inputDate); //pass date to next controller
    display.calculateShowingTimes(filmID); //pass film ID
    display.setFilmName(filmName);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();
  }
}
