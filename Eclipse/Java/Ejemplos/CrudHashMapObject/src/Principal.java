
public class Principal {
	
	public static void main(String[] args) {
		
		Peluche p1 = new Peluche("p-01", "blanco", 80);
		Peluche p2 = new Peluche("p-02", "gris", 160);
		Peluche p3 = new Peluche("p-03", "negro", 240);
		Peluche pC = null;
		
		Implementacion imp = new Implementacion();
		
		imp.guardar(p1);
		imp.guardar(p2);
		imp.guardar(p3);
		
		imp.mostrar();
		
		pC = new Peluche("p-02");
		pC = (Peluche)imp.buscar(pC);
		System.out.println("el peluche encontrado es:"+pC);
		
		pC.setPrecio(200);
		imp.editar(pC);
		imp.mostrar();
		
		
		imp.eliminar(pC);
		imp.mostrar();
		
		
	}

}
