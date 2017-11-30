package network;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ShannonsJSliderPannel extends JPanel {

	private ShannonsController controller;
	JSlider bSlider;
	JSlider sSlider;
	JSlider mdrSlider;

	/**
	 * parameterized constructor
	 * @param controller this constructor takes a ShannonsController type object as a parameter.
	 */
	public ShannonsJSliderPannel(ShannonsController controller) {
		this.controller = controller;
		createPanel();
		eventHandler();
		setLayout(new GridLayout(3, 2));
	}

	
	/**
	 * creates three different sliders 
	 * 1. slider to adjust bandwidth
	 * 2. slider to adjust signal to noise ration
	 * 3. slider to adjust maximum data rate
	 */
	public void createPanel() {

		bSlider = new JSlider(JSlider.HORIZONTAL, 0, 9000, 0);
		bSlider.setMinorTickSpacing(100);
		bSlider.setMajorTickSpacing(1000);
		bSlider.setPaintLabels(true);
		bSlider.setPaintTicks(true);
		addDescToSlider(bSlider, "Bandwidth(HZ)");

		sSlider = new JSlider(JSlider.HORIZONTAL, 0, 3000, 0);
		sSlider.setMinorTickSpacing(100);
		sSlider.setMajorTickSpacing(300);
		sSlider.setPaintLabels(true);
		sSlider.setPaintTicks(true);
		addDescToSlider(sSlider, "Signal to Nosie Ration(db)");

		mdrSlider = new JSlider(JSlider.HORIZONTAL, 0, 9000, 0);
		mdrSlider.setMinorTickSpacing(100);
		mdrSlider.setMajorTickSpacing(1000);
		mdrSlider.setPaintLabels(true);
		mdrSlider.setPaintTicks(true);
		mdrSlider.setEnabled(false);
		addDescToSlider(mdrSlider, "Maximum Data Rate(kbps)");

	}

	/**
	 * Adds a slider to the slider panel 
	 * 
	 * @param s
	 *            the slider
	 * @param description
	 *            the slider description
	 */
	private void addDescToSlider(JSlider s, String description) {

		this.add(new JLabel(description));
		this.add(s);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.CYAN);
		this.setVisible(true);
	}

	/**
	 * Handling events. When a slides the corresponding jTextField value changes.
	 */
	
	public void eventHandler() {
		bSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int bandwithValue = bSlider.getValue();
				controller.setBandwidth(bandwithValue);
			}
		});

		sSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int signalToNoiseValue = sSlider.getValue();
				controller.setSignalToNoise(signalToNoiseValue);
			}
		});
	}

	/**
	 * updateMDR takes double as a parameter and sets the maximum data rate value.
	 * @param mdr  double which contains maximum data rate value.
	 */
	public void updateMDR(double mdr) {
		mdrSlider.setValue((int) mdr);
	}

	/**
	 * updateBandwidth takes double as a parameter and sets the bandwidth value.
	 * @param b  double which contains bandwidth value
	 */
	
	public void updateBandwidth(double b) {
		bSlider.setValue((int) b);
	}
	
	/**
	 * updateSignalToNoise takes double as a parameter and sets the signal to noise ratio value.
	 * @param s double which contains signal to noise value
	 */
	public void updateSignalToNoise(double s) {
		sSlider.setValue((int) s);
	}

}
