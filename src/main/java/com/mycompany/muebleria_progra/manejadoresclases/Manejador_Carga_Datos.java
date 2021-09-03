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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author daniel
 */
public class Manejador_Carga_Datos extends Thread{
    private List<String> errores= new ArrayList();
    private InputStream archivoN;
    private String nombreArchivo;
    private static final String USUARIO="USUARIO";
    private static final String PIEZA="PIEZA";
    private static final String MUEBLE="MUEBLE";
    private static final String ENSAMBLE_PIEZAS="ENSAMBLE_PIEZAS";
    private static final String ENSAMBLAR_MUEBLE="ENSAMBLAR_MUEBLE";
    private static final String CLIENTE="CLIENTE";
    private static final String[] NOMBRES ={USUARIO, PIEZA, MUEBLE, ENSAMBLE_PIEZAS, ENSAMBLAR_MUEBLE, CLIENTE};
    private static String lineaPrincipal=null;

    public Manejador_Carga_Datos(InputStream archivo, String nombreArchivo) {
        this.archivoN = archivo;
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
    public List<String> leerNuevosArchivos()throws IOException{
        try{
            System.out.println("aqui jejeje");
            BufferedReader archivo= new BufferedReader(new InputStreamReader(this.archivoN)); // LE ENVIAMOS AL LECTOR EL ARCHIVO
            System.out.println("aqui");
            String LArchivo = archivo.readLine(); // LEERA LINEA POR LINEA EL ARCHIVO
            System.out.println("m");
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
                    errores.add("NO CUMPLE EL FORMATO : "+lineaPrincipal);
                    e.printStackTrace();
                    LArchivo = archivo.readLine();
                }
            }
             System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
             errores.add("**SE HAN MOSTRADO TODOS LOS ERRORES**".toUpperCase());
        }catch(Exception e){ 
             System.out.println("NO CUMPLE CON EL FORMATO VALIDO : "+lineaPrincipal);  
             errores.add("NO CUMPLE CON EL FORMATO VALIDO : "+lineaPrincipal);
             System.out.println(e);
        }
        return errores;
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
    public void verificarMetodo(String nombreAVerificar, String[] datosObtenidos){
        // SI ES USUARIO
       
        try {
            if (nombreAVerificar.equals(NOMBRES[0])) {
                Usuario us;
                String nomU = quitarComillas(datosObtenidos[0]);
                String pass = quitarComillas(datosObtenidos[1]);
                int tip = Integer.parseInt(datosObtenidos[2]);

                us = new Usuario(nomU, pass, tip);
                Manejador_Usuario mu = new Manejador_Usuario();
                    try{
                        mu.añadir(us);
                    } catch(SQLException e){
                    errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                    }

                System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
            }
            //SI ES PIEZA
            if (nombreAVerificar.equals(NOMBRES[1])) {
                Pieza pieza;
                String tipo = quitarComillas(datosObtenidos[0]);
                BigDecimal costo = BigDecimal.valueOf(Double.parseDouble(datosObtenidos[1]));
                pieza = new Pieza(tipo, costo);
                Manejador_Pieza mp = new Manejador_Pieza();
                try{
                    mp.añadir(pieza);
                    System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
                }catch(SQLException e){
                    errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                }
            }
            // SI ES MUEBLE
            if (nombreAVerificar.equals(NOMBRES[2])) {
                Mueble mueble;
                String nom = quitarComillas(datosObtenidos[0]);
                BigDecimal costo = BigDecimal.valueOf(Double.parseDouble(datosObtenidos[1]));
                mueble = new Mueble(nom, costo);
                Manejador_Mueble mm = new Manejador_Mueble();
                try{
                    mm.añadir(mueble);
                }catch(SQLException e){
                    errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                }
                
                System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
            }
            //SI ES ENSAMBLE DE PIEZAS
            if (nombreAVerificar.equals(NOMBRES[3])) {
                Ensamble_Pieza ep;
                String nombre_mueble = quitarComillas(datosObtenidos[1]);
                String ti_pieza = quitarComillas(datosObtenidos[0]);
                int cant = Integer.parseInt(datosObtenidos[2]);

                ep = new Ensamble_Pieza(cant, nombre_mueble, ti_pieza);
                Manejador_Ensamble_Pieza mep = new Manejador_Ensamble_Pieza();
                try{
                    mep.añadir(ep);
                }catch(SQLException e){
                    errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                }
                
                System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");

            }
            //SI ES ENSAMBLAR MUEBLE
            if (nombreAVerificar.equals(NOMBRES[4])) {
                Mueble_Ensamblado me;
                Manejador_Mueble_Ensamblado mme = new Manejador_Mueble_Ensamblado();
                java.util.Date fecha = mme.formatoFecha(quitarComillas(datosObtenidos[2]), FORMATO_CARGA);
                System.out.println("-------");
                String usuario = datosObtenidos[1];
                String mueble = quitarComillas(datosObtenidos[0]);
                me = new Mueble_Ensamblado(fecha, usuario, mueble);
                try{
                     mme.verificacion(me);
                }catch(SQLException e){
                   errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                }
               

                System.out.println(lineaPrincipal + mme.verificacion(me));
            }
            // SI ES CLIENTE
            if (nombreAVerificar.equals(NOMBRES[5])) {
                Cliente cliente;

                if (datosObtenidos.length == 3) {
                    String nom = quitarComillas(datosObtenidos[0]);
                    String nit = quitarComillas(datosObtenidos[1]);
                    String direc = quitarComillas(datosObtenidos[2]);
                    cliente = new Cliente(nit, nom, direc);

                    Manejador_Cliente mc = new Manejador_Cliente();
                    try{
                         mc.añadir(cliente);
                    }catch(SQLException e){
                     errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                    }
                   
                    System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
                } else {
                    String nom = quitarComillas(datosObtenidos[0]);
                    String nit = quitarComillas(datosObtenidos[1]);
                    String direc = quitarComillas(datosObtenidos[2]);
                    String mun = quitarComillas(datosObtenidos[3]);
                    String dep = quitarComillas(datosObtenidos[4]);

                    cliente = new Cliente(nit, nom, direc, mun, dep);
                    Manejador_Cliente mc = new Manejador_Cliente();
                    try{
                        mc.añadir_extenso(cliente);
                    }catch(SQLException e){
                     errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                    }catch(ArrayIndexOutOfBoundsException p){
                        errores.add("NO SE PUDO GUARDAR: "+lineaPrincipal);
                    }
                    
                    System.out.println(lineaPrincipal + " ***GUARDADA CON EXITO ***");
                }
            }
        } catch (Exception e) {
            System.out.println("carga error "+ e);
        }

     }

    
}
