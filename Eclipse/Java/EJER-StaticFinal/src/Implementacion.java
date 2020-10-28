import java.util.HashMap;

public class Implementacion {
	
	static HashMap<Object, Object> hash = new HashMap<Object, Object>();
	
	public static void guardar(Object obj, Object key) {
		hash.put(key, obj);
	}
	public static void editar(Object obj, Object key) {
		hash.put(key, obj);
	}
	public static void eliminar(Object key) {
		hash.remove(key);
	}
	public static Object buscar(Object key) {
		return hash.get(key);
	}
	public static void mostar() {
		System.out.println(hash);
	}
	
	
}
