<%-- 
    Document   : repdevo
    Created on : 4/09/2021, 00:12:38
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
        <h3 class="text-center">Reporte de Devoluciones</h3>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("SELECT d.id_devolucion,d.fecha_devolucion, d.costo_perdida,f.id_factura, f.fecha_compra, m.id_mueble_ensamblado, m.nombre_mueble, f.cliente_nit, c.nombre FROM devolucion as d INNER JOIN factura as f INNER JOIN mueble_ensamblado as m INNER JOIN cliente as c WHERE f.fecha_compra BETWEEN '0000-00-0.' AND '0000-00-00' AND m.id_mueble_ensamblado=f.id_mueble_ensamblado AND d.id_factura=f.id_factura AND f.cliente_nit=c.nit"); 
                
                %>
        <div class="container buscar">
            <a href="/Muebleria_Progra/Administracion/iadministracion.jsp" class="btn btn-success">Regresar</a>
            <br>
            <br>
        </div>
            <form class="form" >
                <label> Fecha Inicial</label>
                <br>
                <input class="form-control" type="date" name="textfi" placeholder="fecha inicial"  required>
                <br>
                <label> Fecha Final</label>
                <br>
                <input class="form-control" type="date" name="textff" placeholder="ingresa fecha final" required>
                <br>
                <input class="btn btn-success" type="submit" value="BUSCAR">
            </form> 
        <br>
                <%
                    String f1= request.getParameter("textfi");
                    String f2= request.getParameter("textff");
                    if(f1!="" && f2!=""){
                    rs=smy.executeQuery("SELECT d.id_devolucion,d.fecha_devolucion, d.costo_perdida,f.id_factura, f.fecha_compra, m.id_mueble_ensamblado, m.nombre_mueble, f.cliente_nit, c.nombre FROM devolucion as d INNER JOIN factura as f INNER JOIN mueble_ensamblado as m INNER JOIN cliente as c WHERE f.fecha_compra BETWEEN"+"'"+f1+"'"+" AND "+"'"+f2+"'"+"AND m.id_mueble_ensamblado=f.id_mueble_ensamblado AND d.id_factura=f.id_factura AND f.cliente_nit=c.nit"); 
                    }
                   %>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Codigo Devolucion</th>
                        <th class="text-center">Fecha Devolucion</th>
                        <th class="text-center">Costo de Perdida</th>
                        <th class="text-center">Codigo de Factura</th>
                        <th class="text-center">Fecha Compra</th>
                        <th class="text-center">Codigo Mueble</th>
                        <th class="text-center">Nombre Mueble</th>
                        <th class="text-center">Nit</th>
                        <th class="text-center">Nombre</th>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getInt("id_devolucion")%></td>
                        <td><%= rs.getDate("fecha_devolucion")%></td>
                        <td><%= rs.getBigDecimal("costo_perdida")%></td>
                        <td><%= rs.getInt("id_factura")%></td>
                        <td><%= rs.getDate("fecha_compra")%></td>
                        <td><%= rs.getString("id_mueble_ensamblado")%></td>
                        <td><%= rs.getString("nombre_mueble")%></td>
                        <td><%= rs.getString("cliente_nit")%></td>
                        <td><%= rs.getString("nombre")%></td>
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
