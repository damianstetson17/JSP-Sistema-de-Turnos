
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.Supervisor;


public class InicioTrabajador extends javax.swing.JFrame {

    private Controlador controlador;
    private String trabajador="nada";
    private long dni=0;
    private Empleado emp;
    private Supervisor supervisor;
  
    
    public InicioTrabajador(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        setTitle("Inicio");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(800, 650);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        Empleado.setFont(fuente);
        btnSupervisor.setFont(fuente);
        btnSalirAInicio.setFont(fuente);        
        dniIngresado.setFont(fuente);   
        jLabel3.setFont(fuente);   
        btnIniciar.setFont(fuente);   
        btnSalir.setFont(fuente);   
                
        setVisible(true);
        PanelInicioMenu.setSize(800, 650);
        PanelRegistro.setSize(700, 650);
        PanelInicioMenu.setVisible(true);
        PanelRegistro.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInicioMenu = new javax.swing.JPanel();
        Empleado = new javax.swing.JButton();
        btnSupervisor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalirAInicio = new javax.swing.JButton();
        PanelRegistro = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        dniIngresado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelInicioMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Empleado.setText("Empleado");
        Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoActionPerformed(evt);
            }
        });
        PanelInicioMenu.add(Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 250, 80));

        btnSupervisor.setText("Supervisor");
        btnSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupervisorActionPerformed(evt);
            }
        });
        PanelInicioMenu.add(btnSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 250, 80));

        jLabel1.setText("Iniciar como:");
        PanelInicioMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 60));

        btnSalirAInicio.setText("Salir");
        btnSalirAInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAInicioActionPerformed(evt);
            }
        });
        PanelInicioMenu.add(btnSalirAInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 130, 50));

        getContentPane().add(PanelInicioMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 660));

        PanelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Dni:");
        PanelRegistro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 90, 50));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelRegistro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 100, 40));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        PanelRegistro.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 100, 40));
        PanelRegistro.add(dniIngresado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 250, 40));

        getContentPane().add(PanelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupervisorActionPerformed
        trabajador="supervisor";
        setVisible(true);
       
        PanelInicioMenu.setVisible(false);
        PanelRegistro.setVisible(true);
    }//GEN-LAST:event_btnSupervisorActionPerformed

    private void EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoActionPerformed

        trabajador="empleado";
        setVisible(true);
       
        PanelInicioMenu.setVisible(false);
        PanelRegistro.setVisible(true);
        
      
    }//GEN-LAST:event_EmpleadoActionPerformed

    private void btnSalirAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAInicioActionPerformed
        dispose();
        Inicioo irAlInicio =new Inicioo(controlador);
    }//GEN-LAST:event_btnSalirAInicioActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        String eldni=dniIngresado.getText();
        dni=Long.parseLong(eldni);
         if(dni<=0 || dni<1000000){
             JOptionPane.showMessageDialog(null,"DNI ingresado incorrecto"); 
        }else{
             if("empleado".equals(trabajador)){
                 try {
                     emp= controlador.buscarUnEmpleado(dni);
                     if(emp!=null){
                        dispose();
                        MenuEmpleado irAlMenuEmpleado = new MenuEmpleado( controlador,dni);
                     }else{
                         JOptionPane.showMessageDialog(null,"El DNI ingresado no corresponde con un empleado."); 
                         setVisible(true);
                     }
                 } catch (NotificarError ex) {
                      JOptionPane.showMessageDialog(null,ex.getMessage()); 
                 }
                 
             }else{
                  if("supervisor".equals(trabajador)){
                      try {
                        supervisor=controlador.buscarUnSupervisor(dni);
                        if(supervisor!=null){
                            JOptionPane.showMessageDialog(null,"bienvenido "+supervisor.getNombre()); 
                            dispose();
                            MenuSupervisor iralmenucito = new MenuSupervisor(controlador);
                        }else{
                            JOptionPane.showMessageDialog(null,"El DNI ingresado no corresponde con un supervisor."); 
                            setVisible(true);
                        }
                      } catch (NotificarError ex) {
                         JOptionPane.showMessageDialog(null,ex.getMessage()); 
                      }
                  }
                 
             }
         }

        
        
        
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       setVisible(true);
      
       PanelInicioMenu.setVisible(true);
       PanelRegistro.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Empleado;
    private javax.swing.JPanel PanelInicioMenu;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirAInicio;
    private javax.swing.JButton btnSupervisor;
    private javax.swing.JTextField dniIngresado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
