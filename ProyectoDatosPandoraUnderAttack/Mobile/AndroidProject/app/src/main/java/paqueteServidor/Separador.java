package paqueteServidor;

import paqueteLista.*;

public class Separador {

	public Separador() {	}
	
	
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
		lista.Sub(0);
		lista.Sub(1);
		lista.Sub(2);
		return lista;
	}
}
