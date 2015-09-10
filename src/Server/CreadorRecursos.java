package Server;

public class CreadorRecursos extends CreadorR{
	
    public Recursos factoryMethod(String tipoRecurso){
    	
    	Recursos recurso = null;
    	
    	switch(tipoRecurso){
    		
    		case "Recurso1": recurso =new Recurso1();
    		break;
    		
    		case "Recurso2": recurso =new Recurso2();
    		break;
    		
    		case "Recurso3": recurso =new Recurso3();
    		break;
    	}
    	return recurso;

    }
}
