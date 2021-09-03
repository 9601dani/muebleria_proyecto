package com.mycompany.muebleria_progra.servlet.venta;

import com.mycompany.muebleria_progra.clases.Usuario;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Cliente;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class NuevaVenta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("----------------------------");
        String nit= request.getParameter("textnit");
        if(nit==""){
            response(response,"campos vacios",request);
        }else{
                try {
                    Manejador_Cliente nu = new Manejador_Cliente();
                    ResultSet datosObtenidos=nu.select(nit);
                    if (datosObtenidos.getString("nit").equals(nit) && datosObtenidos!=null) {
                         response(response, "cliente existente", request);
                         request.getSession().setAttribute("nit", nit);
                         
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
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Venta/iventa.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } else if (msg.equals("cliente existente")) {
            Conexion_Sql c= new Conexion_Sql(9);
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
            out.println("<t1>" + "Hemos encontrado el cliente" + "</t1>");
            out.println("<br>");
            request.getRequestDispatcher("/realizarventa.jsp");
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
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a class=\"btn btn-primary\"href=\"/Muebleria_Progra/Venta/ventasincliente.jsp\"> Registrar Cliente</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
