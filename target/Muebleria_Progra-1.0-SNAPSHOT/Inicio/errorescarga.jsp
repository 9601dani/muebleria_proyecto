<%-- 
    Document   : errorescarga
    Created on : 31/08/2021, 11:28:39
    Author     : daniel
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
   
    </head>
    <body class="text-center">
        <h1>** ARCHIVO CARGADOS EXITOSAMENTE **</h1>
        <br>   
        <h1>A continuacion una tabla que muestra errores si hubieron</h1>
        <br>
        <br>
        <img src="/Muebleria_Progra/imagen/error.jpg" alt="" width="300" height="150"/>
<div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <% 
                List<String> errores = (ArrayList<String>)request.getAttribute("errores");
                System.out.println(errores.size());
                %>
                <thead>
                    <tr>
                        <th class="text-center">Linea con Errores</th>

                    </tr>
                </thead>
                <tbody id="tbodys">
                    <%
                    for(String cadena:errores){
                    
                    %>
                    <tr>
                <strong>
                    <td class="text-align"><%= cadena %></td>
                </strong>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
       <br> 
       <br>
       <a href="/Muebleria_Progra/Administracion/iadministracion.jsp" class="btn btn-primary"> Regresar</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
   
    </body>
</html>
