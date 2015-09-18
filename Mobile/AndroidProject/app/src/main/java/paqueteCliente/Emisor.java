package paqueteCliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import paqueteServidor.Servidor;

/**
 *
 * @author Fernanda
 */
public class Emisor {
    public Emisor(){
    	try{
	    	String ip=InetAddress.getLocalHost().getHostAddress();
			System.out.println("esta es mi ip:  "+ip);
    	}
		catch(IOException e){
			System.out.println("error en el cliente"+e.getMessage());
			
		}
    }
	
	public void enviar() {
		try{
			String ip="192.168.43.233";
			Socket ClienSo=new Socket(ip,8080) ;
			DataOutputStream DatoaEnviar=new DataOutputStream(ClienSo.getOutputStream());
			DatoaEnviar.writeUTF("conectandome con el servidor");
			ClienSo.close();
		}
		catch(IOException e){
			System.out.println("error en el cliente"+e.getMessage());
			
		}
	}
}    

