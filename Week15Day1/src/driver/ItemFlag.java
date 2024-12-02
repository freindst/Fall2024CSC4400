package driver;

//Q1: what are truly those values are?
//A1: integer array
//Q2: why we use it?
//A2: easy to read and hard to make errors
//Q3: any other benefits?
//A3: faster
//Q4: why we use enum?
//A4: when we need some constants in the code
public enum ItemFlag {
	empty_since_start,
	empty_after_removal,
	normal
}
