
package main;


import controlador.*;

import modelo.*;

import errores.NotificarError;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import vista.Inicioo;


public class TrabajoFinal {

   
    public static void main(String[] args) throws NotificarError {

        
		
		Controlador controlador =null;
		Persistencia persistencia=null;
                   
		try {

			persistencia= new Persistencia();     
                        controlador = new Controlador(persistencia);
                    /*  
                        controlador.crearUnTipoTramite("servicio automotor");
                        controlador.crearUnTipoTramite("atencion al automotor");
                      controlador.crearUnTipoTramite("caja de motor");
                       TipoTramite tt = controlador.buscarUnTipoTramite("servicio automotor");
                        TipoTramite titr = controlador.buscarUnTipoTramite("servicio automotor");
                      List<TipoTramite> tipostrams= new ArrayList<>();
                       tipostrams.add(tt);
                      tipostrams.add(titr);
                        controlador.crearUnArea("recursos artificiales", tipostrams);
                        
                        
                        controlador.crearUnSupervisor("damian", "extension", 41936331, "recursos artificiales");
                       controlador.crearUnEmpleado("angys", "piotro", 41936335, "recursos artificiales");
			controlador.crearUnUsuario("angeles12", "123");
                        Usuario us = controlador.buscarUnUsuario("angeles12");
                        controlador.crearUnCliente("angel", "piotros", 41936336, true, us);
                        Cliente cli = controlador.buscarUnCliente(41936336);
                        
                        controlador.crearUnRequisito("fotocopia certificado");
                         Requisito rec =controlador.buscarRequisito("fotocopia certificado");
                        List<Requisito> requis= new ArrayList<>();
                        requis.add(rec);
                        

                        controlador.crearUnTramite(1, "compra peso", "servicio automotor", requis);
                        controlador.crearUnEstadoTurno("baja");
                        controlador.crearUnaPrioridad("embarazada", 1);
                        
                      
                        controlador.crearUnEstadoTurno("en espera");
                        controlador.crearUnEstadoTurno("pendiente");
                      
                       */
                         
                         
                         
                     Inicioo ventana = new Inicioo(controlador);
                        
                        
                        
                        
                        
                        
                        

                    } catch (NotificarError e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			//e.printStackTrace();

			
		}

	}


        
    }
    
