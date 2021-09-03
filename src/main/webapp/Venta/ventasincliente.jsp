<%-- 
    Document   : ventasincliente
    Created on : 30/08/2021, 01:17:59
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
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="text-center">
            <h1>Registro de Cliente</h1>
            <img class="mb-4" src="/Muebleria_Progra/imagen/ventas.jpg" alt="" width="250" height="150">
        </div>
        <form method="post" action="/Muebleria_Progra/NuevoCliente">
            <div class="container">
                <div class="row">
                  <div class="col-sm">
                    <div class="form-group col-md-12">
                        <label for="inputText">Nit Cliente*</label>
                        <input name ="textnit" type="text" class="form-control" id="in" placeholder="(no uses guiones)"  required>
                    </div>
                  </div>
                        <div class="col-sm">
                            <div class="form-group col-md-12">
                                <label for="inputText">Nombre*</label>
                                <input name="textnombre" type="text" class="form-control" id="inputPassword4" placeholder="Nombre"  required>
                            </div>
                        </div>
                        <div class="col-sm">
                          <div class="form-group col-md-12">
                              <label for="inputText">Direccion*</label>
                              <input name="textdireccion" type="text" class="form-control" id="inputPassword4" placeholder="Direccion"  required>
                          </div>
                        </div>
                        <div class="col-sm">
                          <div class="form-group col-md-12">
                              <label for="inputText">Municipio</label>
                              <input name="textmunicipio" type="text" class="form-control" id="inputPassword4" placeholder="">
                          </div>
                        </div>
                        <div class="col-sm">
                            <div class="form-group col-md-12">
                                <label for="inputText">Departamento</label>
                                <input name="textdepartamento" type="text" class="form-control" id="inputPassword4" placeholder="">
                            </div>
                        </div>
                </div>
                
            </div>
            <br>      
              <div class="text-center">
                  <button type="submit" class="btn btn-primary">Registrar Cliente</button>
              </div>
            
          </form>
            <br>
                <div class="text-align">
                    <h6>(Recuerda que * significa que son campos obligatorios)</h6>
                </div>
            <br>
             <a class="btn btn-primary" href="/Muebleria_Progra/Venta/iventa.jsp"> Salir</a>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
