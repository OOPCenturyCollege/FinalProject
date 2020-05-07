package FinalPackage2;

public class Items {
	private String name; 
	private double price;
	private int quantity;
	
	public Items(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return quantity * price; 
	}

	
	@Override
	public String toString() {
		return name + ", " + price + ", " + quantity;
	}
}
