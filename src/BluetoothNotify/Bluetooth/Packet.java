package BluetoothNotify.Bluetooth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author FH
 */
public class Packet {

	public class PacketTypes {

		public static final short NONE = 0;
		public static final short PING = 1;
		public static final short PONG = 2;
		public static final short NOTIFY = 3;
	};
	public static final short HEADER_SIZE = 2 + 2;
	private short type;
	private byte[] binData;
	private String strData;

	public Packet() {
		type = PacketTypes.NONE;
		binData=new byte[0];
		strData = new String();
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getStrData() {
		return strData;
	}

	public void setData(String strData) {
		this.strData = strData;
	}
	
	public byte[] getBinData()
	{
		return binData;
	}
	
	public void setBinData(byte[] binData)
	{
		this.binData=binData;
	}
	
	public void writeToStream(DataOutputStream stream) throws IOException
	{
		stream.writeShort(type);
		stream.writeShort(binData.length);
		stream.write(binData);
		stream.writeUTF(strData);
	}
	
	public void readFromStream(DataInputStream stream) throws IOException
	{
		type=stream.readShort();
		short binDataSize=stream.readShort();
		binData=new byte[binDataSize];
		stream.readFully(binData);
		strData=stream.readUTF();
	}
}
