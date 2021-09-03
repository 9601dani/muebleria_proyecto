<%-- 
    Document   : reintregreacionmueble
    Created on : 1/09/2021, 05:19:13
    Author     : daniel
--%>

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
            <h1>Reintegro de Mueble</h1>
            <img class="mb-4" src="/Muebleria_Progra/imagen/ventas.jpg" alt="" width="250" height="150">
        </div>
        <h6 class="text-center"> REGISTRO DE FACTURA</h6>
        <form method="post" action="/Muebleria_Progra/ReintegroVenta">
            <div class="container">
                <div class="row">
                  <div class="col-sm">
                    <div class="form-group col-md-12">
                        <label for="inputText">Codigo de Factura</label>
                        <input name="textcodfactura" type="text" class="form-control" id="in" required>
                    </div>
                  </div>
                </div>
            </div>
            <br> 
              <div class="text-center">
                  <button type="submit" class="btn btn-primary">Realizar Reintegro</button>
              </div>
            <br>  
          </form>
            <a class="btn btn-primary" href="/Muebleria_Progra/Venta/iventa.jsp"> REGRESAR</a>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
