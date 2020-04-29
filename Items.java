package FinalPackage1;

public class Items {
	public String name; 
	private double price;
	private int quantity;
	
	public Items(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		
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
		return "Items [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	

}
