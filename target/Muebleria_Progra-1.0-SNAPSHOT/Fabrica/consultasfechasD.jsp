<%-- 
    Document   : consultasfechasD
    Created on : 3/09/2021, 12:36:41
    Author     : daniel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mycompany.muebleria_progra.conexion.Conexion_Sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
   
    </head>
    <body>
        <h3 class="text-center">Consulta de Muebles Creados</h3>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("SELECT m.id_mueble_ensamblado, m.fecha_ensamble, m.costo_fabricacion, m.usuario_nombre, m.nombre_mueble, e.nombre_estado FROM mueble_ensamblado as m INNER JOIN estado_mueble_ensamblado as e WHERE m.id_estado_mueble=e.id_estado_mueble_ensamblado ORDER BY fecha_ensamble DESC"); 
                %>
        <div class="container buscar">
            <a href="/Muebleria_Progra/Fabrica/ifabrica.jsp" class="btn btn-success">Regresar</a>
            <br>
            <br>
             <a href="/Muebleria_Progra/Fabrica/consultafechasA.jsp" class="btn btn-success">Ordenar Ascendente</a>
             <a href="/Muebleria_Progra/Fabrica/consultasfechasD.jsp" class="btn btn-success">Ordenar Descendente</a>
        </div>
        <br>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Codigo Mueble</th>
                        <th class="text-center">Fecha de Ensamble</th>
                        <th class="text-center">Costo Fabricacion</th>
                        <th class="text-center">Usuario</th>
                        <th class="text-center">Nombre del Mueble</th>
                        <th class="text-center">Estado del Mueble</th>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getString("id_mueble_ensamblado")%></td>
                        <td><%= rs.getDate("fecha_ensamble")%></td>
                        <td><%= rs.getBigDecimal("costo_fabricacion")%></td>
                        <td><%= rs.getString("usuario_nombre")%></td>
                        <td><%= rs.getString("nombre_mueble")%></td>
                        <td><%= rs.getString("nombre_estado")%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <%
                   Conexion_Sql con= new Conexion_Sql(1);
                %>
        </div>
       
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
