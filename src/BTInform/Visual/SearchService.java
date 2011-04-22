/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BTInform.Visual;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author A_FH
 */
public class SearchService implements CommandListener {
    
    private MIDlet midlet;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form searchService;
    private Command exitCommand;
    private Command okCommand;
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The SearchService constructor.
     * @param midlet the midlet used for getting
     */
    public SearchService(MIDlet midlet) {
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchService ">//GEN-BEGIN:|11-getter|0|11-preInit
    /**
     * Returns an initiliazed instance of searchService component.
     * @return the initialized component instance
     */
    public Form getSearchService() {
        if (searchService == null) {//GEN-END:|11-getter|0|11-preInit
            // write pre-init user code here
            searchService = new Form("form");//GEN-BEGIN:|11-getter|1|11-postInit
            searchService.addCommand(getExitCommand());
            searchService.addCommand(getOkCommand());
            searchService.setCommandListener(this);//GEN-END:|11-getter|1|11-postInit
            // write post-init user code here
        }//GEN-BEGIN:|11-getter|2|
        return searchService;
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
        if (displayable == searchService) {//GEN-BEGIN:|4-commandAction|1|13-preAction
            if (command == exitCommand) {//GEN-END:|4-commandAction|1|13-preAction
                // write pre-action user code here
//GEN-LINE:|4-commandAction|2|13-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|4-commandAction|3|15-preAction
                // write pre-action user code here
//GEN-LINE:|4-commandAction|4|15-postAction
                // write post-action user code here
            }//GEN-BEGIN:|4-commandAction|5|4-postCommandAction
        }//GEN-END:|4-commandAction|5|4-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|4-commandAction|6|
    //</editor-fold>//GEN-END:|4-commandAction|6|

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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

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
