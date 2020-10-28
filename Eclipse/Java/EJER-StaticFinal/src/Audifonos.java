
public class Audifonos {
	String marca;
	String modelo;
	double precio;
	String tipo;
	
	public Audifonos(){
		
	}
	
	public Audifonos (String marca) {
		
	}

	public Audifonos(String marca, String modelo, double precio, String tipo) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Audifonos [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", tipo=" + tipo + "]\n";
	}
	
	
}
