package mware_lib;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSkeletonThread extends Thread {
	ServerSocket svrSocket;

	ServerSkeletonThread(int port) {
		try {
			svrSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {

		try {
			System.out.println("Started ServerSkeletonThread - wait for connections on port: " + svrSocket.getLocalPort());
			
			Socket mySock;
			mySock = svrSocket.accept();

			ObjectInputStream objIn = new ObjectInputStream(mySock.getInputStream());
			ObjectOutputStream objOut = new ObjectOutputStream(mySock.getOutputStream());

			String req = (String) objIn.readObject();
			System.out.println("Received: " +req);
			
			System.out.println(req);
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}