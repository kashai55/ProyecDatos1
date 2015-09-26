package paqueteXML;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
*
* @author Fernanda
*/

public class clanesXML extends XML{
	Document documento;
	Element raiz;

/**
 * esta funcion se encarga de crear un XML que almacena
 * el creador del clan y los jugadores del mismo
 * @param name
 */
	
	public clanesXML(String name) {
		super(name);
		//Obtenemos la referencia al documento que queremos modificar
		this.documento = super.documento;
				
		//Obtiene el elemento raíz del documento
		this.raiz = super.raiz; 
	}
	/**
	 * funcion que crea y mete en el XML los clanes y los jugadores del mismo
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreCreador: string con el  nombre del creador del clan
	 * @param poscX: string con la coordenada x del clan
	 * @param poscY: string con la coordenada y del clan
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	public void crearClan(String nombreClan,String nombreCreador,String poscX,String poscY) throws TransformerConfigurationException, TransformerException{
        boolean clanIgual=false;
        Node temp=raiz.getFirstChild();
        while(temp!=null){
            if (temp.getNodeName().equals(nombreClan)){
                clanIgual=true;
                System.out.print("ya existe ese nombre de clan");
                break;
            }
            else{
                temp=temp.getNextSibling();
		}
         if (clanIgual==false){
            //Creamos el clan a a�adir
	Element nuevoClan=documento.createElement(nombreClan);
		//creamos el nodo Jugadores que va a ser agregado al clan
	Element jugadores=documento.createElement("Jugadores");
	
			//a�adimos el creador al nodo jugadores
	Element creador =documento.createElement(nombreCreador);
	jugadores.appendChild(creador);
	
				//le a�adimos los objetos al creador, los cuales, como apenas est� creando el clan, al principio son 0
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
	
			//a�adimos el nodo jugadores al clan
	nuevoClan.appendChild(jugadores);
	
	
			//a�adimos los recursos del clan
	Element maderaClan=documento.createElement("MaderaClan");
	maderaClan.appendChild(documento.createTextNode("0"));
	nuevoClan.appendChild(maderaClan);
	
	Element piedraClan=documento.createElement("PiedraClan");
	piedraClan.appendChild(documento.createTextNode("0"));
	nuevoClan.appendChild(piedraClan);
	
	Element hierroClan=documento.createElement("HierroClan");
	hierroClan.appendChild(documento.createTextNode("0"));
	nuevoClan.appendChild(hierroClan);
			
			//a�adimos el identificador de la reliquia
	Element reliquias=documento.createElement("Reliquias");
	reliquias.appendChild(documento.createTextNode("aqui iria el numero de clan"));
	nuevoClan.appendChild(reliquias);
	
	//A�adimos el clan creado a la raiz
	raiz.appendChild(nuevoClan);

	//"Cerramos" el xml
	cerrarXML();
        }
        System.out.print("clan creado");
    }
        
}

	
	/**
	 * añade un jugador a un clan ya existente
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @param poscX: string con la coordenada x del jugador
	 * @param poscY: string con la coordenada y del jugador
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */

	public void a�adirJugador(String nombreClan,String nombreJugador,String poscX, String poscY) throws TransformerConfigurationException, TransformerException{
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
				
				Element clanesJugador=documento.createElement("Clanes");
				clanesJugador.appendChild(documento.createTextNode("C1/C2/C3"));
				nuevoJugador.appendChild(clanesJugador);
				
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

/**
 * 	funcion que devuelve un string con la cantidad de madera de cada jugador
 * @param nombreClan: string con el nombre del clan
 * @param nombreJugador: string con el nombre del jugador
 * @return la cantidad de madera de cada jugador
 */

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
	
	/**
	 * funcion que devuelve un string con la cantidad de piedra de cada jugador
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return la cantidad de piedra de cada jugador
	 */
	
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
	
	/**
	 * funcion que devuelve un string con la cantidad de hierro de cada jugador
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return la cantidad de hierro de cada jugador
	 */
	
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
	
	/**
	 * funcion que aumenta al jugador y al clan la cantidad de madera que es recogida por
	 * cada jugador para la realizacion de armas y bloqueos
	 *@param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @param int con la cantidad que se va aumentar en el recurso
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */

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
	
	/**
	 * funcion que aumenta al jugador y al clan la cantidad de piedra que es recogida por
	 * cada jugador para la realizacion de armas y bloqueos
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @param aumento: int con el aumento que se le va hacer al recurso
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	
	public void aumentarPiedraJugador(String nombreClan,String nombreJugador,int aumento) throws TransformerConfigurationException, TransformerException{
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
						String p=temp2.getFirstChild().getNextSibling().getTextContent();
						int np=Integer.parseInt(p);
						temp2.getFirstChild().getNextSibling().setTextContent(Integer.toString(np+aumento));
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
			Node piedraClan=temp.getFirstChild().getNextSibling().getNextSibling();
			String pClan=piedraClan.getTextContent();
			int np=Integer.parseInt(pClan);
			piedraClan.setTextContent(Integer.toString(np+aumento));
			cerrarXML();
		}
	}
	
	/**
	 * funcion que aumenta al jugador y al clan la cantidad de hierro que es recogida por
	 * cada jugador para la realizacion de armas y bloqueos
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @param aumento: int con el aumento del recurso
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */

	public void aumentarHierroJugador(String nombreClan,String nombreJugador,int aumento) throws TransformerConfigurationException, TransformerException{
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
						String h=temp2.getFirstChild().getNextSibling().getTextContent();
						int nh=Integer.parseInt(h);
						temp2.getFirstChild().getNextSibling().getNextSibling().setTextContent(Integer.toString(nh+aumento));
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
			Node hierroClan=temp.getFirstChild().getNextSibling().getNextSibling().getNextSibling();
			String hClan=hierroClan.getTextContent();
			int nh=Integer.parseInt(hClan);
			hierroClan.setTextContent(Integer.toString(nh+aumento));
			cerrarXML();
		}
	}
	
