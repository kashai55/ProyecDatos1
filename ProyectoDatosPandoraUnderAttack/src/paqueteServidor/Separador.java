package paqueteServidor;

import paqueteLista.*;

/**
 * 
 * @author Ricardo
 *
 */
public class Separador {

	public Separador() {	}
	
	/**
	 * separa la informacion que contiene un string, esta 
	 * informacion debe estar separada por el signo "/", por ejemplo "hola/como/estas" e inserta esta 
	 * informacion en una lista
	 * @param mensaje
	 * @return
	 */
	public Lista separar(String mensaje){
		Lista lista=new Lista();
		int i=0;
		int j=0;
		String temp;
		while (j<mensaje.length()){
			if (mensaje.charAt(j)=='/'){
				temp=mensaje.substring(i,j);
				lista.nuevoObj(temp);
				i=j+1;
				j++;
			}
			else{
				j++;
			}
		}
		temp=mensaje.substring(i, j);
		lista.nuevoObj(temp);
		return lista;
	}
	/**
	 * realiza la misma accion que separar, pero con la diferencia que la informacion del string
	 * debe estar separada de la siguiente manera: "letraNUMERO/letraNUMERO/letraNUMERO...",  separa
	 * e inserta los numeros en una lista
	 * @param mensaje
	 * @return
	 */
	public Lista separarRecurso(String mensaje){
		Lista lista=new Lista();
		int i=1;
		int j=1;
		String temp;
		while (j<mensaje.length()){
			if (mensaje.charAt(j)=='/'){
				temp=mensaje.substring(i,j);
				lista.nuevoObj(temp);
				i=j+2;
				j=j+2;
			}
			else{
				j++;
			}
		}
		temp=mensaje.substring(i, j);
		lista.nuevoObj(temp);
		return lista;
	}
}
