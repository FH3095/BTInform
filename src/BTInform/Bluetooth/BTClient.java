package BTInform.Bluetooth;

import BTInform.BTInform;
import java.util.Vector;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;

/**
 *
 * @author FH
 */
public class BTClient implements DiscoveryListener, Runnable {
    public class Jobs
    {
	private Jobs() {}
	public static final short NONE=0;
	public static final short DISCOVER_DEVICES=1;
	public static final short SEARCH_SERVICES=2;
	public static final short AWAIT_MESSAGE=3;
    };

    private short job;
    private boolean waiting;
    private Thread me;
    private BTInform midlet;
    private BTClientListener listener;
    
    private Vector devices;
    private int discoverType;
    private Vector services;

    private LocalDevice localDevice;
    private DiscoveryAgent discoveryAgent;
    private UUID[] uuidSet = {new UUID(0x1101) };
    private int[] attrSet = {0x4E18461};

    public BTClient(BTInform MIDlet)
    {
	this.midlet=MIDlet;
	reInit();
	try {
	    localDevice=LocalDevice.getLocalDevice();
	} catch (BluetoothStateException ex) {
	    midlet.displayError(ex.getMessage());
	}
	discoveryAgent=localDevice.getDiscoveryAgent();
    }
    
    private void reInit()
    {
	job=Jobs.NONE;
	listener=null;
	me=null;
    }

    public void start(BTClientListener Listener,short Job)
    {
	this.listener=Listener;
	this.job=Job;
	me=new Thread(this);
	me.start();
    }
    
    public short getJob()
    {
	return job;
    }

    public boolean jobFinished()
    {
	return job==Jobs.NONE;
    }

    public void deviceDiscovered(RemoteDevice rd, DeviceClass dc) {
	if(devices.indexOf(rd)==-1)
	{
	    devices.addElement(rd);
	}
    }

    public void inquiryCompleted(int DiscType) {
	this.discoverType=DiscType;
	waiting=false;
    }

    public void serviceSearchCompleted(int i, int i1) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void servicesDiscovered(int i, ServiceRecord[] srs) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
	switch(job)
	{
	    case Jobs.DISCOVER_DEVICES:
		runDiscoverDevices();
		break;
	    case Jobs.SEARCH_SERVICES:
		runSearchServices();
		break;
	}
	listener.BTFinished();
	reInit();
    }

    private boolean runDiscoverDevices()
    {
	waiting=true;
	devices=new Vector();

	try {
            discoveryAgent.startInquiry(DiscoveryAgent.GIAC, this);
        } catch (BluetoothStateException e) {
            midlet.displayError("Can't start inquiry now: " + e);

            return true;
        }
	
	while(waiting==true)
	{
	    try {
		Thread.sleep(750);
	    } catch (InterruptedException ex) {
	    }
	}

        switch (discoverType) {
        case INQUIRY_ERROR:
            midlet.displayError("Device discovering error.");
	    break;

        case INQUIRY_TERMINATED:
            devices.removeAllElements();
            break;

        case INQUIRY_COMPLETED:
            if (devices.isEmpty()) {
                midlet.displayError("No devices in range.");
            }
            break;

        default:
            midlet.displayError("system error:" + " unexpected device discovery code: " + discoverType);
            return false;
        }
	return true;
    }

    private void runSearchServices()
    {
	services=new Vector();
    }
    
    public RemoteDevice[] getDevices()
    {
	RemoteDevice[] devices=new RemoteDevice[this.devices.size()];
	this.devices.copyInto(devices);
	return devices;
    }
    
    public ServiceRecord[] getServices()
    {
	ServiceRecord[] services=new ServiceRecord[this.devices.size()];
	this.services.copyInto(services);
	return services;
    }
}