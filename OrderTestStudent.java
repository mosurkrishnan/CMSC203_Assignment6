import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {

	Order orderOne, orderTwo, orderThree, orderFour;

	@BeforeEach
	public void setUp() throws Exception {
		orderOne = new Order(8, Day.MONDAY, new Customer("Mary", 22));
		orderTwo = new Order(12, Day.SATURDAY, new Customer("John", 45));
		orderThree = new Order(10, Day.SUNDAY, new Customer("Kate", 21));
	}

	@AfterEach
	public void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	public void testGetBeverage() {
		Coffee cf = new Coffee("regular Coffee", Size.SMALL, false, false);
//		Alcohol al = new Alcohol("Mohito", Size.SMALL, false);
//		Smoothie sm1 = new Smoothie("Detox", Size.MEDIUM, 1, false);
//		Smoothie sm2 = new Smoothie("Detox", Size.LARGE, 1, false);

		
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
//		orderOne.addNewBeverage("Mohito", Size.SMALL);
//		orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);
		System.out.println(orderOne.getBeverage(0));
		assertTrue(orderOne.getBeverage(0).equals(cf));
//		assertTrue(orderOne.getBeverage(1).equals(al));
//		assertTrue(orderOne.getBeverage(2).equals(sm1));
//		assertFalse(orderOne.getBeverage(2).equals(sm2));
	}
	@Test
    public void testTotalItems() {
        // Add a beverage and check the total items
        orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
        assertEquals(1, orderOne.getTotalItems());  // Should be 1
    }

	@Test
	public void testAddNewBeverage() throws NullPointerException {

		

	}

	@Test
	public void testCalcOrderTotal() {
		

	}

}
