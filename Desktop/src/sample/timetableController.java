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


public class timetableController{

    @FXML
    public Label timeFor;
    //@FXML
    private Label film1;


    public String temp;




    public void setFilmName(String filmName){
        this.timeFor.setText(filmName);

    }

    public void backButton(ActionEvent event) throws IOException {
        Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/filmScreen.fxml"));
        Scene filmScreen = new Scene(secondaryroot);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(filmScreen);
        window.show();

    }







}
