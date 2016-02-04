package org.kl;

import java.io.FileWriter;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author ameer
 */
public class MyKeyListener implements MyNativeKeyListener {
	
    FileWriter out;
    private DataReader reader;
    
    public MyKeyListener() {
    	reader = new DataReader();
    }
    
    /* Key Pressed */
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        try {
        	reader.sendKey(NativeKeyEvent.getKeyText(e.getKeyCode()));
        }
        catch(InterruptedException ex) {
        	System.out.println("Interrupted Exception");
        	ex.printStackTrace();
        }

    }

    /* Key Released */
   public void nativeKeyReleased(NativeKeyEvent e) {
        //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    /* I can't find any output from this call */
    public void nativeKeyTyped(NativeKeyEvent e) {
        //System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

	public void returnNativeKeyPressed(NativeKeyEvent e) {
		System.out.println("HOT");
		
	}
}
