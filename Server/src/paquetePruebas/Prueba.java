package paquetePruebas;

import paqueteServidor.*;
import paqueteCliente.*;
import paqueteConexiones.*;
import paqueteLista.*;
import paqueteObjetos.*;

public class Prueba {
	public static void main(String[] args) throws InterruptedException {
		Servidor ser=new Servidor();
		Emisor em=new Emisor();
		Thread hilo=new Thread(ser);
		hilo.start();
		em.enviarAservidor("hola");
		em.enviarAservidor("todo bien?");
		
	}
	
}
