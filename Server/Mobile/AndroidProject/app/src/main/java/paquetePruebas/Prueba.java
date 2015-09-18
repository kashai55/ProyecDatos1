package paquetePruebas;

import paqueteLista.Lista;
import paqueteObjetos.*;

public class Prueba {
	public static void main(String[] args) {
		
		CreadorAbstracto creador=new CreadorConcreto();
		
		Lista lista=new Lista();
		
		Object a= creador.factoryMethod("Arma1");

		lista.nuevoObj(a);

		lista.buscar(a);

	}
}
