package no.hvl.dat110.messaging;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		if(data != null && data.length < MessageConfig.SEGMENTSIZE) {
			this.data = data;
		}
	
	}

	public byte[] getData() {
		return this.data; 
	}

}
