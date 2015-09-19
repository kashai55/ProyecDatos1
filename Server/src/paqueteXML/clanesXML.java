package paqueteXML;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class clanesXML extends XML{
	Document documento;
	Element raiz;

	public clanesXML(String name) {
		super(name);
		//Obtenemos la referencia al documento que queremos modificar
		this.documento = super.documento;
				
		//Obtiene el elemento raíz del documento
		this.raiz = super.raiz; 
	}
	
	public void añadirClan(String nombreClan,String nombreCreador,String poscX,String poscY) throws TransformerConfigurationException, TransformerException{
		//Creamos el clan a añadir
		Element nuevoClan=documento.createElement(nombreClan);
			//creamos el nodo Jugadores que va a ser agregado al clan
		Element jugadores=documento.createElement("Jugadores");
		
				//añadimos el creador al nodo jugadores
		Element creador =documento.createElement(nombreCreador);
		jugadores.appendChild(creador);
		
					//le añadimos los objetos al creador, los cuales, como apenas está creando el clan, al principio son 0
		Element madera=documento.createElement("Madera");
		madera.appendChild(documento.createTextNode("0"));
		creador.appendChild(madera);
		
		Element piedra=documento.createElement("Piedra");
		piedra.appendChild(documento.createTextNode("0"));
		creador.appendChild(piedra);
		
		Element hierro=documento.createElement("Hierro");
		hierro.appendChild(documento.createTextNode("0"));
		creador.appendChild(hierro);
		
		Element arma1=documento.createElement("Arma1");
		arma1.appendChild(documento.createTextNode("0"));
		creador.appendChild(arma1);
		
		Element arma2=documento.createElement("Arma2");
		arma2.appendChild(documento.createTextNode("0"));
		creador.appendChild(arma2);
		
		Element bloqueo1=documento.createElement("Bloqueo1");
		bloqueo1.appendChild(documento.createTextNode("0"));
		creador.appendChild(bloqueo1);
		
		Element bloqueo2 =documento.createElement("Bloqueo2");
		bloqueo2.appendChild(documento.createTextNode("0"));
		creador.appendChild(bloqueo2);
		
		Element meritocracia=documento.createElement("Meritocracia");
		meritocracia.appendChild(documento.createTextNode("10"));
		creador.appendChild(meritocracia);
		
		Element x=documento.createElement("CoordenadaX");
		x.appendChild(documento.createTextNode(poscX));
		creador.appendChild(x);
		
		Element y =documento.createElement("CoordenadaY");
		y.appendChild(documento.createTextNode(poscY));
		creador.appendChild(y);
		
				//añadimos el nodo jugadores al clan
		nuevoClan.appendChild(jugadores);
		
		
				//añadimos los recursos del clan
		Element maderaClan=documento.createElement("MaderaClan");
		maderaClan.appendChild(documento.createTextNode("0"));
		nuevoClan.appendChild(maderaClan);
		
		Element piedraClan=documento.createElement("PiedraClan");
		piedraClan.appendChild(documento.createTextNode("0"));
		nuevoClan.appendChild(piedraClan);
		
		Element hierroClan=documento.createElement("HierroClan");
		hierroClan.appendChild(documento.createTextNode("0"));
		nuevoClan.appendChild(hierroClan);
				
				//añadimos el identificador de la reliquia
		Element reliquias=documento.createElement("Reliquias");
		reliquias.appendChild(documento.createTextNode("aqui iria el numero de clan"));
		nuevoClan.appendChild(reliquias);
		
		//Añadimos el clan creado a la raiz
		raiz.appendChild(nuevoClan);

		//"Cerramos" el xml
		cerrarXML();
	}

	public void añadirJugador(String nombreClan,String nombreJugador,String poscX, String poscY) throws TransformerConfigurationException, TransformerException{
		boolean clanEncontrado=false;
		Node temp=raiz.getFirstChild();
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				//una ves encontrado el clan al que se pide unir
				//encontramos el nodo que contiene a los jugadores del clan
				Node jugadoresClan=temp.getFirstChild();
				
				//creamos el elemento del nuevo jugador
				Element nuevoJugador=documento.createElement(nombreJugador);
				
					//creamos sus objetos, como es un nuevo jugador del clan todo comienza en 0
				
				Element madera=documento.createElement("Madera");
				madera.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(madera);
				
				Element piedra=documento.createElement("Piedra");
				piedra.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(piedra);
				
				Element hierro=documento.createElement("Hierro");
				hierro.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(hierro);
				
				Element arma1=documento.createElement("Arma1");
				arma1.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(arma1);
				
				Element arma2=documento.createElement("Arma2");
				arma2.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(arma2);
				
				Element bloqueo1=documento.createElement("Bloqueo1");
				bloqueo1.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(bloqueo1);
				
				Element bloqueo2 =documento.createElement("Bloqueo2");
				bloqueo2.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(bloqueo2);
				
				Element meritocracia=documento.createElement("Meritocracia");
				meritocracia.appendChild(documento.createTextNode("0"));
				nuevoJugador.appendChild(meritocracia);
				
				Element x=documento.createElement("CoordenadaX");
				x.appendChild(documento.createTextNode(poscX));
				nuevoJugador.appendChild(x);
				
				Element y =documento.createElement("CoordenadaY");
				y.appendChild(documento.createTextNode(poscY));
				nuevoJugador.appendChild(y);
				
				//añadimos el nuevo jugador al nodo de jugadores del clan
				jugadoresClan.appendChild(nuevoJugador);
				
				clanEncontrado=true;
				cerrarXML();
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		
		}
		if (clanEncontrado!=true){
			System.out.println("No se encontró el clan al cual se quiere ingresar");
		}
	}

	public int getMaderajugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int madera=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String m=temp2.getFirstChild().getTextContent();
						madera=Integer.parseInt(m);
						jugadorEncontrado=true;
						System.out.println("jugador encontrado");
						break;
					}
					else{
						temp2=temp2.getNextSibling();
					}
				}
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (jugadorEncontrado==false){
			System.out.println("Jugador no encontrado");
		}
		if (clanEncontrado==false){
			System.out.println("Clan no encontrado");
		}
		System.out.println(madera);
		return madera;
	}
	
	public int getPiedrajugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int piedra=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String p=temp2.getFirstChild().getNextSibling().getTextContent();
						piedra=Integer.parseInt(p);
						System.out.println("jugador encontrado");
						jugadorEncontrado=true;
						break;
					}
					else{
						temp2=temp2.getNextSibling();
					}
				}
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (jugadorEncontrado==false){
			System.out.println("Jugador no encontrado");
		}
		if (clanEncontrado==false){
			System.out.println("Clan no encontrado");
		}
		System.out.println(piedra);
		return piedra;
	}
	
	public int getHierrojugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int hierro=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String h=temp2.getFirstChild().getNextSibling().getNextSibling().getTextContent();
						hierro=Integer.parseInt(h);
						System.out.println("jugador encontrado");
						jugadorEncontrado=true;
						break;
					}
					else{
						temp2=temp2.getNextSibling();
					}
				}
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (jugadorEncontrado==false){
			System.out.println("Jugador no encontrado");
		}
		if (clanEncontrado==false){
			System.out.println("Clan no encontrado");
		}
		System.out.println(hierro);
		return hierro;
	}

	public void aumentarMaderaJugador(String nombreClan,String nombreJugador,int aumento) throws TransformerConfigurationException, TransformerException{
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						jugadorEncontrado=true;
						System.out.println("jugador " +nombreJugador+" encontrado");
						String m=temp2.getFirstChild().getNextSibling().getTextContent();
						int nm=Integer.parseInt(m);
						temp2.getFirstChild().setTextContent(Integer.toString(nm+aumento));
						cerrarXML();
						break;
					}
					else{
						temp2=temp2.getNextSibling();
					}
				}
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (jugadorEncontrado==false){
			System.out.println("Jugador no encontrado");
		}
		if (clanEncontrado==false){
			System.out.println("Clan no encontrado");
		}
		if (clanEncontrado & jugadorEncontrado){
			Node maderaClan=temp.getFirstChild().getNextSibling();
			String mClan=maderaClan.getTextContent();
			int nm=Integer.parseInt(mClan);
			maderaClan.setTextContent(Integer.toString(nm+aumento));
			cerrarXML();
		}
	}
}
