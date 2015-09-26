package paqueteCliente;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import paqueteLista.Lista;
import paqueteServidor.Separador;


public class Cliente {
	protected Socket sk;
    protected DataOutputStream salida;
    protected BufferedReader entrada;
    protected String ipServidor;
	public Lista respuestaSeparada;
    
	public Cliente() {
		try {
			ipServidor="172.19.13.202"; //Solo para probar sobre mi propia computadora
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
			try {
				Thread.sleep(2000);
				salida.writeUTF(mensaje + "\n");
				String respuestaEntrada;
				respuestaEntrada = entrada.readLine();
				String respuesta = respuestaEntrada.substring(2, respuestaEntrada.length());
				respuestaSeparada = new Separador().separar(respuesta);

				System.out.println(" Servidor respondio : " + respuesta);

			} catch (IOException e) {
				e.printStackTrace();
			}


	}

}
