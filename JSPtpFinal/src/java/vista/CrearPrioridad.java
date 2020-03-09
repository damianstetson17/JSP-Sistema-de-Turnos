
package vista;

import controlador.Controlador;

import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Prioridad;

public class CrearPrioridad extends javax.swing.JFrame {

    private Controlador controlador;
    
    public CrearPrioridad(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        
        setTitle("Crear Nueva Prioridad");
        setVisible(true);
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2 .setFont(fuente);
        jLabel3.setFont(fuente);
        nombreprioridad.setFont(fuente);
        nivelprioridad .setFont(fuente);      
        TablaPrioridades.setFont(fuente);       
        btnAceptar.setFont(fuente);        
        btnSalir.setFont(fuente);
                
                
        try {
            mostrarPrioridades();
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    
     /**
     * muestra en la tabla todas las prioridades actuales almacenados en la BD.
     * @throws NotificarError 
     **/
    private void mostrarPrioridades() throws NotificarError{
       String matriz[][]= new String [controlador.buscarPrioridades().size()][2];
        int i=0;
        for(Prioridad p:controlador.buscarPrioridades() ){
            matriz[i][0]=p.getNombrePrioridad();
            matriz[i][1]=String.valueOf(p.getNivelPrioridad());
            i++;
        } 
         TablaPrioridades.setModel(new DefaultTableModel(
            matriz,
               new String [] {
                "Nombre", "Nivel"
            }
        ));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreprioridad = new java.awt.TextField();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nivelprioridad = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPrioridades = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Prioridad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 50));
        jPanel1.add(nombreprioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 200, 40));

        btnAceptar.setText("Crear");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 100, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 90, 40));

        jLabel2.setText("Nivel:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 80, 50));
        jPanel1.add(nivelprioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 200, 40));

        TablaPrioridades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Nombre", "Nivel"
            }
        ));
        jScrollPane1.setViewportView(TablaPrioridades);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 350, 260));

        jLabel3.setText("Prioridades actuales:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 230, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor( controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    
    /**
     * al aceptar se obtiene el nombre y nivel de la prioridad, se controla si no esta vacio
     * y se llama a controlador para crear la nueva prioridad
     * finalmente se cierra la ventana y se vuelve al menu
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String  nombre=nombreprioridad.getText();
        int nivel= Integer.parseInt(nivelprioridad.getText());
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
            setVisible(true);
            
        }else{
            try {
                controlador.crearUnaPrioridad(nombre, nivel);
                JOptionPane.showMessageDialog(null, "Se creo la prioridad "+nombre);
                dispose();
                MenuSupervisor iralmenu = new MenuSupervisor( controlador);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPrioridades;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField nivelprioridad;
    private java.awt.TextField nombreprioridad;
    // End of variables declaration//GEN-END:variables
}
