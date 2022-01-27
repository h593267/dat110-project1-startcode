package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		
		segment[0] = (byte) data.length;
		
		for(int i = 0; i < data.length; i++) 
			segment[i+1] = message.getData()[i];

		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {
		
		byte[] data = new byte[segment[0]];
		
		for(int i = 0; i < segment[0]; i++) {
			data[i] = segment[i+1];
		}
		
		Message message = new Message(data);
		
		return message;
		
	}
	
}
