
public class hija extends papa {
	String escolaridad;
	String colorCabello;
	double estatura;
	
	public hija() {
		
	}

	public hija(String nombre, String app, String apm, int edad, String trabajo, String escolaridad,
			String colorCabello, double estatura) {
		super(nombre, app, apm, edad, trabajo);
		this.escolaridad = escolaridad;
		this.colorCabello = colorCabello;
		this.estatura = estatura;
	}
	public void estudiando() {
		System.out.println("Estudiando...");
	}

	@Override
	public String toString() {
		return "hija [escolaridad=" + escolaridad + ", colorCabello=" + colorCabello + ", estatura=" + estatura
				+ ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", edad=" + edad + ", trabajo=" + trabajo
				+ "]";
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public String getColorCabello() {
		return colorCabello;
	}

	public void setColorCabello(String colorCabello) {
		this.colorCabello = colorCabello;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	
}
