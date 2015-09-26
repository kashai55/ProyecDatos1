package paquetePruebas;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import paqueteXML.*;

public class PruebasXml {

	public static void main(String[] args) throws TransformerConfigurationException, TransformerException {
		clanesXML x=new clanesXML("clanes"); 
		x.crearClan("perros", "fer", "4", "5");
		x.crearClan("prueba", "carlitos", "5", "10");
		x.a�adirJugador("perros", "maria", "5","15" );
		x.aumentarHierroJugador("perros", "maria", 150);
		x.aumentarMaderaJugador("perros", "fer", 200);
		x.aumentarPiedraJugador("perros", "fer", 300);
		x.aumentarHierroJugador("perros", "fer", 300);
		x.getArma1jugador("prueba", "carlitos");
		x.getBloqueo1jugador("prueba", "carlitos");
		x.getCoorYjugador("perros", "fer");
		x.getClanesJugador("perros", "maria");
		x.getCoorXjugador("perros", "maria");
		x.getHierroClan("perros");
		x.getMaderaClan("perros");
		x.getHierrojugador("perros", "maria");
		x.getMeritocraciajugador("perros", "fer");
		x.aumentarMaderaJugador("perros", "luis", 200);
		
		XMLusuarios a=new XMLusuarios("jugadores");
		a.a�adirUsuario("luis", "68473685");
		a.a�adirUsuario("carlos", "iygifuifu");
		a.getContrase�a("luis");
		a.getContrase�a("carlos");
		

	}

}
