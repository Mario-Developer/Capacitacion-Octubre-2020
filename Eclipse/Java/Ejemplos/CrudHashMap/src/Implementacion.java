import java.util.HashMap;

public class Implementacion implements Metodos{
	
	HashMap<Integer, Pintufos> map = new HashMap<Integer, Pintufos>();

	@Override
	public void guardar(Pintufos pitufo) {
		map.put(pitufo.getClave(), pitufo);
	}

	@Override
	public void editar(Pintufos pitufo) {
		map.put(pitufo.getClave(), pitufo);
	}

	@Override
	public void eliminar(Pintufos pitufo) {
		map.remove(pitufo.getClave());
	}

	@Override
	public Pintufos buscar(Pintufos pitufo) {
		// TODO Auto-generated method stub
		return map.get(pitufo.getClave());
	}

	@Override
	public void mostrar() {
		System.out.println(map);
	}

}
