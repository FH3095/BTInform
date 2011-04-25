package BluetoothNotify.Bluetooth;

/**
 *
 * @author FH
 */
public interface DataConnectionEventListener {
	public void DataConnectionRecievedData(int Length, byte[] Data);
	public void DataConnectionPacketRecieved(Packet packet);
}
