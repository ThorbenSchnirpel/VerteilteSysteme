package mware_lib;

import java.io.Serializable;

public class RawObject implements Serializable {

	private static final long serialVersionUID = -3688393866021967126L;
	String host;
	int port;
	Object obj;

	public RawObject(String host, int port, Object obj) {
		this.host = host;
		this.port = port;
		this.obj = obj;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String toString() {
		return "RawObject: host(" + host + ") port(" + port + ") obj(" + obj.toString() + ")";
	}

}
