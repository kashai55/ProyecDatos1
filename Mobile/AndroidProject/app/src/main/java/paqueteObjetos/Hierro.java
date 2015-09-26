package paqueteObjetos;

public class Hierro implements Recursos{
	String nombre= "Hierro";
	int cantidad=1;

	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}

	@Override
	public String getName() {
		return nombre;
	}

	@Override
	public void SetCoord(float x, float y) {
		// TODO Auto-generated method stub
		
	}
}

