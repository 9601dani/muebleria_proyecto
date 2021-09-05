package com.mycompany.muebleria_progra.servlet.venta;

import com.mycompany.muebleria_progra.clases.Devolucion;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Devolucion;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Factura;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble_Ensamblado;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class ReintegroVenta extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String cod_fac= request.getParameter("textcodfactura");
        if (cod_fac == "") {
            response(response, "campos vacios", request);
        } else {
            try {
                Manejador_Factura nu = new Manejador_Factura();
                ResultSet datosObtenidos = nu.select(Integer.parseInt(cod_fac));
                    if (datosObtenidos.getInt("id_factura") == Integer.parseInt(cod_fac) && datosObtenidos != null) {
                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String f = simpleDateFormat.format(datosObtenidos.getDate("fecha_compra"));
                        String f2 = simpleDateFormat.format(date);
                        Date fechafin = simpleDateFormat.parse(f);
                        Date fechaact = simpleDateFormat.parse(f2);
                        long diff =  fechaact.getTime() - fechafin.getTime();
                        TimeUnit time = TimeUnit.DAYS;
                        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
                        if ((diffrence) <= 7) {
                            String formattedDate = simpleDateFormat.format(date);
                            java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
                            try{ // aqui hay error
                                Manejador_Mueble_Ensamblado mm = new Manejador_Mueble_Ensamblado();
                                ResultSet datosM = mm.select(datosObtenidos.getString("id_mueble_ensamblado"));
                                if(datosM.next() && datosM!=null){
                                    BigDecimal costperdida = datosM.getBigDecimal("costo_fabricacion");
                                    double d=costperdida.doubleValue()/3;
                                    BigDecimal cf= new BigDecimal(d);
                                    Devolucion dev = new Devolucion(cf, date1, Integer.parseInt(cod_fac));
                                    try {
                                        Manejador_Mueble_Ensamblado m = new Manejador_Mueble_Ensamblado();
                                        m.update(datosObtenidos.getString("id_mueble_ensamblado"),1);
                                        this.registrar(dev, response);
                                    } catch (SQLException l) {
                                    }
                                }
                            }catch(SQLException p){
                            }
                        } else {
                            response(response, "tiempo fuera", request);
                        }
                    } else {
                        response(response, "factura no existe", request);
                    }
            } catch (SQLException ex) {
                System.out.println("error jeje");
                System.out.println(ex);
                response(response, "factura no existe", request);
                
            }   catch (ParseException ex) {
                    System.out.println("por fechas");
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
            out.println(" <a href=\"/Muebleria_Progra/Venta/reintregreacionmueble.jsp\"> Volver</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } else if (msg.equals("factura no existe")) {
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
            out.println("<t1>" + "La factura ingresada no existe" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Venta/reintregreacionmueble.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }else if (msg.equals("tiempo fuera")) {
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
            out.println("<t1>" + "Ha Transcurrido mucho tiempo desde la compra" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Venta/reintregreacionmueble.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }
    }
      public void registrar(Devolucion dev,HttpServletResponse resp){
           PrintWriter out;
        try {
            Manejador_Devolucion nu= new Manejador_Devolucion();
            nu.añadir(dev);
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
            out.println("<t1>" + "Hemos Guardado la devolucion con codigo: "+ dev.getId_factura()+ "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/yes.png\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Venta/iventa.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            System.out.println("error escritura");
      //  } catch(SQLException e){
            System.out.println("error al registrar devolucion");
        }
      }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
