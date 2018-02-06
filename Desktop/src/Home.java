import javafx.application.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Home extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        javafx.geometry.Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();



        //Button 1
        Label label1 = new Label("Film 1"); //Movie content from database
        Button button1 = new Button("Go to");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children laid out in vertical column
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(label1, button1);
        StackPane root = new StackPane();
        //scene1 = new Scene(layout1, 200, 200);
        scene1 = new Scene(layout1,visualBounds.getWidth(),visualBounds.getHeight());


        //Button 2
        Button button2 = new Button("Home");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,visualBounds.getWidth(),visualBounds.getHeight());

        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Desktop Interface");
        window.show();




    }



}

