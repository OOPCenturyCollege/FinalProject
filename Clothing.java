package FinalPackage1;

public class Clothing extends Items{
	private double price;

	public Clothing(String name, double price) {
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
		return  name + "[ price=" + price + ", quantity=" + "]";
	} 
	
	

}

