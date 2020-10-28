import java.util.HashMap;
import java.util.Scanner;

public class ImpGenerica implements Metodos{

	HashMap<Object, Object> hash = new HashMap <Object, Object>();
	Alumno a = null;
	
	@Override
	public void guardar(Object key, Object Obj) {
		hash.put(key, Obj);
		
	}

	@Override
	public void editar(Object key, Object Obj) {
		hash.put(key, Obj);
		
	}

	@Override
	public void eliminar(Object key) {
		hash.remove(key);
		
	}

	@Override
	public Object buscar(Object key) {
		return hash.get(key);
	}

	@Override
	public void mostrar() {
		System.out.println(hash+ "\n");
		
	}

}
