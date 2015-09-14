package paqueteLista;

public class Lista {
	public Nodo head;
	public Nodo tail;
	
	
	public Lista(){
		head=tail=null;
	}
	
	public boolean estaVacia(){
		return head==null;
	}
	
	public void nuevoObj(Object ele){
		Nodo nuevo= new Nodo(ele);
		if (!estaVacia()){
			this.tail.sig=nuevo;
			nuevo.ant=tail;
			nuevo.indice = tail.indice+1;
			tail=nuevo;
		}
		else{
			this.head = this.tail = nuevo;
			nuevo.indice=0;
		}
	}
	
	public Object buscar(Object ele){
		Nodo temp;
		temp=this.head;
		while (temp!=null){
			if (!temp.ele.equals(ele)){
				temp=temp.sig;
			}
			else{
				break;
			}
		}
		if (temp==null){
			System.out.println("No se encontro el elemento");
			return null;
		}
		System.out.println(temp.ele);
		return temp.ele;
	}
	
	public Object Sub(int n){
		if (n<0){
			System.out.println("Error");
			return null;
		}
		if (n>this.tail.indice){
			System.out.println("Error,indice fuera del rango de lista ");
			return null;
		}
		else{
			Nodo temp= this.head;
			int i=0;
			while (i<n){
				temp=temp.sig;
				i++;
			}
			System.out.println(temp.ele);
			return temp.ele;
		}
	}
}
