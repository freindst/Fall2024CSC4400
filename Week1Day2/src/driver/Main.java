package driver;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] {10, 5, 8, 29, 17, 21};
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		//int max = Main.FindMax(array);
		//constructor
		Main obj = new Main();
		int max = obj.FindMax_1(array);
		System.out.println("The maximum number in the array is: " + max);
	}
	
	//method with static keyword is called class method, we call it with class name
	//static means unchanged
	public static int FindMax(int[] input) {
		if (input.length == 0) {
			return -1;
		}
		int temp = input[0];
		for(int i = 1; i < input.length; i++) {
			if (input[i] > temp) {
				temp = input[i];
			}
		}
		
		return temp;
	}
	
	//methods without static keyword are called instance methods
	//we need to call it with the instance/object first
	public int FindMax_1(int[] input) {
		if (input.length == 0) {
			return -1;
		}
		int temp = input[0];
		for(int i = 1; i < input.length; i++) {
			if (input[i] > temp) {
				temp = input[i];
			}
		}
		
		return temp;
	}

}
