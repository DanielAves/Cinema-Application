package sample;

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
import java.util.logging.Logger;


public class timetableController{

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
