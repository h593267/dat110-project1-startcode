package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.MessageConfig;
import no.hvl.dat110.messaging.MessageUtils;

public class RPCUtils {

	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = new byte[1];

		if (payload!= null) {
			
			rpcmsg = new byte[payload.length+1];
			
			for (int i = 0; i < payload.length; i++) {
				rpcmsg[i + 1] = payload[i];
			} 
			
		}
		
		rpcmsg[0] = rpcid;
		
		return rpcmsg;
	}

	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = new byte[rpcmsg.length - 1];

		for (int i = 0; i < payload.length; i++) {
			payload[i] = rpcmsg[i + 1];
		}

		return payload;

	}

	public static byte[] marshallString(String str) {

		byte[] encoded = null;

		encoded = str.getBytes();

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = null;

		decoded = new String(data);

		return decoded;
	}

	public static byte[] marshallVoid() {

		byte[] encoded = null;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		return;

	}

	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else {
			encoded[0] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	public static byte[] marshallInteger(int x) {

		ByteBuffer bb = ByteBuffer.allocate(Integer.BYTES);
		bb.putInt(x);

		return bb.array();
	}

	public static int unmarshallInteger(byte[] data) {

		ByteBuffer bb = ByteBuffer.wrap(data);
		return bb.getInt();

	}
}
