
public class Peluche {
	
	String modelo; //llave
	String color;
	double precio;
	
	public Peluche()
	{
		
	}
	
	public Peluche(String modelo)
	{
		this.modelo = modelo;
	}

	public Peluche(String modelo, String color, double precio) {
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Peluche [modelo=" + modelo + ", color=" + color + ", precio=" + precio + "]\n";
	}
	
	

}
