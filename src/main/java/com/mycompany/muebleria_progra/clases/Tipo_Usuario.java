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
public class Tipo_Usuario {
    private int id_tipo_usuario;
    private String nombre;

    public Tipo_Usuario(int id_tipo_usuario, String nombre) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.nombre = nombre;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
