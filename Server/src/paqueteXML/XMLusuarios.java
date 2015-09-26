package paqueteXML;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class XMLusuarios extends XML {
	
	Document documento;
	Element raiz;
	
	/**
	 * esta funcion se encarga de crear un XML que almacena
	 * la contraseña y el nombre del cada jugador
	 * @param name
	 */
	
	public XMLusuarios(String nombreXML) {
		super(nombreXML);
		//Obtenemos la referencia al documento que queremos modificar
		this.documento = super.documento;
		
		//Obtiene el elemento raíz del documento
		this.raiz = super.raiz; 
	}
	
	/**
	 * funcion que crea y mete en el XML los usuarios del juego
	 * @param nombreNuevo
	 * @param contraseñaNueva
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	
	public void añadirUsuario(String nombreNuevo, String contraseñaNueva) throws TransformerConfigurationException, TransformerException{
		//Creamos los elementos a añadir
		Element jugador=documento.createElement(nombreNuevo);
		Element contraseña=documento.createElement("Contraseña");
		Text cont=documento.createTextNode(contraseñaNueva);
		//Añadimos los elementos creados
		contraseña.appendChild(cont);
		jugador.appendChild(contraseña);
		raiz.appendChild(jugador);
		//"Cerramos" el xml
		cerrarXML();
	}
	
	/**
	 * esta funcion retorna en string la contraseña del jugador que se necesita
	 * @param nombre
	 * @return la contraseña del jugador que se necesita
	 */
	
	public String getContraseña(String nombre){
		String contraseña="";
		Node temp=raiz.getFirstChild();
		while (temp!=null){
			if (temp.getNodeName().equals(nombre)){
				contraseña=temp.getFirstChild().getTextContent();
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (contraseña==""){
			System.out.println("No se encontró al usuario");
			return null;
		}
		else{
			System.out.println(contraseña);
			return contraseña;
		}
	}

}
