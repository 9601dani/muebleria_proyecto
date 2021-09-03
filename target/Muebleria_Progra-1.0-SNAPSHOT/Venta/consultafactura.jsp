<%-- 
    Document   : consultafactura
    Created on : 1/09/2021, 02:39:48
    Author     : daniel
--%>

<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Factura"%>
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
        <div class="text-center">
            <h2>CONSULTA DE FACTURA DE CLIENTE</h2>
        </div>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   Manejador_Factura nf= new Manejador_Factura();
                   ResultSet factu= nf.select_all();
                   rs=smy.executeQuery("SELECT f.id_factura, f.fecha_compra, c.nit, c.nombre, c.direccion, m.id_mueble_ensamblado, mueble.nombre_mueble, mueble.precio FROM factura as f INNER JOIN cliente as c INNER JOIN mueble_ensamblado as m INNER JOIN mueble ON f.cliente_nit= c.nit AND m.id_mueble_ensamblado= f.id_mueble_ensamblado AND m.nombre_mueble= mueble.nombre_mueble");
                   
                   
                %>
        <div class="container buscar">

            <br>
            <br>
            <form class="form" >
                <label> Codigo de Factura</label>
                <br>
                <input class="form-control" type="text" name="textbuscar" placeholder="ingrese codigo de factura"  required>
                <br>
                <input class="btn btn-success" type="submit" value="BUSCAR">
            </form> 
            
             
            <%
                String nomBuscar=request.getParameter("textbuscar");
                if(nomBuscar!=null){  
                 rs = smy.executeQuery("SELECT f.id_factura, f.fecha_compra, c.nit, c.nombre, c.direccion, m.id_mueble_ensamblado, mueble.nombre_mueble, mueble.precio FROM factura as f INNER JOIN cliente as c INNER JOIN mueble_ensamblado as m INNER JOIN mueble ON f.id_factura="+"'"+nomBuscar+"'"+" AND f.cliente_nit= c.nit AND m.id_mueble_ensamblado= f.id_mueble_ensamblado AND m.nombre_mueble= mueble.nombre_mueble");
                }else{
                System.out.println("error");
                }
                
            %>
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
                        <th class="text-center">Direccion</th>
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
                        <td><%= rs.getString("direccion")%></td>
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
        
        
        
        <div class="text-center">
          <a href="/Muebleria_Progra/Venta/iventa.jsp" class="btn btn-success">Regresar</a>
        </div>
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
