package coffeeShop;

public class CoffeeShopMain {

	public static void main(String[] args) {
	
		CoffeeShop cs = new CoffeeShop();
		cs.initialize();
		//cs.printMenuItems();
		//cs.menuPrompt();
		while(true) {
			int selection = cs.menuPrompt();
			if(selection == CoffeeShop.PRINT_MENU) {
				cs.printMenuItems();
			}if(selection == CoffeeShop.ORDER_ITEM) {
				cs.orderItem();
			}if(selection == CoffeeShop.VIEW_CART) {
				cs.viewCart();
			}if(selection == CoffeeShop.EXIT) {
				System.out.println("Thanks for stopping by. See you next time!");
				//	This tells the JVM to exit with a status code of successful
				System.exit(0);
			}
		}
	}


}
