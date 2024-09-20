package drive;

public class Main {

	public static void main(String[] args) {
		//array of array
		int[][] matrix = new int[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
		};
		
		if (matrix.length > 0) {
			for(int y = 0; y < matrix.length; y++) {
				for(int x = 0; x < matrix[0].length; x++) {
					//System.out.println("The item at row index = " + y + " column index = " + x + " is " + matrix[y][x]);
					//System.out.println("("+ (x + 1) + ", " + (y + 1) + "): " + matrix[y][x]);
				}
			}
		}
		/*
		int rows = matrix.length;
		int columns = matrix[0].length;
		//int[r][c] <-> int[i]
		for (int i = 0; i < rows * columns; i++) {
			//the item at 1-d array index at i should be at
			int r = i / columns;
			int c = i % columns;
			//what is the relation between r, c and i
			//i = r * columns + c
			System.out.println("The item + " + i + " + int[" + r + "][" + c + "] is " + matrix[r][c]);
		}*/
		int[] result = BinarySearch(matrix, 13);
		System.out.println(result[0] + " " + result[1]);
	}
	
	//the first item is row index, and the second item is column index
	//there are 3 x 4 = 12 items there.
	//there are 12 comparisons in the worst case. == O(n)
	public static int[] LinearSearch(int[][] board, int query) {
		if (board.length == 0 || board[0].length == 0) {
			return new int[] {-1, -1};
		}
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column ++) {
				if (query == board[row][column]) { //comparison
					return new int[] {row, column};
				}
			}
		}
		//int[row][column] -> int[(row - 1) * total_column + (column - 1)]
		//while (current < total)
		int column_total = board[0].length;
		int row_total = board.length;
		int total = column_total * row_total;
		int current = 0;
		int row_index = 0;
		int column_index = 0 ;
		while (current < total) {
			if (board[row_index][column_index] == query) {
				return new int[] {row_index, column_index};
			} else {
				column_index = column_index + 1;
				if (column_index == column_total) {
					column_index = 0;
					row_index = row_index + 1;
				}
				current++;
			}
		}
		return new int[] {-1, -1};
	}
	
	//1. scan through all the rows, and run binary search for each row
	//2. map the matrix onto 1-d array, and get the index from 1-d array binary search, and map it back to the 2d matrix indexes
	//3. range binary search to return row index, and binary search to return column index
	public static int[] BinarySearch(int[][] matrix, int query) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		int start = 0;
		int end = rows * columns - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			int r = mid / columns;
			int c = mid % columns;
			if (matrix[r][c] == query) {
				return new int[] {r, c};
			} else {
				if (matrix[r][c] < query) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	//row0: 1, 2, 3, 4
	//row1: 5, 6, 7, 8
	//row2: 9, 10, 11, 12
	//leave it to you

	public static int BinarySearch_1(int[] arr, int target) {
		int start = 0;	//1
		int end = arr.length - 1;	//1
		while(start <= end) { //1
			int mid = (start + end) / 2; //1
			if (arr[mid] == target) { //1
				return mid;
			} else {
				if (arr[mid] < target) { //search the larger part of the half of the array //1
					start = mid + 1; //1
				} else { //search the smaller part of the half of the array
					end = mid - 1;
				}
			}
		} //4 * log(n) + 2 
		return -1;
	}
}
