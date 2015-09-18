package paqueteServidor;
import paqueteObjetos.*;
import paqueteLista.*;
import paqueteCliente.*;

public class Clan {
	public String clanName;
	Reliquia reliquia;
	public int madera=0;
	public int hierro=0;
	public int piedra=0;
	
	Lista listaReliquias = new Lista();
	Lista listaJugadores = new Lista();

	Nodo n;
	public Clan(String clanName, Jugador user){
		listaJugadores.nuevoObj(user);
		listaReliquias.nuevoObj(reliquia);
		
	}
}
