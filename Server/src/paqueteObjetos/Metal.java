package paqueteObjetos;

public class Metal implements Recursos{
	String nombre= "Metal";
	int cantidad=1;

	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}

	@Override
	public String getName() {
		return nombre;
	}
}

