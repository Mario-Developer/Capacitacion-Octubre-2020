//CRUD -> Create, Read, Update, Delete
public class balones {
	String modelo;
	String marca;
	Double precio;
	int numero;
	
	public balones() {
		
	}
	
	public balones(String modelo) {
		this.marca = marca;
	}

	public balones(int numero, double precio, String marca, String modelo) {
		this.numero = numero;
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "balones [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", numero=" + numero + "]";
	}
	
	
}
