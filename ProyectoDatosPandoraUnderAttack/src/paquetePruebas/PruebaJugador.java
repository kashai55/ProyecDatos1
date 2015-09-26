package paquetePruebas;


import paqueteServidor.*;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import paqueteCliente.*;
import paqueteLista.*;
import paqueteObjetos.*;


public class PruebaJugador {

	public static void main(String[] args) throws TransformerConfigurationException, TransformerException {
		Jugador jugador1= new Jugador("juanito");
//SE CREA CLAN
		jugador1.getUserName();
		jugador1.listaClanes.Imprimir();
		jugador1.getLiderasgo();
		jugador1.crearClan("ClanPruebaParaElProfe");
		jugador1.getClanActual();
		jugador1.getLiderasgo();
		jugador1.listaClanes.Imprimir();
//SE CREAN RECURSOS PARA PROBAR CREAR ARMAS Y BLOQUEOS
		Madera m = new Madera();
		Hierro h = new Hierro();
		Piedra p = new Piedra();
		jugador1.getMadera();
		jugador1.getPiedra();
		jugador1.getHierro();
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(m);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(h);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.recolectar(p);
		jugador1.getMadera();
		jugador1.getPiedra();
		jugador1.getHierro();
		jugador1.listaArmas.Imprimir();
		jugador1.crearArmas("Arma1");
		jugador1.crearArmas("Arma2");
		jugador1.listaArmas.Imprimir();
		jugador1.listaBloqueos.Imprimir();
		jugador1.crearBloqueo("Bloqueo1");
		jugador1.crearBloqueo("Bloqueo2");
		jugador1.listaBloqueos.Imprimir();
//
	}

}
