package sample;

/**
 * Created by sc16da on 26/02/18.
 */
public class film {
    private static Integer filmID;
    private static String filmName;
    //public void connection() throws ClassNotFoundException{


    public void setFilmID(Integer film_id) {
        this.filmID = film_id;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmName(String film_name) {
        this.filmName = film_name;
    }

    public String getFilmName() {
        return filmName;
    }

}
