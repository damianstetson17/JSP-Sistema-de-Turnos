
package modelo;

import java.util.ArrayList;
import java.util.List;


public class Supervisor extends Persona implements Comparable<Supervisor>{
    
    private Area areaAgregar;
    
    
    public Supervisor(String nombreAgregar, String apellidoAgregar, long dniAgregar) {
		super(nombreAgregar, apellidoAgregar, dniAgregar);
    }

    public Supervisor() {	
    }

    public Supervisor(String nombreAgregar, String apellidoAgregar, long dniAgregar, Area areaAgregar) {
        super(nombreAgregar,apellidoAgregar,dniAgregar);
        this.areaAgregar = areaAgregar;
    }

    public Supervisor(long dniSupervisorBuscar) {
    super(dniSupervisorBuscar);    
    }
    
     //metodo compareTo redefinido, compara por el dni
    @Override
      public int compareTo(Supervisor su){
        long comparacion=0;//por ser int se hace esto, si es string se compara nomas
        comparacion=this.getDni()- su.getDni();//si son iguales devuelve cero
        return (int) comparacion;
    }  
    
    //SETTERS
       public void setAreaAgregar(Area areaAgregar) {
        this.areaAgregar = areaAgregar;
    }

    
    //GETTERS
      public Area getAreaAgregar() {
        return areaAgregar;
    }

    

   
}

