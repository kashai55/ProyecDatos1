package paqueteObjetos;

public class Recurso1 implements Recursos{
	String nombre= "RecursoEjemplo1";
	int cantidad=3;
	

	public void operation() {
		getName();
		System.out.println("se creo: " +cantidad + "x " + nombre );
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
