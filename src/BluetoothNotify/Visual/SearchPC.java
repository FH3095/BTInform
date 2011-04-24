package BluetoothNotify.Visual;

import BluetoothNotify.Bluetooth.Client;
import BluetoothNotify.Bluetooth.ClientEventListener;
import BluetoothNotify.Main;
import java.io.IOException;
import javax.bluetooth.RemoteDevice;
import javax.microedition.lcdui.*;

/**
 * @author FH
 */
public class SearchPC implements CommandListener, ClientEventListener {

	private Main main;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private List searchPC;
    private Command exitCommand;
    private Command okCommand;
    //</editor-fold>//GEN-END:|fields|0|

	/**
	 * The SearchPC constructor.
	 * @param midlet the midlet used for getting
	 */
	public SearchPC(Main main) {
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|4-commandAction|0|4-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|4-commandAction|0|4-preCommandAction
		// write pre-action user code here
	if (displayable == searchPC) {//GEN-BEGIN:|4-commandAction|1|21-preAction
	    if (command == List.SELECT_COMMAND) {//GEN-END:|4-commandAction|1|21-preAction
			// write pre-action user code here
		searchPCAction();//GEN-LINE:|4-commandAction|2|21-postAction
			// write post-action user code here
	    } else if (command == exitCommand) {//GEN-LINE:|4-commandAction|3|27-preAction
			// write pre-action user code here
			main.getVisualMain().exitMIDlet();
//GEN-LINE:|4-commandAction|4|27-postAction
			// write post-action user code here
	    } else if (command == okCommand) {//GEN-LINE:|4-commandAction|5|29-preAction
			// write pre-action user code here
			main.getVisualMain().visualFlow(true);
//GEN-LINE:|4-commandAction|6|29-postAction
			// write post-action user code here
	    }//GEN-BEGIN:|4-commandAction|7|4-postCommandAction
	}//GEN-END:|4-commandAction|7|4-postCommandAction
		// write post-action user code here
    }//GEN-BEGIN:|4-commandAction|8|
    //</editor-fold>//GEN-END:|4-commandAction|8|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchPC ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of searchPC component.
     * @return the initialized component instance
     */
    public List getSearchPC() {
	if (searchPC == null) {//GEN-END:|20-getter|0|20-preInit
		// write pre-init user code here
	    searchPC = new List("Search PC", Choice.IMPLICIT);//GEN-BEGIN:|20-getter|1|20-postInit
	    searchPC.addCommand(getExitCommand());
	    searchPC.addCommand(getOkCommand());
	    searchPC.setCommandListener(this);
	    searchPC.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);
	    searchPC.setSelectCommand(null);
	    searchPC.setSelectedFlags(new boolean[] {  });//GEN-END:|20-getter|1|20-postInit
		// write post-init user code here
	}//GEN-BEGIN:|20-getter|2|
	return searchPC;
    }
    //</editor-fold>//GEN-END:|20-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: searchPCAction ">//GEN-BEGIN:|20-action|0|20-preAction
    /**
     * Performs an action assigned to the selected list element in the searchPC component.
     */
    public void searchPCAction() {//GEN-END:|20-action|0|20-preAction
		// enter pre-action user code here
	String __selectedString = getSearchPC().getString(getSearchPC().getSelectedIndex());//GEN-LINE:|20-action|1|20-postAction
		// enter post-action user code here
    }//GEN-BEGIN:|20-action|2|31-postAction
    //</editor-fold>//GEN-END:|20-action|2|31-postAction

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
	if (exitCommand == null) {//GEN-END:|26-getter|0|26-preInit
		// write pre-init user code here
	    exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|26-getter|1|26-postInit
		// write post-init user code here
	}//GEN-BEGIN:|26-getter|2|
	return exitCommand;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
	if (okCommand == null) {//GEN-END:|28-getter|0|28-preInit
		// write pre-init user code here
	    okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|28-getter|1|28-postInit
		// write post-init user code here
	}//GEN-BEGIN:|28-getter|2|
	return okCommand;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

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

	private Display getDisplay() {
		return main.getVisualMain().getDisplay();
	}

	public void startDisplay() {
		main.getBluetoothClient().start(this, Client.Jobs.DISCOVER_DEVICES);
	}

	public void BTFinished() {
		RemoteDevice[] devices = main.getBluetoothClient().getDevices();
		for (int i = 0; i < devices.length; ++i) {
			try {
				searchPC.append(devices[i].getFriendlyName(true), null);
			} catch (IOException ex) {
				searchPC.append(devices[i].getBluetoothAddress(), null);
			}
		}
	}
}
