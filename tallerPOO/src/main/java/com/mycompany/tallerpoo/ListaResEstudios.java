
package com.mycompany.tallerpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que almacena una lista de resultados de estudio, e implementa sus propios metodos.
 * @author Lucas
 */
public class ListaResEstudios {
    protected ArrayList <ResultadoEstudios> resultados;

    /**
     * Constructor parametrizado de a clase.
     * @param resultados 
     */
    public ListaResEstudios(ArrayList<ResultadoEstudios> resultados) {
        this.resultados = resultados;
    }
    /**
     * Constructor por defecto de a clase.
     */
    public ListaResEstudios() {
        this.resultados=new ArrayList <ResultadoEstudios>();
    }

    public ArrayList<ResultadoEstudios> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<ResultadoEstudios> resultados) {
        this.resultados = resultados;
    }
    
    /**
     * Agrega un objeto tipo {@code ResultadoEstudio} a la lista.
     * @param resu Resultado a agregar
     * @see #getResultados()
     * @see ResultadoEstudios
     * @see #eliminar(com.mycompany.tallerpoo.ResultadoEstudios) 
     */
    public void agregar(ResultadoEstudios resu){
        resultados.add(resu);
    }
    
    /**
     * Elimina de la lista el primer resultado que coincida con el pasado por parametro.
     * @param resu Resultado a agregar
     * @see #getResultados()
     * @see ResultadoEstudios
     * @see #agregar(com.mycompany.tallerpoo.ResultadoEstudios) 
     */
    public void eliminar(ResultadoEstudios resu){
        resultados.remove(resu);
    }
    
    /**
     * Escribe un resultado de estudio a un archivo en especifico.
     * @param archivoNombre Ruta del archivo
     * @param res Objeto tipo {@code ResultadoEstudio} a escribir en el archivo.
     * @see ResultadoEstudios
     * @see #leer(java.lang.String) 
     */
    public void agregarAlArchivo(String archivoNombre, ResultadoEstudios res){
        PrintWriter salida= null;
        try {
            File archivo= new File(archivoNombre);
            salida = new PrintWriter(new FileWriter(archivo, true ));
            
            salida.println(res.getPaciente().getDocumento()+","+res.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                           +","+res.getHora()+","+res.getTipoDeEstudio()+","+res.getInformeDeEstudio());
            
        } catch (IOException ex) {

        } finally {
            salida.close();
        } 
    }
     /**
     * Metodo que busca los resultados de estudio que se realizaron
     * en una fecha determinada.
     * @param fecha
     * @return ArrayList con una lista de estudios realizados en la fecha indicada.
     */
    public ArrayList<ResultadoEstudios> getListaPorFecha(LocalDate fecha){
        ArrayList<ResultadoEstudios> resultados=new ArrayList();
        for (ResultadoEstudios resu : this.resultados){
            if (resu.getFecha().isEqual(fecha)){
                resultados.add(resu);
            }
        }
        return resultados;
    }
    /**
     * Metodo que lee un archivo que contenga datos de resultados de estudios
     * representados correctamente y los almacena en esta lista.En este metodo
     * no se pasa la lista de pacientes, por lo que no se los relaciona.
     * @param archivo Ruta del archivo a leer
     * @see #agregarAlArchivo(java.lang.String, com.mycompany.tallerpoo.ResultadoEstudios) 
     */
    public void leer(String archivo){
        leerInterno(archivo,null);
    }
    /**
     * Metodo que lee un archivo que contenga datos de resultados de estudios
     * representados correctamente y los almacena en esta lista.En este metodo se 
     * pasa la lista de pacintes por parametro, y se vincula el estudio con su
     * respectivo {@code Paciente} de la lista
     * @param archivo Ruta del archivo a leer
     * @param listapaci lista de pacientes en la que se busca y se vincula su resultado de estudio
     * @see #agregarAlArchivo(java.lang.String, com.mycompany.tallerpoo.ResultadoEstudios) 
     */
    public void leer(String archivo, ListaPacientes listapaci){
        leerInterno(archivo,listapaci);
    }
    
    /**
     * Metodo interno que realiza la lectura y almacena en esta lista los resultado de estudios
     * y dependiendo de si se pasa una lista de pacientes nula o no, se vinculan los
     * resultados de estudio con su respectivo paciente.
     * @param archivo Ruta del archivo a leer
     * @param listapaci lista de pacientes a vincular
     * @see #agregarAlArchivo(java.lang.String, com.mycompany.tallerpoo.ResultadoEstudios) 
     */
    private void leerInterno(String archivo,ListaPacientes listapaci){
        
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivo));
            String linea = reader.readLine();
            
            while (linea!=null && !linea.isBlank()){
                String[] split=linea.split(",");//splitea la linea
                String[] splitFecha=split[1].split("/");//splitea la fecha 
                String[] splitHora=split[2].split(":");//splitea la hora
                
                ResultadoEstudios resu=new ResultadoEstudios();
                
                //se inicializar la fecha y hora
                LocalDate fecha= LocalDate.of(Integer.parseInt(splitFecha[2]),
                                                Integer.parseInt(splitFecha[1]),
                                                Integer.parseInt(splitFecha[0]));
                
                LocalTime hora= LocalTime.of(Integer.parseInt(splitHora[0]),
                                                Integer.parseInt(splitHora[1]),
                                                Integer.parseInt(splitHora[2]));
                
                resu.setFecha(fecha);
                resu.setHora(hora);
                
                resu.setTipoDeEstudio(split[3]);
                resu.setInformeDeEstudio(split[4]);
               
                /*si se paso la lista de pacientes por parametro, se busca por dni al paciente
                y hace un setPaciente.
                */
                if (listapaci!=null){            
                    Paciente paci=listapaci.getPorDni(Integer.parseInt(split[0]));
                    resu.setPaciente(paci);
                    
                    //si el paciente existe, se añade este resultado de estudio a la lista del paciente.
                    if (paci!=null){
                        paci.agregarEstudio(resu);
                    }
                }
                this.agregar(resu);
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
