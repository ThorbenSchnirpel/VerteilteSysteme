package accessor_one;

import mware_lib.ClassOneImplBaseStub;

public abstract class ClassOneImplBase {
	
	public abstract String methodOne(int param1, String param2) throws SomeException112;

	public static ClassOneImplBase narrowCast(Object rawObjectRef) {
		ClassOneImplBaseStub classOneImplBaseObj = new ClassOneImplBaseStub(rawObjectRef);
		return classOneImplBaseObj;
	}
}
