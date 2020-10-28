
public class Profesor {
	String nombre;
	String app;
	String apm;
	String matricula;
	
	public Profesor() {
		
	}

	public Profesor(String nombre, String app, String apm, String matricula) {
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.matricula = matricula;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", matricula=" + matricula + "]";
	}
	
	
	
}
