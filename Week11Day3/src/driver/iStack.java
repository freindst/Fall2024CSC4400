package driver;

public interface iStack {
	public void Push(Node node);
	
	public Node Pop();
	
	public Node Peek();
	
	public int GetLength();
	
	public boolean IsEmpty();
}
