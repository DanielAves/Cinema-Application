package sample;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class Ticket {
  private int ticket_id ;
  private int customer_id ;
  private int screening_id ;
  private int seat_id;





	/**
	* Default empty Ticket constructor
	*/
	public Ticket() {
		super();
	}

	/**
	* Default Ticket constructor
	*/
	public Ticket(int customer_id, int screening_id, int seat_id) {
		super();
		this.ticket_id = 0;
		this.customer_id = customer_id;
		this.screening_id = screening_id;
		this.seat_id = seat_id;
	}


	/**
	* Returns value of ticket_id
	* @return
	*/
  @JsonIgnore
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	* Sets new value of ticket_id
	* @param
	*/
  @JsonIgnore
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	* Returns value of customer_id
	* @return
	*/
	public int getCustomer_id() {
		return customer_id;
	}

	/**
	* Sets new value of customer_id
	* @param
	*/
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	/**
	* Returns value of screening_id
	* @return
	*/
	public int getScreening_id() {
		return screening_id;
	}

	/**
	* Sets new value of screening_id
	* @param
	*/
	public void setScreening_id(int screening_id) {
		this.screening_id = screening_id;
	}

	/**
	* Returns value of seat_id
	* @return
	*/
	public int getSeat_id() {
		return seat_id;
	}

	/**
	* Sets new value of seat_id
	* @param
	*/
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	/**
	* Create string representation of Ticket for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", customer_id=" + customer_id + ", screening_id=" + screening_id + ", seat_id=" + seat_id + "]";
	}
}
