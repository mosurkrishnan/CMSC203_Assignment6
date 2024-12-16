import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	Coffee smallShotNosyrup;
	Coffee smallShotNosyrupDuplicate;
	Coffee mediumNoshotNosyrup;
	Coffee largeShot;

	 
	@BeforeEach
	public void setUp() throws Exception {
		smallShotNosyrup = new Coffee("Machiato", Size.SMALL, true, false);
		smallShotNosyrupDuplicate = new Coffee("Machiato", Size.SMALL, true, false);
		mediumNoshotNosyrup = new Coffee("Machiato", Size.MEDIUM, false, false);
		largeShot = new Coffee("Machiato", Size.LARGE, false, false);

	}

	@AfterEach
	public void tearDown() throws Exception {
		smallShotNosyrup =  mediumNoshotNosyrup = largeShot = smallShotNosyrupDuplicate =null;
		 
	}

	@Test
	public void testCalcPrice() {
		assertTrue(smallShotNosyrup.calcPrice() == 2.5); // 2 size + 0.5 shot = 2.5
		assertTrue(mediumNoshotNosyrup.calcPrice() == 2.5); // 2.5 size  + 0 = 2.5
		assertTrue(largeShot.calcPrice() == 3); // 3 size = 3.0
	}

	@Test
	public void testToString() {
		assertTrue(smallShotNosyrup.toString().equalsIgnoreCase("Machiato, SMALL, Extra Shot: Yes, Extra Syrup: No, Price: 2.5"));
		assertTrue(mediumNoshotNosyrup.toString().equalsIgnoreCase("Machiato, MEDIUM, Extra Shot: No, Extra Syrup: No, Price: 2.5"));
		assertTrue(largeShot.toString().equalsIgnoreCase("Machiato, LARGE, Extra Shot: No, Extra Syrup: No, Price: 3.0"));
		 
	}

	
	@Test
	public void testEquals()  { // compafring alcohol objects
		assertTrue(smallShotNosyrup.equals(smallShotNosyrupDuplicate)); // IS TRUE - they have same characterestics
		assertFalse(smallShotNosyrup.equals(mediumNoshotNosyrup)); // two entirely differrent objects should prove false
	}

}



