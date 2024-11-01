package driver;

public class QuickSort {
	
	public QuickSort() {
		
	}
	
	//use the pivot function recursively to find the pivot that split the whole array into two part
	//one smaller than the pivot,
	//the other one all equal or large than the pivot
	public static void Sort(int[] arr, int start, int end) {
		if (start < end) {
			//if you are in a class, the class method sometimes looks the same in calling with instance method
			int pivot = QuickSort.Pivot(arr, start, end);
			Sort(arr, start, pivot - 1);
			Sort(arr, pivot + 1, end);
		}
	}
	
	public static int Pivot(int[] arr, int start, int end) {
		int pivotValue = arr[start];
		int lowCursor = start; //boundary that store the item that smaller than the pivot number
		int highCursor = end; //boundary store the item that greater than the pivot number
		int currentCursor = start;
		while (currentCursor > highCursor) {
			int currentValue = arr[currentCursor];
			if (currentValue > pivotValue) {
				//swap current with high
				arr[currentCursor] = arr[highCursor];
				arr[highCursor] = currentValue;
				highCursor--; //the total number on the range reduce by one
			} else if (currentValue == pivotValue) {
				currentCursor++; //the total number on the range reduce by one
			} else {
				//1 2 3 
				//swap the current with low
				arr[currentCursor] = arr[lowCursor];
				arr[lowCursor] = currentValue;
				lowCursor++;
				currentCursor++; //the total number on the range reduce by one
			}
		}
		return lowCursor; //low is always the first number equals to the pivot value
	}

}
