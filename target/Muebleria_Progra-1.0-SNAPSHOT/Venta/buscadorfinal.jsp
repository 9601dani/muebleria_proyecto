<%-- 
    Document   : buscadorfinal
    Created on : 30/08/2021, 16:38:57
    Author     : daniel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mycompany.muebleria_progra.conexion.Conexion_Sql"%>
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
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                    ResultSet rs=null;
                %>
        <div class="container buscar">
            <a href="pruebabuscador.jsp" class="btn btn-success">Regresar</a>
            <%
                String nomBuscar=request.getParameter("textbuscar");
                if(nomBuscar!=null){
                    
                 smy= Conexion_Sql.getConnection().createStatement();
                rs = smy.executeQuery("select * from cliente where nombre like"+"'%"+nomBuscar+"%'");
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
                        <th class="text-center">Nit</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Direccion</th>
                    </tr>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getString("nit")%></td>
                        <td><%= rs.getString("nombre")%></td>
                        <td><%= rs.getString("direccion")%></td>
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
