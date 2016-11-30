package accessor_one;

import mware_lib.ClientStub;
import mware_lib.IMethodCall;

public abstract class ClassOneImplBase implements IMethodCall{
	
	public abstract String methodOne(int param1, String param2) throws SomeException112;

	public static ClassOneImplBase narrowCast(Object rawObjectRef) {
		ClientStub classOneImplBaseObj = new ClientStub(rawObjectRef);
		return classOneImplBaseObj;
	}
	
	public Object invokeMethod(Object methodname,Object param1, Object param2){
		try {
			Object ret;
			ret = methodOne((int)param1,(String)param2);
			return ret;
		} catch (SomeException112 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
}
