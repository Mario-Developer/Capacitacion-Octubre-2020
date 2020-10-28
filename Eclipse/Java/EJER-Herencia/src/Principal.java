import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		
		Perro p = new Perro("Toby", "French", "Blanco");
		Perro p1 = new Perro("Doug", "Chihuahua", "Café");
		Perro p2 = new Perro("Dante", "Xolo", "Negro");
		Perro pc = null;
		ImplemPerro imp = new ImplemPerro();
		
		imp.guardar(p);
		imp.guardar(p1);
		imp.guardar(p2);
		
		imp.mostrar();
		
		pc = (Perro)imp.buscar(0);
		System.out.println("Objeto encontrado: "+pc);
	}
}
