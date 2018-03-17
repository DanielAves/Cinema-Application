import java.time.LocalDate ;
public class Customer {
  private int customer_id ;
  private String customer_f_name ;
  private String  customer_s_name ;
  private LocalDate customer_dob;
  private String customer_mobile ;
  private String customer_address;
  private String customer_postcode;





	/**
	* Default empty Customer constructor
	*/
	public Customer() {
		super();
	}

	/**
	* Default Customer constructor
	*/
	public Customer(int customer_id, String customer_f_name, String customer_s_name, LocalDate customer_dob, String customer_mobile, String customer_address, String customer_postcode) {
		super();
		this.customer_id = customer_id;
		this.customer_f_name = customer_f_name;
		this.customer_s_name = customer_s_name;
		this.customer_dob = customer_dob;
		this.customer_mobile = customer_mobile;
		this.customer_address = customer_address;
		this.customer_postcode = customer_postcode;
	}

	/**
	* Returns value of customer_id
	* @return
	*/
	public int getCustomer_id() {
		return customer_id;
	}

	/**
	* Sets new value of customer_id
	* @param
	*/
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	/**
	* Returns value of customer_f_name
	* @return
	*/
	public String getCustomer_f_name() {
		return customer_f_name;
	}

	/**
	* Sets new value of customer_f_name
	* @param
	*/
	public void setCustomer_f_name(String customer_f_name) {
		this.customer_f_name = customer_f_name;
	}

	/**
	* Returns value of customer_s_name
	* @return
	*/
	public String getCustomer_s_name() {
		return customer_s_name;
	}

	/**
	* Sets new value of customer_s_name
	* @param
	*/
	public void setCustomer_s_name(String customer_s_name) {
		this.customer_s_name = customer_s_name;
	}

	/**
	* Returns value of customer_dob
	* @return
	*/
	public LocalDate getCustomer_dob() {
		return customer_dob;
	}

	/**
	* Sets new value of customer_dob
	* @param
	*/
	public void setCustomer_dob(LocalDate customer_dob) {
		this.customer_dob = customer_dob;
	}

	/**
	* Returns value of customer_mobile
	* @return
	*/
	public String getCustomer_mobile() {
		return customer_mobile;
	}

	/**
	* Sets new value of customer_mobile
	* @param
	*/
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}

	/**
	* Returns value of customer_address
	* @return
	*/
	public String getCustomer_address() {
		return customer_address;
	}

	/**
	* Sets new value of customer_address
	* @param
	*/
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	/**
	* Returns value of customer_postcode
	* @return
	*/
	public String getCustomer_postcode() {
		return customer_postcode;
	}

	/**
	* Sets new value of customer_postcode
	* @param
	*/
	public void setCustomer_postcode(String customer_postcode) {
		this.customer_postcode = customer_postcode;
	}

	/**
	* Create string representation of Customer for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_f_name=" + customer_f_name + ", customer_s_name=" + customer_s_name + ", customer_dob=" + customer_dob + ", customer_mobile=" + customer_mobile + ", customer_address=" + customer_address + ", customer_postcode=" + customer_postcode + "]";
	}
}
