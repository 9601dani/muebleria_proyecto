<%-- 
    Document   : npieza
    Created on : 3/09/2021, 02:40:16
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
         
    </head>
    <body>
    <div class="text-center">
        <h2>Registrar Nueva Pieza</h2>
    </div>  
        <div>
            <a class="btn btn-success" href="/Muebleria_Progra/Fabrica/modpiezas.jsp">REGRESAR</a>
        </div>
        <form action="/Muebleria_Progra/CPieza" method="post">
            <br>
            <label> Nombre de la Pieza</label>
            <input class="form-control" type="text" name="textp" placeholder="Ingresa el nombre de la pieza" required>
            <br>
            <label> Costo</label>
            <input class="form-control" type="text" name="textc" placeholder="Ingresa el costo" required>
            <br>
            <label> Cantidad</label>
            <input class="form-control" type="text" name="textca" placeholder="Ingresa la cantidad" required>
            <br>
            <div class="text-center">
                <input class="btn btn-success" type="submit" value="GUARDAR PIEZA">
            </div>
            
            
        </form>

            <br>
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
