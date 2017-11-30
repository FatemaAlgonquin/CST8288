package network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShannonsView extends JFrame implements Observer{
	ShannonsJTextFieldPanel panelText;
	ShannonsJSliderPannel panelSlider;
	//ResultPanel resultPanel;
	ShannonsJSpinner shannonsJSpinner;

	/**
	 * default constructor
	 */
	public ShannonsView() {
		super();
	}

	/**
	 * If there is any state change of the observable it updates the observers regarding the change.
	 * When bandwidth and signal to noise changes it update the maximum data rate.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof ShannonsModel) {
			ShannonsModel model = (ShannonsModel) o;
			double maxDR = model.getMaximumDataRate();
			double bandWidth = model.getBandwidth();
			double signalToNoise = model.getSignalToNoise();
			
			panelSlider.updateMDR(maxDR);
			panelText.updateMDR(maxDR);
			
			//resultPanel.updateMDR(maxDR);
			
			panelSlider.updateBandwidth(bandWidth);
			panelText.updateBandwidth(bandWidth);
			panelSlider.updateSignalToNoise(signalToNoise);
			panelText.updateSignalToNoise(signalToNoise);	
			
			shannonsJSpinner.updateMDR(maxDR);
			shannonsJSpinner.updateBandwidth(bandWidth);
			shannonsJSpinner.updateSignalToNoise(signalToNoise);
			
			
		}

	}

	/**
	 * createContentPanel method creates a new JPanel and adds the three panels to it.
	 * @return panel 
	 */
	private JPanel createContentPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.setBackground(Color.darkGray);
		panel.add(panelText);
		panel.add(panelSlider);
		//panel.add(resultPanel);
		panel.add(shannonsJSpinner);
		panel.setVisible(true);
		return panel;

	}

	/**
	 * setController method takes a ShannonsController obj and sets it to the parameterized 
	 * constructor for ShannonsJTextFieldPanel, ShannonsJSliderPannel, ResultPanel
	 * @param shannonsController
	 */
	public void setController(ShannonsController shannonsController) {
		shannonsController.AddObserver(this);
		panelText = new ShannonsJTextFieldPanel(shannonsController);
		panelSlider = new ShannonsJSliderPannel(shannonsController);
		//resultPanel = new ResultPanel(shannonsController);
		shannonsJSpinner = new ShannonsJSpinner(shannonsController);
	}

	/**
	 * Adds the panel to the frame for final display
	 */
	public void run() {
		final JFrame frame = new JFrame("Shannons Theorem");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(770, 700);
		frame.setLayout(new BorderLayout());
		frame.add(createContentPanel(), BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
