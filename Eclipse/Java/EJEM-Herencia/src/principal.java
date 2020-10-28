
public class principal {

	public static void main(String[] args) {

		hija mariana = new hija("Mariana", "Gomez", "De La Rosa", 19, "Dentista", "Prepa", "Cafe", 1.70);
		System.out.println(mariana);
		//set hijo
		mariana.setEscolaridad("prepa");
		//set papa
		mariana.setEdad(20);
		System.out.println(mariana);
		
		//Método papá
		mariana.cocinar(1.30);
		//Método hijo
		mariana.estudiando();
		
	}

}
