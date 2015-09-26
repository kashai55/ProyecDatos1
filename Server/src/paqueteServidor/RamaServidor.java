package paqueteServidor;
import java.io.*;
import java.net.*;

import javax.xml.transform.TransformerException;

import paqueteLista.*;
import paqueteCliente.*;

/**
 * 
 * @author Ricardo
 *
 */
public class RamaServidor extends Thread {
    private Socket socketCliente;
    private DataOutputStream salida;
    private BufferedReader entrada;
    private Servidor superservidor;
    public String mensaje;
    
    public Jugador jugador;
    /**
     * constructor de la clase.
     * inicializa los atributos asignados
     * 
     * @param socket
     * @param superservidor
     * @throws IOException
     */
    public RamaServidor(Socket socket,Servidor superservidor) throws IOException {
        this.superservidor=superservidor;
		this.socketCliente = socket;
        salida = new DataOutputStream(socketCliente.getOutputStream());
        entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
    }
    
    /**
     * Cierra la entrada, la salida y el socket con el cliente
     */
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
    
    /**
     * envia un mensaje al cliente asociado con el socket 
     * @param mensaje
     */
    public void enviarAcliente(String mensaje){
    	try {
			salida.writeUTF(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    /**
     *  espera a que el cliente envie un mensaje, este mensaje es descifrado y le responde al cliente
     * 	con un string, el cual contiene las instrucciones que debe realizar el cliente
     * 
     */
    public void run() {
    	while(true){
	    try {
	    	
	    	String mensajeEntrada=entrada.readLine();
	    	System.out.println("El mensaje recibido en el servidor es: "+mensajeEntrada);
	    	mensaje=mensajeEntrada.substring(2, mensajeEntrada.length());
	    	Lista mensajeSeparado= new Separador().separar(mensaje);
	    	System.out.println("el mensaje cortado es:"+mensaje);
	    	
	    	if ((mensajeSeparado.Sub(0)).toString().equals("SI")){              //sign in
	    			System.out.println("El mensaje de sign in fue recibido");
	    			String nombre=mensajeSeparado.Sub(1).toString();
	    			String password=mensajeSeparado.Sub(2).toString();
	    			superservidor.xmlSeguridad.añadirUsuario(nombre, password);
	    			jugador=new Jugador(nombre);
	    			salida.writeUTF("BN\n");
	    	}
    	
	    	else if ((mensajeSeparado.Sub(0)).toString().equals("LI")){   		//log in
	    		String nombre=mensajeSeparado.Sub(1).toString();
	    		System.out.println("el nombre a buscar en el xml es:"+nombre);
				String password=mensajeSeparado.Sub(2).toString();
				if (password.equals(superservidor.xmlSeguridad.getContraseña(nombre))){
					GameLogin logger=new GameLogin(superservidor.xmlClanes); 
					jugador=logger.login(nombre, password);
					salida.writeUTF("BN\n");
				}
				else{
					salida.writeUTF("ERR/Error nombre de usuario o contraseña incorrectos. Por favor vuelva a intentarlo\n");
				}
	    	}
	    	
	    	else if ((mensajeSeparado.Sub(0)).toString().equals("CC")){
	    		String nombreCreador=jugador.getUserName();
	    		String nombreClan=(mensajeSeparado.Sub(1)).toString();
	    		String latitud=(mensajeSeparado.Sub(2)).toString();
	    		String longitud=(mensajeSeparado.Sub(3)).toString();
	    		superservidor.xmlClanes.crearClan(nombreClan, nombreCreador, latitud, longitud);
	    		salida.writeUTF("CLCR\n");
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