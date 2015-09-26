package paquetePruebas;

import paqueteObjetos.CreadorAbstracto;
import paqueteObjetos.CreadorConcreto;

public class PruebaCreaciondeObjetos {

	public static void main(String[] args) {
		CreadorAbstracto Creador;
		Creador = new CreadorConcreto();
		Object object = Creador.factoryMethod("Arma1");
		Object objec = Creador.factoryMethod("Arma2");
		Object obje = Creador.factoryMethod("Bloqueo1");
		Object obj = Creador.factoryMethod("Bloqueo2");
		Object ob = Creador.factoryMethod("Madera");
		Object o = Creador.factoryMethod("Hierro");
		Object Objeto = Creador.factoryMethod("Piedra");

	}

}
