package accessor_one;

public abstract class ClassTwoImplBase {
	public abstract int methodOne(double param1, String param2) throws SomeException110;

	public abstract double methodTwo() throws SomeException112;

	public static ClassTwoImplBase narrowCast(Object rawObjectRef) {
		return null;
	}
}
