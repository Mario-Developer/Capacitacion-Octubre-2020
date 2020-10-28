
public abstract class Profesionista {
	String nombre;
	String app;
	String apm;
	String titulo;
	String cedula;
	String universidad;
	
	public void cobrar(double cantidad, String tipo) { //Método no abstracto
		
	}
	public abstract void trabajar(); //Método Abstracto
	
	public Profesionista() {
		
	}

	public Profesionista(String nombre, String app, String apm, String titulo, String cedula, String universidad) {
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.titulo = titulo;
		this.cedula = cedula;
		this.universidad = universidad;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	
	
}
