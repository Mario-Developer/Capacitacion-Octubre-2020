import java.util.HashMap;

public class Implementacion implements Metodos{
	
	HashMap<String, Peluche> hash = new HashMap<String, Peluche>();
	Peluche peluche = null;
	
	@Override
	public void guardar(Object obj) {
		peluche = (Peluche) obj;
		hash.put(peluche.getModelo(), peluche);
	}

	@Override
	public void editar(Object obj) {
		peluche = (Peluche) obj;
		hash.put(peluche.getModelo(), peluche);
	}

	@Override
	public void eliminar(Object obj) {
		peluche = (Peluche) obj;
		hash.remove(peluche.getModelo());
	}

	@Override
	public Object buscar(Object obj) {
		peluche = (Peluche) obj;
		peluche = hash.get(peluche.getModelo());
		return peluche;
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
	}

}
