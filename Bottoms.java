
public class Bottoms extends Items{
	private double price;
	private String name;
	private int quantity;
	public Bottoms(String name, double price, int quantity) { // idea - i think we should get rid of the quantity and replace it with gender for the products
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
