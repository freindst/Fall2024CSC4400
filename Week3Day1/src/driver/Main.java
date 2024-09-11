package driver;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int[] input = new int[10];
		int curIndex = 0;
		int range = 10;
		while (curIndex < input.length) {
			int newInt = r.nextInt(range * (curIndex + 1));
			if (curIndex == 0) {
				input[curIndex] = newInt;
				curIndex++;
			} else if (newInt >= input[curIndex - 1]) {
				input[curIndex] = newInt;
				curIndex++;
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + input[i]);
		}
		int randomPosition = r.nextInt(10);
		int numberToSearch = input[randomPosition];
		int pos = BinarySearch(input, numberToSearch);
		if (pos >= 0) {
			System.out.println(numberToSearch + " is at the index of " + pos + " in input array.");
		} else {
			System.out.println(numberToSearch + " is not in input array.");
		}
		/*
		int pos = LinearSearch(input, 7);
		if (pos >= 0) {
			System.out.println("7 is at the index of " + pos + " in input array.");
		} else {
			System.out.println("7 is not in input array.");
		}*/
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
	
	// arr is in ascending order
	public static int BinarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		int mid;
		while (true)
		{
			mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			} else {
				if (mid == end) {
					return -1;
				} else if (arr[mid] < target) { //the mid value is smaller than target value, so we should search
					// for the second half;
					start = mid + 1;
					// keep compare mid and target
				} else {
					// the mid value is larger than the target, we should search the first half.
					end = mid - 1;
				}
			}
		}
	}

}
