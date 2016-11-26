package mware_lib;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ObjectBroker {
	public static NameService nameServ;
	
	public ObjectBroker(NameService nameServ){
		this.nameServ = nameServ;
	}
	public static ObjectBroker init(String serviceHost, int listenPort, boolean debug) throws UnknownHostException, IOException {
		nameServ = new NameServiceStub(serviceHost,listenPort);	
		return new ObjectBroker(nameServ);
	}


	public NameService getNameService() {
		return nameServ;
		//  Liefert den Namensdienst (Stellvetreterobjekt).
	}

	public void shutDown() {
		//  Beendet die Benutzung der Middleware in dieser Anwendung.
	}
}
