package driver;

//this is hash table resolve using linear probe
public class HashTable {
	public int Size;
	public Item[] Table;
	
	public HashTable(int Size) {
		this.Size = Size;
		this.Table = new Item[Size];
		//we need to give the initial array each item
		//empty-since-start flag
		//empty-after-removal
		//common item
		for(int i = 0; i < this.Size; i++) {
			this.Table[i] = new Item();
		}
	}
	
	public int Hashing(int Key) {
		return Key % this.Size;
	}
	
	//return true when success
	//return false when the table is full or there is nothing to update
	public boolean Insert(int key, String value) {
		int index = Hashing(key);
		Item toCheck = this.Table[index];
		int count = 0;
		while (count < this.Size) {
			if (toCheck.Flag == ItemFlag.empty_since_start ||
					toCheck.Flag == ItemFlag.empty_after_removal) {
				Item newItem = new Item(key, value);
				this.Table[index] = newItem;
				return true;
			} else if (toCheck.Key == key) {
				toCheck.Value = value; //upate
				return true;
			} else {
				index++;
				if (index == this.Size) {
					index = 0;
				}
				toCheck = this.Table[index];
				count++;
			}
		}
		return false;
	}
	
	public Item Search(int key) {
		int count = 0;
		int index = Hashing(key);
		Item toCheck = this.Table[index];
		while(count < this.Size) {
			if (toCheck.Flag == ItemFlag.empty_since_start) {
				return null; //not found
			} else if (toCheck.Flag == ItemFlag.normal && toCheck.Key == key) {
				return toCheck; //hit
			} else {
				count++;
				index++;
				if (index == this.Size) {
					index = 0;
				}
				toCheck = this.Table[index];
			}
		}
		return null; //not found
	}
	
	public void Remove(int key) {
		Item item = Search(key);
		if (item != null) {
			item.Flag = ItemFlag.empty_after_removal;
		}
	}
}
