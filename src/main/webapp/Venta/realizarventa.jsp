<%-- 
    Document   : realizarventa
    Created on : 30/08/2021, 00:15:45
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
        <div class="text-center">
            <h1>Registro de Venta</h1>
            <img class="mb-4" src="/Muebleria_Progra/imagen/ventas.jpg" alt="" width="250" height="150">
        </div>
                <%
                   Conexion_Sql co= new Conexion_Sql();
                   Statement smy;
                   ResultSet rs;
                   smy=Conexion_Sql.getConnection().createStatement();
                   rs=smy.executeQuery("select * from cliente");
                %>
        <div class="container buscar">
            <a href="/Muebleria_Progra/Venta/iventa.jsp" class="btn btn-success">Regresar</a>
            <br>
            <br>
            <form class="form" >
                <input class="form-control" type="text" name="textbuscar" placeholder="nombre del cliente">
            <div class="col-sm">
                <div class="form-group col-md-12">
                    <input class="btn btn-success" type="submit" value="BUSCAR">
                </div>
            </div>
                <br>
            <div class="col-sm">
              <div class="form-group col-md-12">
                   <a href="/Muebleria_Progra/Venta/ventasincliente.jsp" class="btn btn-primary"> Registrar Cliente</a>
              </div>
            </div>
                <br>
                <a> *** Si no encuentra el cliente presione "registrar" para registrar al cliente</a>
            </form> 
            
             
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
                
        </div>
         <form method="post" action="/Muebleria_Progra/NuevaVenta">
            <div class="container">
                <div class="row">
                  <div class="col-sm">
                    <div class="form-group col-md-12">
                        <label for="inputEmail4">Nit Cliente</label>
                        <input name="textnit" type="text" class="form-control" id="in" placeholder="(no uses guiones)">
                    </div>
                  </div>
                </div>
                
            </div>
            <br>      
              <div class="text-center">
                  <%
                   Conexion_Sql con= new Conexion_Sql(1);
                %>
                  <button type="submit" class="btn btn-primary">Corroborar datos</button>
              </div>
          </form>
                <script src="js/jquery.js" type="text/javascript"></script>
                <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>

