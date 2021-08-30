/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.clases;

import java.util.Date;

/**
 *
 * @author daniel
 */
public class Factura {
    private int id_factura;
    private Date fecha_compra;
    private String nit;
    private String id_mueble;

    public Factura(int id_factura, Date fecha_compra, String nit, String id_mueble) {
        this.id_factura = id_factura;
        this.fecha_compra = fecha_compra;
        this.nit = nit;
        this.id_mueble = id_mueble;
    }

    public Factura(Date fecha_compra, String nit, String id_mueble) {
        this.fecha_compra = fecha_compra;
        this.nit = nit;
        this.id_mueble = id_mueble;
    }

    public int getId_factura() {
        return id_factura;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public String getNit() {
        return nit;
    }

    public String getId_mueble() {
        return id_mueble;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setId_mueble(String id_mueble) {
        this.id_mueble = id_mueble;
    }
    
    
}
