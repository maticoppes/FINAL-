/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class ListaTriage {
    ArrayList<Triage> triages;


    public ListaTriage(ArrayList<Triage> triages) {
        this.triages = triages;
    }

    public ListaTriage() {
        this.triages= new ArrayList<Triage>();        
    }
    
    
    
    public void agregar (Triage tri) {
        triages.add(tri);
    }
    
    public boolean eliminar (Triage tri) {
        if (triages.contains(tri)) {
            triages.remove(tri);
            return true;
        }
        return false;
    }
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

    @Override
    public String toString() {
        return "ListaTriage{" + "triages=" + triages + '}';
    }
                
                
                
                
                
              
    
    
    
}
