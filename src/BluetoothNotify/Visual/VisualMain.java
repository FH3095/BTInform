package BluetoothNotify.Visual;

import BluetoothNotify.Bluetooth.Client;
import BluetoothNotify.Main;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author FH
 */
public class VisualMain {

	private boolean showingError;
	private final Object showingErrorMutex;
	private Main main;
	private SearchPC searchPC;
	private SearchService searchService;
	private AwaitMessage awaitMessage;
	private AlertMessage alertMessage;

	public VisualMain(Main main) {
		showingErrorMutex = new Object();
		this.main = main;
		showingError = false;
		searchPC = null;
		searchService = null;
		awaitMessage = null;
		alertMessage = null;
	}

	public void switchDisplayable(Displayable nextDisplayable) {
		switchDisplayable(null, nextDisplayable);
	}

	public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
		synchronized (showingErrorMutex) {
			if (showingError == false) {
				Display display = getDisplay();
				if (alert == null) {
					display.setCurrent(nextDisplayable);
				} else {
					display.setCurrent(alert, nextDisplayable);
				}
			}
		}
	}

	public Display getDisplay() {
		return Display.getDisplay(main);
	}

	public void displayError(String Error) {
		synchronized (showingErrorMutex) {
			showingError = true;
			ErrorMessage errorForm = new ErrorMessage(this);
			errorForm.setMessage(Error);
			switchDisplayable(errorForm.getErrorMessage());
		}
	}

	public void visualFlow(boolean forward) {
		if (searchPC != null) {
			searchService = new SearchService(main);
			searchService.startDisplay();
			switchDisplayable(searchService.getSearchService());
			searchPC = null;
			return;
		}
		if (searchService != null) {
			awaitMessage = new AwaitMessage(main);
			awaitMessage.startDisplay();
			switchDisplayable(awaitMessage.getAwaitMessage());
			searchService = null;
			return;
		}
		if (awaitMessage != null) {
			alertMessage = new AlertMessage(main);
			alertMessage.startDisplay();
			switchDisplayable(alertMessage.getAlertMessage(), awaitMessage.getAwaitMessage());
			return;
		}
		searchPC = new SearchPC(main);
		searchPC.startDisplay();
		switchDisplayable(searchPC.getSearchPC());
	}

	public void startMIDlet() {
		visualFlow(true);
	}

	public void pauseMIDlet() {
	}

	public void resumeMIDlet() {
	}

	public void exitMIDlet() {
		main.exitApp();
	}

	public void destroyMIDlet() {
		switchDisplayable(null, null);
	}
}
