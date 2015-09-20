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
		Jugador j = new Jugador(newUsername,newPassword);
		mundo.ListaJugadores.nuevoObj(j);
		System.out.println("se agrego a " + j.getUserName() + "a la lista de jugadores");
		mundo.ListaJugadores.notifyAll();
		System.out.println(j.getUserName() + " se ha unido al mundo");
	}

	public void login(String Username,String Password){
		if (Password == xmlS.getContraseña(Username)){
			Jugador j = new Jugador(Username,Password);
			j.setMadera(xmlC.getMaderajugador(j.getClanActual().getClanName(), j.getUserName()));
//			j.Hierro(xmlC.getHierrojugador(j.getClanActual().getClanName(), j.getUserName()));
//			j.Piedra(xmlC.getPiedrajugador((j.getClanActual().getClanName(), j.getUserName()));
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