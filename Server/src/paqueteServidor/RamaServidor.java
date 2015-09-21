package paqueteServidor;
import java.io.*;
import java.net.*;

public class RamaServidor extends Thread {
    private Socket socketCliente;
    private DataOutputStream salida;
    private BufferedReader entrada;
    private Servidor superservidor;
    public String mensaje;
    
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
	    	System.out.println("El mensaje recibido en el servidor es: "+mensaje);
	    	if (mensaje.equals("posicion")){
	    		salida.writeUTF("Adios!!\n");
	    	}
	    	else{
	    		salida.writeUTF("Eso no fue una posicion\n");
	    	}
	    	
	    } 
	    catch (IOException ex) {
	    	ex.printStackTrace();
	    	}
    	}
    }
}