package practiceAssignment;

import java.util.Arrays;

public class ArraysPractice {
	public static void main(String[] args) {
		ArraysPractice arrays = new ArraysPractice();
		arrays.problem1();
		arrays.problem2();
		arrays.problem3();
		arrays.problem4();
		arrays.problem5();

		}
	public void problem1() {
		int[] nums = {1, 2, 3};
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		System.out.println("\n");
	}
	
	public void problem2() {
		int[] nums = {13, 5, 7, 68, 2};
		int x = nums.length;
		double middle = x/2;
		middle = (int)Math.floor(middle);
		System.out.println(nums[(int)middle]+"\n");
	}
	public void problem3() {
		String[] colors = {"red", "green", "blue", "yellow"};
		System.out.println(colors.length);
		System.out.println(Arrays.toString(colors));
		String[] colors2 = colors.clone();
		System.out.println(Arrays.toString(colors2)+ "\n");
		
	}
	
	public void problem4() {
		//int[] nums = new int[5];
		int[] nums = {4, 45, 23, 82, 14};

		System.out.println(nums[0]);
		System.out.println(nums[4]+"\n");

		//System.out.println(nums[5]);
		
	}
	
	public void problem5() {
		int[] nums = new int[5];
		for(int i = 0; )
	}
	

}
