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

	public boolean removeItem(Items r) {
		for (int i = 0; i < itemsCount; i++) {
			if (items[i] != null && items[i].equals(r)) {
				items[i] = items[itemsCount - 1];
				itemsCount--;
				return true;
			}

		}

		return false;
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
		String info = "Cart Summary: \n";
		double total = 0; 
		for(int i = 0; i < itemsCount; i++) {
			Items item = items[i]; 
			
			double itemTotal = item.getPrice() * item.getQuantity(); 
			
			info += item.getName() + "\t" 
			+ item.getPrice() + "\t" +item.getQuantity() 
			+ "\t" + itemTotal + "\n";
			
			total += itemTotal; 
			
		}
		
		info += "Total: " + total;
		
		return info; 
	}

	}


