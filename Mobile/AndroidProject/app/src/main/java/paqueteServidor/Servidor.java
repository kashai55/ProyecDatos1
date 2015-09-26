package paqueteServidor;

import java.io.*;
import java.net.*;
import paqueteXML.*;

public class Servidor implements Runnable{
    ServerSocket socketServidor;
    
    XMLusuarios xmlSeguridad;
    clanesXML xmlClanes;
    
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
	public void run() {
		while (true) {
			try {
				Socket clienteSocket;
				clienteSocket = socketServidor.accept();
				System.out.println("Nueva conexion entrante: "+clienteSocket);
				(new RamaServidor(clienteSocket,this)).start();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
}