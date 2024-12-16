/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: (Bradley Beverage Shop)
 * Bradley shop is a family-owned store that sells beverages.  The store offers 3 types of beverages: Coffee, 
 * Alcohol, and Smoothie. The store is open from 8 in the morning to 11 pm in the afternoon.  
 * The owner of the shop likes to automate the order transactions and reports, and purchases software for testing 
 * order activities for one month. You are asked to implement this software based on the following requirements.
 * Due: 12/16/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Chandra Krishnan 
*/
public abstract class Beverage {
	//•	Instance variables for beverage name, beverage type, size, and constant attributes for the 
	// base price ($2.0) and size price (additional $0.5 to go a size up).
	
	String bevName;
	Type type;
	Size size;
	public static final double BASE_PRICE = 2.0;
	public static final double SIZE_PRICE = 0.5;
	
	// •	A parametrized constructor to create a Beverage object given its name, type and size
	
	public Beverage(String bevName, Type type, Size size) { 
		// Beverage(String bevName, Type type, Size size)
		
		this.bevName = bevName;
		this.type = type;
		this.size = size;		
	}
	// from JavaDoc - Beverage(String bevName, Type type, Size size)
	// Creates a beverage object using given values.

	/**
	 * •	An addSizePrice()method:
	 * Calculates a new price by adding the size price to the base price. 
	 * There is no additional cost for small size, for medium and large beverages the additional 
	 * cost of size price is added to base price for example if the base price is 2 and SIZE_PRICE is .5 
	 * then the cost of small beverage is 2, the medium beverage is 2.5 and the large beverage is 3.
	 */	
	public double addSizePrice() {
		double price = BASE_PRICE;
		//if ("medium".equalsIgnoreCase(bevSize))
		if (size.equals(size.MEDIUM)) {
			price += SIZE_PRICE;}
		
		else if ((size.equals(size.LARGE))) {
		price += 2* SIZE_PRICE;}
		
		return price;
	}
	// •	An abstract method called calcPrice calculates and returns the beverage price. 
	public abstract double calcPrice();
	
	// •	A toString method: String representation for Beverage including the name and size.
	// from javadoc - Represents a Beverage object in String with the format of bevName,size
	@Override
	public String toString() {
		
		return bevName + ", " + size ;
		
	}
	// •	The Overridden equals method: checks equality based on name, type, size of the beverage.
	// public boolean equals(Object anotherBev)
	@Override
	public boolean equals(Object anotherBev) {
		// below "if" checks if the object being compared (obj) is the same instance as the current object (this).
		if (this == anotherBev)
			return true;
		// checks if obj is null or if the classes of the two objects are different. 
		// if either of these conditions is true, it returns false.
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		// cast Object 'anotherBev' to a beverage object and compares its name, type and size fields for equality.
		Beverage beverage = (Beverage) anotherBev;
		return this.getBevName().equals(beverage.bevName) &&
				this.getType().equals(beverage.getType()) &&
				this.getSize().equals(beverage.getSize());
//		return this.getBevName().equals(coffee.getBevName()) &&
//				
//				this.getType().equals(coffee.getType()) && 
//				this.getSize().equals(coffee.getSize())&&
//				this.getBasePrice() == coffee.getBasePrice() &&
//				this.getExtraShot() == coffee.getExtraShot()&& 
//				this.getExtraSyrup() == coffee.getExtraSyrup();
	
	}
	// getters below
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public String getBevName() {
		return bevName;
	}
	public Type getType() {
		return type;
	}
	public Size getSize() {
		return size;
	}
	// TO DO's - add setters as need be

}
