package vista;

import controlador.Controlador;
import errores.NotificarError;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Turno;
import controlador.*;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Area;
import modelo.EstadoTurno;
import modelo.Tramite;


public class ActualizarEstadoUnTurno extends javax.swing.JFrame {
    
  
    
    private Controlador controlador;
    private String estadoTurnoActual="", nuevoEstadot="";
   private int nroturno;
    private  long dni;
    
    public ActualizarEstadoUnTurno(Controlador controlador,  long dni) {
        this.controlador =controlador;
        this.dni=dni;
        
        initComponents();
        setTitle("Actualizar un Estado Turno");
        this.setVisible(true);
        this.PanelActualizarEstadoTurno.setVisible(true);
        
        this.setSize(800, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);
        jLabel4.setFont(fuente);
        ComboEstado.setFont(fuente);
        TablaTurnos.setFont(fuente);
        LabelEstadoActual.setFont(fuente);      
        LabelNroTurno.setFont(fuente);
        btnActualizar.setFont(fuente);
        btnSalirPanelActualizar.setFont(fuente);
                
        cargarComboEstado();
        try {
           
            mostrarTurnosActuales(dni);
           
        } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

   
    private void mostrarTurnosActuales(long dni) throws NotificarError{
         String matriz[][] = new String[controlador.buscarTurnosEmpleado(dni).size()][4];
         List <Turno> turnos= controlador.buscarTurnosEmpleado(dni);
         
        int i = 0;
         if(!turnos.isEmpty()){
            for (Turno t: turnos) {
            matriz[i][0] = t.getNroTurno().toString();
            matriz[i][1] =t.getEstado().getNombreEstado();
            if( t.getFechaInicioAtencion()!=null ){
                matriz[i][2] = t.getFechaInicioAtencion().toString();
            }else {
                matriz[i][2] ="";
             if(t.getFechaFinAtencion()!=null){
                matriz[i][3] = t.getFechaFinAtencion().toString();
             } else {
                matriz[i][3] ="";
             } 
        }
           i++; 
        }    
        TablaTurnos.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Nro Turno", "Estado ", "Fecha Inicio", "Fecha fin"
            }
        ));
       }else{
           TablaTurnos.setModel(new DefaultTableModel(
                null,
                new String [] {
                "Nro Turno", "Estado ", "Fecha Inicio", "Fecha fin"
            }
        ));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTurnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelActualizarEstadoTurno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalirPanelActualizar.setText("Salir");
        btnSalirPanelActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPanelActualizarActionPerformed(evt);
            }
        });
        PanelActualizarEstadoTurno.add(btnSalirPanelActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 100, 40));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        PanelActualizarEstadoTurno.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 120, 40));

        jLabel2.setText("Nro Turno Ingresado: ");
        PanelActualizarEstadoTurno.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 190, 40));
        PanelActualizarEstadoTurno.add(LabelNroTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 160, 40));

        jLabel3.setText("Estado Actual:");
        PanelActualizarEstadoTurno.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 130, 50));

        ComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEstadoActionPerformed(evt);
            }
        });
        PanelActualizarEstadoTurno.add(ComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 210, 40));

        jLabel4.setText("Nuevo Estado:");
        PanelActualizarEstadoTurno.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, 40));
        PanelActualizarEstadoTurno.add(LabelEstadoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 220, 40));

        TablaTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Turno", "Estado ", "Fecha Inicio", "Fecha fin"
            }
        ));
        TablaTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTurnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTurnos);

        PanelActualizarEstadoTurno.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 600, 110));

        jLabel1.setText("Turnos actuales:");
        PanelActualizarEstadoTurno.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 310, 40));

        getContentPane().add(PanelActualizarEstadoTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEstadoActionPerformed
  
    }//GEN-LAST:event_ComboEstadoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
          nroturno= Integer.parseInt(LabelNroTurno.getText());
          nuevoEstadot= ComboEstado.getSelectedItem().toString();
          if(nuevoEstadot.equals("")  ){
                JOptionPane.showMessageDialog(null,"Debe seleccionar un Nuevo Estado");
                setVisible(true);
          }else{
            try {
                //presiono actualizar 
                controlador.modificarEstadoTurno(nroturno, nuevoEstadot);
                JOptionPane.showMessageDialog(null,"se actualizo el turno: "+nroturno+ "con el estado: "+ nuevoEstadot);
                mostrarTurnosActuales( dni);
                dispose(); 
                MenuEmpleado iralmenu = new MenuEmpleado(controlador,dni);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
          }
    }//GEN-LAST:event_btnActualizarActionPerformed

    
    private void btnSalirPanelActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPanelActualizarActionPerformed
        dispose();
        MenuEmpleado iralmenu = new MenuEmpleado (controlador,dni);   
    }//GEN-LAST:event_btnSalirPanelActualizarActionPerformed

    private void TablaTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTurnosMouseClicked
       int row = TablaTurnos.rowAtPoint(evt.getPoint());
        if(row>=0){
          String  nro =TablaTurnos.getValueAt(row,0).toString();
            if(nro.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un Turno.");
                setVisible(true);
            }else{
                LabelNroTurno.setText(nro);
                nroturno = Integer.parseInt(LabelNroTurno.getText());
                Turno tur;
                try {
                    tur = controlador.buscarUnTurno(nroturno);
                    if(tur==null){
                        JOptionPane.showMessageDialog(null, "El Numero del turno ingresado es incorrecto.");
                        setVisible(true);
                    }else{
                        String estado=tur.getEstado().getNombreEstado();
                        LabelEstadoActual.setText(estado);
                    }
                    
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        }    
    }//GEN-LAST:event_TablaTurnosMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEstado;
    private javax.swing.JLabel LabelEstadoActual;
    private javax.swing.JLabel LabelNroTurno;
    private javax.swing.JPanel PanelActualizarEstadoTurno;
    private javax.swing.JTable TablaTurnos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnSalirPanelActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


}
