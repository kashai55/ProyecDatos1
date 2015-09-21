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
	
	public <Tipo>Tipo buscar(Tipo ele){
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
		return (Tipo) temp.ele;
	}
	
	public int CantObj(Object ele){
		Nodo temp;
		temp=head;
		int i=0;
		while (temp!=null){
			if (!temp.ele.getClass().equals(ele.getClass())){
				temp=temp.sig;
			}
			else{
				i=i+1;
				temp=temp.sig;
			}
		}
		System.out.println("se encuentran " + i + " del elemento buscado");
		return i;
	}
	
	public void EliminarObj(Object ele){
		Nodo temp;
		temp=head;
		if (head!=null){
			if(ele.equals(head.ele)){
				this.head=head.sig;
			}
			else if(ele.equals(tail.ele)){
				this.tail=tail.ant;
			}
			else{
				boolean borrado=false;
				while (temp!=null){
					if (!temp.ele.equals(ele)){
						if ( borrado){
							temp.indice--;
							temp=temp.sig;
						}
						else{
							temp=temp.sig;
						}
					}
					else{
						temp.ant.sig=temp.sig;
						temp.sig.ant=temp.ant;
						borrado=true;
						temp=temp.sig;
					}
				}
			}
		}
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
			return temp.ele;
		}
	}
	public void Imprimir(){
		Nodo temp;
		temp=this.head;
		if (head==null){
			System.out.println("Lista vacia");
			return;
		}
		while(temp!=this.tail){
			System.out.println(temp.ele.toString());
			temp=temp.sig;
		}
		System.out.println(this.tail.ele.toString());
	}
}
