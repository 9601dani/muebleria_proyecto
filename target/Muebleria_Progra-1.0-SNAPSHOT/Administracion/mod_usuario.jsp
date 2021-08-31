<%-- 
    Document   : mod_usuario
    Created on : 29/08/2021, 21:53:26
    Author     : daniel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Ceacion Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <br>
    <br>
        <body   style="background-color: beige">
            <section class="text-center">
                <h3>
                Editar Usuario
                </h3> 
        <p>
        <p>
        <p>
        <p>
            <div>
                <img class="mb-4" src="/Muebleria_Progra/imagen/imagen.png" alt="" width="100" height="100">
            </div>
            </section>
            <br>
            <form class="text-align" style="background-color: darkgray;">
                <table >
                    <tr>
                        <th> Nombre de Usuario </th>
                        <th> Tipo De Usuario </th>
                    </tr>
                    <%
                        Manejador_Usuario mu= new Manejador_Usuario();
                        ResultSet datosObtenidos=mu.select_all();
                        int contador=1;
                        while(datosObtenidos.next()){
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(contador+". "+datosObtenidos.getString("nombre_usuario"));
                        Manejador_Usuario m= new Manejador_Usuario();
                        ResultSet datos= m.select_tipo(datosObtenidos.getInt("tipo_usuario"));
                        while(datos.next()){
                        out.println("<td>");
                        out.println(""+datos.getString("nombre"));
                         out.println("</td>");
                        }
                        out.println("</td>");
                        out.println("</tr>");
                        contador++;
                        }
                    %>
                </table>
            </form>
            <br>
            <form style="background-color: lightsteelblue" action="/Muebleria_Progra/ModificacionUsuario" method="post">
            <div class="form-row">
                <div class="form-group required">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Nombre de Usuario*</label>
                        <input name="textusuari" type="text" class="form-control" id="inputEmail4" placeholder="ejem: 'Nombre1997'">
                    </div>
                </div>
                <br>
                <div class="form-group col-md-6">
                    <fieldset disabled>
                <div class="form-group">
                    <label for="disabledSelect">Accion a Realizar:</label>
                    <option for="disabledSelect" value="4">**** Cancelar Usuario ****</option>
                </div>
            </fieldset>
                </div>
                <br>
                <input type="submit" class="btn btn-primary btn-sm" value="Cancelar Usuario" />
            </div>
            <br>
        </form>
        <div class="text-center">
            <a class="btn btn-primary btn-sm" href="/Muebleria_Progra/Administracion/iadministracion.jsp">REGRESAR</a>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
