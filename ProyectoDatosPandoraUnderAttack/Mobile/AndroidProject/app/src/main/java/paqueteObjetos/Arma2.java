package paqueteObjetos;

public class Arma2 implements Armas{
	String nombre="Arma2";
	Recursos recurso2;
	Recursos recurso1;
	int cantRecurso=3;
	
	public void operation() {
		System.out.println("se creo" + nombre );
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
