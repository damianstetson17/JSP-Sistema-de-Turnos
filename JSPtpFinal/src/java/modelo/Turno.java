package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Turno implements Comparable<Turno>{
    private long IdTurno;
  
    private Integer nroTurno;
    private Date fechaSolicitud;
    private Date fechaInicioAtencion;
    private Date fechaFinAtencion;
    private EstadoTurno estado;
    private Prioridad prioridad;
    private List<Tramite> tramites= new ArrayList<>();

    public Turno( Integer nroTurno, Date fechaSolicitud, EstadoTurno estado, Prioridad prioridad, Tramite tramite) {
       
        this.nroTurno = nroTurno;
        this.fechaSolicitud = fechaSolicitud;
   
        this.estado = estado;
        this.prioridad = prioridad;
        this.tramites.add(tramite);
        
    }
      

    public Turno(long IdTurno, Integer nroTurno, Date fechaSolicitud, Date fechaInicioAtencion, Date fechaFinAtencion, EstadoTurno estado, Prioridad prioridad, List<Tramite> tramites) {
    
        this.nroTurno = nroTurno;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicioAtencion = fechaInicioAtencion;
        this.fechaFinAtencion = fechaFinAtencion;
        this.estado = estado;
        this.prioridad = prioridad;
        List<Tramite> Ltramites = this.tramites;
    }

    public Turno(Integer nroTurnoAgregar) {
        this.nroTurno = nroTurnoAgregar;
      }

    public Turno() {
        
      }


	//metodo compareTo redefinido, compara con el nro
    @Override
      public int compareTo(Turno tu){
        int comparacion=0;//por ser int se hace esto, si es string se compara nomas
        comparacion=this.nroTurno- tu.getNroTurno();//si son iguales devuelve cero, si es positivo nro inventario es mas grande que el ingresado, si es negativo es mas chico y ahi se ordena
        return comparacion;
    }  
    
    
    
    //SETTERS
    public void setNroTurno(Integer nroTurno) {
        this.nroTurno = nroTurno;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setFechaInicioAtencion(Date fechaInicioAtencion) {
        this.fechaInicioAtencion = fechaInicioAtencion;
    }

    public void setFechaFinAtencion(Date fechaFinAtencion) {
        this.fechaFinAtencion = fechaFinAtencion;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setIdTurno(long IdTurno) {
        this.IdTurno = IdTurno;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    
    public void setTramite(Tramite tramiteAgregar) {
    	this.tramites.add(tramiteAgregar);
    }   
    //GETTERS
    public Integer getNroTurno() {
        return nroTurno;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Date getFechaInicioAtencion() {
        return fechaInicioAtencion;
    }

    public Date getFechaFinAtencion() {
        return fechaFinAtencion;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public long getIdTurno() {
        return IdTurno;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

   
}
