<%@page import="errores.NotificarError"%>
<%@page import="vista.CrearCliente"%>
<%@page import="javax.swing.JOptionPane"%>
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
        
        <%-- declaracion de variables--%>
        <%! 
            private Controlador controlador;
            private Persistencia persistencia;
            private String email=null, contrasenia=null,nombreCli=null,apellidoCli=null,dniCLiente=null;  
            private Long dni=null;
            private Usuario usu;
        %>
        
        <%
            persistencia= new Persistencia();     
            controlador = new Controlador(persistencia);
            //cargamos las variables con lo que trae el form de arriba
            email=request.getParameter("nombreUsuario");
            contrasenia=request.getParameter("contraUsuario");
            nombreCli=request.getParameter("nombreCliente");
            apellidoCli=request.getParameter("nombreCliente");
            dniCLiente=request.getParameter("dniCliente");           

            //si alguno de los campos esta vacio
            if((email.equals(""))||(contrasenia.equals(""))||(nombreCli.equals(""))||(apellidoCli.equals(""))||(dniCLiente.equals(""))){
                out.println("Debe ingresar correctamente todos los campos.");
                
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
                    String mensajeError ="Error no se genero el Usuario ("+ex.getMessage()+").";
                    out.println(mensajeError);
                }
            }
        %>
        <form action="recolectarInfoRegistroUsuario.jsp"><input type="submit" value="Volver" name="btnVolver"></form>
    </body>
</html>
