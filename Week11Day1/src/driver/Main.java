package driver;

public class Main {

	public static void main(String[] args) {
		System.out.println("Doubly Linked List");
		Node<Integer> a = new Node();
		a.Payload = 5;
		Node<Integer> b  = new Node();
		b.Payload = 7;
		System.out.println(a.compareTo(b));
	}

}
