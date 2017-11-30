package network;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * ResultPanel class displays the panel with calculation information.
 */
@SuppressWarnings({"unused", "serial"})

public class ResultPanel extends JPanel {
	private ShannonsController controller;
	private JTextField result;
	JLabel lblResult;
	JLabel lblCalculation1;
	JLabel lblCalculation2;
	JLabel lblCalculation3;
	JLabel lblCalculation4;

	/**
	 * parameterized constructor
	 * @param controller this is ShannonsController type parameter
	 */
	public ResultPanel(ShannonsController controller) {
		this.controller = controller;
		setLayout(new GridLayout(3, 2));
		createPanel();
	}

	/**
	 * createPanel method creates a panel and adds its components to add.
	 */
	public void createPanel() {
		lblCalculation1 = new JLabel("Function to apply Shannon's Theorem for capacity:");
		lblCalculation2 = new JLabel("MDR = (H) [log2(1 + s/n)] \n");
		lblCalculation3 = new JLabel("MDR = maximum data rate ");
		lblCalculation4 = new JLabel("H = bandwidth in Herz S/N = signal to noise (SNR)");

		lblResult = new JLabel("Updated maximum data rate (kbps): ");

		result = new JTextField(20);
		this.add(lblCalculation1);
		this.add(lblCalculation2);
		this.add(lblCalculation3);
		this.add(lblCalculation4);
		this.add(lblResult);
		this.add(result);
		this.setBackground(Color.yellow);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setVisible(true);

	}

	/**
	 * updateMDR takes double as a parameter and sets the maximum data rate value. 
	 * @param mdr double which contains maximum data rate value
	 */
	public void updateMDR(double mdr) {
		result.setText(String.valueOf(mdr));
	}

}
