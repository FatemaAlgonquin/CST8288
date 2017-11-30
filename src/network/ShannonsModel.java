
package network; /*	Package for class placement	*/

import java.util.Observable;

/**
 * This class contains required data to implement ShannonsTheorem. The user also
 * requested to provide the necessary input such as bandwidth and signal to
 * noise ration in double. Using ShannonsTheorem it calculates maximum data rate
 * in bits per second and display the result.
 * 
 * @author Fatema Zohora
 * @version 1.0.0 Sep 20, 2017
 */

public class ShannonsModel extends Observable {

	private double bandwidth;
	/** input: double bandwidth (hertz) */
	private double signalToNoiseRatio;
	/** input: double signal To Noise Ratio (decibles) */
	private static final double PRECISION = 100d;
	boolean updating;

	/** Default constructor. */
	public ShannonsModel() {
		super();
	}

	/**
	 * parameterized constructor
	 * 
	 * @param bwidth
	 *            double contains bandwidth
	 * @param snr
	 *            double which contains signal to noise ratio
	 */

	public ShannonsModel(double bwidth, double snr) {
		super();
		setBandwidth(bwidth);
		setSignalToNoise(snr);
	}

	/**
	 * Method getBandwidth returns the double bandwidth
	 * 
	 * @return getBandwidth returns double contains bandwidth
	 */

	public double getBandwidth() {
		return bandwidth;
	}

	/**
	 * Method setBandwidth sets the double bandwidth
	 * 
	 * @param h
	 *            double which contains bandwidth
	 */

	public void setBandwidth(double h) {
		//if (!this.updating) {
			//updating = true;
			if (h < 0) {
				throw new IllegalArgumentException("Bandwidth cannot be a negative value");
			}
			this.bandwidth = h;
			this.setChanged();
			this.notifyObservers();
			//updating = false;
		//}
	}

	/**
	 * Method getSignalToNoise returns the double signal to noise ratio
	 * 
	 * @return getSignalToNoise returns double signalToNoiseRatio
	 */
	public double getSignalToNoise() {
		return signalToNoiseRatio;
	}

	/**
	 * Method setSignalToNoise sets the ratio of signal to noise ratio
	 * 
	 * @param snr
	 *            double which contains signal to noise ratio
	 */

	public void setSignalToNoise(double snr) {
		//if (!this.updating) {
			//updating = true;
			if (snr < 0) {
				throw new IllegalArgumentException("Signal to Noise Ratio (decible) cannot be a negative value");
			} else
				this.signalToNoiseRatio = snr;
			this.setChanged();
			this.notifyObservers();
			//updating = false;
		//}

	}

	/**
	 * Method getMaximumDataRate returns the double maximumDataRate (Maximum
	 * Data Rate)
	 * 
	 * @return maximumDataRate returns double which contains maximumDataRate
	 */

	public double getMaximumDataRate() {
		double result = getMaximumDataRate(getBandwidth(), getSignalToNoise());

		if (Double.isInfinite(result)) {
			return Double.POSITIVE_INFINITY;
		}

		double newResult = Math.round(result * PRECISION) / PRECISION;
		return newResult;
	}

	/**
	 * Method getMaximumDataRate returns the double maximumDataRate (Maximum
	 * Data Rate)
	 * 
	 * @param hertz
	 *            double bandwidth
	 * @param signalToNoise
	 *            double signal To Noise Ratio
	 * @return maximumDataRate returns double maximum Data Rate after
	 *         calculation
	 */
	private double getMaximumDataRate(double hertz, double signalToNoise) {
		double maximumDataRate;
		maximumDataRate = (hertz * (Math.log(1 + Math.pow(10, signalToNoise / 10)) / Math.log(2)));
		//
		return maximumDataRate;
	}

	/**
	 * Returns a string containing all the information entered by user and
	 * calculated maximum data rate
	 * 
	 * @return String contains bandwidth (hertz), signal to noise ration
	 *         (decibel) and maximum data rate (bits per second)
	 */

	public String toString() {
		return "Available bandwidth " + getBandwidth() + " hertz" + "\n" + "Availble signal to noise ratio "
				+ getSignalToNoise() + " decible " + "\n" + "After using  Shanons Theorem Maximum Data Rate is: "
				+ String.format("%.2f", getMaximumDataRate()) + " bits per second";

	}

} /* End of CLASS: ShannonsTheorem.java */