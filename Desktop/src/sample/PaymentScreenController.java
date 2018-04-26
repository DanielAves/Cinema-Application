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
import java.util.Hashtable;

import java.io.IOException;
import java.io.*;
import java.awt.image.BufferedImage;

import java.io.FileOutputStream;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;

import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import javax.imageio.ImageIO;

/**
*
*
* The payment screen simulates card and cash payment for the till operator.
* The total amount payable is passed into the class to be used.

*
* @author Dan Aves,Matt Cutts
* @version 1.1 (2018-04-22)
*/


public class PaymentScreenController {

  /** Path to the resulting PDF file. */
  public static final String CARD = "/cardReciept.pdf";
  public static final String CASH = "/cashReciept.pdf";

  //FXML element importing
  @FXML
  private Label changeDue;
  @FXML
  public Text totalAmount;
  @FXML
  private Button five,ten,fithteen,twenty,thirty,forty,cash,card;
  @FXML
  private TextField tender;

  double grandTotal;                    //Used to store passed total
  boolean cashBol = false;              //Used to determine if user selects "cash"
  List seatsPayment = new ArrayList();  //Local list to store seats passed to method
  int screenIDLocal;                    //Stores passed screenID
  String  cardReciept = "cardReciept.pdf";
  String  cashReciept = "cashReciept.pdf";

  String filmname;        //name of the film
  String ticketType = "adult";      //i.e child, adult etc
  int ticktPrice = 12 ;         //price of individual ticket
  int transTotal = 12;        //totl of all tickets
  int items = 1;              //number of tickets sold
  String screen = "Screen 12";    //screen
  int screenTime;                 //time of viewing
  int seatNum = 12;


  /**
  * This method sets the local variable grandTotal to the passed total from
  * seatingScreenController.
  * @param totalNew.
  * @return Nothing.
  */
  public void setTotal(double total){
    grandTotal = total;
    totalAmount.setText("Total £ " + String.format("%.2f", total));
  }

  /**
  * This method updates the local list for the passed seats
  * @param seats.
  * @return Nothing.
  */
  public void setSeats(List seats)
  {
    seatsPayment = seats;
  }

  /**
  * This method updates the local screenID for the passed ID dependent on
  * previous selections.
  * @param screenID.
  * @return Nothing.
  */
  public void setScreenID(int screenID){
    screenIDLocal = screenID; //Update local version for access in other functions
  }


  public void backButtonClicked(ActionEvent event) throws IOException {
    Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/filmScreen.fxml"));
    Scene filmScreen = new Scene(secondaryroot);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(filmScreen);
    window.show();

  }

  public void logoutButtonClicked(ActionEvent event) throws IOException{
    Parent secondaryroot = FXMLLoader.load(getClass().getResource("resources/homeScreen.fxml"));
    Scene filmScreen = new Scene(secondaryroot);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(filmScreen);
    window.show();

  }

  public void cardClicked(ActionEvent event) throws Exception{
    AlertBox.display("Please wait", "Processing payment");
    card.setStyle("-fx-background-color: #4286f4");
    totalAmount.setText("Total £ " + ("0.00"));
    bookSeats();
    createCardPDF(cardReciept);
  }

  public void bookSeats() throws Exception{
    RestClient client = new RestClient("localhost", 5000);
    // create screening obj for appropriate screening
    int seatsPaymentSize = seatsPayment.size();
    //Loop through seat array
    for(int i =0; i<seatsPaymentSize; i++)
    {
      Screening screening = client.getScreening(screenIDLocal);
      //create seat obj for appropraite seat
      Seat seat = client.getSeat(Integer.parseInt(seatsPayment.get(i).toString()));
      //till is customer 5
      Customer c = new Customer(5);
      //Create a ticket for each seat
      client.createTicket(c,screening,seat);
    }

  }


  public List getSeats(){

    return seatsPayment;
  }


  public int getScreenID(){

    return screenIDLocal;
  }

  public void cashClicked(ActionEvent event) throws Exception{
    cashBol = true;
    cash.setStyle("-fx-background-color: #4286f4");
  }

  public void tenderEntered(ActionEvent event) throws Exception{
    String input = tender.getText();
    if (cashBol == true){
      grandTotal -= Double.parseDouble(input);
      change();
    }
  }

  public void fiveClicked(ActionEvent event) throws Exception{
    if (cashBol == true){
      grandTotal -=5;
      change();
    }
  }

  public void tenClicked(ActionEvent event) throws Exception{
    if (cashBol == true){
      grandTotal -=10;
      change();
    }
  }

  public void fithteenClicked(ActionEvent event) throws Exception{
    if (cashBol == true){
      grandTotal -=15;
      change();
    }
  }

  public void twentyClicked(ActionEvent event) throws Exception{
    if (cashBol == true){
      grandTotal -=20;
      change();
    }
  }

  public void thirtyClicked(ActionEvent event) throws Exception{
    if (cashBol == true){
      grandTotal -=30;
      change();
    }
  }

  public void fortyClicked(ActionEvent event) throws Exception{
    if (cashBol == true){
      grandTotal -=40;
      change();
    }
  }

