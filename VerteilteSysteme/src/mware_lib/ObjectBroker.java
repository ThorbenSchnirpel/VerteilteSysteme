package mware_lib;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;

public class ObjectBroker {
	public static NameService nameServ;
	public static HashMap<String, Object> objMap = new HashMap<String,Object>();

	public ObjectBroker(NameService nameServ){
		ObjectBroker.nameServ = nameServ;
	}
	public static ObjectBroker init(String serviceHost, int listenPort, boolean debug) throws UnknownHostException, IOException {
		nameServ = new NameServiceStub(serviceHost,listenPort);
		ServerSkeletonThread servSkel = new ServerSkeletonThread(9999); // This thread always runs on port 9999(only one thread)
		servSkel.start();
		return new ObjectBroker(nameServ);
	}

	public NameService getNameService() {
		return nameServ;
		//  Liefert den Namensdienst (Stellvetreterobjekt).
	}

	public void shutDown() {
		//  Beendet die Benutzung der Middleware in dieser Anwendung.
	}
	
	public static Object getObj(Object objRef) {
		return objMap.get((String)objRef);
	}
	
	public static void setObj(Object obj, Object objRef) {
		objMap.put((String)objRef,obj);
	}
	
}
