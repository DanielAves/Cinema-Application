package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Main extends Application {

    Stage window;
    Scene loginScreen,filmScreen,timeTable,tickets,seatSelection;

    //public dbConnection db = new dbConnection();


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        window.setTitle("Desktop Interface");
        loginScreen = new Scene(root, 600, 500);


        window.setScene(loginScreen);
        window.show();

        //int test = db.getfilmID();
        //System.out.println(test);







    }



    public static void main(String[] args) {
        launch(args);
    }
}
