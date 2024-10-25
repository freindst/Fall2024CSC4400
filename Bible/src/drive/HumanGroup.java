package drive;

public class HumanGroup {
	public long Population;
	public int Age;
	public int YearsBeingApprentice;
	public int YearsInTeaching;
	public boolean IsDisciple;
	public boolean IsApprentice;
	public boolean IsTeaching;
	public Human HumanSettings;
	
	//it is not necessary to set the default value to all properties
	//but it is recommended to set it explicitly
	public HumanGroup() {
		this.Population = 0;
		this.Age = 0;
		this.YearsBeingApprentice = 0;
		this.YearsInTeaching = 0;
		this.IsApprentice = false;
		this.IsDisciple = false;
		this.IsTeaching = false;
		this.HumanSettings = new Human();
	}
	
	public boolean CanBeApprentice() {
		return this.Age >= this.HumanSettings.AgeAsApprentice 
				&& !this.IsApprentice 
				&& !this.IsDisciple;
	}
	
	public boolean HasBecomeDisciple() {
		return this.IsDisciple;
	}
	
	public boolean IsGivingBirth() {
		return this.Age == this.HumanSettings.AgeOfGivingBirth;
	}
	
	public boolean CanTrainApprentice() {
		return this.IsDisciple 
				&& this.YearsInTeaching == this.HumanSettings.YearsOfApprentice;
	}
	
	public void Aging() {
		this.Age++;
		if (this.IsApprentice) {
			this.YearsBeingApprentice++;
		}
		if (this.IsTeaching && this.IsDisciple) {
			this.YearsInTeaching++;
		}
	}
}
