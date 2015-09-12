package paqueteServidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernanda
 */
public class Servidor implements Runnable{
    
    public Servidor() {
		Thread hilo=new Thread(this);
		hilo.start();
    }

        @Override
	public void run() {
		try {
			ServerSocket SerSo=new ServerSocket(8080);
			Socket Clien;
			while (true){
				System.out.println("aceptando cliente");
				Clien=SerSo.accept();
				System.out.println("aceptado");
				DataInputStream DatoaRecibir=new DataInputStream(Clien.getInputStream());
				String DatoRecibido=DatoaRecibir.readUTF();
				System.out.println(DatoRecibido);
                                
			}
                        
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en servidor"+e.getMessage());
			e.printStackTrace();
			
                }
        }
        private int R,E,C,r,e,c;
        public void Separador(String DatoaRecibir){
            String delimiter = "[-\\,]";
            String [] temp;
            temp = DatoaRecibir.split(delimiter);
            for(int i=0; i < temp.length ; i++){
                if (i==2){
                    R=0;
                    r=R+Integer.parseInt(temp[1]);
                }
                if (i==4){
                    E=0;     
                    e=E+Integer.parseInt(temp[3]);
                }
                else{
                C=0;
                c=C+Integer.parseInt(temp[5]);
            }
                       
        }
        System.out.println(r);   
        System.out.println(e);        
        System.out.println(c);
    }
        
}
