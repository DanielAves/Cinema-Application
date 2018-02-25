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




    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("resources/loginScreen.fxml"));
        window.setTitle("Desktop Interface");
        loginScreen = new Scene(root, 600, 500);


        window.setScene(loginScreen);
        window.show();

    }


    public static void main(String[] args) throws ClassNotFoundException {



        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:films.db"); //jdbc:sqlite:Desktop/films.db - Dec10 pc, intellij
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            dbConnection test = new dbConnection();


            ResultSet rs = statement.executeQuery("select * from Film");
            while(rs.next())
            {

                // read the result set
                test.setFilmID(rs.getInt("film_id"));
                test.setFilmName(rs.getString("film_name"));
                System.out.println("film_name = " + rs.getString("film_name"));


            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }


        launch(args);
    }


}
