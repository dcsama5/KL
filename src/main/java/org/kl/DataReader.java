package org.kl;

public class DataReader {
	
	private static String data;
	
	public synchronized void sendKey(String keyText) throws InterruptedException {
		data = keyText;
		wait();
	}
	
	public static void printData() {
		System.out.println(data);
	}

	public static String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
