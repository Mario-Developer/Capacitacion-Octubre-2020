
public class Medico extends Profesionista{
	String colorBata;
	String especialdad;
	
	@Override
	public void trabajar() { //Método Abstracto Heredado
	}
	
	public void operar() { //Método Propio
		System.out.println("Operando...");
	}
	
	public Medico() {
		
	}

	public Medico(String nombre, String app, String apm, String titulo, String cedula, String universidad,
			String colorBata, String especialdad) {
		super(nombre, app, apm, titulo, cedula, universidad);
		this.colorBata = colorBata;
		this.especialdad = especialdad;
	}

	public String getColorBata() {
		return colorBata;
	}

	public void setColorBata(String colorBata) {
		this.colorBata = colorBata;
	}

	public String getEspecialdad() {
		return especialdad;
	}

	public void setEspecialdad(String especialdad) {
		this.especialdad = especialdad;
	}

	@Override
	public String toString() {
		return "Medico [colorBata=" + colorBata + ", especialdad=" + especialdad + ", nombre=" + nombre + ", app=" + app
				+ ", apm=" + apm + ", titulo=" + titulo + ", cedula=" + cedula + ", universidad=" + universidad + "]";
	}

	
	
}
