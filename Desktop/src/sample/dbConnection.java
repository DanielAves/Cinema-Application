package sample;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by sc16da on 22/02/18.
 */
public class dbConnection {
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
















