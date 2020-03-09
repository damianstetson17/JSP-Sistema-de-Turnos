

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
import modelo.Supervisor;
import modelo.Tramite;

public class ModificarSupervisor extends javax.swing.JFrame {
    private Controlador controlador;
    private String nombre,apellido,nombreArea;
    private long dni;
    private boolean confirmado=false;
    private  Area area;
    
    public ModificarSupervisor(Controlador control) {
        initComponents();
        this.controlador=control;
        setTitle("Modificar Supervisor");
        setSize(1000,900);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        PanelInicioModificarSupervisor.setVisible(true);
        PanelActualizarSupervisor.setVisible(false);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);
        jLabel4.setFont(fuente);
        jLabel7.setFont(fuente);
        jLabel8.setFont(fuente);
        nombreNuevo.setFont(fuente);
        ApellidoNuevo.setFont(fuente);       
        DNInuevo.setFont(fuente);        
        AreaNueva.setFont(fuente);  
        TablaAreas .setFont(fuente);       
        TablaSupervisores.setFont(fuente);   
        confirmar   .setFont(fuente);     
        ModificarEmpleado.setFont(fuente);
        btnSalirAtras.setFont(fuente);     
        btnAceptar.setFont(fuente);        
        btnSalir .setFont(fuente);  
        try {
            mostrarSupervisores();
            mostrarAreasActuales();
                    
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }  
    }

    
    private void mostrarAreasActuales() throws NotificarError{
        String matriz[][] = new String[controlador.buscarAreas().size()][1];
         List<Area> areas= controlador.buscarAreas();
         
        int i = 0;
         if(!areas.isEmpty()){
           
            for (Area a : controlador.buscarAreas()) {
            matriz[i][0] = a.getNombreArea();
            
            i++;
        }
        TablaAreas.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Areas"
            }
        ));
       }else{
           TablaAreas.setModel(new DefaultTableModel(
                null,
                new String [] {
                "Areas"
            }
        ));
       } 
    }
    
     private void  mostrarSupervisores()throws NotificarError{
        String matriz[][] = new String[controlador.buscarSupervisores().size()][4];
         List<Supervisor> Supervisores= controlador.buscarSupervisores();
         
        int i = 0;
         if(!Supervisores.isEmpty()){
           
           for (Supervisor e : controlador.buscarSupervisores()) {
            matriz[i][0] = e.getNombre();
            matriz[i][1] = e.getApellido(); 
            matriz[i][2] =String.valueOf(e.getDni()) ; 
            matriz[i][3] = e.getAreaAgregar().getNombreArea();
            i++;
        }
        TablaSupervisores.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Nombre", "Apellido", "DNI", "Area"
            }
        ));
       }else{
           TablaSupervisores.setModel(new DefaultTableModel(
                 null,
                new String [] {
                "Nombre", "Apellido", "DNI", "Area"
            }
        ));
       }
         
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInicioModificarSupervisor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaSupervisores = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        PanelActualizarSupervisor = new javax.swing.JPanel();
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
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelInicioModificarSupervisor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione el Supervisor a modificar:");
        PanelInicioModificarSupervisor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 410, 50));

        TablaSupervisores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Area"
            }
        ));
        TablaSupervisores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSupervisoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaSupervisores);

        PanelInicioModificarSupervisor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 570, 270));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        PanelInicioModificarSupervisor.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 110, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelInicioModificarSupervisor.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 110, 40));

        getContentPane().add(PanelInicioModificarSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 740));

        PanelActualizarSupervisor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Apellido Nuevo:");
        PanelActualizarSupervisor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 150, 60));

        jLabel3.setText("Nombre:");
        PanelActualizarSupervisor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 110, 60));
        PanelActualizarSupervisor.add(ApellidoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 200, 40));
        PanelActualizarSupervisor.add(nombreNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 200, 40));

        jLabel7.setText("DNI:");
        PanelActualizarSupervisor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 90, 40));
        PanelActualizarSupervisor.add(AreaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 200, 40));

        jLabel8.setText("Area de Trabajo:");
        PanelActualizarSupervisor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 180, 50));
        PanelActualizarSupervisor.add(DNInuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 200, 40));

        ModificarEmpleado.setText("Modificar");
        ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEmpleadoActionPerformed(evt);
            }
        });
        PanelActualizarSupervisor.add(ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, 120, 40));

        btnSalirAtras.setText("Salir");
        btnSalirAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAtrasActionPerformed(evt);
            }
        });
        PanelActualizarSupervisor.add(btnSalirAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 130, 40));

        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        PanelActualizarSupervisor.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 160, 60));

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

        PanelActualizarSupervisor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 290, 310));

        jLabel4.setText("Seleccione el area de Trabajo:");
        PanelActualizarSupervisor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 44, 300, 60));

        getContentPane().add(PanelActualizarSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaSupervisoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSupervisoresMouseClicked
        
        int row = TablaSupervisores.getSelectedRow();
        nombre= (String) TablaSupervisores.getValueAt(row, 0);
        apellido= (String) TablaSupervisores.getValueAt(row, 1);
        dni =  Long.parseLong(TablaSupervisores.getValueAt(row, 2).toString()) ;
        nombreArea=(String) TablaSupervisores.getValueAt(row, 3);
         
    }//GEN-LAST:event_TablaSupervisoresMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        /*
            se debe seleccionar a un supervisor de la tabla supervisores
            luego al aceptar, se muestra el jpanel actualizarSupervisor
            donde se ingresan todos los datos que se quiere actualizar, 
            aquellos datos que esten vacios se cargaran con los actuales
            finalmente se instancia un objeto con los datos y se invoca
            al controlador enviandole el dni antiguo del supervisor y la
            instancia del supervisor con todos sus nuevos datos.
        */
        
        try {
            controlador.buscarUnSupervisor(dni);
            area = controlador.buscarUnArea(nombreArea);
            if(area==null){
                JOptionPane.showMessageDialog(null,"el nombre del area ingresada no es correcto");
                PanelInicioModificarSupervisor.setVisible(true);
                PanelActualizarSupervisor.setVisible(false);
            }
            PanelInicioModificarSupervisor.setVisible(false);
            PanelActualizarSupervisor.setVisible(true);
            
           //cargo los labels con todos los datos actuales
            nombreNuevo.setText(nombre);
            ApellidoNuevo.setText(apellido);
            DNInuevo.setText(String.valueOf(dni));
            AreaNueva.setText(nombreArea);
            
            
        } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    private void ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEmpleadoActionPerformed
        String nombrenuevo, apellidonuevo;
        long dninuevo;
        
        /**
         * se cargan y comprueban los datos si no estan vacios
         */
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
        /**
         * se comprueba si preciono el check
         * si es asi se busca el area y comprueba que exista
         * si existe el area se crea el supervisor y se llama a controlador 
         * para que modifique enviando el dni y el supervisor con todos los datos nuevos
         */
        if(confirmado==true){
            try {
               area = controlador.buscarUnArea(nombreArea);
                if(area==null){
                    JOptionPane.showMessageDialog(null,"el nombre del area ingresada no es correcto");
                    PanelInicioModificarSupervisor.setVisible(false);
                    PanelActualizarSupervisor.setVisible(true);
                }
                Supervisor sup= new Supervisor( nombrenuevo,  apellidonuevo,  dninuevo, area );
                //System.out.println(area.getNombreArea());
            
                controlador.actualizarSupervisor(dninuevo, sup);
                JOptionPane.showMessageDialog(null,"se modifico el supervisor ");
                setVisible(true);
                PanelInicioModificarSupervisor.setVisible(true);
                PanelActualizarSupervisor.setVisible(false);
            } catch (NotificarError ex) {
                 JOptionPane.showMessageDialog(null,ex.getMessage());
            }  
        }else{
             JOptionPane.showMessageDialog(null,"Debe confirmar para continuar");
        }
        
    }//GEN-LAST:event_ModificarEmpleadoActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        confirmado=true;
    }//GEN-LAST:event_confirmarActionPerformed

    private void TablaAreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAreasMouseClicked
        int row = TablaAreas.rowAtPoint(evt.getPoint());
        if(row>=0){
            nombreArea =TablaAreas.getValueAt(row, 0).toString()   ;
            if(nombreArea.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un Area");
               
                PanelInicioModificarSupervisor.setVisible(false);
                PanelActualizarSupervisor.setVisible(true);
            }else{
                AreaNueva.setText(nombreArea);
            }
        }   
    }//GEN-LAST:event_TablaAreasMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       dispose();
       MenuSupervisor iralmenu = new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAtrasActionPerformed
        this.setVisible(true);
        PanelInicioModificarSupervisor.setVisible(true);
        PanelActualizarSupervisor.setVisible(false);
    }//GEN-LAST:event_btnSalirAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField ApellidoNuevo;
    private java.awt.TextField AreaNueva;
    private java.awt.TextField DNInuevo;
    private javax.swing.JButton ModificarEmpleado;
    private javax.swing.JPanel PanelActualizarSupervisor;
    private javax.swing.JPanel PanelInicioModificarSupervisor;
    private javax.swing.JTable TablaAreas;
    private javax.swing.JTable TablaSupervisores;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirAtras;
    private javax.swing.JCheckBox confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.TextField nombreNuevo;
    // End of variables declaration//GEN-END:variables



}
