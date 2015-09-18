package paqueteServidor;
import paqueteLista.Lista;
import paqueteCliente.Jugador;
import paqueteLista.*;

public class GameLogin {
	Lista ListaJugadores = new Lista();
	Nodo n;
	Jugador jug;
	
	public void signup(String newUsername,String newPassword){
		Jugador j = new Jugador(newUsername,newPassword);
		ListaJugadores.nuevoObj(j);
		if(j.Entrar()== true){
			j.crearClan(null);
		}
		else{
			j.conectarseAClan(null,null);
		}
	}
	public void login(String Username,String Password){
	
	}
}