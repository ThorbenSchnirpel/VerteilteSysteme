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
	private OutputStream Out;
	private ObjectOutputStream objOut; // rebind
	private ObjectInputStream objIn; // resolve

	public NameServiceStub(String host, int port) throws UnknownHostException, IOException {
		stubSocket = new Socket(host, port);

		Out = stubSocket.getOutputStream();
		objOut = new ObjectOutputStream(stubSocket.getOutputStream());
	}

	@Override
	public void rebind(Object servant, String name) {
		// Kommunikation
		try {
			System.out.println("Called rebind in NameServiceStub");
			String rebind = "rebind\n";
			Out.write(("\n").getBytes());
			Out.write(rebind.getBytes());
			Out.write((name+"\n").getBytes());
			//objOut.writeObject(servant);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object resolve(String name) {
		try {
			System.out.println("Called resolve in NameServiceStub");
			String reslv = "resolve\n";
			Out.write(("\n").getBytes());
			Out.write(reslv.getBytes());
			Out.write((name+"\n").getBytes());
			System.out.println("Finished resolve request");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
