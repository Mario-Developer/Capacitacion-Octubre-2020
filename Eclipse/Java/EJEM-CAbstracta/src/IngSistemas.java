
public class IngSistemas extends Profesionista{

	String lenguaje;
	String framework;
	String arquitectura;
	
	@Override
	public void trabajar() { //Método Abstracto Heredado
	}
	
	public void programar() { //Método Propio
		System.out.println("Programando...");
	}
	
	public IngSistemas() {
		
	}

	public IngSistemas(String nombre, String app, String apm, String titulo, String cedula, String universidad,
			String lenguaje, String framework, String arquitectura) {
		super(nombre, app, apm, titulo, cedula, universidad);
		this.lenguaje = lenguaje;
		this.framework = framework;
		this.arquitectura = arquitectura;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	public String getArquitectura() {
		return arquitectura;
	}

	public void setArquitectura(String arquitectura) {
		this.arquitectura = arquitectura;
	}

	@Override
	public String toString() {
		return "IngSistemas [lenguaje=" + lenguaje + ", framework=" + framework + ", arquitectura=" + arquitectura
				+ ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", titulo=" + titulo + ", cedula=" + cedula
				+ ", universidad=" + universidad + "]";
	}
	
	


	
	
}
