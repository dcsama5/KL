package org.kl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.junit.Ignore;
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
	@Ignore
	public void testKeyboardInput() {
		MyKeyListener kl = new MyKeyListener();
		try {
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(kl);
			while(true) {
			//	String s = DataReader.getKey();
			}
		}
		catch(NativeHookException ex) {
			
		}
	}
	
	@Test
	public void ServerReaderInputStream() {
		try {
		ServerSocket server = new ServerSocket(7777);
		while(true) {
			Socket socket = server.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
			String str = reader.readLine();
			System.out.println(str);
			}
		}
		}
		catch(IOException ex) {
			
		}
	}
	
}
