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
public class AlertMessage {
    
    private MIDlet midlet;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Alert alertMessage;
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The AlertMessage constructor.
     * @param midlet the midlet used for getting
     */
    public AlertMessage(MIDlet midlet) {
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
            alertMessage = new Alert("alert");//GEN-BEGIN:|11-getter|1|11-postInit
            alertMessage.setTimeout(Alert.FOREVER);//GEN-END:|11-getter|1|11-postInit
            // write post-init user code here
        }//GEN-BEGIN:|11-getter|2|
        return alertMessage;
    }
    //</editor-fold>//GEN-END:|11-getter|2|

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
