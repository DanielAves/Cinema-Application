package sample;

/**
*Class that represents Seat
* @author Mitchell Gladstone
*/
public class Seat{

  private int seat_id;


  public int getSeat_id(){
    return this.seat_id;
  }

  public void setSeat_id(int id){
    this.seat_id = id;
  }

  public String toString(){
      return "Seat [id="+this.seat_id+"]";
  }

}
