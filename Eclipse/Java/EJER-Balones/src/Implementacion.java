import java.util.HashMap;
import java.util.Map;

public class Implementacion implements metodos{

	HashMap<String, balones> hash = new  HashMap<String, balones>(); 
	//'String': La llave es de tipo string pues se buscará a travez de la marca 
	//'balones': Es el objeto que guardará la hashmap
	
	balones balon = null;
	
	//Métodos de la Interfaz
	@Override
	public void guardar(Object Obj) {
		balon = (balones) Obj; //"Obj" se puede convertir en una clase "balones" mediante un cast
		hash.put(balon.getModelo(), balon);
	}

	@Override
	public void editar(Object Obj) {
		balon = (balones) Obj; 
		hash.put(balon.getModelo(), balon);
	}

	@Override
	public void eliminar(Object Obj) {
		balon = (balones) Obj; 
		hash.remove((balon).getModelo());
		
	}

	@Override
	public Object buscar(Object Obj) {
		balon = (balones) Obj; 
		hash.get(balon.getModelo());
		return balon;
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
		
	}
	
	//Métodos especiales
	public void contar() {
		System.out.println("Usted tiene: "+hash.size()+" balones");
	}
	
	public void vacia() {
		if(hash.isEmpty()) {
			System.out.println("El hash está vacío");
		}else {
			System.out.println("El has no está vacío");
		}
	}
	
	public void eliminarTodo() {
		hash.clear();
		System.out.println("Se eliminaron los elementos");
	}
	
	public void buscarMarca(Object Obj) {
		balon = (balones) Obj;
		for (Map.Entry<String, balones> entry : hash.entrySet()) {
			if(entry.getValue().getMarca().equals(balon.getMarca())) {
				System.out.println("Balon econtrado: " + entry.getValue());
			}
		}
	}
	
}