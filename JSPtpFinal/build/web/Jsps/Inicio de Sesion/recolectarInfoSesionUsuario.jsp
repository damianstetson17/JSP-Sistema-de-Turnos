<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="modelo.*"%>
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
            private String email, contrasenia;  
            private Cliente cliente;
        %>
        
        <%
            persistencia= new Persistencia();     
            controlador = new Controlador(persistencia);
            
            //recolectamos informacion del form
            email=request.getParameter("nombreUsuario");
            contrasenia=request.getParameter("contraUsuario");
            
            if(email.equals("")||contrasenia.equals("")){
                String mensajeError ="Error en autenticacion (Debe ingresar un email y contraseña).";
                out.println(mensajeError);
            }else{
                try{
                     //buscamos al cliente de ese usuario ingresado
                    cliente=controlador.buscarUnClienteUsuario(email, contrasenia);
                    //si se puede ocurre todo el jsp
                    %>
                    
                     <table border="4"><%-- matriz que sostiene los turnos--%>
                        <tr><td><h2>Turnos Existentes:</h2></td></tr>
                        <tr>
                            <td>
                                <%-- matriz de turnos del cliente--%>
                                <table border="1" >
                                    <tr>
                                            <td><label id="label-1">Fecha Solicitud:</label></td>
                                            <td><label id="label-1">Num. Turno :</label></td>
                                            <td><label id="label-1">Estado :</label></td>
                                            <td><label id="label-1">Prioridad Turno:</label></td>
                                    </tr>
                                    <%
                                        try{
                                            List<Turno> turnos=cliente.getTurnos();
                                            for(Turno t : turnos)
                                            {
                                                if((!(t.getEstado().getNombreEstado().equals("atendido")))||(!(t.getEstado().getNombreEstado().equals("baja"))))
                                                {
                                    %>
                                        <tr>
                                            <td><input value="<%=format.format(t.getFechaSolicitud()) %>" type="text" name="x1"></td>
                                            <td><input value="<%=t.getNroTurno() %>" type="text" name="x1"></td>
                                            <td><input value="<%=t.getEstado().getNombreEstado() %>" type="text" name="x1"></td>
                                            <td><input value="<%=t.getPrioridad().getNombrePrioridad() %>" type="text" name="x1"></td>
                                        </tr>
                                    <%
                                           }
                                                }
                                        }catch(Exception ex){
                                            out.println("No se ingreso correctamente los datos de Usuario");
                                        }
                                    %>
                                </table>
                            </td>                           
                        </tr>
                        <tr>
                        <td><h3>Cancelar Turno:</h3>
                            <form action="cancelarTurno.jsp">
                                     <input type="submit" value="Cancelar Turno" name="btnCancelar">
                                         <input type="text" value="Nro del turno" name="nroDelTurnoCancelar">
                                    </td>       
                            </form>
                        </tr>
                    </table>
                    <br></br>
                    <table border="4" align="left"><%-- matriz de tramites y prioridades existentes con cancelar un turno--%>
                        <tr>
                            <td><h2>Tramites Existentes:</h2></td>
                            <td><h2>Prioridades Existentes:</h2></td>
                        </tr>
                        <tr>
                            <td>
                                 <%-- matriz de tramites--%>
                                        <table border="1" align="center">
                                            <tr>
                                                    <td><label id="label-1">Nombre Tramite:</label></td>
                                            </tr>
                                                <%
                                                    List<Tramite> tramites = controlador.buscarTramites();
                                                    for(Tramite t : tramites)
                                                    {
                                                 %>
                                                 <tr>
                                                     <td><input value="<%=t.getNombreTramite()%>" type="text" name="x1"></td>
                                                 </tr>
                                                    <%
                                                     }
                                                    %>
                                        </table>
                            </td>
                            <td>
                                 <%--matriz de Prioridades--%>
                                    <table border="1" align="center">
                                        <tr>
                                                <td><label id="label-1">Nombre Prioridad</label></td>
                                        </tr>
                                            <%
                                                List<Prioridad> prioridades = controlador.buscarPrioridades();
                                                for(Prioridad p : prioridades)
                                                {
                                             %>
                                             <tr>
                                                 <td><input value="<%=p.getNombrePrioridad()%>" type="text" name="x1"></td>
                                             </tr>
                                                <%
                                                 }
                                                %>
                                    </table>
                            </td>
                        </tr>
                    </table>

                     <table border="4"><%-- matriz de pedir turno y --%>
                         <tr>
                             <td><h2>Solicitar Turno:</h2></td>    
                         </tr>
                         <tr>
                             <td>
                                <form action="solicitarTurno.jsp">
                                    <input type="text" value="Nombre de Tramite" name="nombreTramite">
                                    <input type="text" value="Nombre de Prioridad" name="prioridad">
                                    <input type="hidden" value="<%= cliente.getDni()%>" name="dniCliente">
                                    <input type="submit" value="Solicitar Turno" name="btnSolicitar">
                                </form>
                            </td>
                         </tr>
                     </table>
                     
                    <%
                }catch(Exception ex){
                    String mensajeError ="Error en autenticacion (No se encontro el usuario).";
                    out.println(mensajeError);
                }
            }
                    
        %>
         <br></br>
         <br></br>  
         <div>
             <form action="iniciorecoltarInfoUsuario.jsp"><input type="submit" value="Cerrar Sesion" name="btnVolver"></form>
         </div>  
    </body>
</html>
