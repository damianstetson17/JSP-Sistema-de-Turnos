
package vista;

import controlador.Controlador;

import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Area;
import modelo.Supervisor;


public class CrearSupervisor extends javax.swing.JFrame {
 
    private Controlador controlador;
    private String nombreArea;
   
    public CrearSupervisor(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
       
        setTitle("Cargar Nuevo Supervisor");
        setVisible(true);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);  
        jLabel3.setFont(fuente); 
        jLabel4.setFont(fuente); 
        jLabel5.setFont(fuente); 
        nombre.setFont(fuente);
        apellido.setFont(fuente);
        DNI.setFont(fuente);
        nombrenuevaArea.setFont(fuente);
        TablaAreas.setFont(fuente);       
        btnCrear.setFont(fuente);       
        btnSalir.setFont(fuente);
        
        try {
            mostrarAreasActuales();
        } catch (NotificarError ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void mostrarAreasActuales() throws NotificarError{
        String matriz[][] = new String[controlador.buscarAreas().size()][1];
        List <Area> areas= controlador.buscarAreas();
        int i = 0;
        if(!areas.isEmpty()){
            for (Area a: controlador.buscarAreas()) {
            matriz[i][0] = a.getNombreArea();
            i++;
        }
        TablaAreas.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Nombre"
            }
        ));
       }else{
           TablaAreas.setModel(new DefaultTableModel(
                null,
                new String[]{
                    "Nombre"
                }
        ));
       }   
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        apellido = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        DNI = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        nombrenuevaArea = new java.awt.TextField();
        btnCrear = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAreas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 130, 50));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 240, 40));

        jLabel2.setText("Apellido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 120, 40));
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 240, 40));

        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 70, 40));
        jPanel1.add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 240, 40));

        jLabel4.setText("Area de Trabajo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 170, 50));
        jPanel1.add(nombrenuevaArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 240, 40));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 110, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 110, 40));

        TablaAreas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        TablaAreas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAreasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaAreas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 240, 330));

        jLabel5.setText("Seleccione el area:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 190, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nomb, ape;
        long dni=0;
        /**
         * se cargan las variables con 
         * los datos de los labels
         */
        nomb=nombre.getText();
        ape=apellido.getText();
        nombreArea= nombrenuevaArea.getText();
        dni= Long.parseLong(DNI.getText());
        /**
         * se controla si algun label esta vacio
         */
        if((nomb.equals("")) || (ape.equals("")) || nombreArea.equals("") || (dni==0) || (1000000>dni)){
            JOptionPane.showMessageDialog(null, "Debe ingresar correctamente los datos");
            setVisible(true);   
        }else{
              try {
                  /**
                   * se crea al supervisor yse vuelve al menu
                   */
                controlador.crearUnSupervisor(nomb, ape, dni, nombreArea);
                JOptionPane.showMessageDialog(null, "Supervisor: "+nomb+" agregado");
                dispose();
                MenuSupervisor iralmenu =new MenuSupervisor(controlador);
              } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } 
        }
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void TablaAreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAreasMouseClicked
        int row = TablaAreas.rowAtPoint(evt.getPoint());

        if(row>=0){
            nombreArea =TablaAreas.getValueAt(row, 0).toString()   ;
            if(nombreArea.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un Area");
            }else{
                nombrenuevaArea.setText(nombreArea);
            }
        }
    }//GEN-LAST:event_TablaAreasMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField DNI;
    private javax.swing.JTable TablaAreas;
    private java.awt.TextField apellido;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.TextField nombre;
    private java.awt.TextField nombrenuevaArea;
    // End of variables declaration//GEN-END:variables



}
