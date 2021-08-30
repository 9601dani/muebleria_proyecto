
package com.mycompany.muebleria_progra.clases;

import java.math.BigDecimal;

/**
 *
 * @author daniel
 */
public class Pieza {
     private String tipo_pieza;
     private BigDecimal costo;
     private int cantidad;

    public Pieza(String tipo_pieza, BigDecimal costo, int cantidad) {
        this.tipo_pieza = tipo_pieza;
        this.costo = costo;
        this.cantidad = cantidad;
    }
    public Pieza(String tipo_pieza, BigDecimal costo) {
        this.tipo_pieza = tipo_pieza;
        this.costo = costo;
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

    public void setTipo_pieza(String tipo_pieza) {
        this.tipo_pieza = tipo_pieza;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
     
}
