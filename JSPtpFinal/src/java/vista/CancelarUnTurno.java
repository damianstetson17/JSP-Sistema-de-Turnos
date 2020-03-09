
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Turno;
import modelo.Usuario;


public class CancelarUnTurno extends javax.swing.JFrame {

    
    
    private Controlador controlador;
    private String confirmado="no";
    private int NroTurno=-1;
    private long dni;
    private Usuario usuario;
    
    public CancelarUnTurno(Controlador controlador,  Usuario usua) {
        initComponents();
        this.controlador=controlador;
        this.usuario=usua;
        setTitle("Cancelar Turno");
        this.setLocationRelativeTo(null);
        setVisible(true);
        this.setSize(800, 650);
        this.setResizable(false);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        TablaTurnoACancelar.setFont(fuente);
        checkConfirmar.setFont(fuente);    
        btnAceptar.setFont(fuente);     
        btnSalir.setFont(fuente);
          
        //centra los valores de la tabla
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        TablaTurnoACancelar.getColumnModel().getColumn(0).setCellRenderer(tcr);
        TablaTurnoACancelar.getColumnModel().getColumn(1).setCellRenderer(tcr);  
        
        try {
            Cliente cliente = controlador.buscarClienteDelUsuario(usuario);
            dni=cliente.getDni();
            if(cliente== null){
                JOptionPane.showMessageDialog(null,"No se pudo encontrar al cliente");
            }else{
                mostrarTablaTurnosPendientes(dni);
            }
         
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
       
    }

    
    private void mostrarTablaTurnosPendientes(long dni) throws NotificarError{
      
        String matriz[][]= new String [controlador.obtenerTurnosPendientesDeCliente(dni).size()][2];
        int i=0;
        for(Turno t: controlador.obtenerTurnosPendientesDeCliente(dni)){
            matriz[i][0]=t.getNroTurno().toString();
            matriz[i][1]=t.getFechaSolicitud().toString();
            i++;
        }
         TablaTurnoACancelar.setModel(new DefaultTableModel(
            matriz,
            new String [] {
                "Nro Turno", "Fecha de Solicitud"
            }
        ));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        PanelSeleccionarTurnoACancelar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTurnoACancelar = new javax.swing.JTable();
        checkConfirmar = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSeleccionarTurnoACancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione un Turno:");
        PanelSeleccionarTurnoACancelar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 270, 40));

        TablaTurnoACancelar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nro Turno", "Fecha de Solicitud"
            }
        ));
        TablaTurnoACancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTurnoACancelarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTurnoACancelar);

        PanelSeleccionarTurnoACancelar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 590, 270));

        checkConfirmar.setText("Confirmar");
        checkConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkConfirmarActionPerformed(evt);
            }
        });
        PanelSeleccionarTurnoACancelar.add(checkConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 140, 50));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        PanelSeleccionarTurnoACancelar.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 110, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelSeleccionarTurnoACancelar.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 100, 40));

        getContentPane().add(PanelSeleccionarTurnoACancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       
        if(confirmado.equals("si") && NroTurno>0){       
            try {            
                controlador.cancelarUnTurno(NroTurno);
                JOptionPane.showMessageDialog(null,"Su turno se cancelo con exito.");
                dispose();
                MenuCliente volverAlMenu = new MenuCliente(controlador,usuario);
            } catch (NotificarError ex) {
                 JOptionPane.showMessageDialog(null,ex.getMessage());
                 
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Debe confirmar para continuar");
        }
      
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       
        dispose();
        MenuCliente volverAlMenu = new MenuCliente(controlador,usuario);
       
     
    }//GEN-LAST:event_btnSalirActionPerformed

    private void TablaTurnoACancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTurnoACancelarMouseClicked
         int row = TablaTurnoACancelar.rowAtPoint(evt.getPoint());
        if(row>=0){
            String numero =TablaTurnoACancelar.getValueAt(row, 0).toString()   ;
            if(!numero.equals("")) {
                NroTurno=Integer.parseInt(numero);
            }
        }
    }//GEN-LAST:event_TablaTurnoACancelarMouseClicked

    private void checkConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkConfirmarActionPerformed
            confirmado="si";
    }//GEN-LAST:event_checkConfirmarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSeleccionarTurnoACancelar;
    private javax.swing.JTable TablaTurnoACancelar;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox checkConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private MenuCliente MenuCliente(Controlador controlador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
