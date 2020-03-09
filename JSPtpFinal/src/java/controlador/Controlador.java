package controlador;

import modelo.*;
import java.util.Date;
import errores.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador{
	private Persistencia persistencia;
	
public Controlador(Persistencia persis){
    this.persistencia=persis;
}

//////////////////////////////////////// METODOS BUSCAR ///////////////////////////////////////////

    //BUSCAR ULTIMO NRO TURNO 
        /**
	 * Permite buscar el ultimo numero de los turnos cargados.
         * @return nro
	 * @throws NotificarError
	 */
    public Integer buscarUltimoNroTurno()throws NotificarError{
	Integer nro=persistencia.buscarUltimoNroTurno();
        if(nro==null){
            nro=0;
        }else{
            nro=nro+1;
        }
        return nro;
    }
    
     //BUSCAR ULTIMO NRO   TRAMITE 
    /**
	 * Permite buscar el ultimo numero de los tramites cargados.
         * @return nro
	 * @throws NotificarError
	 */
    public Integer buscarUltimoNroTramite()throws NotificarError{
	Integer nro=persistencia.buscarUltimoNroTramite();
        if(nro==null){
            nro=0;
        }else{
            nro=nro+1;
        }
        return nro;
    }
    
    //BUSCAR  TRAMITES REALIZADOS DE UN AREA
        /**
	 * Permite buscar todos los tramites realizados de un area.
         * @return turnosAtendidos
	 * @throws NotificarError
	 */
        public List<Tramite> buscarTramitesRealizadosDeUnArea(String nombreAreaBuscar) throws NotificarError{
            Area area = persistencia.buscarArea(nombreAreaBuscar);
            List<Turno> turnos= persistencia.listarTurnos();
            List<Tramite> turnosAtendidos = new ArrayList <>();;
          	/*
                A partir de la lista de todos los turnos, recorro cada turno y comparo si su estado 
                 es atendido, si lo es busco la lista de tramites asociadas a ese turno, 
                ya que cada tramite tiene una Lista de TipoTramite por lo cual 
                busco 1 tipoTramite de 1 tramite de 1 turno y comparo si es igual 
                al tipoTramite que tiene el Area elegida, si son iguales, 
                almaceno en una List los Tramites 
              */
            if(area!=null)
            {
                if(turnos!=null)
                {
                    for(Turno tur: turnos){
                        if(tur.getEstado().getNombreEstado().equals("atendido")){
                             for(Tramite tram: tur.getTramites()){
                                 if(area.getTipostramites().contains(tram.getTipoTramite())){
                                     turnosAtendidos.add(tram);
                                 }
                             }  
                         }
                    }
                }
            }
            return turnosAtendidos;
        }

        //LISTADO DE TIPOTRAMITES REALIZADOS POR AREA 
        /**
	 * Permite buscar todos los TiposTramites realizados de un area.
         * @param nombreAreaBuscar
         * @return tipostramites
         * 
	 * @throws NotificarError
	 */
        public List <TipoTramite> tipoTramitesRealizadosPorArea(String nombreAreaBuscar) throws NotificarError{    
            Area area = persistencia.buscarArea(nombreAreaBuscar);
            List<Turno> turnos= persistencia.listarTurnos();
            List<TipoTramite> tipostramites = new ArrayList <>();
            /*
                A partir de la lista de todos los turnos, recorro cada uno y comparo si el estado 
                de ese turno es atendido, si lo cumple busco su lista de tramites, 
                donde cada tramite tiene una Lista de TipoTramite por lo cual 
                busco 1 tipoTramite de 1 tramite de 1 turno y comparo si es igual 
                al tipoTramite que tiene el Area elegida, si son iguales, 
                almaceno en una List tiposTramites ese tipo de tramite
            */
            if(area!=null)
            {
                if(turnos!=null)
                {
                    for(Turno tur: turnos){
                        if(tur.getEstado().getNombreEstado().equals("atendido")){
                             for(Tramite tram: tur.getTramites()){
                                 if(area.getTipostramites().contains(tram.getTipoTramite())){
                                     tipostramites.add(tram.getTipoTramite());
                                 }
                             }  
                         }
                    }
                }
            }
            
            
            return  tipostramites;
            
        }
        
     //BUSCAR TODOS LOS TURNOS PENDIENTES DE UN CLIENTE QUE POSEEN LOS TIPOS TRAMITES APTOS PARA ATENDER POR UN EMPLEADO
        /**
         * Busca todos los turnos pendientes de un cliente que puede resolver el empleado del area especifica.
         * @param dni
         * @return turnospendientes
         * @throws NotificarError 
         */
    public List<Turno> obtenerTurnosPendientesAtenderEmpleado(long dni)throws NotificarError{
        Empleado empleado= persistencia.buscarEmpleado(dni);
        List<Turno> turnos= persistencia.listarTurnos();
        List<Turno> turnospendientes= new ArrayList<>();
        
        if(empleado!=null)
        {
            if(turnos!=null)
            {
                for(Turno turno: turnos){
                    if(turno.getEstado().getNombreEstado().equals("en espera")){
                        for(Tramite tramiteturno: turno.getTramites()){
                            if(empleado.getTipostramites().contains(tramiteturno.getTipoTramite())){
                                turnospendientes.add(turno);
                            }
                        }
                    }
                }
               
            }
            
        } 
        return turnospendientes;   
    }    
    
    public void agregarTurnoAtendidoEmpleado(Integer NroTurno, long dni) throws NotificarError{
        Empleado empleadoBuscar=persistencia.buscarEmpleado(dni);
        Turno turno=persistencia.buscarTurno(NroTurno);
        
        if(empleadoBuscar==null)//si no encontro el empleado
        {
            throw new NotificarError("No se encontro el empleado a agregar el turno atendido");
        }else{
            if(turno==null)//si no encontro el turno
            {
                throw new NotificarError("No se encontro el Turno a agregar a turno atendido del empleado "+empleadoBuscar.getDni());
            }else{
                //si encontro el empleado y el turno
                empleadoBuscar.agregarTurnoAtendido(turno);
                this.persistencia.guardarOActualizarInstancia(empleadoBuscar);
            }
        }
    }
    
    
    
    //BUSCAR TODOS LOS TURNOS DE UN CLIENTE QUE POSEEN LOS TIPOS TRAMITES APTOS PARA ATENDER POR UN EMPLEADO
        /**
         * Busca todos los turnos de un cliente que puede resolver el empleado del area especifica.
         * @param dni
         * @return turnospendientes
         * @throws NotificarError 
         */
    public List<Turno> buscarTurnosEmpleado(long dni)throws NotificarError{
        Empleado empleado= persistencia.buscarEmpleado(dni);
        List<Turno> turnos= persistencia.listarTurnos();
        List<Turno> turnosempleado= new ArrayList<>();
        if(empleado!=null)
        {
            if(turnos!=null)
            {
                for(Turno tur: turnos){
                        for(Tramite tram: tur.getTramites()){
                            if(empleado.getTipostramites().contains(tram.getTipoTramite()) ){
                                turnosempleado.add(tur);
                            }
                             
                        }  
                }
            }
        }
        return turnosempleado;   
    } 
      
    //BUSCAR TODOS LOS TURNOS  DE UN CLIENTE
    /**
     * Busca todos los turnos pendientes de un cliente.
     * @param dni
     * @return
     * @throws NotificarError 
     */
    public List<Turno> obtenerTurnosDeCliente(long dni) throws NotificarError{
 	Cliente cliente =persistencia.buscarCliente(dni);
        List<Turno> turnos = persistencia.listarTodosTurnosCliente(dni);
        List<Turno> turnosPendientes = new ArrayList<>();
        if(!turnos.isEmpty()){
            for(Turno tur: turnos){
                if(cliente.getTurnos().contains(tur) ){
                        turnosPendientes.add(tur);
                    }
                }
        }else{
             throw new NotificarError("Usted no posee turnos");
        }
        return turnosPendientes;
    }
    
    //BUSCAR TODOS LOS TURNOS  DE UN CLIENTE
    /**
     * Busca todos los turnos pendientes de un cliente.
     * @param dni
     * @return
     * @throws NotificarError 
     */
    public List<Turno> obtenerTurnosPendientesDeCliente(long dni) throws NotificarError{
 	Cliente cliente =persistencia.buscarCliente(dni);
        List<Turno> turnos = persistencia.listarTodosTurnosPendientes();
        List<Turno> turnosPendientes = new ArrayList<>();
        if(!turnos.isEmpty()){
            for(Turno tur: turnos){
                if(tur.getEstado().getNombreEstado().equals("baja") || tur.getEstado().getNombreEstado().equals("atendido")){
                    throw new NotificarError("Usted no posee turnos para cancelar");
                }else{
                    if(cliente.getTurnos().contains(tur) ){
                        turnosPendientes.add(tur);
                    }
                }
            } 
        }else{
             throw new NotificarError("Usted no posee turnos para cancelar");
        }
         return turnosPendientes;  
    }
    
 
 //BUSCAR TODOS LOS TURNOS PENDIENTES DE UN CLIENTE CON SU DNI
    /**
     * Busca todos los turnos pendientes.
     * @return turnos
     * @throws NotificarError 
     */
    public List<Turno> listarTurnosPendientesCliente(long dni) throws NotificarError{
 	List<Turno> turnos = persistencia.listarTodosTurnosPendientesCliente(dni);
        return turnos; 
    }
 
    //BUSCAR TODOS LOS TURNOS PENDIENTES 
    /**
     * Busca todos los turnos pendientes.
     * @return turnos
     * @throws NotificarError 
     */
    public List<Turno> listarTurnosPendientes() throws NotificarError{
 	List<Turno> turnos = persistencia.listarTodosTurnosPendientes();
        return turnos;
    }
    
    //BUSCAR TODOS LOS TIPOTRAMITES
    /**
     * Busca todos los TipoTramites.
     * @return tipoTramites
     * @throws NotificarError 
     */
    public List<TipoTramite> buscarTipoTramites() throws NotificarError{
        List<TipoTramite> tipoTramites = persistencia.listarTipoTramites();
 	return tipoTramites;
    }
 
    //BUSCAR TODOS LOS ESTADOS DE TURNO
    /**
     * Busca todos los EstadoTurnos.
     * @return lEstT
     * @throws NotificarError 
     */
    public List<EstadoTurno> buscarEstadsTurnos()throws NotificarError{
        List<EstadoTurno> listaEstadosT = persistencia.listarEstadoTurno();
        return listaEstadosT;
    }
 
    //BUSCAR UN ESTADO TURNO POR SU NOMBRE
    /**
     * Busca un  EstadoTurnos por su nombre.
     * @param nombreEstadoBuscar
     * @return estadoBuscado
     * @throws NotificarError 
     */
    public EstadoTurno buscarUnestadoTurno(String nombreEstadoBuscar) throws NotificarError{
        EstadoTurno estadoBuscado =persistencia.buscarEstadoTurno(nombreEstadoBuscar);
        return estadoBuscado;
    }

    //BUSCAR ESTADO TURNO DE UN TURNO
    /**
     * Busca el EstadoTurnos del turno.
     * @param nroTurnoBuscar
     * @return estadoDelTurno
     * @throws NotificarError 
     */
    public EstadoTurno buscarUnEstadoTurno(Integer nroTurnoBuscar)throws NotificarError{
        Turno turno = persistencia.buscarTurno(nroTurnoBuscar);
	EstadoTurno estadoDelTurno=null;
        if(turno==null)//si no se encontro el turno
	{
            throw new NotificarError("No se encontro el Turno ingresado al que desea buscar el estado.");
	}else{
            estadoDelTurno=turno.getEstado();
	}
	return estadoDelTurno;
    }

    //BUSCAR UN TURNO
    /**
     * Busca un turno.
     * @param nroTurnoBuscar
     * @return estadoDelTurno
     * @throws NotificarError 
     */
    public Turno buscarUnTurno(Integer nroTurnoBuscar) throws NotificarError{
        Turno turno = persistencia.buscarTurno(nroTurnoBuscar);
	return turno; 
    }

    //BUSCAR TURNOS PENDIENTES DE UN CLIENTE
    /**
     * Busca los turnos pendientes de un cliente.
     * @param dniClienteBuscar
     * @return turnosPendientes
     * @throws NotificarError 
     */
    public List<Turno> turnosPendientesCliente(long dniClienteBuscar) throws NotificarError{
        List<Turno> turnosPendientes=new ArrayList <>();
	Cliente clienteABuscar = persistencia.buscarCliente(dniClienteBuscar);
        List<Turno> turnosDelCliente=new ArrayList <>();
        turnosDelCliente=  clienteABuscar.getTurnos();
        if(clienteABuscar==null){
             throw new NotificarError("No el existe el cliente ingresado");
        }
        if(turnosDelCliente==null){
            throw new NotificarError("El cliente ingresado no posee turnos");
        }else{ 
            for(int i=0; i<turnosDelCliente.size(); i++ )
            {
                if(turnosDelCliente.get(i).getEstado().getNombreEstado().equals("en espera")) 
                {
                    turnosDelCliente.add(turnosDelCliente.get(i));
                }
            }
        }   
        return turnosPendientes; 
    }

    //BUSCAR REQUISITOS DE UN TRAMITE
    /**
     * Busca los Requisitos de un Tramite.
     * @param nombreTramiteBuscar
     * @return requisitos
     * @throws NotificarError 
     */
    public List<Requisito> requisitosDeUnTramite(String nombreTramiteBuscar) throws NotificarError{
        Tramite tramiteBuscado=persistencia.buscarTramite(nombreTramiteBuscar);
        List<Requisito> requisitos = new ArrayList <>();
        if(tramiteBuscado!=null)//si existen el tramite en persistencia
        {
            for(Requisito requisito: tramiteBuscado.getRequisitosObligatorios()){
                if(requisito.isActivo()==true){
                    requisitos=tramiteBuscado.getRequisitosObligatorios();
                }
            }   
        }else
            throw new NotificarError("No se encontro el Tramite que se desea obtener sus requisitos.");
        
        return requisitos;       
    }
    
    //BUSCAR TIPOS TRAMITE DE UN AREA
    /**
     * Busca los TiposTramite por un Area.
     * @param nombreAreaBuscar
     * @return tipostramites
     * @throws NotificarError 
     */
    public List<TipoTramite> buscarTipoTramiteArea(String nombreAreaBuscar) throws NotificarError{
        Area area= persistencia.buscarArea(nombreAreaBuscar);
        if(area==null){
            throw new NotificarError("No se encontro el area que desea obtener sus tipos tramites.");
        }else{
            List<TipoTramite> tipostramites =persistencia.buscarTipoTramiteDeArea(nombreAreaBuscar);
            return tipostramites;
        }
    }
    
    //BUSCAR TODOS LOS EMPLEADOS
    /**
     * Busca todos los Empleados.
     * @return empleados
     * @throws NotificarError 
     */
    public List<Empleado> buscarEmpleados() throws NotificarError{
        List<Empleado> empleados = persistencia.listarEmpleado();
 	return empleados;
    }
 
    //BUSCAR DE TODAS LAS AREAS
    /**
     * Busca todos las Areas.
     * @return areas
     * @throws NotificarError 
     */
    public List<Area> buscarAreas() throws NotificarError{
        List<Area> areas = persistencia.listarArea();
 	return areas;
    }
 
    //BUSCAR TODOS LOS SUPERVISORES
    /**
     * Busca todos los Supervisores.
     * @return supervisores
     * @throws NotificarError 
     */
    public List<Supervisor> buscarSupervisores() throws NotificarError{
        List<Supervisor> supervisores = persistencia.listarSupervisor();
 	return supervisores;
    }

    //BUSCAR TODOS LOS USUARIOS
    /**
     * Busca todos los Usuarios.
     * @return usuarios
     * @throws NotificarError 
     */
    public List<Usuario> buscarUsuarios() throws NotificarError{
        List<Usuario> usuarios = persistencia.listarUsuario();
 	return usuarios;
    } 
    
    //BUSCAR TODOS LOS CLIENTES
    /**
     * Busca todos los Clientes.
     * @return clientes
     * @throws NotificarError 
     */
    public List<Cliente> buscarClientes() throws NotificarError{
        List<Cliente> clientes = persistencia.listarCliente();
 	return clientes;
    }

    //BUSCAR TODOS LOS REQUISITOS
    /**
     * Busca todos los Requisitos.
     * @return requisitos
     * @throws NotificarError 
     */
    public List<Requisito> buscarRequisitos() throws NotificarError{
        List<Requisito> requisitos = persistencia.listarRequisito();
 	return requisitos;
    }
  
    //BUSCAR TODAS LAS PRIORIDADES
    /**
     * Busca todos las Prioridades.
     * @return prioridades
     * @throws NotificarError 
     */
    public List<Prioridad> buscarPrioridades() throws NotificarError{
        List<Prioridad> prioridades = persistencia.listarPrioridad();
 	return prioridades;
    }
 
    //BUSCAR TODOS LOS TRAMITES
    /**
     * Busca todos los Tramites.
     * @return tramites
     * @throws NotificarError 
     */
    public List<Tramite> buscarTramites() throws NotificarError{
        List<Tramite> tramites = persistencia.listarTramites();
 	return tramites;
    }
    
    //BUSCAR TODOS LOS TURNOS
    /**
     * Permite buscar todos los Turnos.
     * @return turnos
     * @throws NotificarError 
     */
    public List<Turno> buscarTurnos() throws NotificarError{
        List<Turno> turnos = persistencia.listarTurnos();
 	return turnos;
    }
 
    //BUSCAR TURNOS DE UN CLIENTE
    /**
     * Permite buscar todos los turnos de un cliente.
     * @param dniClienteBuscar
     * @return turnosDelCliente
     * @throws NotificarError 
     */
    public List<Turno> turnosDeUnCliente(long dniClienteBuscar)throws NotificarError{
        Cliente cliente = persistencia.buscarCliente(dniClienteBuscar);
        List<Turno> turnosDelCliente=null;
        if(cliente!=null){
            turnosDelCliente=cliente.getTurnos();
        }else
            throw new NotificarError("No se encontro el cliente ingresado para la busqueda de los turnos.");
            
        return turnosDelCliente;  
    }
        
    //BUSCAR UN TIPOTRAMITE
    /**
     * Permite buscar un TipoTramite.
     * @param nombreTipoTramiteBuscar
     * @return tipotramiteABuscar
     * @throws NotificarError 
     */
    public TipoTramite buscarUnTipoTramite(String nombreTipoTramiteBuscar)throws NotificarError{
	TipoTramite tipotramiteABuscar=persistencia.buscarTipoTramite(nombreTipoTramiteBuscar);
        return tipotramiteABuscar;  
    }
     
    //BUSCAR UN USUARIO
    /**
     * Permite buscar un Usuario.
     * @param email
     * @return usuario
     * @throws NotificarError 
     */
    public Usuario buscarUnUsuario(String email)throws NotificarError{
	Usuario usuario=null;
        usuario = persistencia.buscarUsuario(email);
        return usuario;  
    }
  
    //BUSCAR CLIENTE
    /**
     * Permite buscar un Cliente.
     * @param dniClienteBuscar
     * @return cliente
     * @throws NotificarError 
     */
    public Cliente buscarUnCliente(long dniClienteBuscar)throws NotificarError{
	Cliente cliente = persistencia.buscarCliente(dniClienteBuscar);
        return cliente;   
    }
        
    //BUSCAR CLIENTE DEL USUARIO 
    /**
     * Permite buscar el Cliente perteneciente al usuario con email y contrasenia.
     * @param emailBuscar
     * @param contraseniaBuscar
     * @return ClienteABuscar
     * @throws NotificarError 
     */
    public Cliente buscarUnClienteUsuario(String emailBuscar, String contraseniaBuscar)throws NotificarError{
	List<Cliente> Clientes =persistencia.listarCliente();
        Usuario usuario = persistencia.buscarUsuario(emailBuscar);//busco en persistencia que me retorne el obj a buscar
        Cliente ClienteABuscar = null;
        for(Cliente cli: Clientes){
            if(cli.getUsuario().compareTo(usuario)==0)//si persistencia no lo encontro
            {
                ClienteABuscar = cli;
                break;
            }
        }
        return ClienteABuscar;
    }    
    
    //BUSCAR CLIENTE DEL USUARIO 
    /**
     * Permite buscar el Cliente perteneciente al Usuario.
     * @param unUsuario
     * @return ClienteABuscar
     * @throws NotificarError 
     */
    public Cliente buscarClienteDelUsuario(Usuario unUsuario)throws NotificarError{
	
            List<Cliente> Clientes =persistencia.listarCliente();
           
            Cliente ClienteABuscar = null;
            for(Cliente cli: Clientes){
                if(cli.getUsuario().compareTo(unUsuario)==0)//si persistencia  lo encontro
                {
                    ClienteABuscar = cli;
                    break;
                }
            }
            return ClienteABuscar;
        
    }    
    
    
    //BUSCAR EMPLEADO
    /**
     * Permite busar un Empleado.
     * @param dniEmpleadoBuscar
     * @return empleado
     * @throws NotificarError 
     */
    public Empleado buscarUnEmpleado(long dniEmpleadoBuscar)throws NotificarError{
       
            Empleado empleado= persistencia.buscarEmpleado(dniEmpleadoBuscar);
           
               return empleado; 
           
    }
    
    //BUSCAR SUPERVISOR
    /**
     * Permite buscar un Supervisor.
     * @param dniSupervisorBuscar
     * @return supervisor
     * @throws NotificarError 
     */
    public Supervisor buscarUnSupervisor(long dniSupervisorBuscar)throws NotificarError{
            Supervisor supervisor= persistencia.buscarSupervisor(dniSupervisorBuscar);
            return supervisor;     
    }
         
    // BUSCAR REQUISITO
    /**
     * Permite buscar un Requisito.
     * @param nombrerequisito
     * @return requisito
     * @throws NotificarError 
     */
    public Requisito buscarRequisito(String nombrerequisito )throws NotificarError{
        Requisito requisito= persistencia.buscarRequisito(nombrerequisito);
        return requisito;  
    }
    
    //BUSCAR AREA
    /**
     * Permite buscar un Area.
     * @param nombreAreaBuscar
     * @return area
     * @throws NotificarError 
     */
    public Area buscarUnArea(String nombreAreaBuscar)throws NotificarError{
        Area area= persistencia.buscarArea(nombreAreaBuscar);
        return area;     
    }
        
    //BUSCAR UN TRAMITE
    /**
     * Permite buscar un Tramite.
     * @param nombreTramiteBuscar
     * @return tramite
     * @throws NotificarError 
     */
    public Tramite buscarUntramite(String nombreTramiteBuscar) throws NotificarError{
	Tramite tramite= persistencia.buscarTramite(nombreTramiteBuscar);
        return tramite;     
    }

    //BUSCAR UNA PRIORIDAD
    /**
     * Permite buscar una Prioridad.
     * @param nombrePrioridadBuscado
     * @return prioridad
     * @throws NotificarError 
     */
    public Prioridad buscarUnaPrioridad(String nombrePrioridadBuscado) throws NotificarError{
	Prioridad prioridad= persistencia.buscarPrioridad(nombrePrioridadBuscado);
        return prioridad;     
    }

//////////////////////////////////////// METODOS CREAR ////////////////////////////////////////////
    //CREAR UN TURNO
    /**
     * Permite crear un Turno.
     * @param fechaSolicitudAgregar
     * @param nombreEstadoAgregar
     * @param prioridadAgregar
     * @param nombreTramiteAgregar
     * @param cliente
     * @throws NotificarError 
     */
    public void creaUnTurno(Date fechaSolicitudAgregar,String nombreEstadoAgregar,String prioridadAgregar,String nombreTramiteAgregar, Cliente cliente)throws NotificarError
    {
            String mensaje = null;  
            /*
            * Pide a la persistencia que inicie la sesiÃ³n.
            */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de turno con los datos.
		 */
		Tramite tramite = this.buscarUntramite(nombreTramiteAgregar);
                Prioridad prioridad=this.buscarUnaPrioridad(prioridadAgregar);
                EstadoTurno estadoturno = this.buscarUnestadoTurno(nombreEstadoAgregar);
                Integer nroTurnoAgregar= this.buscarUltimoNroTurno();
                
                Turno turnoAgregar = new Turno(nroTurnoAgregar,fechaSolicitudAgregar,estadoturno,prioridad,tramite);
                
                /*
		 * Se comprueba que no exista el turno.
		 */
		Turno duplicado = this.buscarUnTurno(nroTurnoAgregar);
                
		if (duplicado != null) {
			/*
			 * Significa que ya existe el turno.
			 */
			mensaje = String.format("Ya existe el turno: %s.", turnoAgregar.getNroTurno());
			throw new NotificarError(mensaje);
		}

		/*
		 */
                               
		this.persistencia.guardarOActualizarInstancia(turnoAgregar);
                
                cliente.addtur(turnoAgregar);
                this.persistencia.guardarOActualizarInstancia(cliente);
		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();
	}
    
    
    //CREAR UN AREA
    /**
     * Permite crear un Area.
     * @param nombreAreaAgregar
     * @param tipotramites
     * @throws NotificarError 
     */
    public void crearUnArea(String nombreAreaAgregar,List<TipoTramite> tipotramites) throws NotificarError{
                String mensaje;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de area con los datos.
		 */
		 
                
                 Area AreaAgregar = new Area(nombreAreaAgregar,tipotramites);
		/*
		 * Se comprueba que no exista el area.
		 */
		Area duplicado = this.buscarUnArea(nombreAreaAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el area.
			 */
			mensaje = String.format("Ya existe el Area: %s.", AreaAgregar.getNombreArea());
			throw new NotificarError(mensaje);
		}
                /*
		 * Se le pide a la persistencia que guarde el Area.
		 */
		this.persistencia.guardarOActualizarInstancia(AreaAgregar);
                /*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();
	}
             
             
    //CREAR UN CLIENTE
    /**
	 * Permite crear un Usuario.
         * @param email
         * @param contrasenia
	 * @throws NotificarError
	 */
    public void crearUnCliente(String nombreAgregar, String apellidoAgregar, long dniAgregar, boolean activo, Usuario usuario)throws NotificarError {
         String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de cliente con los datos.
		 */
		 
                 Cliente clienteAgregar = new Cliente(nombreAgregar,apellidoAgregar,dniAgregar,activo,usuario);
		/*
		 * Se comprueba que no exista el cliente.
		 */
		Cliente duplicado = this.buscarUnCliente(dniAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el cliente.
			 */
			mensaje = String.format("Ya existe el cliente: %s.", clienteAgregar.getNombre());
			throw new NotificarError(mensaje);
		}

		/*
		 * Se le pide a la persistencia que guarde el cliente.
		 */
		this.persistencia.guardarOActualizarInstancia(clienteAgregar);

		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();
        
    }
    
    //CREAR UN USUARIO
    /**
	 * Permite crear un Usuario.
         * @param email
         * @param contrasenia
	 * @throws NotificarError
	 */
    public void crearUnUsuario(String email, String contrasenia)throws NotificarError{
        
            String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de usuario con los datos.
		 */
		 
              Usuario usuarioAAgregar=new Usuario(email,contrasenia);;
		/*
		 * Se comprueba que no exista el usuario.
		 */
		Usuario duplicado = this.buscarUnUsuario(email);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el usuario.
			 */
			mensaje = String.format("Ya existe el cliente: %s.", usuarioAAgregar.getEmail());
			throw new NotificarError(mensaje);
		}
                /*
		 * Se le pide a la persistencia que guarde el usuario.
		 */
		this.persistencia.guardarOActualizarInstancia(usuarioAAgregar);

		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();
            
        }
    
    //CREAR UN EMPLEADO
     /**
	 * Permite crear un Empleado.
         * @param nombreAgregar
         * @param apellidoAgregar
         * @param dniAgregar
         * @param nombreArea
	 * @throws NotificarError
	 */
    public void crearUnEmpleado(String nombreAgregar, String apellidoAgregar, long dniAgregar,String nombreArea)throws NotificarError {
             
            String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de empleado con los datos.
		 */
                Area area = this.buscarUnArea(nombreArea);
                List<TipoTramite> tipostramites= new ArrayList<>();
                tipostramites.addAll(area.getTipostramites());
                Empleado empleadoAAgregar = new Empleado(nombreAgregar,apellidoAgregar,dniAgregar, area);
		empleadoAAgregar.setTipostramites(tipostramites);
                /*
		 * Se comprueba que no exista el empleado.
		 */
		Empleado duplicado = this.buscarUnEmpleado(dniAgregar);
                
		if (duplicado != null) {
			/*
			 * Significa que ya existe el empleado.
			 */
			mensaje = String.format("Ya existe el empleado: %s.", empleadoAAgregar.getNombre());
			throw new NotificarError(mensaje);
		}

		/*
		 * Se le pide a la persistencia que guarde el empleado.
		 */
		this.persistencia.guardarOActualizarInstancia(empleadoAAgregar);

		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();
                  
    }    
        
    //CREAR UNA PRIORIDAD
    /**
	 * Permite crear una Prioridad.
         * @param nombrePrioridadAgregar
         * @param lvlPrioridad
	 * @throws NotificarError
	 */
    public void crearUnaPrioridad(String nombrePrioridadAgregar, int lvlPrioridad)throws NotificarError{
        
              String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de prioridad con los datos.
		 */
                Prioridad prioridad = new Prioridad(nombrePrioridadAgregar,lvlPrioridad);
		/*
		 * Se comprueba que no exista la prioridad.
		 */
		Prioridad duplicado = this.buscarUnaPrioridad(nombrePrioridadAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe la prioridad.
			 */
			mensaje = String.format("Ya existe el empleado: %s.", prioridad.getNombrePrioridad());
			throw new NotificarError(mensaje);
		}

		/*
		 * Se le pide a la persistencia que guarde la prioridad
		 */
		this.persistencia.guardarOActualizarInstancia(prioridad);

		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();    
           
    }
        
    //CREAR UN ESTADO TURNO
    /**
	 * Permite crear un EstadoTurno.
         * @param nombreEstadoAgregar
	 * @throws NotificarError
	 */
    public void crearUnEstadoTurno(String nombreEstadoAgregar)throws NotificarError{
                String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de estadoturno con los datos.
		 */
                EstadoTurno estadoturno = new EstadoTurno(nombreEstadoAgregar);
		/*
		 * Se comprueba que no exista la prioridad.
		 */
		EstadoTurno duplicado = this.buscarUnestadoTurno(nombreEstadoAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el estadoturno.
			 */
			mensaje = String.format("Ya existe el empleado: %s.", estadoturno.getNombreEstado());
			throw new NotificarError(mensaje);
		}

		/*
		 * Se le pide a la persistencia que guarde el estadoturno
		 */
		this.persistencia.guardarOActualizarInstancia(estadoturno);

		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();    
           
    }
        
    
    //CREAR UN REQUISITO
     /**
	 * Permite crear un Requisito.
         * @param nombreRequisitoAgregar
	 * @throws NotificarError
	 */
    public void crearUnRequisito(String nombreRequisitoAgregar)throws NotificarError{
                String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de requisito con los datos.
		 */
                Requisito requisito = new Requisito(nombreRequisitoAgregar);
		/*
		 * Se comprueba que no exista el requisito.
		 */
		Requisito duplicado = this.buscarRequisito(nombreRequisitoAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el requisito.
			 */
			mensaje = String.format("Ya existe el requisito: %s.", requisito.getNombreRequisito());
			throw new NotificarError(mensaje);
		}
		/*
		 * Se le pide a la persistencia que guarde el requisito
		 */
		this.persistencia.guardarOActualizarInstancia(requisito);
		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion(); 
        
    }
    
    //CREAR UN TIPOTRAMITE
     /**
	 * Permite crear un TipoTramite.
         * @param nombreTipoTramiteAgregar
	 * @throws NotificarError
	 */
    public void crearUnTipoTramite(String nombreTipoTramiteAgregar)throws NotificarError{
        
             String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de TipoTramite con los datos.
		 */
               TipoTramite TipoTramiteAAgregar= new TipoTramite(nombreTipoTramiteAgregar);
		/*
		 * Se comprueba que no exista el TipoTramiteAAgregar.
		 */
		TipoTramite duplicado = this.buscarUnTipoTramite(nombreTipoTramiteAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el TipoTramiteAAgregar.
			 */
			mensaje = String.format("Ya existe el Tipo Tramite: %s.", TipoTramiteAAgregar.getNombreTipoTramite());
			throw new NotificarError(mensaje);
		}

		/*
		 * Se le pide a la persistencia que guarde el TipoTramiteAAgregar
		 */
                
		this.persistencia.guardarOActualizarInstancia(TipoTramiteAAgregar);
             
		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion(); 
    }
    
    //CREAR UN TRAMITE
    /**
	 * Permite crear un Tramite.
         * @param nroTramiteAgregar
          * @param nombreTramiteAgregar
          * @param nombreTipoTramiteAsignar
          * @param requisitosObli
	 * @throws NotificarError
	 */
    public void crearUnTramite(Integer nroTramiteAgregar, String nombreTramiteAgregar,String nombreTipoTramiteAsignar,List<Requisito> requisitosObli)throws NotificarError{
                
           String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de Tramite con los datos.
		 */
              TipoTramite tipotramite= this.buscarUnTipoTramite(nombreTipoTramiteAsignar);
              Tramite tramiteAAgregar = new Tramite(nroTramiteAgregar,nombreTramiteAgregar, tipotramite,requisitosObli );
		/*
		 * Se comprueba que no exista el tramiteAAgregar.
		 */
		Tramite duplicado = this.buscarUntramite(nombreTramiteAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el tramiteAAgregar.
			 */
			mensaje = String.format("Ya existe el empleado: %s.", tramiteAAgregar.getNombreTramite());
			throw new NotificarError(mensaje);
		}

		/*
		 * Se le pide a la persistencia que guarde el tramiteAAgregar
		 */
		this.persistencia.guardarOActualizarInstancia(tramiteAAgregar);

		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion(); 
        
    }

    
    //CREAR UN SUPERVISOR
    /**
	 * Permite crear un Supervisor.
         * @param nombreAgregar
          * @param apellidoAgregar
          * @param dniAgregar
          * @param nombreArea
	 * @throws NotificarError
	 */
    public void crearUnSupervisor(String nombreAgregar, String apellidoAgregar, long dniAgregar,String nombreArea)throws NotificarError {
              
              String mensaje = null;  
		/*
		 * Pide a la persistencia que inicie la sesiÃ³n.
		 */
		this.persistencia.comprobarSesion();

		/*
		 * Se crea una instancia de Supervisor con los datos.
		 */
             Area area = this.buscarUnArea(nombreArea);
            Supervisor supervisorAAgregar = new Supervisor(nombreAgregar,apellidoAgregar,dniAgregar, area);
		/*
		 * Se comprueba que no exista el Supervisor.
		 */
		Supervisor duplicado = this.buscarUnSupervisor(dniAgregar);

		if (duplicado != null) {
			/*
			 * Significa que ya existe el Supervisor.
			 */
			mensaje = String.format("Ya existe el empleado: %s.", supervisorAAgregar.getNombre());
			throw new NotificarError(mensaje);
		}

		/*
		 * Se le pide a la persistencia que guarde el Supervisor
		 */
		this.persistencia.guardarOActualizarInstancia(supervisorAAgregar);

		/*
		 * Se le pide a la persistencia que cierre la sesiÃ³n.
		 */
		this.persistencia.cerrarSesion();        
    } 

      
    //////////////////////////////////////// METODOS ACTUALIZAR / MODIFICAR ///////////////////////////////////////
    
    //ACTUALIZAR AREA
    /**
	 * Permite cambiar los atributos de un Area.
         * @param nombreArea
          * @param nuevoNombreArea
          * @param tramitesAgregar
	 * @throws NotificarError
	 */
    public void actualizaUnArea(String nombreArea,String nuevoNombreArea, List<TipoTramite> tramitesAgregar)throws NotificarError{
	
        this.persistencia.comprobarSesion();
		String mensaje = null;
               
                Area area = this.buscarUnArea(nombreArea);
		Area duplicado = this.buscarUnArea(nuevoNombreArea);
                
		if (duplicado != null && duplicado.compareTo(area) != 0) {
			mensaje = String.format("Ya existe el Area: %s.", area.getNombreArea());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         area.modificarArea(nuevoNombreArea,tramitesAgregar);
                   
                }else{
                   if(area.getNombreArea().equals(duplicado.getNombreArea())){
                    area.modificarArea(nuevoNombreArea,tramitesAgregar);  
                }
               }
		
		this.persistencia.guardarOActualizarInstancia(area);
		this.persistencia.cerrarSesion();
                

}

    //MODIFICAR UN ESTADO TURNO
    /**
	 * Permite cambiar los atributos de un turno.
         * @param nroTurno
          * @param nuevoNombreEstadoTurno
	 * @throws NotificarError
	 */
    public void modificarEstadoTurno(int nroTurno,String nuevoNombreEstadoTurno) throws NotificarError{
	
	Turno TurnoModif=this.buscarUnTurno(nroTurno);
        EstadoTurno estado =this.buscarUnestadoTurno(nuevoNombreEstadoTurno);
        
        if(estado.getNombreEstado().equals("baja") || estado.getNombreEstado().equals("atendido")){
            java.util.Date fechafin= new java.util.Date();
            TurnoModif.setFechaFinAtencion(fechafin);
        }else{
            if(estado.getNombreEstado().equals("en espera") || estado.getNombreEstado().equals("para atencion") || estado.getNombreEstado().equals("atendiendo")){
                java.util.Date fechainicio = new java.util.Date();
                TurnoModif.setFechaInicioAtencion(fechainicio);
            }
        }
                        
        TurnoModif.setEstado(estado);
        persistencia.guardarOActualizarInstancia(TurnoModif);
	
    }

    
    
    
    
    
    
    
    //MODIFICAR UNA PRIORIDAD
         /**
	 * Permite modificar los atributos uno de una Prioridad.
     * @param nombreActual
         * @param nombrePrioridadModificar
         * @param nivelPrioridadModificar
	 * @throws NotificarError
	 */
    public void actualizarPrioridad(String nombreActual, String nombrePrioridadModificar, Integer nivelPrioridadModificar) throws NotificarError{
            persistencia.comprobarSesion();
		String mensaje = null; 
                Prioridad prioridad = this.buscarUnaPrioridad(nombreActual);
		Prioridad duplicado = this.buscarUnaPrioridad(nombrePrioridadModificar);
          
		if (duplicado != null && duplicado.compareTo(prioridad) != 0) {
			mensaje = String.format("Ya existe la Prioridad: %s.", prioridad.getNombrePrioridad());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         prioridad.setNombrePrioridad(nombrePrioridadModificar);
                         prioridad.setNivelPrioridad(nivelPrioridadModificar);    
                }else{
                   if(prioridad.getNombrePrioridad().equals(duplicado.getNombrePrioridad())){
                    prioridad.setNombrePrioridad(nombrePrioridadModificar);
                    prioridad.setNivelPrioridad(nivelPrioridadModificar);  
                }
               }
		persistencia.guardarOActualizarInstancia(prioridad);
		persistencia.cerrarSesion();
        persistencia.cerrarSesion();
    }
    
    //MODIFICAR UN EMPLEADO
    /**
	 * Permite modificar los atributos de un Empleado.
         * @param dniEmpleado
         * @param datosEmpleadoModificar
	 * @throws NotificarError
	 */
    public void actualizaUnEmpleado(long dniEmpleado,Empleado datosEmpleadoModificar) throws NotificarError{
            persistencia.comprobarSesion();
		String mensaje;             
                Empleado empleado = this.buscarUnEmpleado(dniEmpleado);
		Empleado duplicado = this.buscarUnEmpleado(datosEmpleadoModificar.getDni());
                
		if (duplicado != null && duplicado.compareTo(empleado) != 0) {
			mensaje = String.format("Ya existe el Empleado: %d.", empleado.getDni());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         empleado.setNombre(datosEmpleadoModificar.getNombre());
                         empleado.setApellido(datosEmpleadoModificar.getApellido());
                         empleado.setDni(datosEmpleadoModificar.getDni());
                         empleado.setAreaTrabajo(datosEmpleadoModificar.getAreaTrabajo());  
                         empleado.setTipostramites(datosEmpleadoModificar.getTipostramites());      
                }else{
                    if((empleado.getDni()-duplicado.getDni())==0){
                    //empleado=datosEmpleadoModificar;   
                    empleado.setNombre(datosEmpleadoModificar.getNombre());
                         empleado.setApellido(datosEmpleadoModificar.getApellido());
                         empleado.setDni(datosEmpleadoModificar.getDni());
                         empleado.setAreaTrabajo(datosEmpleadoModificar.getAreaTrabajo());  
                         empleado.setTipostramites(datosEmpleadoModificar.getTipostramites());
                    }
               }
	    persistencia.guardarOActualizarInstancia(empleado);
            persistencia.cerrarSesion();
    }
    
    //ACTUALIZAR ESTADO TURNO
    /**
	 * Permite modificar los atributos de un EstadoTurno.
         * @param nombreActual
         * @param nuevoNombre
	 * @throws NotificarError
	 */
    public void actualizarEstadoTurno(String nombreActual, String nuevoNombre) throws NotificarError{
            persistencia.comprobarSesion();
		String mensaje; 
                EstadoTurno estadoturno = this.buscarUnestadoTurno(nombreActual);
		EstadoTurno duplicado = this.buscarUnestadoTurno(nuevoNombre);
          
		if (duplicado != null && duplicado.compareTo(estadoturno) != 0) {
			mensaje = String.format("Ya existe el estadoturno: %s.", estadoturno.getNombreEstado());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         estadoturno.setNombreEstado(nuevoNombre);   
                }else{
                   if(estadoturno.getNombreEstado().equals(duplicado.getNombreEstado())){
                    estadoturno.setNombreEstado(nuevoNombre); 
                }
               }
		persistencia.guardarOActualizarInstancia(estadoturno);
		
        persistencia.cerrarSesion();
    }
    
    //ACTUALIZAR REQUISITO
    /**
	 * Permite modificar los atributos de un Requisito.
         * @param nombreActual
         * @param nuevoNombre
	 * @throws NotificarError
	 */
    public void actualizarRequisito(String nombreActual, String nuevoNombre) throws NotificarError{
        persistencia.comprobarSesion();
		String mensaje; 
                Requisito requisito = this.buscarRequisito(nombreActual);
		Requisito duplicado = this.buscarRequisito(nuevoNombre);
          
		if (duplicado != null && duplicado.compareTo(requisito) != 0) {
			mensaje = String.format("Ya existe el estadoturno: %s.", requisito.getNombreRequisito());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         requisito.setNombreRequisito(nuevoNombre);   
                }else{
                   if(requisito.getNombreRequisito().equals(duplicado.getNombreRequisito())){
                    requisito.setNombreRequisito(nuevoNombre); 
                }
               }
		persistencia.guardarOActualizarInstancia(requisito);
		
        persistencia.cerrarSesion();
    }
    
    //ACTUALIZAR UN SUPERVISOR
    /**
	 * Permite modificar los atributos de un Supervisor.
         * @param dniSupervisor
         * @param datosSupervisorModificar
	 * @throws NotificarError
	 */
    public void actualizarSupervisor(long dniSupervisor, Supervisor datosSupervisorModificar) throws NotificarError{
         persistencia.comprobarSesion();
		String mensaje;             
                Supervisor supervisor = this.buscarUnSupervisor(dniSupervisor);
		Supervisor duplicado = this.buscarUnSupervisor(datosSupervisorModificar.getDni());
                
		if (duplicado != null && duplicado.compareTo(supervisor) != 0) {
			mensaje = String.format("Ya existe el Supervisor: %d.", supervisor.getDni());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         supervisor.setNombre(datosSupervisorModificar.getNombre());
                         supervisor.setApellido(datosSupervisorModificar.getApellido());
                         supervisor.setDni(datosSupervisorModificar.getDni());
                         supervisor.setAreaAgregar(datosSupervisorModificar.getAreaAgregar());
                }else{
                   if((supervisor.getDni()-duplicado.getDni())==0){
                    supervisor.setNombre(datosSupervisorModificar.getNombre());
                    supervisor.setApellido(datosSupervisorModificar.getApellido());
                    supervisor.setDni(datosSupervisorModificar.getDni());
                    System.out.println(datosSupervisorModificar.getAreaAgregar().getNombreArea());
                    supervisor.setAreaAgregar(datosSupervisorModificar.getAreaAgregar());   
                }
               }
		persistencia.guardarOActualizarInstancia(supervisor);
		
        persistencia.cerrarSesion();
    }
    
    //ACTUALIZAR UN TIPO TRAMITE
    /**
	 * Permite modificar los atributos de un TipoTramite.
         * @param nombreActual
         * @param nuevoNombre
	 * @throws NotificarError
	 */
    public void actualizarTipoTramite(String nombreActual, String nuevoNombre) throws NotificarError{
        persistencia.comprobarSesion();
		String mensaje; 
                TipoTramite tipotramite = this.buscarUnTipoTramite(nombreActual);
		TipoTramite duplicado = this.buscarUnTipoTramite(nuevoNombre);
          
		if (duplicado != null && duplicado.compareTo(tipotramite) != 0) {
			mensaje = String.format("Ya existe el estadoturno: %s.", tipotramite.getNombreTipoTramite());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         tipotramite.setNombreTipoTramite(nuevoNombre);   
                }else{
                   if(tipotramite.getNombreTipoTramite().equals(duplicado.getNombreTipoTramite())){
                    tipotramite.setNombreTipoTramite(nuevoNombre); 
                }
               }
		persistencia.guardarOActualizarInstancia(tipotramite);
		persistencia.cerrarSesion();
     
    }
    
    //ACTUALIZAR UN TRAMITE
    /**
	 * Permite modificar los atributos de un Tramite.
         * @param nombreActual
     * @param nuevoNombre
     * @param nombretipotramite
     * @param requisitos
	 * @throws NotificarError
	 */
    public void actualizarTramite(String nombreActual,String nuevoNombre,String nombretipotramite, List<Requisito> requisitos)throws NotificarError{
        persistencia.comprobarSesion();
        String mensaje; 
                Tramite tramite = this.buscarUntramite(nombreActual);
		Tramite duplicado = this.buscarUntramite(nuevoNombre);
                TipoTramite tipoTramite = this.buscarUnTipoTramite(nombretipotramite);
                if(tipoTramite==null){
                    mensaje = String.format("No se encontro el TipoTramite: %s.", nombretipotramite);
			throw new NotificarError(mensaje);
                }
		if (duplicado != null && duplicado.compareTo(tramite) != 0) {
			mensaje = String.format("Ya existe el estadoturno: %s.", tramite.getNombreTramite());
			throw new NotificarError(mensaje);
		}
               if(duplicado==null){
                         tramite.setNombreTramite(nuevoNombre);   
                         tramite.setTipoTramite(tipoTramite);
                         tramite.setRequisitosObligatorios(requisitos);
                }else{
                   if(tramite.getNombreTramite().equals(duplicado.getNombreTramite())){
                    tramite.setNombreTramite(nuevoNombre);   
                    tramite.setTipoTramite(tipoTramite);
                    tramite.setRequisitosObligatorios(requisitos); 
                }
               }
        persistencia.guardarOActualizarInstancia(tramite);
        persistencia.cerrarSesion();
    }
    
    //REASIGNAR UN TURNO
    /**
	 * Permite asignar al Turno un nuevo tramite (lo agrega a su lista "Tramites").
         * @param nroTurno
         * @param nombreTramiteNuevo
	 * @throws NotificarError
	 */
    public void reasignarUnTurno(int nroTurno, String nombreTramiteNuevo)throws NotificarError{
        try{
            persistencia.comprobarSesion();
            Turno turno = persistencia.buscarTurno(nroTurno);
            Tramite tramiteAsignar = persistencia.buscarTramite(nombreTramiteNuevo);
            
            if(turno!=null)//si lo encontro
            {
                if(tramiteAsignar!=null)//si lo encontro
                {
                    turno.setTramite(tramiteAsignar);
                    persistencia.guardarOActualizarInstancia(turno);
                }else{
                  throw new NotificarError("No se encontro el Tramite a asignar al turno.");  
                }
            }else{
                throw new NotificarError("No se encontro el Turno a modificar.");
            }
        }catch(NotificarError ex) {
                throw new NotificarError(ex.getMessage());
            }
        persistencia.cerrarSesion();
    }
    
    //////////////////////////////////////// METODOS BORRAR ///////////////////////////////////////

    //CANCELAR UN TURNO 
    /**
	 * Permite cambiar el estado de un turno a "baja".
         * @param nroTurnoAct
	 * @throws NotificarError
	 */
    public void cancelarUnTurno(Integer nroTurnoAct) throws NotificarError{
	try{
            Turno turnoACancelar = persistencia.buscarTurno(nroTurnoAct);
            EstadoTurno et=persistencia.buscarEstadoTurno("baja");
            if(turnoACancelar!=null){
                turnoACancelar.setEstado(et);
                persistencia.guardarOActualizarInstancia(turnoACancelar);
            }else
                 throw new NotificarError("No se encontro el Turno a cancelar.");
        }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
        } 
    }   

 
    /**
     * TODOS LOS METODOS A CONTINUACION, RECIBEN UN OBJETO, 
     * CAMBIAN SU ESTADO A FALSE (INACTIVO)
     * Y GUARDAN EL OBJETO EN PERSISTENCIA
     * @param empleado
     * @throws errores.NotificarError
     */
   
    
    public void BorrarEmpleado( Empleado empleado) throws NotificarError{
       empleado.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(empleado);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }
    

    public void BorrarCliente( Cliente cliente) throws NotificarError{
       cliente.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(cliente);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }
    
    public void BorrarSupervisor( Supervisor supervisor) throws NotificarError{
       supervisor.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(supervisor);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }
    
    public void BorrarRequisito( Requisito requisito) throws NotificarError{
       requisito.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(requisito);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }
    
    public void BorrarUsuario( Usuario usuario) throws NotificarError{
       usuario.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(usuario);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }
    
    public void BorrarPrioridad( Prioridad prioridad) throws NotificarError{
       prioridad.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(prioridad);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }
    
    public void BorrarEstadoTurno( EstadoTurno estadoturno) throws NotificarError{
       estadoturno.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(estadoturno);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }

 public void BorrarTramite( Tramite tramite) throws NotificarError{
       tramite.setActivo(false);
       try{
            for(Turno turnodelTramite: this.buscarTurnos()){
                if(turnodelTramite.getTramites().contains(tramite)){
                    this.cancelarUnTurno(turnodelTramite.getNroTurno());

                }
            }
            this.persistencia.guardarOActualizarInstancia(tramite);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }
 
  public void BorrarTipoTramite( TipoTramite tipotramite) throws NotificarError{
       tipotramite.setActivo(false);
       try{
            this.persistencia.guardarOActualizarInstancia(tipotramite);
       }catch(NotificarError ne){
            throw new NotificarError(ne.getMessage());
       }
    }

}
