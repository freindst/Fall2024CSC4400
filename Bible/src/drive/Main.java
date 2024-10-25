package drive;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		HumanBeing earth = new HumanBeing();
		earth.Initiate();
		int Year = 0;
		System.out.println("Game starts at Year: " + (Year + 2024));
		boolean end = false;
		while(!end) {
			Year++;
			System.out.println(Year + " Year pass. Game is at Year: " + (Year + 2024));
			earth.AgeUp();
			earth.Report();
			if (earth.TotalDisciples > earth.TotalNonBelivers) {
				end = true;
			}
		}
	}

}
