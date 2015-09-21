package paqueteServidor;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import paqueteCliente.Jugador;
import paqueteXML.*;
import paqueteLista.*;

public class GameLogin {
	Nodo n;
	Jugador jug;
	XMLusuarios xmlS;
	clanesXML xmlC;
	Mundo mundo;
	public void signup(String newUsername,String newPassword) throws TransformerConfigurationException, TransformerException{
		xmlS.añadirUsuario(newUsername, newPassword);
		Jugador j = new Jugador(newUsername);
		mundo.ListaJugadores.nuevoObj(j);
		System.out.println("se agrego a " + j.getUserName() + "a la lista de jugadores");
		mundo.ListaJugadores.notifyAll();
		System.out.println(j.getUserName() + " se ha unido al mundo");
	}

	public void login(String Username,String Password){
		if (Password == xmlS.getContraseña(Username)){
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
		}
		else{
			System.out.println("Error nombre de usuario o contraseña incorrectos. Por favor vuelva a intentarlo");
			
		}
		
		
	}

}