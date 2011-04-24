package BluetoothNotify.Bluetooth;

import BluetoothNotify.Main;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

/**
 *
 * @author FH
 */
public class DataConnection implements Runnable {

	private Main main;

	public DataConnection(Main main) {
		this.main = main;
	}

	public void start(String ConnectionURL) {
	}

	public void run() {

		try {
			StreamConnection connection = (StreamConnection) Connector.open(btConnectionURL);

			//
			// open an input stream to get some data
			//

			InputStream in = connection.openInputStream();

			byte[] serialData;
			readData = true;
			while (readData == true) {
				int lengthavai = 0;
				lengthavai = in.available();

				if (lengthavai > 0) {
					serialData = new byte[lengthavai];
					int length = in.read(serialData);
					System.out.println("data read: " + new String(serialData));
					dataViewForm.append(new String(serialData));
				}
			}

			in.close();
			connection.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
