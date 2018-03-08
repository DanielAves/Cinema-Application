import java.time.LocalTime ;
import java.time.LocalDate ;
public class Screening {
  private int screening_id ;
  private int film_id;
  private LocalTime screening_time ;
  private LocalDate screening_date ;



	/**
	* Default empty Screening constructor
	*/
	public Screening() {
		super();
	}

	/**
	* Default Screening constructor
	*/
	public Screening(int screening_id, int film_id, LocalTime screening_time, LocalDate screening_date) {
		super();
		this.screening_id = screening_id;
		this.film_id = film_id;
		this.screening_time = screening_time;
		this.screening_date = screening_date;
	}

	/**
	* Create string representation of Screening for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Screening [screening_id=" + screening_id + ", film_id=" + film_id + ", screening_time=" + screening_time + ", screening_date=" + screening_date + "]";
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
	* Returns value of film_id
	* @return
	*/
	public int getFilm_id() {
		return film_id;
	}

	/**
	* Sets new value of film_id
	* @param
	*/
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	/**
	* Returns value of screening_time
	* @return
	*/
	public LocalTime getScreening_time() {
		return screening_time;
	}

	/**
	* Sets new value of screening_time
	* @param
	*/
	public void setScreening_time(LocalTime screening_time) {
		this.screening_time = screening_time;
	}

	/**
	* Returns value of screening_date
	* @return
	*/
	public LocalDate getScreening_date() {
		return screening_date;
	}

	/**
	* Sets new value of screening_date
	* @param
	*/
	public void setScreening_date(LocalDate screening_date) {
		this.screening_date = screening_date;
	}
}
