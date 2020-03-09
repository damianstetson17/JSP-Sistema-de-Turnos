package org.apache.jsp.Jsps.Inicio_0020de_0020Sesion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.*;
import controlador.*;

public final class recolectarInfoSesionUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            private Controlador controlador;
            private Persistencia persistencia;
            private String email, contrasenia;  
            private Cliente cliente;
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>  \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            persistencia= new Persistencia();     
            controlador = new Controlador(persistencia);
            
            //recolectamos info del form
            email=request.getParameter("nombreUsuario");
            contrasenia=request.getParameter("contraUsuario");
            //buscamos al cliente de ese usuario ingresado
            cliente=controlador.buscarUnClienteUsuario(email, contrasenia);         
        
      out.write("\n");
      out.write("        <h2>Turnos Actuales:</h2>\n");
      out.write("        <table border=\"1\" >\n");
      out.write("            <tr>\n");
      out.write("                    <td><label id=\"label-1\">Fecha Solicitud:</label></td>\n");
      out.write("                    <td><label id=\"label-1\">Num. Turno :</label></td>\n");
      out.write("                    <td><label id=\"label-1\">Estado :</label></td>\n");
      out.write("                    <td><label id=\"label-1\">Prioridad Turno:</label></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                try{
                    List<Turno> turnos=cliente.getTurnos();
                    for(Turno t : turnos)
                    {
                        if((!(t.getEstado().getNombreEstado().equals("atendido")))||(!(t.getEstado().getNombreEstado().equals("baja"))))
                        {
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><input value=\"");
      out.print(format.format(t.getFechaSolicitud()) );
      out.write("\" type=\"text\" name=\"x1\"></td>\n");
      out.write("                    <td><input value=\"");
      out.print(t.getNroTurno() );
      out.write("\" type=\"text\" name=\"x1\"></td>\n");
      out.write("                    <td><input value=\"");
      out.print(t.getEstado().getNombreEstado() );
      out.write("\" type=\"text\" name=\"x1\"></td>\n");
      out.write("                    <td><input value=\"");
      out.print(t.getPrioridad().getNombrePrioridad() );
      out.write("\" type=\"text\" name=\"x1\"></td>\n");
      out.write("                </tr>\n");
      out.write("            ");

                   }
                        }
                }catch(Exception ex){
                    out.println("No se ingreso correctamente los datos de Usuario");
                }
            
      out.write("\n");
      out.write("        </table>   \n");
      out.write("        <form action=\"cancelarTurno.jsp\"><input type=\"text\" value=\"\" name=\"nroDelTurnoCancelar\">\n");
      out.write("        <input type=\"submit\" value=\"Cancelar Turno\" name=\"btnCancelar\"></form>\n");
      out.write("        <br></br>\n");
      out.write("        <h2>Solicitar Turno:</h2>\n");
      out.write("             <table border=\"1\" >\n");
      out.write("            <tr>\n");
      out.write("                    <td><label id=\"label-1\">Nombre Tramite:</label></td>\n");
      out.write("            </tr>\n");
      out.write("                ");

                    List<Tramite> tramites = controlador.buscarTramites();
                    for(Tramite t : tramites)
                    {
                 
      out.write("\n");
      out.write("                 <tr>\n");
      out.write("                     <td><input value=\"");
      out.print(t.getNombreTramite());
      out.write("\" type=\"text\" name=\"x1\"></td>\n");
      out.write("                 </tr>\n");
      out.write("                    ");

                     }
                    
      out.write("\n");
      out.write("                    <table border=\"1\" >\n");
      out.write("            <tr>\n");
      out.write("                    <td><label id=\"label-1\">Nombre Prioridad</label></td>\n");
      out.write("            </tr>\n");
      out.write("                ");

                    List<Prioridad> prioridades = controlador.buscarPrioridades();
                    for(Prioridad p : prioridades)
                    {
                 
      out.write("\n");
      out.write("                 <tr>\n");
      out.write("                     <td><input value=\"");
      out.print(p.getNombrePrioridad());
      out.write("\" type=\"text\" name=\"x1\"></td>\n");
      out.write("                 </tr>\n");
      out.write("                    ");

                     }
                    
      out.write("\n");
      out.write("                    <div style=\"float: bottom;\">\n");
      out.write("                        ");
 try{
      out.write("\n");
      out.write("                <form action=\"solicitarTurno.jsp\">\n");
      out.write("                    <input type=\"text\" value=\"Nombre de Tramite\" name=\"nombreTramite\">\n");
      out.write("                    <input type=\"text\" value=\"Nombre de Prioridad\" name=\"prioridad\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print( cliente.getDni());
      out.write("\" name=\"dniCliente\">\n");
      out.write("                    <input type=\"submit\" value=\"Solicitar Turno\" name=\"btnSolicitar\">\n");
      out.write("                </form> \n");
      out.write("                ");
 }catch(Exception ex){
                        out.println("No se ingreso correctamente los datos de Usuario");
                    }
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <form action=\"iniciorecoltarInfoUsuario.jsp\"><input type=\"submit\" value=\"Salir\" name=\"btnVolver\"></form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
