/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.clases;

import java.math.BigDecimal;

/**
 *
 * @author daniel
 */
public class Ensamble_Pieza {
    private int cantidad;
    private String tipo_pieza;
    private BigDecimal pieza_costo;
    private String nombre_mueble;

    public Ensamble_Pieza(int cantidad,String nombre_mueble, String tipo_pieza, BigDecimal pieza_costo) {
        this.cantidad = cantidad;
        this.tipo_pieza = tipo_pieza;
        this.pieza_costo = pieza_costo;
        this.nombre_mueble = nombre_mueble;
    }

    public Ensamble_Pieza(int cantidad, String tipo_pieza, String nombre_mueble) {
        this.cantidad = cantidad;
        this.tipo_pieza = tipo_pieza;
        this.nombre_mueble = nombre_mueble;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo_pieza() {
        return tipo_pieza;
    }

    public BigDecimal getPieza_costo() {
        return pieza_costo;
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

    public void setPieza_costo(BigDecimal pieza_costo) {
        this.pieza_costo = pieza_costo;
    }

    public void setNombre_mueble(String nombre_mueble) {
        this.nombre_mueble = nombre_mueble;
    }
    
    
}
