
public class Perro {
	String Nombre;
	String Raza;
	String Color;
	
	public Perro() {
		
	}

	public Perro(String nombre, String raza, String color) {
		this.Nombre = nombre;
		this.Raza = raza;
		this.Color = color;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getRaza() {
		return Raza;
	}

	public void setRaza(String raza) {
		Raza = raza;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	@Override
	public String toString() {
		return "Perro [Nombre=" + Nombre + ", Raza=" + Raza + ", Color=" + Color + "]";
	}
	
	
}
