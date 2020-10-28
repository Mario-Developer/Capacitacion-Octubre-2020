import java.util.*;

public class Principal {

	public static void main(String[] args) {

		Scanner l = null;
		int menu, menuE, index;

		String modelo;
		String marca;
		double precio;
		String material;

		Cartera cartera = null;
		Implementacion imp = new Implementacion();

		System.out.println("BIENVENIDOS A SU TIENDA DE CARTERAS -> ENUCOM");
		do {
			System.out.println("*** MENU ***");
			System.out.println("1.-alta");
			System.out.println("2.-editar");
			System.out.println("3.-eliminar");
			System.out.println("4.-buscar id");
			System.out.println("5.-buscar por modelo");
			System.out.println("6.-contar");
			System.out.println("7.-vacia");
			System.out.println("8.-eliminar");
			System.out.println("9.-mostrar");
			System.out.println("10.-salir");

			l = new Scanner(System.in);
			menu = l.nextInt();

			switch (menu) {
			case 1:
				// alta
				System.out.println("ALTA DE CARTERAS");

				System.out.println("escribe el modelo");
				l = new Scanner(System.in);
				modelo = l.nextLine();

				System.out.println("escribe la marca");
				l = new Scanner(System.in);
				marca = l.nextLine();

				System.out.println("escribe el material");
				l = new Scanner(System.in);
				material = l.nextLine();

				System.out.println("escribe el precio");
				l = new Scanner(System.in);
				precio = l.nextInt();

				cartera = new Cartera(modelo, marca, precio, material);
				imp.guardar(cartera);
				break;
			case 2:
				// editar->antes de editar hay que buscar
				System.out.println("Escribe el id a editar");
				l = new Scanner(System.in);
				index = l.nextInt();
				cartera = imp.buscar(index);
				do {
					System.out.println("elige la opción");
					System.out.println("1.-precio");
					System.out.println("2.-material");
					System.out.println("3.-regresar");
					l = new Scanner(System.in);
					menuE = l.nextInt();

					if (menuE == 1) {
						System.out.println("escribe el precio a editar");
						l = new Scanner(System.in);
						precio = l.nextInt();
						cartera.setPrecio(precio);
					} else if (menuE == 2) {
						System.out.println("escribe el material a buscar");
						l = new Scanner(System.in);
						material = l.nextLine();
						cartera.setMaterial(material);
					}
					imp.editar(index, cartera);
				} while (menuE < 3);
				break;
			case 3:
				// eliminar
				System.out.println("Escribe el id a eliminar");
				l = new Scanner(System.in);
				index = l.nextInt();
				imp.eliminr(index);

				break;
			case 4:
				// buscar por id
				System.out.println("Escribe el id a buscar");
				l = new Scanner(System.in);
				index = l.nextInt();
				cartera = imp.buscar(index);
				System.out.println("la cartera que busca es:" + cartera);
				break;
			case 5:
				// buscar por modelo
				System.out.println("escribe el modelo a buscar");
				l = new Scanner(System.in);
				modelo = l.nextLine();

//				cartera = new Cartera();
//				cartera.setModelo(modelo);

//				cartera = new Cartera(modelo, null, 0, null);

				cartera = new Cartera(modelo);
				cartera = imp.buscarModelo(cartera);

				break;
			case 6:
				// contar
				imp.contar();
				break;
			case 7:
				// vacia
				imp.vacia();
				break;
			case 8:
				// eliminar
				break;
			case 9:
				// mostrar
				imp.mostrar();
				break;
			case 10:
				System.out.println("gracias por vicitarnos!!!");
				break;
			}// cierra switch

		} while (menu < 10);
	}// cierra main

}
