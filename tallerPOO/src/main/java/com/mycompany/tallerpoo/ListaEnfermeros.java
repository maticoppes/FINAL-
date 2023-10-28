
package com.mycompany.tallerpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * La clase ListaEnfermeros es una colección que almacena instancias de la clase Enfermero.
 * Permite agregar enfermeros a la lista, así como leer y escribir datos de enfermeros desde/hacia un archivo.
 * @author Lucas
 */

public class ListaEnfermeros {
    /**
     * Una lista que almacena instancias de la clase Enfermero.
     */
    private ArrayList<Enfermero> enfermeros;
    
    /**
     * Una lista que almacena instancias de la clase Enfermero.
     */
    
    public ListaEnfermeros(ArrayList<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }

    /**
     * Constructor de la clase ListaEnfermeros que crea una lista vacía de enfermeros.
     */    
    public ListaEnfermeros() {
        this.enfermeros=new ArrayList<Enfermero>();
    }
    /**
     * Obtiene la lista de enfermeros.
     *
     * @return La lista de enfermeros almacenada en esta instancia.
     */    
    public ArrayList<Enfermero> getEnfermeros() {
        return enfermeros;
    }
/**
     * Establece la lista de enfermeros con una nueva lista.
     *
     * @param enfermeros La nueva lista de enfermeros a establecer.
     */

    public void setEnfermeros(ArrayList<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }
    
    /**
     * Agrega una instancia de Enfermero a la lista de enfermeros.
     *
     * @param enfermero La instancia de Enfermero que se agregará a la lista.
     */    
    public void agregar(Enfermero enfermero){
        this.enfermeros.add(enfermero);
    }
    /**
     * Agrega una instancia de Enfermero a la lista de enfermeros.
     *
     * @param enfermero La instancia de Enfermero que se agregará a la lista.
     */    
    public void agregarArchivo(String archivoNombre, Enfermero enfermero){
        PrintWriter salida= null;
        try {
            File archivo= new File(archivoNombre);
            salida = new PrintWriter(new FileWriter(archivo, true ));            
                       
            salida.println(enfermero.getDocumento()+","+enfermero.getNombre()+","+enfermero.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+","
                    +enfermero.getDomicilio()+","+enfermero.getTelefoFijo()+","+enfermero.getTelefonoCelular()+","
                    +enfermero.getEstadoCivil()+","+enfermero.getCorreoElectronico());
            
        } catch (IOException ex) {
            
        } finally {
            salida.close();
        } 
    }
    
    /**
     * Lee información de enfermeros desde un archivo especificado y agrega los enfermeros a la lista.
     *
     * @param archivoNombre El nombre del archivo del cual se leerá la información de los enfermeros.
     * @return Una lista de enfermeros creada a partir de los datos leídos.
     */    
    public ArrayList<Enfermero> leer(String archivoNombre){
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivoNombre));
            String linea = reader.readLine();
            
            while (linea!=null && !linea.trim().isEmpty()){
                String[] split=linea.split(",");//splitea la linea
                String[] splitFecha=split[2].split("/");//splitea la fecha 
                
                Enfermero enfermero=new Enfermero();
                
                LocalDate fechanac= LocalDate.of(Integer.parseInt(splitFecha[2]),
                                                Integer.parseInt(splitFecha[1]),
                                                Integer.parseInt(splitFecha[0]));
                
                enfermero.setDocumento(Integer.parseInt(split[0]));
                enfermero.setNombre(split[1]);
                enfermero.setFechaNacimiento(fechanac);
                enfermero.setDomicilio(split[3]);
                enfermero.setTelefoFijo(Integer.parseInt(split[4]));
                enfermero.setTelefonoCelular(Integer.parseInt(split[5]));
                enfermero.setEstadoCivil(split[6]);
                enfermero.setCorreoElectronico(split[7]);

                
                this.agregar(enfermero);
                
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return enfermeros;
    }
}
