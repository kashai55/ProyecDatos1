package paqueteConexiones;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Emisor {
	String miIP;
	String ipServidor="192.168.100.9"; //aca va el ip de la maquina que definamos como servidor
	Socket ClienSo;
	
    public Emisor(){
    	try{
	    	miIP=InetAddress.getLocalHost().getHostAddress();
			System.out.println("Se creo un emisor y esta es mi ip: " +miIP);
    	}
		catch(IOException e){
			System.out.println("error en el cliente"+e.getMessage());
			
		}
    }
	
	public void enviarAservidor(String mensaje) {
		try{
			ClienSo=new Socket(ipServidor,8080) ;
			DataOutputStream DatoaEnviar=new DataOutputStream(ClienSo.getOutputStream());
			DatoaEnviar.writeUTF(miIP+"/"+mensaje);
			ClienSo.close();
		}
		catch(IOException e){
			System.out.println("error en el emisor"+e.getMessage());
		}
	}
	
	public void enviarAcliente(String mensaje, String ip) {
		try{
			ClienSo=new Socket(ip,8080) ;
			DataOutputStream DatoaEnviar=new DataOutputStream(ClienSo.getOutputStream());
			DatoaEnviar.writeUTF(ip+"/"+mensaje);
			ClienSo.close();
		}
		catch(IOException e){
			System.out.println("error en el emisor"+e.getMessage());
		}
	}
}    

