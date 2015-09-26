package paqueteObjetos;

public class Recurso2 implements Recursos{
	String nombre= "RecursoEjemplo2";
	int cantidad=2;

	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}

	@Override
	public void SetCoord(float x, float y) {

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
