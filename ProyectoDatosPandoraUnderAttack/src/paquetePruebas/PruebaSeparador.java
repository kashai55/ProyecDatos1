package paquetePruebas;

import paqueteLista.Lista;
import paqueteServidor.Separador;

public class PruebaSeparador {

	public static void main(String[] args) {
		Separador s=new Separador();
		String mensaje1="hola/como/estas";
		String mensaje2="M20/P15/H9";
		
		Lista mensaje1separado=s.separar(mensaje1);
		Lista mensaje2separado=s.separar(mensaje2);
		mensaje1separado.Imprimir();
		mensaje2separado.Imprimir();

	}

}
