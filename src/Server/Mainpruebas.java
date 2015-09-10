package Server;

public class Mainpruebas {
	
	
	public static void main(String[] args) {
		GameLogin log = new GameLogin();
		log.signup("juanito","mora");
		CreadorA aCreador;
		aCreador = new CreadorArmas();
		Armas arma = aCreador.factoryMethod("Arma1");
		arma.operation();
		CreadorR rCreador;
		rCreador= new CreadorRecursos();
		Recursos recurso = rCreador.factoryMethod("Recurso1");
		recurso.operation();
		
		

	}

}
