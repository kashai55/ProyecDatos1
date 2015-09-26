package paqueteObjetos;

public class Madera implements Recursos{
	String nombre="Madera";
	int cantidad=1;
	float x;
	float y;

	public void operation() {
		getName();
		System.out.println("se creo: " +cantidad + "x " + nombre );
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}


	@Override
	public void SetCoord(float x, float y) {
		this.x=x;
		this.y=y;
		
	}

}
