
package com.mycompany.tallerpoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * La clase ListaEspecialidades es una colección que almacena instancias de la clase Especialidad.
 * Permite agregar especialidades a la lista, así como leer información de especialidades desde un archivo.
 * 
 * @author Lucas
 */

public class ListaEspecialidades {
    /**
     * Una lista que almacena instancias de la clase Especialidad.
     */
    protected ArrayList <Especialidad> especialidades;

    /**
     * Constructor de  ListaEspecialidades que deja inicializar la lista con una lista
     * existente de especialidades.
     *
     * @param especialidades La lista de especialidades para inicializar.
     */
    public ListaEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    /**
     * Constructor de la clase ListaEspecialidades que crea una lista vacía de especialidades.
     */
    public ListaEspecialidades() {
        this.especialidades=new ArrayList <Especialidad>();
    }
    
    /**
     * Obtiene la lista de especialidades.
     *
     * @return La lista de especialidades almacenada en esta instancia.
     */
    
    public ArrayList<Especialidad> getResultados() {
        return especialidades;
    }
    
    /**
     * Establece la lista de especialidades con una nueva lista.
     *
     * @param especialidades La nueva lista de especialidades a establecer.
     */
    
    public void setResultados(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
    
    /**
     * Agrega una instancia de Especialidad a la lista de especialidades.
     *
     * @param espe La instancia de Especialidad que se agregará a la lista.
     */    
    
    public void agregar(Especialidad espe){
        especialidades.add(espe);
    }

    /**
     * Elimina una instancia de Especialidad de la lista de especialidades.
     *
     * @param espe La instancia de Especialidad que se eliminará de la lista.
     */    
    
    public void eliminar(Especialidad espe){
        especialidades.remove(espe);
    }
    
    /**
     * Lee información de especialidades desde un archivo especificado y agrega las especialidades a la lista.
     *
     * @param archivo El nombre del archivo del cual se leerá la información de las especialidades.
     * @param listamed Una lista de médicos para relacionar con las especialidades leídas.
     * @param listamedesp Una lista de asociaciones entre médicos y especialidades para actualizar.
     */
    
    public void leer(String archivo){
        leerInterno(archivo,null,null);
    }

    /**
     * Lee información de especialidades desde un archivo especificado y agrega las especialidades a la lista.
     *
     * @param archivo     El nombre del archivo del cual se leerá la información de las especialidades.
     * @param listamed    Una lista de médicos para relacionar con las especialidades leídas.
     * @param listamedesp Una lista de asociaciones entre médicos y especialidades para actualizar.
     */
    
    public void leer(String archivo, ListaMedicos listamed, ListaMedEsp listamedesp){
        leerInterno(archivo,listamed,listamedesp);
    }
    
    /**
     * Método interno utilizado para leer y procesar la información de especialidades desde un archivo.
     *
     * @param archivo     El nombre del archivo del cual se leerá la información de las especialidades.
     * @param listamed    Una lista de médicos para relacionar con las especialidades leídas.
     * @param listamedesp Una lista de asociaciones entre médicos y especialidades para actualizar.
     */
    
    private void leerInterno(String archivo, ListaMedicos listamed, ListaMedEsp listamedesp){
        
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivo));
            String linea = reader.readLine();
            
            while (linea!=null && !linea.isBlank()){
                String[] split=linea.split(",");//splitea la linea                
                String infoMedico= split[0].replace("[", "");
                infoMedico= infoMedico.replace("]", "");
                
                String [] splitInfoMed= infoMedico.split(";");
                

                
                Especialidad espe=new Especialidad();
                
                espe.setTitulo(split[1]);
                espe.setEspecialidad(split[2]);
                
                /*si se paso la lista de medicos por parametro, se busca por dni al medico
                y hace un agregarMedico.
                */
                if (listamed!=null){     
                    
                    for (String datos : splitInfoMed){
                        
                        String[] splitDatos=datos.split("-");
                        Medico medi=listamed.getPorDni(Integer.parseInt(splitDatos[0]));

                        /*si el medico existe, se añade esta especialidad la lista del medico, y al atributo medico
                        de la clase dependencia MedicoEspecialdad*/
                        if (medi!=null){
                            espe.agregarMedico(medi);
                            medi.agregarEspecialidad(espe);
                            String[] splitFecha=splitDatos[1].split("/");
                            //se inicializa la fecha y hora
                            LocalDate fecha= LocalDate.of(Integer.parseInt(splitFecha[2]),
                                                         Integer.parseInt(splitFecha[1]),
                                                     Integer.parseInt(splitFecha[0]));

                            MedicoEspecialidad medicoesp=new MedicoEspecialidad(fecha,splitDatos[2],medi,espe);
                            listamedesp.agregarEspe(medicoesp);
                        }
                    }
                }
                
                this.agregar(espe);
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

/**
 * Convierte la instancia de ListaEspecialidades en una representación en forma de cadena.
 *
 * @return Una cadena que representa la instancia de ListaEspecialidades, incluyendo
 *         información sobre las especialidades almacenadas en la lista.
 */    
    
    @Override
    public String toString() {
        return "ListaEspecialidades{" + "especialidades=" + especialidades + '}';
    }
}
