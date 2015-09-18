package paqueteCliente;
import paqueteServidor.*;
import paqueteLista.*;
import paqueteObjetos.*;


public class Jugador {

	String userName;
	String password;
	int madera=0;
	int hierro=0;
	int piedra=0;
	
	Clan clanActual;
	
	Lista listaClanes = new Lista();
	Lista listaBloqueos = new Lista();
	Lista listaArmas = new Lista();
	
	public Jugador(String un,String pw){
		userName=un;
		password=pw;
	}
	public void crearClan(String clanName){
		Clan c = new Clan(clanName, null);
		listaClanes.nuevoObj(c);
		System.out.println(this.getUserName() +  " ha creado el clan");
	}
	public void conectarseAClan(Clan clan,String nombreClan){
		listaClanes.buscar(nombreClan);
	}
	public boolean Entrar(){
		int n = 1;
		if (n==1){
			return true;
		}
		return false;
	}

	public void crearArmas(String arma){
		CreadorAbstracto Creador;
		Creador = new CreadorConcreto();
		if (arma=="Arma1"){
			Object Arma = Creador.factoryMethod("Arma1");
			System.out.println("Se creo una Arma1 satisfactoriamente");
			listaArmas.nuevoObj(Arma);
		}
		else{
			Object Arma = Creador.factoryMethod("Arma2");
			System.out.println("Se creo una Arma2 satisfactoriamente");
			listaArmas.nuevoObj(Arma);
		}
		
	}
	
	public void crearBloqueo(String bloqueo){
		CreadorAbstracto Creador;
		Creador = new CreadorConcreto();
		if (bloqueo=="Bloqueo"){
			Object Bloqueo = Creador.factoryMethod("Bloqueo1");
			System.out.println("Se creo una Bloqueo1 satisfactoriamente");
			listaArmas.nuevoObj(Bloqueo);
		}
		else{
			Object Bloqueo = Creador.factoryMethod("bloqueo2");
			System.out.println("Se creo una Bloqueo2 satisfactoriamente");

			listaArmas.nuevoObj(Bloqueo);
		}
		
	}
	public void recolectar(Recursos r){
		if (r.getName()=="Madera"){
			this.madera++;
			this.clanActual.madera++;
			
			System.out.println("Se obtuvo 1 de Madera al inventario de:" + this.userName);
			System.out.println("Se agrego 1 de Madera al clan:" + this.clanActual.clanName);

		}
		if (r.getName()=="Piedra"){
			this.piedra++;
			this.clanActual.piedra++;
			System.out.println("Se obtuvo 1 de Piedra");
		}
		else{
			this.hierro++;
			this.clanActual.hierro++;
			System.out.println("Se obtuvo 1 de Piedra");
			
		}
	}
//	public void pandoraUnderAttack(){
//	}
//	public void realizarAccion(){
//	}
	public String getUserName(){
		return userName;
	}
}

