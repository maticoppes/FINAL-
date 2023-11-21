package com.mycompany.tallerpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa una lista de admisiones de pacientes en un entorno de atención
 * médica de emergencia. Tiene métodos para gestionar las admisiones, agregar y
 * eliminar admisiones, así como leer y escribir admisiones en un archivo. Cada
 * admisión se asocia a un paciente, una fecha, una hora y un motivo de
 * consulta. Si se da una lista de pacientes, se establece la relación entre
 * pacientes y admisiones.
 *
 * @author Usuario
 */
public class ListaAdmisiones {

    protected ArrayList<AdmisionDeEmergencia> admisiones;

    /**
     * Constructor parametrizado.
     *
     * @param admisiones
     */
    public ListaAdmisiones(ArrayList<AdmisionDeEmergencia> admisiones) {
        this.admisiones = admisiones;
    }

    /**
     * Constructor de la clase `ListaAdmisiones`. Inicializa una lista vacía de
     * admisiones.
     */
    public ListaAdmisiones() {
        this.admisiones = new ArrayList<AdmisionDeEmergencia>();
    }

    /**
     * Obtiene la lista de admisiones.
     *
     * @return La lista de admisiones almacenada en la instancia.
     */
    public ArrayList<AdmisionDeEmergencia> getAdmisiones() {
        return admisiones;
    }

    /**
     * Establece la lista de admisiones.
     *
     * @param admisiones La lista de admisiones que se desea establecer.
     */
    public void setAdmisiones(ArrayList<AdmisionDeEmergencia> admisiones) {
        this.admisiones = admisiones;
    }

    /**
     * Agrega una admisión a la lista de admisiones.
     *
     * @param adm La admisión que se desea agregar a la lista.
     */
    public void agregar(AdmisionDeEmergencia adm) {
        admisiones.add(adm);
    }

    /**
     * Elimina una admisión de la lista de admisiones.
     *
     * @param adm La admisión que se desea eliminar de la lista.
     */
    public void eliminar(AdmisionDeEmergencia adm) {
        admisiones.remove(adm);
    }

    /**
     * Lee admisiones desde el archivo y agrega las admisiones a la lista.
     *
     * @param archivo El nombre del archivo desde el cual se leen las
     * admisiones.
     */
    public void leer(String archivo) {
        leerInterno(archivo, null);
    }

    /**
     * Lee admisiones desde un archivo y agrega las admisiones a la lista.
     * También se proporciona una lista de pacientes para establecer la relación
     * entre pacientes y admisiones.
     *
     * @param archivo El nombre del archivo desde el cual se leen las
     * admisiones.
     * @param listapaci La lista de pacientes para establecer la relación entre
     * pacientes y admisiones.
     */
    public void leer(String archivo, ListaPacientes listapaci) {
        leerInterno(archivo, listapaci);
    }

    /**
     * Agrega una admisión al archivo especificado.
     *
     * @param archivoNombre El nombre del archivo en el que se agregarán las
     * admisiones.
     * @param admi La admisión que se desea agregar al archivo.
     */
    public void agregarAlArchivo(String archivoNombre, AdmisionDeEmergencia admi) {
        PrintWriter salida = null;
        try {
            File archivo = new File(archivoNombre);

            salida = new PrintWriter(new FileWriter(archivo, true));

            salida.println(admi.getPaciente().getDocumento() + "," + admi.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "," + admi.getHora() + "," + admi.getMotivoDeConsulta());

        } catch (IOException ex) {
            Logger.getLogger(ListaMedicos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            salida.close();
        }
    }

    /**
     * Lee admisiones desde un archivo y agrega las admisiones a la lista
     * interna de la clase. Si se proporciona una lista de pacientes, establece
     * la relación entre pacientes y admisiones.
     *
     * @param archivo El nombre del archivo desde el cual se leen las
     * admisiones.
     * @param listapaci La lista de pacientes utilizada para establecer
     * relaciones con las admisiones.
     */
    private void leerInterno(String archivo, ListaPacientes listapaci) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea = reader.readLine();

            while (linea != null && !linea.trim().isEmpty()) {
                String[] split = linea.split(",");//splitea la linea
                String[] splitFecha = split[1].split("-");//splitea la fecha 
                String[] splitHora = split[2].split(":");//splitea la hora

                AdmisionDeEmergencia adm = new AdmisionDeEmergencia();

                //se inicializar la fecha y hora
                LocalDate fecha = LocalDate.of(Integer.parseInt(splitFecha[0]),
                        Integer.parseInt(splitFecha[1]),
                        Integer.parseInt(splitFecha[2]));

                LocalTime hora = LocalTime.of(Integer.parseInt(splitHora[0]),
                        Integer.parseInt(splitHora[1]),
                        Integer.parseInt(splitHora[2]));

                adm.setFecha(fecha);
                adm.setHora(hora);
                adm.setMotivoDeConsulta(split[3]);

                Box box = DatosTaller.getBoxes().getPorNumero(Integer.parseInt(split[4]));
                adm.setBox(box);

                splitFecha = split[5].split("/");//splitea la fecha de asignacionBox
                splitHora = split[6].split(":");//splitea la hora de asignacionBox

                fecha = LocalDate.of(Integer.parseInt(splitFecha[2]),
                        Integer.parseInt(splitFecha[1]),
                        Integer.parseInt(splitFecha[0]));

                hora = LocalTime.of(Integer.parseInt(splitHora[0]),
                        Integer.parseInt(splitHora[1]),
                        Integer.parseInt(splitHora[2]));

                /*si se paso la lista de pacientes por parametro, se busca por dni al paciente
                y hace un setPaciente.
                 */
                if (listapaci != null) {
                    Paciente paci = listapaci.getPorDni(Integer.parseInt(split[0]));
                    adm.setPaciente(paci);

                    //si el paciente existe, se añade esta admision a la lista del paciente.
                    if (paci != null) {
                        paci.agregarAdmision(adm);
                    }
                }

                AsignacionBox asig = new AsignacionBox(fecha, hora, box, adm);
                DatosTaller.getAsignaciones().agregar(asig);
                this.agregar(adm);
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public AdmisionDeEmergencia buscarAdmision(int dni) {
        AdmisionDeEmergencia admiEncontrada = new AdmisionDeEmergencia();
        for (AdmisionDeEmergencia admi : this.admisiones) {
            if (admi.getPaciente().getDocumento() == dni) {
                admiEncontrada = admi;
            }
        }
        return admiEncontrada;
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
                if (Integer.parseInt(split[0])!= dniEliminar){
                    writer.write(linea + System.getProperty("line.separator"));
                }
            }
            writer.close(); 
            reader.close(); 
            
            Path tempPath = Paths.get(temp);
            Path originalPath = Paths.get(archivo);
            Files.move(tempPath, originalPath, StandardCopyOption.REPLACE_EXISTING);

        } catch (FileNotFoundException ex) {
            System.out.println("error");
        }
    }

}
