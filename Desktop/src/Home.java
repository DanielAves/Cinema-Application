/**
 * Created by sc16da on 06/02/18.
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Home extends Application {

    @Override public void start(Stage primaryStage) {
        Button okButton = new Button("OK");
        okButton.setStyle("-fx-font: 22 arial;");

        okButton.setOnAction(event -> System.out.println("OK clicked!"));

        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(okButton);

        Scene scene = new Scene(pane, 250, 85);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button3");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}