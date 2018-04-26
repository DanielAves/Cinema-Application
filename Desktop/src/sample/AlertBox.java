/**
 * AlertBox.java
 */

package sample;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.util.*;
import javafx.util.Duration;
import javafx.animation.*;

/**
 * Class for ...
 *
 * @author
 */
public class AlertBox {

  /**
   * [display description]
   * @param title   [description]
   * @param message [description]
   */
  public static void display(String title, String message) {

    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);

    Label label = new Label();
    label.setText(message);

    VBox layout = new VBox(10);
    layout.getChildren().addAll(label);
    layout.setAlignment(Pos.CENTER_LEFT);

    Scene scene = new Scene(layout);
    window.setScene(scene);

    window.show();

    PauseTransition delay = new PauseTransition(Duration.seconds(1));
    delay.setOnFinished( event -> label.setText("Processing payment.") );
    delay.play();
    PauseTransition delay2 = new PauseTransition(Duration.seconds(2));
    delay2.setOnFinished( event -> label.setText("Processing payment..") );
    delay2.play();
    PauseTransition delay3 = new PauseTransition(Duration.seconds(3));
    delay3.setOnFinished( event -> label.setText("Processing payment...") );
    delay3.play();
    PauseTransition delay4 = new PauseTransition(Duration.seconds(4));
    delay4.setOnFinished( event -> label.setText("Processing payment....") );
    delay4.play();

    PauseTransition delayClose = new PauseTransition(Duration.seconds(6));
    delayClose.setOnFinished( event -> window.close() );
    delayClose.play();
  }
}
