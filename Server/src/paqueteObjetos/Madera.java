package paqueteObjetos;

public class Madera implements Recursos{
	String nombre="Madera";
	int cantidad=3;
	

	public void operation() {
		getName();
		System.out.println("se creo: " +cantidad + "x " + nombre );
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
