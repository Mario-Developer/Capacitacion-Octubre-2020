
public class Principal {
	
	public static void main(String[] args) {
		
		Pintufos p1 = new Pintufos(1, "papa pitufo", "verde");
		Pintufos p2 = new Pintufos(2, "fortachon", "gris");
		Pintufos p3 = new Pintufos(3, "pitufina", "rojo");
		Pintufos pC = null;
		Implementacion imp = new Implementacion();
		
		imp.guardar(p1);
		imp.guardar(p2);
		imp.guardar(p3);
		
		imp.mostrar();
		
		//buscar
		pC = new Pintufos(2);
		pC = imp.buscar(pC);
		System.out.println("el pitufo encontrado es:"+pC);
		
		//editar->antes de editar hay que buscar
		System.out.println("editar");
		pC.setColor("amarillo");
		imp.editar(pC);
		imp.mostrar();
		
		System.out.println("eliminar");
		//eliminar
		imp.eliminar(pC);
		imp.mostrar();
		
		/*CRUD
		 * fRUTAS->String nombre llave, color String, precioKilo double, peso duble
		 *  1 alta
		 *  2 editar cualquier campo
		 *  3 eliminar
		 *  4 buscar
		 *  5 mostrar
		 *  6 contar
		 *  7 salir
		 * 
		 * 
		 * 
		 * */
		
		
		
	}

}
