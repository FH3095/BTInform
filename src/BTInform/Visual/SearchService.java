package BTInform.Visual;

import BTInform.BTInform;
import javax.microedition.lcdui.*;

/**
 * @author FH
 */
public class SearchService implements CommandListener {
    
    private BTInform midlet;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private List searchService;
    private Command exitCommand;
    private Command okCommand;
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The SearchService constructor.
     * @param midlet the midlet used for getting
     */
    public SearchService(BTInform midlet) {
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|4-commandAction|0|4-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|4-commandAction|0|4-preCommandAction
        // write pre-action user code here
	if (displayable == searchService) {//GEN-BEGIN:|4-commandAction|1|18-preAction
	    if (command == List.SELECT_COMMAND) {//GEN-END:|4-commandAction|1|18-preAction
		// write pre-action user code here
		searchServiceAction();//GEN-LINE:|4-commandAction|2|18-postAction
		// write post-action user code here
	    } else if (command == exitCommand) {//GEN-LINE:|4-commandAction|3|21-preAction
		// write pre-action user code here
		midlet.exitMIDlet();
//GEN-LINE:|4-commandAction|4|21-postAction
		// write post-action user code here
	    } else if (command == okCommand) {//GEN-LINE:|4-commandAction|5|23-preAction
		// write pre-action user code here
//GEN-LINE:|4-commandAction|6|23-postAction
		// write post-action user code here
	    }//GEN-BEGIN:|4-commandAction|7|4-postCommandAction
	}//GEN-END:|4-commandAction|7|4-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|4-commandAction|8|
    //</editor-fold>//GEN-END:|4-commandAction|8|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchService ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initiliazed instance of searchService component.
     * @return the initialized component instance
     */
    public List getSearchService() {
	if (searchService == null) {//GEN-END:|16-getter|0|16-preInit
	    // write pre-init user code here
	    searchService = new List("Search Service", Choice.IMPLICIT);//GEN-BEGIN:|16-getter|1|16-postInit
	    searchService.addCommand(getExitCommand());
	    searchService.addCommand(getOkCommand());
	    searchService.setCommandListener(this);
	    searchService.setSelectCommand(null);//GEN-END:|16-getter|1|16-postInit
	    // write post-init user code here
	}//GEN-BEGIN:|16-getter|2|
	return searchService;
    }
    //</editor-fold>//GEN-END:|16-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: searchServiceAction ">//GEN-BEGIN:|16-action|0|16-preAction
    /**
     * Performs an action assigned to the selected list element in the searchService component.
     */
    public void searchServiceAction() {//GEN-END:|16-action|0|16-preAction
	// enter pre-action user code here
	String __selectedString = getSearchService().getString(getSearchService().getSelectedIndex());//GEN-LINE:|16-action|1|16-postAction
	// enter post-action user code here
    }//GEN-BEGIN:|16-action|2|
    //</editor-fold>//GEN-END:|16-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
	if (exitCommand == null) {//GEN-END:|20-getter|0|20-preInit
	    // write pre-init user code here
	    exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|20-getter|1|20-postInit
	    // write post-init user code here
	}//GEN-BEGIN:|20-getter|2|
	return exitCommand;
    }
    //</editor-fold>//GEN-END:|20-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
	if (okCommand == null) {//GEN-END:|22-getter|0|22-preInit
	    // write pre-init user code here
	    okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|22-getter|1|22-postInit
	    // write post-init user code here
	}//GEN-BEGIN:|22-getter|2|
	return okCommand;
    }
    //</editor-fold>//GEN-END:|22-getter|2|
}
