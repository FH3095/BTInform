package BluetoothNotify;

import BluetoothNotify.Bluetooth.Client;
import BluetoothNotify.Bluetooth.DataConnection;
import BluetoothNotify.Visual.VisualMain;
import javax.microedition.midlet.MIDlet;

/**
 * @author FH
 */
public class Main extends MIDlet {

	private Client bluetoothClient;
	private DataConnection dataConnection;
	private VisualMain visualMain;
	private boolean paused;

	public Main() {
		paused = false;
		bluetoothClient = new Client(this);
		dataConnection = new DataConnection(this);
		visualMain = new VisualMain(this);
	}

	public void startApp() {
		if (paused == true) {
			resumeApp();
		} else {
			visualMain.startMIDlet();
		}
	}

	public void pauseApp() {
		paused = true;
		visualMain.pauseMIDlet();
	}

	public void resumeApp() {
		paused = false;
		visualMain.resumeMIDlet();
	}

	public void exitApp() {
		destroyApp(true);
	}

	public void destroyApp(boolean unconditional) {
		paused = false;
		visualMain.destroyMIDlet();
		notifyDestroyed();
	}

	public Client getBluetoothClient() {
		return bluetoothClient;
	}

	public VisualMain getVisualMain() {
		return visualMain;
	}

	public DataConnection getDataConnection() {
		return dataConnection;
	}
}
