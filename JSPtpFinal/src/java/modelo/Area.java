
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Area implements Comparable<Area>{
    private long IdArea;
    private String nombreArea;
    private boolean activo;
    private  List<TipoTramite> tipostramites = new ArrayList<>();

    public Area(String nombreAreaAgregar, List<TipoTramite> tipotramite) {
		this.nombreArea=nombreAreaAgregar;
                this.tipostramites=tipotramite;
                this.activo=true;
    }

    public Area() {
    }

    //metodo compareTo redefinido
    @Override
    public int compareTo(Area ar){
    	return this.nombreArea.compareTo(ar.getNombreArea());
    
    }
 
    //SETTERS
    public void setIdArea(long IdArea) {
        this.IdArea = IdArea;
    }
    public void setTipostramites(List<TipoTramite> tipostramites) {
        this.tipostramites = tipostramites;
    }
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    public void addTramite(List<TipoTramite> tramites){
        this.tipostramites=tramites;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    //GETTERS
    public String getNombreArea() {
        return nombreArea;
    }
    public long getIdArea() {
        return IdArea;
    }
    public List<TipoTramite> getTipostramites() {
        return tipostramites;
    }

    public boolean isActivo() {
        return activo;
    }

    //METODO MODIFICAR
    public void modificarArea(String nuevoNombre, List<TipoTramite>nuevosTipos) {
            this.nombreArea= nuevoNombre;
            this.tipostramites=nuevosTipos;
            
	}
    
    
    
}
