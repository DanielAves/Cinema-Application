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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class filmScreenController{


    @FXML
    public Label film1;

    @FXML
    public Button filmButton1;

    public String filmName;

    @FXML
    public Label film2;
    public Label film3;
    public Label film4;
    public Label film5;
    public Label film6;
    public Label film7;
    public Label film8;


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");



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
//        film2.setText(con.filmList.get(8).getFilmName());
//        film2.setText(con.filmList.get(9).getFilmName());
//        film2.setText(con.filmList.get(10).getFilmName());






    }



    public void setDate(LocalDate date){
        //this.timeFor.setText(filmName);
        System.out.println(dtf.format(date));


    }



}








