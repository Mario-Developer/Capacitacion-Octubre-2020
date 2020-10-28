import java.util.ArrayList;
import java.util.List;

public class Implementacion implements Metodos{
	
	List<Cartera> lista = new ArrayList<Cartera>();

	@Override
	public void guardar(Cartera cartera) {
		lista.add(cartera);
		System.out.println("se guardo la cartera!!!");
	}

	@Override
	public void editar(int index, Cartera cartera) {
		lista.set(index, cartera);
		System.out.println("la cartera se edito");
	}

	@Override
	public void eliminr(int index) {
		lista.remove(index);
		System.out.println("la cartera se elimino!!!");
	}

	@Override
	public Cartera buscar(int index) {
		// TODO Auto-generated method stub
		return lista.get(index);
	}

	@Override
	public void mostrar() {
		System.out.println(lista);
	}
	
	////////////////////////////metodos adicionales
	
	public void contar()
	{
		System.out.println("usted tiene "+ lista.size() + " carteras!!!");
	}
	
	public void vacia()
	{
		if(lista.isEmpty())
		{
			System.out.println("la lista esta VACIA!!!");
		}
		else
		{
			System.out.println("la lista tiene ELEMENTOS!!!");
		}
	}
	
	public Cartera buscarModelo(Cartera cartera)
	{
		Cartera car = null;
		for(Cartera c : lista)
		{
			if(c.getModelo().equals(cartera.getModelo())) 
			{
				car = c;
				System.out.println("la cartera encontrada es:"+c);
			}
		}
		return car;
	}

}
