package driver;

public class MergeSort {
	
	public MergeSort() {
		
	}
	
	//we keeps on dividing the arr until there is only one item
	public static void Merge(int[] arr, int start, int end) {
		if (end > start) {
			int mid = (start + end) / 2; //integer division
			Merge(arr, start, mid);
			Merge(arr, mid + 1, end);
			Merging(arr, start, end, mid);
		}
	}
	
	//left array is from start to mid, and right array is from mid + 1 to end
	//left and right arrays are both sorted
	//we merge them into a larger array index from start to end, and keep in ascending order
	public static void Merging(int[] arr, int start, int end, int mid) {
		int[] tempArray = new int[end - start + 1];
		int leftCursor = start;
		int rightCursor = mid + 1;
		
		int tempCursor = 0;
		
		while((leftCursor <= mid) || (rightCursor <= end)) {
			int left = arr[leftCursor];
			int right = arr[rightCursor];
			if (left < right) {
				tempArray[tempCursor] = left;
				leftCursor++;
				tempCursor++;
			} else {
				tempArray[tempCursor] = right;
				rightCursor++;
				tempCursor++;
			}
		}
		
		//left array runs out
		if (leftCursor > mid) {
			//more all the remaining items on the right array to the temp array
			while(rightCursor <= end) {
				tempArray[tempCursor] = arr[rightCursor];
				rightCursor++;
				tempCursor++;
			}
		}
		
		//right array runs out
		if (rightCursor > end) {
			while(leftCursor <= mid) {
				tempArray[tempCursor] = arr[leftCursor];
				leftCursor++;
				tempCursor++;
			}
		}
		
		//move all temp array items back to the arr
		for(int i = 0; i < tempArray.length; i++) {
			tempArray[i] = arr[start + i];
		}
	}

}
