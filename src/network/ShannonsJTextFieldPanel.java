package network;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ShannonsJTextFieldPanel extends JPanel {

	JTextField tMDR;
	JTextField tBandwidth;
	JTextField tSignalToNoise;
	private ShannonsController controller;

	/**
	 * parameterized constructor
	 * @param controller this constructor takes a ShannonsController type object as a parameter.
	 */
	public ShannonsJTextFieldPanel(ShannonsController controller) {
		this.controller = controller;
		createPanel();
		eventHandler();
		setLayout(new GridLayout(0, 2));
	}

	/**
	 * creates the panel with JTextField and corresponding labels for three fields.
	 * 1. Bandwidth
	 * 2. signal to noise ration 
	 * 3. maximum data rate
	 */
	public void createPanel() {
		JLabel lblBandwidth = new JLabel("Bandwidth(HZ)");
		tBandwidth = new JTextField(20);
		tBandwidth.setText("0");
		lblBandwidth.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblSignalToNoise = new JLabel("Signal To Noise (db)");
		tSignalToNoise = new JTextField(20);
		tSignalToNoise.setText("0");

		JLabel lblMDR = new JLabel("Maximum Data Rate");
		tMDR = new JTextField(20);

		this.add(lblBandwidth);
		this.add(tBandwidth);
		this.add(lblSignalToNoise);
		this.add(tSignalToNoise);
		this.add(lblMDR);
		this.add(tMDR);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.lightGray);
		this.setVisible(true);
	}

	/**
	 * Handling events.When a users enters data to the corresponding filed and hits enter it will update the 
	 * maximum data rate filed.
	 */
	public void eventHandler() {
		tBandwidth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!tBandwidth.getText().startsWith("-") && !tBandwidth.getText().isEmpty()
							&& Double.parseDouble(tBandwidth.getText()) >= 0) {
						controller.setBandwidth(Double.parseDouble(tBandwidth.getText()));
					} else {
						JOptionPane.showMessageDialog(null, "Enter a non negative number for bandwidth (hertz)",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Enter a non negative number for bandwidth (hertz)", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException i) {
					JOptionPane.showMessageDialog(null, "Enter a non negative number for bandwidth (hertz)", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		tSignalToNoise.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!(tSignalToNoise.getText().startsWith("-"))
							&& Double.parseDouble(tSignalToNoise.getText()) >= 0) {
						controller.setSignalToNoise(Double.parseDouble(tSignalToNoise.getText()));
					} else {
						JOptionPane.showMessageDialog(null,
								"Enter a valid number for signal to noise ratio in (decible)s", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Enter a valid number for signal to noise ratio in (decible)s",
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException exception) {
					JOptionPane.showMessageDialog(null, "Enter a valid number for signal to noise ratio in (decible)s",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * updateMDR takes double as a parameter and sets the maximum data rate value.
	 * @param mdr double which contains maximum data rate value.
	 */
	public void updateMDR(double mdr) {
		tMDR.setText(String.valueOf(mdr));
	}
	
	/**
	 * updateBandwidth takes double as a parameter and sets the bandwidth value.
	 * @param b double which contains bandwidth value
	 */
	public void updateBandwidth(double b) {
		tBandwidth.setText(String.valueOf(b));
	}
	
	/**
	 * updateSignalToNoise takes double as a parameter and sets the signal to noise value.
	 * @param s double which contains signal to noise value
	 */
	public void updateSignalToNoise(double s) {
		tSignalToNoise.setText(String.valueOf(s));
	}

}
