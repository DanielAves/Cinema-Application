package sample;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
*Generic wrapper is used for object serialisation/deserialisation
*@author Mitchell Gladstone
*/

public class GenericWrapper<T> {

  private List<T> objects;

  private int num_results;

  private int total_pages;

  private int page;

	/**
	* Returns value of objects
	* @return
	*/
	public List<T> getObjects() {
		return objects;
	}

	/**
	* Sets new value of objects
	* @param
	*/
	public void setObjects(List<T> objects) {
		this.objects = objects;
	}

	/**
	* Returns value of num_results
	* @return
	*/
	public int getNum_results() {
		return num_results;
	}

	/**
	* Sets new value of num_results
	* @param
	*/
	public void setNum_results(int num_results) {
		this.num_results = num_results;
	}

	/**
	* Returns value of total_pages
	* @return
	*/
	public int getTotal_pages() {
		return total_pages;
	}

	/**
	* Sets new value of total_pages
	* @param
	*/
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	/**
	* Returns value of page
	* @return
	*/
	public int getPage() {
		return page;
	}

	/**
	* Sets new value of page
	* @param
	*/
	public void setPage(int page) {
		this.page = page;
	}
}
