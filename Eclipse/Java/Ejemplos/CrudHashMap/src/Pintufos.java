
public class Pintufos {
	
	int clave;//llave
	String nombre;
	String color;
	
	public Pintufos()
	{
		
	}
	
	public Pintufos(int clave)
	{
		this.clave = clave;
	}

	public Pintufos(int clave, String nombre, String color) {
		this.clave = clave;
		this.nombre = nombre;
		this.color = color;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pintufos [clave=" + clave + ", nombre=" + nombre + ", color=" + color + "]\n";
	}
	
	
	

}
