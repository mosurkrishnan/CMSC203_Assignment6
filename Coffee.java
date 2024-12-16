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
public class Coffee extends Beverage{
	
	// •	Contains additional instance variables of type boolean to indicate  
	String bevName;
	Size size;
	// extraShot - true if extra coffee shot added , false otherwise
	// extraSyrup - true if extra syrup is added , false otherwise
	boolean extraShot = false;
	boolean extraSyrup = false;;
	
	// •	A parametrized constructor  
	// Creates a Coffee object using the given values
	public Coffee (String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		// beverage constructor - public Beverage(String bevName, Type type, Size size) 
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
		
	}
	
	// recommended per JavaDoc
	// Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) - Creates a Coffee object using the given values
	// 

	

	// Indicates whether or not extra shot is added
	public boolean getExtraShot() {
			
		return extraShot;
	}
	// Indicates whether or not extra syrup is added
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	// An Overridden calcPrice method. Calculates the price based on base price, size, extra coffee shot and extra syrup
		@Override
		public double calcPrice() {
			// if it contains extra shot of coffee (additional cost of 50 cents) and extra syrup (additional cost of 50 cents).  
			double price = super.addSizePrice();
			if (extraShot) 
				price += 0.5;
			if (extraSyrup) 
				price += 0.5;
			return price;
			
		}
	// A toString method: String representation of Coffee beverage, including the name, size ,  
	// whether it contains extra shot, extra syrup and the price of the coffee
	// following String format: name,size, whether it contains extra shot, extra syrup and the price
		@Override
		public String toString() {
		String shot;
		if(extraShot)
			shot = "Yes";
		else
			shot = "No";
		String syrup;
		if(extraSyrup)
			syrup = "Yes";
		else
			syrup = "No";
			
		return super.toString()+ ", " + "Extra Shot: " + shot + ", " + "Extra Syrup: "
				+ syrup + ", " + "Price: " + calcPrice();
	}
	// •	The Overridden equals method: checks equality based on name, type, size of the beverage.
		// public boolean equals(Object anotherBev)
		@Override
		public boolean equals(Object anotherBev) {
			// below "if" checks if the object being compared (anotherBev) is the same instance as the current object (this).
			if (this == anotherBev)
				return true;
			// checks if anotherBev is null or if the classes of the two objects are different. 
			// if either of these conditions is true, it returns false.
			if (anotherBev == null || getClass() != anotherBev.getClass())
				return false;
			// cast Object 'anotherBev' to a Coffee object and compares its name, type and size fields for equality.
			// Returns: true if the name, type, size and base price and whether or not it 
						// contains extra shot and extra syrup false otherwise
			Coffee coffee = (Coffee) anotherBev;
			return this.getBevName().equals(coffee.getBevName()) &&
					
					this.getType().equals(coffee.getType()) && 
					this.getSize().equals(coffee.getSize())&&
					this.getBasePrice() == coffee.getBasePrice() &&
					this.getExtraShot() == coffee.getExtraShot()&& 
					this.getExtraSyrup() == coffee.getExtraSyrup();
			
			
		}

}
