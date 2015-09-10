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
	
	Lista listaR = new Lista();
	Lista listaC = new Lista();
	
	public Jugador(String un,String pw){
		userName=un;
		password=pw;
	}
	public void crearClan(String clanName){
		Clan c = new Clan(clanName, null);
		listaC.nuevoObj(c);
		System.out.println(this.getUserName() +  " ha creado el clan");
	}
	public void conectarseAClan(Clan clan,String nombreClan){
		listaC.buscar(nombreClan);
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
			listaR.nuevoObj(r1);
		}
		else if (ele.equals(r2)){
			listaR.nuevoObj(r2);
		}
		else{
			listaR.nuevoObj(r3);
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
