package paqueteServidor;
import paqueteLista.Lista;
import paqueteServidor.Mundo;
import paqueteCliente.Jugador;
import paqueteLista.*;
import paqueteObjetos.*;

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
