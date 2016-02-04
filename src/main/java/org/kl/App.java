package org.kl;

import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 * Hello world!
 *
 */
public class App 
{
	 
    public static void main(String[] args) throws NativeHookException {
    	
        Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.WARNING);
        try {
            /* Register jNativeHook */
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            /* Its error */
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        MyKeyListener ss = new MyKeyListener();
        GlobalScreen.addNativeKeyListener(ss);
    }
}
