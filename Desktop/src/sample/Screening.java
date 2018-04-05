package sample;
import java.time.LocalTime ;
import java.time.LocalDate ;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Screening {
  private int screening_id ;
  private int film_id;

  @JsonDeserialize(using = LocalTimeDeserializer.class)
  @JsonSerialize(using = LocalTimeSerializer.class)
  private LocalTime screening_time ;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate screening_date ;
  private int screen_id;



  @JsonProperty("screen")
  private void unpackScreenFromNextedObject(Map<String, String> screen) {
     this.screen_id = Integer.parseInt(screen.get("screen_id"));
  }


	/**
	* Default empty Screening constructor
	*/
	public Screening() {
		super();
	}

	/**
	* Default Screening constructor
	*/
	public Screening(int screening_id, int film_id, LocalTime screening_time, LocalDate screening_date, int screen_id) {
		super();
		this.screening_id = screening_id;
		this.film_id = film_id;
		this.screening_time = screening_time;
		this.screening_date = screening_date;
		this.screen_id = screen_id;
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

	/**
	* Returns value of screen_id
	* @return
	*/
	public int getScreen_id() {
		return screen_id;
	}

	/**
	* Sets new value of screen_id
	* @param
	*/
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}

	/**
	* Create string representation of Screening for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Screening [screening_id=" + screening_id + ", film_id=" + film_id + ", screening_time=" + screening_time + ", screening_date=" + screening_date + ", screen_id=" + screen_id + "]";
	}
}
