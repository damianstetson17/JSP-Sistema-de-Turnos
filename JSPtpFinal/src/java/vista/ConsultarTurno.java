
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Turno;
import modelo.Usuario;


public class ConsultarTurno extends javax.swing.JFrame {
 
   
    private Controlador controlador;
    private int nroTurno;
    private Turno turno; 
     private Usuario usua;
     private long dni;
     
    public ConsultarTurno(Controlador controlador,  Usuario usua)  {
        initComponents();
        this.controlador=controlador;
        this.usua=usua;
        setTitle("Consultar un Turno");
        setVisible(true);
        this.setSize(800, 650);
        PanelTurnoConsultar.setSize(800, 650);
        PanelTurnoConsultar.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel2.setFont(fuente);
        TablaDatosTurno.setFont(fuente);
        btnSalir.setFont(fuente);      
        
        try {
            Cliente cli= controlador.buscarClienteDelUsuario(usua);
            dni=cli.getDni();
           mostrarTablaDatosTurno(dni);
        } catch (NotificarError ex) {
          JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
    }

    
  
     private void mostrarTablaDatosTurno(long dni) throws NotificarError{
       String matriz[][]= new String [controlador.obtenerTurnosDeCliente(dni).size()][3];
       List <Turno> turnos= controlador.obtenerTurnosDeCliente(dni);
      
       if(!turnos.isEmpty()){
        int i=0;
        for(Turno t: turnos){
            
            matriz[i][0]=String.valueOf(t.getNroTurno());
            matriz[i][1]=t.getFechaSolicitud().toString();
            matriz[i][2]=t.getEstado().getNombreEstado();
          
            i++;
        }
         TablaDatosTurno.setModel(new DefaultTableModel(
            matriz,
            new String [] {
                "Nro Turno", "Fecha de Solicitud", "Estado"
            }
        ));
       }else{
           TablaDatosTurno.setModel(new DefaultTableModel(
            null,
            new String [] {
                "Nro Turno", "Fecha de Solicitud", "Estado"
            }
             ));
       }
    }
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTurnoConsultar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosTurno = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTurnoConsultar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Sus turnos:");
        PanelTurnoConsultar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, 50));

        TablaDatosTurno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nro Turno", "Fecha de Solicitud", "Estado"
            }
        ));
        jScrollPane1.setViewportView(TablaDatosTurno);

        PanelTurnoConsultar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 660, 280));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelTurnoConsultar.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 100, 50));

        getContentPane().add(PanelTurnoConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        dispose();
        MenuCliente iralmenuCliente = new MenuCliente(controlador,usua);
        
        
    }//GEN-LAST:event_btnSalirActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTurnoConsultar;
    private javax.swing.JTable TablaDatosTurno;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables



}
