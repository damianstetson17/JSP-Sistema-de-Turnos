package vista;

import controlador.Controlador;
import errores.NotificarError;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Turno;
import controlador.*;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EstadoTurno;
import modelo.Tramite;


public class ActualizarEstadoTurnoAtendido extends javax.swing.JFrame {
    
  
    
    private Controlador controlador;
    private String estadoTurnoActual="", nuevoEstadot="";
    private Integer numeroTurno;
    private  long dni;
    
    public ActualizarEstadoTurnoAtendido(Controlador controlador, int NroTurno, long dni) {
        this.controlador =controlador;
        this.dni=dni;
        
        initComponents();
        setTitle("Actualizar Estado Turno");
        this.setVisible(true);
        this.PanelActualizarEstadoTurno.setVisible(true);
        numeroTurno=NroTurno;
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);
        jLabel4.setFont(fuente);
        ComboEstado.setFont(fuente);
        LabelEstadoActual.setFont(fuente);      
        LabelNroTurno.setFont(fuente);
        btnActualizar.setFont(fuente);
        btnSalirPanelActualizar.setFont(fuente);
                
        cargarComboEstado();
        try {
            mostrarNroTurnoYEstado();
           
        } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

 

    public void mostrarNroTurnoYEstado()throws NotificarError{
        try {
            
            Turno tur=controlador.buscarUnTurno(numeroTurno);
            String num  =tur.getNroTurno().toString();
            String estado=tur.getEstado().getNombreEstado();
            System.out.println(tur.getEstado().getNombreEstado());
            LabelNroTurno.setText(num);
            LabelEstadoActual.setText(estado);
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }   
    }
    private void cargarComboEstado () {
            try{
                for(EstadoTurno estt: controlador.buscarEstadsTurnos()){
                    ComboEstado.addItem(estt.getNombreEstado());  
                }
            } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelActualizarEstadoTurno = new javax.swing.JPanel();
        btnSalirPanelActualizar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LabelNroTurno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        LabelEstadoActual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelActualizarEstadoTurno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalirPanelActualizar.setText("Salir");
        btnSalirPanelActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPanelActualizarActionPerformed(evt);
            }
        });
        PanelActualizarEstadoTurno.add(btnSalirPanelActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 100, 40));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        PanelActualizarEstadoTurno.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 120, 40));

        jLabel2.setText("Nro Turno Ingresado: ");
        PanelActualizarEstadoTurno.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 180, 40));
        PanelActualizarEstadoTurno.add(LabelNroTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 200, 40));

        jLabel3.setText("Estado Actual:");
        PanelActualizarEstadoTurno.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 130, 50));

        ComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEstadoActionPerformed(evt);
            }
        });
        PanelActualizarEstadoTurno.add(ComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 210, 40));

        jLabel4.setText("Nuevo Estado:");
        PanelActualizarEstadoTurno.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 160, 40));
        PanelActualizarEstadoTurno.add(LabelEstadoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 220, 40));

        getContentPane().add(PanelActualizarEstadoTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEstadoActionPerformed
  
    }//GEN-LAST:event_ComboEstadoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
           nuevoEstadot= ComboEstado.getSelectedItem().toString();
          if(nuevoEstadot.equals("")  ){
                JOptionPane.showMessageDialog(null,"Debe seleccionar un Nuevo Estado");}
          try {
            //presiono actualizar 
            controlador.modificarEstadoTurno(numeroTurno, nuevoEstadot);
            JOptionPane.showMessageDialog(null,"se actualizo el turno: "+numeroTurno+ "con el estado: "+ nuevoEstadot);
            dispose(); 
            MenuEmpleado iralmenu = new MenuEmpleado(controlador,dni);
          } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    
    private void btnSalirPanelActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPanelActualizarActionPerformed
        dispose();
        MenuEmpleado iralmenu = new MenuEmpleado (controlador,dni);   
    }//GEN-LAST:event_btnSalirPanelActualizarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEstado;
    private javax.swing.JLabel LabelEstadoActual;
    private javax.swing.JLabel LabelNroTurno;
    private javax.swing.JPanel PanelActualizarEstadoTurno;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnSalirPanelActualizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables


}
