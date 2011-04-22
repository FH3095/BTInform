package BTInform.Visual;

import BTInform.BTInform;
import javax.microedition.lcdui.*;

/**
 * @author FH
 */
public class AwaitMessage implements CommandListener {
    
    private BTInform midlet;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form awaitMessage;
    private Command okCommand;
    private Command exitCommand;
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The AwaitMessage constructor.
     * @param midlet the midlet used for getting
     */
    public AwaitMessage(BTInform midlet) {
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: awaitMessage ">//GEN-BEGIN:|11-getter|0|11-preInit
    /**
     * Returns an initiliazed instance of awaitMessage component.
     * @return the initialized component instance
     */
    public Form getAwaitMessage() {
        if (awaitMessage == null) {//GEN-END:|11-getter|0|11-preInit
            // write pre-init user code here
            awaitMessage = new Form("form");//GEN-BEGIN:|11-getter|1|11-postInit
            awaitMessage.addCommand(getOkCommand());
            awaitMessage.addCommand(getExitCommand());
            awaitMessage.setCommandListener(this);//GEN-END:|11-getter|1|11-postInit
            // write post-init user code here
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
		midlet.exitMIDlet();
//GEN-LINE:|4-commandAction|2|15-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|4-commandAction|3|13-preAction
                // write pre-action user code here
//GEN-LINE:|4-commandAction|4|13-postAction
                // write post-action user code here
            }//GEN-BEGIN:|4-commandAction|5|4-postCommandAction
        }//GEN-END:|4-commandAction|5|4-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|4-commandAction|6|
    //</editor-fold>//GEN-END:|4-commandAction|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|12-getter|0|12-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|12-getter|0|12-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|12-getter|1|12-postInit
            // write post-init user code here
        }//GEN-BEGIN:|12-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|12-getter|2|

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
}
