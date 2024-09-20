package drive;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello");
		//string: "it is a good day today". does this string has duplicate characters

	}
	
	//string abcde
	//compare a with b, c, d, e
	//compare b with c, d, e
	//compare c with d, e,
	//...
	//if all not match, return true
	public static boolean AllUniqueChar(String input) {
		for(int i = 0; i < input.length(); i++) { //this goes for n round
			for(int j = i + 1; j < input.length(); j++) { //this goes for n - 1, n - 2, n - 3, ... 1 = n * (n - 1) /2 
				//O(n*(n-1)/2)) roughly O(n^2)
				if (input.charAt(i) == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean AllUniqueChar1(String input) {
		char[] box = new char[100];
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < count; j++) {
				if (input.charAt(i) == box[j]) {
					return false;
				} else {
					box[count] = input.charAt(i);
					count++;
				}
			}
		}
		return true;
	}

}
