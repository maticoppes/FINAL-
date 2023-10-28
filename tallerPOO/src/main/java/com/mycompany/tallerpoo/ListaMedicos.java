
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
 * La clase `ListaMedicos` representa una lista de médicos en un sistema médico o de salud. Permite gestionar
 * médicos, agregarlos, eliminarlos, y realizar operaciones relacionadas con la lectura y escritura de datos
 * de médicos en archivos.
 * @author Lucas
 */

public class ListaMedicos {
    // ArrayList que almacena la lista de médicos

    public ArrayList <Medico> medicos;
    
    /**
     * Constructor de la clase `ListaMedicos` que inicializa la lista de médicos.
     */    
    public ListaMedicos() {
        this.medicos = new ArrayList<Medico>();
    }
    
    /**
     * Constructor de la clase `ListaMedicos` que permite inicializar la lista de médicos con una lista existente.
     *
     * @param medicos Lista de médicos preexistente.
     */
    
    public ListaMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }
    
    /**
     * Obtiene la lista de médicos almacenada en la clase.
     *
     * @return ArrayList que contiene la lista de médicos.
     */
    
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }
    
    /**
     * Establece la lista de médicos en la clase.
     *
     * @param medicos Nueva lista de médicos.
     */
    
    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }
    
    /**
     * Agrega un médico a la lista de médicos.
     *
     * @param medi El médico a agregar.
     */    
    
    public void agregar(Medico medi){
        medicos.add(medi);
    }
    /**
     * Elimina un médico de la lista de médicos.
     *
     * @param medi El médico a eliminar.
     */    
    public void eliminar(Medico medi){
        medicos.remove(medi);
    }

    /**
     * Agrega información de un médico al archivo especificado. La información incluye datos como el documento,
     * nombre, fecha de nacimiento, domicilio, teléfonos de contacto, estado civil, correo electrónico y matrícula.
     *
     * @param archivoNombre Nombre del archivo en el que se almacenará la información del médico.
     * @param med El médico cuyos datos se agregarán al archivo.
     */    
    
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

    /**
     * Obtiene un médico por su número de documento (DNI).
     *
     * @param dni El número de documento (DNI) del médico que se busca.
     * @return El objeto `Medico` correspondiente al DNI proporcionado, o `null` si no se encuentra ningún médico con
     *         ese DNI en la lista.
     */    
    
    public Medico getPorDni(int dni){
        for (Medico medi : this.medicos){
           if (medi.getDocumento()==dni){
                return medi;
            }        
        }
        return null;
    }

    /**
     * Lee información de médicos desde un archivo y la agrega a la lista de médicos.
     *
     * @param archivo El nombre del archivo que contiene la información de los médicos.
     */    
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
    /**
     * Sobrescribe el método `toString()` de la clase  para proporcionar una representación en forma de cadena
     * de la instancia de la clase `ListaMedicos`.
     *
     * @return Una cadena que representa la instancia de la clase `ListaMedicos`.
     */
    @Override
    public String toString() {
        return "ListaMedicos{" + "medicos=" + medicos + '}';
    }
    /**
     * Este método debería ser implementado para obtener un médico en una posición específica en la lista.
     *
     * @param i Índice de la posición del médico en la lista.
     * @return El objeto `Medico` en la posición `i` de la lista, si existe.
     * @throws UnsupportedOperationException si la implementación actual no admite esta operación.
     */
    Medico get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
