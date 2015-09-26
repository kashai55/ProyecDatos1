package paqueteServidor;
import java.io.*;
import java.net.*;

import javax.xml.transform.TransformerException;

import paqueteLista.*;
import paqueteCliente.*;

public class RamaServidor extends Thread {
    private Socket socketCliente;
    private DataOutputStream salida;
    private BufferedReader entrada;
    private Servidor superservidor;
    public String mensaje;
    
    Jugador jugador;
    
    public RamaServidor(Socket socket,Servidor superservidor) throws IOException {
        this.superservidor=superservidor;
		this.socketCliente = socket;
        salida = new DataOutputStream(socketCliente.getOutputStream());
        entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
    }
    
    public void desconectar() {
        try {
        	System.out.println("Cliente:  "+socketCliente+"  desconectado");
        	entrada.close();
			salida.close();
			socketCliente.close();
        } catch (IOException ex) {
            System.out.println("Errror al desconectar el cliente "+socketCliente);
        }
    }
    
    public void enviarAcliente(String mensaje){
    	try {
			salida.writeUTF(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @Override
    public void run() {
    	while(true){
	    try {
	    	
	    	String mensajeEntrada=entrada.readLine();
	    	mensaje=mensajeEntrada.substring(2, mensajeEntrada.length());
	    	Lista mensajeSeparado= new Separador().separar(mensaje);
	    	System.out.println("El mensaje recibido en el servidor es: "+mensaje);
	    	
	    	if ((mensajeSeparado.Sub(0)).toString().equals("SI")){              //sign in
	    			String nombre=mensajeSeparado.Sub(1).toString();
	    			String password=mensajeSeparado.Sub(2).toString();
	    			superservidor.xmlSeguridad.añadirUsuario(nombre, password);
	    			jugador=new Jugador(nombre);
	    			salida.writeUTF("BN/bienvenido srRodriguez");
				
	    	}
	    	
	    	else if ((mensajeSeparado.Sub(0)).toString().equals("LI")){   		//log in
	    		String nombre=mensajeSeparado.Sub(1).toString();
				String password=mensajeSeparado.Sub(2).toString();
				GameLogin logger=new GameLogin(superservidor.xmlClanes); 
				if (password==superservidor.xmlSeguridad.getContraseña(nombre)){
					jugador=logger.login(nombre, password);
				}
				else{
					salida.writeUTF("ERR/Error nombre de usuario o contrasña incorrectos. Por favor vuelva a intentarlo");
				}
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	else{
	    		salida.writeUTF("Eso no fue una posicion\n");
	    	}
	    	
	    } 
	    catch (IOException ex) {
	    	ex.printStackTrace();
	    	}
	    catch (TransformerException e) {
			e.printStackTrace();
		}
    	}
    }
}