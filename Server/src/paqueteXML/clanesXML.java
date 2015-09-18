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

public class clanesXML {

	 String clanXML;
	    Document documento1;
	    //Main Node
	    Element raiz1;

	    public clanesXML(){
	        try {
	            this.clanXML="Clanes";
	            
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            DOMImplementation implementation = builder.getDOMImplementation();
	            documento1 = implementation.createDocument(null, clanXML, null);
	            documento1.setXmlVersion("1.0");
	            
	            raiz1 = documento1.getDocumentElement();
	            
	        } 
	        catch (ParserConfigurationException ex) {
	            Logger.getLogger(seguridadXML.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
	    public void cerrarXML() throws TransformerConfigurationException, TransformerException{
	        //Generate XML
	        Source source = new DOMSource(documento1);
	        //Indicamos donde lo queremos almacenar
	        Result result = new StreamResult(new java.io.File(clanXML+".xml")); //nombre del archivo
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	        transformer.transform(source, result);
	        
	            
	    }
	    public void agregarClan(String nombreClan){
	    //creacion de lemento de jugador con la contraseña
	            
	            Element NuevoClan=documento1.createElement(nombreClan);
	            Element jugadores=documento1.createElement("Jugadores");
	            NuevoClan.appendChild(jugadores);
	            Element j=documento1.createElement("J1");
	            jugadores.appendChild(j);
	            
	            //nodo nombre
	            Element nombre=documento1.createElement("nombre");
	            Text cont=documento1.createTextNode("---------");
	            nombre.appendChild(cont);
	            j.appendChild(nombre);
	            
	            //nodo clanesJugador
	            Element clanesJugador=documento1.createElement("clanes");
	            Text cont1=documento1.createTextNode("clan1/clan2/clan3");
	            clanesJugador.appendChild(cont1);
	            j.appendChild(clanesJugador);
	          
	            //nodo recursos
	            Element recursos=documento1.createElement("recursos");
	            Text cont2=documento1.createTextNode("M0/P0/H0");
	            recursos.appendChild(cont2);
	            j.appendChild(recursos);
	            
	            //nodo armas
	            Element armas=documento1.createElement("armas");
	            Text cont3=documento1.createTextNode("A0/B0");
	            armas.appendChild(cont3);
	            j.appendChild(armas);
	            
	            //nodo bloqueos
	            Element bloqueos=documento1.createElement("bloqueos");
	            Text cont4=documento1.createTextNode("CA0/CB0");
	            bloqueos.appendChild(cont4);
	            j.appendChild(bloqueos);
	            
	            //nodo meritocracia
	            Element meritocracia =documento1.createElement("meritocracia");
	            Text cont5=documento1.createTextNode("0");
	            meritocracia.appendChild(cont5);
	            j.appendChild(meritocracia);
	            
	            //nodo coordenadas
	            Element coordenadas=documento1.createElement("coordenadas");
	            Text cont6=documento1.createTextNode("x/y");
	            coordenadas.appendChild(cont6);
	            j.appendChild(coordenadas);
	            
	            //nodo recursosClan
	            Element recursosClan=documento1.createElement("recursosClan");
	            Text cont7=documento1.createTextNode("M0/P0/H0");
	            recursosClan.appendChild(cont7);
	            NuevoClan.appendChild(recursosClan);
	            
	            //nodo reliquiasClan
	            Element reliquiasClan=documento1.createElement("reliquiasClan");
	            Text cont8=documento1.createTextNode("R1/R2/R3");
	            reliquiasClan.appendChild(cont8);
	            NuevoClan.appendChild(reliquiasClan);
	            
	            //nodo coordenadasClan
	            Element coordenadasClan=documento1.createElement("coordenadasClan");
	            Text cont9=documento1.createTextNode("x/y");
	            coordenadasClan.appendChild(cont9);
	            NuevoClan.appendChild(coordenadasClan);
	            
	            raiz1.appendChild(NuevoClan);
	            
	            try {
	            this.cerrarXML();
	        } catch (TransformerException ex) {
	            Logger.getLogger(clanesXML.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	            //String a=clan.getTextContent();
	            //System.out.print("Este es el valor del nodo"+a);
	    }
	
}
