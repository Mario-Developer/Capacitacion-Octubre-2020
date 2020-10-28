import java.util.*;

public class principal {
	public static void main(String[] args) {
		Scanner l = null;
		int menu, menuE;
		
		balones balon = null;
		Implementacion imp = new Implementacion();
		
		String marca, modelo;
		int numero;
		double precio;
		
		do {
			System.out.println("Alta");
			System.out.println("Editar");
			System.out.println("Eliminar");
			System.out.println("Buscar por ID");
			System.out.println("Buscar por Marca");
			System.out.println("Vacia");
			System.out.println("Contar");
			System.out.println("Eliminar todo");
			System.out.println("Mostrar");
			System.out.println("Salir");
			l = new Scanner(System.in);
			menu = l.nextInt();
			
			switch(menu) {
				case 1: //Alta
					l=new Scanner(System.in);
					System.out.println("Ingrese Marca");
					marca = l.nextLine();
					System.out.println("Ingrese Número");
					numero = l.nextInt();
					System.out.println("Ingrese Precio");
					precio = l.nextDouble();
					System.out.println("Ingrese Modelo");
					modelo = l.nextLine();
					balon = new balones(numero, precio, marca, modelo);
					imp.guardar(balon);
					System.out.println("Balón guardado");
					break;
				case 2: //Editar
					break;
				case 3: //Eliminar
					l = new Scanner(System.in);
					System.out.println("Ingrese Modelo a eliminar");
					modelo = l.nextLine();
					balon = new balones(modelo);
					balon = (balones)imp.buscar(balon);
					imp.eliminar(balon);
					System.out.println("El balon encontrado es: "+balon);
					break;
				case 4: //Buscar ID
					l = new Scanner(System.in);
					System.out.println("Ingrese Modelo a buscar");
					modelo = l.nextLine();
					balon = new balones(modelo);
					balon = (balones)imp.buscar(balon);
					System.out.println("El balon encontrado es: "+balon);
					break;
				case 5: //Buscar Marca
					
					
					break;
				case 6: //Vacia
					if(imp.hash.isEmpty()) {
						System.out.println("Hash vacía");
					}else {
						System.out.println("Hash no vacía");
					}
					break;
				case 7: //Contar
					break;
				case 8: //Eliminar todo
					imp.hash.clear();
					break;
				case 9: //Mostrar
					imp.mostrar();
					break;
				case 10: //Slir
					break;
			}
		}while(menu < 10);
		
	}

}
