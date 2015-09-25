package paqueteObjetos;
/**
 * 
 * @author Kevin
 *
 */
public class Arma1 implements Armas{
	/**
	 * Atributos de la clase Arma1
	 */
	String nombre="Arma1";
	Recursos recurso1;
	int cantRecurso=3;
	/**
	 * Es el conjunto de metodos que van a ser realizados por esta clase
	 */
	public void operation() {
		System.out.println("se creo: " + nombre );
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

}
