
package modelo;

import errores.NotificarError;
import java.util.ArrayList;
import java.util.List;


public class Tramite implements Comparable<Tramite> {
    private long IdTramite;
    private Integer nroTramite;
    private String nombreTramite;
    private TipoTramite tipoTramite;
    private List<Requisito> requisitosObligatorios= new ArrayList<>();
    private boolean activo;
    
    public Tramite() {
    }
    
    public Tramite(Integer nroTramiteAgregar, String nombreTramiteAgregar, TipoTramite tipoTramAsignar, List<Requisito> requisitosObligatorios) {
	this.nroTramite=nroTramiteAgregar;
	this.nombreTramite=nombreTramiteAgregar;
	this.tipoTramite=tipoTramAsignar;
        this.requisitosObligatorios = requisitosObligatorios;
        this.activo=true;
    }
    
    public Tramite(Integer nroTramiteAgregar, String nombreTramiteAgregar) {
        this.nroTramite = nroTramiteAgregar;
        this.nombreTramite = nombreTramiteAgregar; 
        this.activo=true;
    }

    public Tramite(String nombreTramiteAsignar) {
        this.nombreTramite = nombreTramiteAsignar; 
        this.activo=true;
    }

    //metodo compareTo redefinido, compara con el nro
    @Override
      public int compareTo(Tramite tra){
        int comparacion=0;//por ser int se hace esto, si es string se compara nomas
        comparacion=this.nroTramite- tra.getNroTramite();//si son iguales devuelve cero, si es positivo nro inventario es mas grande que el ingresado, si es negativo es mas chico y ahi se ordena
        return comparacion;
    }  
    
    //SETTERS
    public void setIdTramite(long IdTramite) {
        this.IdTramite = IdTramite;
    }
    public void setNroTramite(Integer nroTramite) {
        this.nroTramite = nroTramite;
    }
    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }
    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
    public void setRequisitosObligatorios(List<Requisito> requisitosObligatorios) {
        this.requisitosObligatorios = requisitosObligatorios;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
       
    //GETTERS

    public long getIdTramite() {
        return IdTramite;
    }
    public boolean isActivo() {
        return activo;
    }
    public Integer getNroTramite() {
        return nroTramite;
    }
    public String getNombreTramite() {
        return nombreTramite;
    }
    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }
    public List<Requisito> getRequisitosObligatorios() {
        return requisitosObligatorios;
    }

}
