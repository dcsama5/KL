package org.kl;

import java.util.EventListener;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public interface MyNativeKeyListener extends NativeKeyListener {
	
	public void returnNativeKeyPressed(NativeKeyEvent e);

}
