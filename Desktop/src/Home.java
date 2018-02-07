import javafx.application.*;
import javafx.geometry.*;
import javafx.geometry.Insets;
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

        //Window 1

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10)); //border
        grid.setVgap(8);                                               //Spacing for elements
        grid.setHgap(10);

        javafx.geometry.Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();



        scene1 = new Scene(grid,visualBounds.getWidth(),visualBounds.getHeight());
        window.setScene(scene1);
        window.show();



        //Button 1
        Label label1 = new Label("Film 1"); //Movie content from database
        Button button1 = new Button("Go to");
        button1.setOnAction(e -> window.setScene(scene2));
        GridPane.setConstraints(button1, 10,0);
        grid.getChildren().addAll(button1,label1);

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //Window 2

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10,10,10,10)); //border
        grid2.setVgap(8);                                               //Spacing for elements
        grid2.setHgap(10);



        //Button 2
        Button button2 = new Button("Home");
        button2.setOnAction(e -> window.setScene(scene1));
        GridPane.setConstraints(button2, 1,0);
        grid2.getChildren().addAll(button2);



        scene2 = new Scene(grid2,visualBounds.getWidth(),visualBounds.getHeight());

        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Desktop Interface");
        window.show();




    }

    public void closeProgram(){ //Implement at a later date, stops user accidently closing program
        //boolean result = ConfirmBox.display("Exit", "Are you sure you want to exit");
        //System.out.println(result);


    }



}

