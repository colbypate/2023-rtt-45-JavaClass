package coffeeShop;

public class MenuItem {
	
	private String name;
	private double price;
	private int inStock;
	// default constructor
	public MenuItem() {
		
		
	}
	
	// constructor that takes two parameters
	public MenuItem(String name, double price, int inStock) {
		this.name = name;
		this.price = price;
		this.inStock = inStock;
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
	
	public int getInStock() {
		return inStock;
	}
	
	public void setInStock(int inStock) {
		this.inStock = inStock;
		
	}
	
	
}
