package org.apache.jsp.Jsps.Inicio_0020de_0020Sesion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import errores.NotificarError;
import vista.CrearCliente;
import javax.swing.JOptionPane;
import controlador.*;
import modelo.*;

public final class registrarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
            private Controlador controlador;
            private Persistencia persistencia;
            private String email=null, contrasenia=null,nombreCli=null,apellidoCli=null,dniCLiente=null;  
            private Long dni=null;
            private Usuario usu;
        
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            persistencia= new Persistencia();     
            controlador = new Controlador(persistencia);
            //cargamos las variables con lo que trae el form de arriba
            email=request.getParameter("nombreUsuario");
            contrasenia=request.getParameter("contraUsuario");
            nombreCli=request.getParameter("nombreCliente");
            apellidoCli=request.getParameter("nombreCliente");
            dniCLiente=request.getParameter("dniCliente");           
            out.println("hola: ("+dniCLiente+")");
            //si alguno de los campos esta vacio
            if((email.equals(null))||(contrasenia.equals(null))||(nombreCli.equals(null))||(apellidoCli.equals(null))||(dniCLiente==null)){
                out.println("Debe ingresar correctamente todos los campos");
                
            }else{
                try{
                //creamos el usuario con los metodos de controlador
                controlador.crearUnUsuario(email, contrasenia);
                //creamo el cliente con los metodos de controlador
                usu=controlador.buscarUnUsuario(email);
                dni=Long.parseLong(dniCLiente);
                controlador.crearUnCliente(nombreCli, apellidoCli, dni, true,  usu);
                String mensajeExito = String.format("Se creo con exito el Usuario %d con DNI %d",nombreCli,dniCLiente);
                out.println(mensajeExito);
                }catch(Exception ex){
                    String mensajeError ="Error no se genero el Usuario: "+ex.getMessage();
                    out.println(mensajeError);
                }
            }
        
      out.write("\n");
      out.write("        <form action=\"recolectarInfoRegistroUsuario.jsp\"><input type=\"submit\" value=\"Volver\" name=\"btnVolver\"></form>\n");
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
