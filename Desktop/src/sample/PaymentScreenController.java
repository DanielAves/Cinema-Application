package sample;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.text.DecimalFormat;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.io.IOException;

// import java.io.File;
//
// import com.itextpdf.text.DocumentException;
// import com.itextpdf.layout.element.Paragraph;
// import com.itextpdf.layout.element.Text;
// import com.itextpdf.kernel.pdf.PdfDocument;
// import com.itextpdf.kernel.pdf.PdfWriter;
// import com.itextpdf.layout.Document;




public class PaymentScreenController {

  @FXML
  private Label changeDue;

  @FXML
  public Text totalAmount;

  @FXML
  private Button five,ten,fithteen,twenty,thirty,forty,cash,card;

  @FXML
  private TextField quantity;

  double grandTotal;
  boolean cashBol = false;


  public void setTotal(double totalNew){
    grandTotal = totalNew;
    totalAmount.setText("Total £ " + String.format("%.2f", totalNew));
  }

  public void setSeats(List seats)
  {
    //System.out.println(seats.get(0));

  }


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

  public void cardClicked(ActionEvent event) throws InterruptedException{




    AlertBox.display("Please wait", "Processing payment");


    //System.out.println("Processing payment");
    // Thread.sleep(5000);
    // System.out.println("Test");
  }

  public void cashClicked(ActionEvent event) throws IOException{
    cashBol = true;
    System.out.println(cashBol);
  }

  public void quantityEntered(ActionEvent event) throws IOException{
    String input = quantity.getText();
    if (cashBol = true){
      grandTotal -= Double.parseDouble(input);
      change();
    }
  }

  public void fiveClicked(ActionEvent event) throws IOException{
    if (cashBol = true){
      grandTotal -=5;
      change();
    }
  }

  public void tenClicked(ActionEvent event) throws IOException{
    if (cashBol = true){
      grandTotal -=10;
      change();
    }
  }

  public void fithteenClicked(ActionEvent event) throws IOException{
    if (cashBol = true){
      grandTotal -=15;
      change();
    }
  }

  public void twentyClicked(ActionEvent event) throws IOException{
    if (cashBol = true){
      grandTotal -=20;
      change();
    }
  }

  public void thirtyClicked(ActionEvent event) throws IOException{
    if (cashBol = true){
      grandTotal -=30;
      change();
    }
  }

  public void fortyClicked(ActionEvent event) throws IOException{
    if (cashBol = true){
      grandTotal -=40;
      change();
    }
  }

  public void change(){
    if (grandTotal < 0){
      grandTotal = Math.abs(grandTotal);
      totalAmount.setText("Total £ " + ("0.00"));
      changeDue.setText("Change £ " + String.format("%.2f", grandTotal));



    }
    else{
      totalAmount.setText("Total £ " + String.format("%.2f", grandTotal));
    }
  }

  // public void createPdf(String dest) throws IOException
  // {
  //     PdfDocument pdfDocument = new PdfDocument(new PdfWriter(dest));
  //     pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
  //     Document document = new Document(pdfDocument);
  //     document.add(
  //         new Paragraph()
  //             .setFontSize(20)
  //             .add(new Text("This is your Reciept")));
  //     document.close();
  // }


}
