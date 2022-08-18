<%-- 
    Document   : perfil
    Created on : 14/08/2022, 10:48:06 AM
    Author     : ranyerino
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloVO.RolVO"%>
<%@include file="Sesiones.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="menu.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="">Inicio</a></li>
                <li><a href="perfil.jsp">Perfil</a></li>
                <li><a href="registrarUsuario.jsp">Registrar usuario</a></li>
                <form method="post" action="Sesiones">
                    <input type="submit" value="Cerrar Sesion" >
                </form>
            </ul>
        </nav>
    <center>
        <form method="post" action="Usuario">
            <label>Primer nombre</label><br>
            <input type="text" name="nombre1"><br>

            <label>Segundo Nombre</label><br>
            <input type="text" name="nombre2"><br>

            <label>Primer apellido</label><br>
            <input type="text" name="apellido1"><br>

            <label>Segundo apellido</label><br>
            <input type="text" name="apellido2"><br>

            <label>Numero de documento</label><br>
            <input type="int" name="numDocu"><br>

            <label>Tipos de documento</label><br>
            <select name="tipoDocu">
                <option>Seleccione su tipo de documento</option>
                <option value="C.C">Cedula de ciudadania</option>
                <option value="T.I">Tarjeta de indentidad</option>
                <option value="otro">Otro</option>
            </select><br>

            <label>Numero de telefono</label><br>
            <input type="int" name="numTel"><br>

            <label>Direccion</label><br>
            <input type="text" name="direcUsua"><br>

            <label>Correo</label><br>
            <input type="text" name="correo"><br>

            <label>fecha de nacimiento</label><br>
            <input type="text" name="fecha">

            <% RolVO rolVO = new RolVO();
                RolDAO rolDAO = new RolDAO();
                ArrayList<RolVO> listaDatos = rolDAO.listar(usuario);

                for (int i = 0; i < listaDatos.size(); i++) {

                    rolVO = listaDatos.get(i);
                }
            %>
            <input type="hidden" name="textId" value="<%=rolVO.getRolId()%>">
            
            <button>Ingresar</button> <br>
            <input type="hidden" value="5" name="opcion"><br>

        </form>
        <%
                if (request.getAttribute("mensajeError") != null) { %>
        ${mensajeError}

        <%} else {%>
        ${mensajeExito}        
        <%}%>
    </center>

</body>
</html>
