package paquetePruebas;

import paqueteServidor.*;
import paqueteCliente.*;

import paqueteLista.*;
import paqueteObjetos.*;

public class Prueba {
	public static void main(String[] args) throws Exception{
		Servidor servidor=new Servidor();
		Thread hiloServidor=new Thread(servidor);
		hiloServidor.start(); 
////		
		Cliente cli=new Cliente();
//		cli.comunicarse("hola");
//		cli.comunicarse("hi");
//		cli.comunicarse("vonjeour");
//		cli.comunicarse("hehehe");
		
//		Lista l=new Lista();
//		l.nuevoObj("hahaha");
//		l.nuevoObj("hihihi");
//		l.nuevoObj("jujuju");
//		l.nuevoObj("jojojo");
//		l.nuevoObj("equisDe");
//		String n=l.Sub(3);
//		String m=l.Sub(4);
		
	}
}
