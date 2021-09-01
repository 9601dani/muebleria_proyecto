<%-- 
    Document   : consultadia
    Created on : 1/09/2021, 03:51:54
    Author     : daniel
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
        <h3 class="text-center">VENTAS DEL DIA</h3>
                <%
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = simpleDateFormat.format(date);
                    java.sql.Date date1 = java.sql.Date.valueOf(formattedDate); 
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("SELECT f.id_factura, f.fecha_compra, c.nit, c.nombre, m.id_mueble_ensamblado, mueble.nombre_mueble, mueble.precio FROM factura as f INNER JOIN mueble_ensamblado as m INNER JOIN cliente as c INNER JOIN mueble WHERE f.fecha_compra="+ "'"+date1+"'"+"AND m.id_mueble_ensamblado= f.id_mueble_ensamblado AND f.cliente_nit=c.nit AND m.nombre_mueble= mueble.nombre_mueble");
                   
                %>
        <div class="container buscar">
            <a href="/Muebleria_Progra/Venta/iventa.jsp" class="btn btn-success">Regresar</a>
            <br>
            <br>
        </div>
        <br>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Codigo Factura</th>
                        <th class="text-center">Fecha de Compra</th>
                        <th class="text-center">Nit</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Codigo Mueble</th>
                        <th class="text-center">Nombre del Mueble</th>
                        <th class="text-center">Precio</th>
                    </tr>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getInt("id_factura")%></td>
                        <td><%= rs.getDate("fecha_compra")%></td>
                        <td><%= rs.getString("nit")%></td>
                        <td><%= rs.getString("nombre")%></td>
                        <td><%= rs.getString("id_mueble_ensamblado")%></td>
                        <td><%= rs.getString("nombre_mueble")%></td>
                        <td><%= rs.getBigDecimal("precio")%></td>
                        
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