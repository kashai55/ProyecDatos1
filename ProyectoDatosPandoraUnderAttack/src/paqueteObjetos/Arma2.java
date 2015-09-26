package paqueteObjetos;
/**
 * 
 * @author Kevin
 *
 */
public class Arma2 implements Armas{
	/**
	 * Atributos de la clase Arma1
	 */
	String nombre="Arma2";

	/**
	 * Es el conjunto de metodos que van a ser realizados por esta clase
	 */
	public void operation() {
		System.out.println("se creo" + this.nombre );
		getName();
	}
	/**
	 * retorna el nombre de la clase
	 * @return el nombre del arma
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}
	/**
	 * Asigna las coordernadas donde se va a crear el arma
	 */
	@Override
	public void SetCoord(double x, double y) {
		// TODO Auto-generated method stub
		
	}

}
