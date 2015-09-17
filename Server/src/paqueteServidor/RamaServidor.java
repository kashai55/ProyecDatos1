package paqueteServidor;
import java.io.*;
import java.net.*;

public class RamaServidor extends Thread {
    private Socket socketCliente;
    private DataOutputStream salida;
    private DataInputStream entrada2;
    private BufferedReader entrada;
    private Servidor superservidor;

    
    public RamaServidor(Socket socket,Servidor superservidor) {
        try {
        	this.superservidor=superservidor;
            this.socketCliente = socket;
            salida = new DataOutputStream(socket.getOutputStream());
            entrada2 = new DataInputStream(socket.getInputStream());
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            System.out.println("Conectado el cliente"+socketCliente);
        } catch (IOException ex) {
        	System.out.println("Error en la rama servidor del cliente"+socket);
        }
    }
    
    public void desconectar() {
        try {
        	System.out.println("Cliente:  "+socketCliente+"  desconectado");
        	entrada2.close();
        	entrada.close();
			salida.close();
			socketCliente.close();
        } catch (IOException ex) {
            System.out.println("Errror al desconectar el cliente "+socketCliente);
        }
    }
    @Override
    public void run() {
	        try {
//	        	String mensaje;
//	            mensaje=entrada.readLine();
//	            System.out.println("el mensaje es: " +mensaje);
	            String mensaje2;
	            mensaje2=entrada2.readUTF();
	            System.out.println("el mensaje 2 es: " +mensaje2);
	        	if (mensaje2.equals("hola")){
	        		System.out.println("eso fue un hola");
	        		salida.writeUTF("el servidor te responde hola");
	        	}
	        	if (mensaje2=="DESCONECTAR"){
	        		System.out.println("adios");
	        		salida.writeUTF("el servidor se despide");
	        		desconectar();
	        	}
	        } 
	        catch (IOException ex) {
	        	ex.printStackTrace();
	        	}
    }
}