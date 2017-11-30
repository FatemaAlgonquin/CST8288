package network;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ShannonsJSpinner extends JPanel{
	private ShannonsController controller;
	JSpinner.NumberEditor editor;
	JSpinner bSpinner;
	JSpinner sSpinner;
	JSpinner mdrSpinner;
	
	
	/**
	 * parameterized constructor
	 * @param controller this constructor takes a ShannonsController type object as a parameter.
	 */
	public ShannonsJSpinner(ShannonsController controller) {
	
	    
		this.controller = controller;
		createPanel();
		eventHandler();
		setLayout(new GridLayout(3,0));
		
	}
	
	public void createPanel() {
	    SpinnerModel value = new SpinnerNumberModel(0.0, //initial value  
	            0.0, //minimum value  
	            9000.0, //maximum value  
	            1.0); //step 
		
		
		
		bSpinner = new JSpinner(value);
		//editor = new JSpinner.NumberEditor(bSpinner);
		//bSpinner.setEditor(editor);
		
		
		
		JLabel label1 = new JLabel("Bandwidth(HZ)");
		bSpinner.setPreferredSize(new Dimension(128, 16));	
		this.add(label1);
		this.add(bSpinner);
		
		
		
		SpinnerModel valueS = new SpinnerNumberModel(0.0, //initial value  
	            0.0, //minimum value  
	            3000.0, //maximum value  
	            1.0); //step 
		sSpinner = new JSpinner(valueS);
		JLabel label2 = new JLabel("Signal To Noise (db)");
		this.add(label2);
		this.add(sSpinner);
		
		
		SpinnerModel valueM = new SpinnerNumberModel(0.0, //initial value  
	            0.0, //minimum value  
	            9000.0, //maximum value  
	            1.0); //step 
		mdrSpinner = new JSpinner(valueM);
		JLabel label3 = new JLabel("Maximum Data Rate");
		this.add(label3);
		this.add(mdrSpinner);
			
		this.setBackground(Color.ORANGE);
		this.setVisible(true);
	}
	
	
		public void eventHandler() {
			bSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					
					double bandwithValue = (double) bSpinner.getValue();
					//bSpinner.getModel().setValue(bandwithValue);
					controller.setBandwidth(bandwithValue);
				}
			});
			
			sSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					double signalToNoiseValue = (double) sSpinner.getValue();
					controller.setSignalToNoise(signalToNoiseValue);
				}
			});
	}
		
		public void updateMDR(double mdr) {
			mdrSpinner.setValue((double) mdr);
		}
		
		public void updateBandwidth(double b) {
			bSpinner.setValue((double) b);
		}
		
		public void updateSignalToNoise(double s) {
			sSpinner.setValue((double) s);
		}

}
