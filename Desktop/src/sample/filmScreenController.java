package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class filmScreenController{


    @FXML
    public Label film1;

    @FXML
    public Button filmButton1;

    public String filmName;

    @FXML
    public Label film2;



    public void logoutButtonClicked(ActionEvent event) throws IOException{
        Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/loginScreen.fxml"));
        Scene filmScreen = new Scene(secondaryroot);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(filmScreen);
        window.show();

    }
    public void selectFilm(ActionEvent event) throws IOException{
        System.out.println(event.getSource());

        if ("".equals(event.getSource())) {
            System.out.println("test");
        }







        //if statement here for button selection, changes filmname
        String filmName = film1.getText();




        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("resources/timetableScreen.fxml"));
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
        dbConnection test2 = new dbConnection();
        film1.setText(test2.getFilmName());
        //film1.setText("The Greatest Show Man ever");
        film2.setText("terminator");


    }


    }








