
public class Humano {
	String nombre;
	String npp;
	String apm;
	int edad;
	
	public Humano() {
		
	}

	public Humano(String nombre, String npp, String apm, int edad) {
		this.nombre = nombre;
		this.npp = npp;
		this.apm = apm;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNpp() {
		return npp;
	}

	public void setNpp(String npp) {
		this.npp = npp;
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

	@Override
	public String toString() {
		return "Humano [nombre=" + nombre + ", npp=" + npp + ", apm=" + apm + ", edad=" + edad + "]";
	}
	
	
	
}
