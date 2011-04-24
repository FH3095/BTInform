package BluetoothNotify.Visual;

import BluetoothNotify.Bluetooth.Client;
import BluetoothNotify.Visual.AlertMessage;
import BluetoothNotify.Visual.AwaitMessage;
import BluetoothNotify.Visual.ErrorMessage;
import BluetoothNotify.Visual.SearchPC;
import BluetoothNotify.Visual.SearchService;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author FH
 */
public class VisualMain extends MIDlet {

    private SearchPC searchPC;
    private SearchService searchService;
    private AwaitMessage awaitMessage;
    private AlertMessage alertMessage;
    
    private Client btClient;
    private boolean paused;

    public VisualMain() {
	paused = false;
	searchPC = null;
	searchService = null;
	awaitMessage = null;
	alertMessage = null;
	btClient=new Client(this);
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
	visualFlow(true);
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
    
    public void displayError(String Error)
    {
	ErrorMessage errorForm=new ErrorMessage(this);
	errorForm.setMessage(Error);
	switchDisplayable(errorForm.getErrorMessage());
    }
    
    public void visualFlow(boolean forward)
    {
	if(searchPC!=null)
	{
	    searchService=new SearchService(this);
	    searchService.startDisplay();
	    switchDisplayable(searchService.getSearchService());
	    searchPC=null;
	    return;
	}
	if(searchService!=null)
	{
	    awaitMessage=new AwaitMessage(this);
	    awaitMessage.startDisplay();
	    switchDisplayable(awaitMessage.getAwaitMessage());
	    searchService=null;
	    return;
	}
	if(awaitMessage!=null)
	{
	    alertMessage=new AlertMessage(this);
	    alertMessage.startDisplay();
	    switchDisplayable(alertMessage.getAlertMessage(), awaitMessage.getAwaitMessage());
	    return;
	}
	searchPC=new SearchPC(this);
	searchPC.startDisplay();
	switchDisplayable(searchPC.getSearchPC());
    }

    public Client getBTClient()
    {
	return btClient;
    }
}
