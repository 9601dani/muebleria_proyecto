<%-- 
    Document   : ventacliente
    Created on : 30/08/2021, 01:17:43
    Author     : daniel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble"%>
<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble_Ensamblado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Venta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body>
        <div class="text-center">
            <h1>Registro de Venta</h1>
            <img class="mb-4" src="imagen/ventas.jpg" alt="" width="250" height="150">
        </div>
        <h6> Datos Cliente</h6>
        <form method="post" action="VentaFinal">
            <div class="container">
                <div class="row">
                  <div class="col-sm">
                    <div class="form-group col-md-12">
                        <label for="inputText">Nit Cliente</label>
                        <input name="textnit" type="text" class="form-control" id="in" placeholder="(no uses guiones)">
                    </div>
                  </div>
                </div>
            </div>
            <br> 
            <h6> Datos mueble</h6>
            <div>
                <input name="textmueble" type="text" class="form-control" id="in" placeholder="(ingresa codigo del mueble)"> 
                    <table >
                    <tr>
                        <th> Nombre Mueble </th>
                        <th> Id Mueble </th>
                        <th> Estado Mueble </th>
                    </tr>
                    <%
                        Manejador_Mueble_Ensamblado mu= new Manejador_Mueble_Ensamblado();
                        ResultSet datosObtenidos=mu.select_all();
                        int contador=1;
                        while(datosObtenidos.next()){
                            if(datosObtenidos.getInt("id_estado_mueble")==1){
                                out.println("<tr>");
                                    out.println("<td>");
                                    out.println(contador+". "+datosObtenidos.getString("nombre_mueble"));
                                    out.println("</td>");
                                    out.println("<td>");
                                    out.println(datosObtenidos.getString("id_mueble_ensamblado"));
                                    out.println("</td>");
                                    Manejador_Mueble_Ensamblado me= new Manejador_Mueble_Ensamblado();
                                    ResultSet datos=me.select_estado(datosObtenidos.getInt("id_estado_mueble"));
                                    while(datos.next()){
                                    out.println("<td>");
                                    out.println(datos.getString("nombre_estado"));
                                    out.println("</td>");
                                }
                                out.println("</tr>");
                            }

                        contador++;
                        }
                    %>
                        </table>
            </div>
              <div class="text-center">
                  <button type="submit" class="btn btn-primary">Realizar Venta</button>
              </div>
          </form>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
