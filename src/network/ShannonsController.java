package network;

import java.util.Observer;
/**
 * ShannonsController Interface holds the default behaviors for the ShannonsTheorem class.
 * @author Fatema
 *
 */
public interface ShannonsController {
	public void AddObserver(Observer o);
	public void setBandwidth(double bandwidth);
	public void setSignalToNoise(double signalToNoise);
}
