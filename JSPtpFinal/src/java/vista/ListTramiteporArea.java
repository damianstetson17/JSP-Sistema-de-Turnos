
package vista;

import controlador.Controlador;

import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Area;
import modelo.Tramite;


public class ListTramiteporArea extends javax.swing.JFrame {

    
    private Controlador controlador;
  
     private String nombreTramite,nombreAreaABuscar;
    
    public ListTramiteporArea( Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        this.setSize(800,900);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelInicioListadoTramite.setSize(800, 650);
        PanelListaTramite.setSize(800,900);
        setVisible(true);
        PanelInicioListadoTramite.setVisible(true);
        PanelListaTramite.setVisible(false);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        label2.setFont(fuente);       
        TablaTramiteRealizadoPorArea.setFont(fuente); 
        ComboArea.setFont(fuente); 
        btnAceptar.setFont(fuente); 
        btnSalirinicio.setFont(fuente);       
        btnSalir.setFont(fuente);
        
        cargarComboArea();  
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
    
     private void mostrarTablaTramitePorArea(String nombreAreaABuscar) throws NotificarError{
        String matriz[][]= new String [controlador.buscarTramitesRealizadosDeUnArea(nombreAreaABuscar).size()][3];
        int i=0;
            for(Tramite tram: controlador.buscarTramitesRealizadosDeUnArea(nombreAreaABuscar)){
            matriz[i][0]=String.valueOf(tram.getNroTramite());
            matriz[i][1]=tram.getNombreTramite();
            matriz[i][2]=tram.getTipoTramite().getNombreTipoTramite();
            i++;
        }
         TablaTramiteRealizadoPorArea.setModel(new DefaultTableModel(
            matriz,
            new String [] {
                "Nro. Tramite", "Tramite", "Tipo Tramite"
            }
        ));
                         
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInicioListadoTramite = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        ComboArea = new javax.swing.JComboBox<>();
        PanelListaTramite = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTramiteRealizadoPorArea = new javax.swing.JTable();
        label2 = new java.awt.Label();
        btnSalirinicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelInicioListadoTramite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Area:");
        PanelInicioListadoTramite.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, 50));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        PanelInicioListadoTramite.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 100, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelInicioListadoTramite.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 90, 40));

        PanelInicioListadoTramite.add(ComboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 220, 40));

        getContentPane().add(PanelInicioListadoTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 490));

        PanelListaTramite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaTramiteRealizadoPorArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nro Tramite", "Tramite", "Tipo Tramite"
            }
        ));
        jScrollPane1.setViewportView(TablaTramiteRealizadoPorArea);

        PanelListaTramite.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 510, 242));

        label2.setName("Tramites Realizados por Area:"); // NOI18N
        label2.setText("Tramites Realizados por Area:");
        PanelListaTramite.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 320, 60));

        btnSalirinicio.setText("Salir");
        btnSalirinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirinicioActionPerformed(evt);
            }
        });
        PanelListaTramite.add(btnSalirinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 100, 40));

        getContentPane().add(PanelListaTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        nombreAreaABuscar= ComboArea.getSelectedItem().toString();
        if(nombreAreaABuscar.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del Area");
        }else{
            try {
                Area ar = controlador.buscarUnArea(nombreAreaABuscar);
                mostrarTablaTramitePorArea(nombreAreaABuscar);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            setVisible(true);
           PanelInicioListadoTramite.setVisible(false);
           PanelListaTramite.setVisible(true);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralMenu = new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirinicioActionPerformed
       dispose();
        MenuSupervisor irAlMenu = new MenuSupervisor(controlador); 
    }//GEN-LAST:event_btnSalirinicioActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboArea;
    private javax.swing.JPanel PanelInicioListadoTramite;
    private javax.swing.JPanel PanelListaTramite;
    private javax.swing.JTable TablaTramiteRealizadoPorArea;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirinicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables


    
}
