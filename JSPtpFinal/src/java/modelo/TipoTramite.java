
package modelo;


public class TipoTramite implements Comparable<TipoTramite> {
    private String nombreTipoTramite;
    private long IdTipoTramite;
    private boolean activo;

    public TipoTramite() {
    }
    
    public TipoTramite(String nombreTipoTramite) {
       this.nombreTipoTramite = nombreTipoTramite;
       this.activo=true;
    }
    
    //metodo compareTo redefinido
    @Override
    public int compareTo(TipoTramite ti){
         return this.nombreTipoTramite.compareTo(ti.getNombreTipoTramite());
    
    }
    //GETTERS

    public String getNombreTipoTramite() {
        return nombreTipoTramite;
    }

    public long getIdTipoTramite() {
        return IdTipoTramite;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
//SETTERS

    public void setNombreTipoTramite(String nombreTipoTramite) {
        this.nombreTipoTramite = nombreTipoTramite;
    }

    public void setIdTipoTramite(long IdTipoTramite) {
        this.IdTipoTramite = IdTipoTramite;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
   
    
    
}
