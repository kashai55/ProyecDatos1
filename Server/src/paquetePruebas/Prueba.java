package paquetePruebas;

import paqueteServidor.*;
import paqueteCliente.*;
import paqueteConexiones.*;
import paqueteLista.*;
import paqueteObjetos.*;

public class Prueba {
	public static void main(String[] args) throws InterruptedException {
		Cliente chinoesgay = new Cliente();
		Thread hilo = new Thread(chinoesgay);
		hilo.start();
		chinoesgay.emi.enviarAservidor("hola");
	}
	
}
