package vista;

import controlador.*;
import java.awt.Font;

public class MenuEmpleado extends javax.swing.JFrame {
  
     
    
    private Controlador controlador;
    long dni;
    
    public MenuEmpleado(Controlador control, long dni) {
        this.controlador=control;
        this.dni=dni;
        initComponents();
        setTitle("Menu");
       
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Font fuente= new Font("Dialog",18,20);
        setFont(fuente);
        jMenu1.setFont(fuente);
        jMenu2.setFont(fuente);
        jMenuItem1.setFont(fuente);
        jMenuItem2.setFont(fuente);
        ItemReasignarTurno.setFont(fuente);        
        btnSalir.setFont(fuente);       
        
        setVisible(true); 
    }

   
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        ItemReasignarTurno = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 100, 40));

        jMenu1.setText("Inicio");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Turnos");

        jMenuItem1.setText("Atender un Turno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Actualizar Estado ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        ItemReasignarTurno.setText("Reasignar Turno");
        ItemReasignarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemReasignarTurnoActionPerformed(evt);
            }
        });
        jMenu2.add(ItemReasignarTurno);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        InicioTrabajador retornarInicio= new InicioTrabajador(controlador);
        
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ItemReasignarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemReasignarTurnoActionPerformed
        dispose();
        ReasignarTurno reasignarUnTurno =new ReasignarTurno(controlador,dni);
       
    }//GEN-LAST:event_ItemReasignarTurnoActionPerformed
   
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
      ActualizarEstadoUnTurno actualizarEstadoDeUnTurno =new ActualizarEstadoUnTurno(controlador,dni);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      dispose();
      AtenderTurno menuatender = new AtenderTurno(controlador, dni);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemReasignarTurno;
    private javax.swing.JButton btnSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables



}
