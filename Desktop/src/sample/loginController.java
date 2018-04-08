package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.TextField;

public class loginController{

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    String test = "user";
    String passwordStore = "password";


    public void loginButtonClicked(ActionEvent event) throws IOException {
        String uname = username.getText();
        String pass = password.getText();
        System.out.println(uname);
        System.out.println(pass);

 //       if (test.equals(uname) && passwordStore.equals(pass)) {
            Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/homeScreen.fxml"));
            Scene filmScreen = new Scene(secondaryroot);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(filmScreen);
            window.show();

    //    } else {
    //        System.out.println("Wrong credentials");
    //    }

    }
}
