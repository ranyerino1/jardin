<%-- 
    Document   : Sesiones
    Created on : 2/06/2022, 04:28:16 PM
    Author     : alrod
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sesiones</title>
    </head>
    <%
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "No-cache,no-store,must-revalidate");
        response.setDateHeader("Expirar", 0);


    %>


    <%        
        HttpSession sesion = (HttpSession) request.getSession();
        String usuario = "";
        String usuid="";

        if (sesion.getAttribute("datosUsuario") == null) {

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            UsuarioVO usuVO = (UsuarioVO) sesion.getAttribute("datosUsuario");
            usuario = usuVO.getUsuLogin();
            usuid = usuVO.getUsuId();
        }

    %>
    <body>
    </body>
</html>
