package mware_lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NameServiceStub extends NameService {

	Socket stubSocket;
	private String host;
	private int port;
	private ObjectOutputStream objOut; // rebind
	private ObjectInputStream objIn; // resolve

	public NameServiceStub(String host, int port) throws UnknownHostException, IOException {
		this.host=host;
		this.port=port;
	}

	@Override
	public void rebind(Object servant, String name) {
		// Kommunikation
		try {
			stubSocket = new Socket(host, port);
			objOut = new ObjectOutputStream(stubSocket.getOutputStream());

			//Send rebind-Request
			objOut.writeObject("rebind");
			objOut.writeObject(servant);
			objOut.writeObject(name);
			objOut.flush();

			int port_skel =stubSocket.getLocalPort();
			
			//stubSocket.close();

			//ServerSkeletonThread servSkel = new ServerSkeletonThread(port_skel);
			//servSkel.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object resolve(String name){
		try {
			
			stubSocket = new Socket(host, port); //Get new tcp-connection
			
			objOut = new ObjectOutputStream(stubSocket.getOutputStream());
			objIn = new ObjectInputStream(stubSocket.getInputStream());
			
			//Send resolve-request
			objOut.writeObject("resolve");
			objOut.writeObject(name);
			objOut.flush();
			
			//Receive resolve-reply
			Object res = (Object) objIn.readObject();
			
			return res;
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
