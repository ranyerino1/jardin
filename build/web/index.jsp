<%--
    Document   : index
    Created on : 9/05/2022, 10:20:51 AM
    Author     : Sena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="index.css">
        <title>Login</title>
    </head>
    <body>
        <div class="login-box">
            <h2>Inicios de sesión</h2>
            <form method="post" action="Usuario">
                <div class="user-box">
                    <input type="text" name="textLogin" required="">
                    <label>Usuario</label>
                </div>
                <div class="user-box">
                    <input type="password" name="textPassword" required="">
                    <label>Contraseña</label>
                </div>
                <button>Iniciar</button>
                <input type="hidden" value="4" name="opcion"><br>
                <%
                if (request.getAttribute("mensajeError") != null) {%>


                ${mensajeError}

                <%} else {%>

                ${mensajeExito}

                <%}
                %>

            </form>
        </div>

    </body>
</html>
