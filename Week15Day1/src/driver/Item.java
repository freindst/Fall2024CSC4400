package driver;

public class Item {
	public ItemFlag Flag;
	public int Key;
	public String Value;
	
	public Item(int Key, String Value) {
		this.Key = Key;
		this.Value = Value;
		this.Flag = ItemFlag.normal;
	}
	
	public Item() {
		this.Key = 0;
		this.Value = "";
		this.Flag = ItemFlag.empty_since_start;
	}
	
	@Override
	public String toString() {
		return String.format("{%d | %s}", Key, Value);
	}

}
