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
import org.w3c.dom.Text;

public class seguridadXML {
    
    String nombreXML;
    Document documento;
    //Main Node
    Element raiz;

    public seguridadXML(String name){
        try {
            this.nombreXML=name;
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            documento = implementation.createDocument(null, name, null);
            documento.setXmlVersion("1.0");
            
            raiz = documento.getDocumentElement();
            
        } 
        catch (ParserConfigurationException ex) {
            Logger.getLogger(seguridadXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void cerrarXML() throws TransformerConfigurationException, TransformerException{
        //Generate XML
        Source source = new DOMSource(documento);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new java.io.File(nombreXML+".xml")); //nombre del archivo
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        
            
    }
    public void agregarJugador(String nombre,String contra){
    //creacion de lemento de jugador con la contrase�a
            
            Element jugador=documento.createElement(nombre);
            Element contrase�a=documento.createElement("Contrase�a");
            Text cont=documento.createTextNode(contra);
            contrase�a.appendChild(cont);
            jugador.appendChild(contrase�a);
            
            
            raiz.appendChild(jugador);
            
            
        try {
            this.cerrarXML();
        } catch (TransformerException ex) {
            Logger.getLogger(seguridadXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            String a=contrase�a.getTextContent();
            System.out.print("Este es el valor del nodo"+a);
    }
}