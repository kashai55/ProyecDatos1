package paqueteLista;
/**
 * 
 * @author Kevin
 *
 */
public class Nodo {
	/**
	 * Atributos de la clase nodo
	 */
	Object ele;
	Nodo sig;
	Nodo ant;
	int indice;
	/**
	 * Constructor de la clase recive un objeto y lo asigna a su elemento
	 * @param i objeto el cual va a ser adicionado como el elemento
	 */
	public Nodo(Object i){
		this.ele=i;
	}
}
