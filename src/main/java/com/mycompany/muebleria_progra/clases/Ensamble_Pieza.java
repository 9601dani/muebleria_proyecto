/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.clases;

import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Ensamble_Pieza;
import java.math.BigDecimal;

/**
 *
 * @author daniel
 */
public class Ensamble_Pieza extends Manejador_Ensamble_Pieza {
    private int cantidad;
    private String tipo_pieza;
    private String nombre_mueble;



    public Ensamble_Pieza(int cantidad, String tipo_pieza, String nombre_mueble) {
        this.cantidad = cantidad;
        this.tipo_pieza = tipo_pieza;
        this.nombre_mueble = nombre_mueble;
    }

    public Ensamble_Pieza() {
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo_pieza() {
        return tipo_pieza;
    }


    public String getNombre_mueble() {
        return nombre_mueble;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo_pieza(String tipo_pieza) {
        this.tipo_pieza = tipo_pieza;
    }


    public void setNombre_mueble(String nombre_mueble) {
        this.nombre_mueble = nombre_mueble;
    }
    
    
}
