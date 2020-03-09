package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Empleado extends Persona implements Comparable<Empleado>{
  
    private Area areaTrabajo;
    private List<Turno> turnosAtendidos= new ArrayList<>();
    private List<TipoTramite> tipostramites = new ArrayList<>();
    
    //CONSTRUCTORES
    public Empleado(String nombreAgregar, String apellidoAgregar, long dniAgregar) {
		super(nombreAgregar,apellidoAgregar,dniAgregar);	//se llama al constructor persona.	
    }
    public Empleado(String nombreAgregar, String apellidoAgregar, long dniAgregar, Area areaEmple) {
	   super(nombreAgregar,apellidoAgregar,dniAgregar);	//se llama al constructor persona.
	   this.areaTrabajo=areaEmple;
	  
    }
    public Empleado() {
    }
    public Empleado(long dniEmpleadoBuscar) {
        super(dniEmpleadoBuscar);
    }
    //SETTERS
    public void setAreaTrabajo(Area areaTrabajo){
        this.areaTrabajo = areaTrabajo;
    }
    public void setTurnosAtendidos(List<Turno> turnosAtendidos) {
        this.turnosAtendidos = turnosAtendidos;
    }
    public void setTipostramites(List<TipoTramite> tipostramites) {
        this.tipostramites = tipostramites;
    }
    public void agregarTurnoAtendido(Turno t) {
        turnosAtendidos.add(t);
    }
    //GETTERS
    public Area getAreaTrabajo() {
        return areaTrabajo;
    }
    public List<Turno> getTurnosAtendidos() {
        return turnosAtendidos;
    }
    public List<TipoTramite> getTipostramites() {
        return tipostramites;
    }
    
   	//metodo compareTo redefinido, compara por el dni
    @Override
      public int compareTo(Empleado emp){
        long comparacion=0;//por ser int se hace esto, si es string se compara nomas
        comparacion=this.getDni()- emp.getDni();//si son iguales devuelve cero
        return (int) comparacion;
    }   	
}
