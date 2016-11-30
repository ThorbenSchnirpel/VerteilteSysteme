package aufgabe3;

import java.io.IOException;
import java.net.UnknownHostException;

import accessor_one.ClassOneImplBase;
import accessor_one.SomeException112;
import mware_lib.*;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException, SomeException112{
		ObjectBroker objBroker = ObjectBroker.init("localhost", 8811, false);
		NameService nameSrvc = objBroker.getNameService();
		
		Object rawObjRef =nameSrvc.resolve("A"); // gets RawObject (host,port,Object) from NS
		System.out.println("Client: resolved A to : " + ((RawObject)rawObjRef).getObj());
		
		ClassOneImplBase remoteObj = ClassOneImplBase.narrowCast(rawObjRef); //Gets a ClassOneImplStub

		String s = remoteObj.methodOne(556,"Hi there");
		System.out.println(s);

		objBroker.shutDown();
	}

}
