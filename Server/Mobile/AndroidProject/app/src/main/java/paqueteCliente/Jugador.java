package paqueteCliente;
import paqueteServidor.*;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import paqueteLista.*;
import paqueteObjetos.*;
import paqueteXML.*;


public class Jugador{

	protected String userName;
	protected int madera=0;
	protected int hierro=0;
	protected int piedra=0;
	protected double posx;
	protected double posy;
	
	protected Clan clanActual;
	Mundo mundo;
	
	public Lista listaClanes = new Lista();
	public Lista listaBloqueos = new Lista();
	public Lista listaArmas = new Lista();
	
	public Jugador(String un){
		userName=un;
	}
	public void crearClan(String clanName) throws TransformerConfigurationException, TransformerException{
		Clan clan = new Clan("Lolol",this);
		this.listaClanes.nuevoObj(clan);
	}
//	public String ConectarseClan(String nombreClan){
//		mundo.ListaClanes.buscar(nombreClan);
//		return 
//	}

	public void crearArmas(String arma){
		CreadorAbstracto Creador;
		Creador = new CreadorConcreto();
		if (arma=="Arma1"){
			if (this.hierro>=2 && this.piedra>=1){
				Object Arma = Creador.factoryMethod("Arma1");
				System.out.println("Se creo una Arma1 satisfactoriamente");
				listaArmas.nuevoObj(Arma);
				listaArmas.Imprimir();
				this.setHierro(-2);
				this.setPiedra(-1);
				this.clanActual.setClanHierro(-2);
				this.clanActual.setClanPiedra(-1);
			}
			else{
				System.out.println("No se cuenta con los materiales necesarios para crear el arma");
			}
		}
		else if (arma=="Arma2"){
			if (this.hierro>=3 && this.piedra>=5 && this.madera>=7){
				Object Arma = Creador.factoryMethod("Arma2");
				System.out.println("Se creo una Arma2 satisfactoriamente");
				listaArmas.nuevoObj(Arma);
				listaArmas.Imprimir();
				this.setHierro(-3);
				this.setPiedra(-5);
				this.setMadera(-7);
				this.clanActual.setClanHierro(-3);
				this.clanActual.setClanPiedra(-5);
				this.clanActual.setClanMadera(-7);
			}
			else{
				System.out.println("No se cuenta con los materiales necesarios para crear el arma");
			}
		}
		else{
			System.out.println("Error, el arma deseada no existe");
		}
	}
	
