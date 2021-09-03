<%-- 
    Document   : consultapieza
    Created on : 3/09/2021, 12:40:59
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
        <h3 class="text-center">Consulta de Piezas</h3>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("SELECT tipo_pieza, cantidad,costo FROM pieza;"); 
                %>
        <div class="container buscar">
            <a href="/Muebleria_Progra/Fabrica/ifabrica.jsp" class="btn btn-success">Regresar</a>
            <br>
            <br>
             <a href="/Muebleria_Progra/Fabrica/consultapiezaA.jsp" class="btn btn-success">Ordenar Ascendente</a>
             <a href="/Muebleria_Progra/Fabrica/consultapiezaD.jsp" class="btn btn-success">Ordenar Descendente</a>
        </div>
        <br>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Tipo Pieza</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Costo</th>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getString("tipo_pieza")%></td>
                        <td><%= rs.getInt("cantidad")%></td>
                        <td><%= rs.getBigDecimal("costo")%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <%
                   Conexion_Sql con= new Conexion_Sql(1);
                %>
        </div>
        
                <br>
        <br>
        <h3>A continuacion te presentamos las piezas que estan apunto de agotarse:</h3>
             <%
                   Conexion_Sql cok= new Conexion_Sql();
                   Statement dmy;
                   ResultSet rd;
                   dmy=Conexion_Sql.getConnection().createStatement();
                   rd=smy.executeQuery("SELECT tipo_pieza, cantidad,costo FROM pieza WHERE cantidad<10"); 
                %>
        <div class="container buscar">
        </div>
        <br>
        <div class="container">
            <table class="table table-bordered" id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">Tipo Pieza</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Costo</th>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rd.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rd.getString("tipo_pieza")%></td>
                        <td><%= rd.getInt("cantidad")%></td>
                        <td><%= rd.getBigDecimal("costo")%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <%
                   Conexion_Sql cop= new Conexion_Sql(1);
                %>
        </div>
       
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
