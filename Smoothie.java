import java.util.Objects;
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
public class Smoothie extends Beverage{
	// •	Contains additional instance variables for number of fruits and boolean variable to 
	// indicate if protein powder is added to the beverage. 
	// The cost of adding protein is $1.50 and each additional fruit costs 50 cents.
	
	// String bevName;
	// String size;
	int numOfFruits = 0; // Number of fruits to be added to the smoothie
	boolean addProtein = false; // Whether to add protein to the smoothie or not
	public final double PROTEIN_PRICE = 1.50;
	public final double FRUIT_PRICE = 0.50;
	
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) { 
		
		// public Beverage(String bevName, Type type, Size size) 
		super( bevName, Type.SMOOTHIE, size );
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
		
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	public boolean getAddProtein() {
		return addProtein;
	}
	// Contains the name , size, whether or not protein added , number of fruits and price
	// Overrides:toString in class Beverage
	@Override
	public String toString() {
	
			
		return super.toString() + ", " + " Protein: " + addProtein + ", " 
				+ " No of Fruits: " + numOfFruits + " Price: " + calcPrice();
	}
	// •	An Overridden calcPrice method.
	// The cost of adding protein is $1.50 and each additional fruit costs 50 cents.
	@Override
	public double calcPrice() {
		
		double price = super.addSizePrice();
//		System.out.println("super add size price is " + price);
//		System.out.println("Num of Fruits: " + numOfFruits);
//	    System.out.println("Add Protein: " + addProtein);
	    // Add cost for protein if applicable
	    if (addProtein) {
	        price += PROTEIN_PRICE;
	    }
	    // Add cost for fruits if applicable
	    if (numOfFruits > 0) {
	        price += numOfFruits * FRUIT_PRICE;
	    }

	    return price;
	}
	// •	An Overridden equals method: checks equality based on the Beverage class equals method and 
	// additional instance variables for this class.
	// Returns:true if the name, type, size and base price, number of Fruits and add protein are the same, false otherwise
	@Override
	public boolean equals(Object anotherBev) {
		// below "if" checks if the object being compared (anotherBev) is the same instance as the current object (this).
		if (this == anotherBev)
			return true;
		// checks if anotherBev is null or if the classes of the two objects are different. 
		// if either of these conditions is true, it returns false.
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		// cast Object 'anotherBev' to a Smoothie object and compares its name, type and size fields for equality.
		// Returns:true if the name, type, size and base price, number of Fruits and add protein are the same, false otherwise
					
		Smoothie smoothie = (Smoothie) anotherBev;
		// below code (line 76-82) is to compare objects by each of its characteristics
//		System.out.println("Comparing bevName: " + this.getBevName() + " with " + smoothie.getBevName());
//	    System.out.println("Comparing type: " + this.getType() + " with " + smoothie.getType());
//	    System.out.println("Comparing size: " + this.getSize() + " with " + smoothie.getSize());
//	    System.out.println("Comparing basePrice: " + this.getBasePrice() + " with " + smoothie.getBasePrice());
//	    System.out.println("Comparing numOfFruits: " + this.getNumOfFruits() + " with " + smoothie.getNumOfFruits());
//	    System.out.println("Comparing addProtein: " + this.getAddProtein() + " with " + smoothie.getAddProtein());
		return Objects.equals(this.getBevName(), smoothie.getBevName()) &&
				Objects.equals(this.getType(), smoothie.getType()) &&
				Objects.equals(this.getSize(), smoothie.getSize()) &&
		           this.getBasePrice() == smoothie.getBasePrice() &&
		           this.getNumOfFruits() == smoothie.getNumOfFruits() &&
		           this.getAddProtein() == smoothie.getAddProtein();
		
//		return this.getBevName().equals(coffee.getBevName()) &&	
//		this.getType().equals(coffee.getType()) && 
//		this.getSize().equals(coffee.getSize())&&
//		this.getBasePrice() == coffee.getBasePrice() &&
//		this.getExtraShot() == coffee.getExtraShot()&& 
//		this.getExtraSyrup() == coffee.getExtraSyrup();
		
	}
	
}
