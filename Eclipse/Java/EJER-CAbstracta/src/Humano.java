
public class Humano extends SerVivo{
	String Nombre;
	int edad;
	
	@Override
	public void comunicarce() {
		System.out.println("Hablando");
		
	}

	@Override
	public void comer() {
		System.out.println("Comiendo Hamburguesa");
		
	}
	
	public void construir() {
		System.out.println("Construyendo");
	}
	
	public Humano() {
		
	}

	public Humano(String genero, String especie, String nombre, int edad) {
		super(genero, especie);
		Nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Humano [Nombre=" + Nombre + ", edad=" + edad + ", Genero=" + Genero + ", Especie=" + Especie + "]";
	}
	
	


	
	
}
