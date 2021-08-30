/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.clases;

import java.math.BigDecimal;
import java.util.Date;



/**
 *
 * @author daniel
 */
public class Devolucion {
    private int id_devolucion;
    private BigDecimal costo_perdida;
    private Date fecha_devolucion;
    private int id_factura;

    public Devolucion(int id_devolucion, BigDecimal costo_perdida, Date fecha_devolucion, int id_factura) {
        this.id_devolucion = id_devolucion;
        this.costo_perdida = costo_perdida;
        this.fecha_devolucion = fecha_devolucion;
        this.id_factura = id_factura;
    }

    public Devolucion(BigDecimal costo_perdida, Date fecha_devolucion, int id_factura) {
        this.costo_perdida = costo_perdida;
        this.fecha_devolucion = fecha_devolucion;
        this.id_factura = id_factura;
    }

    public int getId_devolucion() {
        return id_devolucion;
    }

    public BigDecimal getCosto_perdida() {
        return costo_perdida;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public void setCosto_perdida(BigDecimal costo_perdida) {
        this.costo_perdida = costo_perdida;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }
    
    //METODO PARA CAMBIAR LAS FECHAS A SQL
    /*Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);*/
    
}
