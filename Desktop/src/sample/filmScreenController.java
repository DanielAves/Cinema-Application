package sample;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class filmScreenController{


    @FXML
    public Label film1;

    public String filmName;

    @FXML
    public Label film2;


    public void logoutButtonClicked(ActionEvent event) throws IOException{
        Parent secondaryroot = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        Scene filmScreen = new Scene(secondaryroot);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(filmScreen);
        window.show();

    }
    public void selectFilm(ActionEvent event) throws IOException{
        //if statement here for button selection, changes filmname
        String filmName = film1.getText();

        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("timetableScreen.fxml"));
        try{
            Loader.load();
        }catch (IOException ex){
            Logger.getLogger(filmScreenController.class.getName());
        }

        timetableController display = Loader.getController();
        display.setFilmName(filmName);

        Parent p = Loader.getRoot();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(p));
        window.show();


    }


    public void initialize(){
        film1.setText("The Greatest Show Man");
        film2.setText("terminator");


    }


    }








