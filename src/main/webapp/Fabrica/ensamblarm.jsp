<%-- 
    Document   : ensamblarm
    Created on : 4/09/2021, 14:51:38
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
        <title>JSP Ceacion Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
        <body   style="background-color: beige">
            <section class="text-center">
                <h3>
                Ensamblar Mueble
                </h3> 
        <p>
        <p>
        <p>
        <p>
            <div>
                <img class="mb-4" src="/Muebleria_Progra/imagen/imagen.png" alt="" width="100" height="100">
            </div>
            </section>
            
        <p>
        <p>                
        <p>
        <p>
        <form style="background-color: lightsteelblue" action="/Muebleria_Progra/Ensamblar" method="post">
            <div class="form-row">
                <div class="form-group required">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Nombre Mueble *</label>
                        <br>
                        <select name="textmueble">
                    <%
                        Conexion_Sql co = new Conexion_Sql();
                        Statement smy;
                        ResultSet rs;
                        smy = Conexion_Sql.getConnection().createStatement();
                        rs = smy.executeQuery("SELECT * FROM mueble");
                        while (rs.next()) {

                    %>
                    <option value="<%=rs.getString("nombre_mueble")%>"><%=rs.getString("nombre_mueble")%></option>
                    <%}%>
                </select> 
                    </div>
                </div>   
                <br>
                <div class="form-group col-md-6">
                    <label for="inputAddress"> Usuario De Fabrica *</label>
                    <br>
                     <select name="textnom">
                    <%
                        Conexion_Sql c = new Conexion_Sql();
                        Statement sm;
                        ResultSet r;
                        sm = Conexion_Sql.getConnection().createStatement();
                        r = sm.executeQuery("SELECT * FROM usuario");
                        while (r.next()) {
                        if(r.getInt("tipo_usuario")==3){
                    %>
                    <option value="<%=r.getString("nombre_usuario")%>"><%=r.getString("nombre_usuario")%></option>
                    <%}%>
                    <%}%>
                </select> 
                </div>

                <br>
                <input type="submit" class="btn btn-primary btn-sm" value="Ensamblar Mueble" />
            </div>
            <br>
        </form>
        <div class="text-center">
            <a class="btn btn-primary btn-sm" href="/Muebleria_Progra/Fabrica/ifabrica.jsp">REGRESAR</a>
        </div>
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
