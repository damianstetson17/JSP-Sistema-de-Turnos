
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
import modelo.Empleado;


public class ModificarEmpleado extends javax.swing.JFrame {

    private Controlador controlador;
    private long dni;
    private String nombre,apellido,nombreArea;
    private  boolean confirmado=false,confirmado2=false;
    private Area area;
    private Empleado empleado;

    public ModificarEmpleado(Controlador control) {
        this.controlador=control;
        initComponents();
        setVisible(true);
        setTitle("Modificar");
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.panelInicioModificarEmpleado.setSize(700, 550);
        this.panel2ModifcarEmpelado.setSize(900, 1000);
        panel2ModifcarEmpelado.setVisible(false);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);
        jLabel7.setFont(fuente);
        jLabel8.setFont(fuente);
        nombreNuevo.setFont(fuente);
        ApellidoNuevo.setFont(fuente);       
        DNInuevo.setFont(fuente);        
        AreaNueva.setFont(fuente);  
        TablaAreas .setFont(fuente);       
        tablaEmpleados.setFont(fuente);   
        confirmar1.setFont(fuente);
        confirmar   .setFont(fuente);     
        ModificarEmpleado.setFont(fuente);
        btnSalirAtras.setFont(fuente);     
        btnAceptar.setFont(fuente);        
        btnSalir .setFont(fuente);    
        
        
        
        
        this.setLocationRelativeTo(null);
        try {
            mostrarEmpleados();
            
        } catch (NotificarError ex) {
            Logger.getLogger(ModificarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicioModificarEmpleado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        confirmar1 = new javax.swing.JCheckBox();
        panel2ModifcarEmpelado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ApellidoNuevo = new java.awt.TextField();
        nombreNuevo = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        AreaNueva = new java.awt.TextField();
        jLabel8 = new javax.swing.JLabel();
        DNInuevo = new java.awt.TextField();
        ModificarEmpleado = new javax.swing.JButton();
        btnSalirAtras = new javax.swing.JButton();
        confirmar = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAreas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInicioModificarEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "nombre", "apellido", "dni", "area"
            }
        ));
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        panelInicioModificarEmpleado.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 480, 410));

        jLabel1.setText("Seleccione el Empelado a modificar:");
        panelInicioModificarEmpleado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 320, 40));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelInicioModificarEmpleado.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 110, 50));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelInicioModificarEmpleado.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 110, 50));

        confirmar1.setText("Confirmar");
        confirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar1ActionPerformed(evt);
            }
        });
        panelInicioModificarEmpleado.add(confirmar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 140, 50));

        getContentPane().add(panelInicioModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1050, 740));

        panel2ModifcarEmpelado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Apellido:");
        panel2ModifcarEmpelado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 140, 60));

        jLabel3.setText("Nombre:");
        panel2ModifcarEmpelado.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 120, 50));
        panel2ModifcarEmpelado.add(ApellidoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 280, 40));
        panel2ModifcarEmpelado.add(nombreNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 280, 40));

        jLabel7.setText("DNI:");
        panel2ModifcarEmpelado.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 70, 40));
        panel2ModifcarEmpelado.add(AreaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 280, 40));

        jLabel8.setText("Area de Trabajo:");
        panel2ModifcarEmpelado.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 160, 50));
        panel2ModifcarEmpelado.add(DNInuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 280, 40));

        ModificarEmpleado.setText("Modificar");
        ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEmpleadoActionPerformed(evt);
            }
        });
        panel2ModifcarEmpelado.add(ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 120, 40));

        btnSalirAtras.setText("Salir");
        btnSalirAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAtrasActionPerformed(evt);
            }
        });
        panel2ModifcarEmpelado.add(btnSalirAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, 110, 40));

        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        panel2ModifcarEmpelado.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 465, 150, 70));

        TablaAreas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Areas"
            }
        ));
        TablaAreas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAreasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaAreas);

        panel2ModifcarEmpelado.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 250, 240));

        getContentPane().add(panel2ModifcarEmpelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 0, 1150, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//matriz empelados
private void mostrarEmpleados() throws NotificarError{
       String matriz[][] = new String[controlador.buscarEmpleados().size()][4];
         List<Empleado> empleados= controlador.buscarEmpleados();
         
        int i = 0;
         if(!empleados.isEmpty()){
           
            for (Empleado e : controlador.buscarEmpleados()) {
            matriz[i][0] = e.getNombre();
            matriz[i][1] = e.getApellido(); 
            matriz[i][2] =String.valueOf(e.getDni()) ; 
            matriz[i][3] = e.getAreaTrabajo().getNombreArea();
            i++;
        }
        tablaEmpleados.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "nombre", "apellido", "dni", "area"
            }
        ));
       }else{
           tablaEmpleados.setModel(new DefaultTableModel(
                null,
                new String [] {
                "nombre", "apellido", "dni", "area"
            }
        ));
       }   
    }    
