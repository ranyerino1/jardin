<%-- 
    Document   : registrarUsuario
    Created on : 9/05/2022, 09:18:14 AM
    Author     : Sena
--%>

<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@include file="Sesiones.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="menu.css">
        <link rel="stylesheet" href="index.css">
        <title>Registrar</title>

    </head>
    <body>   
        <nav>
            <ul>
                <li><a href="admin.jsp">Inicio</a></li>
                <li><a href="">Registrar usuario</a></li>
                <form method="post" action="Sesiones">
                    <input type="submit" value="Cerrar Sesion" >
                </form>
            </ul>
        </nav>
        <div class="login-box">
            <h2>Registrar Usuario</h2>
            <form method="post" action="Usuario">
                <div class="user-box">
                    <input type="text" name="textLogin" required="">
                    <label>Usuario</label>
                </div>
                <div class="user-box">
                    <input type="password" name="textPassword" required="">
                    <label>Contraseña</label>
                </div>
                <button>Registrar</button> <br>
                <input type="hidden" value="1" name="opcion"><br>
            </form>

            <%
            if (request.getAttribute("mensajeError") != null) { %>
            ${mensajeError}

            <%} else {%>
            ${mensajeExito}        
            <%}%>
    </body>
</html>
