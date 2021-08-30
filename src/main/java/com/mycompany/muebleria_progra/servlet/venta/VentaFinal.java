/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet.venta;

import com.mycompany.muebleria_progra.clases.Factura;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Cliente;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Factura;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble_Ensamblado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class VentaFinal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nit= request.getParameter("textnit");
        String codmueble=request.getParameter("textmueble").toUpperCase();
        if(nit=="" || codmueble==""){
            response(response,"campos vacios",request);
        }else{
                try {
                    Manejador_Cliente nu = new Manejador_Cliente();
                    ResultSet datosObtenidos=nu.select(nit);
                    if (datosObtenidos.getString("nit").equals(nit) && datosObtenidos!=null) {
                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = simpleDateFormat.format(date);
                        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate); 
                        Factura nf= new Factura(date1,nit,codmueble);
                        this.realizarVenta(nf, response);
                    } else {
                        response(response,"cliente no existente", request);
                    }
                } catch (SQLException ex) {
                    response(response,"cliente no existente", request);
                }
        }
        

    }
    private void response(HttpServletResponse resp, String msg, HttpServletRequest request)
            throws IOException {
        if (msg.equals("campos vacios")) {
            PrintWriter out = resp.getWriter();
             out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\">");
            out.println("<t1>" + "Hemos detectado campos vacios" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"InicioServlet?eleccion=rventa\"> Registrar Nuevamente</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }else if (msg.equals("cliente no existente")) {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\" >");
            out.println("<t1>" + "No hemos encontrado el cliente" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a class=\"btn btn-primary\"href=\"InicioServlet?eleccion=rventa\">Registrar Venta</a>");
            out.println("<br>");
            out.println(" <a class=\"btn btn-primary\"href=\"InicioServlet?eleccion=ncliente\"> Registrar Cliente</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public void realizarVenta(Factura factura,HttpServletResponse resp){
            Manejador_Mueble_Ensamblado nu = new Manejador_Mueble_Ensamblado();
            nu.update(factura.getId_mueble());
            PrintWriter out;
        try {
            Manejador_Factura nf = new Manejador_Factura();
            nf.añadir(factura);
            out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\">");
            out.println("<t1>Hemos registrado la venta</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"imagen/yes.png\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"CerrarSesion?eleccion=regresarV\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            System.out.println("error escritura");
        }
               
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
