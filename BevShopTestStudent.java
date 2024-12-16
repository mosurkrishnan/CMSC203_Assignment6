import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
	
	BevShop shop;

	@BeforeEach
	public void setUp() throws Exception {
		shop = new BevShop();
	}

	@AfterEach
	public void tearDown() throws Exception {
		shop = null;
	}

	@Test
	public void testValidAgeForAlcohol() {
		System.out.println("Jane's age is valid: " + shop.isValidAge(22));
		assertTrue(shop.isValidAge(44)); // true
		assertFalse(shop.isValidAge(18)); // false
	}

	@Test
	public void testStartNewOrder() {
		
		shop.startNewOrder(10, Day.MONDAY, "Jane", 22); 
		Order currentOrder = shop.getCurrentOrder();
		
		assertFalse(currentOrder.equals(null)); // we just started an Order.class should NOT be be null
		assertTrue(currentOrder.getOrderTime() == 10); // verifying order time
		assertTrue(currentOrder.getOrderDay().equals(Day.MONDAY)); // verifying order DAY MONDAY
		 
		assertTrue(currentOrder.getCustomer().name.equalsIgnoreCase("Jane")); // verifying order DAY
			
	}

	@Test
	public void testProcessAlcoholLimit()  {
		// public int getMaxOrderForAlcohol() {
		shop.startNewOrder(10, Day.MONDAY, "John", 25); 
		assertTrue(shop.isEligibleForMore()); 
		shop.processAlcoholOrder("Martini", Size.SMALL);; // drink #1
		shop.processAlcoholOrder("whisky", Size.SMALL);; // drink #2
		assertTrue(shop.isEligibleForMore()); // SHOULD BE TRUE
		shop.processAlcoholOrder("vodka", Size.SMALL);; // drink #3 - eligibility is over
		assertFalse(shop.isEligibleForMore()); // False - should pass
		
	}
	
	@Test
	public void testTotalMonthlySale()  {// ***************NOT WORKING************************
		System.out.println("being developed");	
		shop.startNewOrder(10, Day.MONDAY, "John", 25);
		shop.processCoffeeOrder("Latte", Size.MEDIUM, true, true); // Base: 2.0, Size: 0.5, Extras: 1.0 = 3.5
		shop.processAlcoholOrder("Whiskey", Size.SMALL);          // Base: 2.0 = 2.0; Cumulative total $5.5
		shop.startNewOrder(14, Day.SATURDAY, "Anna", 30);
		shop.processSmoothieOrder("Mango Smoothie", Size.LARGE, 3, true); // Base: 2.0, Size: 1.0, Fruit: 1.5, Protein: 1.5 = $6.0
		// 2 customers - total sale = 11.5
		
        double total = shop.totalMonthlySale(); // ***************NOT WORKING************************
        
        assertTrue(total == 11.5);
	}
	
	@Test
	public void testProcessCoffeeOrder()  { // 
		// processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
		BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processCoffeeOrder("Latte", Size.MEDIUM, true, true); // 2.50 + 0.5 + 0.5 = 3.5

        Order currentOrder = shop.getCurrentOrder();
        assertEquals(1, currentOrder.getTotalItems()); // order should have 1 beverage
        assertEquals("Latte", currentOrder.getBeverage(0).getBevName()); // name should match
        assertTrue(currentOrder.calcOrderTotal() == 3.5); // match price of 3.5	
 
	}
	@Test
	public void testProcessAlcoholOrder()  { // 
		// processAlcoholOrder(String bevName, Size size) 
		BevShop shop = new BevShop();
		Customer c = new Customer("John", 25);
		Alcohol weekendSmall = new Alcohol("Whiskey", Size.SMALL, true); // SATURDAY
        shop.startNewOrder(10, Day.SATURDAY, c.name, c.age);
        shop.processAlcoholOrder("Whiskey", Size.SMALL); // 2.0 + 0.6 (weekend) = 2.6

        Order currentOrder = shop.getCurrentOrder();
        assertEquals(1, currentOrder.getTotalItems()); // order should have 1 beverage
        assertEquals("Whiskey", currentOrder.getBeverage(0).getBevName()); // name should match
        System.out.println("currentOrder.calcOrderTotal()" + currentOrder.calcOrderTotal());
        assertTrue(currentOrder.calcOrderTotal() == 2.6); // match price of2.6	

	}
	
	@Test
	public void testProcessSmoothieOrder()  { // THIS IS THE PROBLEM - MAY NOT WORK
		// processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
		BevShop shop = new BevShop();
		Customer c = new Customer("John", 25);
		Smoothie power = new Smoothie("Power", Size.LARGE, 5, true);  
		
        shop.startNewOrder(10, Day.SATURDAY, c.name, c.age);
        shop.processSmoothieOrder("Power", Size.LARGE, 5, true);; // 3 (size) + 2.5 (fuits) + 1.5 (protein) = 7
        
        
        Order currentOrder = shop.getCurrentOrder();
        shop.getCurrentOrder().calcOrderTotal();
        assertEquals(1, currentOrder.getTotalItems()); // order should have 1 beverage
        assertEquals("Power", currentOrder.getBeverage(0).getBevName()); // name should match
        assertTrue(currentOrder.calcOrderTotal() == 7.0); // match price of 7.0	

	}

}
