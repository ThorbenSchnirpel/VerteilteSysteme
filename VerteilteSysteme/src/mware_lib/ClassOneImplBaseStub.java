package mware_lib;

import accessor_one.ClassOneImplBase;
import accessor_one.SomeException112;

public class ClassOneImplBaseStub extends ClassOneImplBase{

	private String host;
	private int port;
	private RawObject objRef;
	
	public ClassOneImplBaseStub(Object rawObjectRef){
		this.objRef = (RawObject)rawObjectRef;
	}
	
	public String methodOne(int param1, String param2) throws SomeException112 {
		//return "param1: " + param1 + " +  param2: " + param2;
		return "In methodOne: host(" + objRef + ") port(" +objRef +")";
	}

}
