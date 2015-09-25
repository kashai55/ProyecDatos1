package paqueteObjetos;
/**
 * 
 * @author Kevin
 * De esta clase heredan las clases Bloqueo1 y Bloqueo2 sus metodos
 *
 */
public interface Bloqueos {
	/**
	 * Hereda el metodo para retornar el nombre de los bloqueos
	 * @return el nombre del bloqueo
	 */
	public String getName();
	/**
	 * Es el conjunto de metodos que van a ser realizados por los diferentes bloqueos
	 */
	public void operation();
}
