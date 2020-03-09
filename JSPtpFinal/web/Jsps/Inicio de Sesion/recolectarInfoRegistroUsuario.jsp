<%@page import="controlador.*"%>
<%@ page import = "modelo.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align:center;">
            <%-- formulario que recolecat los datos para crear al cliente--%>
            <h1>Registrar Usuario</h1>
            <table border="4" style="margin: 0 auto;">
                <form action="registrarUsuario.jsp">
                  <tr>    <td>Usuario:      </td><td>   <input type="text" name="nombreUsuario">    </td>   </tr>
                  <tr>    <td> Contraseña:  </td><td>   <input type="text" name="contraUsuario">    </td>   </tr>
                  <tr>    <td>Nombre:       </td><td>   <input type="text" name="nombreCliente">    </td>   </tr>
                  <tr>    <td>Apellido:     </td><td>   <input type="text" name="apellidoCliente">  </td>   </tr>
                  <tr>    <td>DNI:          </td><td>   <input type="text" name="dniCliente">       </td>   </tr>
                  <tr>    <td><input type="submit" value="Registrarse" name="btnRegistrar">         </td>
                </form>
                  <form action="iniciorecoltarInfoUsuario.jsp"> 
                      <td>  <input type="submit" value="Volver" name="btnIniciarsesion">              </td>
                  </form>
            </table>
        </div>
        </body>
</html>
