package Server;
import cliente.*;
public class Mainpruebas {
	
	
	public static void main(String[] args) {
		Recurso1 r1 = new Recurso1();
		GameLogin log = new GameLogin();
		log.signup("juanito","mora");
		Jugador j = new Jugador("lolo", "lala");
		
		CreadorA aCreador;
		aCreador = new CreadorArmas();
		Armas arma = aCreador.factoryMethod("Arma1");
		arma.operation();
		CreadorR rCreador;
		rCreador= new CreadorRecursos();
		Recursos recurso = rCreador.factoryMethod("Recurso1");
		recurso.operation();
		j.recolectar(recurso);
		
		

	}

}
