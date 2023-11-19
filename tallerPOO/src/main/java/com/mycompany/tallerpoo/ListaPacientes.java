
package com.mycompany.tallerpoo;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.time.format.DateTimeFormatter;

/**
 * La clase `ListaPacientes` representa una lista de pacientes y proporciona métodos para gestionar pacientes y realizar operaciones de lectura y escritura de datos de pacientes.
 * Cada paciente en la lista se representa como una instancia de la clase `Paciente`.
 * @author Lucas
 */

public class ListaPacientes {
    /**
     * 
     * Esta lista contiene los pacientes que están siendo gestionados por la instancia de `ListaPacientes`.
     */
    public ArrayList <Paciente> pacientes;

    /**
     * Constructor predeterminado que inicializa una instancia de `ListaPacientes` con una lista vacía de pacientes.
     */    
    public ListaPacientes() {
        this.pacientes = new ArrayList<Paciente>();
    }

    /**
     * Constructor que permite inicializar una instancia de `ListaPacientes` con una lista de pacientes existente.
     *
     * @param pacientes La lista de pacientes a ser asignada.
     */    
    public ListaPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    /**
     * Obtiene la lista de pacientes.
     *
     * @return La lista de pacientes.
     */    
    
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    /**
     * Establece la lista de pacientes con una nueva lista de pacientes.
     *
     * @param pacientes La nueva lista de pacientes a ser asignada.
     */
    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    /**
     * Agrega un paciente a la lista de pacientes.
     *
     * @param paci El paciente a ser agregado.
     */    
    public void agregar(Paciente paci){
        pacientes.add(paci);
    }
    
    /**
     * Elimina un paciente de la lista de pacientes.
     *
     * @param paci El paciente a ser eliminado.
     */    
    
    public void eliminar(Paciente paci){
        pacientes.remove(paci);
    }

    /**
     * Busca un paciente en la lista de pacientes por número de documento.
     *
     * @param dni El número de documento del paciente a buscar.
     * @return El paciente encontrado o null si no se encuentra ningún paciente con ese número de documento.
     */    
    public Paciente getPorDni(int dni){
        
        for (Paciente paci : this.pacientes){
           
           if (paci.getDocumento()==dni){
                return paci;
            }        
        }
        return null;
    }

    /**
     * Agrega los datos de un paciente al archivo especificado. Los datos del paciente se escriben en formato CSV.
     *
     * @param archivoNombre El nombre del archivo en el que se agregarán los datos del paciente.
     * @param paciente El paciente cuyos datos se agregarán al archivo.
     */    
    
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

    /**
     * Lee los datos de pacientes desde el archivo especificado y los agrega a la lista de pacientes.
     *
     * @param archivo El nombre del archivo del que se leerán los datos de los pacientes.
     * @return La lista de pacientes que se ha llenado con los datos del archivo.
     */    
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
                paci.setMotivo(split[9]);
                
                this.agregar(paci);
                
                linea = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pacientes;
    }
    
    public ArrayList<Paciente> leerEnEspera(String archivo){
        
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivo));
            String linea = reader.readLine();
            
            while (linea!=null && !linea.trim().isEmpty()){
                String[] split=linea.split(",");//splitea la linea
                
                this.agregar(DatosTaller.getPacientes().getPorDni(Integer.parseInt(split[0])));
                
                linea = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pacientes;
    }

    /**
     * Sobrescribe el método `toString()` de la clase `Object` para proporcionar una representación en forma de cadena
     * de la instancia de la clase `ListaPacientes`.
     *
     * @return Una cadena que representa la instancia de la clase `ListaPacientes`.
     */
    @Override
    public String toString() {
        return "ListaPacientes{" + "pacientes=" + pacientes + '}';
    }
}
