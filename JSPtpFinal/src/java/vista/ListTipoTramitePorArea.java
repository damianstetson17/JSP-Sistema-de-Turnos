package vista;

import controlador.*;
import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Area;

import modelo.TipoTramite;

public class ListTipoTramitePorArea extends javax.swing.JFrame {

   
    
    private Controlador controlador;
    private String nombreAreaBuscar;
    
    public ListTipoTramitePorArea(Controlador control) {
        this.controlador=control;
        initComponents();
        cargarComboArea();
        setTitle("Listado de Tipos de Tramites por Area");
       // this.setSize(800, 650);
        setVisible(true);
        PanelListadoNombreArea.setSize(800, 650);
        PanelListadoTipoTramite.setSize(1200, 1000);
        PanelListadoNombreArea.setVisible(true);
        PanelListadoTipoTramite.setVisible(false);

        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        labeltipotramiteArea.setFont(fuente);       
        labelcantidadTipoTramite.setFont(fuente);
        TablaTipoTramite.setFont(fuente); 
        ComboArea.setFont(fuente); 
        btnAceptarPanelInicio.setFont(fuente); 
        btnSalirPanelInicio.setFont(fuente);       
        btnSalir.setFont(fuente);
        
        
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
    
    private void cargarComboArea () {
            try{
                for(Area a: controlador.buscarAreas()){
                    ComboArea.addItem(a.getNombreArea());  
                }
            } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }     
    }
    
    private void mostrarListaTipoTramiteRealizado() throws NotificarError{
        String matriz[][]= new String [controlador.tipoTramitesRealizadosPorArea(nombreAreaBuscar).size()][2];
        int i=0;
        for(TipoTramite tt: controlador.tipoTramitesRealizadosPorArea(nombreAreaBuscar) ){
            matriz[i][0]=tt.getNombreTipoTramite();
            
            i++;
        }
         TablaTipoTramite.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                "Nombre"
            }
        ));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelListadoNombreArea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptarPanelInicio = new javax.swing.JButton();
        btnSalirPanelInicio = new javax.swing.JButton();
        ComboArea = new javax.swing.JComboBox<>();
        PanelListadoTipoTramite = new javax.swing.JPanel();
        labeltipotramiteArea = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTipoTramite = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        labelcantidadTipoTramite = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelListadoNombreArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre del Area:");
        PanelListadoNombreArea.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 190, 40));

        btnAceptarPanelInicio.setText("Aceptar");
        btnAceptarPanelInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarPanelInicioActionPerformed(evt);
            }
        });
        PanelListadoNombreArea.add(btnAceptarPanelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 100, 40));

        btnSalirPanelInicio.setText("Salir");
        btnSalirPanelInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPanelInicioActionPerformed(evt);
            }
        });
        PanelListadoNombreArea.add(btnSalirPanelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 90, 40));

        PanelListadoNombreArea.add(ComboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 220, 40));

        getContentPane().add(PanelListadoNombreArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 620));

        PanelListadoTipoTramite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelListadoTipoTramite.add(labeltipotramiteArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 490, 50));

        TablaTipoTramite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        TablaTipoTramite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTipoTramiteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTipoTramite);

        PanelListadoTipoTramite.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 460, 250));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelListadoTipoTramite.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 90, 40));
        PanelListadoTipoTramite.add(labelcantidadTipoTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 480, 50));

        getContentPane().add(PanelListadoTipoTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         setVisible(true);
        PanelListadoNombreArea.setVisible(true);
        PanelListadoTipoTramite.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarPanelInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarPanelInicioActionPerformed
        nombreAreaBuscar=ComboArea.getSelectedItem().toString();
        if(nombreAreaBuscar.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del Area");
        }else{
            try {
                Area area= controlador.buscarUnArea(nombreAreaBuscar);
                labeltipotramiteArea.setText("Tipos de tramites del Area: "+nombreAreaBuscar);
                labelcantidadTipoTramite.setText("Total Tipo de Tramites del Area: "+controlador.tipoTramitesRealizadosPorArea(nombreAreaBuscar).size());
                mostrarListaTipoTramiteRealizado();
                setVisible(true);
                PanelListadoNombreArea.setVisible(false);
                PanelListadoTipoTramite.setVisible(true);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }   
    }//GEN-LAST:event_btnAceptarPanelInicioActionPerformed

    private void btnSalirPanelInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPanelInicioActionPerformed
       dispose();
       MenuSupervisor irAlMenu= new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirPanelInicioActionPerformed

    private void TablaTipoTramiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTipoTramiteMouseClicked
    
    }//GEN-LAST:event_TablaTipoTramiteMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboArea;
    private javax.swing.JPanel PanelListadoNombreArea;
    private javax.swing.JPanel PanelListadoTipoTramite;
    private javax.swing.JTable TablaTipoTramite;
    private javax.swing.JButton btnAceptarPanelInicio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirPanelInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelcantidadTipoTramite;
    private javax.swing.JLabel labeltipotramiteArea;
    // End of variables declaration//GEN-END:variables



}
