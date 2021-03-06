package mware_lib;

public abstract class NameService {
	// ��Schnittstelle�zum�Namensdienst�public�abstract�void�rebind(Object�servant,�String�name);
	// �Meldet�ein�Objekt�(servant)�beim�Namensdienst�an. ���
	// �Eine�eventuell�schon�vorhandene�Objektreferenz�gleichen�Namens ���
	// �soll��berschrieben�werden.

	public abstract void rebind(Object servant, String name);

	public abstract Object resolve(String name); // �Liefert�eine�generische�Objektreferenz�zu�einem�Namen.�(vgl.�unten)
}