	/**
	 * funcion que retorna la cantiadad de madera que tiene el clan solicitado
	 * @param nombreClan: string con el nombre del clan
	 * @return string con la cantidad de madera
	 */
	
	public int getMaderaClan(String nombreClan){
		boolean clanEncontrado=false;
		Node temp=raiz.getFirstChild();
		int madera=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				String m=temp.getFirstChild().getNextSibling().getTextContent();
				madera=Integer.parseInt(m);
				clanEncontrado=true;
				System.out.print("clan encontrado");
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (clanEncontrado==false){
			System.out.println("Clan no encontrado");
		}
		System.out.println(madera);
		return madera;
	}
	
	/**
	 * funcion que retorna la cantiadad de piedra que tiene el clan solicitado
	 * @param nombreClan: string con el nombre del clan
	 * @return string con la cantidad de piedra
	 */
	
	public int getPiedraClan(String nombreClan){
		boolean clanEncontrado=false;
		Node temp=raiz.getFirstChild();
		int piedra=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				String p=temp.getFirstChild().getNextSibling().getNextSibling().getTextContent();
				piedra=Integer.parseInt(p);
				clanEncontrado=true;
				System.out.print("clan encontrado");
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (clanEncontrado==false){
			System.out.println("Clan no encontrado");
		}
		System.out.println(piedra);
		return piedra;
	}
	
	/**
	 * funcion que retorna la cantiadad de hierro que tiene el clan solicitado
	 * @param nombreClan: string con el nombre del clan
	 * @return string con la cantidad de hierro
	 */
	
	public int getHierroClan(String nombreClan){
		boolean clanEncontrado=false;
		Node temp=raiz.getFirstChild();
		int hierro=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				String h=temp.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getTextContent();
				hierro=Integer.parseInt(h);
				clanEncontrado=true;
				System.out.print("clan encontrado");
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (clanEncontrado==false){
			System.out.println("Clan no encontrado");
		}
		System.out.println(hierro);
		return hierro;
	}
	
	/**
	 * funcion que retorna el que caso que se tenga el arma1 del jugador
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string cpon el nombre del jugador
	 * @return string de arma1
	 */
	
	public int getArma1jugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int arma1=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String a1=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getTextContent();
						arma1=Integer.parseInt(a1);
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
		System.out.println(arma1);
		return arma1;
	}
	
	/**
	 * funcion que retorna el que caso que se tenga el arma2 del jugador
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return string de arma2
	 */
	
	public int getArma2jugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int arma2=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String a2=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getTextContent();
						arma2=Integer.parseInt(a2);
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
		System.out.println(arma2);
		return arma2;
	}
	
	/**
	 * funcion que retorna el que caso que se tenga el bloqueo1 del jugador
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return string de bloqueo1
	 */
	
	public int getBloqueo1jugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int bloqueo1=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String b1=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling

().getTextContent();
						bloqueo1=Integer.parseInt(b1);
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
		System.out.println(bloqueo1);
		return bloqueo1;
	}
	
	/**
	 * funcion que retorna el que caso que se tenga el bloqueo2 del jugador
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return string de bloqueo2
	 */
	
	public int getBloqueo2jugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int bloqueo2=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String b2=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling

().getNextSibling().getTextContent();
						bloqueo2=Integer.parseInt(b2);
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
		System.out.println(bloqueo2);
		return bloqueo2;
	}
	
	/**
	 * funcion que se encarga de retornar el nivel del jugador solicitado
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return el nivel del jugador en el clan
	 */
	
	public int getMeritocraciajugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int meritocracia=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String me=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling

().getNextSibling().getNextSibling().getTextContent();
						meritocracia=Integer.parseInt(me);
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
		System.out.println(meritocracia);
		return meritocracia;
	}
	
	/**
	 * funcion que retorna la ubicacion en la coordenada x
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return la coordenada x de la posocion del jugador
	 */
	
	public int getCoorXjugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int cx=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String x=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling

().getNextSibling().getNextSibling().getNextSibling().getTextContent();
						cx=Integer.parseInt(x);
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
		System.out.println(cx);
		return cx;
	}
	
	/**
	 * funcion que retorna la ubicacion en la coordenada y
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el  nombre del jugador
	 * @return la coordenada y de la posocion del jugador
	 */
	
	public int getCoorYjugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		int cy=0;
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						String y=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling

().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getTextContent();
						cy=Integer.parseInt(y);
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
		System.out.println(cy);
		return cy;
	}
	
	/**
	 * esta funcion retorna todos los clanes al los que pertenece el jugador
	 * @param nombreClan: string con el nombre del clan
	 * @param nombreJugador: string con el nombre del jugador
	 * @return todos los clanes del jugador
	 */
	
	public String getClanesJugador(String nombreClan,String nombreJugador){
		boolean clanEncontrado=false;
		boolean jugadorEncontrado=false;
		Node temp=raiz.getFirstChild();
		String clanesJugador="";
		while (temp!=null){
			if (temp.getNodeName().equals(nombreClan)){
				clanEncontrado=true;
				Node temp2= temp.getFirstChild().getFirstChild();
				while(temp2!=null){
					if (temp2.getNodeName().equals(nombreJugador)){
						clanesJugador=temp2.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling

().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getTextContent();
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
		System.out.println(clanesJugador);
		return clanesJugador;
	}
}
