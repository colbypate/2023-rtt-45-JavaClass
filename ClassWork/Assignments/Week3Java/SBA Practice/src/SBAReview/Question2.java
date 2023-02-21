package SBAReview;

public class Question2 {

	// position : 0 1 2 3 4 5
	// values : a b c d e f
	private static final int ARRAY_SIZE = 5;

	private int[] array;

	public static void main(String[] args) {
			//	we need to create a one based data structure for an array of size 5
			//	(arrays are 0 based)
			Question2 q2 = new Question2();
			

			int[] avg = {1, 2, 3, 4, 5, 6, 7};
			q2.calculateAverage(avg);
			q2.setValue(4);
			//	 print first message setting value
			q2.setValue(5);
			//	print first message setting value
			q2.setValue(4);
			//	print second message because its already been changed
			q2.move(50, 3);
			// print first message
			q2.move(30, 3);
			// print second message
			q2.move(30, 4);
			// print second message
	
		}
	Question2(){
		
		
		//	the key to this is to ignore the 0 element of the array
		array = new int[ARRAY_SIZE + 1];
		//	initialize this entire array to a value... -1
		
		for(int i = 1; i < array.length; i++) {
			array[i] = -1;
			System.out.println(array[i]);
		}
	}

	public void calculateAverage(int[] arr) {
		// calculate the average
		// decimal format this using %.2f
		// print out a message using system.out.format with the average
		// include a new line character at the end of the message
	}

	public void setValue(int index) {
		// if the value at index == -1 print a message saying that
		// you set the value and what it is and set the value
		// otherwise print a message saying that it was already changed
		//array[index]
	}
	
	public void move(int value, int id) {
		//	if the vale at array[id] == -1 then print a message saying "value with 
		//	id: {id} is moved to {value}"and set the value to 1
		//	otherwise print a message saying"value is already 1"
	}

}
