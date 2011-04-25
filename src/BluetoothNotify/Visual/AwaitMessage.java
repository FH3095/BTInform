package BluetoothNotify.Visual;

import BluetoothNotify.Bluetooth.DataConnectionEventListener;
import BluetoothNotify.Bluetooth.Packet;
import BluetoothNotify.Main;
import javax.microedition.lcdui.*;

/**
 * @author FH
 */
public class AwaitMessage implements CommandListener, DataConnectionEventListener {

	private Main main;
	//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
	private Form awaitMessage;
	private StringItem Log;
	private Command exitCommand;
	private Command okCommand;
	//</editor-fold>//GEN-END:|fields|0|

	/**
	 * The AwaitMessage constructor.
	 * @param midlet the midlet used for getting
	 */
	public AwaitMessage(Main main) {
		this.main = main;
	}

	//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
	//</editor-fold>//GEN-END:|methods|0|
	//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
	/**
	 * Initializes the application.
	 * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
	 */
	private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
		// write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
		// write post-initialize user code here
	}//GEN-BEGIN:|0-initialize|2|
	//</editor-fold>//GEN-END:|0-initialize|2|

	//<editor-fold defaultstate="collapsed" desc=" Generated Getter: awaitMessage ">//GEN-BEGIN:|11-getter|0|11-preInit
	/**
	 * Returns an initiliazed instance of awaitMessage component.
	 * @return the initialized component instance
	 */
	public Form getAwaitMessage() {
		if (awaitMessage == null) {//GEN-END:|11-getter|0|11-preInit
			// write pre-init user code here
			awaitMessage = new Form("Await Message", new Item[] { getLog() });//GEN-BEGIN:|11-getter|1|11-postInit
			awaitMessage.addCommand(getExitCommand());
			awaitMessage.setCommandListener(this);//GEN-END:|11-getter|1|11-postInit
			// write post-init user code here
			initialize();
		}//GEN-BEGIN:|11-getter|2|
		return awaitMessage;
	}
	//</editor-fold>//GEN-END:|11-getter|2|

	//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|4-commandAction|0|4-preCommandAction
	/**
	 * Called by a system to indicated that a command has been invoked on a particular displayable.
	 * @param command the Command that was invoked
	 * @param displayable the Displayable where the command was invoked
	 */
	public void commandAction(Command command, Displayable displayable) {//GEN-END:|4-commandAction|0|4-preCommandAction
		// write pre-action user code here
		if (displayable == awaitMessage) {//GEN-BEGIN:|4-commandAction|1|15-preAction
			if (command == exitCommand) {//GEN-END:|4-commandAction|1|15-preAction
				// write pre-action user code here
				main.getVisualMain().exitMIDlet();
//GEN-LINE:|4-commandAction|2|15-postAction
				// write post-action user code here
			}//GEN-BEGIN:|4-commandAction|3|4-postCommandAction
		}//GEN-END:|4-commandAction|3|4-postCommandAction
		// write post-action user code here
	}//GEN-BEGIN:|4-commandAction|4|19-postAction
	//</editor-fold>//GEN-END:|4-commandAction|4|19-postAction

	//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|14-getter|0|14-preInit
	/**
	 * Returns an initiliazed instance of exitCommand component.
	 * @return the initialized component instance
	 */
	public Command getExitCommand() {
		if (exitCommand == null) {//GEN-END:|14-getter|0|14-preInit
			// write pre-init user code here
			exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|14-getter|1|14-postInit
			// write post-init user code here
		}//GEN-BEGIN:|14-getter|2|
		return exitCommand;
	}
	//</editor-fold>//GEN-END:|14-getter|2|

	//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|2-switchDisplayable|0|2-preSwitch
	/**
	 * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
	 * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
	 * @param nextDisplayable the Displayable to be set
	 */
	public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|2-switchDisplayable|0|2-preSwitch
		// write pre-switch user code here
		Display display = getDisplay();//GEN-BEGIN:|2-switchDisplayable|1|2-postSwitch
		if (alert == null) {
			display.setCurrent(nextDisplayable);
		} else {
			display.setCurrent(alert, nextDisplayable);
		}//GEN-END:|2-switchDisplayable|1|2-postSwitch
		// write post-switch user code here
	}//GEN-BEGIN:|2-switchDisplayable|2|
	//</editor-fold>//GEN-END:|2-switchDisplayable|2|

	//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
	/**
	 * Returns an initiliazed instance of okCommand component.
	 * @return the initialized component instance
	 */
	public Command getOkCommand() {
		if (okCommand == null) {//GEN-END:|18-getter|0|18-preInit
			// write pre-init user code here
			okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|18-getter|1|18-postInit
			// write post-init user code here
		}//GEN-BEGIN:|18-getter|2|
		return okCommand;
	}
	//</editor-fold>//GEN-END:|18-getter|2|

	//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Log ">//GEN-BEGIN:|20-getter|0|20-preInit
	/**
	 * Returns an initiliazed instance of Log component.
	 * @return the initialized component instance
	 */
	public StringItem getLog() {
		if (Log == null) {//GEN-END:|20-getter|0|20-preInit
			// write pre-init user code here
			Log = new StringItem("Log", "", Item.PLAIN);//GEN-LINE:|20-getter|1|20-postInit
			// write post-init user code here
		}//GEN-BEGIN:|20-getter|2|
		return Log;
	}
	//</editor-fold>//GEN-END:|20-getter|2|

	private Display getDisplay() {
		return main.getVisualMain().getDisplay();
	}

	public void startDisplay() {
		main.getDataConnection().start(this);
		if (!main.getDataConnection().isWriteReady(15000)) {
			main.getVisualMain().displayError("Connection isn't write-ready!");
			return;
		}
		/*String File="Duke (png)";
		try {
		main.getDataConnection().write((byte)File.length());
		main.getDataConnection().write(File.getBytes());
		} catch (IOException ex) {
		main.getVisualMain().displayError("Error while writing to connection: "+ex.getMessage());
		}*/
	}

	public boolean DataConnectionPacketRecieved(Packet packet) {
		StringBuffer LogContentBuffer = new StringBuffer(2148);
		LogContentBuffer.append(getLog().getText()).append(packet.getType()).
				append(";");
		byte[] binData = packet.getBinData();
		for (short i = 0; i < binData.length; ++i) {
			LogContentBuffer.append((int) binData[i]);
		}
		LogContentBuffer.append(packet.getStrData()).append("\n");
		String LogContent = LogContentBuffer.toString();
		if (LogContent.length() > 2048) {
			LogContent = LogContent.substring(LogContentBuffer.length() - 2048);
		}
		getLog().setText(LogContent);
		return false;
	}
}
