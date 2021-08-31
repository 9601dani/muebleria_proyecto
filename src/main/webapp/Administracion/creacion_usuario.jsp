<%-- 
    Document   : creacion_usuario
    Created on : 29/08/2021, 12:57:42
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Ceacion Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
        <body   style="background-color: beige">
            <section class="text-center">
                <h3>
                Creacion De  Nuevo Usuario
                </h3> 
        <p>
        <p>
        <p>
        <p>
            <div>
                <img class="mb-4" src="/Muebleria_Progra/imagen/imagen.png" alt="" width="100" height="100">
            </div>
            </section>
            
        <p>
        <p>                
        <p>
        <p>
        <form style="background-color: lightsteelblue" action="/Muebleria_Progra/CreacionUsuario" method="post">
            <div class="form-row">
                <div class="form-group required">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Nombre de Usuario *</label>
                        <input name="textusuario" type="text" class="form-control" id="inputEmail4" placeholder="ejem: 'Nombre1997'">
                    </div>
                </div>   
                <p>
                <p>
                <p>
              <div class="form-group col-md-6">
                <label for="inputPassword4">Contraseña *</label>
                <input name="textpass"type="password" class="form-control" id="inputPassword4" placeholder="ejem: 'Password.123'">
              </div>
                <p>
                <p>
                <p>
                <div class="form-group col-md-6">
                    <label for="inputAddress"> Tipo de Usuario *</label>
                    <select name="texttipo" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
                        <option value="1">Administrador</option>
                        <option value="2">Vendedor</option>
                        <option value="3">Fabricador</option>
                    </select>
                </div>

                <br>
                <input type="submit" class="btn btn-primary btn-sm" value="Guardar Usuario" />
            </div>
            <br>
        </form>
        <div class="text-center">
            <a class="btn btn-primary btn-sm" href="/Muebleria_Progra/Administracion/iadministracion.jsp">REGRESAR</a>
        </div>
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
