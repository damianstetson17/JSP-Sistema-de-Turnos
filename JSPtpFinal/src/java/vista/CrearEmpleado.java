
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Area;
import modelo.Empleado;
import modelo.Tramite;

public class CrearEmpleado extends javax.swing.JFrame {
    
    private Controlador controlador;
  
    
    public CrearEmpleado(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        
        setTitle("Registrar Nuevo Empleado");
        setVisible(true);
        this.setSize(950, 750);
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
        ComboArea.setFont(fuente);      
        TablaEmpleados.setFont(fuente);
                
                
                
        cargarComboArea ();
        try {
            mostrarEmpleados();
        } catch (NotificarError ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    private void mostrarEmpleados() throws NotificarError{
      
        String matriz[][]= new String [controlador.buscarEmpleados().size()][4];
        int i=0;
        for(Empleado e:controlador.buscarEmpleados() ){
            matriz[i][0]=e.getNombre();
            matriz[i][1]=e.getApellido();
            matriz[i][2]=String.valueOf(e.getDni());
      
            i++;
        } 
         TablaEmpleados.setModel(new DefaultTableModel(
            matriz,
               new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ));
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
        btnCrear = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        ComboArea = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 90, 50));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 250, 40));

        jLabel2.setText("Apellido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 100, 40));
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 250, 40));

        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 80, 40));
        jPanel1.add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 250, 40));

        jLabel4.setText("Area de Trabajo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 150, 60));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 100, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 100, 40));

        ComboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAreaActionPerformed(evt);
            }
        });
        jPanel1.add(ComboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 250, 50));

        jLabel5.setText("Empleados:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 160, 40));

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ));
        jScrollPane1.setViewportView(TablaEmpleados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 410, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nomb, ape, nombreAreaTrabajo;
        long dni;
        nomb=nombre.getText();
        ape=apellido.getText();
        nombreAreaTrabajo= ComboArea.getSelectedItem().toString();
        
        if(ComboArea.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Debe seleccionar un Area"); 
            }
        if((nomb.equals("")) || (ape.equals("")) || DNI.getText().equals("") || nombreAreaTrabajo.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar correctamente todos los datos");
            setVisible(true);
            
        }else{
             try {
                 dni= Long.parseLong(DNI.getText());
                 if((dni==0) || (10000000>dni)){
                     JOptionPane.showMessageDialog(null, "El DNI ingresado es incorrecto.");
                 }else{
                     
                      Area areatrab= controlador.buscarUnArea(nombreAreaTrabajo);
                    if(areatrab==null){
                        JOptionPane.showMessageDialog(null, "No existe un Area con el nombre ingresado.");
                        setVisible(true);
                    }else
                        controlador.crearUnEmpleado(nomb, ape, dni, nombreAreaTrabajo);
                        JOptionPane.showMessageDialog(null, "se creo el empleado ");
                        dispose();
                        MenuSupervisor iralmemu = new MenuSupervisor(controlador);
                 }
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }    
        }    
    }//GEN-LAST:event_btnCrearActionPerformed

     private void cargarComboArea () {
            try{
                for(Area a: controlador.buscarAreas()){
                    ComboArea.addItem(a.getNombreArea());  
                }
            } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }     
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ComboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboAreaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboArea;
    private java.awt.TextField DNI;
    private javax.swing.JTable TablaEmpleados;
    private java.awt.TextField apellido;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField nombre;
    // End of variables declaration//GEN-END:variables
}
