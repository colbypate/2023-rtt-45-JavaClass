package practiceAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysPractice {
	public static void main(String[] args) {
		ArraysPractice arrays = new ArraysPractice();
		arrays.problem1();
		arrays.problem2();
		arrays.problem3();
		arrays.problem4();
		arrays.problem5();
		arrays.problem6();
		arrays.problem7();
		arrays.problem8();
		arrays.problem9();
		arrays.problem10();
		arrays.problem11();



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
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
	}
	
	public void problem6() {
		int[] nums = new int[5];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i*2;
		}
	}
	
	public void problem7() {
		int[] nums = new int[5];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i;
			if(i != 2) {
				System.out.println(nums[i]);
			}
			}
	}
	
	public void problem8() {
		int[] nums = new int[5];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i;
			}
		int temp = nums[0];
		nums[0] = nums[2];
		nums[2] = temp;
		System.out.println(Arrays.toString(nums));
		
	}
	
	public void problem9() {
		int[] nums = {4, 2, 9, 13, 1, 0};
		Arrays.sort(nums);
		System.out.println("Array in ascending order: " + Arrays.toString(nums));
		System.out.println("Smallest number: " + nums[0]);
		System.out.println("Largest number: " + nums[nums.length-1]);

	}
	
	public void problem10() {
		Object[] arr = {"Large", "Cheese", "Pizza", 12.99};
		System.out.println(Arrays.toString(arr));
	}
	
	public void problem11() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many favorite foods do you have?");
		int num = scanner.nextInt();
		scanner.nextLine();
		Object[] favs = new Object[num];
		for(int i = 0; i < num; i++) {
			//String var = scanner.nextLine();
			System.out.println("Enter favorite food #"+(i+1)+": ");
			String var = scanner.nextLine();
			favs[i] = var;
		}
		System.out.println("Your fav foods are: " + Arrays.toString(favs).replace("[","").replace("]",""));
	}
}