//botones
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       if(confirmado==true && dni!=0)
        {
        try {
            controlador.buscarUnEmpleado(dni);
            empleado = controlador.buscarUnEmpleado(dni);
            if(empleado==null){
                JOptionPane.showMessageDialog(null,"Seleccione un Empleado");
                panelInicioModificarEmpleado.setVisible(true);
                panel2ModifcarEmpelado.setVisible(false);
            }
            panelInicioModificarEmpleado.setVisible(false);
            panel2ModifcarEmpelado.setVisible(true);
            mostrarAreasActuales();
            

            //cargo los labels con todos los datos actuales
            nombreNuevo.setText(nombre);
            ApellidoNuevo.setText(apellido);
            DNInuevo.setText(String.valueOf(dni));
            AreaNueva.setText(nombreArea);

        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
       }else{
               JOptionPane.showMessageDialog(null,"Debe seleccionar un Empleado y confirmar para continuar");
               }
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEmpleadoActionPerformed
        String nombrenuevo, apellidonuevo;
        long dninuevo;

        //cargo los nuevos datos
        nombrenuevo= nombreNuevo.getText();
        apellidonuevo= ApellidoNuevo.getText();
        dninuevo=Long.parseLong( DNInuevo.getText());

        if(nombrenuevo==null){
            nombrenuevo=nombre;
            nombreNuevo.setText(nombre);
        }
        if(apellidonuevo==null){
            apellidonuevo=apellido;
            ApellidoNuevo.setText(apellido);
        }
        if(dninuevo==0){
            dninuevo=dni;
            DNInuevo.setText(String.valueOf(dni));
        }

        if(confirmado2==true){
            try {
                area = controlador.buscarUnArea(nombreArea);
                if(area==null){
                    JOptionPane.showMessageDialog(null,"el nombre del area ingresada no es correcto");
                    panelInicioModificarEmpleado.setVisible(false);
                    panel2ModifcarEmpelado.setVisible(true);
                }

                Empleado emple= new Empleado( nombrenuevo,  apellidonuevo,  dninuevo, area );
                System.out.println(area.getNombreArea());

                controlador.actualizaUnEmpleado(dninuevo, emple);
                JOptionPane.showMessageDialog(null,"se modifico con exito");
                setVisible(true);
                panelInicioModificarEmpleado.setVisible(false);
                panel2ModifcarEmpelado.setVisible(true);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe confirmar para continuar");
        }

    }//GEN-LAST:event_ModificarEmpleadoActionPerformed
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
    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
       confirmado2 = true;
    }//GEN-LAST:event_confirmarActionPerformed

    private void TablaAreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAreasMouseClicked

        int row = TablaAreas.rowAtPoint(evt.getPoint());

        if(row>=0){
            nombreArea =TablaAreas.getValueAt(row, 0).toString()   ;
            if(nombreArea.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un empleado");
                this.panelInicioModificarEmpleado.setSize(1500, 1000);
                this.panel2ModifcarEmpelado.setSize(1500, 1000);
                panelInicioModificarEmpleado.setVisible(false);
                panel2ModifcarEmpelado.setVisible(true);
            }else{
                AreaNueva.setText(nombreArea);
            }
        }

    }//GEN-LAST:event_TablaAreasMouseClicked

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        int row = tablaEmpleados.rowAtPoint(evt.getPoint());
         nombre = (String) tablaEmpleados.getValueAt(row, 0);
         apellido = (String) tablaEmpleados.getValueAt(row, 1);
         dni = Long.parseLong(tablaEmpleados.getValueAt(row, 2).toString());
         nombreArea = (String) tablaEmpleados.getValueAt(row, 3);
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void btnSalirAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAtrasActionPerformed
        panelInicioModificarEmpleado.setVisible(true);
                panel2ModifcarEmpelado.setVisible(false);
    }//GEN-LAST:event_btnSalirAtrasActionPerformed

    private void confirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar1ActionPerformed
        confirmado=true;
    }//GEN-LAST:event_confirmar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField ApellidoNuevo;
    private java.awt.TextField AreaNueva;
    private java.awt.TextField DNInuevo;
    private javax.swing.JButton ModificarEmpleado;
    private javax.swing.JTable TablaAreas;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirAtras;
    private javax.swing.JCheckBox confirmar;
    private javax.swing.JCheckBox confirmar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.TextField nombreNuevo;
    private javax.swing.JPanel panel2ModifcarEmpelado;
    private javax.swing.JPanel panelInicioModificarEmpleado;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
