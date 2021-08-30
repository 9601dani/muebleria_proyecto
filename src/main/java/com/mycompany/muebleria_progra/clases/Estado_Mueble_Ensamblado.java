/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.clases;

/**
 *
 * @author daniel
 */
public class Estado_Mueble_Ensamblado {
    private int id_estado_mueble;
    private String nombre_estado;

    public Estado_Mueble_Ensamblado(int id_estado_mueble, String nombre_estado) {
        this.id_estado_mueble = id_estado_mueble;
        this.nombre_estado = nombre_estado;
    }

    public int getId_estado_mueble() {
        return id_estado_mueble;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setId_estado_mueble(int id_estado_mueble) {
        this.id_estado_mueble = id_estado_mueble;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
    
    
}