	public void crearBloqueo(String bloqueo){
		CreadorAbstracto Creador;
		Creador = new CreadorConcreto();
		if (bloqueo=="Bloqueo1"){
			if (this.hierro>=3 && this.piedra>=3){
				Object Bloqueo = Creador.factoryMethod("Bloqueo1");
				System.out.println("Se creo una Bloqueo1 satisfactoriamente");
				listaBloqueos.nuevoObj(Bloqueo);
				listaBloqueos.Imprimir();
				this.hierro=hierro-3;
				this.piedra=piedra-3;
				this.clanActual.setClanHierro(-3);
				this.clanActual.setClanPiedra(-3);
			}
			else{
				System.out.println("No se cuenta con los materiales necesarios para crear el bloqueo");
			}
		}
		else if (bloqueo == "Bloqueo2"){
			if (this.hierro>=5 && this.piedra>=7 && this.madera>=10){
				Object Bloqueo = Creador.factoryMethod("Bloqueo2");
				System.out.println("Se creo una Bloqueo2 satisfactoriamente");
				listaBloqueos.nuevoObj(Bloqueo);
				listaBloqueos.Imprimir();
				this.hierro=hierro-5;
				this.piedra=piedra-7;
				this.madera=madera-10;
				this.clanActual.setClanHierro(-5);
				this.clanActual.setClanPiedra(-7);
				this.clanActual.setClanMadera(-10);
				
			}
			else{
				System.out.println("No se cuenta con los materiales necesarios para crear el bloqueo");
			}
		}
		else{
			System.out.println("Error, el bloqueo deseado no existe");
		}
		
	}
	public void recolectar(Recursos r) throws TransformerConfigurationException, TransformerException{
		if (r.getName()=="Madera"){
			this.setMadera(1);
			this.clanActual.setClanMadera(1);
			System.out.println("Se obtuvo 1 de Madera al inventario de:" + this.userName);
			System.out.println("Se agrego 1 de Madera al clan:" + this.clanActual.getClanName());

		}
		if (r.getName()=="Piedra"){
			this.setPiedra(1);
			this.clanActual.setClanPiedra(1);
			System.out.println("Se obtuvo 1 de Piedra");
			System.out.println("Se agrego 1 de Piedra al clan:" + this.clanActual.getClanName());

		}
		else{
			this.setHierro(1);
			this.clanActual.setClanHierro(1);
			System.out.println("Se obtuvo 1 de Hierro");
			System.out.println("Se agrego 1 de Hierro al clan:" + this.clanActual.getClanName());
			
		}
	}
//	public void pandoraUnderAttack(Clan ClanOb){
//	if()
//	}
//	public void realizarAccion(){
//	}
	public String getUserName(){
		System.out.println(userName);
		return userName;
	}
	public Clan getClanActual(){
		System.out.println("este es tu clan actual: " + clanActual.getClanName());
		return clanActual;
	}
	public  int getMadera(){
		System.out.println(madera);
		return this.madera;
	}
	public  int getHierro(){
		System.out.println(madera);
		return this.hierro;
	}
	public  int getPiedra(){
		System.out.println(piedra);
		return this.piedra;
	}
	public  int setMadera(int cMadera){
		return this.madera= this.madera+cMadera;
	}
	public  int setHierro(int cHierro){
		return this.hierro= this.hierro+cHierro;
	}
	public  int setPiedra(int cPiedra){
		return this.piedra= this.piedra+cPiedra;
	}
	public double getPoscx(){
		System.out.println(posx);
		return posx;
	}
	public double getPoscy(){
		System.out.println(posy);
		return posy;
	}
//	public double setPoscx(){
//		System.out.println(posx);
//		return posx;
//	}
//	public double setPoscy(){
//		System.out.println(posy);
//		return posy;
//	}
	public void setArma1(int cantArma1){
		int i;
		for(i=0; i>cantArma1; i++){
			CreadorAbstracto Creador;
			Creador = new CreadorConcreto();
			Object Arma = Creador.factoryMethod("Arma1");
			listaArmas.nuevoObj(Arma);
			System.out.println(listaArmas.CantObj(Arma));
			
		}
	}
	public void setArma2(int cantArma2){
		int i;
		for(i=0; i>cantArma2; i++){
			CreadorAbstracto Creador;
			Creador = new CreadorConcreto();
			Object Arma = Creador.factoryMethod("Arma2");
			listaArmas.nuevoObj(Arma);
			System.out.println(listaArmas.CantObj(Arma));
		}
	}
	public void setBloqueo1(int cantBloqueo1){
		int i;
		for(i=0; i>cantBloqueo1; i++){
			CreadorAbstracto Creador;
			Creador = new CreadorConcreto();
			Object Bloqueo = Creador.factoryMethod("Bloqueo1");
			listaBloqueos.nuevoObj(Bloqueo);
			System.out.println(listaBloqueos.CantObj(Bloqueo));
		}
	}
	public void setBloqueo2(int cantBloqueo2){
		int i;
		for(i=0; i>cantBloqueo2; i++){
			CreadorAbstracto Creador;
			Creador = new CreadorConcreto();
			Object Bloqueo = Creador.factoryMethod("Bloqueo2");
			listaBloqueos.nuevoObj(Bloqueo);
			System.out.println(listaBloqueos.CantObj(Bloqueo));
		}
	}
}
