package paqueteObjetos;
/**
 * 
 * @author Kevin
 *
 */
public class Piedra implements Recursos{
	/**
	 * atributos de la clase piedra
	 */
	String nombre= "Piedra";
	float x;
	float y;
	/**
	 * Es el conjunto de metodos que van a ser realizados por esta clase
	 */
	public void operation() {
		System.out.println("se obtuvo" + nombre );
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
		
		// TODO Auto-generated method stub
		
	}

}
