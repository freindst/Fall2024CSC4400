package driver;

public class HashTableChaining {
	public int Size;
	public List[] Table;
	
	public HashTableChaining(int InitialSize) {
		this.Size = InitialSize;
		this.Table = new List[this.Size]; //what is currently on the array. null
		//always initiate objects and arrays in the constructor
		for(int i = 0; i < this.Size; i++) {
			this.Table[i] = new List();
		}
		//empty list is different from null(unknown)
	}
	
	public int HashingFunction(int key) {
		return key % this.Size;
	}
	
	public void Insert(int key, String value) {
		int index = HashingFunction(key);
		Node oldNode = this.Table[index].Search(key);
		if (oldNode != null) {
			oldNode.Value = value;
		} else {
			Node newNode = new Node();
			newNode.Key = key;
			newNode.Value = value;
			this.Table[index].Append(newNode);
		}
	}
	
	//Search in the hash table will always give a unique result
	public Node Search(int key) {
		int index = HashingFunction(key);
		return this.Table[index].Search(key);
	}
	
	public void Remove(int key) {
		int index = HashingFunction(key);
		this.Table[index].Remove(key);
	}
	
	public void Display() {
		String output = "";
		for(int i = 0; i < this.Size; i++) {
			output += String.format("[%d] %s\n", i, this.Table[i].toString()); 
		}
		System.out.println(output);
	}
	
	
	public void Resize() {
		//how?
		//the harder questions is what the new size should be in the hashtable
		HashTableChaining newtable = new HashTableChaining(1000);
		//how to loop through all items on the hash table?
		for(int i = 0; i < this.Size; i++) {
			List lst = this.Table[i];
			Node node = lst.Head;
			while (node != null) {
				newtable.Insert(node.Key, node.Value);
				node = node.NextNode;
			}
		}
		this.Size = newtable.Size;
		this.Table = newtable.Table;
	}

}
