/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase `ListaTriage` almacena una lista de objetos `Triage` y proporciona
 * métodos para gestionar estos objetos, como agregar, eliminar, leer desde un archivo y 
 * escribir en un archivo. También permite asociar triajes con admisiones de emergencia.
 * 
 * @author Matias
 */
public class ListaTriage {
    ArrayList<Triage> triages;
    
    /**
     * Constructor parametrizado de la clase `ListaTriage`.
     *
     * @param triages La lista de triajes a almacenar.
     */

    public ListaTriage(ArrayList<Triage> triages) {
        this.triages = triages;
    }

    /**
     * Constructor por defecto de la clase `ListaTriage`. Inicializa una lista vacía de triajes.
     */    
    public ListaTriage() {
        this.triages= new ArrayList<Triage>();        
    }
    
    /**
     * Agrega un objeto `Triage` a la lista de triajes.
     *
     * @param tri El objeto `Triage` a agregar.
     */
    
    public void agregar (Triage tri) {
        triages.add(tri);
    }
    
    /**
     * Elimina un objeto `Triage` de la lista de triajes.
     *
     * @param tri El objeto `Triage` a eliminar.
     * @return `true` si se eliminó con éxito, `false` si no se encontró en la lista.
     */    
    public boolean eliminar (Triage tri) {
        if (triages.contains(tri)) {
            triages.remove(tri);
            return true;
        }
        return false;
    }
    
    /**
     * Escribe un objeto `Triage` en un archivo específico, junto con la información
     * de la admisión de emergencia asociada.
     *
     * @param archivoNombre La ruta del archivo donde se escribirá el triaje.
     * @param triage El objeto `Triage` a escribir en el archivo.
     */
    public void agregarArchivo(String archivoNombre, Triage triage){
        PrintWriter salida= null;
        try {
            File archivo= new File(archivoNombre);
            salida = new PrintWriter(new FileWriter(archivo, true ));            
            
            AdmisionDeEmergencia admi=triage.getAdmision();
            Medico med=triage.getMedico();
            salida.println(triage.getFecha()+","+triage.getColorSugerido()+","+triage.getColorFinal()+","+admi.getPaciente().getDocumento()+","+med.getDocumento());
                    
        } catch (IOException ex) {
            
        } finally {
            salida.close();
        } 
    }

    /**
     * Lee los triajes desde un archivo y los almacena en la lista.
     *
     * @param archivo La ruta del archivo a leer.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */    
    public void leer (String archivo) throws IOException {
        
        Triage tri; 
      
        try {         
            BufferedReader br= new BufferedReader (new FileReader(archivo));
            String linea = br.readLine();
                        
            
            while (null!=linea && !linea.trim().isEmpty()) {
                String [] campos = linea.split(",");
          // Validar que haya al menos dos campos en la línea antes de procesarla
            if (campos.length >= 2) {
                String[] splitFecha = campos[0].split("-");
                LocalDate fec = LocalDate.of(Integer.parseInt(splitFecha[0]), Integer.parseInt(splitFecha[1]), Integer.parseInt(splitFecha[2]));
                tri = new Triage();
                tri.setFecha(fec);
                tri.setColorSugerido(campos[1].trim()); //  trim() para eliminar espacios en blanco alrededor del color
                
                
                this.agregar(tri);
                
                linea = br.readLine();
                } else {
                System.err.println("Línea incorrecta: " + linea);
                }
                linea = br.readLine();
                }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                ex.printStackTrace();
                }
                System.out.println(triages.size());
                }
    
    /**
     * Escribe información de admisión de emergencia en un archivo.
     *
     * @param archivoNombre La ruta del archivo donde se escribirá la información de admisión.
     * @param admi La admisión de emergencia a escribir en el archivo.
     */    
    
    public void agregarAlArchivo(String archivoNombre, AdmisionDeEmergencia admi){
        PrintWriter salida= null;
        try {
            File archivo= new File(archivoNombre);
            
            salida = new PrintWriter(new FileWriter(archivo, true ));
            
            salida.println(admi.getPaciente().getDocumento()+","+admi.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+","+admi.getHora()+","+admi.getMotivoDeConsulta());
            
        } catch (IOException ex) {
            Logger.getLogger(ListaMedicos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            salida.close();
        }
    }
    
    public void eliminarDelArchivoPorDni(String archivo, int dniEliminar) throws IOException{
        String userDir=System.getProperty("user.dir");
        String temp=(archivo+"_temp");
        File inputFile = new File(archivo);
        File tempFile = new File(temp);
        
        System.out.println(tempFile);
        System.out.println(inputFile);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            System.out.println("1");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            System.out.println("2");
            String linea;
            
            while((linea = reader.readLine()) != null) {
                String []split= linea.split(",");
                if (Integer.parseInt(split[3])!= dniEliminar){
                    writer.write(linea + System.getProperty("line.separator"));
                }
            }
            writer.close(); 
            reader.close(); 
            
            Path tempPath = Paths.get(temp);
            Path originalPath = Paths.get(archivo);
            Files.move(tempPath, originalPath, StandardCopyOption.REPLACE_EXISTING);

        } catch (FileNotFoundException ex) {
            System.out.println("f");
        }
    }
    /**
     * Devuelve una representación en forma de cadena de la lista de triajes.
     *
     * @return La representación en cadena de la lista de triajes.
     */    
    
    
    @Override
    public String toString() {
        return "ListaTriage{" + "triages=" + triages + '}';
    }
                
                
                
                
                
              
    
    
    
}
