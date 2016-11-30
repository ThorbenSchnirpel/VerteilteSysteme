package mware_lib;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import mware_lib.ObjectBroker;

public class ServerSkeletonThread extends Thread {
	ServerSocket svrSocket;

	public ServerSkeletonThread(int port) {
		try {
			svrSocket = new ServerSocket(port);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void run() {

		try {
			System.out.println(
					"Started ServerSkeletonThread - wait for connections on port: " + svrSocket.getLocalPort());

			Socket mySock;
			mySock = svrSocket.accept();

			ObjectInputStream objIn = new ObjectInputStream(mySock.getInputStream());
			ObjectOutputStream objOut = new ObjectOutputStream(mySock.getOutputStream());

			String objRef = (String) objIn.readObject();
			String req = (String) objIn.readObject();
			Object param1 = (Object) objIn.readObject();
			Object param2 = (Object) objIn.readObject();

			System.out.println("Received: " + req + " for Objectreference: " + objRef + " with param1: " + param1
					+ " param2: " + param2);

			Object obj = ObjectBroker.getObj(objRef);
		
			Object ret =((IMethodCall) obj).invokeMethod((Object)req,(Object)param1,(Object)param2);
			
			System.out.println("Return: " + ret);

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
