package driver;

public class Node {
	public int Payload;
	public Node NextNode;
	public Node PreNode;
	
	public Node() {
		this.Payload = 0;
		this.NextNode = null;
		this.PreNode = null;
	}
}
