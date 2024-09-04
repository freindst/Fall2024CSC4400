package driver;

public class Main {

	public static void main(String[] args) {
		Salesman blade = new Salesman("Blade", 101);
		Salesman jon = new Salesman("Jon", 1100);
		Salesman tim = new Salesman("Tim", 100);
		Salesman litmen = new Salesman("litmen", 300);
		Salesman abram = new Salesman("Abram", 1101);
		Salesman frank = new Salesman("frank", 80);
		Salesman luna = new Salesman("luna", 500);
		Salesman[] sales = new Salesman[] {blade, jon, tim, litmen, abram, frank, luna};
		Salesman[] top5 = Salesman.topFive(sales);
		for(int i = 0; i < 5; i++) {
			System.out.println( (i + 1) + " " + top5[i].display() );
		}
	}

}
