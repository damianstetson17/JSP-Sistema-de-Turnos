
package modelo;


public class Usuario implements Comparable<Usuario>{
    private long IdUsuario;
    private String  contrasenia, email;
    private boolean activo=true;

     public Usuario( String user,String pass) {
		this.contrasenia=pass;
		this.email=user;
		this.IdUsuario=IdUsuario;
                this.activo=true;
	}

    public Usuario(String user) {
        this.email = user;    
    }

    public Usuario() {
    }
 
	//metodo compareTo redefinido, compara con el cod
    @Override
      public int compareTo(Usuario us){
        return this.email.compareTo(us.getEmail());
    }      
      //SETTERS
 
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUsuario(long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    //GETTERS

    public String getContrasenia() {
        return contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public long getIdUsuario() {
        return IdUsuario;
    } 

    public boolean isActivo() {
        return activo;
    }
    
    
    
}
