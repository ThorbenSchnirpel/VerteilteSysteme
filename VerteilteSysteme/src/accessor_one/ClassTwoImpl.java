package accessor_one;

public class ClassTwoImpl extends ClassTwoImplBase{

	@Override
	public int methodOne(double param1, String param2) throws SomeException110 {
		return (int) param1;
	}

	@Override
	public double methodTwo() throws SomeException112 {
		return 1.5;
	}

}
