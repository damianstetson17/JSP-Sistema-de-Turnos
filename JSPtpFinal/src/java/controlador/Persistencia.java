package controlador;

import java.util.List;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import errores.NotificarError;
import java.util.ArrayList;
import modelo.*;

public class Persistencia {

	private final String configuracion = "hibernate.cfg.xml";
	private SessionFactory factory;
	private Session sesion;

	public Persistencia() throws NotificarError {
		this.crearConexion();
	}

	/**
	 * Permite cerrar todas las conexiones activas.
	 * 
	 * @throws NotificarError
	 */
	protected void desconectar() throws NotificarError {
		/*
		 * Primero se cierra la sesi�n.
		 */
		this.cerrarSesion();

		/*
		 * Se cierra la conexi�n a la base de datos desde el sessionFactory.
		 */
		if (this.factory != null) {
			if (this.factory.isOpen()) {
				this.factory.close();
			}
		}
	}

	/**
	 * Permite cerrar la sesi�n actual de la base de datos.
	 * 
	 * @throws NotificarError
	 */
	protected void cerrarSesion() throws NotificarError {
		try {
			if (this.sesion != null) {
				if (this.sesion.isConnected()) {
					this.sesion.disconnect();
				}

				if (this.sesion.isOpen()) {
					this.sesion.close();
				}
			}
		} catch (HibernateException e) {
			throw new NotificarError(e.getMessage());
		}

	}

	/**
	 * Comprueba si la sesi�n est� abierta, caso contrario la abre.
	 * 
	 * @throws NotificarError en caso de que no se puede establecer una conexi�n
	 *                           con la base de datos.
	 */
	protected void comprobarSesion() throws NotificarError {
		String mensaje = null;

		try {
			/*
			 * Se verifica que el factory est� disponible.
			 */
			if (this.factory.isClosed()) {
				/*
				 * Se intenta abrir la conexi�n.
				 */
				this.crearConexion();
			}

			/*
			 * Se verifica si la sesi�n est� disponible.
			 */
			if (this.sesion == null || !this.sesion.isConnected()) {
				/*
				 * Se crea una nueva sesi�n.
				 */
				this.sesion = this.factory.openSession();
			}
		} catch (HibernateException e) {
			mensaje = "Se ha interrumpido la conexi�n con la base de datos.";
			throw new NotificarError(mensaje);
		}
	}

	private void crearConexion() throws NotificarError {
		try {
			this.factory = new Configuration().configure(this.configuracion).buildSessionFactory();
		} catch (HibernateException e) {
			throw new NotificarError(e.getMessage());
		}
	}
	
