package mware_lib;

public class ObjectBroker {
	public static ObjectBroker init(String serviceHost, int listenPort, boolean debug) {
		return null;
	}
	// ��Front�End�der�Middleware�public�static�ObjectBroker�init(String�serviceHost,�
	// int�listenPort,�boolean�debug)�{�...�} ���
	// �Das�hier�zur�ckgelieferte�Objekt�soll�der�zentrale�Einstiegspunkt� ���
	// �der�Middleware�aus�Applikationssicht�sein. ���
	// �Parameter:�Host�und�Port,�bei�dem�die�Dienste�(hier:�Namensdienst) ���
	// ������������kontaktiert�werden�sollen.�Mit�debug�sollen�Test���
	// ������������ausgaben�der�Middleware�ein��oder�ausgeschaltet�werden ���
	// ������������k�nnen.�

	public NameService getNameService() {
		return null;
		// �Liefert�den�Namensdienst�(Stellvetreterobjekt).
	}

	public void shutDown() {
		// �Beendet�die�Benutzung�der�Middleware�in�dieser�Anwendung.
	}
}
