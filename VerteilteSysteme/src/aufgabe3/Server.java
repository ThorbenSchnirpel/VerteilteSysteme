package aufgabe3;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;

import accessor_one.ClassOneImpl;
import mware_lib.NameService;
import mware_lib.ObjectBroker;
import mware_lib.ServerSkeletonThread;

public class Server {

	public static void main(String[] args) throws UnknownHostException, IOException{
		
		ClassOneImpl classOneObj = new ClassOneImpl();
		
		ObjectBroker objBroker = ObjectBroker.init("localhost", 8811, false);
		NameService nameSrvc = objBroker.getNameService();
			
		nameSrvc.rebind(classOneObj,"A");

		while(true){
			
		}
	}
}
