package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.text.DecimalFormat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class bookingScreenController {

    @FXML
    private ComboBox child,student,adult,vip;
    @FXML
    private Label childTotal,studentTotal,adultTotal,vipTotal,grandTotal;

    private static DecimalFormat df2 = new DecimalFormat(".##");

    double childTotal2,studentTotal2,adultTotal2,vipTotal2;

    Double grandTotal2 = 0.0;

    




    public void backButtonClicked(ActionEvent event) throws IOException {
        Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/filmScreen.fxml"));
        Scene filmScreen = new Scene(secondaryroot);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(filmScreen);
        window.show();

    }

    public void logoutButtonClicked(ActionEvent event) throws IOException{
        Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/loginScreen.fxml"));
        Scene filmScreen = new Scene(secondaryroot);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(filmScreen);
        window.show();

    }

    public void selectSeats(ActionEvent event) throws IOException{
        Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/seatingScreen.fxml"));
        Scene filmScreen = new Scene(secondaryroot);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(filmScreen);
        window.show();
    }

    public void comboBoxChild(ActionEvent event) throws IOException{
        String amount = child.getValue().toString();
        double childTotal2 = Double.parseDouble(amount) *6.00;
        childTotal.setText("Total   £ "+ String.format("%.2f",childTotal2));
        grandTotal(vipTotal2, adultTotal2, studentTotal2, childTotal2);
    }
    public void comboBoxStudent(ActionEvent event) throws IOException {
        String amount = student.getValue().toString();
        Double studentTotal2 = Double.parseDouble(amount) *7.50;
        studentTotal.setText("Total   £ "+ String.format("%.2f",studentTotal2));
        grandTotal(vipTotal2, adultTotal2, studentTotal2, childTotal2);
    }
    public void comboBoxAdult(ActionEvent event) throws IOException{
        String amount = adult.getValue().toString();
        Double adultTotal2 = Double.parseDouble(amount) *8.00;
        adultTotal.setText("Total   £ "+ String.format("%.2f",adultTotal2));
        grandTotal(vipTotal2, adultTotal2, studentTotal2, childTotal2);

    }
    public void comboBoxVip(ActionEvent event) throws IOException{
        String amount = vip.getValue().toString();
        Double vipTotal2 = Double.parseDouble(amount) *10.00;
        vipTotal.setText("Total   £ "+ String.format("%.2f",vipTotal2));
        grandTotal(vipTotal2, adultTotal2, studentTotal2, childTotal2);

    }

    public void grandTotal(Double vipTotal2, Double adultTotal2, double studentTotal2, double childTotal2){

        grandTotal2 += childTotal2;
        grandTotal2 += studentTotal2;
        grandTotal2 += adultTotal2;
        grandTotal2 += vipTotal2;
        grandTotal.setText("Total   £ " + String.format("%.2f", grandTotal2));


    }









    public void initialize() {
        child.getItems().addAll(1,2,3,4);
        student.getItems().addAll(1,2,3,4);
        adult.getItems().addAll(1,2,3,4);
        vip.getItems().addAll(1,2,3,4);











    }


}
