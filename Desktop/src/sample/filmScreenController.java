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
import java.time.LocalDate ;

public class filmScreenController{



  @FXML
  public Button film1,film2,film3,film4,film5,film6,film7,film8,film9,film10;
  public Text filmDate;






  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  public LocalDate test;

  public void setDate(LocalDate date){
    test = date;
    System.out.println(date);
    //this.timeFor.setText(filmName);
    filmDate.setText("Showing films for " + dtf.format(date));
  }

  public void setScreen(LocalDate date) throws Exception{
    RestClient client = new RestClient("localhost", 5000);

    List filmList = new ArrayList();
    List screeningsList = new ArrayList();
    List filmIdList = new ArrayList();

    //Populate filmlist
    filmList = client.getFilms();

    //Check amount of films in db
    int filmAmount = filmList.size();

    //Populate screeningsList
    screeningsList = client.getScreenings();

    //Check amount of screenings in db
    int screeningAmount = screeningsList.size();

    //Date passed from user selection
    //inputDate = date;
    LocalDate inputDate = LocalDate.of(2018,04,04);

    for(int i = 1; i<=screeningAmount; i++){
      Screening s = client.getScreening(i);
      LocalDate dateScreening = s.getScreening_date();
      if(dateScreening.equals(inputDate)){
        if(filmIdList.contains(s.getFilm_id())){
        }
        else{
          filmIdList.add(s.getFilm_id());
        }
      }
    }

    for(int i =0; i<filmIdList.size() ;i++){ //client.getFilm(i) != null
      int temp = Integer.parseInt(filmIdList.get(i).toString());
      Film f = client.getFilm(temp);
      String filmName = f.getFilm_name();
      switch (i) {
        case 0: film1.setText(filmName);
        break;
        case 1: film2.setText(filmName);
        break;
        case 2: film3.setText(filmName);
        break;
        case 3: film4.setText(filmName);
        break;
        case 4: film5.setText(filmName);
        break;
        case 5: film6.setText(filmName);
        break;
        case 6: film7.setText(filmName);
        break;
        case 7: film8.setText(filmName);
        break;
        case 8: film9.setText(filmName);
        break;
        case 9: film10.setText(filmName);
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
  public void selectFilm1(ActionEvent event) throws IOException{
    System.out.println(event.getSource());

    if ("".equals(event.getSource())) {
      System.out.println("test");
    }

    String filmName = film1.getText();


    FXMLLoader Loader = new FXMLLoader();
    Loader.setLocation(getClass().getResource("resources/timetableScreen.fxml"));
    try{
      Loader.load();
    }catch (IOException ex){
      Logger.getLogger(filmScreenController.class.getName());
    }

    timetableController display = Loader.getController();
    //display.setFilmName(filmName);

    Parent p = Loader.getRoot();
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(new Scene(p));
    window.show();

  }



  //
  // public void initialize() throws Exception{
  //
  // }
}
