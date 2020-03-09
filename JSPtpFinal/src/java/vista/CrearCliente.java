
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;

import modelo.Cliente;

public class CrearCliente extends javax.swing.JFrame {
    
   private Controlador controlador;
    private Usuario usu;
  
    
    public CrearCliente(Controlador controlador, Usuario unUsuario) {
        initComponents();
        this.controlador=controlador;
      
        setTitle("Registrar Cliente");
        setVisible(true);
        this.setSize(700, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        usu=unUsuario;
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);
        nombre.setFont(fuente);
        apellido.setFont(fuente);
        DNI.setFont(fuente);    
        btnCrear.setFont(fuente);        
        btnSalir .setFont(fuente);      
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
        btnCrear = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 100, 50));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 280, 40));

        jLabel2.setText("Apellido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 100, 50));
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 280, 40));

        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 90, 50));
        jPanel1.add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 270, 40));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 110, 50));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        /*
            al crear se cargan y controlan los atributos y se lo mandan al controlador 
            para que lo cree, una vez creado se llama a la ventana de inicio para que 
            el nuevo cliente inicie sesion
        */
        
        String nomb, ape;
        long dni;
        nomb=nombre.getText();
        ape=apellido.getText();
        dni= Long.parseLong(DNI.getText());
        boolean activo=true;
      
        if((nomb.equals("")) || (ape.equals("")) || (dni==0) || (1000000>dni)){
             JOptionPane.showMessageDialog(null, "Debe ingresar correctamente los datos");
            setVisible(true);
        }else{
            try {
                controlador.crearUnCliente(nomb, ape, dni, activo,  usu);
             
                dispose();
                Inicioo iralinicio= new Inicioo(controlador);
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage()); 
            }
            
        }
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        Inicioo inicio =new Inicioo(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField DNI;
    private java.awt.TextField apellido;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextField nombre;
    // End of variables declaration//GEN-END:variables
}
