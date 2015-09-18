package paqueteObjetos;

public class CreadorConcreto extends CreadorAbstracto{
	
    public Object factoryMethod(String tipo){
    	
    	Object objeto = null;
    	
    	switch(tipo){
    		
    		case "Recurso1": objeto =new Recurso1();
    		break;
    		
    		case "Recurso2": objeto =new Recurso2();
    		break;
    		
    		case "Recurso3": objeto =new Recurso3();
    		break;

    		case "Arma1": objeto =new Arma1();
    		break;
    		
    		case "Arma2": objeto =new Arma2();
    		break;
    	}
    	return objeto;

    }

}
