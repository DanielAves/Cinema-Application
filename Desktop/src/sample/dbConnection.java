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
public class dbConnection{
    private Integer filmID;
    public void connection() throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");







        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:Desktop/films.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.


            ResultSet rs = statement.executeQuery("select * from Film");
            while(rs.next())
            {
                int film_id;

                // read the result set
                film_id = rs.getInt("film_id");
                System.out.println("film_name = " + rs.getString("film_name"));


            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }





    }
    public void setFilmID(Integer film_id){
        this.filmID = film_id;
    }
    public Integer getfilmID() {
        return filmID;
    }














}
