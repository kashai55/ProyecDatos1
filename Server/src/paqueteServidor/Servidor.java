package paqueteServidor;

import java.io.*;
import java.net.*;

public class Servidor implements Runnable{
    ServerSocket socketServidor;
    
    public Servidor(){
    	try {
			socketServidor = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
	@Override
	public void run() {
		while (true) {
			try {
				Socket clienteSocket;
				clienteSocket = socketServidor.accept();
				System.out.println("Nueva conexión entrante: "+clienteSocket);
				(new RamaServidor(clienteSocket,this)).start();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
}