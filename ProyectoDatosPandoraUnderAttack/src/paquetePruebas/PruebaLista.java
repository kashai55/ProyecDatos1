package paquetePruebas;

import paqueteLista.*;
import paqueteObjetos.*;

public class PruebaLista {

	public static void main(String[] args) {
		Arma1 arma1 = new Arma1();
		Arma1 arma1A = new Arma1();
		Arma1 arma1B = new Arma1();
		Arma2 arma2 = new Arma2();
		Lista lista = new Lista();
		lista.estaVacia();
		lista.Imprimir();
		lista.nuevoObj(arma1);
		lista.nuevoObj(arma1A);
		lista.nuevoObj(arma1B);
		lista.nuevoObj(arma2);
		lista.estaVacia();
		lista.Imprimir();
		lista.CantObj(arma1);
		lista.buscar(arma1);
		lista.EliminarObj(arma1B);
		lista.Sub(2);

		

		
		
		
	}

}
