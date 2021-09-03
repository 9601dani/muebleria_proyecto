<%-- 
    Document   : carga
    Created on : 31/08/2021, 00:18:59
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Carga</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body style="background-color: gray;">
        <br>
        <div class="text-center">
            <h1>Carga de Archivos</h1>
            <img class="mb-4" src="/Muebleria_Progra/imagen/archivo.jpg" alt="" width="250" height="150">
        </div>
        <br>
        <br>
        <form action="/Muebleria_Progra/CargaDatos" method="post" enctype="multipart/form-data">
            <div class="container" style="background-color: honeydew">
                <div class="row">
                  <div class="col-sm">
                    <div class="form-group col-md-12">
                        <label for="myfile"> Subir Archivo De Datos </label><br><br>
                        <input type="file" id="myfile" name="myfile" size="6" required><br><br>
                        <input type="submit" value="Subir Archivo" class="btn btn-primary"><br>
                        <br>
                        <br>
                        <div class="text-center">
                            <a href="/Muebleria_Progra/Administracion/iadministracion.jsp" class="btn btn-primary"> Regresar</a>
                        </div>
                    </div>
                  </div>
              </div>
            </div>
            <br>
            
          </form>
              
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
