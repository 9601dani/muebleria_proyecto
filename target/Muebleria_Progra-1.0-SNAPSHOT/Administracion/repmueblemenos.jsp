<%-- 
    Document   : repmueblemenos
    Created on : 4/09/2021, 02:29:37
    Author     : daniel
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
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
        <h3 class="text-center">Reporte Mueble Mas Vendido</h3>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("SELECT me.nombre_mueble, COUNT(me.nombre_mueble) AS Cantidad FROM factura as f INNER JOIN mueble_ensamblado as me WHERE fecha_compra BETWEEN '2000-02-01' AND '2080-03-01' AND f.id_mueble_ensamblado= me.id_mueble_ensamblado GROUP BY me.nombre_mueble ORDER BY Cantidad ASC LIMIT 1"); 
                   String nom="";
                   String f1="";
                   String f2="";
                   String cant="1";
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
                    f1=request.getParameter("textfi");
                     f2=request.getParameter("textff");
                   rs=smy.executeQuery("SELECT me.nombre_mueble, COUNT(me.nombre_mueble) AS Cantidad FROM factura as f INNER JOIN mueble_ensamblado as me WHERE me.id_estado_mueble='2'  AND me.id_mueble_ensamblado= f.id_mueble_ensamblado AND f.fecha_compra BETWEEN"+ "'"+f1+"'" +" AND " +"'" +f2+"'"+" GROUP BY me.nombre_mueble ORDER BY Cantidad ASC LIMIT 1"); 
                %>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Nombre Mueble</th>
                        <th class="text-center">Cantidad de Ventas</th>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getString("nombre_mueble")%></td>
                        <td><%=rs.getInt("cantidad")%></td>
                       <%=nom+=rs.getString("nombre_mueble")%>
                        <%=cant=rs.getString("cantidad")%>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <%
                   Conexion_Sql con= new Conexion_Sql(1);
                %>
        </div>
        <!-- aqui es el segundo reporte -->
            <% Conexion_Sql cm= new Conexion_Sql();
                   Statement sm;
                   ResultSet r;
                   sm=Conexion_Sql.getConnection().createStatement();
                   
                   r=sm.executeQuery("SELECT f.fecha_compra, me.id_mueble_ensamblado, me.nombre_mueble, m.precio FROM factura as f INNER JOIN mueble_ensamblado as me INNER JOIN mueble as m WHERE me.id_estado_mueble='2'  AND me.id_mueble_ensamblado= f.id_mueble_ensamblado AND f.fecha_compra BETWEEN"+ "'"+f1+"'" +" AND " +"'" +f2+"'"); 
             %>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Fecha Compra</th>
                        <th class="text-center">Codigo Mueble</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Precio</th>
                </thead>
                <tbody id="tbodys">
                    <%
                    int contador=1;
                    while(r.next()&& contador<= Integer.parseInt(cant)){
                    contador++;
                    System.out.println(contador);
                    System.out.println(cant);
                    %>
                    <tr>
                        <td class="text-center"><%= r.getDate("fecha_compra")%></td>
                        <td><%=r.getString("id_mueble_ensamblado")%></td>
                        <td><%= r.getString("nombre_mueble")%></td>
                        <td><%=r.getBigDecimal("precio")%></td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <%
                   Conexion_Sql ca= new Conexion_Sql(1);
                %>
        </div>
        
        
        
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
