package aufgabe3;

import java.io.IOException;
import java.net.UnknownHostException;

import mware_lib.NameService;
import mware_lib.ObjectBroker;

public class Server {

	public static void main(String[] args) throws UnknownHostException, IOException{
		ObjectBroker objBroker = ObjectBroker.init("localhost", 8888, false);
		NameService nameSrvc = objBroker.getNameService();
		int i=4666;
		nameSrvc.rebind(i,"A");
	}
}