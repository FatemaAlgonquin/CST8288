package networktest;

import java.text.DecimalFormat;

import org.junit.Test;

import junit.framework.TestCase;
import network.ShannonsModel;

/**
 * JUnit tests for the ShannonsTheorem class from the "network" project.
 * 
 * @author Fatema Zohora
 * @version 1.0.0
 */

public class Test_ShannonsModel extends TestCase {

	/**
	 * Default constructor
	 */
	public Test_ShannonsModel() {
		super();
	}

	/** ShannonsTheorem object to call methods. */
	private ShannonsModel shannonsModel;
	/** DecimalFormat is used to get decimals to two decimal places */
	DecimalFormat df = new DecimalFormat("#.##");

	
	@Override
	protected void setUp() throws Exception {
		System.out.println("Setting it up!");	
	}
	
	@Override
	protected void tearDown() throws Exception {
		System.out.println("Running: tearDown !");
	}

	@Test
	/**
	 * Test default constructor
	 */
	public void testConstructor() {
		shannonsModel = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsModel);
	}

	@Test
	/**
	 * Test parameterized constructor
	 */
	public void testParameterizedConstructor() {
		shannonsModel = new ShannonsModel(3, 30);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsModel);
	}

	/**
	 * Test whether it handles negative input
	 */
	@Test
	public void testNegativeBandwidth() {
		boolean exception = false;
		try {
			shannonsModel = new ShannonsModel(3, 30);
			shannonsModel.setBandwidth(-3);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		assertTrue(exception);
	}

	/**
	 * Test whether it handles negative input
	 */
	@Test
	public void testNegativeSignalToNoise() {
		boolean exception = false;
		try {
			shannonsModel = new ShannonsModel(3, 30);
			shannonsModel.setSignalToNoise(-30);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		assertTrue(exception);
	}

	@Test
	/**
	 * Test method getBandwidth()
	 */
	public void testBandwidth() {
		shannonsModel = new ShannonsModel(3, 30);
		shannonsModel.setBandwidth(4.00);
		assertEquals(4.00, shannonsModel.getBandwidth(), 0);
	}

	@Test
	/**
	 * Test method getSignalToNoise()
	 */
	public void testSignalToNoise() {
		shannonsModel = new ShannonsModel(3, 30);
		shannonsModel.setSignalToNoise(40.00);
		assertEquals(40.00, shannonsModel.getSignalToNoise(), 0);
	}

	@Test
	/**
	 * Test method getMaximumDataRate
	 */
	public void testMaximumDataRate() {
		shannonsModel = new ShannonsModel(3, 30);
		assertEquals(29.90, Double.parseDouble(df.format(shannonsModel.getMaximumDataRate())), 0);
	}

	@Test
	/**
	 * Test method setBandwidth()
	 */
	public void testSetBandwidth() {
		shannonsModel = new ShannonsModel(3, 30);
		shannonsModel.setBandwidth(8.00);
		assertEquals(8.00, shannonsModel.getBandwidth(), 0);
	}

	@Test
	/**
	 * Test method setSignalToNoise
	 */
	public void testSetSignalToNoise() {
		shannonsModel = new ShannonsModel(3, 30);
		shannonsModel.setSignalToNoise(99.00);
		assertEquals(99.00, shannonsModel.getSignalToNoise(), 0);
	}

	/**
	 * Test the default value of bandwidth(0.0) and signal to noise ratio(0.0)
	 * with the getMaximumDataRate method
	 * 
	 */

	public void testDefaultValueGetMaximumDataRate() {
		shannonsModel = new ShannonsModel(0, 0);
		assertEquals(0.0, Double.parseDouble(df.format(shannonsModel.getMaximumDataRate())), 0);
	}

	@Test
	/**
	 * Test method toString
	 */
	public void testToString() {
		shannonsModel = new ShannonsModel(3.0, 30.0);
		String message = "Available bandwidth " + "3.0" + " hertz" + "\n" + "Availble signal to noise ratio " + "30.0"
				+ " decible " + "\n" + "After using  Shanons Theorem Maximum Data Rate is: " + "29.90"
				+ " bits per second";
		assertEquals(message, shannonsModel.toString());
	}

}
