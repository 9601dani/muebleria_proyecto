<%-- 
    Document   : inicio_sesion
    Created on : 26/08/2021, 15:38:38
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muebleria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body class="text-center" style="background-color: beige">
        <p>
        <p>
        <p>
        <p>
            <br>
            <br>
            <br>
            <br>
            <br>
        <p>
        <p>
        <p>
        <p>
            <br>
            <br>
            <br>
            <br>
            <br>
         <img class="mb-4" src="imagen/imagen.png" alt="" width="100" height="100">
        <!--  
        <section>
            <button type="button" class="btn-close btn-close-black"aria-label="Close"></button>
        </section>-->
        <form action="Validacion" method="post">
        <div id="login-box">
            <h1>Login</h1> <! - El título de Inicio de sesión ->
            
            <div class="form">
                <div class="item"> <! - parte de nombre de usuario ->
                    <i></i> <! - Se utilizará para dibujar el icono delante del nombre de usuario ->
                    <input type="text" placeholder="username" name="username"> <! - Entrada de nombre de usuario realizada por cuadro de texto ->
                </div>
                <p>
                <div class="item"> <! - parte de la contraseña ->
                    <i></i> <! - Se utilizará para dibujar el icono delante de la contraseña en el futuro ->
                    <input type="password" placeholder="password" name="password"> <! - Entrada de contraseña usando el cuadro de texto de contraseña ->
                </div>

            </div>
            <p>
            <p>
                <input type="submit" class="btn btn-primary btn-sm" value="Iniciar Sesion" />
            
        </div>
    </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
  
    </body>
</html>
