

/**
*
* Simple representation of a seat.
*
*@author Mitchell Gladstone
*
*/

public class Seat {

    private char row ;
    private int col ;
    private boolean avalible

/**
*
* Creates Seat Object
*@param row - letter a-z representing row of seat
*@param collomn - number representing seat coloumn
*
*/

  public Seat(char row, int col){
        this.row = row;
        this.col= col;
        this.avalible = true;
    }




