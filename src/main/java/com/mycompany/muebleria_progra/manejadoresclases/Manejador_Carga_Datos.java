package com.mycompany.muebleria_progra.manejadoresclases;

import com.mycompany.muebleria_progra.clases.Cliente;
import com.mycompany.muebleria_progra.clases.Ensamble_Pieza;
import com.mycompany.muebleria_progra.clases.Mueble;
import com.mycompany.muebleria_progra.clases.Mueble_Ensamblado;
import com.mycompany.muebleria_progra.clases.Pieza;
import com.mycompany.muebleria_progra.clases.Usuario;
import static com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble_Ensamblado.FORMATO_CARGA;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;


/**
 *
 * @author daniel
 */
public class Manejador_Carga_Datos extends Thread{
    private File archivo;
    private String nombreArchivo;
    private static final String USUARIO="USUARIO";
    private static final String PIEZA="PIEZA";
    private static final String MUEBLE="MUEBLE";
    private static final String ENSAMBLE_PIEZAS="ENSAMBLE_PIEZAS";
    private static final String ENSAMBLAR_MUEBLE="ENSAMBLAR_MUEBLE";
    private static final String CLIENTE="CLIENTE";
    private static final String[] NOMBRES ={USUARIO, PIEZA, MUEBLE, ENSAMBLE_PIEZAS, ENSAMBLAR_MUEBLE, CLIENTE};
    private static String lineaPrincipal=null;

    public Manejador_Carga_Datos(File archivo, String nombreArchivo) {
        this.archivo = archivo;
        this.nombreArchivo = nombreArchivo;
    }
    
        @Override
    public void run(){// METODO RUN PARA INICIAR LA SUBIDA DE ARCHIVOS 
        try {
            leerNuevosArchivos();// LLAMAMOS AL METODO
        } catch (FileNotFoundException ex) {
            System.out.println("ARCHIVO NO ENCONTRADO");
            System.out.println("No se puede leer el archivo");
        } catch (IOException ex) {
            System.err.println("ERROR IOEXEPTION");
        }
        
    }
    public void leerNuevosArchivos()throws FileNotFoundException, IOException{
        try{
            FileReader archivo1 = new FileReader(archivo); // PIDE EL ARCHIVO A SUBIR       
            BufferedReader archivo= new BufferedReader(archivo1); // LE ENVIAMOS AL LECTOR EL ARCHIVO
            String LArchivo = archivo.readLine(); // LEERA LINEA POR LINEA EL ARCHIVO
            this.lineaPrincipal= LArchivo;
            int posicion;
            String Vauxiliar ;
            String Vauxiliar1;
            String[] datosAProcesar; // ARREGLO DE LOS CAMPOS RECONOCIDOS
            while(LArchivo !=null){
                try {
                    posicion = LArchivo.indexOf("(");// devuelve el texto hasta donde haya un (
                    Vauxiliar = LArchivo.substring(0, posicion); // DEVUELVE LA CADENA  DESDE 0 HASTA DONDE ESTA EL PARENTESIS
                    Vauxiliar1 = LArchivo.substring(posicion); //DEVUELVE HASTA EL (
                    datosAProcesar = quitarParentesis(Vauxiliar1); // QUITA LAS , Y ) DE LA PALABRA
                    System.out.println(LArchivo);
                    System.out.println(Vauxiliar);
                    System.out.println(Vauxiliar1);
                    for (String string : datosAProcesar) {
                        System.out.println(string);
                    }
                    //verificarMetodo(Vauxiliar, datosAProcesar); // LLAMA EL METODO PARA GUARDARLO
                    verificarMetodo(Vauxiliar, datosAProcesar);
                    System.out.println(" mande al metodo");
                    LArchivo = archivo.readLine();
                    this.lineaPrincipal = LArchivo;

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("NO CUMPLE EL FORMATO, LA SIGUIENTE LINEA: " + lineaPrincipal);
                    e.printStackTrace();
                    LArchivo = archivo.readLine();
                }
            }
             System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
             System.out.println("**SE COMPLETO LA CARGA DE ARCHIVOS**".toUpperCase());
        }catch(Exception e){ 
             System.out.println("NO CUMPLE CON EL FORMATO VALIDO : "+lineaPrincipal);  
             System.out.println(e);
        }
    }
    public static String[] quitarParentesis(String lineaTexto){
        int posicionPrincipal;
        String texto;
        posicionPrincipal = lineaTexto.lastIndexOf(")");
        texto=lineaTexto.substring(1,posicionPrincipal); 
        String[] arregloLinea = texto.split(",");
        return arregloLinea;
    }
    
