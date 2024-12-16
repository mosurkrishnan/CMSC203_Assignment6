import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class AlcoholTestStudent {

	Alcohol weekdaySmall;
	Alcohol weekdaySmallDuplicate;
	Alcohol weekendMedium;
    Alcohol weekendLarge;

	@BeforeEach
	public void setUp() throws Exception {
		weekdaySmall = new Alcohol("Whiskey", Size.SMALL, false);
		weekdaySmallDuplicate = new Alcohol("Whiskey", Size.SMALL, false);
        weekendMedium = new Alcohol("Vodka", Size.MEDIUM, true);
        weekendLarge = new Alcohol("Rum", Size.LARGE, true);
	}

	@AfterEach
	public void tearDown() throws Exception {
		weekdaySmall = weekdaySmallDuplicate = weekendMedium = weekendLarge = null;
	}

	@Test
	public void testCalcPrice() {
		// SMALL size on a weekday: Only base price
		assertTrue(weekdaySmall.calcPrice() == 2.0);
		assertTrue(weekendMedium.calcPrice() == 3.1);
		assertTrue(weekendLarge.calcPrice() == 3.6); // 3 for large, 0.6 for weekend
	}

	@Test
	public void testToString() {
		assertTrue(weekdaySmall.toString().equalsIgnoreCase("Whiskey, SMALL,  is it weekend: false,  Price: 2.0"));
		assertTrue(weekendMedium.toString().equalsIgnoreCase("Vodka, MEDIUM,  is it weekend: true,  Price: 3.1"));
		assertTrue(weekendLarge.toString().equalsIgnoreCase("Rum, LARGE,  is it weekend: true,  Price: 3.6"));
	}

	@Test
	public void testIsWeekend()  {
		assertFalse(weekdaySmall.isWeekend()); // weekdaySmall should return False or show an error
		assertTrue(weekendMedium.isWeekend()); // should return true
		assertTrue(weekendLarge.isWeekend()); // should return true
	}
	
	@Test
	public void testSetWeekend()  {
		weekdaySmall.setWeekend(true); // we are changing wwekday to weekend. should return true
		assertTrue(weekdaySmall.isWeekend());
		
		weekendMedium.setWeekend(false); // we are changing weekend to a weekday drink - becomes weekday now
										// so, assertFalse should turn green
		assertFalse(weekendMedium.isWeekend());
	}
	
	@Test
	public void testEquals()  { // compafring alcohol objects
		assertTrue(weekdaySmall.equals(weekdaySmallDuplicate)); // IS TRUE - they have same characterestics
		assertFalse(weekendMedium.equals(weekdaySmall)); // two entirely differrent objects should prove false
		
	}

}
