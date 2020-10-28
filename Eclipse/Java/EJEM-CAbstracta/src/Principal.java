
public class Principal {

	public static void main(String[] args) {
		Medico med1 = new Medico("Alberto", "Rosas", "De la Rosa", "T01T", "C01C", "Poli", "Blanca", "Pediatria");
		System.out.println(med1);
		//Metodo de clase super no abstracto
		med1.cobrar(500, "Efectivo");
		//Metodo de clase super abstracto
		med1.trabajar();
		//Metodo propio de clase hijo
		med1.operar();
		
		IngSistemas ing = new IngSistemas("Mario", "Gomez", "De la Rosa", "T02T", "C01C", "BUAP", "PHP", "Laravel", "Cliente Servidor");
		System.out.println(ing);
		ing.cobrar(10000, "Nomina");
		ing.trabajar();
		ing.programar();
	}

}
