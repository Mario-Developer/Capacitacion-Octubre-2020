import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner l = null;
		int menu, menuE;

		String nombre;// llave
		String color;
		double peso;
		double precio;

		Fruta fruta = null;
		Implementacion imp = new Implementacion();

		System.out.println("BIENVENIDOS A SU FRUTERIA ENUCOM");
		do {
			System.out.println("*** MENU ***");
			System.out.println("1.-alta");
			System.out.println("2.-editar");
			System.out.println("3.-eliminar");
			System.out.println("4.-buscar");
			System.out.println("5.-mostrar");
			System.out.println("6.-contra");
			System.out.println("7.-salir");

			l = new Scanner(System.in);
			menu = l.nextInt();

			switch (menu) {
			case 1:
				// alta
				System.out.println("ALTA DE FRUTAS");

				System.out.println("escriba el nombre");
				l = new Scanner(System.in);
				nombre = l.nextLine();

				System.out.println("escriba el color");
				l = new Scanner(System.in);
				color = l.nextLine();

				System.out.println("escriba el precio");
				l = new Scanner(System.in);
				precio = l.nextDouble();

				System.out.println("escriba el peso");
				l = new Scanner(System.in);
				peso = l.nextDouble();

				fruta = new Fruta(nombre, color, peso, precio);
				imp.guardar(fruta);
				System.out.println("se guardo la fruta:" + fruta + " correctamente!!!");
				break;
			case 2:
				// editar
				System.out.println("escriba el nombre a editar");
				l = new Scanner(System.in);
				nombre = l.nextLine();

				fruta = new Fruta(nombre);
				fruta = imp.buscar(fruta);

				do {
					System.out.println("elige la opcion a editar");
					System.out.println("1.-color");
					System.out.println("2.-precio");
					System.out.println("3.-peso");
					System.out.println("4.-regresar->");

					l = new Scanner(System.in);

					menuE = l.nextInt();

					switch (menuE) {
					case 1:
						System.out.println("escriba el color a editar");
						l = new Scanner(System.in);
						color = l.nextLine();
						fruta.setColor(color);
						break;
					case 2:
						System.out.println("escriba el color a peso");
						l = new Scanner(System.in);
						peso = l.nextDouble();
						fruta.setPeso(peso);
						break;
					case 3:
						System.out.println("escriba el color a precio");
						l = new Scanner(System.in);
						precio = l.nextDouble();
						fruta.setPrecio(precio);
						break;

					}// cierra switch interno

					imp.editar(fruta);
					System.out.println("se edito la fruta correctamente!!!");
				} while (menuE < 4);

				break;
			case 3:
				// eliminar
				System.out.println("escriba el nombre a eliminar");
				l = new Scanner(System.in);
				nombre = l.nextLine();

				fruta = new Fruta(nombre);
				fruta = imp.buscar(fruta);
				imp.eliminar(fruta);
				System.out.println("se elimno la fruta:" + fruta);
				break;
			case 4:
				// buscar
				System.out.println("escriba el nombre a buscar");
				l = new Scanner(System.in);
				nombre = l.nextLine();

				fruta = new Fruta(nombre);
				fruta = imp.buscar(fruta);
				System.out.println("la fruta encontrada es:" + fruta);
				break;
			case 5:
				// mostrar
				imp.mostrar();
				break;
			case 6:
				imp.contar();
				break;
			case 7:
				System.out.println("gracias por vicitarnos");
				break;

			}// cierra el switch
		} while (menu < 7);
	}// cierra main

	
	//Clase Object->
	
}
