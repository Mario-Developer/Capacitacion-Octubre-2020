
public class papa {
	String nombre;
	String app;
	String apm;
	int edad;
	String trabajo;
	
	public papa() {
		
	}
	public papa(String nombre, String app, String apm, int edad, String trabajo) {
		super();
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.edad = edad;
		this.trabajo = trabajo;
	}
	public void cocinar (double hora) {
		System.out.println("cocinando a las: "+ hora + " del día");
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getApm() {
		return apm;
	}
	public void setApm(String apm) {
		this.apm = apm;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	@Override
	public String toString() {
		return "papa [nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", edad=" + edad + ", trabajo=" + trabajo
				+ "]";
	}
	
}
