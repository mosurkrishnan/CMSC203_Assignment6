import java.time.LocalDate;
import java.util.ArrayList;
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
public class BevShop implements BevShopInterface {
	private ArrayList<Order> orders;
	private int numOfAlcoholDrink;
	private Order currentOrder;
	
	
	private static final int MIN_ALCOHOL_AGE = 21; // •	The minimum age to order alcohol drink is 21.
    private static final int MAX_ALCOHOL_PER_ORDER = 3; // max drinks in an order
    private static final int MIN_TIME = 8;  // 8AM
    private static final int MAX_TIME = 23; // 11 PM
    private static final int MAX_FRUIT = 5;
	
    
    // BevShop() - default Constructor Initializes a BevShop Object
    public BevShop() {
    	this.orders = new ArrayList<>();
        this.numOfAlcoholDrink = 0;
    }
    /**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time
	 *            time represents the time
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean isValidTime(int time) {
		if( time >= MIN_TIME && time <= MAX_TIME)
			return true;
		else
			return false;
	}
	/**
	 * @return returns the constant value for the maximum number of fruits
	 */
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
		
	}
	/**
	 * returns the constant value for the Maximum age for offering Alcohol drink
	 *
	 * @return returns the value for the minimum age for offering Alcohol drink
	 */
	public int getMinAgeForAlcohol() {
		return MIN_ALCOHOL_AGE;
	}
	/**
	 * returns true if the passed parameter exceeds the Maximum FRUIT allowed
	 *
	 * @param numOfFruits - number of fruits
	 * @return true if the passed parameter exceeds the MAXIUM number of fruits
	 *         allowed for the SMOTHIE drink, false otherwise
	 */
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT)
			return true;
		else
			return false;
	}
	/**
	 * returns constant maximum number of alcohol beverages/per order offered by
	 * the beverage shop
	 *
	 * @return constant maximum number of alcohol beverages/per order offered by
	 *         the beverage shop
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ALCOHOL_PER_ORDER;
	}
	/**
	 * checks if the number of alcohol beverages for the current order has
	 * reached the maximum
	 *
	 * @return true if number of alcohol drinks for the current order has
	 *         reached the maximum , false otherwise
	 */
	public boolean isEligibleForMore() {
		if (numOfAlcoholDrink >= MAX_ALCOHOL_PER_ORDER)
			return false;
		else 
			return true;
	}
	/**
	 * returns the number of alcohol drinks for the current order
	 *
	 * @return returns the number of alcohol drinks for the current order
	 */
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}
	/**
	 * check the valid age for the alcohol drink
	 *
	 * @param age
	 *            the age
	 * @return returns true if age is more than minimum eligible age , false
	 *         otherwise
	 */
	public boolean isValidAge(int age) {
		if(age >= MIN_ALCOHOL_AGE)
			return true;
		else 
			return false;
	}
	/**
	 * Creates a new order , NO BEVERAGE is added to the order yet
	 *
	 * @param time
	 *            time of the order
	 * @param day
	 *            day of the order of type DAY
	 * @param customerName
	 *            customer name
	 * @param customerAge
	 *            customer age
	 */
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		// Order constructor - public Order(int orderTime, Day orderDay, Customer cust)
		// creating a new customer object...passing to it and THEN
		Customer customer = new Customer(customerName,  customerAge);
		// passing customer object to currentOrder
		currentOrder = new Order(time, day, customer );
		
		// Add the new order to the list of orders
	    orders.add(currentOrder);

	    // Reset the number of alcohol drinks for the new order
	    numOfAlcoholDrink = 0; // may need to add a counter within alcohol constructor
	}
	/**
	 * process the Coffee order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param extraShot
	 *            true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup
	 *            true if the coffee beverage has extra syrup , false otherwise
	 */

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		// Coffee constructor - public Coffee (String bevName, Size size, boolean extraShot, boolean extraSyrup)
		// Coffee coffee = new Coffee(bevName,  size,  extraShot,  extraSyrup);
		
		if (currentOrder == null) {
	        throw new IllegalStateException("No active order. Start a new order first."); 
	    }
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);	
	}
	/**
	 * process the Alcohol order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName - beverage name
	 * @param size - beverage size
	 */
	public void processAlcoholOrder(String bevName, Size size) {
		// alcohol constructor - public Alcohol(String bevName, Size size, boolean isWeekend) 
		// in Order - public void addNewBeverage(String bevName, Size size)
		currentOrder.addNewBeverage(bevName, size);
		numOfAlcoholDrink++; // alcohol counter
	}
	/**
	 * process the Smoothie order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param numOfFruits
	 *            number of fruits to be added
	 * @param addProtein
	 *            true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		// from Order - public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
		
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	/**
	 * locate an order based on the order number
	 *
	 * @param orderNo
	 *            the order number
	 * @return the index of the order in the list of Orders if found or -1 if
	 *         not found
	 */
	public int findOrder(int orderNo) {
		// loop array to search for "OrderNo" in "orders" arraylist
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo)
				return i; // meaning found
			
		}
		return -1; // meaning order not found. 
	}
	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 *
	 * @param orderNo
	 *            the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {
		// Orders are stored in a ArrayList<Order> orders. loop thru it
		// calcOrderTotal is in "Order" class
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo)
				return orders.get(i).calcOrderTotal(); // IF FOUND
									
		}
		return -1; // if order NOT found. 
	}
	
	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 *
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
		double total = 0;
		
		for (int i = 0; i < orders.size(); i++) {
			// System.out.println("orders " + i + ": " + orders.get(i));
			total += orders.get(i).calcOrderTotal();
		}	
		return total; // NOTE this is TOTAL sales and NOT MONTHLY Sales
	}
	/**
	 * returns total numbers of orders within the month
	 *
	 * @returns total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders() {
		int count = 0;
		
		for (int i = 0; i < orders.size(); i++) {
			count++;
		}	
		return count; // NOTE this is TOTAL sales and NOT MONTHLY Sales
		
	}
	/**
	 * returns the current Order located in the index in the list of orders.
	 * Notes: this method returns the shallow copy of the order
	 *
	 * @return the current order
	 */
	public Order getCurrentOrder() {
		
		if (orders.size() <= 0)
			return null;
		else
			return orders.get(orders.size()-1);	
	}
	/**
	 * returns Order in the list of orders at the index Notes: this method
	 * returns the shallow copy of the order
	 *
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders() {
		int n = orders.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()){
                	//if (arr[j].compareTo(arr[minIndex]) < 0) {  
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }	
	}
	/**
	 * An Overridden toString method: The string representation of all the orders and the total monthly sale.  
	 */
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Beverage Shop Orders:\n");
        for (int i = 0; i <orders.size(); i++) {
        	sb.append(orders.get(i).toString());
        }
        
        sb.append("\nTotal Monthly Sales: $").append(totalMonthlySale());
        return sb.toString();
    }
	
}
