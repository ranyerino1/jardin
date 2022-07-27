<%-- 
    Document   : admin
    Created on : 19/07/2022, 03:26:30 PM
    Author     : ranyerino
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="menu.css">
        <link rel="stylesheet" href="admin.css">
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="">Inicio</a></li>
                <li><a href="registrarUsuario.jsp">Registrar usuario</a></li>
                <form method="post" action="Sesiones">
                    <input type="submit" value="Cerrar Sesion" >
                </form>
            </ul>
        </nav>
        
    <center>
        <table border="6px" >
                <tr>
                    <th>Usuario</th>
                    <th>Estado</th>
                </tr>
                <%
                    UsuarioVO usuVO = new UsuarioVO();
                    UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
                    ArrayList<UsuarioVO> listarUsuarios = usuDAO.listar();
                    for (int i = 0; i < listarUsuarios.size(); i++) {

                        usuVO = listarUsuarios.get(i);
                %>
                <tr>
                <td><%=usuVO.getUsuLogin()%></td>
                <td><%=usuVO.getEstado()%></td>
                </tr>
                <%}%>
    </table>
    </center>
        
    </body>
</html>
