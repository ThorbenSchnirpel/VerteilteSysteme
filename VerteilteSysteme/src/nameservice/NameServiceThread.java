package nameservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NameServiceThread extends Thread {
	public void run() {

		ServerSocket serSock;
		try {
			serSock = new ServerSocket(8889);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedReader in;
		OutputStream out;

		while (true) {
			// Auf Verbindungsanfrage warten.
			Socket mySock;
			try {
				Socket mySock = serSock.accept();
				// -> Socket fuer die eigentliche Verbindung

				// I/O-Kanäle der Socket
				in = new BufferedReader(new InputStreamReader(mySock.getInputStream()));
				out = mySock.getOutputStream();

				// Kommunikation
				//TODO READ input and execute methods?
				System.out.println(in.readLine());
				out.write(("Who's there?\n").getBytes());

				// Verbindung schliessen
				in.close();
				out.close();
				mySock.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		// Server runterfahren
		//serSock.close();
	}
}
