package paqueteServidor;

import paqueteCliente.Jugador;
import paqueteXML.*;
/**
 * 
 * @author Kevin
 *
 */
public class GameLogin {
	/**
	 * Atributos de la clase
	 */
	Jugador jug;
	XMLusuarios xmlS;
	clanesXML xmlC;
	Mundo mundo;
	public GameLogin(clanesXML xml){
		this.xmlC=xml;
	}
	/**
	 * retorna una nueva instacia de jugardor con sus items de una partida anterior
	 * @param Username es el string con el ombre de usuario el jugador
	 * @param Password es la contraseña del jugador
	 * @return un jugador con sus items cargados
	 */
	public Jugador login(String Username,String Password){
		Jugador j = new Jugador(Username);
		j.setMadera(xmlC.getMaderajugador(j.getClanActual().getClanName(), j.getUserName()));
		j.setHierro(xmlC.getHierrojugador(j.getClanActual().getClanName(), j.getUserName()));
		j.setPiedra(xmlC.getPiedrajugador(j.getClanActual().getClanName(), j.getUserName()));
		j.setArma1(xmlC.getArma1jugador(j.getClanActual().getClanName(), j.getUserName()));
		j.setArma2(xmlC.getArma2jugador(j.getClanActual().getClanName(), j.getUserName()));
		j.setBloqueo1(xmlC.getBloqueo1jugador(j.getClanActual().getClanName(), j.getUserName()));
		j.setBloqueo2(xmlC.getBloqueo2jugador(j.getClanActual().getClanName(), j.getUserName()));
		mundo.ListaJugadores.nuevoObj(j);
		System.out.println("se agrego a " + j.getUserName() + "a la lista de jugadores");
		mundo.ListaJugadores.notifyAll();
		System.out.println(j.getUserName() + " se ha unido al mundo");
		return j;
	}

}