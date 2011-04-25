package BluetoothNotify.Bluetooth;

import BluetoothNotify.Main;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

/**
 *
 * @author FH
 */
public class DataConnection implements Runnable {

	private Main main;
	private Thread me;
	private boolean stop;
	private String connectionURL;
	private DataConnectionEventListener listener;
	private final Object mutex;
	private InputStream in;
	private OutputStream out;

	public DataConnection(Main main) {
		mutex = new Object();
		this.main = main;
		connectionURL = "";
		reInit();
	}

	private void reInit() {
		stop = false;
		me = null;
		listener = null;
		in = null;
		out = null;
	}

	public void start(DataConnectionEventListener Listener) {
		this.listener = Listener;
		stop = false;
		me = new Thread(this);
		me.start();
	}

	public void stop(boolean Wait) {
		stop = true;
		if (me != null) {
			try {
				me.join();
			} catch (InterruptedException ex) {
			}
		}
	}

	public void run() {
		try {
			StreamConnection connection = (StreamConnection) Connector.open(connectionURL);
			in = connection.openInputStream();
			out = connection.openOutputStream();

			byte[] serialData;
			while (!stop) {
				synchronized (mutex) {
					int lengthavai = 0;
					lengthavai = in.available();

					if (lengthavai > 0) {
						serialData = new byte[lengthavai];
						int length = in.read(serialData);
						if (listener != null) {
							listener.DataConnectionRecievedData(length, serialData);
						}
					}
				}
				try {
					Thread.sleep(1000 * 5);
				} catch (InterruptedException ex) {
				}
			}

			out.close();
			in.close();
			connection.close();

		} catch (IOException ioe) {
			main.getVisualMain().displayError("Error while communicating: " + ioe.getMessage());
		}
		reInit();
	}

	public void write(byte Data) throws IOException {
		synchronized (mutex) {
			out.write(Data);
		}
	}

	public void write(byte[] Data) throws IOException {
		synchronized (mutex) {
			out.write(Data);
		}
	}

	public void write(byte[] Data, int Offset, int Length) throws IOException {
		synchronized (mutex) {
			out.write(Data, Offset, Length);
		}
	}

	public String getConnectionURL() {
		return connectionURL;
	}

	public void setConnectionURL(String ConnectionURL) {
		this.connectionURL = ConnectionURL;
	}

	public boolean isWriteReady(int WaitTime) {
		if (WaitTime < 0) {
			WaitTime = 0;
		}
		while (WaitTime > 0 && out == null) {
			try {
				Thread.sleep(1000 * 1);
			} catch (InterruptedException ex) {
			}
			WaitTime -= 1000;
		}
		return out != null;
	}
}
