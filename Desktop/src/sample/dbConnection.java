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

    public static void Open()throws ClassNotFoundException{
        Connection connection = null;
        try
        {
            // create a database connection
            Connection con = DriverManager.getConnection("jdbc:sqlite:Desktop/films.db"); //jdbc:sqlite:Desktop/films.db - Dec10 pc, intellij
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            film db = new film();
            db.setConnection(con);


            ResultSet rs = statement.executeQuery("select * from Film");
            while(rs.next())
            {

                // read the result set
                db.setFilmID(rs.getInt("film_id"));
                db.setFilmName(rs.getString("film_name"));
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





}
















