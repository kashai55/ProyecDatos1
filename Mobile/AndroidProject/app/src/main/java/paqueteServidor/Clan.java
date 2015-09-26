package paqueteServidor;
import paqueteObjetos.*;
import paqueteLista.*;
import paqueteCliente.*;

public class Clan {
	protected String clanName;
	Reliquia reliquia;
	protected int madera=0;
	protected int hierro=0;
	protected int piedra=0;
	
	Lista listaReliquias = new Lista();
	Lista listaJugadores = new Lista();

	Nodo n;
	public Clan(String clanName, Jugador user){
		listaJugadores.nuevoObj(user);
		listaReliquias.nuevoObj(reliquia);
		
	}
	public String getClanName(){
		return clanName;
	}
	public  int getClanMadera(){
		return this.madera;
	}
	public  int getClanHierro(){
		return this.hierro;
	}
	public  int getClanPiedra(){
		return this.piedra;
	}
	public  int setClanMadera(int cMadera){
		return this.madera= this.madera+cMadera;
	}
	public  int setClanHierro(int cHierro){
		return this.hierro= this.hierro+cHierro;
	}
	public  int setClanPiedra(int cPiedra){
		return this.piedra= this.piedra+cPiedra;
	}
}
