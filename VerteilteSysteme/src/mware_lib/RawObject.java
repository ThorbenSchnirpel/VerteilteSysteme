package mware_lib;

import java.io.Serializable;

public class RawObject implements Serializable {
	String host;
	int port;
	Object obj;

	public RawObject(String host, int port, Object obj) {
		this.host = host;
		this.port = port;
		this.obj = obj;
	}

	public String toString() {
		return "RawObject: host(" + host + ") port(" + port + ") obj(" + obj.toString() + ")";
	}

}
