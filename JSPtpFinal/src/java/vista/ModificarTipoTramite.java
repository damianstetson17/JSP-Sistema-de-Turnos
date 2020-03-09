
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoTurno;
import modelo.TipoTramite;
import modelo.Turno;


public class ModificarTipoTramite extends javax.swing.JFrame {

   
    private Controlador controlador;
    private String nombre;
    
    public ModificarTipoTramite(Controlador controlador) {
        initComponents();
        
        setVisible(true);
        this.controlador=controlador;
        setTitle("Modificar Tipo Tramite");
        setVisible(true);
        setVisible(true);
        setSize(800,650);
        PanelInicio.setVisible(true);
        PanelActualizar.setVisible(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        TablaNombre.setFont(fuente);
        nuevonombre.setFont(fuente);
        btnAceptar.setFont(fuente);
        btnSalir.setFont(fuente);
        btnModiciar .setFont(fuente);      
        btnSalirAtras .setFont(fuente);      
                
        try {
            mostrarTablaNombres();
        } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    
     private void mostrarTablaNombres() throws NotificarError{
      
        String matriz[][]= new String [controlador.buscarTipoTramites().size()][1];
        int i=0;
        for(TipoTramite tt: controlador.buscarTipoTramites()){
            matriz[i][0]=tt.getNombreTipoTramite();
            i++;
        }
         TablaNombre.setModel(new DefaultTableModel(
            matriz,
            new String [] {
                "Nombre"
            }
        ));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInicio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNombre = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        PanelActualizar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nuevonombre = new java.awt.TextField();
        btnModiciar = new javax.swing.JButton();
        btnSalirAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaNombre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        TablaNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaNombreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaNombre);

        PanelInicio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 390, 240));

        jLabel1.setText("Seleccione el que desea modificar:");
        PanelInicio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 350, 40));

        btnAceptar.setText("Modificar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        PanelInicio.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 110, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelInicio.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 90, 40));

        getContentPane().add(PanelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 520));

        PanelActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nuevo nombre:");
        PanelActualizar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 160, 40));
        PanelActualizar.add(nuevonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 230, 40));

        btnModiciar.setText("Modificar");
        btnModiciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiciarActionPerformed(evt);
            }
        });
        PanelActualizar.add(btnModiciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 120, 40));

        btnSalirAtras.setText("Salir");
        btnSalirAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAtrasActionPerformed(evt);
            }
        });
        PanelActualizar.add(btnSalirAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 100, 40));

        getContentPane().add(PanelActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu = new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void TablaNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaNombreMouseClicked
        int row = TablaNombre.getSelectedRow();
        nombre= (String) TablaNombre.getValueAt(row, 0);
    }//GEN-LAST:event_TablaNombreMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try{
            controlador.buscarUnTipoTramite(nombre);
             setVisible(true);
             PanelInicio.setVisible(false);
             PanelActualizar.setVisible(true);
            
            
        
        }catch(NotificarError ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
        
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAtrasActionPerformed
            setVisible(true);
             PanelInicio.setVisible(true);
             PanelActualizar.setVisible(false);
    }//GEN-LAST:event_btnSalirAtrasActionPerformed

    private void btnModiciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiciarActionPerformed
       String nuevnombre=nuevonombre.getText();
       
       if(nombre.equals("")){
           JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
           setVisible(true);
            PanelInicio.setVisible(false);
            PanelActualizar.setVisible(true);
           
       }else{
           try{
           controlador.actualizarTipoTramite(nombre,nuevnombre);
           dispose();
           MenuSupervisor iralmenu =new MenuSupervisor(controlador);
           }catch(NotificarError ex){
               JOptionPane.showMessageDialog(null, ex.getMessage());
           }
       }
    }//GEN-LAST:event_btnModiciarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelActualizar;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JTable TablaNombre;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnModiciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField nuevonombre;
    // End of variables declaration//GEN-END:variables



}
