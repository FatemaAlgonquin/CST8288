package network;

import java.util.Observer;

@SuppressWarnings("unused")
public class ShannonsTheorem implements ShannonsController {
	ShannonsModel model = new ShannonsModel();

	/**
	 * Default constructor
	 */
	public ShannonsTheorem() {
		super();
	}

	/**
	 * Method getBandwidth returns the double bandwidth
	 * 
	 * @return getBandwidth returns double contains bandwidth
	 */

	public double getBandwidth() {
		return model.getBandwidth();
	}

	/**
	 * Method setBandwidth sets the double bandwidth
	 * 
	 * @param h
	 *            double which contains bandwidth
	 */

	public void setBandwidth(double h) {
		model.setBandwidth(h);
	}

	/**
	 * Method getSignalToNoise returns the double signal to noise ratio
	 * 
	 * @return getSignalToNoise returns double signalToNoiseRatio
	 */
	public double getSignalToNoise() {
		return model.getSignalToNoise();
	}

	/**
	 * Method setSignalToNoise sets the ratio of signal to noise ratio
	 * 
	 * @param snr
	 *            double which contains signal to noise ratio
	 */

	public void setSignalToNoise(double snr) {
		model.setSignalToNoise(snr);
	}

	/**
	 * Method getMaximumDataRate returns the double maximumDataRate (Maximum
	 * Data Rate)
	 * 
	 * @return maximumDataRate returns double which contains maximumDataRate
	 */

	public double getMaximumDataRate() {
		return model.getMaximumDataRate();
	}

	/**
	 * Adds to the observer list
	 */
	@Override
	public void AddObserver(Observer o) {
		model.addObserver(o);

	}

	/**
	 * Sets the model.
	 * 
	 * @param shannonsModel
	 */
	private void setModel(ShannonsModel shannonsModel) {
		this.model = shannonsModel;
	}

	/**
	 * Main point of execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ShannonsController controller = new ShannonsTheorem();
		ShannonsView view = new ShannonsView();
		view.setController(controller);
		view.run();
	}

}
