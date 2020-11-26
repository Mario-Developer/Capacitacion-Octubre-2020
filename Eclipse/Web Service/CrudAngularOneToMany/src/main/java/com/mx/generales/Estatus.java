package com.mx.generales;

public class Estatus {
	String message;
	String resp;
	Object obj;
	
	public Estatus() {
		
	}

	public Estatus(String message, String resp, Object obj) {
		this.message = message;
		this.resp = resp;
		this.obj = obj;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Estatus [message=" + message + ", resp=" + resp + ", obj=" + obj + "]\n";
	}
	
	
}
