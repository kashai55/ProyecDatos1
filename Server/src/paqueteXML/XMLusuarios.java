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
		
		//Obtiene el elemento ra�z del documento
		this.raiz = super.raiz; 
	}
	
	public void a�adirUsuario(String nombreNuevo, String contrase�aNueva) throws TransformerConfigurationException, TransformerException{
		//Creamos los elementos a a�adir
		Element jugador=documento.createElement(nombreNuevo);
		Element contrase�a=documento.createElement("Contrase�a");
		Text cont=documento.createTextNode(contrase�aNueva);
		//A�adimos los elementos creados
		contrase�a.appendChild(cont);
		jugador.appendChild(contrase�a);
		raiz.appendChild(jugador);
		//"Cerramos" el xml
		cerrarXML();
	}
	
	public String getContrase�a(String nombre){
		String contrase�a="";
		Node temp=raiz.getFirstChild();
		while (temp!=null){
			if (temp.getNodeName().equals(nombre)){
				contrase�a=temp.getFirstChild().getTextContent();
				break;
			}
			else{
				temp=temp.getNextSibling();
			}
		}
		if (contrase�a==""){
			System.out.println("No se encontr� al usuario");
			return null;
		}
		else{
			System.out.println(contrase�a);
			return contrase�a;
		}
	}

}
