package BluetoothNotify.Bluetooth;

import BluetoothNotify.Main;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

/**
 *
 * @author FH
 */
public class DataConnection implements Runnable {

	private class PingCheck implements Runnable {

		private boolean awaitingPong;
		private Main main;
		private int pingInterval;
		private boolean stop;

		public PingCheck(Main main, int pingInterval) {
			this.main = main;
			this.pingInterval = pingInterval;
			awaitingPong = false;
			stop = false;
		}

		public void stop() {
			stop = true;
		}

		public void recievedPong() {
			awaitingPong = false;
		}

		public void start() {
			new Thread(this).start();
		}

		public void run() {
			while (!stop) {
				try {
					Thread.sleep(pingInterval);
				} catch (InterruptedException ex) {
				}
				if (awaitingPong) {
					main.getVisualMain().displayError("Haven't recieved pong for ping-packet! Connection interrupted.");
				}
				awaitingPong = true;
				Packet packet = new Packet();
				packet.setType(Packet.PacketTypes.PING);
				main.getDataConnection().write(packet);
			}
		}
	}

	private Main main;
	private Thread me;
	private PingCheck pingCheck;
	private boolean stop;
	private String connectionURL;
	private DataConnectionEventListener listener;
	private final Object mutex;
	private DataInputStream in;
	private DataOutputStream out;

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
		if (pingCheck != null) {
			pingCheck.stop();
		}
		pingCheck = null;
	}

	public void start(DataConnectionEventListener Listener) {
		this.listener = Listener;
		stop = false;
		me = new Thread(this);
		me.start();
		pingCheck = new PingCheck(main, 15000);
		pingCheck.start();
	}

	public void stop(boolean Wait) {
		stop = true;
		pingCheck.stop();
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
			in = connection.openDataInputStream();
			out = connection.openDataOutputStream();

			while (!stop) {
				synchronized (mutex) {
					int lengthavai = 0;
					lengthavai = in.available();

					if (lengthavai >= Packet.HEADER_SIZE) {
						Packet curPacket = new Packet();
						curPacket.readFromStream(in);
						handlePacket(curPacket);
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

	public void write(Packet packet) {
		try {
			packet.writeToStream(out);
		} catch (IOException ex) {
			main.getVisualMain().displayError("Can't send packet: " + ex.getMessage());
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

	private void handlePacket(Packet packet) {
		if (listener != null && listener.DataConnectionPacketRecieved(packet)) {
			return;
		}

		switch (packet.getType()) {
			case Packet.PacketTypes.PING:
				Packet pack = new Packet();
				pack.setType(Packet.PacketTypes.PONG);
				try {
					pack.writeToStream(out);
				} catch (IOException ex) {
					main.getVisualMain().displayError("Can't send pong-packet: " + ex.getMessage());
				}
				break;
			case Packet.PacketTypes.PONG:
				pingCheck.recievedPong();
				break;
		}
	}
}
