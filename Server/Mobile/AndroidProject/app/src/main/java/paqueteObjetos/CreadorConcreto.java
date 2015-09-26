package paqueteObjetos;

public class CreadorConcreto extends CreadorAbstracto{
	
    public Object factoryMethod(String tipo){
    	
    	Object objeto = null;
    	
    	switch(tipo){
    		
    		case "Madera": objeto =new Madera();
    		break;
    		
    		case "Piedra": objeto =new Piedra();
    		break;
    		
    		case "Hierro": objeto =new Hierro();
    		break;

    		case "Arma1": objeto =new Arma1();
    		break;
    		
    		case "Arma2": objeto =new Arma2();
    		break;
    		
    		case "Bloqueo1": objeto =new Bloqueo1();
    		break;
    		
    		case "Bloqueo2": objeto =new Bloqueo2();
    		break;
    		
    	}
    	return objeto;

    }

}
