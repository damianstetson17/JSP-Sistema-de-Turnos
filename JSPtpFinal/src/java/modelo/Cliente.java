
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Cliente extends Persona implements Comparable<Cliente> {
   
    private boolean activo;
    private Usuario usuario;
    private List<Turno> turnos= new ArrayList<>();

   
    
    
    public Cliente() {
	}
    
    
    public Cliente(String nombreAgregar, String apellidoAgregar, long dniAgregar, boolean activo,Usuario usuario) {
		super(nombreAgregar,apellidoAgregar,dniAgregar);
                this.activo=true;
                this.usuario = usuario;
    //se llama al constructor persona.
		
	}

    public Cliente(long dniClienteBuscar) {
        super(dniClienteBuscar);}
    
    
	//metodo compareTo redefinido, compara por el dni
    @Override
      public int compareTo(Cliente cli){
        long comparacion=0;
        comparacion=this.getDni()-cli.getDni();		//si son iguales devuelve cero, 
        return (int) comparacion;																
    }  
      
    

    //SETTERS
    

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
   
    public void addtur(Turno turno){
        this.turnos.add(turno);
    }
    
      //GETTERS

    public boolean isActivo() {
        return activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }
    
    
}

