package cliente;
import Server.*;
import logicaJuego.*;


public class Jugador {

	String userName;
	String password;
	int rango;
	int cantRec;
	Recurso1 r1;
	Recurso2 r2;
	Recurso3 r3;
	
	Lista listaRecursos = new Lista();
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
//	public void solicitudClan(){
//	}
	public void recolectar(Object ele){
		if (ele.equals(r1)){
			listaRecursos.nuevoObj(r1);
			System.out.println("Se ha obtenido 3x de madera");
		}
		else if (ele.equals(r2)){
			listaRecursos.nuevoObj(r2);
			System.out.println("Se ha obtenido 2x de " + r2);
		}
		else{
			listaRecursos.nuevoObj(r3);
			System.out.println("Se ha obtenido 1x de " + r2);
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
