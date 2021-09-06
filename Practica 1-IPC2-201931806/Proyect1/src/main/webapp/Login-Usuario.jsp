<%-- 
    Document   : Login
    Created on : 31/08/2021, 19:20:16
    Author     : aztk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/LogIn.css"  type="text/css" media="all" >

        <title>JSP Page</title>
    </head>
    <body>

        <div class="LogInBody" id="LogInBody">
            <%-- apartado para pedir credenciales --%>
            <form class="formularioLogin" id=""formularioLogin method="post" action="iniciarsesion"> 
                <h1>Bienvenido al Login de usuarios</h1>
                <p>Usuario: </p>
                <div class="texto">
                    <input type="text" class="txtIn" id="usuarioIn" required="" name="userIngresado">
                </div>

                <p>Cotnraseña: </p>
                <div class="texto">
                    <input type="password" class="txtIn" id="passwordIn" required="" name="passowordIngresado">
                </div> <br>
                <input type="submit" value="Entrar" id="Entrar" class="boton">
                <input type="button" value="Regresar" id="Regresar" class="boton" onclick='location.href = location ='index.html'");>
            </form>
        </div>
    </body>
</html>
