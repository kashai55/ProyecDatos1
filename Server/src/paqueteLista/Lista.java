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
		if (!estaVacia()){
			tail= new Nodo(ele,null,tail);
			tail.ant.sig= tail;
		}
		else head = tail = new Nodo(ele);
	}
	public Object buscar(Object ele){
		Nodo temp;
		temp=head;
		while (temp!=null){
			if (temp.ele != ele){
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
	
	public Nodo Sub(int n){
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
			while (i<temp.indice){
				i++;
				temp=temp.sig;
			}
			return temp;
		}
	}
}
