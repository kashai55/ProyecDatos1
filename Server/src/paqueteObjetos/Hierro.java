package paqueteObjetos;
/**
 * 
 * @author Kevin
 *
 */
public class Hierro implements Recursos{
	/**
	 * atributos de la clase hierro
	 */
	String nombre= "Hierro";
	int cantidad=1;
	/**
	 * Es el conjunto de metodos que van a ser realizados por esta clase
	 */
	public void operation() {
		System.out.println("se obtuvo" + nombre );
	}
	/**
	 * Obtiene el nombre del recurso
	 * @return nombre del recurso
	 */
	@Override
	public String getName() {
		return nombre;
	}
	/**
	 * Asigna las coordernadas donde se va a crear el recurso
	 */
	@Override
	public void SetCoord(double x, double y) {
		// TODO Auto-generated method stub
		
	}
}

