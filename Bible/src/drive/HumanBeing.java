package drive;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanBeing {
	public ArrayList<HumanGroup> Disciples;
	public ArrayList<HumanGroup> Apprentices;
	public ArrayList<HumanGroup> Nonbelievers;
	public long TotalPopulation;
	public long TotalDisciples;
	public long TotalNonBelivers;
	
	//constructor must initiate all non-primitive data type attribute
	public HumanBeing() {
		this.Apprentices = new ArrayList<HumanGroup>();
		this.Disciples = new ArrayList<HumanGroup>();
		this.Nonbelievers = new ArrayList<HumanGroup>();
		this.TotalDisciples = 0;
		this.TotalPopulation = 0;
		this.TotalNonBelivers = 0;
	}
	
	//this function will set up the default value of the our game
	public void Initiate() {
		this.TotalPopulation = 7700000000l;
		this.TotalDisciples = 13l;
		HumanGroup firstDisciples = new HumanGroup();
		firstDisciples.Age = 30;
		firstDisciples.Population = 13;
		firstDisciples.IsDisciple = true;
		this.Disciples.add(firstDisciples);
		HumanGroup allPopulation = new HumanGroup();
		allPopulation.Age = 18;
		allPopulation.Population = 7700000000l - firstDisciples.Population;
		this.TotalNonBelivers = allPopulation.Population;
		this.Nonbelievers.add(allPopulation);
	}
	
	//what happens when the human beings live for one year
	public void AgeUp() {
		//events would happen
		//all groups of human would have baby at the age of 30
		long totalBabies = 0;
		Iterator<HumanGroup> iApprentices = this.Apprentices.iterator();
		while(iApprentices.hasNext()) {
			HumanGroup curApprentices = iApprentices.next();
			curApprentices.Aging();
			//people die
			if (curApprentices.Age == 72) {
				iApprentices.remove();
				continue;
			}
			if (curApprentices.Age == 30) {
				totalBabies = totalBabies + curApprentices.Population / 2 * 2;
			}
			//the apprentice would become disciple when the training year from 2 to 3
			if (curApprentices.YearsBeingApprentice == 3) {
				curApprentices.IsApprentice = false;
				curApprentices.YearsBeingApprentice = 0;
				curApprentices.IsDisciple = true;
				iApprentices.remove(); //graduate from apprentices
				this.Disciples.add(curApprentices); //become disciples
			}
		}
		
		long totalDisciples = 0;
		Iterator<HumanGroup> iDisciples = this.Disciples.iterator();
		while(iDisciples.hasNext()) {
			HumanGroup curDisicples = iDisciples.next();
			curDisicples.Aging();
			//people die
			if (curDisicples.Age == 72) {
				iApprentices.remove();
				continue;
			}
			if (curDisicples.Age == 30) {
				totalBabies = totalBabies + curDisicples.Population / 2 * 2;
			}
		}
		
		long nonBelivers = 0;
		Iterator<HumanGroup> iNonbelievers = this.Nonbelievers.iterator();
		while(iNonbelievers.hasNext()) {
			HumanGroup curNonbelievers = iNonbelievers.next();
			curNonbelievers.Aging();
			//people die
			if (curNonbelievers.Age == 72) {
				iNonbelievers.remove();
				continue;
			}
			if (curNonbelievers.Age == 30) {
				totalBabies = totalBabies + curNonbelievers.Population / 2 * 2;
			}
			nonBelivers = nonBelivers + curNonbelievers.Population;
		}
		
		iApprentices = this.Apprentices.iterator();
		while(iApprentices.hasNext()) {
			HumanGroup curApprentices = iApprentices.next();
			//the apprentice would become disciple when the training year from 2 to 3
			if (curApprentices.YearsBeingApprentice == 3) {
				curApprentices.IsApprentice = false;
				curApprentices.YearsBeingApprentice = 0;
				curApprentices.IsDisciple = true;
				iApprentices.remove(); //graduate from apprentices
				this.Disciples.add(curApprentices); //become disciples
			}
		}
		
		iDisciples = this.Disciples.iterator();
		while(iDisciples.hasNext()) {
			HumanGroup curDisciples = iDisciples.next();
			if (curDisciples.YearsInTeaching == 3) {
				curDisciples.YearsInTeaching = 0;
				curDisciples.IsTeaching = false;
			}
			if (!curDisciples.IsTeaching) {
				//how many disciples are currently able to teaching
				totalDisciples = totalDisciples + curDisciples.Population;
				curDisciples.IsTeaching = true;
			}
		}
		
		//the disciples would increase the teaching year by one
		//the disciples whose teaching is 3 years will stop teaching and roll back to 0
		//the disciples will find the qualified non-believers and teach them to be apprentice
		long capOfNewApprentice = totalDisciples * 2;
		iNonbelievers = this.Nonbelievers.iterator();
		while(iNonbelievers.hasNext()) {
			//if the nonbeliever group population 
			//is less than the total disciples * 2, then they will be come apprentice
			//otherwise, portion will become apprentice
			//scanning each human group, and subtract from the cap of new apprentices until it reaches 0
			HumanGroup curNonbelivers =  iNonbelievers.next();
			if (capOfNewApprentice == 0) {
				break;
			} else if (curNonbelivers.Population == capOfNewApprentice) {
				curNonbelivers.IsApprentice = true;
				iNonbelievers.remove();
				this.Apprentices.add(curNonbelivers);
				break;
			} else if (curNonbelivers.Population <  capOfNewApprentice) {
				curNonbelivers.IsApprentice = true;
				iNonbelievers.remove();
				this.Apprentices.add(curNonbelivers);
				capOfNewApprentice = capOfNewApprentice - curNonbelivers.Population;
			} else {
				curNonbelivers.Population = curNonbelivers.Population - capOfNewApprentice;
				HumanGroup newApprentices = new HumanGroup();
				newApprentices.Population = capOfNewApprentice;
				newApprentices.Age = curNonbelivers.Age;
				newApprentices.IsApprentice = true;
				this.Apprentices.add(newApprentices);
			}
		}
		//all human dies at the age of 72
		//the total population and total disciple number will change each year
		//iterate all nonbeliever groups and find enough people to train
		
		//create a new human group of the new born baby, and put it back to the non-believer group
		if (totalBabies > 0) {
			HumanGroup Baby = new HumanGroup();
			Baby.Age = 1;
			Baby.Population = totalBabies;
			this.Nonbelievers.add(Baby);
		}
	}
	
	public void Report() {
		//calculate how many disciples are there
		long totalDisicples = 0;
		for(int i = 0; i < this.Disciples.size(); i++) {
			totalDisicples = totalDisicples + this.Disciples.get(i).Population;
		}
		this.TotalDisciples = totalDisicples;
		//calculate how many populations
		long totalPopulation = 0;
		this.TotalNonBelivers = 0;
		totalPopulation = totalPopulation + totalDisicples;
		for(int i = 0; i < this.Nonbelievers.size(); i++) {
			totalPopulation = totalPopulation + this.Nonbelievers.get(i).Population;
			this.TotalNonBelivers = this.TotalNonBelivers + this.Nonbelievers.get(i).Population;
		}
		for(int i = 0; i < this.Apprentices.size(); i++) {
			totalPopulation = totalPopulation + this.Apprentices.get(i).Population;
		}
		this.TotalPopulation = totalPopulation;
		//print it out
		System.out.println("Total population is: " + this.TotalPopulation);
		System.out.println("Total population of disciples is: " + this.TotalDisciples);
		//determine whether the game needs to continue;
		//let's see when the total disciples are more than the nonbelievers
	}
}
