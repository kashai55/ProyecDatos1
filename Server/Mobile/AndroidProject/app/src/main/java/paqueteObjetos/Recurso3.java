package paqueteObjetos;

public class Recurso3 implements Recursos{
	String nombre= "RecursoEjemplo3";
	int cantidad=1;

	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}

	@Override
	public String getName() {
		return nombre;
	}
}
