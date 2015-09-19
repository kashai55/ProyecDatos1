package paqueteCliente;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {
	protected Socket sk;
    protected DataOutputStream salida;
    protected DataInputStream entrada2;
    protected BufferedReader entrada;
    protected String ipServidor;
    
	public Cliente() {
		try {
			ipServidor=InetAddress.getLocalHost().getHostAddress(); //Solo para probar sobre mi propia computadora
			this.sk= new Socket(ipServidor,8080);
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void comunicarse(String mensaje){
		try {
			
			salida = new DataOutputStream(sk.getOutputStream());
//	        entrada = new BufferedReader(new InputStreamReader(sk.getInputStream()));
	        entrada2= new DataInputStream(sk.getInputStream());
	        salida.writeUTF(mensaje);
	        
	        //String respuesta;
//	        respuesta = entrada.readLine();
	        String respuesta2 = entrada2.readUTF();
//	        System.out.println(" Servidor respondió: " + respuesta);
	        System.out.println(" Servidor respondió como respuesta 2: " + respuesta2);
	        salida.close();
//	        sk.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
