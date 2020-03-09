
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Turno;

public class AtenderTurno extends javax.swing.JFrame {

    
    private Controlador controlador;
    private int NroTurno=-1;
    private long dni;
    
    public AtenderTurno(Controlador controlador, long dni) {
        initComponents();
        TablaTurnosPendientes.setVisible(true);
        this.controlador=controlador;
        this.dni=dni;
        setTitle("Atender un Turno");
        this.setLocationRelativeTo(null);
        setVisible(true);
        this.setSize(800, 650);
        this.setResizable(false);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        label1.setFont(fuente);
        TablaTurnosPendientes.setFont(fuente);
        Atender.setFont(fuente);
        btnSalir.setFont(fuente);
                
        try {
            mostrarTablaTurnosPendientes(dni);
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

     private void mostrarTablaTurnosPendientes(long dni) throws NotificarError{
        String matriz[][]= new String [controlador.obtenerTurnosPendientesAtenderEmpleado(dni).size()][3];
        List <Turno> turnos= controlador.obtenerTurnosPendientesAtenderEmpleado(dni);
      
        if(!turnos.isEmpty()){
            int i=0;
            for(Turno t: turnos){
            
                matriz[i][0]=String.valueOf(t.getNroTurno());
                matriz[i][1]=t.getPrioridad().getNombrePrioridad();
                matriz[i][2]=t.getEstado().getNombreEstado();
                i++;
            }
            TablaTurnosPendientes.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                "Nro Turno", "Prioridad", "Estado"
            }
        ));
       }else{
           TablaTurnosPendientes.setModel(new DefaultTableModel(
            null,
            new String [] {
                "Nro Turno", "Prioridad", "Estado"
            }
        ));
       }     
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTurnosPendientes = new javax.swing.JTable();
        Atender = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("Turnos Pendientes:");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 240, 50));

        TablaTurnosPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nro Turno", "Prioridad", "Estado"
            }
        ));
        TablaTurnosPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTurnosPendientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTurnosPendientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 440, 270));

        Atender.setText("Atender");
        Atender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtenderActionPerformed(evt);
            }
        });
        jPanel1.add(Atender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 100, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuEmpleado iralmenusuper = new MenuEmpleado(controlador,dni);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void TablaTurnosPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTurnosPendientesMouseClicked
        int row = TablaTurnosPendientes.rowAtPoint(evt.getPoint());
        if(row>=0){
            String numero =TablaTurnosPendientes.getValueAt(row, 0).toString()   ;
            if(!numero.equals("")) {
                NroTurno=Integer.parseInt(numero);
            }
        }
    }//GEN-LAST:event_TablaTurnosPendientesMouseClicked

    private void AtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtenderActionPerformed
        if(NroTurno<0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un turno");
            setVisible(true);
        }else{  
            dispose();
            // controlador.cancelarUnTurno(NroTurno);
            ActualizarEstadoTurnoAtendido actualizarestado = new ActualizarEstadoTurnoAtendido(controlador,NroTurno,dni );
        }
    }//GEN-LAST:event_AtenderActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atender;
    private javax.swing.JTable TablaTurnosPendientes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables


}
