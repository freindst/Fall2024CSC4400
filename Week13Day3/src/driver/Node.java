package driver;

public class Node {
	public Node NextNode;
	public int Key;
	public String Value;
	
	public Node() {
		this.NextNode = null;
		this.Key = 0;
		this.Value = "";
	}
	
	@Override
	public String toString() {
		return String.format("(%d|%s)", this.Key, this.Value);
	}

}
