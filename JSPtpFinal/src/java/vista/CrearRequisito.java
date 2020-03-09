
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Requisito;

public class CrearRequisito extends javax.swing.JFrame {

    
    
    private Controlador controlador;
    
    public CrearRequisito(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        setTitle("Crear Nuevo Requisito");
        setVisible(true);
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);       
        nombrerequisito.setFont(fuente);
        TablaRequisitos.setFont(fuente);       
        btnAceptar.setFont(fuente);       
        btnSalir.setFont(fuente);
        
        
        try {
            mostrarRequisitos();
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }

     /**
     * muestra en la tabla todos los requisitos actuales almacenados en la BD.
     * @throws NotificarError 
     **/
    private void mostrarRequisitos() throws NotificarError{
       String matriz[][]= new String [controlador.buscarRequisitos().size()][1];
        int i=0;
        for(Requisito r:controlador.buscarRequisitos() ){
            matriz[i][0]=r.getNombreRequisito();
            i++;
        } 
         TablaRequisitos.setModel(new DefaultTableModel(
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
        nombrerequisito = new java.awt.TextField();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaRequisitos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Requisito:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 190, 50));
        jPanel1.add(nombrerequisito, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 220, 40));

        btnAceptar.setText("Crear");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 90, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 80, 40));

        TablaRequisitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TablaRequisitos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 260, 270));

        jLabel2.setText("Requisitos actuales:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 180, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * al aceptar se obtiene el nombre del requisito, controla si no esta vacio
     * y se llama a controlador para crear el nuevo requisito
     * finalmente se cierra la ventana y se vuelve al menu
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String  nombre=nombrerequisito.getText();
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
            setVisible(true);
        }else{
            try {
                controlador.crearUnRequisito(nombre);
                dispose();
                 JOptionPane.showMessageDialog(null,"Requisito: "+nombre+" agregado");
                MenuSupervisor iralmenu = new MenuSupervisor(controlador);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaRequisitos;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField nombrerequisito;
    // End of variables declaration//GEN-END:variables



}
