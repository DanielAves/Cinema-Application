import javafx.application.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.awt.*;

import java.awt.Window;
import java.awt.geom.Rectangle2D;

public class Home extends Application{

    Stage window;
    Scene HomeScreen, FilmTimes;

    public static void main(String[] args) {
        launch(args);

    }





    @Override
    public void start(Stage primaryStage) throws Exception{

        java.util.Date date = new java.util.Date();





        //System.out.println(date);

        window = primaryStage;

        javafx.geometry.Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds(); //Allows visual bounds
        //Window 1

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10)); //border
        grid.setVgap(8);                                               //Spacing for elements
        grid.setHgap(10);


        HomeScreen = new Scene(grid,visualBounds.getWidth(),visualBounds.getHeight());
        window.setScene(HomeScreen);
        window.show();


        Label Date = new Label(String.valueOf(date));
        Label Film1 = new Label("Film 1 Text"); //Movie content from database
        Label Film2 = new Label("Film 2 Text");
        Label Film3 = new Label("Film 3 Text");
        Label Film4 = new Label("Film 4 Text");
        Label Film5 = new Label("Film 5 Text");
        Label TimeFor = new Label("Displaying times for    ");

        Button Film1Button = new Button("Go to");
        Film1Button.setPrefHeight(50);
        Film1Button.setPrefWidth(100);
        Button Film2Button = new Button("Go to");
        Film2Button.setPrefHeight(50);
        Film2Button.setPrefWidth(100);
        Button Film3Button = new Button("Go to");
        Film3Button.setPrefHeight(50);
        Film3Button.setPrefWidth(100);
        Button Film4Button = new Button("Go to");
        Film4Button.setPrefHeight(50);
        Film4Button.setPrefWidth(100);
        Button Film5Button = new Button("Go to");
        Film5Button.setPrefHeight(50);
        Film5Button.setPrefWidth(100);



        //Links for elements

        Film1Button.setOnAction(e ->{
            TimeFor.setText(TimeFor.getText() + String.valueOf(Film1));
            window.setScene(FilmTimes);
        });
        Film2Button.setOnAction(e ->{
            TimeFor.setText(TimeFor.getText() + String.valueOf(Film2));
            window.setScene(FilmTimes);
        });
        Film3Button.setOnAction(e ->{
            TimeFor.setText(TimeFor.getText() + String.valueOf(Film3));
            window.setScene(FilmTimes);
        });
        Film4Button.setOnAction(e ->{
            TimeFor.setText(TimeFor.getText() + String.valueOf(Film4));
            window.setScene(FilmTimes);
        });
        Film5Button.setOnAction(e ->{
            TimeFor.setText(TimeFor.getText() + String.valueOf(Film5));
            window.setScene(FilmTimes);
        });




        //Positioning of elements
        GridPane.setConstraints(Film1Button, 120,10);
        GridPane.setConstraints(Film1, 5,10);
        GridPane.setConstraints(Film2Button, 120,20);
        GridPane.setConstraints(Film2, 5,20);
        GridPane.setConstraints(Film3Button, 120,30);
        GridPane.setConstraints(Film3, 5,30);
        GridPane.setConstraints(Film4Button, 120,40);
        GridPane.setConstraints(Film4, 5,40);
        GridPane.setConstraints(Film5Button, 120,50);
        GridPane.setConstraints(Film5, 5,50);
        GridPane.setConstraints(Date,150,0);



        //Add all contents to Grid
        grid.getChildren().addAll(Film1Button,Film2Button,Film3Button,Film4Button,Film5Button,Film1,Film2,Film3,Film4,Film5,Date);











        //Window 2



        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10,10,10,10)); //border
        grid2.setVgap(8);                                               //Spacing for elements
        grid2.setHgap(10);

        FilmTimes = new Scene(grid2,visualBounds.getWidth(),visualBounds.getHeight());


        Button HomeButton = new Button("Home");
        HomeButton.setPrefHeight(25);
        HomeButton.setPrefWidth(100);

        Button[] FilmTimes;

        FilmTimes = new Button[11];
        for (int i = 1; i <11; i++){
            FilmTimes[i] = new Button();
            FilmTimes[i].setPrefHeight(100);
            FilmTimes[i].setPrefWidth(200);
            grid2.getChildren().add(FilmTimes[i]);

        }

        GridPane.setConstraints(FilmTimes[1], 50,10);
        GridPane.setConstraints(FilmTimes[2], 50,20);
        GridPane.setConstraints(FilmTimes[3], 50,30);
        GridPane.setConstraints(FilmTimes[4], 50,40);
        GridPane.setConstraints(FilmTimes[5], 50,50);
        GridPane.setConstraints(FilmTimes[6], 60,10);
        GridPane.setConstraints(FilmTimes[7], 60,20);
        GridPane.setConstraints(FilmTimes[8], 60,30);
        GridPane.setConstraints(FilmTimes[9], 60,40);
        GridPane.setConstraints(FilmTimes[10], 60,50);

        FilmTimes[1].setText("9:00");
        FilmTimes[2].setText("11:00");
        FilmTimes[3].setText("13:00");
        FilmTimes[4].setText("15:00");
        FilmTimes[5].setText("17:00");
        FilmTimes[6].setText("18:00");
        FilmTimes[7].setText("19:00");
        FilmTimes[8].setText("20:00");
        FilmTimes[9].setText("21:00");
        FilmTimes[10].setText("22:00");







        HomeButton.setOnAction(e -> {
            window.setScene(HomeScreen);
            TimeFor.setText("");
        });




        GridPane.setConstraints(HomeButton, 1,0);
        GridPane.setConstraints(TimeFor, 50, 1);


        grid2.getChildren().addAll(HomeButton,TimeFor);





        //Display scene 1 at first
        window.setScene(HomeScreen);
        window.setTitle("Desktop Interface");
        window.show();







    }



    public void closeProgram(){ //Implement at a later date, stops user accidently closing program
        //boolean result = ConfirmBox.display("Exit", "Are you sure you want to exit");
        //System.out.println(result);


    }








}

