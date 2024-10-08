package driver;

public class Salesman {
	//properties
	public String Name;
	public int Revenue;
	
	//constructor
	public Salesman(String n, int Revenue) {
		this.Name = n;
		this.Revenue = Revenue;
	}
	
	//methods
	//getter
	public String getName() {
		return this.Name;
	}
	
	//setter
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String display() {
		return this.Name + ": " + this.Revenue;
	}
	
	public static Salesman[] topFive(Salesman[] sales) {
		int measure = 0; //the maximum amount of comparison will be n * n
		// make a temperary array for the results
		Salesman[] fiveGuys = new Salesman[5]; //fiveGuys[0] = null
		for(int i = 0; i < sales.length; i++) { //scan through all salesman
			Salesman current = sales[i];
			for(int j = 0; j < 5; j++) {
				Salesman temp = fiveGuys[j];
				if (temp == null) {
					fiveGuys[j] = current;
					break;
				} else {
					if (current.Revenue > temp.Revenue) {
						fiveGuys[j] = current;
						current = temp;
					}
				}
				measure++;
			}
		}
		System.out.println("This algorithm takes " + measure + " times of comparison.");
		return fiveGuys;
	}
}
