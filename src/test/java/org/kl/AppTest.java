package org.kl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
	@Test
	public void testCreateFile() {
		File file = new File("test");
		boolean created = false;
		try {
			if(file.exists())
				file.delete();
			else
				created = file.createNewFile();
		}
		catch(IOException ex) {
			fail("unable to create file");
		}
		assertTrue(created);
		file.delete();
	}
	
	@Test
	public void testKeyboardInput() {
		MyKeyListener kl = new MyKeyListener();
		try {
			GlobalScreen.registerNativeHook();
		}
		catch(NativeHookException ex) {
			
		}
	}
	
}
