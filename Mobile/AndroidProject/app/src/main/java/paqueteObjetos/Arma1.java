package paqueteObjetos;

public class Arma1 implements Armas{
	String nombre="Arma1";
	Recursos recurso1;
	int cantRecurso=3;
	
	public void operation() {
		System.out.println("se creo: " + nombre );
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
