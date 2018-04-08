package sample;
public class Film {
  private int film_id ;
  private String film_name ;
  private String film_description ;
  private int film_runtime ;
  private String film_director;
  private String film_age_rating;



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
	* Returns value of film_name
	* @return
	*/
	public String getFilm_name() {
		return film_name;
	}

	/**
	* Sets new value of film_name
	* @param
	*/
	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}

	/**
	* Returns value of film_description
	* @return
	*/
	public String getFilm_description() {
		return film_description;
	}

	/**
	* Sets new value of film_description
	* @param
	*/
	public void setFilm_description(String film_description) {
		this.film_description = film_description;
	}

	/**
	* Returns value of film_runtime
	* @return
	*/
	public int getFilm_runtime() {
		return film_runtime;
	}

	/**
	* Sets new value of film_runtime
	* @param
	*/
	public void setFilm_runtime(int film_runtime) {
		this.film_runtime = film_runtime;
	}

	/**
	* Returns value of film_director
	* @return
	*/
	public String getFilm_director() {
		return film_director;
	}

	/**
	* Sets new value of film_director
	* @param
	*/
	public void setFilm_director(String film_director) {
		this.film_director = film_director;
	}

	/**
	* Returns value of film_age_rating
	* @return
	*/
	public String getFilm_age_rating() {
		return film_age_rating;
	}

	/**
	* Sets new value of film_age_rating
	* @param
	*/
	public void setFilm_age_rating(String film_age_rating) {
		this.film_age_rating = film_age_rating;
	}

	/**
	* Create string representation of Film for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", film_name=" + film_name + ", film_description=" + film_description + ", film_runtime=" + film_runtime + ", film_director=" + film_director + ", film_age_rating=" + film_age_rating + "]";
	}
}
