<%-- 
    Document   : editarp
    Created on : 3/09/2021, 00:27:39
    Author     : daniel
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mycompany.muebleria_progra.conexion.Conexion_Sql"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="com.mycompany.muebleria_progra.manejadoresclases.Manejador_Pieza"%>
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
            <h2>Editar Pieza</h2>
        </div>

        <div class="container buscar">
            <a href="/Muebleria_Progra/Fabrica/modpiezas.jsp" class="btn btn-success">Regresar</a>
            <br>
            <br>
            <form class="form" >
                <div class="col-sm">
                    <div class="form-group col-md-12">
                    <a> *** Si no encuentra la pieza presione "registrar" para registrar una nueva pieza</a>
                    <br>
                    <a href="/Muebleria_Progra/Fabrica/npieza.jsp" class="btn btn-primary"> Registrar Pieza</a>
                    </div>
                    <br>
                    <br>
                </div>
            </form> 
            <a>EDITAR:</a>
            <br>
            <%
                Manejador_Pieza mp = new Manejador_Pieza();
                ResultSet datosObtenidos = mp.select_all();
            %>
            <br>
            <form>
                <div class="form-group">
                    <select name="texttipo" class="custom-select d-block w-50" id="inlineFormCustomSelectPref">
                        <%
                            while (datosObtenidos.next()) {
                        %>
                        <option value="<%=datosObtenidos.getString("tipo_pieza") + "-" + datosObtenidos.getBigDecimal("costo")%>"> <%=datosObtenidos.getString("tipo_pieza") + "-" + datosObtenidos.getBigDecimal("costo")%></option>
                        <%}%>
                    </select>
                    <br>
                </div>
                <input class="btn btn-success" type="submit" value="Seleccionar para editar">
                <br>
                <a> *** (Recuerda que solo puedes editar el precio o su costo) ***</a>
            </form> 
            <br>
        </div>
    </div>

    <%
        Conexion_Sql co = new Conexion_Sql();
        Statement smy;
        ResultSet rs;
        smy = Conexion_Sql.getConnection().createStatement();
        rs = smy.executeQuery("select * from pieza where tipo_pieza='nul'");
    %>
    <div class="container buscar">
        <br>
        <%
            String nomBuscar = request.getParameter("texttipo");
            if (nomBuscar != null) {
                smy = Conexion_Sql.getConnection().createStatement();
                String[] datos = nomBuscar.split("-");
                rs = smy.executeQuery("select * from pieza where tipo_pieza=" + "'" + datos[0] + "' AND costo=" + "'" + datos[1] + "' ");
            } else {
                System.out.println("error");
            }

        %>
    </div>
        <div class="container">
            <form method="POST" action="/Muebleria_Progra/MPieza">
                <%                while (rs.next()) {
                BigDecimal costoinicial= rs.getBigDecimal("costo");
                %>
                <label type="text"> Nombre de la Pieza </label>
                <input class="form-control" type="text" name="textp" value="<%=rs.getString("tipo_pieza")%>" readonly>
                <br>
                <label type="text"> Precio Pieza </label>
                <input class="form-control" type="text" name="textc" value="<%=rs.getBigDecimal("costo")%>">
                <br>
                <label type="text"> Cantidad</label>
                <input class="form-control" type="text" name="textca" value="<%=rs.getInt("cantidad")%>">
                <br>
                <input class="form-control" type="hidden" name="textcostoa" value="<%=rs.getBigDecimal("costo")%>" >
                <%}%>
                <div class="text-center">
                    <input type="submit" class="btn btn-primary" value="ACTUALIZAR"></a>
                </div>
            </form>
        </div>
        
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>
