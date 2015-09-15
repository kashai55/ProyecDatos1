package paqueteCliente;

import paqueteConexiones.Emisor;
import paqueteConexiones.Receptor;
import paqueteConexiones.Separador;
import paqueteLista.Lista;

public class Cliente implements Runnable {
	
	public Emisor emi;
	Receptor reci;
	public Separador sep;
    
    public Cliente() {
    	emi=new Emisor();
    	reci=new Receptor();
    	sep=new Separador();
//		Thread hilo=new Thread(this);
//		hilo.start();
    }

        @Override
	public void run() {
        	while (true){
	        	reci.esperarMensaje();
	        	String mensaje=reci.getMensaje();
	        	System.out.println("recibido desde el cliente: "+mensaje);
        	}
        }
        

}
