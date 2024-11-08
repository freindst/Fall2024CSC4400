package driver;

public class StackInterfaceList implements iStack {
	public Node Header;
	public Node Tail;
	
	public StackInterfaceList() {
		this.Header = null;
		this.Tail = null;
	}
	
	//append()
	public void Append(Node node) {
		if (this.IsEmpty()) {
			this.Header = node;
			this.Tail = node;
		} else {
			this.Tail.NextNode = node;
			node.PreNode = this.Tail;
			this.Tail = node;
		}
	}
	
	//prepend()
	public void Prepend(Node node) {
		if (this.IsEmpty()) {
			this.Header = node;
			this.Tail = node;
		} else {
			node.NextNode = this.Header;
			this.Header.PreNode = node;
			this.Header = node;
		}
	}

	
	//Remove()
	public void Remove(Node node) {
		if (node == this.Header && node == this.Tail) {
		//node it both the tail and the header
			this.Header = null;
			this.Tail = null;
		} else if (node == this.Tail) {
		//node is the tail
			//.....-> 2 -> 3 -> null
			Node pre = node.PreNode;
			pre.NextNode = null;
			node.PreNode = null;
			this.Tail = pre;
		} else if (node == this.Header) {
		//node is the header
			Node next = node.NextNode;
			node.NextNode = null;
			next.PreNode = null;
			this.Header = next;
		} else {
		//all generic cases
			node.PreNode.NextNode = node.NextNode;
			node.NextNode.PreNode = node.PreNode;
			node.NextNode = null;
			node.PreNode = null;
		}
	}
	@Override
	public void Push(Node node) {
		this.Append(node);
	}

	@Override
	public Node Pop() {
		Node returnNode = this.Tail;
		this.Remove(returnNode);
		return returnNode;
	}

	@Override
	public Node Peek() {
		return this.Tail;
	}

	@Override
	public int GetLength() {
		int length = 0;
		Node node = this.Header;
		while (node != null) {
			length++;
			node = node.NextNode;
		}
		return length;
	}

	@Override
	public boolean IsEmpty() {
		return this.Header == null;
	}

}
