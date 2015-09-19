package paqueteServidor;
import java.io.*;
import java.net.*;

public class RamaServidor extends Thread {
    private Socket socketCliente;
    private DataOutputStream salida;
    private BufferedReader entrada;
    private Servidor superservidor;

    
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
    @Override
    public void run() {
    	while(true){
	    try {
	    	
	    	String mensajeEntrada=entrada.readLine();
	    	String mensaje=mensajeEntrada.substring(2, mensajeEntrada.length());
	    	if (mensaje.equals("hola")){
	    		System.out.println("eso fue un hola");
	    	}
	    	salida.writeUTF("Hola!!  soy el servidor\n");
	    	
	    } 
	    catch (IOException ex) {
	    	ex.printStackTrace();
	    	}
    	}
    }
}