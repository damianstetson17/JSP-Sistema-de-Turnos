<%@page import="modelo.Turno"%>
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
                private Controlador controlador;
                private Persistencia persistencia;
                private int nroTurno;
                private String nroDelTurnoString;
            %>

            <%
              //se inicializan las variables y se recogen los valores del Form anterioi
               persistencia= new Persistencia();
               controlador= new Controlador(persistencia);
               nroDelTurnoString=request.getParameter("nroDelTurnoCancelar").toString();
               

               try{
                   nroTurno=Integer.parseInt(nroDelTurnoString); 
                   controlador.cancelarUnTurno(nroTurno);
                   out.println("Se cancelo con Exito el Turno.");
               }catch(Exception ex){
                   String mensajeError ="Error no se pudo cancelar el Turno ("+ex.getMessage()+").";
                    out.println(mensajeError);
               }
            %>
                <form action="iniciorecoltarInfoUsuario.jsp"><input type="submit" value="Volver" name="btnVolver"></form>   
        </body>
</html>
