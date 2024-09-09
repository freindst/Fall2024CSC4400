package driver;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int[] input = new int[10];
		for (int i = 0; i < 10; i++) {
			input[i] = r.nextInt(10);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + input[i]);
		}
		int pos = LinearSearch(input, 7);
		if (pos >= 0) {
			System.out.println("7 is at the index of " + pos + " in input array.");
		} else {
			System.out.println("7 is not in input array.");
		}
	}
	
	// return -1 when there is no number in the arr matches target
	// return the 0-based index of the first number matching target
	public static int LinearSearch(int[] arr, int target) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		} 
		return -1;
	}

}
