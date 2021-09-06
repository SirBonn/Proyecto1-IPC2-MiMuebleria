<%-- 
    Document   : Area-Ventas
    Created on : 1/09/2021, 22:05:42
    Author     : aztk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
        <%
             response.setHeader("cache-control", "no-cache, no-store, must-revalidate");

             if (session.getAttribute("usuario") == null && session.getAttribute("password") == null) {
                  response.sendRedirect("index.html");
             }
        %>
    </head>
    <body>
        <h1>TIENDA</h1>
        <nav class="menu" id="menuTienda">
            <h1> ${usuario} estas en la tienda</h1>
            <form action="cerrarsesion">
                <input type="submit" value="Cerrar sesion">
            </form>
            <br>
            <input type="button" onclick=" location.href = 'Registro-Cliente.jsp'" value="Registrar Cliente" name="RegistroBoton" /> 
        </nav>
    </body>
</html>
