package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sc16da on 26/02/18.
 */
public class film {

    private Connection con;
    public void setConnection(Connection con){
        this.con=con;
    }

    public void filmNames() throws ClassNotFoundException{
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select film_name from Film");

            System.out.println("film_name = " + rs.getString("film_name"));

        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }


    }






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
