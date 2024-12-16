import java.util.Scanner;
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
public class BevShopDriverApp {

	private static Size size;
	private static Day day;

	public static void main(String[] args) {
		
		boolean newOrder = true; // for a newOrder. while loop will make it loop back for next order
		String name; // name of customer
		int age;
		boolean ageAppropriate = false;
		boolean isWeekend = false;
		int time;
		
		Scanner keypad = new Scanner(System.in);
		BevShop shop = new BevShop();
		
		boolean isValidInput = false;
        boolean response = false;
		System.out.println("Welcome to Bradley Beverage Shop");
		System.out.println("Would you like to start a new order - Press Y for Yes or N for No");
		String input = keypad.nextLine().toUpperCase();

        if (input.equals("Y")) {
            response = true;
            isValidInput = true;
        } else if (input.equals("N")) {
            response = false;
            isValidInput = true;
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
        }
        
		while (response)
		{
			System.out.println("#--------------------------------------------------#");
			System.out.println("Starting a new order.");
            day = Day.MONDAY;
            int orderTime = 10; // as in 10 AM for example
            
            System.out.println("The current order in process can have at most " + BevShop.MAX_ORDER_FOR_ALCOHOL + " alcoholic beverages.");
            System.out.println("The minimum age to order alcohol drink is " + BevShop.MIN_AGE_FOR_ALCOHOL);
    		System.out.println("Start please a new order:");
    		System.out.println("Your Total Order for now is 0.0" );
    																			// get customer details
    		System.out.println("Would you please enter your name John");
    		name = "John";
    		System.out.println("Would you please enter your age 23");
    		
    		age = 23;
    		
    		// Creating Order object - also creates Customer object
    		Customer customer = new Customer(name, age);
    		Order order = new Order(orderTime, day, customer); 		    		
    		
    		if (age >= BevShop.MIN_AGE_FOR_ALCOHOL) {
    			System.out.println("Your age is above 21 and you are eligible to order alcohol"); }
    		
    		// BevShop - startNewOrder(int time, Day day, String customerName, int customerAge)
    		shop.startNewOrder(orderTime, day, name, age);
    		//***************************************ORDER #1****************************************************
    		// DRINK #1 ORDER
    		System.out.println("Would you please add an alcohol drink ");
    		shop.processAlcoholOrder("Wine", Size.SMALL);
    		order.addNewBeverage(name, Size.SMALL);
    		// Alcohol alcohol = new Alcohol("Wine", Size.SMALL, false);
    									// String bevName, Size size, boolean isWeekend	
    		// order.addNewBeverage("Wine", Size.SMALL);
    		// public void addNewBeverage(String bevName, Size size) {
    		System.out.println("The current order of drinks is " + order.getTotalItems());	
    		System.out.println("The Total price on the Order is " + order.calcOrderTotal());
    		System.out.println("Your current alcohol drink order is less than  " + (1+ shop.MAX_ORDER_FOR_ALCOHOL));
    		if(!shop.isEligibleForMore())
    			System.out.println("You have a maximum alcohol drinks for this order" );	
    		//*******************************************************************************************
    		// DRINK #2 ORDER
    		System.out.println("Would you please add an alcohol drink ");
    		shop.processAlcoholOrder("Beer", Size.LARGE);
    		order.addNewBeverage("Beer", Size.LARGE);
    		// Alcohol alcohol = new Alcohol("Wine", Size.SMALL, false);
    									// String bevName, Size size, boolean isWeekend	
    		// order.addNewBeverage("Wine", Size.SMALL);
    		// public void addNewBeverage(String bevName, Size size) {
    		System.out.println("The current order of drinks is " + order.getTotalItems());	
    		System.out.println("The Total price on the Order is " + order.calcOrderTotal());
    		System.out.println("Your current alcohol drink order is less than  " + (1+ shop.MAX_ORDER_FOR_ALCOHOL));
    		if(!shop.isEligibleForMore())
    			System.out.println("You have a maximum alcohol drinks for this order" );	
    		//*******************************************************************************************
    		// DRINK #2 ORDER
    		System.out.println("Would you please add an alcohol drink ");
    		shop.processAlcoholOrder("Whisky", Size.MEDIUM);
    		order.addNewBeverage("Whisky", Size.MEDIUM);
    		// Alcohol alcohol = new Alcohol("Wine", Size.SMALL, false);
    									// String bevName, Size size, boolean isWeekend	
    		// order.addNewBeverage("Wine", Size.SMALL);
    		// public void addNewBeverage(String bevName, Size size) {
    		System.out.println("The current order of drinks is " + order.getTotalItems());	
    		System.out.println("The Total price on the Order is " + order.calcOrderTotal());
    		System.out.println("Your current alcohol drink order is less than  " + (1+ shop.MAX_ORDER_FOR_ALCOHOL));
    		if(!shop.isEligibleForMore())
    			System.out.println("You have a maximum alcohol drinks for this order" );	
    		//*******************************************************************************************
    		// 1st Order continued- COFFEE #1 
    		System.out.println("Would you please add a COFFEE to your order: ");
    		boolean extraShot = true;
    		boolean extraSyrup = true;
    		shop.processCoffeeOrder("Latte", Size.LARGE, extraShot, extraSyrup);
    		order.addNewBeverage("Latte", Size.LARGE, extraShot, extraSyrup);
    		// BevShop - public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
    		// ORDER public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
    		System.out.println("The current order of drinks is " + order.getTotalItems());	
    		System.out.println("The Total price on the Order is " + order.calcOrderTotal());
    		System.out.println("#--------------------------------------------------#");
    		
    		// 	ASSUME CUSTOMER CLOSES OUT ORDER
    		
    		response = false;
    		//CLOSE OUT ORDER
		}
    		//****************************************ORDER #2***************************************************
    		System.out.println("Would you like to start a new order - Press Y for Yes or N for No");
    		input = keypad.nextLine().toUpperCase();

            if (input.equals("Y")) {
                response = true;
                isValidInput = true;
            } else if (input.equals("N")) {
                response = false;
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
            
         // BEVERAGE #1 Order #2 - COFFEE #1 
            
            while (response)
    		{
                System.out.println("Starting a new order.");
                day = Day.MONDAY;
                int orderTime = 11; // as in 11 AM for example
                

                System.out.println("The current order in process can have at most " + BevShop.MAX_ORDER_FOR_ALCOHOL + " alcoholic beverages.");
                System.out.println("The minimum age to order alcohol drink is " + BevShop.MIN_AGE_FOR_ALCOHOL);
        		System.out.println("Start please a new order:");
        		System.out.println("Your Total Order for now is 0.0" );
        																			// get customer details
        		System.out.println("Would you please enter your name: Ray");
        		 name = "Ray";
        		System.out.println("Would you please enter your age: 18");
        		
        		age = 18;
        		
        		// Creating Order object - also creates Customer object
        		Customer customer = new Customer(name, age);
        		Order order = new Order(orderTime, day, customer); 		    		
        		
        		if (age >= BevShop.MIN_AGE_FOR_ALCOHOL) {
        			System.out.println("Your age is above 21 and you are eligible to order alcohol"); }
        		
        		// BevShop - startNewOrder(int time, Day day, String customerName, int customerAge)
        		shop.startNewOrder(orderTime, day, name, age);
        		//*******************************************************************************************
        		// Beverage #1 ORDER #2
        		System.out.println("Would you please add a SMOOTHIE to order ");
        		int numOfFruits = 5;
        		boolean addProtein = true;
        		shop.processSmoothieOrder("Combo", Size.LARGE, numOfFruits, addProtein);
        		order.addNewBeverage("Combo", Size.LARGE, numOfFruits, addProtein);
        		// ORDER public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        		// BEVSHOP public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
        		System.out.println("The current order of drinks is " + order.getTotalItems());	
        		System.out.println("The Total price on the Order is " + order.calcOrderTotal());
        		
        		//******************************************************************************************* 
        		// Beverage #2 ORDER #2
        		
        		System.out.println("Would you please add a SMOOTHIE to order: ");
        		System.out.println("Would you please add a COFFEE to your order: ");
        		boolean extraShot = true;
        		boolean extraSyrup = true;
        		shop.processCoffeeOrder("Latte", Size.LARGE, extraShot, extraSyrup);
        		order.addNewBeverage("Latte", Size.LARGE, extraShot, extraSyrup);
        		// BevShop - public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
        		// ORDER public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
        		System.out.println("The current order of drinks is " + order.getTotalItems());	
        		System.out.println("The Total price on the Order is " + order.calcOrderTotal());
        		//******************************************************************************************* 
        		// Beverage #3 - DISQUALIFIED ORDER #2
        		
        		System.out.println("Would you please add a drink: ");
        		if (age >= BevShop.MIN_AGE_FOR_ALCOHOL) {
        			System.out.println("Your age is above 21 and you are eligible to order alcohol"); }
        		
        		System.out.println("The current order of drinks is: " + order.getTotalItems());	
        		System.out.println("The Total price on the Order is: " + order.calcOrderTotal());
        		System.out.println("The total number of fruits is: " + shop.getMaxNumOfFruits());
        		// The total number of fruits is 5
        		if(shop.isMaxFruit(numOfFruits))
        			System.out.println("You reached a Maximum number of fruits");
        		System.out.println("Total price on the second Order:: " + order.calcOrderTotal());
        				
	            // ASSUME CUSTOMER CLOSES OUT ORDER
	    		response = false;
	    		//CLOSE OUT ORDER
	    		//Total price on the second Order: 16.0
	    		// Total amount for all Orders: 27.0

    		}
            System.out.println("\nTotal amount for all Orders: " + shop.totalMonthlySale());
            System.out.println("");
            System.out.println("#--------------------------------------------------#");
            System.out.println("            THE END - SHOP CLOSES");
            System.out.println("#--------------------------------------------------#");
    		//****************************** 		 
		}	

}

	

