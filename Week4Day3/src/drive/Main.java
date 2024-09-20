package drive;

public class Main {

	public static void main(String[] args) {
		int[] list = new int[] {1, 2, 3, 4, 5, 6};
		ReverseList2(list, 0, list.length - 1);
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	//O(n)
	public static int Factorial1(int n) {
		int result = 1;
		while(n > 0) {
			result = result * n;
			n = n - 1;
		}
		return result;
	}
	
	//O(n)
	//T(n) = 3 + T(n-1) + T(n-2)
	//T(1) = 1
	//T(n) = 3(n-1) + 1 = 3n - 2
	public static int Factorial2(int n) {
		if (n == 1) {
			return 1;
		}
		return n * Factorial2(n - 1);
	}
	
	public static void ReverseList1(int[] arr) {
		for(int i = 0; i < arr.length /2; i++) {
			//index: i vs index: arr.length - 1 - i
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 -i];
			arr[arr.length - 1 -i] = temp;
		}
	}
	
	//reversive reverse
	public static void ReverseList2(int[] arr, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			ReverseList2(arr, startIndex + 1, endIndex - 1);
		}
	}
	
	//Fibonacci F(n) = F(n-1) + F(n-2)
	//F(0) = 1
	//F(1) = 1
	public static int Fibonacci(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
	
	//how to write in loop?
	public static int Fibonacci1(int n) {
		int[] Fib = new int[n];
		for(int i = 0; i < n; i++) {
			if (i == 0 || i == 1) {
				Fib[i] = 1;
			} else {
				Fib[i] = Fib[i - 1] + Fib[i - 2];
			}
		}
		return Fib[n - 1] + Fib[n - 2];
	}
	
}
