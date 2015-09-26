package paqueteObjetos;
/**
 * 
 * @author Kevin
 * De esta clase heredan las clases Arma1 y Arma2 sus metodos
 *
 */
public interface Armas {
	
	/**
	 * Asigna las cordenadas en las cuales el arma va a aparecer en el mapa
	 * @param x Representa la latitud en la cual se va a ubicar el arma
	 * @param y Represeta la longitud en la cual se va a ubicar el arma
	 */
	public abstract void SetCoord(double x,double y);
	
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
