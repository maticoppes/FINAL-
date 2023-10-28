
package com.mycompany.tallerpoo;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Usuario
 */
public class ListaPacientes {
    public ArrayList <Paciente> pacientes;
    
    public ListaPacientes() {
        this.pacientes = new ArrayList<Paciente>();
    }
    
    public ListaPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public void agregar(Paciente paci){
        pacientes.add(paci);
    }
    
    public void eliminar(Paciente paci){
        pacientes.remove(paci);
    }
    
    public Paciente getPorDni(int dni){
        for (Paciente paci : this.pacientes){
           if (paci.getDocumento()==dni){
                return paci;
            }        
        }
        return null;
    }
    
    public void agregarAlArchivo(String archivoNombre, Paciente paciente){
        PrintWriter salida= null;
        try {
            File archivo= new File(archivoNombre);
            salida = new PrintWriter(new FileWriter(archivo, true ));            
                       
            salida.println(paciente.getDocumento()+","+paciente.getNombre()+","+paciente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+","
                    +paciente.getDomicilio()+","+paciente.getTelefoFijo()+","+paciente.getTelefonoCelular()+","
                    +paciente.getEstadoCivil()+","+paciente.getCorreoElectronico()+","+paciente.getPersonaContacto());
            
        } catch (IOException ex) {
            
        } finally {
            salida.close();
        } 
    }
    
    public ArrayList<Paciente> leer(String archivo){
        
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivo));
            String linea = reader.readLine();
            
            while (linea!=null && !linea.trim().isEmpty()){
                String[] split=linea.split(",");//splitea la linea
                String[] splitFecha=split[2].split("/");//splitea la fecha 
                
                Paciente paci=new Paciente();
                
                LocalDate fechanac = LocalDate.of(Integer.parseInt(splitFecha[2]),
                                                Integer.parseInt(splitFecha[1]),
                                            Integer.parseInt(splitFecha[0]));
                
                paci.setDocumento(Integer.parseInt(split[0]));
                paci.setNombre(split[1]);
                paci.setFechaNacimiento(fechanac);
                paci.setDomicilio(split[3]);
                paci.setTelefoFijo(Integer.parseInt(split[4]));
                paci.setTelefonoCelular(Integer.parseInt(split[5]));
                paci.setEstadoCivil(split[6]);
                paci.setCorreoElectronico(split[7]);
                paci.setPersonaContacto(split[8]);
                
                this.agregar(paci);
                
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public String toString() {
        return "ListaPacientes{" + "pacientes=" + pacientes + '}';
    }
}
