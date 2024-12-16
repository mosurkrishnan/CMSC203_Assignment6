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
public class Alcohol extends Beverage{
	// •	Contains additional instance variable for whether or not it is offered in the weekend.  
	// The additional cost for drinks offered in the weekend is 60 cents. 
	boolean isWeekend = false; // Checks if it is weekend. whether the beverage is offered in the weekend false otherwise
	public final double ADDL_WEEKEND_ALC_PRICE = 0.60;
	// private Day orderDay; //  "Monday", "Tuesday" etc
	
	// public Alcohol(String bevName, Size size, boolean isWeekend)
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		// // beverage constructor - public Beverage(String bevName, Type type, Size size)
        super(bevName, Type.ALCOHOL, size ); // Type = "Alcohol"
        this.isWeekend = isWeekend;
    }
	// JAVADOC - Specified by: calcPrice in class Beverage
	// •	An Overridden calcPrice method.
	@Override
	public double calcPrice() {
		double price = super.addSizePrice(); 
		if(isWeekend)
			price += ADDL_WEEKEND_ALC_PRICE;
		return price;
	}
	
	// An Overridden toString method: String representation of a alcohol drink including the name, 
	//size, whether or not beverage is offered in the weekend and the price.
	@Override
	public String toString() {
	// String representation of Alcohol beverage, includes the name, size, whether or not 
	// beverage is offered in weekend and the price
	return super.toString() + ", " + " is it weekend: " + isWeekend + ", " 
						+ " Price: " + calcPrice();	
	}
	// Checks if this Beverage equals to anotherBev
	public boolean equals(Object anotherBev) {
		
		// below "if" checks if the object being compared (anotherBev) is the same instance as the current object (this).
				if (this == anotherBev)
					return true;
				// checks if anotherBev is null or if the classes of the two objects are different. 
				// if either of these conditions is true, it returns false.
				if (anotherBev == null || getClass() != anotherBev.getClass())
					return false;
				// cast Object 'anotherBev' to a Alcohol object and compares its name, type and size fields for equality.
				// Returns: true if the name, type, size and base price and whether beverage is offered in weekend or 
				// not are the same, false otherwise
							
				Alcohol alcohol = (Alcohol) anotherBev;
				return this.getBevName().equals(alcohol.getBevName()) &&
						this.getType().equals(alcohol.getType()) &&
						this.getSize().equals(alcohol.getSize())&&
						this.getBasePrice() == alcohol.getBasePrice() ;
//				return this.getBevName().equals(coffee.getBevName()) &&	
//				this.getType().equals(coffee.getType()) && 
//				this.getSize().equals(coffee.getSize())&&
//				this.getBasePrice() == coffee.getBasePrice() &&
//				this.getExtraShot() == coffee.getExtraShot()&& 
//				this.getExtraSyrup() == coffee.getExtraSyrup();
		 
	}
	// Getter and setter for isWeekend
    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

}
