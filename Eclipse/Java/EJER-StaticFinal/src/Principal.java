import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Audifonos a = null;

		Scanner s = null;
		int menu, menue;
		double precio = 0;
		String marca = null;
		String modelo = null;
		String tipo = null;

		do {
			System.out.println("1. Alta");
			System.out.println("2. Buscar Marca");
			System.out.println("3. Eliminar");
			System.out.println("4. Editar");
			System.out.println("5. Mostrar");
			System.out.println("6. Salir");
			s = new Scanner(System.in);
			menu = s.nextInt();

			switch (menu) {
			case 1:
				try {
					System.out.println("Marca: ");
					s = new Scanner(System.in);
					marca = s.nextLine();
					System.out.println("Modelo: ");
					s = new Scanner(System.in);
					modelo = s.nextLine();
					System.out.println("Precio: ");
					s = new Scanner(System.in);
					precio = s.nextInt();
					System.out.println("Tipo: ");
					s = new Scanner(System.in);
					tipo = s.nextLine();
				} catch (Exception e) {
					System.out.println("Revisar datos");
				}
				a = new Audifonos(marca, modelo, precio, tipo);
				Implementacion.guardar(a, marca);
				break;
			case 2:
				if (Implementacion.hash.isEmpty()) {
					System.out.println("No hay registros en la tabla");
				} else {
					s = new Scanner(System.in);
					System.out.println("Ingrese Marca");
					marca = s.nextLine();
					if (Implementacion.hash.containsKey(marca)) {
						System.out.println(Implementacion.buscar(marca));
					} else {
						System.out.println("La marca no existe");
					}
				}
				break;
			case 3:
				if (Implementacion.hash.isEmpty()) {
					System.out.println("No hay registros en la tabla");
				} else {
					s = new Scanner(System.in);
					System.out.println("Marca a eliminar");
					marca = s.nextLine();
					if (Implementacion.hash.containsKey(marca)) {
						Implementacion.eliminar(marca);
					} else {
						System.out.println("La marca no existe");
					}
				}
				break;
			case 4:
				if (Implementacion.hash.isEmpty()) {
					System.out.println("No hay registros en la tabla");
				}else {
					System.out.println("Ingrese marca a editar: ");
					s = new Scanner(System.in);
					marca = s.nextLine();

					a = new Audifonos(marca);
					a = (Audifonos) Implementacion.buscar(marca);// Polimorfismo
					
					do {
						System.out.println("1. Tipo");
						System.out.println("2. Modelo");
						System.out.println("3. Regresar");

						s = new Scanner(System.in);
						menue = s.nextInt();

						switch (menue) {
						case 1:
							System.out.println("Editar tipo: ");
							s = new Scanner(System.in);
							tipo = s.nextLine();
							a.setTipo(tipo);
							break;
						case 2:
							System.out.println("Editar modelo: ");
							s = new Scanner(System.in);
							modelo = s.nextLine();
							a.setModelo(modelo);
							break;
						case 3:
							break;
						}
						Implementacion.editar(a, marca);
					} while (menue < 3);
				}
				break;
			case 5:
				if (Implementacion.hash.isEmpty()) {
					System.out.println("No hay registros en la tabla");
				} else {
					Implementacion.mostar();
				}
				break;
			case 6:
				break;
			}
		} while (menu < 6);
	}

}
