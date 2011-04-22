package BTInform.Visual;

import BTInform.BTInform;
import javax.microedition.lcdui.*;

/**
 * @author FH
 */
public class AlertMessage implements CommandListener {
    
    private BTInform midlet;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Alert alertMessage;
    private Command backCommand;
    private Image alertImage;
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The AlertMessage constructor.
     * @param midlet the midlet used for getting
     */
    public AlertMessage(BTInform midlet) {
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertMessage ">//GEN-BEGIN:|11-getter|0|11-preInit
    /**
     * Returns an initiliazed instance of alertMessage component.
     * @return the initialized component instance
     */
    public Alert getAlertMessage() {
        if (alertMessage == null) {//GEN-END:|11-getter|0|11-preInit
            // write pre-init user code here
            alertMessage = new Alert("alert", null, getAlertImage(), null);//GEN-BEGIN:|11-getter|1|11-postInit
            alertMessage.addCommand(getBackCommand());
            alertMessage.setCommandListener(this);
            alertMessage.setTimeout(Alert.FOREVER);//GEN-END:|11-getter|1|11-postInit
            // write post-init user code here
        }//GEN-BEGIN:|11-getter|2|
        return alertMessage;
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
        if (displayable == alertMessage) {//GEN-BEGIN:|4-commandAction|1|14-preAction
            if (command == backCommand) {//GEN-END:|4-commandAction|1|14-preAction
                // write pre-action user code here
//GEN-LINE:|4-commandAction|2|14-postAction
                // write post-action user code here
            }//GEN-BEGIN:|4-commandAction|3|4-postCommandAction
        }//GEN-END:|4-commandAction|3|4-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|4-commandAction|4|
    //</editor-fold>//GEN-END:|4-commandAction|4|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|13-getter|0|13-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|13-getter|0|13-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|13-getter|1|13-postInit
            // write post-init user code here
        }//GEN-BEGIN:|13-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|13-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertImage ">//GEN-BEGIN:|12-getter|0|12-preInit
    /**
     * Returns an initiliazed instance of alertImage component.
     * @return the initialized component instance
     */
    public Image getAlertImage() {
        if (alertImage == null) {//GEN-END:|12-getter|0|12-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|12-getter|1|12-@java.io.IOException
                alertImage = Image.createImage("/60px-Gtk-dialog-warning.svg.png");
            } catch (java.io.IOException e) {//GEN-END:|12-getter|1|12-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|12-getter|2|12-postInit
            // write post-init user code here
        }//GEN-BEGIN:|12-getter|3|
        return alertImage;
    }
    //</editor-fold>//GEN-END:|12-getter|3|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(midlet);
    }

    /**
     * Exits MIDlet.
     * Note you have to implement proper MIDlet destroying.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        // midlet.destroyApp(true);
        midlet.notifyDestroyed();
    }
}
