
public class Tops extends Items {
	private double price;
	private int quantity;
	private String name;
	
	public Tops(String name, double price, int quantity) {
		super(name, price, quantity);
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
	@Override
	public String toString() {
		return "[Name=" + name + " | Price=" + price + " | Quantity=" + quantity + "]";
	} 
	
	

}
