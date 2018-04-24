/**
 * Film.java
 */

package sample;

/**
 * Class for ...
 *
 * @author Dan Aves
 */
public class Film {
  /** ID number of the film. */
  private int film_id;
  /** Name of the film. */
  private String film_name;
  /** Description of the film. */
  private String film_description;
  /** Runtime of the film. */
  private int film_runtime;
  /** Director of the film. */
  private String film_director;
  /** Age rating of the film. */
  private String film_age_rating;

	/**
	 * @return ID number of film.
	 */
	public int getFilm_id() {
		return film_id;
	}

	/**
	 * Sets new value of this.film_id.
	 * @param film_id ID number of film.
	 */
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	/**
	 * @return Name of film.
	 */
	public String getFilm_name() {
		return film_name;
	}

	/**
	 * Sets new value of this.film_name.
	 * @param film_name Name of film.
	 */
	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}

	/**
	 * @return Description of film.
	 */
	public String getFilm_description() {
		return film_description;
	}

	/**
	 * Sets new value of this.film_description.
	 * @param film_description Description of film.
	 */
	public void setFilm_description(String film_description) {
		this.film_description = film_description;
	}

	/**
	 * @return Runtime of film.
	 */
	public int getFilm_runtime() {
		return film_runtime;
	}

	/**
	 * Sets new value of this.film_runtime.
	 * @param film_runtime Runtime of film.
	 */
	public void setFilm_runtime(int film_runtime) {
		this.film_runtime = film_runtime;
	}

	/**
	 * @return Director of film.
	 */
	public String getFilm_director() {
		return film_director;
	}

	/**
	 * Sets new value of this.film_director.
	 * @param film_director Director of film.
	 */
	public void setFilm_director(String film_director) {
		this.film_director = film_director;
	}

	/**
	 * @return Age rating of film.
	 */
	public String getFilm_age_rating() {
		return film_age_rating;
	}

	/**
	 * Sets new value of this.film_age_rating.
	 * @param film_age_rating Age rating of film.
	 */
	public void setFilm_age_rating(String film_age_rating) {
		this.film_age_rating = film_age_rating;
	}

	/**
	 * @return String representation of Film for printing
	 */
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", film_name=" + film_name + ", film_description=" + film_description + ", film_runtime=" + film_runtime + ", film_director=" + film_director + ", film_age_rating=" + film_age_rating + "]";
	}
}
