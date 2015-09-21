package paqueteCliente;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {
	protected Socket sk;
    protected DataOutputStream salida;
    protected BufferedReader entrada;
    protected String ipServidor;
    
	public Cliente() {
		try {
			ipServidor=InetAddress.getLocalHost().getHostAddress(); //Solo para probar sobre mi propia computadora
			this.sk= new Socket(ipServidor,8080);
			this.entrada = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			this.salida = new DataOutputStream(sk.getOutputStream());
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void comunicarse(String mensaje) throws InterruptedException{
		while (true){
		try {
			Thread.sleep(5000);
	        salida.writeUTF(mensaje+"\n");
	        String respuestaEntrada;
	        respuestaEntrada = entrada.readLine();
	        String respuesta=respuestaEntrada.substring(2, respuestaEntrada.length());
	        if(respuesta.equals("Adios!!")){
	        	System.out.println("actualizar jugadores");
	        }
	        System.out.println(" Servidor respondió : " + respuesta);

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

}
