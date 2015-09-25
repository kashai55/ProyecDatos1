package paqueteObjetos;
/**
 * 
 * @author Kevin
 * De esta clase hereda de la clase CreadorAbstracto sus metodos
 *
 */
public class CreadorConcreto extends CreadorAbstracto{
	/**
	 * Crea un objeto segun el Objeto que se desee crear
	 * @param recive un string con el nombre de la clase que se desea crear
	 * @return Un objeto creado del tipo del string ingresado
	 */
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
