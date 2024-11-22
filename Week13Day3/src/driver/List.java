package driver;

public class List {
	public Node Head;
	
	public List() {
		this.Head = null;
	}
	
	public int GetLength() {
		int length = 0;
		Node node = this.Head;
		while (node != null) {
			length++;
			node = node.NextNode;
		}
		return length;
	}
	
	public boolean IsEmpty() {
		return this.Head == null;
	}
	
	public void Append(Node node) {
		if (this.IsEmpty()) {
			this.Head = node;
		} else {
			Node cur = this.Head;
			while (cur.NextNode != null) {
				cur = cur.NextNode;
			}
			cur.NextNode = node;
		}
	}
	
	//return the first node has the same key
	public Node Search(int key) {
		Node node = this.Head;
		while (node != null) {
			if (node.Key == key) {
				return node;
			} else {
				node = node.NextNode;
			}
		}
		return null;
	}
	
	public void Remove(int key) {
		if (!this.IsEmpty()) {
			if (this.Head.Key == key && this.Head.NextNode == null) {
				this.Head = null;
			}
			Node preNode = this.Head;
			Node node = preNode.NextNode;
			while (node != null) {
				if (node.Key == key) {
					preNode.NextNode = node.NextNode;
					node.NextNode = null;
					break;
				} else {
					preNode = node;
					node = node.NextNode;
				}
			}
		}
	}
}
