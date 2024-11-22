package driver;

public class HashTableChaining {
	public int Size;
	public List[] Table;
	
	public HashTableChaining(int InitialSize) {
		this.Size = InitialSize;
		this.Table = new List[this.Size];
	}
	
	public int HashingFunction(int key) {
		return key % this.Size;
	}
	
	public void Insert(int key, String value) {
		int index = HashingFunction(key);
		Node newNode = new Node();
		newNode.Key = key;
		newNode.Value = value;
		this.Table[index].Append(newNode);
	}
	
	public Node Search(int key) {
		int index = HashingFunction(key);
		return this.Table[index].Search(key);
	}
	
	public void Remove(int key) {
		int index = HashingFunction(key);
		this.Table[index].Remove(key);
	}
	
	public void Display() {
		
	}

}
