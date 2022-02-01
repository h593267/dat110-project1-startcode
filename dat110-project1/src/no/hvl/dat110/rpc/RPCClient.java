package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		connection = msgclient.connect();
	}
	
	public void disconnect() {
		
		connection.close();
		
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] data = RPCUtils.encapsulate(rpcid, params);
		Message message = new Message(data);
		connection.send(message);
		
		Message reply = connection.receive();
		byte[] returnval = RPCUtils.decapsulate(reply.getData());
		
		return returnval;
		
	}

}
