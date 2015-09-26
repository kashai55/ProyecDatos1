package paqueteServidor;

import java.io.*;
import java.net.*;
import paqueteXML.*;

/**
 * 
 * @author Ricardo
 *
 */
public class Servidor implements Runnable{
    ServerSocket socketServidor;
    
    XMLusuarios xmlSeguridad;
    clanesXML xmlClanes;
    
    /**
     * Constructor, este inicializa los xml's y el socketServidor
     */
    public Servidor(){
    	try {
    		xmlSeguridad= new XMLusuarios("Seguridad");
    		xmlClanes=new clanesXML("Clanes");
    		
			socketServidor = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    

	@Override
	/**
	 * metodo heredado de la clase Runnable por lo que es lo que se va a hacer en un hilo.
	 * Este metodo espera a que un cliente se conecte via socket, este socket es enviado a una 
	 * RamaServidor, cada RamaServidor se encarga de manejar los mensajes de cada cliente asociado
	 */
	public void run() {
		while (true) {
			try {
				Socket clienteSocket;
				clienteSocket = socketServidor.accept();
				System.out.println("Nueva conexión entrante: "+clienteSocket);
				(new RamaServidor(clienteSocket,this)).start();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
}