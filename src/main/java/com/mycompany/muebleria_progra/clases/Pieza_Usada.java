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
public class Pieza_Usada {
    private String tipo_pieza;
    private BigDecimal costo;
    private int cantidad;
    private String id_mueble_ensamblado;

    public Pieza_Usada(String tipo_pieza, BigDecimal costo, int cantidad, String id_mueble_ensamblado) {
        this.tipo_pieza = tipo_pieza;
        this.costo = costo;
        this.cantidad = cantidad;
        this.id_mueble_ensamblado = id_mueble_ensamblado;
    }

    public String getTipo_pieza() {
        return tipo_pieza;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getId_mueble_ensamblado() {
        return id_mueble_ensamblado;
    }

    public void setTipo_pieza(String tipo_pieza) {
        this.tipo_pieza = tipo_pieza;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setId_mueble_ensamblado(String id_mueble_ensamblado) {
        this.id_mueble_ensamblado = id_mueble_ensamblado;
    }
    
    
}
