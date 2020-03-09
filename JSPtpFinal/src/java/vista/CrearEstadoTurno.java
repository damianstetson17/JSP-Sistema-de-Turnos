
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoTurno;

public class CrearEstadoTurno extends javax.swing.JFrame {

    
    
    private Controlador controlador;
    
    public CrearEstadoTurno(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        setTitle("Crear Nuevo Estado Turno");
        setVisible(true);
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);       
        nombreestado.setFont(fuente);
        TablaEstados.setFont(fuente);       
        btnAceptar.setFont(fuente);       
        btnSalir.setFont(fuente);
                
        try {
            mostrarEstados();
        } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
               
        
    }

    
    /**
     * muestra en la tabla todos los estados turnos actuales almacenados en la BD.
     * @throws NotificarError 
     **/
    private void mostrarEstados() throws NotificarError{
       String matriz[][]= new String [controlador.buscarEstadsTurnos().size()][1];
        int i=0;
        for(EstadoTurno et:controlador.buscarEstadsTurnos() ){
            matriz[i][0]=et.getNombreEstado();
            i++;
        } 
         TablaEstados.setModel(new DefaultTableModel(
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
        nombreestado = new java.awt.TextField();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEstados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Estado:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, 50));
        jPanel1.add(nombreestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 200, 40));

        btnAceptar.setText("Crear");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 90, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 90, 40));

        TablaEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TablaEstados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 270, 280));

        jLabel2.setText("Estados Turno actuales:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 230, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * metodo al hacer click en boton salir
     * @param evt 
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    
    /**
     * al aceptar se obtiene el nombre del estado, controla si no esta vacio
     * y se llama a controlador para crear el nuevo estado turno
     * finalmente se cierra la ventana y se vuelve al menu
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String  nombre=nombreestado.getText();
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
            setVisible(true);
            
        }else{
            try {
                controlador.crearUnEstadoTurno(nombre);
                JOptionPane.showMessageDialog(null, "se creo el estado turno "+nombre);
                dispose();
                MenuSupervisor iralmenu = new MenuSupervisor(controlador);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEstados;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField nombreestado;
    // End of variables declaration//GEN-END:variables



}
