public abstract class SerVivo {
	String Genero;
	String Especie;
	
	public abstract void comunicarce();
	public abstract void comer();
	
	public SerVivo() {
		
	}

	public SerVivo(String genero, String especie) {
		Genero = genero;
		Especie = especie;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getEspecie() {
		return Especie;
	}

	public void setEspecie(String especie) {
		Especie = especie;
	}
	
	
}
