package paqueteObjetos;

public class Piedra implements Recursos{
	String nombre= "Piedra";
	float x;
	float y;

	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public void SetCoord(float x, float y) {
		
		// TODO Auto-generated method stub
		
	}

}
