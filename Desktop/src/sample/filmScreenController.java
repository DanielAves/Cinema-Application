package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class filmScreenController{
    @FXML
    private Label film1;

    public void homeButtonClicked(ActionEvent event) throws IOException{
        Parent secondaryroot = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        Scene filmScreen = new Scene(secondaryroot);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(filmScreen);
        app_stage.show();


    }





    }








