package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Logger;

public class seatingScreenController {

  double totalNew;

  public void setTotal(double grandTotal2){
    System.out.println(grandTotal2);
    totalNew = grandTotal2;
  }
    public void payClicked(ActionEvent event)throws IOException{
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("resources/PaymentScreen.fxml"));
        try{
            Loader.load();
        }catch (IOException ex){
            Logger.getLogger(filmScreenController.class.getName());
        }

        PaymentScreenController total = Loader.getController();
        total.setTotal(totalNew);

        Parent p = Loader.getRoot();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(p));
        window.show();
    }


}
