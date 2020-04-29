package FinalPackage1;

public class Customer {
	private String name;
	private String lname;
	private String address; 
	private String city; 
	private String state; 
	private String email; 
	private int zipcode; 
	private int accountNumber;
	
	public Customer(String name, String lname, String address, String city, String state, String email, int zipcode,
			int accountNumber) {
		super();
		this.name = name;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zipcode = zipcode;
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "\nCustomer" + "\n name: " + name + " last name: " + lname + " \n address: " + address + "\n city: " + city + "\n state: "
				+ state + "\n email: " + email + " \n zipcode: " + zipcode + "\n accountNumber: " + accountNumber + "";
	} 
	
	
	
	

}
