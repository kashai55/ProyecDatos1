package paqueteServidor;
import paqueteObjetos.*;
import paqueteLista.*;
import paqueteCliente.*;

public class Clan {
	String clanName;
	Reliquia reliquia;
	
	Lista listaR = new Lista();
	Lista listaJ = new Lista();
	Nodo n;
	public Clan(String clanName, Jugador user){
		listaJ.nuevoObj(user);
		listaR.nuevoObj(reliquia);
	}
}
