package libraryAssignment;


public class LibraryInterfaceDemo{

	public static void main(String[] args) {
		KidUser kid1 = new KidUser();
		KidUser kid2 = new KidUser();
		
		kid1.setAge(10);
		kid2.setAge(18);
		
		kid1.registerAccount();
		kid2.registerAccount();
		
		kid1.setBookType("Kids");
		kid2.setBookType("Fiction");
		
		AdultUser adult1 = new AdultUser();
		AdultUser adult2 = new AdultUser();
		
		adult1.setAge(5);
		adult2.setAge(23);
		
		adult1.registerAccount();
		adult2.registerAccount();
		
		adult1.setBookType("Kids");
		adult2.setBookType("Fiction");
	}

}
