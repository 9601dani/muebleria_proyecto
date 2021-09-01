<%-- 
    Document   : ventacliente
    Created on : 30/08/2021, 01:17:43
    Author     : daniel
--%>

<%@page import="java.sql.Statement"%>
<%@page import="com.mycompany.muebleria_progra.conexion.Conexion_Sql"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble"%>
<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble_Ensamblado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Venta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body>
        <div class="text-center">
            <h1>Registro de Venta</h1>
            <img class="mb-4" src="/Muebleria_Progra/imagen/ventas.jpg" alt="" width="250" height="150">
        </div>
        <h6 class="text-center"> Datos Cliente</h6>
        <form method="post" action="/Muebleria_Progra/VentaFinal">
            <div class="container">
                <div class="row">
                  <div class="col-sm">
                    <div class="form-group col-md-12">
                        <label for="inputText">Nit Cliente</label>
                        <input name="textnit" type="text" class="form-control" id="in" value="<%= request.getSession().getAttribute("nit") %>" required>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="inputText">Id del Mueble</label>
                        <input name="textmueble" type="text" class="form-control" id="in" placeholder="(Ingresa el id del mueble)">
                    </div>
                  </div>
                </div>
            </div>
            <br> 
              <div class="text-center">
                  <button type="submit" class="btn btn-primary">Realizar Venta</button>
              </div>
            <br>  
          </form>
            <a class="btn btn-primary" href="/Muebleria_Progra/Venta/iventa.jsp"> REGRESAR</a>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
