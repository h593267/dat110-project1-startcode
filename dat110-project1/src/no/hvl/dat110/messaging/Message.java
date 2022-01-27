package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	//HEI
	public Message(byte[] data) {
		
		if(data != null && data.length < MessageConfig.SEGMENTSIZE) {
			this.data[0] = (byte) data.length;
			
			for(int i = 1; i < data.length; i++) {
				this.data[i] = data[i];
			}
			
			// Padding
			for(int i = data.length; i < MessageConfig.SEGMENTSIZE; i++) {
				this.data[i] = 0;
			}
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.constructor("Message"));
			
		// TODO - END
	}

	public byte[] getData() {
		return this.data; 
	}

}
