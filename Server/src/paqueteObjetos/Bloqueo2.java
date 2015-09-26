package paqueteObjetos;
/**
 * 
 * @author Kevin
 *
 */
public class Bloqueo2 implements Bloqueos{
	/**
	 * Atributos de la clase Bloqueo2
	 */
	String nombre="Bloqueo2";
	Arma2 arma;
	/**
	 * Obtiene el nombre del bloqueo
	 * @return El nombre del bloqueo
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}
	/**
	 * Es el conjunto de metodos que van a ser realizados por esta clase
	 */
	@Override
	public void operation() {
		System.out.println("se creo: " + nombre );
		// TODO Auto-generated method stub
		
	}

}
