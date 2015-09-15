package paqueteObjetos;

public class Piedra implements Recursos{
	String nombre= "Piedra";
	int cantidad=2;

	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
