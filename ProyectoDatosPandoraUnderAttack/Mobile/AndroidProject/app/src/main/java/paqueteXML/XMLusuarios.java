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
	
	public XMLusuarios(String nombreXML) {
		super(nombreXML);
		//Obtenemos la referencia al documento que queremos modificar
		this.documento = super.documento;
		
		//Obtiene el elemento rañz del documento
		this.raiz = super.raiz; 
	}
	
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
			System.out.println("No se encontrña al usuario");
			return null;
		}
		else{
			System.out.println(contraseña);
			return contraseña;
		}
	}

}
