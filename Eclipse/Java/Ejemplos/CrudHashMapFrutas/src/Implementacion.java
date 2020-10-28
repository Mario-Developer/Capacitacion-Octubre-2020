import java.util.HashMap;

public class Implementacion implements Metodos{
	
	HashMap<String, Fruta> hash = new HashMap<String, Fruta>();

	@Override
	public void guardar(Fruta fruta) {
		hash.put(fruta.getNombre(), fruta);
	}

	@Override
	public void editar(Fruta fruta) {
		hash.put(fruta.getNombre(), fruta);
	}

	@Override
	public void eliminar(Fruta fruta) {
		hash.remove(fruta.getNombre());
	}

	@Override
	public Fruta buscar(Fruta fruta) {
		fruta = hash.get(fruta.getNombre()); 
		return fruta;
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
	}
	
	//////////////////metodos especiales
	public void contar()
	{
		System.out.println("usted tiene:"+hash.size()+" frutas!!!");
	}

}
