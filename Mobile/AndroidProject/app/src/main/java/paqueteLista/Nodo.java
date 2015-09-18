package paqueteLista;

public class Nodo {
	Object ele;
	Nodo sig;
	Nodo ant;
	int indice;
	String info;
	
	public Nodo(Object i){
	this(i,null,null);	
	}
	public Nodo(Object i, Nodo n,Nodo m){
		ele=i;
		sig=n;
		ant=m;
	}
}
