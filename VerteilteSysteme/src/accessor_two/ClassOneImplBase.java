package accessor_two;

public abstract class ClassOneImplBase {
	public abstract double methodOne(String param1, double param2) throws SomeException112;

	public abstract double methodTwo(String param1, double param2) throws SomeException112, SomeException604;

	public static ClassOneImplBase narrowCast(Object rawObjectRef) {
		return null;
	}
}
