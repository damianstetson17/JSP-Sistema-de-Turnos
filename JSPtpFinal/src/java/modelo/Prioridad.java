
package modelo;


public class Prioridad implements Comparable<Prioridad> {
    private String nombrePrioridad;
    private long idPrioridad;
    private int nivelPrioridad;
    private boolean activo;
    
    public Prioridad(String prioridadAgregar) {
        this.nombrePrioridad = prioridadAgregar;
        
    }
    public Prioridad(String nombrePrioridad, int nivelPrioridad) {
        this.nombrePrioridad = nombrePrioridad;
        this.nivelPrioridad = nivelPrioridad;
        this.activo=true;
    }
    
    public Prioridad() {
    }
    
       //metodo compareTo redefinido
    @Override
    public int compareTo(Prioridad pri){
     int comparacion = this.nivelPrioridad-pri.getNivelPrioridad();
     return comparacion;
    }
    
    //GETTERS
    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public boolean isActivo() {
        return activo;
    }

    
    //SETTERS
    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }
    
    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    
    
    public long getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(long idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    } 
}
