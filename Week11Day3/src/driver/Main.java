package driver;

public class Main {

	public static void main(String[] args) {
		System.out.println("Abstraction.");
		Stack stack = new IntListStack();
		stack.Peek();
		stack.Pop();
		stack.Push(new Node());
		
		iStack stack1 = new StackInterfaceList();
		stack1.Peek();
		stack1.Pop();
		stack1.Push(null);
	}

}
