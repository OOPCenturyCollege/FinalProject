package FinalPackage2;

import FinalPackage1.Items;

public class Electronics extends Items {
	private double price;

	
	public Electronics(String name, double price) {
		super(name, price);
		this.price = price;

	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + " [price=" + price +"]";
	} 
	
	

}

