package driver;

public abstract class Stack {
	public abstract void Push(Node node);
	
	public abstract Node Pop();
	
	public abstract Node Peek();
	
	public abstract int GetLength();
	
	public abstract boolean IsEmpty();
}
