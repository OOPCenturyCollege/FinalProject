package FinalPackage2;

import FinalPackage1.Items;

public class Electronics extends Items {
	private double price;
	private String name;

	//constructor
	public Electronics(String name, double price) {
		super(name, price);
		this.name = name;
		this.price = price;
	}
	
	//getters and setters
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return name + " | Price: $" + price;
	} 
}


