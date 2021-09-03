<%-- 
    Document   : devintervalo
    Created on : 2/09/2021, 00:33:41
    Author     : daniel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mycompany.muebleria_progra.conexion.Conexion_Sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
   
    </head>
    <body>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("SELECT d.id_devolucion,d.fecha_devolucion, d.costo_perdida,c.nit, c.nombre, f.id_factura, f.fecha_compra, m.id_mueble_ensamblado, m.nombre_mueble FROM devolucion as d INNER JOIN factura as f INNER JOIN mueble_ensamblado as m INNER JOIN cliente as c WHERE d.fecha_devolucion BETWEEN '0000-00-00' AND '0000-00-00'  AND c.nit='0' AND d.id_factura=f.id_factura AND m.id_mueble_ensamblado=f.id_mueble_ensamblado");             
                %>
        <h3 class="text-center">CONSULTA DE DEVOLUCIONES DE CLIENTE</h3>
            <form class="form" >
                <label> Nit Cliente</label>
                <br>
                <input class="form-control" type="text" name="textname" placeholder="ingresa nit a buscar"  required>
                <br>
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
        <%
                    String nit=request.getParameter("textname");
                    String f1= request.getParameter("textfi");
                    String f2= request.getParameter("textff");
                   
                    
                    
                    if(nit!="" || f1!="" || f2!="" ){  
                    rs=smy.executeQuery("SELECT d.id_devolucion,d.fecha_devolucion, d.costo_perdida,c.nit, c.nombre, f.id_factura, f.fecha_compra, m.id_mueble_ensamblado, m.nombre_mueble FROM devolucion as d INNER JOIN factura as f INNER JOIN mueble_ensamblado as m INNER JOIN cliente as c WHERE d.fecha_devolucion BETWEEN"+"'"+f1+"'"+ "AND "+"'"+f2+"'"+ "  AND c.nit="+"'"+nit+"'"+" AND d.id_factura=f.id_factura AND m.id_mueble_ensamblado=f.id_mueble_ensamblado");
                    }else{
                        System.out.println("error");
                    }
        %>
                    
        <div class="container buscar">
            <br>
            <br>
        </div>
        <br>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Codigo Devolucion</th>
                        <th class="text-center">Fecha de Devolucion</th>
                        <th class="text-center">Costo Perdida</th>
                        <th class="text-center">Codigo Factura</th>
                        <th class="text-center">Fecha Compra</th>
                        <th class="text-center">Codigo_Mueble</th>

                    </tr>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getInt("id_devolucion")%></td>
                        <td><%= rs.getDate("fecha_devolucion")%></td>
                        <td><%= rs.getBigDecimal("costo_perdida")%></td>
                        <td><%= rs.getString("nit")%></td>
                        <td><%= rs.getString("nombre")%></td>
                        <td><%= rs.getInt("id_factura")%></td>
                        <td><%= rs.getDate("fecha_compra")%></td>
                        <td><%= rs.getString("id_mueble_ensamblado")%></td>
                        <td><%= rs.getString("nombre_mueble")%></td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <%
                   Conexion_Sql con= new Conexion_Sql(1);
                %>
             </div>
             <div class="text-center">
                  <a  href="/Muebleria_Progra/Venta/iventa.jsp" class="btn btn-success">Regresar</a>
             </div>
            
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
