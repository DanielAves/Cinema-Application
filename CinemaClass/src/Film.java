
/**
*
* Simple representation of a film.
*
*@author Mitchell Gladstone
*
*/

public class Film {
    
    private String title;

    private String synopsis;


/**
*
* Creates Film Object
*@param title - title of film
*@param synopsis - brief overview of film
*
*/

    public Film(String title , String synopsis){
        this.title = title;
        this.synopsis= synopsis;
    }

/**
*
* Get method that returns title of film object
* @return - title of film
*
*/
    public String getTitle() {
        return title ;
    }

/**
*
* Get method that returns title of film object
* @return - title of film
*
*/

    public String getSynopsis() {
        return synopsis ;
    }


}
