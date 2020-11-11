package com.mx.generales;

public class Estatus {
	String res;
	String mensaje;
	Object obj;
	
	public Estatus() {
		
	}

	public Estatus(String res, String mensaje, Object obj) {
		this.res = res;
		this.mensaje = mensaje;
		this.obj = obj;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Estatus [res=" + res + ", mensaje=" + mensaje + ", obj=" + obj + "]\n";
	}
	
	
	
}
