package org.apache.jsp.Jsps.Inicio_0020de_0020Sesion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controlador.*;
import modelo.*;

public final class recolectarInfoRegistroUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div style=\"text-align:center;\">\n");
      out.write("            ");
      out.write("\n");
      out.write("            <h1>Registrar Usuario</h1>\n");
      out.write("            <table border=\"4\" style=\"margin: 0 auto;\">\n");
      out.write("                <form action=\"registrarUsuario.jsp\">\n");
      out.write("                  <tr>    <td>Usuario:      </td><td>   <input type=\"text\" name=\"nombreUsuario\">    </td>   </tr>\n");
      out.write("                  <tr>    <td> Contraseña:  </td><td>   <input type=\"text\" name=\"contraUsuario\">    </td>   </tr>\n");
      out.write("                  <tr>    <td>Nombre:       </td><td>   <input type=\"text\" name=\"nombreCliente\">    </td>   </tr>\n");
      out.write("                  <tr>    <td>Apellido:     </td><td>   <input type=\"text\" name=\"apellidoCliente\">  </td>   </tr>\n");
      out.write("                  <tr>    <td>DNI:          </td><td>   <input type=\"text\" name=\"dniCliente\">       </td>   </tr>\n");
      out.write("                  <tr>    <td><input type=\"submit\" value=\"Registrarse\" name=\"btnRegistrar\">         </td>\n");
      out.write("                </form>\n");
      out.write("                  <form action=\"iniciorecoltarInfoUsuario.jsp\"> \n");
      out.write("                      <td>  <input type=\"submit\" value=\"Volver\" name=\"btnIniciarsesion\">              </td>\n");
      out.write("                  </form>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        </body>\n");
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
