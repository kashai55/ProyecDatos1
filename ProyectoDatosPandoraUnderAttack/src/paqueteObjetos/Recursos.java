package paqueteObjetos;
/**
 * 
 * @author Kevin
 * De esta clase heredan las clases Madera,Hierr y Piedra sus metodos
 *
 */
public abstract interface Recursos {
	/**
	 * Asigna las cordenadas en las cuales el recurso va a aparecer en el mapa
	 * @param x Representa la latitud en la cual se va a ubicar el recurso
	 * @param y Represeta la longitud en la cual se va a ubicar el recurso
	 */
	public abstract void SetCoord(double x,double y);
	/**
	 * Hereda el metodo para retornar el nombre del recurso 
	 * @return el nombre del recurso
	 */
	public abstract String getName();
	/**
	 * Es el conjunto de metodos que van a ser realizados por los diferentes recursos
	 */
	public void operation();
}
