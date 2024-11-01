package driver;

//integer linked list
public class SinglyLinkedListNode {
	//link
	public SinglyLinkedListNode nextNode;
	//value
	public int payload;
	
	public SinglyLinkedListNode() {
		this.nextNode = null;
		this.payload = 0;
	}
	
	public SinglyLinkedListNode(int value) {
		this.nextNode = null;
		this.payload = value;
	}
	
	//what is the default result of ToString of an object?
	@Override
	public String toString() {
		return String.valueOf(this.payload);
	}
}
