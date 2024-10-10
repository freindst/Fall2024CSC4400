package drive;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] testArray = RandomizedArray(1000000, 1, 1000000);
		int[] testArrayForShell = ArrayClone(testArray);
		long startTime = System.currentTimeMillis();
		ShellSort(testArrayForShell);
		long endTime = System.currentTimeMillis();
		System.out.println("Shell sort took " + (endTime - startTime) + " milliseconds.");
		/*int[] testArrayForBubble = ArrayClone(testArray);
		long startTime = System.currentTimeMillis();
		BubbleSort(testArrayForBubble);
		long endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort took " + (endTime - startTime) + " milliseconds to complete.");
		int[] testArrayForInsertion = ArrayClone(testArray);
		startTime = System.currentTimeMillis();
		InsertionSort(testArrayForInsertion);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion Sort took " + (endTime - startTime) + " milliseconds to complete.");
		int[] testArrayForSelection = ArrayClone(testArray);
		startTime = System.currentTimeMillis();
		SelectionSort(testArrayForSelection);
		endTime = System.currentTimeMillis();
		System.out.println("Selection Sort took " + (endTime - startTime) + " milliseconds to complete.")
*/
		/*for(int i = 0; i < testArray.length; i++) {
			System.out.println(testArray[i]);
		}*/
		//shell sort
		startTime = System.currentTimeMillis();
		InsertionSort(testArray);
		endTime = System.currentTimeMillis();
		System.out.println("Insert sort took " + (endTime - startTime) + " milliseconds.");
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
	
	public static void InsertionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j = i + 1;
			while(j > 0 && arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j = j - 1;
			}
		}
	}
	
	//size = 100, start = 1, end = 10000
	public static int[] RandomizedArray(int size, int start, int end) {
		if (end - start + 1 >= size) {
			//when size = 100, start = 0, end = 100,000
			int[] sourceArray = new int[end - start + 1];
			for(int i = 0; i < end - start + 1; i++) {
				sourceArray[i] = start + i;
			}
			for(int i = 0; i < 3; i++) {
				shuffle(sourceArray);
			}
			int[] result = new int[size];
			for(int i = 0; i < size; i++) {
				result[i] = sourceArray[i];
			}
			return result;
		} else {
			return null;
		}
	}
	
	//we will randomized the items in the array
	public static void shuffle(int[] array) {
		//loop for half of the amount of the array
		for(int i = 0; i < array.length / 2; i++) {
		//every round we pick two random positions and swap the items on these two position
			Random r = new Random();
			int pos1 = r.nextInt(array.length - 1);
			int pos2 = r.nextInt(array.length - 1);
			int temp = array[pos1];
			array[pos1] = array[pos2];
			array[pos2] = temp;
		}
	}
	
	public static int[] ArrayClone(int[] array) {
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = array[i];
		}
		return result;
	}
	
	//the new insertion sort uses round-robin fashion to partition the array into gap groups. the first item start with startIndex.
	//then, we apply insertion sort on this specific partition, (partition startIndex, with gap amount of item separated)
	public static void InsertionSort (int[] arr, int startIndex, int gap) {
		//1, 2, 3, 4, 5, 6, 7, 8
		//1, 2, 3, 4, 5, 6, 7, 8
		/*for(int i = startIndex; i < arr.length - gap; i=i+gap) {
			int j = i + gap;
			while(j > startIndex && arr[j - gap] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - gap];
				arr[j - gap] = temp;
				j = j - gap;
			}
		}*/
		for(int i = startIndex; i < arr.length - gap; i = i + gap) {
			int j = i + gap;
			while(j > startIndex && arr[j - gap] >= arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - gap];
				arr[j - gap] = temp;
				j = j - gap;
			}
		}
	}
	
	//apply the insertion sort on each group when we partition the whole array into (gap) groups
	public static void InsertionSortOnGap(int[] arr, int gap) {
		for(int i = 0; i < gap; i++) {
			InsertionSort(arr, i, gap);
		}
	}
	
	//shell sort with gap from 2^k, 2^k-1, 2^k-2, ..., 4, 2, 1. 2^k < length, and 2^k+1 >= length
	public static void ShellSort(int[] arr) {
		int k = 1;
		int gaps = 2;
		while (gaps < arr.length) {
			gaps = gaps * 2;
			k = k + 1;
		}
		gaps = gaps / 2; //1000 2^10=1024 k = 9 gap is 9
		k = k - 1;
		for(int i = k; i >= 0; i--) {
			int gap = pow(2, i);
			InsertionSortOnGap(arr, gap);
		}
	}
	
	public static int pow(int base, int power) {
		int result = 1;
		for(int i = 0; i < power; i++) {
			result = result * base;
		}
		return result;
	}

}
