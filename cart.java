package FinalPackage1;


public class Cart {
	
	private Items[] items;
	private int itemsCount;

	public Cart(int size) {
		items = new Items[size];
		itemsCount = 0;
	}

	public void add(Items i) {
		items[itemsCount++] = i;
	}


	public Items[] getItems() {
		return items;
	}

	public void setItem(Items[] it) {
		this.items = it;
	}

	public int getItemCount() {
		return itemsCount;
	}

	public void setProduceCount(int itemCount) {
		this.itemsCount = itemCount;
	}

	@Override
	public String toString() {
		String info = " Cart Summary \n";
		double total = 0.00; 
		for(int i = 0; i < itemsCount++; i++) {
			Items item = items[i]; 
			
			info += item.getName() + "\t" 
			+ item.getPrice() + "\t" +item.getQuantity() 
			+ "\t" + item.getTotal() + "\n";
			
			total += item.getTotal(); 
		}
		info += " Total: $" + String.format("%.2f",total) +"\n";
		return info; 
	}
	}
