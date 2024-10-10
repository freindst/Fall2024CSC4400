package driver;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int[] testArray = new int[10];
		for(int i = 0; i < 10; i++) {
			testArray[i] = r.nextInt(20);
			System.out.print(testArray[i] + ", ");
		}
		int p = partition(testArray, 0, 9);
		System.out.println("pivot is at " + p + " the value is " + testArray[p]);
		for(int i = 0; i < 10; i++) {
			System.out.print(testArray[i] + ", ");
		}
	}
	
	//this is for ascending order
	//rearrange the items on the arr, and moving all numbers smaller than pivot to the left side of pivot, and all numbers greater than pivot to the right side of pivot
	//return the index of the pivot
	public static int partition(int[] arr, int start, int end) {
		//mid is the index of the pivot
		int mid = (start + end) / 2;
		int pivot = arr[mid];
		int leftCursor = start;
		int rightCursor = end;
		while(true) {
			//leftCursor stops at the number on the arr from left to right when it is no smaller than pivot
			//loop from start to end, unti arr[leftCursor] >= pivot
			while(arr[leftCursor] < pivot) {
				leftCursor++;
			}
			
			//move rightCursor from right to left
			while(arr[rightCursor] > pivot) {
				rightCursor--;
			}
			
			//swap when leftCursor and rightCursor are not on the same item
			if (leftCursor < rightCursor) {
				int temp = arr[leftCursor];
				arr[leftCursor] = arr[rightCursor];
				arr[rightCursor] = temp;
				leftCursor++;
				rightCursor--;
			}
			
			if (leftCursor >= rightCursor) {
				return leftCursor;
			}
			
		}
	}

}