  public void change() throws Exception{
    if (grandTotal < 0){
      grandTotal = Math.abs(grandTotal);
      totalAmount.setText("Total £ " + ("0.00"));
      changeDue.setText("Change £ " + String.format("%.2f", grandTotal));
      bookSeats();
      createCashPDF(cashReciept);
    }
    else if (grandTotal == 0.0){
        totalAmount.setText("Total £ " + ("0.00"));
        changeDue.setText("");
        bookSeats();
    }
    else{
      totalAmount.setText("Total £ " + String.format("%.2f", grandTotal));
    }
  }

  private void createCardPDF(String cardReciept) throws DocumentException, IOException {

    File file = new File(CARD);
    file.getParentFile().mkdirs();
    generateQr("Hello");
    //create a document
    Document document = new Document();
    //create an instance for it to be generated
    PdfWriter.getInstance(document, new FileOutputStream(cardReciept));
    document.open();
    document.add(new Paragraph("Osprey Cinema"));
    document.add(new Paragraph("University Of Leeds Union"));
    document.add(new Paragraph("Leeds\n\n"));
    document.add(new Paragraph(filmname + "                  " + "£" + ticktPrice + "\n\n"));
    document.add(new Paragraph("**** **** **** 6190"));
    document.add(new Paragraph("Visa Debit "));
    document.add(new Paragraph("Merchant ID: **12345 \n Terminal ID: ****1234  \n\n"));
    document.add(new Paragraph("SALE \n\n"));
    document.add(new Paragraph("Your account will be debited with the total amount shown: \n Total: " + "AMOUNT \n"));
    document.add(new Paragraph("Number of items: " + items + "\n\n"));
    document.add(new Paragraph("SOURCE:     CONTACTLESS \n\n"));
    document.add(new Paragraph("Authorisation Code: 12387 \n\n"));
    document.add(new Paragraph("Please keep this reciept for your records. \n\n"));
    document.add(new Paragraph("CUSTOMER COPY \n\n"));
    document.add(new Paragraph("T O T A L " + "           " + grandTotal + "\n\n"));
    document.add(new Paragraph("Thank you for visiting Britains Best Cinema Experience"));
    document.add(new Paragraph("#OspreyCinemaWhereExcitingHappens\n\n"));
    document.add(new Paragraph("Tell us how we did by sending us an email\n with the chance to win £100. \n Eamil: ukoc@OSPREYCinema.com \n"));
    Image QR = Image.getInstance("ticket.png");
    QR.setAlignment(Image.MIDDLE);
    document.add(QR);
    document.close();
  }

  private void createCashPDF(String cashReciept) throws DocumentException, IOException {

    File file = new File(CASH);
    file.getParentFile().mkdirs();
    //create a document
    Document document = new Document();
    generateQr("Hello");
    //create an instance for it to be generated
    PdfWriter.getInstance(document, new FileOutputStream(cashReciept));
    document.open();
    document.add(new Paragraph("Osprey Cinema"));
    document.add(new Paragraph("University Of Leeds Union"));
    document.add(new Paragraph("Leeds\n\n"));
    document.add(new Paragraph(filmname + "                  " + "£" + ticktPrice + "\n\n"));
    document.add(new Paragraph("Cash Payment "));
    document.add(new Paragraph("Merchant ID: **12345 \n Terminal ID: ****1234  \n\n"));
    document.add(new Paragraph("SALE \n\n"));
    document.add(new Paragraph("You have been charged: \n Total: " + "AMOUNT \n"));
    document.add(new Paragraph("Number of items: " + items + "\n\n"));
    document.add(new Paragraph("SOURCE:     CASH\n\n"));
    document.add(new Paragraph("Authorisation Code: 12387 \n\n"));
    document.add(new Paragraph("Please keep this reciept for your records. \n\n"));
    document.add(new Paragraph("CUSTOMER COPY \n\n"));
    document.add(new Paragraph("T O T A L " + "           " + transTotal + "\n\n"));
    document.add(new Paragraph("Thank you for visiting Britains Best Cinema Experience"));
    document.add(new Paragraph("#OspreyCinemaWhereExcitingHappens\n\n"));
    document.add(new Paragraph("Tell us how we did by sending us an email\n with the chance to win £100. \n Eamil: ukoc@OSPREYCinema.com \n"));
    Image QR = Image.getInstance("ticket.png");
    QR.setAlignment(Image.MIDDLE);
    document.add(QR);
    document.close();
  }

  private static void generateQr(String text){
      File file = new File("ticket.png");
      Hashtable hash = new Hashtable();
      //works out size of string and creates the error correct level
      hash.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
      QRCodeWriter codewriter = new QRCodeWriter();
      //creates the QR matrix
      try {
          BitMatrix matrix = codewriter.encode(text, BarcodeFormat.QR_CODE,500,500,hash);
          //creates the specific image file
          BufferedImage code = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
          code.createGraphics();
          //Creates the white background
          Graphics2D colours = (Graphics2D)code.getGraphics();
          colours.setColor(Color.white);
          colours.fillRect(0,0,500,500);
          colours.setColor(Color.BLACK);
          //creates each pixel of the QR code
          for(int i = 0 ; i<500;i++){
              for(int j = 0; j < 500;j++){
                  if (matrix.get(i,j)){
                      colours.fillRect(i,j,1,1);
                  }
              }
          }
          //creates an image with a png file type
          ImageIO.write(code,"png",file);

      } catch (WriterException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
