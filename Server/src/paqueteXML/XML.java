package paqueteXML;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XML {
	
	public void XML() {
        // TODO code application logic here
        String nombre_archivo = "jugadores";
        ArrayList key = new ArrayList();
        ArrayList value = new ArrayList();
 
        try {
            generate(nombre_archivo, key, value);
        } catch (Exception e) {}
    }
 
    public static void generate(String name, ArrayList<String> key,ArrayList<String> value) throws Exception{
 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
 
            //Main Node
            Element raiz = document.getDocumentElement();
            
            //creacion de lemento de jugador con la contraseña
            Element jugador=document.createElement("jugador");
            Element contraseña=document.createElement("contraseña");
            Text cont=document.createTextNode("nada");
            contraseña.appendChild(cont);
            jugador.appendChild(contraseña);
            raiz.appendChild(jugador);
            
            //nodo recursos
            Element recursos=document.createElement("recursos");
            Text cont1=document.createTextNode("cantidad");
            recursos.appendChild(cont1);
            jugador.appendChild(recursos);
            raiz.appendChild(jugador);
            
            //nodo clan
            Element clanes=document.createElement("clan");
            Text cont2=document.createTextNode("clanes");
            clanes.appendChild(cont2);
            jugador.appendChild(clanes);
            raiz.appendChild(jugador);
           
             //nodo bloqueos
            Element bloqueos=document.createElement("bloqueos");
            Text cont3=document.createTextNode("bloqueos");
            clanes.appendChild(cont3);
            jugador.appendChild(bloqueos);
            raiz.appendChild(jugador);
            
             //nodo armas
            Element armas=document.createElement("armas");
            Text cont4=document.createTextNode("armas");
            clanes.appendChild(cont4);
            jugador.appendChild(armas);
            raiz.appendChild(jugador);
            
             //nodo coordenadas
            Element coordenadas=document.createElement("coordenadas");
            Text cont5=document.createTextNode("coordenadas");
            clanes.appendChild(cont5);
            jugador.appendChild(coordenadas);
            raiz.appendChild(jugador);
            
            String a=contraseña.getTextContent();
            System.out.print("Este es el valor del nodo"+a);
            
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(name+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        
    }

}
