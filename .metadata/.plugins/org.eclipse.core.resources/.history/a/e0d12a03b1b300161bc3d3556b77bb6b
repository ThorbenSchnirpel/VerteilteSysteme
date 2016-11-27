package aufgabe3;

import java.io.IOException;
import java.net.UnknownHostException;

import mware_lib.*;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		ObjectBroker objBroker = ObjectBroker.init("localhost", 8811, false);
		NameService nameSrvc = objBroker.getNameService();
		RawObject rawObj = new RawObject();
	//	nameSrvc.rebind(rawObj,"A");
		nameSrvc.resolve("A");
	}

}
