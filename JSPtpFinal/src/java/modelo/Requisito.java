
package modelo;

public class Requisito implements Comparable<Requisito> {
    private String nombreRequisito;
    private long IdRequisito;
    private boolean activo=true;

    public Requisito() {
    }
       //metodo compareTo redefinido
    @Override
    public int compareTo(Requisito rec){
         return this.nombreRequisito.compareTo(rec.getNombreRequisito());
    
    } 
      //SETTERS
    public void setNombreRequisito(String nombreRequisito) {
        this.nombreRequisito = nombreRequisito;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    //GETTERS
    public String getNombreRequisito() {
        return nombreRequisito;
    }

    public Requisito(String nombreRequisito) {
        this.nombreRequisito = nombreRequisito;
        this.activo=true;
    }

    public long getIdRequisito() {
        return IdRequisito;
    }

    public void setIdRequisito(long IdRequisito) {
        this.IdRequisito = IdRequisito;
    }

    public boolean isActivo() {
        return activo;
    }
    
}
