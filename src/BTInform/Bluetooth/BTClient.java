package BTInform.Bluetooth;

import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

/**
 *
 * @author FH
 */
public class BTClient implements DiscoveryListener, Runnable {

    public void deviceDiscovered(RemoteDevice rd, DeviceClass dc) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inquiryCompleted(int i) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void serviceSearchCompleted(int i, int i1) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void servicesDiscovered(int i, ServiceRecord[] srs) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
}
