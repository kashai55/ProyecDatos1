package Server;

public class Recurso2 implements Recursos{
	String nombre= "RecursoEjemplo2";
	int cantidad=2;

	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}

}
