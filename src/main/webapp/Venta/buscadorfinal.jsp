<%-- 
    Document   : buscadorfinal
    Created on : 30/08/2021, 16:38:57
    Author     : daniel
--%>

<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble_Ensamblado"%>
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
        <div class="text-center">
            <<h2>CONSULTA DE MUEBLES DISPONIBLES</h2>
        </div>
        <br>
        <div class="text-align">
            <a href="/Muebleria_Progra/Venta/iventa.jsp" class="btn btn-success">Regresar</a>
        </div>
        <br>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("select * from mueble_ensamblado");
                %>
        <div class="container buscar">
            
            <br>
            <br>
            <form class="form" >
                <label> Nombre mueble</label>
                <input class="form-control" type="text" name="textbuscarm" placeholder="ingresa nombre del mueve para buscar"  required>
                <input class="btn btn-success" type="submit" value="BUSCAR">
                <br>
            </form> 
            <%
                String nomBuscar=request.getParameter("textbuscarm");
                if(nomBuscar!=null){
                 smy= Conexion_Sql.getConnection().createStatement();
                rs = smy.executeQuery("select * from mueble_ensamblado where nombre_mueble like"+"'%"+nomBuscar+"%'");
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
                        <th class="text-center">Id Mueble</th>
                        <th class="text-center">Nombre Mueble</th>
                        <th class="text-center">Fecha Ensamble</th>
                        <th class="text-center">Estado Mueble</th>
                    </tr>
                </thead>
                <tbody id="tbodys">
                    <%
                    while(rs.next()){
                        if(rs.getInt("id_estado_mueble")==1){
                       ResultSet rp =  new Manejador_Mueble_Ensamblado().select_estado(rs.getInt("id_estado_mueble"));
                
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getString("id_mueble_ensamblado")%></td>
                        <td><%= rs.getString("nombre_mueble")%></td>
                        <td><%= rs.getDate("fecha_ensamble")%></td>
                        <td><%= rp.getString("nombre_estado")%></td>
                    </tr>
                        <%}%>
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
