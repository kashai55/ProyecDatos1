package paqueteObjetos;

public class Arma1 implements Armas{
	String nombre="ArmaEjemplo1";
	Recursos recurso1;
	int cantRecurso=3;
	
	public void operation() {
		System.out.println("se creo: " + nombre );
	}

}
