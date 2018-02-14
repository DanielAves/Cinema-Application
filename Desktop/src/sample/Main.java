package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene loginScreen,filmScreen,timeTable,tickets,seatSelection;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        window.setTitle("Desktop Interface");
        loginScreen = new Scene(root, 600, 500);


        window.setScene(loginScreen);
        window.show();

//
//        Parent secondaryroot = FXMLLoader.load(getClass().getResource("filmScreen.fxml"));
//        filmScreen = new Scene(secondaryroot, 600, 500);






        //window.setScene(new Scene(root,600,500));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
