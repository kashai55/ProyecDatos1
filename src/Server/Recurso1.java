package Server;

public class Recurso1 implements Recursos{
	String nombre= "RecursoEjemplo1";
	int cantidad=3;

	public void operation() {
		System.out.println("se creo: " +cantidad + "x " + nombre );
	}

}
