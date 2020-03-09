package vista;

import controlador.*;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Requisito;
import modelo.Tramite;
import modelo.Usuario;

public class ListRequisitoTramite extends javax.swing.JFrame {
   
    
    
    private Controlador controlador;
    private String nombreTramite;
    private Usuario usua;
    
    public ListRequisitoTramite(Controlador control, int nroTurno, String nombreTramiteseleccionado, Usuario usua) {
        this.controlador=control;
        this.usua=usua;
        
        initComponents();
        String numTurno = String.valueOf(nroTurno);
        nombreTramite =nombreTramiteseleccionado;
        labelnroTurno.setText(numTurno);
        setTitle("Requisitos Obligatorios");
        setVisible(true);
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        TablaRequisito.setFont(fuente);
        jLabel2.setFont(fuente);
        labelnroTurno.setFont(fuente);
        salir.setFont(fuente);      
                
                
        try {
            mostrarTablaRequisitoTramite();
        } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
            
    }
    
     private void mostrarTablaRequisitoTramite() throws NotificarError{
        String matriz[][]= new String [controlador.requisitosDeUnTramite(nombreTramite).size()][2];
        List <Requisito> requisitos= controlador.requisitosDeUnTramite(nombreTramite);
        System.out.println(requisitos.size());
        if(!requisitos.isEmpty()){
            int i=0;
            for(Requisito r: requisitos){
                matriz[i][0]=r.getNombreRequisito();
                i++;
            }
            TablaRequisito.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                ""
            }
            ));
       }else{
            TablaRequisito.setModel(new DefaultTableModel(
            null,
             new String [] {
                ""
            }
             ));
       }        
                         
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaRequisito = new javax.swing.JTable();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelnroTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Recuerde concurrir con los siguientes requisitos:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 430, 60));

        TablaRequisito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        jScrollPane1.setViewportView(TablaRequisito);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 370, 360));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 110, 50));

        jLabel2.setText("Su numero de Turno es:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 210, 50));
        jPanel1.add(labelnroTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 110, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
        MenuCliente irAlMenu = new MenuCliente(controlador,usua); 
    }//GEN-LAST:event_salirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaRequisito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelnroTurno;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables



}
