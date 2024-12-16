import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class Order implements OrderInterface, Comparable<Order>{
	// •	Instance variables for order number, order time, order day and 
	// customer and a list of beverages within this order
	
	private int orderNo;
    private int orderTime; // 
    private Day orderDay; //  "Monday", "Tuesday" etc
    private Customer customer;
    private List<Beverage> beverages; // HOW DOES THIS COME INTO PLAY????
    									// is this to store orders??
    // public Coffee coffee;
    
    public Order(int orderTime, Day orderDay, Customer cust) { 
    	// orderTime - time of the order (between 8 and 23 )
    	// orderDay - day of the order
    	// cust - a customer object
    	orderNo = generateOrder();
    	this.orderTime = orderTime;
    	this.orderDay = orderDay;
    	this.customer = new Customer(cust);
    	this.beverages = new ArrayList<>();
    }
 // Generate random order number between 10000 and 90000
    private int generateOrder() {
        Random random = new Random();
        return random.nextInt(10000, 90000); // Range: (10000 lower origin, 90000)
    }
    public int getOrderNo() {
    	return orderNo;
    }
    public int getOrderTime() {
    	return orderTime;
    }
    public void setOrderDay(Day orderDay) {
    	this.orderDay = orderDay;
    }
    public Day getOrderDay() {
    	return orderDay;
    }
    public Customer getCustomer() {
    	return customer;
    }
    /**
	 * 
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
    public boolean isWeekend() {
    	return this.orderDay.equals(Day.SUNDAY)|| this.orderDay.equals(Day.SATURDAY); // CHECK THIS LATER
    	 
    	// isWeekend in interface OrderInterface
    	// @return true if the day is a weekend day (Saturday or Sunday)
		
    }
    /**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * 
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
    public Beverage getBeverage(int itemNo) {
    	// returns the beverage listed in the itemNo of the order, 
    	// for example if itemNo is 0 this method will return the first beverage in this order 
    	// Note: this method returns the shallow copy of the Beverage
    	// Returns: the beverage listed in the itemNo of the order or null if there is no item in the order
    	
    	if (itemNo >= 0 && itemNo < beverages.size()) { // checks to see if "item no" is within range
            return beverages.get(itemNo); 
        }
        return null; // Returns null if itemNo is invalid
    }
    
    public int getTotalItems() {
    	return beverages.size();
    	// returns the total number of beverages ordered within this order
    }
    /**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
    // addBeverage is AN OVERLADED METHOD TO ADD DIFFERRENT BEV's
    
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
    	// public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
    	
    	Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
    	beverages.add(coffee);	
    }
    /**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
    //ADDS ALCOHOL TO ORDER
    public void addNewBeverage(String bevName, Size size) {
    	// public Alcohol(String name, String size, boolean isWeekend) {
//    	Alcohol alcohol = new Alcohol(bevName, size , isWeekend());
//    	beverages.add(alcohol);
    	
    	boolean isWeekend = (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
        beverages.add(new Alcohol(bevName, size, isWeekend));
    }
    /**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addProtein true if protein is added, false otherwise
	 */
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
    	
    	Smoothie smoothie = new Smoothie(bevName,  size,  numOfFruits,  addProtein);
    	beverages.add(smoothie);
    }
    /**
	 * Calculates and returns the total amount for this order
		Specified by:
		calcOrderTotal in interface OrderInterface
	 */
    public double calcOrderTotal() {
    	// Calculates and returns the total amount for this order
    	// LOOPIMG THRU ARRAYLIST "beverages" 
    	double total = 0;
    	for (int i = 0; i < beverages.size(); i++) {
    		// System.out.println("Beverage " + i + ": " + beverages.get(i));
            total += beverages.get(i).calcPrice();
            
    	}
    	return total;
    }
    /**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (int i = 0; i < beverages.size(); i++) {
            if(beverages.get(i).getType().equals(type)){
            	count++;
            }   
    	}
    	return count;
	}
	/**
	 * An Overridden toString method: Includes order number, time, day, customer name, customer age 
	 * and the list of beverages (with information of the beverage).
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNo).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Beverages:\n");
				for (int i = 0; i < beverages.size(); i++) {
            sb.append(" - ").append(getBeverage(i)).append("\n");
            }  
		sb.append("Total Price: $").append(calcOrderTotal());	
		String result = sb.toString();
		return result;
	}
	/**
	 * Override the compareTo method to compare this order with another order based on the order number. 
	 * Returns 0 if this order number is same as another order's order number, 
	 * 1 if it is greater than another order's order number, -1 if it smaller than another order's order number.
	 */
	@Override
    public int compareTo(Order other) {
		
		return Integer.compare(this.orderNo, other.orderNo);
	
    }

}
