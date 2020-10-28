
public class Cartera {
	
	//>modelo:string, marca:string, precio:double, material:string

	String modelo;
	String marca;
	double precio;
	String material;
	
	public Cartera()
	{
		
	}
	
	public Cartera(String modelo)
	{
		this.modelo = modelo;
	}

	public Cartera(String modelo, String marca, double precio, String material) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.material = material;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Cartera [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", material=" + material + "]\n";
	}
	
	
}
