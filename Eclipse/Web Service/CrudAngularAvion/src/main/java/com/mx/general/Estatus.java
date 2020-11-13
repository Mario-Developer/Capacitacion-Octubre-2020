package com.mx.general;

public class Estatus {
	String res;
	String message;
	Object obj;
	
	public Estatus() {
		
	}

	public Estatus(String res, String message, Object obj) {
		super();
		this.res = res;
		this.message = message;
		this.obj = obj;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Estatus [res=" + res + ", message=" + message + ", obj=" + obj + "]\n";
	}
	
	
}
