package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Logger;

public class homeScreenController {

    @FXML
    private DatePicker filmDate;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void showToday(javafx.event.ActionEvent event) throws IOException{

        Calendar now = Calendar.getInstance();

        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate));


        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("resources/filmScreen.fxml"));
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

    public void showFutureDate(javafx.event.ActionEvent event) throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = filmDate.getValue();
      //  System.out.println(dtf.format(date));





        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("resources/filmScreen.fxml"));
        try{
            Loader.load();
        }catch (IOException ex){
            Logger.getLogger(filmScreenController.class.getName());
        }

        filmScreenController display = Loader.getController();
        display.setDate(date);

        Parent p = Loader.getRoot();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(p));
        window.show();




    }








}
