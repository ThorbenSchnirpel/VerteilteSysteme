package aufgabe3;

import java.io.IOException;
import java.net.UnknownHostException;

import mware_lib.NameService;
import mware_lib.ObjectBroker;

public class Server {

	public static void main(String[] args) throws UnknownHostException, IOException{
		ObjectBroker objBroker = ObjectBroker.init("localhost", 8811, false);
		NameService nameSrvc = objBroker.getNameService();
		String str1 = "Ich bin ein Objekt.";
		String str2 = "Ich bin ein anderes Objekt.";
		
		
		nameSrvc.rebind(str1,"A");
		//nameSrvc.rebind(str2,"B");
		while(true){
			
		}
	}
}
