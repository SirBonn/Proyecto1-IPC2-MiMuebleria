<%-- 
    Document   : Area-Fabrica
    Created on : 1/09/2021, 19:29:09
    Author     : aztk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabrica</title>
        <%
             response.setHeader("cache-control", "no-cache, no-store, must-revalidate");

             if (session.getAttribute("usuario") == null && session.getAttribute("password") == null) {
                  response.sendRedirect("index.html");
             }
        %>


    </head>
    <body>
        <h1> ${usuario} estas en la fabrica</h1>

        <form action="cerrarsesion">
            <input type="submit" value="Cerrar sesion">
        </form>
        
      <form method = "post" enctype = "multipart / form-data" action="cargarArchivos">
            <label for="archivoDatos">Selecciona el archivo</label>
            <input type="file" name="archivoDatos">
            <br>
            <button type="submit">Subir</button>
        </form>        
        
    </body>
</html>
