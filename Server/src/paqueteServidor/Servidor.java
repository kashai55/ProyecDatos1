package paqueteServidor;

import paqueteConexiones.*;
import paqueteLista.Lista;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Servidor implements Runnable{
	
	Emisor emi;
	Receptor reci;
	Separador sep;
    
    public Servidor() {
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
        	Lista listaMensaje=sep.separar(mensaje);
        	if (listaMensaje.Sub(1).equals("todo bien?")){
        		System.out.println("omg eso fue un todo bien?");}
        		emi.enviarAcliente("pura vida", (String)listaMensaje.Sub(0));
        	if (listaMensaje.Sub(1).equals("hola")){
        		emi.enviarAcliente("holi", (String)listaMensaje.Sub(0));
        		
        	}
    	}
    }
        
}
