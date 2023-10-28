
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
 *
 * @author Lucas
 */
public class ListaMedicos {
    public ArrayList <Medico> medicos;
    
    public ListaMedicos() {
        this.medicos = new ArrayList<Medico>();
    }
    
    public ListaMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }
    
    public void agregar(Medico medi){
        medicos.add(medi);
    }
    
    public void eliminar(Medico medi){
        medicos.remove(medi);
    }
    
    public void agregarAlArchivo(String archivoNombre, Medico med){
        PrintWriter salida= null;
        try {
            File archivo= new File(archivoNombre);
            salida = new PrintWriter(new FileWriter(archivo, true ));            
                       
            salida.println(med.getDocumento()+","+med.getNombre()+","+med.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+","
                    +med.getDomicilio()+","+med.getTelefoFijo()+","+med.getTelefonoCelular()+","
                    +med.getEstadoCivil()+","+med.getCorreoElectronico()+","+med.getMatricula());
            
        } catch (IOException ex) {
            
        } finally {
            salida.close();
        } 
    }
    
    public Medico getPorDni(int dni){
        for (Medico medi : this.medicos){
           if (medi.getDocumento()==dni){
                return medi;
            }        
        }
        return null;
    }
    
    public void leer(String archivo){
        
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivo));
            String linea = reader.readLine();
            
            while (linea!=null && !linea.isBlank()){
                String[] split=linea.split(",");//splitea la linea
                String[] splitFecha=split[2].split("/");//splitea la fecha 
                
                Medico medi=new Medico();
                
                LocalDate fechanac= LocalDate.of(Integer.parseInt(splitFecha[2]),
                                                Integer.parseInt(splitFecha[1]),
                                                Integer.parseInt(splitFecha[0]));
                
                medi.setDocumento(Integer.parseInt(split[0]));
                medi.setNombre(split[1]);
                medi.setFechaNacimiento(fechanac);
                medi.setDomicilio(split[3]);
                medi.setTelefoFijo(Integer.parseInt(split[4]));
                medi.setTelefonoCelular(Integer.parseInt(split[5]));
                medi.setEstadoCivil(split[6]);
                medi.setCorreoElectronico(split[7]);
                medi.setMatricula(Integer.parseInt(split[8]));
                
                this.agregar(medi);
                
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(medicos.size());
    }

    @Override
    public String toString() {
        return "ListaMedicos{" + "medicos=" + medicos + '}';
    }

    Medico get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
