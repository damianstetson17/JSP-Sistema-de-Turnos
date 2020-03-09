
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Prioridad;
import modelo.Tramite;
import modelo.Usuario;

public class SolicitarTurno extends javax.swing.JFrame {
 
  
    
    private Controlador controlador;
    private String TramiteSeleccionado,PrioridadSeleccionada, email, contrasena;
    private Usuario usua;
    
    public SolicitarTurno(Controlador controlador, Usuario usua)  {
        this.controlador=controlador;
        this.usua=usua;
        this.email=email;
        this.contrasena=contrasena;
        initComponents();
        setTitle("Solicitar Turno");
        setVisible(true);
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        ComboTramite.setFont(fuente);
        ComboPrioridad.setFont(fuente);
        crear.setFont(fuente);
        salir.setFont(fuente);
                
        cargarComboTramite();
        cargarComboPrioridad();  
    }

    
    private void cargarComboTramite () {
            try{
                for(Tramite tram: controlador.buscarTramites()){
                    ComboTramite.addItem(tram.getNombreTramite());  
                }
            } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
       
            
    }
    
        
        
    private void cargarComboPrioridad (){
            try{
                for(Prioridad prio: controlador.buscarPrioridades()){
                     ComboPrioridad.addItem(prio.getNombrePrioridad());  
                }
            } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCrearTurnoDos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        crear = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        ComboTramite = new javax.swing.JComboBox<>();
        ComboPrioridad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCrearTurnoDos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Seleccione el Tramite:");
        PanelCrearTurnoDos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 200, 50));

        jLabel1.setText("Seleccione Prioridad:");
        PanelCrearTurnoDos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 200, 50));

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        PanelCrearTurnoDos.add(crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 100, 40));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        PanelCrearTurnoDos.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 90, 40));

        ComboTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTramiteActionPerformed(evt);
            }
        });
        PanelCrearTurnoDos.add(ComboTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 240, 40));

        PanelCrearTurnoDos.add(ComboPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 240, 40));

        getContentPane().add(PanelCrearTurnoDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        TramiteSeleccionado= ComboTramite.getSelectedItem().toString();
        PrioridadSeleccionada= ComboPrioridad.getSelectedItem().toString();
        if(TramiteSeleccionado.equals("Seleccione una Opcion") || PrioridadSeleccionada.equals("Seleccione una Opcion") ){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una Opcion");   
        }else{
            java.util.Date fechaSolicitud = new java.util.Date();
             
            String estadoTurno ="en espera";
            
            try {
               
                Cliente clien=  controlador.buscarClienteDelUsuario(usua);
                controlador.creaUnTurno( fechaSolicitud,estadoTurno,PrioridadSeleccionada, TramiteSeleccionado, clien);
                Integer nro = controlador.buscarUltimoNroTurno();
                JOptionPane.showMessageDialog(null, "Se creo el turno con exito su numero de Turno es: "+nro);
                dispose();
                ListRequisitoTramite mostrarRequisitos= new ListRequisitoTramite(controlador,nro,TramiteSeleccionado, usua);
            } catch (NotificarError ex) {
               JOptionPane.showMessageDialog(null,ex.getMessage()); 
            }
        }    
    }//GEN-LAST:event_crearActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
        MenuCliente irAlMenu = new MenuCliente(controlador, usua); 
        
    }//GEN-LAST:event_salirActionPerformed

    private void ComboTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTramiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTramiteActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboPrioridad;
    private javax.swing.JComboBox<String> ComboTramite;
    private javax.swing.JPanel PanelCrearTurnoDos;
    private javax.swing.JButton crear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables



}
