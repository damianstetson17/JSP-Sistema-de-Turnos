
package vista;

import controlador.Controlador;

import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TipoTramite;

public class CrearTipoTramite extends javax.swing.JFrame {


    private Controlador controlador;
    
    public CrearTipoTramite( Controlador controlador) {
        initComponents();
        setVisible(true);
        this.controlador=controlador;
       
        setTitle("Crear Nuevo Tipo Tramite");
        setVisible(true);
         this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);       
        nombretipotramite.setFont(fuente);
        TablaTipoTramites.setFont(fuente);       
        btnAceptar.setFont(fuente);       
        btnSalir.setFont(fuente);
        
        try {
            mostrarTiposTramites();
        } catch (NotificarError ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

     /**
     * muestra en la tabla todos los tipos tramites actuales almacenados en la BD.
     * @throws NotificarError 
     **/
    private void mostrarTiposTramites() throws NotificarError{
       String matriz[][]= new String [controlador.buscarTipoTramites().size()][1];
        int i=0;
        for(TipoTramite tt:controlador.buscarTipoTramites() ){
            matriz[i][0]=tt.getNombreTipoTramite();
            i++;
        } 
         TablaTipoTramites.setModel(new DefaultTableModel(
            matriz,
               new String [] {
                "Nombre"
            }
        ));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombretipotramite = new java.awt.TextField();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTipoTramites = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Tipo Tramite:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 200, 60));
        jPanel1.add(nombretipotramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 200, 40));

        btnAceptar.setText("Crear");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 90, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 80, 40));

        TablaTipoTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "nombre"
            }
        ));
        jScrollPane1.setViewportView(TablaTipoTramites);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 260, 270));

        jLabel2.setText("Tipos Tramites actuales:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 260, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor( controlador );
    }//GEN-LAST:event_btnSalirActionPerformed

    
    /**
     * al aceptar se obtiene el nombre del tipo tramite, controla si no esta vacio
     * y se llama a controlador para crear el nuevo tipo tramite
     * finalmente se cierra la ventana y se vuelve al menu
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String  nombre=nombretipotramite.getText();
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un nuevo nombre");
            setVisible(true);
            
        }else{
            try {
                controlador.crearUnTipoTramite(nombre);
                JOptionPane.showMessageDialog(null, "Se creo el Tipo Tramite "+ nombre);
                dispose();
                MenuSupervisor iralmenu = new MenuSupervisor( controlador );
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTipoTramites;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField nombretipotramite;
    // End of variables declaration//GEN-END:variables



}
