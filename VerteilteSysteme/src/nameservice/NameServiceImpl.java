package nameservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import aufgabe3.Client;
import mware_lib.Connection;
import mware_lib.NameService;

public class NameServiceImpl extends NameService {

	private static HashMap<String, Object> nameMap;

	@Override
	public void rebind(Object servant, String name) {
		nameMap.put(name, servant);
	}

	@Override
	public Object resolve(String name) {
		return nameMap.get(name);
	}

	public static void main(String[] args) throws IOException {
		ServerSocket mySvrSocket;
		BufferedReader in;
		ObjectOutputStream  objOut; // rebind
		ObjectInputStream  objIn; // resolve

		mySvrSocket = new ServerSocket(8811);

		while (true) {
			Socket mySock = mySvrSocket.accept(); // -> Socket fuer die
												  // eigentliche Verbindung
			in = new BufferedReader(new InputStreamReader(mySock.getInputStream()));
			//objIn = new ObjectInputStream(mySock.getInputStream());
			objOut = new ObjectOutputStream(mySock.getOutputStream());
            //TODO in durch objIn ersetzen? ObjectInputstream kann auch String             
			System.out.println("Vor if");
			in.readLine();
			String req = in.readLine();
			
			if(req.equals("resolve")){
				System.out.println("Got resolve request");
				//String name = in.readLine();
				//TODO Look name up
				//objOut.writeObject(nameMap.get(name)); 
				System.out.println("Finished resolve request");
			}else if(req.equals("rebind")){
				System.out.println("Got rebind request");
				String name = in.readLine();
//				try {
//					Object obj = objIn.readObject();
//					nameMap.put(name,obj);
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				//TODO get Object with object stream //http://stackoverflow.com/questions/12910350/how-to-send-an-object-over-tcp-in-java
				System.out.println("Finished rebind request");
			}else{
				System.out.println(req);
			}
			
			in.close();
			mySock.close();
		}
	}
}
