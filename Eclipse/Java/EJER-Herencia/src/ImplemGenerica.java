import java.util.*;

public class ImplemGenerica implements Metodos{

	List<Object> list = new ArrayList<Object>(); //Polimorfismo
	
	@Override
	public void guardar(Object obj) {
		list.add(obj);
		System.out.println("Registro guardado");
	}

	@Override
	public void editar(Object obj, Object index) {
		list.set((int)index, obj); //Polimorfismo
		System.out.println("Registro editado");
		
	}

	@Override
	public void eliminar(Object index) {
		list.remove((int)index); //Polimorfismo
		System.out.println("Registro removido");
	}

	@Override
	public Object buscar(Object index) {
		
		return list.get((int)index); //Polimorfismo
		
	}

	@Override
	public void mostrar() {
		System.out.println(list);
	}

}
