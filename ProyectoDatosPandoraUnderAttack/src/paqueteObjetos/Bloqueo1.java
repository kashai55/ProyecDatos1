package paqueteObjetos;
/**
 * 
 * @author Kevin
 *
 */
public class Bloqueo1 implements Bloqueos {
	/**
	 * Atributos de la clase Bloqueo1
	 */
	String nombre="Bloqueo1";
	Arma1 arma;
	/**
	 * Es el conjunto de metodos que van a ser realizados por esta clase
	 */
	public void operation() {
		System.out.println("se creo: " + nombre );
	}
	/**
	 * Obtiene el nombre del bloqueo
	 * @return El nombre del bloqueo
	 */
	@Override
	public String getName() {
		return nombre;
	}


}
