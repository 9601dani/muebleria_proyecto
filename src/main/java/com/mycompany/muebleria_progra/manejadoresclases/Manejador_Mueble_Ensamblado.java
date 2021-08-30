package com.mycompany.muebleria_progra.manejadoresclases;


import com.mycompany.muebleria_progra.clases.Ensamble_Pieza;
import com.mycompany.muebleria_progra.clases.Mueble_Ensamblado;
import com.mycompany.muebleria_progra.clases.Pieza;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Manejador_Mueble_Ensamblado {
    public static final String FORMATO_CARGA="dd/mm/yyyy";
    public static final String FORMATO_SQL="yyyy-MM-dd";
    private final String AÑADIR_M_E="INSERT INTO mueble_ensamblado (id_mueble_ensamblado,fecha_ensamble,usuario_nombre,id_estado_mueble,nombre_mueble,costo_fabricacion) VALUES(?,?,?,?,?,?)";
    private final String SELECT="SELECT * FROM mueble_ensamblado WHERE id_mueble_ensamblado=?";
     private final String SELECT_ESTADO="SELECT * FROM estado_mueble_ensamblado WHERE id_estado_mueble_ensamblado=?";
    private final String SELECT_SELECT="SELECT * FROM mueble_ensamblado WHERE nombre_mueble=?";
    private final String SELECT_ALL="SELECT * FROM mueble_ensamblado";
    private final String DELETE="DELETE FROM mueble_ensamblado WHERE id_mueble_ensamblado=?";
    private final String UPDATE="UPDATE mueble_ensamblado SET id_estado_mueble=? WHERE id_mueble_ensamblado=?";
    private Connection conexion;

    public Manejador_Mueble_Ensamblado() {
        Conexion_Sql co= new Conexion_Sql();
    }
    
    public String verificacion(Mueble_Ensamblado mueble) {
        String retorno="";
        System.out.println(mueble.getNombre_mueble());
        Manejador_Ensamble_Pieza mep = new Manejador_Ensamble_Pieza();
        ResultSet datosObtenidos_piezas= mep.select_especial(mueble.getNombre_mueble());
        ArrayList<Ensamble_Pieza> piezas_necesarias= new ArrayList<>();
        boolean ensamblar=true;
        double costo_fabricacion = 0;
        try {
            while (datosObtenidos_piezas.next()) {
                piezas_necesarias.add(new Ensamble_Pieza(datosObtenidos_piezas.getInt("cantidad"),datosObtenidos_piezas.getString("nombre_mueble"), datosObtenidos_piezas.getString("tipo_pieza"), datosObtenidos_piezas.getBigDecimal("pieza_costo")));
            }
            if (piezas_necesarias.size() > 0) {
                ArrayList<ResultSet> resultado_piezas = new ArrayList<>(); 
                ArrayList<Pieza> piezas = new ArrayList<>();
                Manejador_Pieza mp = new Manejador_Pieza();

                for (Ensamble_Pieza piezas_para_ensamble : piezas_necesarias) {
                    resultado_piezas.add(mp.select_especial(piezas_para_ensamble.getTipo_pieza())); 
                }

                for (int i = 0; i < resultado_piezas.size(); i++) { 
                    while (resultado_piezas.get(i).next()) {
        
                        piezas.add(new Pieza(resultado_piezas.get(i).getString("tipo_pieza"), resultado_piezas.get(i).getBigDecimal("costo"), resultado_piezas.get(i).getInt("cantidad")));
                    }
                }
         
                if (piezas.size() > 0) {
                    int piezasEncontradas = 0;
                    for (Ensamble_Pieza receta : piezas_necesarias) { 
                        int piezasFaltantes = receta.getCantidad();
                        for (int i = 0; i < piezas.size(); i++) {

                            if (receta.getTipo_pieza().equals(piezas.get(i).getTipo_pieza())) { 
                                System.out.println("Entra 1");
                                int piezasUtilizadas = 0;

                                if (piezas.get(i).getCantidad() - piezasFaltantes >= 0) { 
                                    piezasUtilizadas = piezasFaltantes; 
                                    piezas.get(i).setCantidad(piezas.get(i).getCantidad() - piezasFaltantes); 
                                    piezasFaltantes = 0; 

                                } else if (piezasFaltantes - piezas.get(i).getCantidad() > 0 && piezas.get(i).getCantidad() > 0) { 
                                    piezasUtilizadas = piezas.get(i).getCantidad();
                                    piezas.get(i).setCantidad(0); 
                                    piezasFaltantes = piezasFaltantes - piezasUtilizadas;
                                } else if (piezas.get(i).getCantidad() == 0) {
                                    break;
                                }

                                if (piezasFaltantes == 0 && ensamblar == true) { 
                                    System.out.println("Entra 2"); 
                                    piezasEncontradas++;
                                    costo_fabricacion += piezas.get(i).getCosto().doubleValue() * piezasUtilizadas; //obtenemos el costo del mueble agregandole el precio de la pieza multiplicada por el número de piezas utilizadas
                                    break;
                                } else if (piezasFaltantes > piezasUtilizadas && piezasUtilizadas > 0) { //si las piezas faltantes es mayor al número de piezas encontradas pero se han utilizado algunas piezas entonces aún así se debe agregar el costo de dicha pieza utilizada
                                    costo_fabricacion += piezas.get(i).getCosto().doubleValue() * piezasUtilizadas;//igual que arriba
                                    continue; //utiliza continue ya que no se han encontrado todas las piezas y se debe seguir buscando
                                } else if (piezasFaltantes > 0 && ensamblar == true && i == piezas.size()) { //si todavía hay piezas faltantes y el iterador ya ha llegado al último valor significa que no encontró el número de piezas necesarias para la elaboración del producto
                                    ensamblar = false;
                                }
                            }
                        }

                        if (ensamblar == false) {
                            break;
                        }
                    }
                    if (ensamblar == true && piezasEncontradas == piezas_necesarias.size()) { //hace el update e insert si el ensamble es permitido y el número de piezas encontradas es igual al número de piezas necesarias en la receta
                        Manejador_Pieza update = new Manejador_Pieza();
                        for (Pieza piezasActualizadas : piezas) {
                            Pieza pieza_actualizada = new Pieza(piezasActualizadas.getTipo_pieza(), piezasActualizadas.getCosto(), piezasActualizadas.getCantidad());
                            update.update(pieza_actualizada);
                        }
                        retorno+="SE GUARDO";
                        añadir(mueble, BigDecimal.valueOf(costo_fabricacion));
                    } else {
                        System.err.println("\n\n\n\n\nNo posee todas las piezas para la elaboración del mueble. error 2");
                    }
                }
            } else {
                System.out.println("NO HAY PIEZAS ASIGNADAS PARA EL MUEBLE");
            }
        } catch (SQLException p) {
            System.out.println(p);
            System.out.println("error");
            retorno+="NO SE GUARDO";
        }
        return retorno;
        
    }
    
    public int añadir(Mueble_Ensamblado mueble, BigDecimal costo){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(AÑADIR_M_E);
            query.setString(1, mueble.getId_mueble_ensamblado());
            query.setDate(2, java.sql.Date.valueOf(new SimpleDateFormat(FORMATO_SQL).format(mueble.getFecha_ensamble())));
            query.setString(3, mueble.getNombre_usuario());
            query.setInt(4, mueble.getEstado_mueble());
            query.setString(5, mueble.getNombre_mueble());
            query.setBigDecimal(6, costo);
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
        return 0;
        
    }
    
    public  java.util.Date formatoFecha(String fechaS, String formatoFecha){
        SimpleDateFormat format= new SimpleDateFormat(formatoFecha);
        java.util.Date fecha;
        
        try{
            fecha=format.parse(fechaS);
            return fecha;
        }catch(ParseException P){
            P.printStackTrace();
            return null;
        }
        
    }
    
    public ResultSet select(String id_mueble){
        ResultSet datosObtenidos=null;
        PreparedStatement query=null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setString(1, id_mueble);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
       return datosObtenidos;
    }
    public ResultSet select_estado(int id_estado_mueble){
        ResultSet datosObtenidos=null;
        PreparedStatement query=null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT_ESTADO);
            query.setInt(1, id_estado_mueble);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
       return datosObtenidos;
    }
    
    public ResultSet select_select(String nombre_mueble){
        ResultSet datosObtenidos=null;
        PreparedStatement query=null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT_SELECT);
            query.setString(1, nombre_mueble);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
       return datosObtenidos;
    }
    
    public ResultSet select_all(){
        ResultSet datosObtenidos=null;
        PreparedStatement query;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT_ALL);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
       return datosObtenidos;
    }
    
     public void delete(String id_mueble){
        try {
            PreparedStatement query = Conexion_Sql.conexion.prepareStatement(DELETE);
            query.setString(1, id_mueble);
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
    }
     public int update(String id){
        PreparedStatement query=null;
       try {
            query= Conexion_Sql.conexion.prepareStatement(UPDATE);
            query.setInt(1, 2);
            query.setString(2, id);
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
               Conexion_Sql co= new Conexion_Sql(1);
        return 0;
        
    }
    
}
