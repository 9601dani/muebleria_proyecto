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
public class Mueble {
    private String nombre_mueble;
    private BigDecimal precio;

    public Mueble(String nombre_mueble, BigDecimal precio) {
        this.nombre_mueble = nombre_mueble;
        this.precio = precio;
    }

    public String getNombre_mueble() {
        return nombre_mueble;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setNombre_mueble(String nombre_mueble) {
        this.nombre_mueble = nombre_mueble;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
}
