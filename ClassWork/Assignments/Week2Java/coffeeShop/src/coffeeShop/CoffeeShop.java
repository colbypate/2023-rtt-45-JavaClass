package coffeeShop;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
	
	//	this private member variable can only be accessed inside the CoffeeShop class
	private List<MenuItem> menuItems = new ArrayList<>();
	
	public void initialize() {
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setInStock(100);
		
		menuItems.add(item1);
		
		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(6.30);
		item2.setInStock(85);
		
		menuItems.add(item2);
		
		//	this creates a new menu item using the constructor
		MenuItem item3 = new MenuItem("Croissant", 5.99, 50);
		menuItems.add(item3);
		
		//	this does the same thing in one line of code
		menuItems.add(new MenuItem("Egg Sandwich", 8.50, 25));
		
	}
	
	public void printMenuItems() {
		System.out.println("Menu Items\tPrice\tQuantity In Stock");
		System.out.println("----------\t-----\t-----------------");

		for(MenuItem item : menuItems){
			System.out.println(item.getName() + "\t" + "$" +
			String.format("%.2f", item.getPrice()) + "\t" + 
					+ item.getInStock());
			}
		}

}

