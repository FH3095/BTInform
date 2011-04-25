package BluetoothNotify.Bluetooth;

/**
 *
 * @author FH
 */
public interface DataConnectionEventListener {

	public boolean DataConnectionPacketRecieved(Packet packet); //True=already handled
}
