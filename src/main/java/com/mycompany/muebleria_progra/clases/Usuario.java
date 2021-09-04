/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.clases;

import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class Usuario extends Manejador_Usuario{
    private String nombre_usuario;
    private String passsword;
    private int tipo_usuario;

    public Usuario(String nombre_usuario, String passsword, int tipo_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.passsword = passsword;
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getPasssword() {
        return passsword;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    
}
