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
public class Mueble_Ensamblado {
    private String id_mueble_ensamblado;
    private Date fecha_ensamble;
    private String nombre_usuario;
    private int estado_mueble;
    private String nombre_mueble;
    private BigDecimal costo_fabricacion;
    private char[] digitos = {'0','1','2','3','4','5','6','7','8','9'}; //10 
    private char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};//26

    public Mueble_Ensamblado(String id_mueble_ensamblado, Date fecha_ensamble, String nombre_usuario, int estado_mueble, String nombre_mueble,BigDecimal costo_fabricacion) {
        this.id_mueble_ensamblado = id_mueble_ensamblado;
        this.fecha_ensamble = fecha_ensamble;
        this.nombre_usuario = nombre_usuario;
        this.estado_mueble = estado_mueble;
        this.nombre_mueble = nombre_mueble;
        this.costo_fabricacion= costo_fabricacion;
    }

    public Mueble_Ensamblado(Date fecha_ensamble, String nombre_usuario, String nombre_mueble,BigDecimal costo_fabricacion) {
        this.id_mueble_ensamblado=this.cod_mueble();
        this.fecha_ensamble = fecha_ensamble;
        this.nombre_usuario = nombre_usuario;
        this.estado_mueble = 1;
        this.nombre_mueble = nombre_mueble;
        this.costo_fabricacion= costo_fabricacion;
    }

    public Mueble_Ensamblado(Date fecha_ensamble, String nombre_usuario, String nombre_mueble) {
        this.id_mueble_ensamblado = this.cod_mueble();
        this.fecha_ensamble = fecha_ensamble;
        this.nombre_usuario = nombre_usuario;
        this.estado_mueble=1;
        this.nombre_mueble = nombre_mueble;
    }

    

    public String getId_mueble_ensamblado() {
        return id_mueble_ensamblado;
    }

    public Date getFecha_ensamble() {
        return fecha_ensamble;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public int getEstado_mueble() {
        return estado_mueble;
    }

    public String getNombre_mueble() {
        return nombre_mueble;
    }

    public void setId_mueble_ensamblado(String id_mueble_ensamblado) {
        this.id_mueble_ensamblado = id_mueble_ensamblado;
    }

    public void setFecha_ensamble(Date fecha_ensamble) {
        this.fecha_ensamble = fecha_ensamble;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setEstado_mueble(int estado_mueble) {
        this.estado_mueble = estado_mueble;
    }

    public void setNombre_mueble(String nombre_mueble) {
        this.nombre_mueble = nombre_mueble;
    }
    
    private String cod_mueble(){
       String cod="";
       int num= (int)(Math.random()*10+8);
        for (int i = 0; i < num; i++) {
            int num1 = (int) (Math.random() * 2+1);
            switch (num1) {
                case 1:
                    int num2=(int)(Math.random() *10);
                    cod+=digitos[num2];
                    break;
                case 2:
                     int num3=(int)(Math.random()*26);
                    cod+= letras[num3];
                    break;
            }
        }
       return cod.toUpperCase();
    }
    
}
