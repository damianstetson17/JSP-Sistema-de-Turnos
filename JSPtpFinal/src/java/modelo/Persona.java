
package modelo;


public abstract class Persona {
    
    private String nombre, apellido;
    private boolean activo=true;
    private long dni, idPersona;
    
    
    public Persona() {
	}
    
    public Persona(String nombreAgregar, String apellidoAgregar, long dniAgregar) {
		this.setNombre(nombreAgregar);
		this.apellido=apellidoAgregar;
		this.setDni(dniAgregar);
                this.activo=true;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

        public long getIdPersona() {
            return idPersona;
        }

        public void setIdPersona(long idPersona) {
            this.idPersona = idPersona;
        }

        public Persona(long dni) {
             this.dni = dni;
        }

        public boolean isActivo() {
            return activo;
        }

        public void setActivo(boolean activo) {
            this.activo = activo;
        }

    
    
	
	
}
