package mware_lib;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NameServiceStub extends NameService {

	private String host; //NameService
	private int port; //NameService
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
			Socket stubSocket = new Socket(host, port);
			objOut = new ObjectOutputStream(stubSocket.getOutputStream());

			//Send rebind-Request
			objOut.writeObject("rebind");
			objOut.writeObject(servant);
			objOut.writeObject(name);
			objOut.flush();
				
			ObjectBroker.setObj(name, servant);
			
			//objOut.close();
			//stubSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object resolve(String name){
		try {
			
			Socket 
			stubSocket = new Socket(host, port); //Get new tcp-connection
			
			objOut = new ObjectOutputStream(stubSocket.getOutputStream());
			objIn = new ObjectInputStream(stubSocket.getInputStream());
			
			//Send resolve-request
			objOut.writeObject("resolve");
			objOut.writeObject(name);
			objOut.flush();
			
			//Receive resolve-reply
			Object res = (Object) objIn.readObject();

			objOut.close();
			objIn.close();
			stubSocket.close();
			
			return res;
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
