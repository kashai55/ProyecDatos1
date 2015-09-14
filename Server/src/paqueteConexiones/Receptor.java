package paqueteConexiones;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Receptor{
	
	String DatoRecibido;
	ServerSocket SerSo;
	Socket Clien;
	
    public Receptor() {
    	try {
			SerSo=new ServerSocket(8080);
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public String getMensaje(){
    	return DatoRecibido;
    }
   
    public void esperarMensaje(){
    	try {
			System.out.println("esperando cliente");
			Clien=SerSo.accept();
			System.out.println("aceptado");
			DataInputStream DatoaRecibir=new DataInputStream(Clien.getInputStream());
			DatoRecibido=DatoaRecibir.readUTF();
			           
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en receptor: "+e.getMessage());
			e.printStackTrace();
		}
    	
    }
    

    
//        @Override
//	public void run() {
//		try {
//			ServerSocket SerSo=new ServerSocket(8080);
//			Socket Clien;
//				System.out.println("aceptando cliente");
//				Clien=SerSo.accept();
//				System.out.println("aceptado");
//				DataInputStream DatoaRecibir=new DataInputStream(Clien.getInputStream());
//				DatoRecibido=DatoaRecibir.readUTF();
//				System.out.println(DatoRecibido);
//			SerSo.close();
//                                
//                        
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Error en receptor"+e.getMessage());
//			e.printStackTrace();
//			
//                }
//        }
    

}