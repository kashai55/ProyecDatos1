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
//		
		Cliente cli=new Cliente();
		cli.comunicarse("hola");
		cli.comunicarse("hi");
		cli.comunicarse("vonjeour");
		cli.comunicarse("hehehe");
	}
}
