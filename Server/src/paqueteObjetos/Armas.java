package paqueteObjetos;
/**
 * 
 * @author Kevin
 * De esta clase heredan las clases Arma1 y Arma2 sus metodos
 *
 */
public interface Armas {
	/**
	 * Hereda el metodo para retornar el nombre de las armas 
	 * @return el nombre del arma
	 */
	public String getName();
	/**
	 * Es el conjunto de metodos que van a ser realizados por los diferentes recursos
	 */
	public void operation();
}
