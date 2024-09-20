package driver;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int size = 10000;
		int[] input = new int[size];
		for(int i = 0; i < 10000; i++) {
			input[i] = i + 10;
		}
		int numberToSearch = size + 1;
		long startTime = System.nanoTime();
		int pos = LinearSearch(input, numberToSearch);
		long endTime = System.nanoTime();
		System.out.println("It takes linear Search " + (endTime - startTime) + " nanoseconds to run the search.");
		startTime = System.nanoTime();
		BinarySearch(input, numberToSearch);
		endTime = System.nanoTime();
		System.out.println("It takes binary Search " + (endTime - startTime) + " nanoseconds to run the search.");
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
	
	public static int BinarySearch_1(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			} else {
				if (arr[mid] < target) { //search the larger part of the half of the array
					start = mid + 1;
				} else { //search the smaller part of the half of the array
					end = mid - 1;
				}
			}
		}
		return -1;
	}

}
