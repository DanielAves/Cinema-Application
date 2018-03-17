package sample;

/**
 * Created by sc16da on 28/02/18.
 */
public class Screening {

//
//    public Screening(Integer screeningID, Integer screeningTime, String screeningDate, Integer filmId, Integer screenID) {
//        this.screeningID = screeningID;
//        ScreeningTime = screeningTime;
//        ScreeningDate = screeningDate;
//        FilmId = filmId;
//        ScreenID = screenID;
//    }

    private Integer screeningID;
    private String ScreeningTime;
    private String ScreeningDate;
    private Integer FilmID;
    private Integer ScreenID;

    public Integer getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(Integer screening_id) {
        this.screeningID = screening_id;
    }


    public String getScreeningTime() {
        return ScreeningTime;
    }

    public void setScreeningTime(String screening_time) {
        ScreeningTime = screening_time;
    }

    public String getScreeningDate() {
        return ScreeningDate;
    }

    public void setScreeningDate(String screening_date) {
        ScreeningDate = screening_date;
    }

    public Integer getFilmID() {
        return FilmID;
    }

    public void setFilmID(Integer film_id) {
        FilmID = film_id;
    }

    public Integer getScreenID() {
        return ScreenID;
    }

    public void setScreenID(Integer screen_id) {
        ScreenID = screen_id;
    }





}
