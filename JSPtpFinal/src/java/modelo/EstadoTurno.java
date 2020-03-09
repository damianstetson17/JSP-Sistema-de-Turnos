
package modelo;


public class EstadoTurno implements Comparable<EstadoTurno> {
    private long IdEstadoTurno;
    private String nombreEstado;
    private boolean activo;
    
    public EstadoTurno() {
  	  }

      public EstadoTurno(String nombre) {
    	  this.nombreEstado=nombre;
          this.activo=true;
      }

	//metodo compareTo redefinido
    @Override
    public int compareTo(EstadoTurno est){
         return this.nombreEstado.compareTo(est.getNombreEstado());
    
    }
  
  //GETTERS
  public String getNombreEstado() {
        return nombreEstado;
    }
   public long getIdEstadoTurno() {
        return IdEstadoTurno;
    }

    public boolean isActivo() {
        return activo;
    }
  
    //SETTERS
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   

    public void setIdEstadoTurno(long IdEstadoTurno) {
        this.IdEstadoTurno = IdEstadoTurno;
    }
   
}
