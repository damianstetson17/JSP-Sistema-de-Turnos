
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Usuario;


public class Inicioo extends javax.swing.JFrame {

    private Controlador controlador;
    private String email, contraseña;
  
    
    public Inicioo(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        setVisible(true);
        this.setResizable(false);
        this.setSize(800, 650);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        setTitle("Inicio");
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        emailIngresado.setFont(fuente);
        contraseniaIngresado.setFont(fuente);        
        jCheckBox1.setFont(fuente);
        btnRegistrarse.setFont(fuente);
        btnIniciar.setFont(fuente);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarse = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        emailIngresado = new javax.swing.JTextField();
        contraseniaIngresado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 150, 50));

        btnIniciar.setText("Iniciar Sesion");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 180, 50));
        getContentPane().add(emailIngresado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 350, 40));

        contraseniaIngresado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseniaIngresadoActionPerformed(evt);
            }
        });
        getContentPane().add(contraseniaIngresado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 350, 40));

        jLabel1.setText("E-mail:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 80, 30));

        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 100, 30));

        jCheckBox1.setText("No soy Cliente");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 180, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        /*
            al seleccionar registrarse se crea un usuario y contrasenia nuevos
            y se envia ese objeto al jframe crearcliente junto con el controlador
            para crear un cliente con ese usuario, cuando se crea el cliente
            retorna a este jframe (inicio) para iniciar sesion
        */
    
        
        email= emailIngresado.getText();
        contraseña=contraseniaIngresado.getText();
       
        if(email.equals("")  || contraseña.equals("")){
            JOptionPane.showMessageDialog(null,"Debe ingresar e-mail y/o contraseña"); 
             setVisible(true);
        }else{
            try {
                
                controlador.crearUnUsuario(email,contraseña);
                JOptionPane.showMessageDialog(null, "se registro su usuario con exito"); 
                Usuario unUsuario=controlador.buscarUnUsuario(email);
                dispose();
                
               CrearCliente crearCliente = new CrearCliente(controlador,unUsuario);
                
            } catch (NotificarError ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
                    
        
        
        }
     
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        email= emailIngresado.getText();
        contraseña=contraseniaIngresado.getText();
       
        if(email.equals("")  || contraseña.equals("")){
            JOptionPane.showMessageDialog(null,"Debe ingresar e-mail y/o contraseña"); 
             setVisible(true);
        }else{
            try {
                Usuario usua= controlador.buscarUnUsuario(email);
                if(usua!=null){
                    JOptionPane.showMessageDialog(null, "bienvenida: "+usua.getEmail());
                    dispose(); 
                    MenuCliente irAMenuClientee = new MenuCliente(controlador, usua);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro el usuario ingresado.");
                    setVisible(true);
                }
            } catch (NotificarError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       
        dispose();
        InicioTrabajador irAlInicio =new InicioTrabajador(controlador);
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void contraseniaIngresadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseniaIngresadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseniaIngresadoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JTextField contraseniaIngresado;
    private javax.swing.JTextField emailIngresado;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables



}
