package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sc16da on 26/02/18.
 */
public class Film {

    private Integer filmID;
    private String filmName;
    private String filmDescription;
    private Integer filmRuntime;
    private String filmDirector;
    private Integer filmAgeRating;


    public Integer getFilmID() { return filmID; }

    public void setFilmID(Integer film_id) {
        this.filmID = film_id;
    }


    public String getFilmName() { return filmName; }

    public void setFilmName(String film_name) { this.filmName = film_name; }


    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String film_description) {
        this.filmDescription = film_description;
    }


    public Integer getFilmRuntime() {
        return filmRuntime;
    }

    public void setFilmRuntime(Integer film_runtime) {
        this.filmRuntime = film_runtime;
    }


    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String film_director) {
        this.filmDirector = film_director;
    }


    public Integer getFilmAgeRating() {
        return filmAgeRating;
    }

    public void setFilmAgeRating(Integer film_age_rating) {
        this.filmAgeRating = film_age_rating;
    }




//    private Connection con;
//    public void setConnection(Connection con){
//        this.con=con;
//    }
//
//    public void filmNames() throws ClassNotFoundException {
//        try {
//            Statement statement = con.createStatement();
//            statement.setQueryTimeout(30);  // set timeout to 30 sec.
//            ResultSet rs = statement.executeQuery("select film_name from Film");
//
//            System.out.println("film_name = " + rs.getString("film_name"));
//        }
//        catch(SQLException e) {
//            // if the error message is "out of memory",
//            // it probably means no database file is found
//            System.err.println(e.getMessage());
//        }
//    }

}
