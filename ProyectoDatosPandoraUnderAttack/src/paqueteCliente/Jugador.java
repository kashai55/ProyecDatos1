package paqueteCliente;
import paqueteServidor.*;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import paqueteLista.*;
import paqueteObjetos.*;
import paqueteXML.*;
/**
 * 
 * @author Kevin
 *
 */
public class Jugador{
	
/**
 * Atributos de la clase Jugador
 */

	protected String userName;
	protected int madera=0;
	protected int hierro=0;
	protected int piedra=0;
	protected double posx;
	protected double posy;
	protected boolean lider=false;
	protected Clan clanActual;
	Mundo mundo;
	
	public Lista listaClanes = new Lista();
	public Lista listaBloqueos = new Lista();
	public Lista listaArmas = new Lista();
	/**
	 * Constructor de la Clase Jugador, recibe un string con el nombre de usuario del jugador
	 * @param un nombre de usuario del jugador
	 */
	public Jugador(String un){
		userName=un;
	}
	/**
	 * Crea una nueva instancia de clan y el objeto creaado es agregado a lista de clanes del jugador, ademas se le asigna true al atributo lider
	 * @param clanName
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	public void crearClan(String clanName) throws TransformerConfigurationException, TransformerException{
		Clan clan = new Clan(clanName,this);
		this.clanActual=clan;
		this.listaClanes.nuevoObj(clan);
		this.setLiderasgo();
	}
//	public String ConectarseClan(String nombreClan){
//		mundo.ListaClanes.buscar(nombreClan);
//		return 
//	}
	/**
	 * Recibe un String con el tipo de arma que desea crear, si cuenta con los recursos se crea el arma y se le restan a los recursos del jugador y del clan, si no, no crea el objeto
	 * @param arma String con el tipo de arma que desea crear
	 */
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
	/**
	 * 	/**
	 * Recibe un String con el tipo de bloqueo que desea crear, si cuenta con los recursos se crea el arma y se le restan a los recursos del jugador y del clan, si no, no crea el objeto
	 * @param bloqueo String con el tipo de bloqueo que desea crear
	 */
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
	/**
	 * Recibe un objeto de tipo recurso el cual puede ser Madera,Hierro o Piedra y se agrega al inventario del Jugador
	 * @param r objeto de tipo recurso el cual puede ser Madera,Hierro o Piedra
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
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
	/**
	 * Obtiene el nombre de usuario ingresado por el usario
	 * @return el nombre de usuario
	 */
	public String getUserName(){
		System.out.println(userName);
		return userName;
	}
	/**
	 * Obtiene el Clan actual en el cual el jugador esta jugando
	 * @return el clan con el cual el jugador esta jugando actualmente
	 */
	public Clan getClanActual(){
		System.out.println("este es tu clan actual: " + clanActual.getClanName());
		return clanActual;
	}
	/**
	 * Obtiene la cantidad de madera que posee el jugador
	 * @return cantidad del recurso madera del Jugador
	 */
	public  int getMadera(){
		System.out.println("se tiene " + madera + " de madera");
		return this.madera;
	}
	/**
	 * Obtiene la cantidad de hierro que posee el jugador
	 * @return cantidad del recurso hierro del Jugador
	 */
	public  int getHierro(){
		System.out.println("se tiene " + hierro + " de hierro");
		return this.hierro;
	}
	/**
	 * Obtiene la cantidad de piedra que posee el jugador
	 * @return cantidad del recurso piedra del Jugador
	 */
	public  int getPiedra(){
		System.out.println("se tiene " + piedra + " de piedra");
		return this.piedra;
	}
	/**
	 * Obtiene un true si el jugador es el lider del clan creado o false si no lo es
	 * @return true o false
	 */
	public boolean getLiderasgo(){
		System.out.println(lider);
		return lider;
	}
	/**
	 * Permite asignar la cantidad de madera de un jugador cuando recoje un recurso o carga una partida
	 * @param cMadera cantidad del recurso madera que se va a agregar
	 * @return la suma de la madera contenida mas la que va a ser adicionada
	 */
	public  void setMadera(int cMadera){
		 this.madera= this.madera+cMadera;
	}
	/**
	 * Permite asignar la cantidad de hierro de un jugador cuando recoje un recurso o carga una partida
	 * @param cHierro cantidad del recurso Hierro que se va a agregar
	 * @return la suma de la hierro contenida mas la que va a ser adicionada
	 */
	public void setHierro(int cHierro){
		 this.hierro= this.hierro+cHierro;
	}
	/**
	 * Permite asignar la cantidad de piedra de un jugador cuando recoje un recurso o carga una partida
	 * @param cPiedra cantidad del recurso piedra que se va a agregar
	 * @return la suma de la piedra contenida mas la que va a ser adicionada
	 */
	public  void setPiedra(int cPiedra){
		this.piedra= this.piedra+cPiedra;
	}
	/**
	 * Obtiene la posicion en x de un Jugador
	 * @return posicion en x del jugador
	 */
	public double getPoscx(){
		System.out.println(posx);
		return posx;
	}
	/**
	 * Obtiene la posicion en y de un Jugador
	 * @return posicion en y del jugador
	 */
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
	/**
	 * Asigna la cantidad de armas del tipo 1 que el jugador previamente poseia al cargar el juego
	 * @param cantArma1 cantidad de armas del tipo 1 que el jugador poseia
	 */
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
	/**
	 * Asigna la cantidad de armas del tipo 2 que el jugador previamente poseia al cargar el juego
	 * @param cantArma2 cantidad de armas del tipo 2 que el jugador poseia
	 */
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
	/**
	 * Asigna la cantidad de bloqueos del tipo 1 que el jugador previamente poseia al cargar el juego
	 * @param cantBloqueo1 cantidad de bloqueos del tipo 1 que el jugador poseia
	 */
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
	/**
	 * Asigna la cantidad de bloqueos del tipo 2 que el jugador previamente poseia al cargar el juego
	 * @param cantBloqueo1 cantidad de bloqueos del tipo 2 que el jugador poseia
	 */
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
	/**
	 * Asigna true si el jugador es lider del clan 
	 * @return true
	 */
	public boolean setLiderasgo(){
		return lider=true;
	}
	/**
	 * @author Kevin
	 */
}