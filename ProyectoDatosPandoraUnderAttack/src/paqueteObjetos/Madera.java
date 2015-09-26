package paqueteObjetos;
/**
 * 
 * @author Kevin
 *
 */
public class Madera implements Recursos{
	/**
	 * atributos de la clase madera
	 */
	String nombre="Madera";
	int cantidad=1;
	double x;
	double y;
	/**
	 * Es el conjunto de metodos que van a ser realizados por esta clase
	 */
	public void operation() {
		getName();
		System.out.println("se creo: " +cantidad + "x " + nombre );
	}
	/**
	 * Obtiene el nombre del recurso
	 * @return retorna el nombre del recurso
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}
	/**
	 * Asigna las coordernadas donde se va a crear el recurso
	 */
	@Override
	public void SetCoord(double x, double y) {
		this.x=x;
		this.y=y;
		
	}

}
