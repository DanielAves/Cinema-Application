
import java.util.GregorianCalendar;

/**
*
* Simple representation of a film's screening.
*
*@author Mitchell Gladstone
*
*/

public class Screening extends Film {

private GregorianCalendar dateAndTime ;
private  int screen ;
/**
*
* Creates Screening Object
*@param title - title of film
*@param synopsis - brief overview of film
*@param int year, int month, int dayOfMonth, int hourOfDay, int minute, int second - used to make calender object representing time of screening
*
*/

public Screening (String title , String synopsis, int year, int month, int dayOfMonth, int hourOfDay, int minute, int second){
    
    super(title , synopsis);
    dateAndTime = new GregorianCalendar(year,month,dayOfMonth,hourOfDay,minute,second);

}

}


