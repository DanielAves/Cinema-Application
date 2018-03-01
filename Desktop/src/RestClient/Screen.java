import java.util.Map;

public class Screen extends Resource {

  private int screen_id;

  private int screen_capacity;


	/**
	* Returns value of screen_id
	* @return
	*/
	public int getScreen_id() {
		return screen_id;
	}

	/**
	* Sets new value of screen_id
	* @param
	*/
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}

	/**
	* Returns value of screen_capacity
	* @return
	*/
	public int getScreen_capacity() {
		return screen_capacity;
	}

	/**
	* Sets new value of screen_capacity
	* @param
	*/
	public void setScreen_capacity(int screen_capacity) {
		this.screen_capacity = screen_capacity;
	}

	/**
	* Create string representation of Screen for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Screen [screen_id=" + screen_id + ", screen_capacity=" + screen_capacity + "]";
	}
}
