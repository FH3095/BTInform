package BTInform.Visual;

import BTInform.BTInform;
import javax.microedition.lcdui.*;

/**
 * @author FH
 */
public class ErrorMessage implements CommandListener {
    
    private BTInform midlet;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form errorMessage;
    private StringItem stringItem;
    private Command exitCommand;
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The Error constructor.
     * @param midlet the midlet used for getting
     */
    public ErrorMessage(BTInform midlet) {
	this.midlet = midlet;
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|4-commandAction|0|4-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|4-commandAction|0|4-preCommandAction
	// write pre-action user code here
	if (displayable == errorMessage) {//GEN-BEGIN:|4-commandAction|1|13-preAction
	    if (command == exitCommand) {//GEN-END:|4-commandAction|1|13-preAction
		// write pre-action user code here
		midlet.exitMIDlet();
//GEN-LINE:|4-commandAction|2|13-postAction
		// write post-action user code here
	    }//GEN-BEGIN:|4-commandAction|3|4-postCommandAction
	}//GEN-END:|4-commandAction|3|4-postCommandAction
	// write post-action user code here
    }//GEN-BEGIN:|4-commandAction|4|
    //</editor-fold>//GEN-END:|4-commandAction|4|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: errorMessage ">//GEN-BEGIN:|11-getter|0|11-preInit
    /**
     * Returns an initiliazed instance of errorMessage component.
     * @return the initialized component instance
     */
    public Form getErrorMessage() {
	if (errorMessage == null) {//GEN-END:|11-getter|0|11-preInit
	    // write pre-init user code here
	    errorMessage = new Form("Error", new Item[] { getStringItem() });//GEN-BEGIN:|11-getter|1|11-postInit
	    errorMessage.addCommand(getExitCommand());
	    errorMessage.setCommandListener(this);//GEN-END:|11-getter|1|11-postInit
	    // write post-init user code here
	}//GEN-BEGIN:|11-getter|2|
	return errorMessage;
    }
    //</editor-fold>//GEN-END:|11-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|12-getter|0|12-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
	if (exitCommand == null) {//GEN-END:|12-getter|0|12-preInit
	    // write pre-init user code here
	    exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|12-getter|1|12-postInit
	    // write post-init user code here
	}//GEN-BEGIN:|12-getter|2|
	return exitCommand;
    }
    //</editor-fold>//GEN-END:|12-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|15-getter|0|15-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
	if (stringItem == null) {//GEN-END:|15-getter|0|15-preInit
	    // write pre-init user code here
	    stringItem = new StringItem("Error-Message\n", "", Item.PLAIN);//GEN-LINE:|15-getter|1|15-postInit
	    // write post-init user code here
	}//GEN-BEGIN:|15-getter|2|
	return stringItem;
    }
    //</editor-fold>//GEN-END:|15-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
	return midlet.getDisplay();
    }
    
    public void setMessage(String Message)
    {
	getStringItem().setText(Message);
    }
}
