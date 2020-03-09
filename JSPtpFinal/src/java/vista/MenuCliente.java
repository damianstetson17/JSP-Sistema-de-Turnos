
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;


public class MenuCliente extends javax.swing.JFrame {
   
  
    
    private Controlador controlador;
    private Usuario usuario;
    
    public MenuCliente(Controlador controlador, Usuario usua) {
          
        initComponents();
        this.controlador=controlador;
        this.usuario=usua;
        Font fuente= new Font("Dialog",18,20);
        setFont(fuente);
        jMenu1.setFont(fuente);
        jMenu1.setSize(18, 20);
        SolicitarTurno.setFont(fuente);
        CancelarTurno.setFont(fuente);
        jMenuItem1.setFont(fuente);
        salir.setFont(fuente);
        
        setTitle("Menu");
        this.setSize(650, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        Inicio = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        SolicitarTurno = new javax.swing.JMenuItem();
        CancelarTurno = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("Inicio");

        SolicitarTurno.setText("Solicitar Turno");
        SolicitarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitarTurnoActionPerformed(evt);
            }
        });
        jMenu1.add(SolicitarTurno);

        CancelarTurno.setText("Cancelar Turno");
        CancelarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarTurnoActionPerformed(evt);
            }
        });
        jMenu1.add(CancelarTurno);

        jMenuItem1.setText("Consultar Turno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        Inicio.add(jMenu1);

        setJMenuBar(Inicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
       
        dispose();
       Inicioo retornarInicio= new Inicioo(controlador);
        
    }//GEN-LAST:event_salirActionPerformed

    private void SolicitarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitarTurnoActionPerformed

       dispose();
       SolicitarTurno solicitarUnTurno = new SolicitarTurno(controlador, usuario);
        
    }//GEN-LAST:event_SolicitarTurnoActionPerformed

    private void CancelarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarTurnoActionPerformed
        dispose(); 
       CancelarUnTurno cancelarUnTurno= new CancelarUnTurno(controlador, usuario);
    
    }//GEN-LAST:event_CancelarTurnoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      dispose();
      //abre JFrame listado de turnos pendientes de un cliente
      ConsultarTurno consultarturno = new ConsultarTurno(controlador, usuario);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CancelarTurno;
    private javax.swing.JMenuBar Inicio;
    private javax.swing.JMenuItem SolicitarTurno;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables



}
