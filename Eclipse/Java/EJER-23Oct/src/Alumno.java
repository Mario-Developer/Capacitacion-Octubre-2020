
public class Alumno {
	String nombre;
	String app;
	String apm;
	String matricula;
	Profesor prof;
	
	public Alumno() {
		
	}

	public Alumno(String nombre, String app, String apm, String matricula, Profesor prof) {
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.matricula = matricula;
		this.prof = prof;
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

	public Profesor getProf() {
		return prof;
	}

	public void setProf(Profesor prof) {
		this.prof = prof;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", matricula=" + matricula + ", prof="
				+ prof + "]";
	}
	
	
}
