package paqueteServidor;
import paqueteObjetos.*;
import paqueteLista.*;
import paqueteCliente.*;
/**
 * 
 * @author Kevin
 *
 */
public class Clan {
	/**
	 * Atributos
	 */
	protected String clanName;
	Reliquia reliquia;
	protected int madera=0;
	protected int hierro=0;
	protected int piedra=0;
	
	Lista listaReliquias = new Lista();
	Lista listaJugadores = new Lista();

	/**
	 * Constructor de la clase clan
	 * @param clanName Es el nombre que e usuario va a asignar al clan creado
	 * @param user es el usuario que creo el clan
	 */
	public Clan(String clanName, Jugador user){
		this.clanName=clanName;
		listaJugadores.nuevoObj(user);
		listaReliquias.nuevoObj(reliquia);
		
	}
	/**
	 * Obtiene el nombre de clan ingresado por el usario
	 * @return el nombre del clan
	 */
	public String getClanName(){
		return clanName;
	}
	/**
	 * Obtiene la cantidad de madera que posee el clan
	 * @return cantidad del recurso madera del clan
	 */
	public  int getClanMadera(){
		return this.madera;
	}
	/**
	 * Obtiene la cantidad de hierro que posee el clan
	 * @return cantidad del recurso hierro del clan
	 */
	public  int getClanHierro(){
		return this.hierro;
	}
	/**
	 * Obtiene la cantidad de piedra que posee el clan
	 * @return cantidad del recurso piedra del clan
	 */
	public  int getClanPiedra(){
		return this.piedra;
	}
	/**
	 * Permite asignar la cantidad de madera del clan cuando recoje un recurso o carga una partida
	 * @param cMaderra cantidad del recurso madera que se va a agregar
	 * @return la suma de la madera contenida mas la que va a ser adicionada
	 */
	public void setClanMadera(int cMadera){
		this.madera= this.madera+cMadera;
	}
	/**
	 * Permite asignar la cantidad de hierro del clan cuando recoje un recurso o carga una partida
	 * @param cHierro cantidad del recurso hierro que se va a agregar
	 * @return la suma de la hierro contenida mas la que va a ser adicionada
	 */
	public void setClanHierro(int cHierro){
		 this.hierro= this.hierro+cHierro;
	}
	/**
	 * Permite asignar la cantidad de piedra del clan cuando recoje un recurso o carga una partida
	 * @param cPiedra cantidad del recurso piedra que se va a agregar
	 * @return la suma de la piedra contenida mas la que va a ser adicionada
	 */
	public void setClanPiedra(int cPiedra){
		this.piedra= this.piedra+cPiedra;
	}
}
