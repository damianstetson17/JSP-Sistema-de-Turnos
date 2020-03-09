<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div style="text-align:center;">
             <!--Titulos de inciio-->
            <h1 style="font-family:verdana;">Bienvenido      </h1>   
            <h2 style="font-family:verdana;">Inicio de Sesion</h2>  
        <table border="4" style="margin: 0 auto;">
            <!--Formulario que recolecta datos del usuario-->
            <form action="recolectarInfoSesionUsuario.jsp">
                <tr>    <td>    Usuario:    </td>       <td>    <input type="text" name="nombreUsuario">    </td>   </tr>
                <tr>    <td>    Contraseña: </td>       <td>    <input type="password" name="contraUsuario"></td>   </tr>
                <tr>    <td>    <input type="submit" value="Iniciar Sesion" name="btnIniciarsesion">        </td>   
            </form>
            <!--Formulario que invoca registrarse-->
            <form action="recolectarInfoRegistroUsuario.jsp"> 
                        <td>    <input type="submit" value="No tengo Cuenta" name="btnRegistrase">                  </tr>
            </form>
        </table>
       </div
    </body>
</html>
