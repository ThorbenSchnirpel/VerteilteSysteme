package mware_lib;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import accessor_one.ClassOneImplBase;
import accessor_one.SomeException112;

public class ClientStub extends ClassOneImplBase {

	private String host;
	private int port;
	private Object objRef;

	public ClientStub(Object rawObjectRef) {
		this.objRef = ((RawObject) rawObjectRef).getObj();
		this.host = ((RawObject) rawObjectRef).getHost();
		this.port = ((RawObject) rawObjectRef).getPort();
	}

	public String methodOne(int param1, String param2) throws SomeException112 {
		// Send methodrequest to ServerSkeletonThread
		try {
			Socket stubSocket = new Socket(host, port);
			ObjectOutputStream objOut = new ObjectOutputStream(stubSocket.getOutputStream());
			ObjectInputStream objIn = new ObjectInputStream(stubSocket.getInputStream());

			// Send methodOne-Request
			objOut.writeObject(objRef);
			objOut.writeObject("methodOne");
			objOut.writeObject(param1);
			objOut.writeObject(param2);
			objOut.flush();
			
			Object res = (Object) objIn.readObject();
			//TODO: return res; when there is acutally a correct return value
			System.out.println(res);
			
			objOut.close();
			objIn.close();
			stubSocket.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "In methodOne: host(" + objRef + ") port(" + objRef + ")";
	}

}
