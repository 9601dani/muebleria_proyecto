<%-- 
    Document   : ifabrica
    Created on : 28/08/2021, 17:51:53
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
        <title>JSP Fabrica</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body class="text-center" style="background-color:beige">
        <p>
        <p>
        <p>
        <p>
            <br>
            <br>
            <br>
            <br>
            <br>
        <p>
        <p>
        <p>
        <p>
            <br>
            <br>
            <br>
            <br>
            <br>
        <div style="background-color: lightblue;">
            <h1> Bienvenido a Fabrica</h1>
        </div>
        <img class="mb-4" src="/Muebleria_Progra/imagen/fabrica.jpg" alt="" width="700" height="100">
        <div class="text-align" style="font-size: large">
            <a class="btn btn-primary" href="/Muebleria_Progra/">Cerrar Sesion</a>
        </div>
        <br>
        <div class="container overflow-hidden" style="background-color:burlywood;">
            <div class="row gx-5">
                <div class="col">
                    <div class="mb-3">
                        <div style="font-size: 15px;">
                            <a href="/Muebleria_Progra/Fabrica/modpiezas.jsp" class="btn"> Modificacion de Piezas</a>
                        </div>

                    </div> 
                </div>
                <div class="col">
                    <div class="mb-3">
                        <div style="font-size: 15px;">
                            <h3>
                                <a href="*" class="btn"> Ensamblar Mueble</a>
                            </h3>

                        </div>

                    </div> 
                </div>
                <div class="col">
                    <div class="mb-3">
                        <div style="font-size: 15px;">
                            <a href="/Muebleria_Progra/Fabrica/consultafechas.jsp" class="btn"> Consulta Muebles Creados</a>
                        </div>

                    </div> 
                </div>
                <div class="col">
                    <div class="mb-3">
                        <div style="font-size: 15px;">
                            <a href="/Muebleria_Progra/Fabrica/consultapieza.jsp" class="btn"> Consulta de Piezas</a>
                        </div>

                    </div> 
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>
        <h3>A continuacion te presentamos las piezas que estan apunto de agotarse:</h3>
             <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("SELECT tipo_pieza, cantidad,costo FROM pieza WHERE cantidad<10"); 
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
