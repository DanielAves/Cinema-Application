package sample;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by sc16da on 22/02/18.
 */
public class dbConnection {

    public static ArrayList<Film> filmList = new ArrayList<Film>();
    public static ArrayList<Screening> screeningList = new ArrayList<>();


    public static void Open()throws ClassNotFoundException {


        Connection connection = null;

        try {
            // create a database connection
            Connection con = DriverManager.getConnection("jdbc:sqlite:app.db"); //jdbc:sqlite:Desktop/films.db - Dec10 pc, intellij
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //db.setConnection(con);

            ResultSet rs = statement.executeQuery("SELECT * FROM Film");
            while(rs.next()) {
                Film db = new Film();

                db.setFilmID(rs.getInt("film_id"));
                db.setFilmName(rs.getString("film_name"));
                db.setFilmDescription(rs.getString("film_description"));
                db.setFilmRuntime(rs.getInt("film_runtime"));
                db.setFilmDirector(rs.getString("film_director"));
                db.setFilmAgeRating(rs.getInt("film_age_rating"));
                filmList.add(db);
            }

            System.out.println(filmList.get(8).getFilmName());

            ResultSet rst = statement.executeQuery("SELECT * FROM Screening");
            while(rs.next()){
                Screening db = new Screening();

                db.setScreeningID(rst.getInt("screening_id"));
                db.setScreeningTime(rst.getString("screening_time"));
                db.setScreeningDate(rst.getString("screening_date"));
                db.setFilmId(rst.getInt("film_id"));
                db.setScreenID(rst.getInt("screen_id"));
                screeningList.add(db);

                //Film db = new Film();

            }
            //List<Screening>

            System.out.println(screeningList.get(7).getScreeningTime());
            //System.out.println(screeningList.get(5).getScreeningDate());
        }
        catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

}
