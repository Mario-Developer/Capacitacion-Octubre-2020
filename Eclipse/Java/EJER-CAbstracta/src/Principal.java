
public class Principal {
	public static void main(String[] args) {
		Humano h = new Humano("Homo", "Homo Sapiens", "Adriana", 45);
		System.out.println(h);
		h.comer();
		h.comunicarce();
		h.construir();
		
		Caballo c = new Caballo("Equus", "E. Ferus", "Arabe", "Negro");
		System.out.println(c);
		c.comer();
		c.comunicarce();
		c.equitar();
	}
}
