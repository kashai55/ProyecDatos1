package Server;

public class CreadorArmas extends CreadorA{
	
    public Armas factoryMethod(String tipoArma){
    	
    	Armas arma = null;
    	
    	switch(tipoArma){
    		
    		case "Arma1": arma =new Arma1();
    		break;
    		
    		case "Arma2": arma =new Arma2();
    		break;
    		
    	}
    	return arma;

    }
}