        public static String quitarComillas(String lineaTexto){
        String arregloLinea = lineaTexto.substring(1,lineaTexto.length()-1);
        return arregloLinea;
    }
    public void verificarMetodo(String nombreAVerificar, String[] datosObtenidos) throws IOException, SQLException{
        // SI ES USUARIO
        if(nombreAVerificar.equals(NOMBRES[0])){
            Usuario us;
            String nomU = quitarComillas(datosObtenidos[0]);
            String pass = quitarComillas(datosObtenidos[1]);
            int tip= Integer.parseInt(datosObtenidos[2]);
           
                us = new  Usuario(nomU,pass,tip);
                Manejador_Usuario mu = new Manejador_Usuario();
                mu.añadir(us);
               System.out.println(lineaPrincipal +" ***GUARDADA CON EXITO ***"); 
        }
        //SI ES PIEZA
        if(nombreAVerificar.equals(NOMBRES[1])){
            Pieza pieza;
            String tipo= quitarComillas(datosObtenidos[0]);
            BigDecimal costo= BigDecimal.valueOf(Double.parseDouble(datosObtenidos[1]));
                pieza = new Pieza(tipo,costo);
                Manejador_Pieza mp = new Manejador_Pieza();
                mp.añadir(pieza);
               System.out.println(lineaPrincipal +" ***GUARDADA CON EXITO ***");

        }
        // SI ES MUEBLE
        if (nombreAVerificar.equals(NOMBRES[2])) {
            Mueble mueble;
            String nom = quitarComillas(datosObtenidos[0]);
            BigDecimal costo = BigDecimal.valueOf(Double.parseDouble(datosObtenidos[1]));
            mueble = new Mueble(nom, costo);
            Manejador_Mueble mm = new Manejador_Mueble();
            mm.añadir(mueble);
            System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
        }
        //SI ES ENSAMBLE DE PIEZAS
        if (nombreAVerificar.equals(NOMBRES[3])) {
            Ensamble_Pieza ep;
            String nombre_mueble = quitarComillas(datosObtenidos[1]);
            String ti_pieza = quitarComillas(datosObtenidos[0]);
            int cant = Integer.parseInt(datosObtenidos[2]);

            ep = new Ensamble_Pieza(cant, nombre_mueble, ti_pieza);
            Manejador_Ensamble_Pieza mep= new Manejador_Ensamble_Pieza();
            mep.añadir(ep);
            System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");

        }
        //SI ES ENSAMBLAR MUEBLE
        if(nombreAVerificar.equals(NOMBRES[4])){
            Mueble_Ensamblado me;
            Manejador_Mueble_Ensamblado mme = new Manejador_Mueble_Ensamblado();
            java.util.Date fecha = mme.formatoFecha(quitarComillas(datosObtenidos[2]),FORMATO_CARGA);
            System.out.println("-------");
            String usuario= datosObtenidos[1];
            String mueble= quitarComillas(datosObtenidos[0]);
            me= new Mueble_Ensamblado(fecha,usuario,mueble);
            mme.verificacion(me);
            
            System.out.println(lineaPrincipal + mme.verificacion(me));
        }
        // SI ES CLIENTE
         if (nombreAVerificar.equals(NOMBRES[5])) {
            Cliente cliente;
            
            if(datosObtenidos.length==3){
                String nom= quitarComillas(datosObtenidos[0]);
                String nit= quitarComillas(datosObtenidos[1]);
                String direc= quitarComillas(datosObtenidos[2]);
                cliente= new Cliente(nit,nom,direc);
                
                Manejador_Cliente mc= new Manejador_Cliente();
                mc.añadir(cliente);
                System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
            }else{
                String nom= quitarComillas(datosObtenidos[0]);
                String nit= quitarComillas(datosObtenidos[1]);
                String direc= quitarComillas(datosObtenidos[2]);
                String mun= quitarComillas(datosObtenidos[3]);
                String dep= quitarComillas(datosObtenidos[4]);
                
                cliente = new Cliente(nit,nom,direc,mun,dep);
                Manejador_Cliente mc= new Manejador_Cliente();
                mc.añadir_extenso(cliente);
                System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
            }
         }
     }

    
}