	/**
	 * Permite guardar o actualizar las modificaciones realizadas a una instancia.
	 * 
	 * @param instancia
	 * @throws NotificarError
	 */
	public void guardarOActualizarInstancia(Object instancia) throws NotificarError {

		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se una transacci�n.
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
                    this.sesion.saveOrUpdate(instancia);
                    tx.commit();
		} catch (HibernateException e) {
                    tx.rollback();
                    throw new NotificarError(e.getMessage());
		}
	}

	/**
	 * Devuelve una lista con los Usuario que existan en la base de datos.
	 * 
	 * @return
	 * @throws NotificarError en caso de alg�n error en la base de datos.
	 */
	public List<Usuario> listarUsuario() throws NotificarError {

		String textoConsulta = "From Usuario T where T.activo = TRUE";
		List<Usuario> lista = null;

		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		try {
			/*
			 * Se crea una consulta.
			 */
			Query<Usuario> consulta = this.sesion.createQuery(textoConsulta, Usuario.class);
			lista = consulta.list();

		} catch (Exception e) {
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}

	
	/**
	 * Permite buscar un Usuario.
	 * 
        * @param email
        * @param contrasenia
    
	 * @return
	 * @throws NotificarError
	 */
	public Usuario buscarUsuario(String email) throws NotificarError {

		String textoConsulta = "From Usuario C where C.email = :email and C.activo = TRUE";

		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		Usuario usuario = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Usuario> consulta = this.sesion.createQuery(textoConsulta, Usuario.class);
			consulta.setParameter("email", email);
			
			List<Usuario> lista = consulta.list();

			if (!lista.isEmpty()) {
				usuario = lista.get(0);
			}

			tx.commit();
                        
                        
		} catch (HibernateException e) {
			tx.rollback();

			throw new NotificarError(e.getMessage());
		}
            return usuario;
		
	}
	
	
	/**
	 * Devuelve una lista con los Turnos que existan en la base de datos.
	 * 
         * @param IdTurno
	 * @return
	 * @throws NotificarError en caso de alg�n error en la base de datos.
	 */
	public List<Turno> listarTurnos(int IdTurno) throws NotificarError {

		String textoConsulta = "From Turno T where T.IdTurno = :IdTurno";
		List<Turno> lista = null;

		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		try {
			/*
			 * Se crea una consulta.
			 */
			Query<Turno> consulta = this.sesion.createQuery(textoConsulta, Turno.class);
			consulta.setParameter("IdTurno",IdTurno );

		} catch (Exception e) {
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}

	/**
	 * Permite listar los turnos.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<Turno> listarTurnos() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Turno";
		List<Turno> lista = null;

		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Turno> consulta = this.sesion.createQuery(textoConsulta, Turno.class);

			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}
	
	/**
	 * Permite buscar un Turno por su numero.
	 * @param nroTurno
	 * @return
	 * @throws NotificarError
	 */
	public Turno buscarTurno(Integer nroTurno) throws NotificarError {
		String textoConsulta = "From Turno T where T.nroTurno = :nroTurno";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();

		Turno turno = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Turno> consulta = this.sesion.createQuery(textoConsulta, Turno.class);
			consulta.setParameter("nroTurno", nroTurno);

			List<Turno> lista = consulta.list();

			if (!lista.isEmpty()) {
				turno = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return turno;
	}

        
        /**
	 * Permite buscar el ultimo numero de turno.
	 * @return
	 * @throws NotificarError
	 */
	public Integer buscarUltimoNroTurno() throws NotificarError {
		String textoConsulta = "Select max(nroTurno) From Turno";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();

		Integer nroturno  = null;
               
		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Integer> consulta = this.sesion.createQuery(textoConsulta, Integer.class);
			List<Integer> lista = consulta.list();
                        if (!lista.isEmpty()) {
				nroturno = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return nroturno;
	}
        
         /**
	 * Permite buscar el ultimo numero de tramite.
	 * @return
	 * @throws NotificarError
	 */
	public Integer buscarUltimoNroTramite() throws NotificarError {
		String textoConsulta = "Select max(nroTramite) From Tramite";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();

		Integer nrotramite  = null;
               
		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Integer> consulta = this.sesion.createQuery(textoConsulta, Integer.class);
			List<Integer> lista = consulta.list();

			if (!lista.isEmpty()) {
				nrotramite = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return nrotramite;
	}
	
        
        /**
	 * Permite buscar todos los turnos pendientes de un cliente.
	 * @return
	 * @throws NotificarError
	 */
	public List<Turno> listarTodosTurnosPendientesCliente(long dni) throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Turno";
		List<Turno> lista = null;
                Cliente cliente = this.buscarCliente(dni);
                List<Turno> turnosPendientes = new ArrayList<>();
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Turno> consulta = this.sesion.createQuery(textoConsulta, Turno.class);
                       
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}
                
                for(Turno tur: lista){
                     if(cliente.getTurnos().contains(tur) && tur.getEstado().getNombreEstado().equals("en espera")){
                         turnosPendientes.add(tur);
                     }
                }
		return turnosPendientes;
	}
        
         /**
	 * Permite buscar todos los turnos de un cliente .
	 * @return
	 * @throws NotificarError
	 */
	public List<Turno> listarTodosTurnosCliente(long dni) throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Turno";
		List<Turno> lista = null;
                Cliente cliente = this.buscarCliente(dni);
                List<Turno> turnos = new ArrayList<>();
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Turno> consulta = this.sesion.createQuery(textoConsulta, Turno.class);
                       
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}
                
                for(Turno tur: lista){
                     if(cliente.getTurnos().contains(tur)){
                        turnos.add(tur);
                     }
                }
		return turnos;
	}
        
        /**
	 * Permite buscar todos los turnos pendientes .
	 * @return
	 * @throws NotificarError
	 */
	public List<Turno> listarTodosTurnosPendientes() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Turno";
		List<Turno> lista = null;
               
                List<Turno> turnosPendientes = new ArrayList<>();
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Turno> consulta = this.sesion.createQuery(textoConsulta, Turno.class);
                       
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}
                
                for(Turno tur: lista){
                     if( tur.getEstado().getNombreEstado().equals("en espera") || tur.getEstado().getNombreEstado().equals("para atencion")){
                         turnosPendientes.add(tur);
                     }
                }
		return turnosPendientes;
	}
        
	/**
	 * Permite buscar un Tramite por su numero.
	 * @param nroTramite
	 * @return
	 * @throws NotificarError
	 */
	public Tramite buscarTramite(long nroTramite) throws NotificarError {
		String textoConsulta = "From Tramite T where T.nroTramite = :nroTramite and T.activo = TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();
             
		Tramite tramite = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Tramite> consulta = this.sesion.createQuery(textoConsulta, Tramite.class);
			consulta.setParameter("nroTramite", nroTramite);
                       // consulta.setParameter("activo", verdadero);
			List<Tramite> lista = consulta.list();

			if (!lista.isEmpty()) {
				tramite = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return tramite;
	}

	/**
	 * Permite listar los Tramites.
	 * 
        * @param IdTramite
	 * @return
	 * @throws NotificarError
	 */
	public List<Tramite> listarTramites(long IdTramite) throws NotificarError {
	
			/*
			 * Se define el texto de la consulta.
			 */
			String textoConsulta = "From Tramite";
			List<Tramite> lista = null;

			/*
			 * Se comprueba la sesión.
			 */
			this.comprobarSesion();

			/*
			 * Se inicia una transacción
			 */
			Transaction tx = this.sesion.beginTransaction();

			try {
				/*
				 * Se crea la consulta.
				 */
				Query<Tramite> consulta = this.sesion.createQuery(textoConsulta, Tramite.class);

				/*
				 * Se carga la lista a partir de la consulta.
				 */
				lista = consulta.list();

				/*
				 * Se finaliza la transacción.
				 */
				tx.commit();

			} catch (PersistenceException e) {
				tx.rollback();
				throw new NotificarError(e.getMessage());
			}

			return lista;
		}
        
        
        
	public List<Tramite> listarTramites() throws NotificarError {
		
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Tramite T where T.activo = TRUE";
		List<Tramite> lista = null;
               
		/*
		 * Se comprueba la sesión.
		 */
		this.comprobarSesion();
                
		/*
		 * Se inicia una transacción
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Tramite> consulta = this.sesion.createQuery(textoConsulta, Tramite.class);
                     
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacción.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}

    
	/**
	 * Permite buscar un Tramites por su nombre.
	 * @param nombreTramite
	 * @return
	 * @throws NotificarError
	 */
	public Tramite buscarTramite(String nombreTramite) throws NotificarError {
		String textoConsulta = "From Tramite T where T.nombreTramite = :nombreTramite and T.activo = TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();
               
		Tramite tramite = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Tramite> consulta = this.sesion.createQuery(textoConsulta, Tramite.class);
			consulta.setParameter("nombreTramite", nombreTramite);
                      
                      
			List<Tramite> lista = consulta.list();

			if (!lista.isEmpty()) {
				tramite = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return tramite;
	}
	
	/**
	 * Permite buscar un TipoTramites por su nombre.
	 * @param nombreTipoTramite
	 * @return
	 * @throws NotificarError
	 */
	public TipoTramite buscarTipoTramite(String nombreTipoTramite) throws NotificarError {
		String textoConsulta = "From TipoTramite T where T.nombreTipoTramite = :nombreTipoTramite and T.activo =TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();
                
		TipoTramite tipotramite = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<TipoTramite> consulta = this.sesion.createQuery(textoConsulta, TipoTramite.class);
			consulta.setParameter("nombreTipoTramite", nombreTipoTramite);
                  
                        
			List<TipoTramite> lista = consulta.list();

			if (!lista.isEmpty()) {
				tipotramite = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return tipotramite;
	}

	/**
	 * Permite listar los TipoTramites.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<TipoTramite> listarTipoTramites() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From TipoTramite T where T.activo = TRUE";
		List<TipoTramite> lista = null;
               
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<TipoTramite> consulta = this.sesion.createQuery(textoConsulta, TipoTramite.class);
                       
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException   e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}

	
	/**
	 * Permite listar todos los TipoTramites de un area.
	 * 
     * @param nombreArea
	 * @return
	 * @throws NotificarError
	 */
	public List<TipoTramite> buscarTipoTramiteDeArea(String nombreArea) throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From TipoTramite T where T.activo = TRUE";
		List<TipoTramite> lista = null;
            
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<TipoTramite> consulta = this.sesion.createQuery(textoConsulta, TipoTramite.class);
                      
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException   e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

                Area area= this.buscarArea(nombreArea);
                List<TipoTramite> tiposdelarea= area.getTipostramites();
                List<TipoTramite> tipostramites= new ArrayList<>();
                
                for(TipoTramite tt: lista){
                    if(tiposdelarea.contains(tt)){
                        tipostramites.add(tt);
                    }
                }
                
                
		return tipostramites;
	}
	
	/**
	 * Permite buscar un TipoPrioridad por su nombre.
	 * @param nombrePrioridad
	 * @return
	 * @throws NotificarError
	 */
	public Prioridad buscarPrioridad(String nombrePrioridad) throws NotificarError {
		String textoConsulta = "From Prioridad T where T.nombrePrioridad = :nombrePrioridad and T.activo = TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();

		Prioridad Prioridad = null;
                  
		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Prioridad> consulta = this.sesion.createQuery(textoConsulta, Prioridad.class);
			consulta.setParameter("nombrePrioridad", nombrePrioridad);
                        
			List<Prioridad> lista = consulta.list();

			if (!lista.isEmpty()) {
				Prioridad = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return Prioridad;
	}

	/**
	 * Permite listar los Prioridad.
	 * @return
	 * @throws NotificarError
	 */
	public List<Prioridad> listarPrioridad() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Prioridad T where T.activo = TRUE";
		List<Prioridad> lista = null;
              
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Prioridad> consulta = this.sesion.createQuery(textoConsulta, Prioridad.class);
                        
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}

	/**
	 * Permite listar los Clientes.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<Cliente> listarCliente() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Cliente T where T.activo = TRUE";
		List<Cliente> lista = null;
               
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Cliente> consulta = this.sesion.createQuery(textoConsulta, Cliente.class);
                       
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();
                        return lista;
		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}	
	}
	/**
	 * Permite buscar un Supervisor por su codigodni.
	 * @param dni
	 * @return
	 * @throws NotificarError
	 */
	public Supervisor buscarSupervisor(long dni) throws NotificarError {
		String textoConsulta = "From Supervisor T where T.dni = :dni and T.activo =TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();
                
		Supervisor supervisor = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Supervisor> consulta = this.sesion.createQuery(textoConsulta, Supervisor.class);
			consulta.setParameter("dni", dni);
                       
			List<Supervisor> lista = consulta.list();

			if (!lista.isEmpty()) {
				supervisor = lista.get(0);
			}
			tx.commit();
                } catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}
		return supervisor;
	}

	/**
	 * Permite listar los Supervisor.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<Supervisor> listarSupervisor() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Supervisor T where T.activo = TRUE";
		List<Supervisor> lista = null;
               
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Supervisor> consulta = this.sesion.createQuery(textoConsulta, Supervisor.class);
                        
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}
        
	/**
	 * Permite buscar un Requisito por su nombre.
	 * @param nombreRequisito
	 * @return
	 * @throws NotificarError
	 */
	public Requisito buscarRequisito(String nombreRequisito) throws NotificarError {
		String textoConsulta = "From Requisito T where T.nombreRequisito = :nombreRequisito and T.activo =TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();

		Requisito requisito = null;
                
		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Requisito> consulta = this.sesion.createQuery(textoConsulta, Requisito.class);
			consulta.setParameter("nombreRequisito", nombreRequisito);
                        
                        
			List<Requisito> lista = consulta.list();

			if (!lista.isEmpty()) {
				requisito = lista.get(0);
			}
			tx.commit();
                        return requisito;
		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		
	}

	/**
	 * Permite listar los Requisito.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<Requisito> listarRequisito() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Requisito T where T.activo = TRUE";
		List<Requisito> lista = null;
              
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();
                
		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Requisito> consulta = this.sesion.createQuery(textoConsulta, Requisito.class);
                       
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}
            return lista;
	}

	/**
	 * Permite buscar un EstadoTurno por su nombre.
	 * @param nombreEstado
	 * @return
	 * @throws NotificarError
	 */
	public EstadoTurno buscarEstadoTurno(String nombreEstado) throws NotificarError {
		String textoConsulta = "From EstadoTurno T where T.nombreEstado = :nombreEstado and T.activo = TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();

		EstadoTurno estadoTurno = null;
               
		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<EstadoTurno> consulta = this.sesion.createQuery(textoConsulta, EstadoTurno.class);
			consulta.setParameter("nombreEstado", nombreEstado);
                       
			List<EstadoTurno> lista = consulta.list();

			if (!lista.isEmpty()) {
				estadoTurno = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return estadoTurno;
	}

	/**
	 * Permite listar los EstadoTurno.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<EstadoTurno> listarEstadoTurno() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From EstadoTurno T where T.activo = TRUE";
		List<EstadoTurno> lista = null;
              
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<EstadoTurno> consulta = this.sesion.createQuery(textoConsulta, EstadoTurno.class);
                     
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}

	/**
	 * Permite buscar un Empleado por su dni.
	 * @param dni
	 * @return
	 * @throws NotificarError
	 */
	public Empleado buscarEmpleado(long dni) throws NotificarError {
		String textoConsulta = "From Empleado E where E.dni = :dni and E.activo = TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();
                
		Empleado empleado = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Empleado> consulta = this.sesion.createQuery(textoConsulta, Empleado.class);
			consulta.setParameter("dni", dni);
                        
			List<Empleado> lista = consulta.list();

			if (!lista.isEmpty()) {
				empleado = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return empleado;
	}
	
	
	/**
	 * Permite listar los Empleado.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<Empleado> listarEmpleado() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Empleado T where T.activo = TRUE";
		List<Empleado> lista = null;
               
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Empleado> consulta = this.sesion.createQuery(textoConsulta, Empleado.class);
                        
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}

	

	/**
	 * Permite buscar un Cliente por su codigodni.
	 * @param dni
	 * @return
	 * @throws NotificarError
	 */
	public Cliente buscarCliente(long dni) throws NotificarError {
		String textoConsulta = "From Cliente C where C.dni = :dni and C.activo = TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();
                
		Cliente cliente = null;

		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Cliente> consulta = this.sesion.createQuery(textoConsulta, Cliente.class);
			consulta.setParameter("dni", dni);
                      
			List<Cliente> lista = consulta.list();

			if (!lista.isEmpty()) {
				cliente = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return cliente;
	}
	
	
	/**
	 * Permite buscar un Area por su nombre.
	 * @param nombreArea
	 * @return
	 * @throws NotificarError
	 */
	public Area buscarArea(String nombreArea) throws NotificarError {
		String textoConsulta = "From Area T where T.nombreArea = :nombreArea and T.activo = TRUE";

		/*
		 * Se comprueba la conexi�n.
		 */
		this.comprobarSesion();

		Area area = null;
                
		Transaction tx = this.sesion.beginTransaction();

		try {
			Query<Area> consulta = this.sesion.createQuery(textoConsulta, Area.class);
			consulta.setParameter("nombreArea", nombreArea);
                      
			List<Area> lista = consulta.list();

			if (!lista.isEmpty()) {
				area = lista.get(0);
			}
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return area;
	}
	
	
	/**
	 * Permite listar los Area.
	 * 
	 * @return
	 * @throws NotificarError
	 */
	public List<Area> listarArea() throws NotificarError {
		/*
		 * Se define el texto de la consulta.
		 */
		String textoConsulta = "From Area T where T.activo = TRUE";
		List<Area> lista = null;
                
		/*
		 * Se comprueba la sesi�n.
		 */
		this.comprobarSesion();

		/*
		 * Se inicia una transacci�n
		 */
		Transaction tx = this.sesion.beginTransaction();

		try {
			/*
			 * Se crea la consulta.
			 */
			Query<Area> consulta = this.sesion.createQuery(textoConsulta, Area.class);
                        
			/*
			 * Se carga la lista a partir de la consulta.
			 */
			lista = consulta.list();

			/*
			 * Se finaliza la transacci�n.
			 */
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw new NotificarError(e.getMessage());
		}

		return lista;
	}
}
