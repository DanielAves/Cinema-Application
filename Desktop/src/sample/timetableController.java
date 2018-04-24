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
  int[] screeningID = new int[10];
  int[] screenID = new int[10];
  boolean time1,time2,time3,time4,time5,time6,time7,time8,time9,time10 = false;

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
    //List screeningsList = new ArrayList();
    List timeList = new ArrayList();
    int j = 0; //Used for storing screeningID for specific time

  List<Screening> screeningsList = new ArrayList<Screening>();
  screeningsList = client.getScreeningsByDate(inputDate);
  List<Screening> usedScreeningsList = new ArrayList<Screening>();
  List<LocalTime> filmTimes = new ArrayList<LocalTime>();


  for (Screening s : screeningsList){
    int id = s.getFilm_id();
    if (id == filmID){
      filmTimes.add(s.getScreening_time());
      usedScreeningsList.add(s);
    }
  }


  Collections.sort(filmTimes);
  for(int i=0;i<filmTimes.size();i++){
    System.out.println(filmTimes.get(i));
  }


  for(int i=0;i<usedScreeningsList.size();i++){
   System.out.println(usedScreeningsList.get(i));
   }



  List<Integer> orderedFilmIds = new ArrayList<Integer>();
  List<Integer> orderedScreeningIds = new ArrayList<Integer>();

  for (int i= 0 ; i< filmTimes.size();i++){
    for (Screening s : usedScreeningsList){
      if (s.getScreening_time() == filmTimes.get(i)){
        int fid = s.getFilm_id();
        int sid = s.getScreening_id();
        orderedFilmIds.add(fid);
        orderedScreeningIds.add(sid);
      }

    }

}

for(int i=0;i<orderedFilmIds.size();i++){
  System.out.println(orderedFilmIds.get(i));
}
 System.out.println("SCREENING IDS");
for(int i=0;i<orderedScreeningIds.size();i++){
  System.out.println(orderedScreeningIds.get(i));
}

/**  for (Screening s : usedScreeningsList){

        screenTime = s.getScreening_time();
        int screenID = s.getScreen_id();
        int size = filmTime.size();

        if(size > 0 && time1 == false && s.getFilm_id() == filmID && screenTime.equals(filmTimes.get(0))){
          screeningID[0] = s.getScreening_id();
          screenID[0] = s.getScreen_id();
          film1.setText(timeList.get(0).toString());
          screen1.setText("Screen " + Integer.toString(s.getScreen_id()));
          time1 = true;

        }



  }*/




  // int size = filmTimes.size();
  // if(size > 0 && time1 == false && usedScreeningsList.getFilm_id() == filmID && screenTime.equals(timeList.get(0)) && dateScreening.equals(inputDate)){
  //   screeningID[0] = s.getScreening_id();
  //   screenID[0] = s.getScreen_id();
  //   film1.setText(timeList.get(0).toString());
  //   screen1.setText("Screen " + Integer.toString(s.getScreen_id()));
  //   time1 = true;
  //
  // }
  //
  //
  // for(int i =1; i<=screeningAmount; i++){
  //
  //   Screening s = client.getScreening(i);
  //   LocalTime screenTime = s.getScreening_time();
  //   LocalDate dateScreening = s.getScreening_date();
  //   int size = timeList.size();
  //   if(size > 0 && time1 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(0)) && dateScreening.equals(inputDate)){
  //     screeningID[0] = s.getScreening_id();
  //     screenID[0] = s.getScreen_id();
  //     film1.setText(timeList.get(0).toString());
  //     screen1.setText("Screen " + Integer.toString(s.getScreen_id()));
  //     time1 = true;
  //   }
  //






    //Populate screeningsList
    /**screeningsList = client.getScreenings();

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
      if(size > 0 && time1 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(0)) && dateScreening.equals(inputDate)){
        screeningID[0] = s.getScreening_id();
        screenID[0] = s.getScreen_id();
        film1.setText(timeList.get(0).toString());
        screen1.setText("Screen " + Integer.toString(s.getScreen_id()));
        time1 = true;
      }

      else if(size > 1 && time2 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(1)) && dateScreening.equals(inputDate)){
        screeningID[1] = s.getScreening_id();
        film2.setText(timeList.get(1).toString());
        screen2.setText("Screen " + Integer.toString(s.getScreen_id()));
        time2 = true;
      }
      else if(size > 2 && time3 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(2)) && dateScreening.equals(inputDate)){
        screeningID[2] = s.getScreening_id();
        screenID[2] = s.getScreen_id();
        film3.setText(timeList.get(2).toString());
        screen3.setText("Screen " + Integer.toString(s.getScreen_id()));
        time3 = true;
      }
      else if(size > 3 && time4 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(3)) && dateScreening.equals(inputDate)){
        screeningID[3] = s.getScreening_id();
        screenID[3] = s.getScreen_id();
        film4.setText(timeList.get(3).toString());
        screen4.setText("Screen " + Integer.toString(s.getScreen_id()));
        time4 = true;
      }
      else if(size > 4 && time5 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(4)) && dateScreening.equals(inputDate)){
        screeningID[4] = s.getScreening_id();
        screenID[4] = s.getScreen_id();
        film5.setText(timeList.get(4).toString());
        screen5.setText("Screen " + Integer.toString(s.getScreen_id()));
        time5 = true;
      }
      else if(size > 5 && time6 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(5)) && dateScreening.equals(inputDate)){
        screeningID[5] = s.getScreening_id();
        screenID[5] = s.getScreen_id();
        film6.setText(timeList.get(5).toString());
        screen6.setText("Screen " + Integer.toString(s.getScreen_id()));
        time6 = true;
      }
      else if(size > 6 && time7 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(6)) && dateScreening.equals(inputDate)){
        screeningID[6] = s.getScreening_id();
        screenID[6] = s.getScreen_id();
        film7.setText(timeList.get(6).toString());
        screen7.setText("Screen " + Integer.toString(s.getScreen_id()));
        time7 = true;
      }
      else if(size > 7 && time8 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(7)) && dateScreening.equals(inputDate)){
        screeningID[7] = s.getScreening_id();
        screenID[7] = s.getScreen_id();
        film8.setText(timeList.get(7).toString());
        screen8.setText("Screen " + Integer.toString(s.getScreen_id()));
        time8 = true;
      }
      else if(size > 8 && time9 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(8)) && dateScreening.equals(inputDate)){
        screeningID[8] = s.getScreening_id();
        screenID[8] = s.getScreen_id();
        film9.setText(timeList.get(8).toString());
        screen9.setText("Screen " + Integer.toString(s.getScreen_id()));
        time9 = true;
      }
      else if(size > 9 && time10 == false && s.getFilm_id() == filmID && screenTime.equals(timeList.get(9)) && dateScreening.equals(inputDate)){
        screeningID[9] = s.getScreening_id();
        screenID[9] = s.getScreen_id();
        film10.setText(timeList.get(9).toString());
        screen10.setText("Screen " + Integer.toString(s.getScreen_id()));
        time10 = true;
      }
    }*/
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
    display.setScreeningID(screeningID[filmID]);

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
