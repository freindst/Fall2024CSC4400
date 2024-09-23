package drive;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("Sort");
		int[] testArray = new int[] {5, 7, 2, 13, 10, 23};
		BubbleSort(testArray);
		for(int i = 0; i < testArray.length; i++) {
			System.out.println(testArray[i]);
		}
	}
	
	//use selection sort to make the arr in ascending order
	public static void SelectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			//in each loop, we put the current smallest number in the position of i
			for(int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void BubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			//in each loop, we compare neighbor items, and brings the larger one to the right
			for(int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
