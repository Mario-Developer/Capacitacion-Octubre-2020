
public class Fruta {
	
	String nombre;//llave
	String color;
	double peso;
	double precio;
	
	public Fruta()
	{
		
	}
	
	public Fruta(String nombre)
	{
		this.nombre = nombre;
	}

	public Fruta(String nombre, String color, double peso, double precio) {
		this.nombre = nombre;
		this.color = color;
		this.peso = peso;
		this.precio = precio;
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", color=" + color + ", peso=" + peso + ", precio=" + precio + "]\n";
	}
	
	

}
