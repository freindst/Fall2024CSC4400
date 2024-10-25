package drive;

public class Human {
	public int MaxAge;
	public int AgeAsApprentice;
	public int YearsOfApprentice;
	public int AgeOfGivingBirth;
	public int CapOfApprentice;
	public int CapOfBaby;
	
	public Human() {
		this.MaxAge = 72;
		this.AgeAsApprentice = 18;
		this.YearsOfApprentice = 3;
		this.AgeOfGivingBirth = 30;
		this.CapOfApprentice = 2;
		this.CapOfBaby = 2;
	}
	
	public Human(int age1, int age2, int year1, int age3, int cap1, int cap2) {
		this.MaxAge = age1;
		this.AgeAsApprentice = age2;
		this.YearsOfApprentice = year1;
		this.AgeOfGivingBirth = age3;
		this.CapOfApprentice = cap1;
		this.CapOfBaby = cap2;
	}
}
