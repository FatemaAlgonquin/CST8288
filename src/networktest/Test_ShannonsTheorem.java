package networktest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Test;

import network.ShannonsTheorem;

public class Test_ShannonsTheorem {
	public Test_ShannonsTheorem() {
		super();
	}

	/** ShannonsTheorem object to call methods. */
	private ShannonsTheorem shannons = null;
	/** DecimalFormat is used to get decimals to two decimal places */
	DecimalFormat df = new DecimalFormat("#.##");

	protected void setUp() throws Exception {
		System.out.println("Setting it up!");
	}

	protected void tearDown() throws Exception {
		System.out.println("Running: tearDown !");
	}

	@Test
	/**
	 * Test default constructor
	 */
	public void testConstructor() {
		shannons = new ShannonsTheorem();
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannons);
	}

	/**
	 * Test whether it handles negative input
	 */
	@Test
	public void testNegativeBandwidth() {
		boolean exception = false;
		try {
			ShannonsTheorem shannons = new ShannonsTheorem();
			shannons.setBandwidth(-3);
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
			ShannonsTheorem shannons = new ShannonsTheorem();
			shannons.setSignalToNoise(-30);
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
		ShannonsTheorem shannons = new ShannonsTheorem();
		shannons.setBandwidth(4.00);
		assertEquals(4.00, shannons.getBandwidth(), 0);
	}

	@Test
	/**
	 * Test method getSignalToNoise()
	 */
	public void testSignalToNoise() {
		ShannonsTheorem shannons = new ShannonsTheorem();
		shannons.setSignalToNoise(40.00);
		assertEquals(40.00, shannons.getSignalToNoise(), 0);
	}

	@Test
	/**
	 * Test method getMaximumDataRate
	 */
	public void testMaximumDataRate() {
		ShannonsTheorem shannons = new ShannonsTheorem();
		shannons.setBandwidth(3);
		shannons.setSignalToNoise(30);

		assertEquals(29.90, Double.parseDouble(df.format(shannons.getMaximumDataRate())), 0);
	}

}
