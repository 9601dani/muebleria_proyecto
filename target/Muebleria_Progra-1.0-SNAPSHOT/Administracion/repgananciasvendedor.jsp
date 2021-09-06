<%-- 
    Document   : repgananciasvendedor
    Created on : 5/09/2021, 14:07:48
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
        
        <div>
            <a href="/Muebleria_Progra/Administracion/iadministracion.jsp" class="btn btn-primary" > Regresar</a>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="text-center" >
            <img src="/Muebleria_Progra/imagen/rep.png" width="300" height="300" alt=""/>
        </div>
        
        <br>
        <br>
        <br>
        
        <h3 class="text-center" >AQUI PODRAS OBTENER REPORTES GENERALES </h3>
        <div class="text-center">
            <a href="/Muebleria_Progra/ReporteGeneral?eleccion=cliente" class="btn btn-primary" > EXPORTAR REPORTE DE CLIENTES</a>
        </div>
        <br>
        <div class="text-center">
            <a href="/Muebleria_Progra/ReporteGeneral?eleccion=usuario" class="btn btn-primary" > EXPORTAR REPORTE DE USUARIO</a>
        </div>
        <br>
        <div class="text-center">
            <a href="/Muebleria_Progra/ReporteGeneral?eleccion=piezas" class="btn btn-primary" > EXPORTAR REPORTE DE PIEZAS</a>
        </div>
        <br>
        <div class="text-center">
            <a href="/Muebleria_Progra/ReporteGeneral?eleccion=mueble" class="btn btn-primary" > EXPORTAR REPORTE DE MUEBLES</a>
        </div>
       
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
