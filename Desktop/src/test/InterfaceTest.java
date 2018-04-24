package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.matcher.control.LabeledMatchers.hasText;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testfx.api.FxAssert.verifyThat;



public class InterfaceTest extends ApplicationTest{


  @Override
  public void start (Stage stage) throws Exception {
    Parent mainNode = FXMLLoader.load(Main.class.getResource("resources/loginScreen.fxml"));
    stage.setScene(new Scene(mainNode));
    stage.show();
    stage.toFront();
  }

  @Before
  public void setUp () throws Exception {
  }

  @After
  public void tearDown () throws Exception {
    FxToolkit.hideStage();
    release(new KeyCode[]{});
    release(new MouseButton[]{});
  }

  @Test
  public void Test1InvalidLogin () {
    clickOn("#username");
    write("This is a test!");
    clickOn("#passwordField");
    write("This is a test!");
    clickOn("#loginButton");
    verifyThat("#invalidDetails", hasText("Invalid details entered, try again"));
  }
  @Test
  public void Test2LoginButton() {
    verifyThat("#loginButton", hasText("Login"));
  }
  @Test
  public void Test3CorrectLogin() {
    clickOn("#username");
    write("user");
    clickOn("#passwordField");
    write("password");
    clickOn("#loginButton");
    sleep(1000);
    clickOn("#viewToday");
    sleep(7000);
  }

}
