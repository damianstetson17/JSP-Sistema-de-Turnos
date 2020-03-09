package vista;

import javax.swing.JOptionPane;
import controlador.*;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Tramite;
import modelo.Turno;

public class ReasignarTurno extends javax.swing.JFrame {
 
    private int NroTurno;
    private Controlador controlador;
    private long dni;
    String confirmar="no", nombreTramite, mensaje;

    public ReasignarTurno(Controlador control, long dni) {
        this.controlador=control;
        this.dni=dni;
        initComponents();
        setTitle("Reasignar Turno");
        setVisible(true);
        setSize(900, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);
        NroTurnoAReasignar.setFont(fuente);
        ComboTramite.setFont(fuente);
        TablaTurnosPendientes.setFont(fuente);     
        Confirmar.setFont(fuente);
        btnReasignar.setFont(fuente);    
        btnSalir.setFont(fuente); 
                
        try {
            mostrarTablaTurnosPendientes(dni);
            cargarComboTramite();
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Confirmar = new javax.swing.JCheckBox();
        btnReasignar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        NroTurnoAReasignar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ComboTramite = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaTurnosPendientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nro Turno:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 90, 50));

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 140, 50));

        btnReasignar.setText("Reasignar");
        btnReasignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReasignarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReasignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 120, 50));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 90, 50));
        jPanel1.add(NroTurnoAReasignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 150, 40));

        jLabel2.setText("Asignar a:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 120, 40));

        jPanel1.add(ComboTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 240, 40));

        TablaTurnosPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        jScrollPane2.setViewportView(TablaTurnosPendientes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 300, 260));

        jLabel3.setText("Turnos Pendientes:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 260, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
//TODO turno
    private void mostrarTablaTurnosPendientes(long dni) throws NotificarError{
        String matriz[][]= new String [controlador.obtenerTurnosPendientesAtenderEmpleado(dni).size()][2];
        List <Turno> turnos= controlador.obtenerTurnosPendientesAtenderEmpleado(dni);
      
        if(!turnos.isEmpty()){
            int i=0;
            for(Turno t: turnos){
            
                matriz[i][0]=String.valueOf(t.getNroTurno());
                matriz[i][1]=t.getPrioridad().getNombrePrioridad();
                i++;
            }
            TablaTurnosPendientes.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                "Nro Turno", "Prioridad"
             }
            ));
       }else{
           TablaTurnosPendientes.setModel(new DefaultTableModel(
            null,
             new String [] {
                "Nro Turno", "Prioridad"
            }
             ));
       }       
    }
    
private void TablaTurnosPendientesMouseClicked(java.awt.event.MouseEvent evt) {                                                   
        
        int row = TablaTurnosPendientes.rowAtPoint(evt.getPoint());
        if(row>=0){
            String numero =TablaTurnosPendientes.getValueAt(row, 0).toString()   ;
            if(!numero.equals("")) {
                NroTurno=Integer.parseInt(numero);
            }
        }
    } 

    //TODO tramites
    private void cargarComboTramite () {
            try{
                for(Tramite tram: controlador.buscarTramites()){
                    ComboTramite.addItem(tram.getNombreTramite());  
                }
            } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }     
    }
    
//botones
    private void btnReasignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReasignarActionPerformed
         
        //controlar que selecciono confirmar 
        if(confirmar.equals("si")){
            if(ComboTramite.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Debe seleccionar un Tramite");       
            }else{
                //cargo las variables con lo que se selecciono del combobox y el nro turno
                  NroTurno= Integer.parseInt(NroTurnoAReasignar.getText());
                  nombreTramite =ComboTramite.getSelectedItem().toString();
                try {
                    controlador.reasignarUnTurno(NroTurno, nombreTramite);
                    mensaje=String.format("Se ha reasignado exitosamente el Turno: %d al Tramite: %s",NroTurno,nombreTramite);
                    JOptionPane.showMessageDialog(null,mensaje);
                    
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }   
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe confirmar para continuar");   
        }     
    }//GEN-LAST:event_btnReasignarActionPerformed
 
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        dispose();
        MenuEmpleado irAlMenu = new MenuEmpleado(controlador,dni);       
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
           confirmar="si";        
    }//GEN-LAST:event_ConfirmarActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTramite;
    private javax.swing.JCheckBox Confirmar;
    private javax.swing.JTextField NroTurnoAReasignar;
    private javax.swing.JTable TablaTurnosPendientes;
    private javax.swing.JButton btnReasignar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


}
