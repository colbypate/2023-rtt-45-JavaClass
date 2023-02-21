package SBAReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {
	
	//	null means there was no object found so no memory is allocated for it
	//	empty means there is memory allocated for the object there's just nothing in it

	//	( x == null) is true
	//	(X.equals("")) will thrown an error
	//	(y.equlas("") is true
	//	(y == null) is false
	
	
	public static void main(String[] args) {
		// how to transfer an array into an array list
		
		String[] arr = {"zero", "one", "two", "three", "four", "five"};
		Question1 q1 = new Question1();
		q1.convert(arr);
		q1.replace(2);
		//	replaced two with the empty string
		q1.replace(4);
		//	replaced four with the empty string
		
		q1.compact();
		//	should print zero, one, three, five

		}
	private List<String> list = new ArrayList<String>();
	
//	public Question1() {
//		//	in the constructor create a new array list
//		ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
//
//
//	}
	
	//	know how to convert an array of strings to a list of strings
	public void convert(String[] arr) {
		//ArrayList<String> list = new ArrayList<>();
		for(String str : arr) {
			list.add(str);
			
		}
	}
	

	
	public void replace(int idx) {
		//	in an ArrayList write the value at idx to be an empty string
		//	print a message saying what the value of the position in the list is
		//	and the value you are overwriting it with
		
		String x = list.get(idx);
		list.set(idx, "");
		System.out.println(x + " is replaced at index "+ idx + " by an empty string");
		
		
	}

	public void compact(){
		//	remove all values in the array list that are empty strings
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("")) {
				list.remove(i);
			}
		}
		System.out.println(list.toString());
	}
}
