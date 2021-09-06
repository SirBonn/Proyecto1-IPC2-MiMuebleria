<%-- 
    Document   : Registro-Cliente
    Created on : 1/09/2021, 22:17:34
    Author     : aztk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Registro de clientes nuevos</h1>

        <form class="formNuevoCliente" id="formNuevoCliente" method="post" action="clienteregistro">
            <h1>Registro de nuevos clientes</h1>

            <br><label>NIT: </label> <input type="number    " class="txt" id="newNit" required="" onkeyup="validarDatosRegistro()" name="NitIngresado"><br>
            <br><label>Nombre: </label> <input type="text" class="txt" id="newName" required="" onkeyup="validarDatosRegistro()" name="NameIngresado" maxlength="40"><br>
            <br><label>Direccion: </label> <input type="text" class="txt" id="newDirection" required="" onkeyup="validarDatosRegistro()" name="DirectionIngresado" maxlength="40"><br>
            <br><label>Télefono: </label> <input type="text" class="txt" id="newPhone" name="PhoneIngresado" maxlength="40" > <br>
            
            <%-- apartado de botones --%>
            <br> <input type="submit" value="Registrar" class="boton" id="Registrar" disabled="">
            <input type="button" value="Regresar" id="Regresar" class="boton" onclick="history.back()">

        </form>
    </body>
    <script src="resources/js/FunctionsRegistroClientes.js"></script>
</html>
