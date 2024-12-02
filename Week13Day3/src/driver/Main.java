package driver;

public class Main {

	public static void main(String[] args) {
		HashTableChaining hb = new HashTableChaining(10);
		hb.Insert(5, "lily");
		hb.Insert(9, "jim");
		hb.Insert(10, "brown");
		hb.Insert(15, "miller");
		hb.Display();
		hb.Remove(15);
		hb.Insert(9,"peter");
		hb.Display();


	}

}
