package FinalPackage2;

public class Electronics extends Items {
	private double price;
	private String name;
	private int quantity;
	
	//constructor
	public Electronics(String name, double price, int quantity) {
		super(name, price, quantity);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	@Override
	public String toString() {
		return name + ", " + price;
	} 
}
