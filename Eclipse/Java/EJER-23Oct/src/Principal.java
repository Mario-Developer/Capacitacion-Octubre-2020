import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Profesor p0 = new Profesor("Armando", "Lopez", "Perez", "M001");
		Profesor p1 = new Profesor("Fernando", "Paredes", "Juarez", "M002");
		Profesor p2 = new Profesor("Orlando", "Gomez", "Vazquez", "M003");
		
		Alumno a = null;
		
		
		ImpProfesor imp = new ImpProfesor();
		ImpAlumno ima = new ImpAlumno();
		
		Scanner s = null;
		int opc, case4, opca;
		String nombre, app, apm, matricula, matriculap;
		
		do {	
			System.out.println("1. Alta Profesor");
			System.out.println("2. Mostrar Profesor");
			System.out.println("3. Alta Alumno");
			System.out.println("4. Editar Alumno");
			System.out.println("5. Eliminar Alumno");
			System.out.println("6. Buscar Alumno");
			System.out.println("7. Mostrar Alumno");
			System.out.println("8. Salir");
			
			s = new Scanner(System.in);
			opc = s.nextInt();
			
			switch(opc) {
				case 1:
					imp.guardar("M001", p0);
					imp.guardar("M002", p1);
					imp.guardar("M003", p2);
					break;
					
				case 2:
					if(imp.hash.isEmpty()) {
						System.out.println("No hay profesores registrados");
					}else {
						imp.mostrar();
					}
					break;
					
				case 3:
					if(imp.hash.isEmpty()) {
						System.out.println("No se pueden registrar alumnos si no hay profesores");
					}else {
						try {
							s=new Scanner(System.in);
							System.out.println("Ingrese Nombre:");
						 	nombre = s.nextLine();
							
							System.out.println("Ingrese Apellido P:");
							app = s.nextLine();
							
							System.out.println("Ingrese Apellido M:");
							apm = s.nextLine();
							
							System.out.println("Ingrese Matrícula:");
							matricula  = s.nextLine();
							
							System.out.println("Seleccione un profesor por su matrícula:");
							imp.mostrar();
							matriculap = s.nextLine();
							
							if(imp.hash.containsKey(matriculap)) {
								a = new Alumno(nombre, app, apm, matricula, (Profesor) imp.buscar(matriculap));
								ima.guardar(matricula, a);
							}else {
								System.out.println("No es posible encontrar la matrícula del profesor solicitado");
							}
						}catch(Exception e) {
							System.out.println("Algo salió mal, inténtelo de nuevo");
						}
					}
					break;
					
				case 4:
					if(ima.hash.isEmpty()) {
						System.out.println("No hay alumnos registrados");
					}else{
						try {
							s = new Scanner(System.in);
							System.out.println("Ingrese la matricula del alumno a editar: ");
							matricula = s.nextLine();
							
							if(ima.hash.containsKey(matricula)) {
								System.out.println("Ingrese Nombre:");
							 	nombre = s.nextLine();
								
								System.out.println("Ingrese Apellido P:");
								app = s.nextLine();
								
								System.out.println("Ingrese Apellido M:");
								apm = s.nextLine();
								
								System.out.println("Ingrese Matrícula:");
								matricula  = s.nextLine();
								
								System.out.println("Seleccione un profesor por su matrícula:");
								imp.mostrar();
								matriculap = s.nextLine();
								
								if(imp.hash.containsKey(matriculap)) {
									a = new Alumno(nombre, app, apm, matricula, (Profesor) imp.buscar(matriculap));
									ima.editar(matricula, a);
								}else {
									System.out.println("No es posible encontrar la matrícula del profesor solicitada");
								}
								
							}else {
								System.out.println("No es posible encontrar la matrícula solicitada");
							}
						}catch(Exception e) {
							System.out.println("Algo salió mal, inténtelo de nuevo");
						}
					}
					break;
					
				case 5:
					if(ima.hash.isEmpty()) {
						System.out.println("No hay alumnos registrados");
					}else {
						s = new Scanner(System.in);
						System.out.println("Ingrese la matrícula del alumno a eliminar");
						matricula = s.nextLine();
						if(ima.hash.containsKey(matricula)) {
							ima.eliminar(matricula);
						}else {
							System.out.println("No es posible encontrar la matrícula solicitada");
						}
					}
					break;
					
				case 6:
					if(ima.hash.isEmpty()) {
						System.out.println("No hay alumnos registrados");
					}else {
						s = new Scanner(System.in);
						System.out.println("Ingrese matrícula:");
						matricula = s.nextLine();
						if(ima.hash.containsKey(matricula)) {
							System.out.println("Alumno encontrado: "+ima.buscar(matricula) );
						}else {
							System.out.println("Alumno no encontrado");
						}
					}
					break;
					
				case 7:
					if(ima.hash.isEmpty()) {
						System.out.println("No hay alumnos registrados");
					}else {
						ima.mostrar();
					}
					break;
			}//Fin switch
		}while (opc < 8);
		
		
		
	}

}
