package coffeeShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
	
	public static final int PRINT_MENU = 1;
	public static final int ORDER_ITEM = 2;
	public static final int VIEW_CART = 3;
	public static final int EXIT = 4;
	//	this private member variable can only be accessed inside the CoffeeShop class
	private List<MenuItem> menuItems = new ArrayList<>();
	
	private List<MenuItem> cart = new ArrayList<>();
	
	//	all member variables are defined at the top of the file
	private Scanner scanner = new Scanner(System.in);
	
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
		
		menuItems.sort(new Comparator<MenuItem>(){
			@Override
			public int compare(MenuItem o1, MenuItem o2) {
				//	this sorts by price
				Double p1 = o1.getPrice();
				Double p2 = o2.getPrice();
				return p1.compareTo(p2);
				
				//	this sorts by name
				//	return o1.getName().compareTo(o2.getName());			}
			}
		});
	}
	
	public void printMenuItems() {
		System.out.println("Menu Items\tPrice\tQuantity In Stock");
		System.out.println("----------\t-----\t-----------------");

		for(MenuItem item : menuItems){
			System.out.println(item.getName() + "\t" + "$" +
			String.format("%.2f", item.getPrice()) + "\t" + 
					+ item.getInStock());
			}
		System.out.println("----------\t-----\t-----------------");		
		}
	
	public int menuPrompt() {
		System.out.println("Welcome to Colby's Coffee Shop");
		System.out.println(PRINT_MENU + ") Print Menu");
		System.out.println(ORDER_ITEM + ") Order Item");
		System.out.println(VIEW_CART + ") View Cart:");
		System.out.println(EXIT + ") Exit Coffee Shop");

		System.out.print("\nMake Selection: ");
		
		int selection = scanner.nextInt();
		scanner.nextLine();
		System.out.println("");
		
		//System.out.println("Opening menu "+selection);

		return selection;
		
	}
	
	public void orderItem() {
		printMenuItems();
		System.out.print("Enter item name: ");
		String itemName = scanner.nextLine();
		System.out.println(itemName);
		
		MenuItem selectedItem = findMenuItemByItemName(itemName);
		if(selectedItem != null) {
			System.out.println(itemName + " is valid");
			cart.add(selectedItem);
		}else {
			System.out.println(itemName + " is not a valid selection");
		}
	}
	
	//	this is a very common patter in software engineering---
	//	if the method returns null then the itemName was not found
	//	else if the method returns a MenuItemit was
	private MenuItem findMenuItemByItemName(String itemName) {
		if(itemName == null) {
			return null;
		}
		itemName = itemName.trim();
		for(MenuItem menuItem : menuItems) {
			if(menuItem.getName().equalsIgnoreCase(itemName)) {
				return menuItem;
				
			}
		}
		return null;
	}
	
	public void viewCart() {
		double totalPrice = 0.0;
		System.out.println(cart.size() + " item(s) in your cart: \n");
		System.out.println("Item Name\tPrice\t");
		System.out.println("----------\t-----");
		for(MenuItem item : cart) {
			System.out.println(item.getName() + "\t$" + 
			String.format("%.2f", item.getPrice()));
			totalPrice  = totalPrice + item.getPrice();
		}
		System.out.println("----------\t-----\t");
		System.out.println("Total Price:\t$" + String.format("%.2f", totalPrice));
		System.out.println("");
	}

}

