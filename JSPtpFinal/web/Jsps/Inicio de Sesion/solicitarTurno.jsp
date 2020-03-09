<%@page import="modelo.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.*"%>
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
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            private Controlador controlador;
            private Persistencia persistencia;
            private Cliente cliente;
            private String prioridadAgregar,nombreTramAgregar;
            private Long dniCliente;
           
        %>
        
        <% 
           persistencia=new Persistencia();
           controlador= new Controlador(persistencia);
           prioridadAgregar=request.getParameter("prioridad");
           nombreTramAgregar=request.getParameter("nombreTramite");
           
            try{
                java.util.Date fechaSolicitud = new java.util.Date();
                dniCliente=Long.parseLong(request.getParameter("dniCliente"));
                cliente=controlador.buscarUnCliente(dniCliente);
                controlador.creaUnTurno(fechaSolicitud,"en espera",prioridadAgregar , nombreTramAgregar, cliente);
                out.println("Se creo con exito el Turno."); 
            }catch(Exception ex){
                String mensajeError ="Error no se genero el Turno ("+ex.getMessage()+").";
                out.println(mensajeError);
            }
        %>
        <form action="iniciorecoltarInfoUsuario.jsp"><input type="submit" value="Volver" name="btnVolver"></form>
    </body>
</html>
