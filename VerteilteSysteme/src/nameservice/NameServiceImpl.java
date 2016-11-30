package nameservice;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import mware_lib.RawObject;

public class NameServiceImpl{

	private static HashMap<String, RawObject> nameMap = new HashMap<String,RawObject>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket mySvrSocket;
		ObjectOutputStream objOut; // rebind
		ObjectInputStream objIn; // resolve
		//TODO: Port muss zur Laufzeit einstellbar sein
		mySvrSocket = new ServerSocket(8811);

		while (true) {
			Socket mySock = mySvrSocket.accept();

			objIn = new ObjectInputStream(mySock.getInputStream());
			objOut = new ObjectOutputStream(mySock.getOutputStream());
			
			String req = (String) objIn.readObject();

			if (req.equals("resolve")) {

				String name = (String) objIn.readObject();				
				System.out.println("Got resolve-Request for : " + name );
				
				Object obj = nameMap.get(name);
				System.out.println(obj.toString());
				
				objOut.writeObject(obj);
				objOut.flush();
				
			} else if (req.equals("rebind")) {
				System.out.println("Got rebind request from host: "
						+mySock.getInetAddress().getHostAddress() 
						+ " port: " + mySock.getPort());

				Object servant = (Object) objIn.readObject();
				String name = (String) objIn.readObject();

				RawObject rawObj = new RawObject(mySock.getInetAddress().getHostAddress(),9999,servant); // ServerSkeletonThread always receives on port 9999
				
				nameMap.put(name, rawObj);
				System.out.println("Added Objectreference: " + servant + " with name : " + name + " to nameMap!");
				
			} else {
				System.out.println(req);
			}

			objIn.close();
			objOut.close();
			mySock.close();
		}
	}
}
