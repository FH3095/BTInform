package BTInform;

import BTInform.Visual.AlertMessage;
import BTInform.Visual.AwaitMessage;
import BTInform.Visual.SearchPC;
import BTInform.Visual.SearchService;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author FH
 */
public class BTInform extends MIDlet {

    SearchPC searchPC;
    SearchService searchService;
    AwaitMessage awaitMessage;
    AlertMessage alertMessage;
    boolean paused;

    public BTInform() {
	paused = false;
	searchPC = null;
	searchService = null;
	awaitMessage = null;
	alertMessage = null;
    }
    
    public void switchDisplayable(Displayable nextDisplayable) {
	switchDisplayable(null, nextDisplayable);
    }
    
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
        Display display = getDisplay();
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }
    }

    public void startMIDlet()
    {
	searchPC=new SearchPC(this);
	switchDisplayable(searchPC.getSearchPC());
    }

    public void resumeMIDlet()
    {
    }
    
    public void exitMIDlet()
    {
	switchDisplayable(null, null);
	destroyApp(true);
	notifyDestroyed();
    }
    
    public void init()
    {
    }

    public void startApp() {
	if(paused)
	{
	    resumeApp();
	}
	else
	{
	    init();
	    startMIDlet();
	}
    }

    public void pauseApp() {
	paused=true;
    }

    public void destroyApp(boolean unconditional) {
    }
    
    public void resumeApp()
    {
	resumeMIDlet();
    }
    
    public Display getDisplay() {
        return Display.getDisplay(this);
    }
}
