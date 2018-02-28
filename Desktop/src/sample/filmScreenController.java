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

public class filmScreenController{



    @FXML
    public Button film1,film2,film3,film4,film5,film6,film7,film8,film9,film10;
    public Text filmDate;






    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");



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


    public void initialize(){
        Film db = new Film();
        dbConnection con = new dbConnection();
        film1.setText(con.filmList.get(0).getFilmName());

        film2.setText(con.filmList.get(1).getFilmName());
        film3.setText(con.filmList.get(2).getFilmName());
        film4.setText(con.filmList.get(3).getFilmName());
        film5.setText(con.filmList.get(4).getFilmName());
        film6.setText(con.filmList.get(5).getFilmName());
        film7.setText(con.filmList.get(6).getFilmName());
        film8.setText(con.filmList.get(7).getFilmName());
        film9.setText(con.filmList.get(8).getFilmName());
        film10.setText(con.filmList.get(9).getFilmName());

    }



    public void setDate(LocalDate date){
        //this.timeFor.setText(filmName);
        filmDate.setText("Showing films for " + dtf.format(date));
        System.out.println(dtf.format(date));
    }
}








