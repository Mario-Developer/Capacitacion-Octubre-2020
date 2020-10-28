
public class Caballo extends SerVivo{
	String Raza;
	String Color;
	
	@Override
	public void comunicarce() {
		System.out.println("Relinchando...");
		
	}
	@Override
	public void comer() {
		System.out.println("Comiendo pasto");
		
	}
	
	public void equitar() {
		System.out.println("Equitando");
	}
	 public Caballo() {
		 
	 }
	public Caballo(String genero, String especie, String raza, String color) {
		super(genero, especie);
		Raza = raza;
		Color = color;
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
		return "Caballo [Raza=" + Raza + ", Color=" + Color + ", Genero=" + Genero + ", Especie=" + Especie + "]";
	}
	 
	 
	
}
