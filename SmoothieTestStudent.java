import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	Smoothie smoothBasic;
	Smoothie smoothBasicDuplicate;
	Smoothie SmoothMedium;
	Smoothie SmoothPower;
	
	@BeforeEach
	public void setUp() throws Exception {
		// (String bevName, Size size, int numOfFruits, boolean addProtein)
		smoothBasic = new Smoothie("Basic", Size.SMALL, 0, false);
				// ("Basic", Size.SMALL, false, false );
		smoothBasicDuplicate = new Smoothie("Basic", Size.SMALL, 0, false);
		SmoothMedium = new Smoothie("Medium", Size.MEDIUM, 5, false);
		SmoothPower = new Smoothie("Power", Size.LARGE, 5, true);
	}

	@AfterEach
	public void tearDown() throws Exception {
		smoothBasic =  smoothBasicDuplicate = SmoothMedium = SmoothPower =null;	 
	}

	@Test
	public void testCalcPrice() {
		assertTrue(smoothBasic.calcPrice() == 2.0); // 2 size + 0 = 2.0
		assertTrue(SmoothMedium.calcPrice() == 5); // 2.5 size  + 5x0.5 = 5
		assertTrue(SmoothPower.calcPrice() == 7); // 3 size + 5x0.5 + 1.5 = 7.0
	}

	@Test
	public void testToString() {
		assertTrue(smoothBasic.toString().equalsIgnoreCase("Basic, SMALL,  Protein: false,  No of Fruits: 0 Price: 2.0"));
		assertTrue(SmoothMedium.toString().equalsIgnoreCase("Medium, MEDIUM,  Protein: false,  No of Fruits: 5 Price: 5.0"));
		assertTrue(SmoothPower.toString().equalsIgnoreCase("Power, LARGE,  Protein: true,  No of Fruits: 5 Price: 7.0"));
		 
	}

	
	@Test
	public void testEquals()  { // compafring alcohol objects
		assertTrue(smoothBasic.equals(smoothBasicDuplicate)); // IS TRUE - they have same characterestics
		assertFalse(smoothBasic.equals(SmoothPower)); // two entirely differrent objects should prove false
	}

}