/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase RegistroMedico representa un registro de atención médica, 
 * que incluye información sobre la fecha, hora
 * , lugar de atención, diagnóstico y diagnóstico clínico. 
 * También permite realizar diversas operaciones 
 * relacionadas con el registro médico, como calcular pacientes 
 * que consultaron en un rango de fechas, calcular el número 
 * de pacientes atendidos por un médico en un rango de fechas y más.
 * 
 * @author Matias
 */
public class RegistroMedico {
    
    private LocalDate fecha;
    private LocalTime hora; 
    private String lugarAtendido;
    private String diagnostico;
    private String diagnosticoClinico;
    public ArrayList<RegistroMedico> registroMedico;
    public AdmisionDeEmergencia admisionDeEmergencia;
    public ArrayList<Medico> medico;
    public Paciente paciente;

    /**
     * Constructor de la clase RegistroMedico parametrizado . 
     * @param fecha
     * @param hora
     * @param lugarAtendido
     * @param diagnostico
     * @param diagnosticoClinico 
     */
    
    public RegistroMedico(LocalDate fecha, LocalTime hora, String lugarAtendido, String diagnostico, String diagnosticoClinico) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugarAtendido = lugarAtendido;
        this.diagnostico = diagnostico;
        this.diagnosticoClinico = diagnosticoClinico;
    }

    /**
     * Constructor que inicializa un objeto RegistroMedico con valores por defecto.
     * La fecha se establece en 1 de enero del año 1.
     * La hora se establece en 00:00:00.
     * Los campos de lugarAtendido, diagnostico y diagnosticoClinico se inicializan como cadenas vacías. 
     */
    
    public RegistroMedico() {
        this.fecha = LocalDate.of(1, 1, 1);
        this.hora = LocalTime.of(0, 0,0);
	this.lugarAtendido = "";
	this.diagnostico = "";
	this.diagnosticoClinico = "";
    }

    /**
     * Obtiene la fecha del registro médico.
     *
     * @return La fecha del registro médico en formato LocalDate.
     */        
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del registro médico.
     *
     * @param fecha La fecha del registro médico a establecer en formato LocalDate.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    /**
     * Obtiene la hora del registro médico.
     *
     * @return La hora del registro médico en formato LocalTime.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora del registro médico.
     *
     * @param hora La hora del registro médico a establecer en formato LocalTime.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el lugar de atención del registro médico.
     *
     * @return El lugar de atención del registro médico como una cadena de caracteres.
     */    
    
    public String getLugarAtendido() {
        return lugarAtendido;
    }

    /**
     * Establece el lugar de atención del registro médico.
     *
     * @param lugarAtendido El lugar de atención del registro médico a establecer como una cadena de caracteres.
     */    
    
    public void setLugarAtendido(String lugarAtendido) {
        this.lugarAtendido = lugarAtendido;
    }

    /**
     * Obtiene el diagnóstico del registro médico.
     *
     * @return El diagnóstico del registro médico como una cadena de caracteres.
     */    
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico del registro médico.
     *
     * @param diagnostico El diagnóstico del registro médico a establecer como una cadena de caracteres.
     */    
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    /**
     * Obtiene el diagnóstico clínico del registro médico.
     *
     * @return El diagnóstico clínico del registro médico como una cadena de caracteres.
     */
    public String getDiagnosticoClinico() {
        return diagnosticoClinico;
    }
    /**
     * Establece el diagnóstico clínico del registro médico.
     *
     * @param diagnosticoClinico El diagnóstico clínico del registro médico a establecer como una cadena de caracteres.
     */
    
    public void setDiagnosticoClinico(String diagnosticoClinico) {
        this.diagnosticoClinico = diagnosticoClinico;
    }

    
    /**
     * Calcula y devuelve una lista de DNIs de pacientes que más consultaron en un rango de fechas.
     *
     * @param fecha1 Fecha de inicio del rango.
     * @param fecha2 Fecha de fin del rango.
     * @return Una lista de DNIs de pacientes que más consultaron en el rango de fechas especificado.
     */
    
    public static ArrayList<String> calcularMasConsPorFecha(LocalDate fecha1, LocalDate fecha2) {
    
    ArrayList<String> personasConMasConsultas = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/Archivos/Triage.txt"))) {
        String linea = br.readLine();
        ArrayList<String> dnis = new ArrayList<>();
        ArrayList<LocalDate> fechas = new ArrayList<>();

        while (linea != null) {
            String[] array = linea.split(",");
            if(array.length>=4){
                
            String[] splitFecha = array[0].split("-");
            LocalDate fechaConsulta = LocalDate.of(Integer.parseInt(splitFecha[0]), Integer.parseInt(splitFecha[1]), Integer.parseInt(splitFecha[2]));
            
            dnis.add(array[3]);
            fechas.add(fechaConsulta);
            }
            linea = br.readLine();
        }

        // Crear un HashMap para realizar un seguimiento de las consultas por persona
        HashMap<String, Integer> consultasPorPersona = new HashMap<>();

        // Iterar sobre los DNIs y fechas
        for (int i = 0; i < dnis.size(); i++) {
            String dni = dnis.get(i);
            LocalDate fechaConsulta = fechas.get(i);
            
            // Verificar si la fecha de consulta está dentro del rango
            if (fechaConsulta.isAfter(fecha1) && fechaConsulta.isBefore(fecha2)) {
                consultasPorPersona.put(dni, consultasPorPersona.getOrDefault(dni, 0) + 1);
            }
        }

        int maxConsultas = 0;

        // Encontrar el número máximo de consultas en el rango
        for (String dni : consultasPorPersona.keySet()) {
            int consultas = consultasPorPersona.get(dni);
            if (consultas > maxConsultas) {
                maxConsultas = consultas;
                personasConMasConsultas.clear();
                personasConMasConsultas.add(dni);
            } else if (consultas == maxConsultas) {
                personasConMasConsultas.add(dni);
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    return personasConMasConsultas;
    }
        
    /**
     * Calcula el número de pacientes que un médico atendió en un rango de fechas.
     *
     * @param fecha1    Fecha de inicio del rango.
     * @param fecha2    Fecha de fin del rango.
     * @param dniMedico DNI del médico.
     * @return El número de pacientes atendidos por el médico en el rango de fechas especificado.
     */
    //calcula el numero pacientes de que un medico ,ingresado por dni, atendio
    public static int calcularNumPacDeMedPorFecha(LocalDate fecha1, LocalDate fecha2, String dniMedico) {
        String barra = File.separator;
        ArrayList<String> paciAtenMedi = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/Archivos/Triage.txt"))) {
            String linea = br.readLine();

            while (linea != null) {
                String[] array = linea.split(",");
                if (array.length >= 4) { // Asegúrate de que haya suficientes campos en la línea
                    String dniPaciente = array[3];
                    
                    String medicoAsignado = array[4];
                    
                    String[] splitFecha = array[0].split("-");
                    
                    LocalDate fechaAtencion = LocalDate.of(
                            Integer.parseInt(splitFecha[0]),
                            Integer.parseInt(splitFecha[1]),
                            Integer.parseInt(splitFecha[2])
                    );

                    if (medicoAsignado.equals(dniMedico) && fechaAtencion.isAfter(fecha1) && fechaAtencion.isBefore(fecha2)) {
                        paciAtenMedi.add(dniPaciente);
                    }
                    
                }
                linea = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int cont=paciAtenMedi.size();
        return cont;
    
    }

    /**
     * Calcula y devuelve el médico que atendió a la mayoría de pacientes en un rango de fechas.
     *
     * @param fecha1 Fecha de inicio del rango.
     * @param fecha2 Fecha de fin del rango.
     * @return El DNI del médico que atendió a la mayoría de pacientes en el rango de fechas especificado. 
     * @param fecha1
     * @param fecha2
     * @return 
     */
    public static String calcularMedMasPacPorFecha(LocalDate fecha1, LocalDate fecha2) {
        String barra = File.separator;
        ArrayList<String> citas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/Archivos/Triage.txt"))) {
            String linea = br.readLine();

            while (linea != null) {
                String[] array = linea.split(",");
                if (array.length >= 4) {
                    String dniPaciente = array[3];
                    String fechaAtencionStr = array[0];
                    String medicoAsignado = array[4];

                    String[] splitFecha = fechaAtencionStr.split("-");
                    LocalDate fechaAtencion = LocalDate.of(
                            Integer.parseInt(splitFecha[0]),
                            Integer.parseInt(splitFecha[1]),
                            Integer.parseInt(splitFecha[2])
                    );

                    if (fechaAtencion.isAfter(fecha1) && fechaAtencion.isBefore(fecha2) ) {
                        citas.add(medicoAsignado);
                    }
                }
                linea = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Calcular al médico que atendió a la mayoría de pacientes
        Map<String, Integer> contadorMedicos = new HashMap<>();
        for (String medicoAsignado : citas) {
            contadorMedicos.put(medicoAsignado, contadorMedicos.getOrDefault(medicoAsignado, 0) + 1);
        }

        int maxPacientesAtendidos = 0;
        String medicoConMasPacientes = null;

        for (Map.Entry<String, Integer> entry : contadorMedicos.entrySet()) {
            if (entry.getValue() > maxPacientesAtendidos) {
                maxPacientesAtendidos = entry.getValue();
                medicoConMasPacientes = entry.getKey();
            }
        }

        return medicoConMasPacientes;
    }    
        
    /**
     * Calcula el número de pacientes dentro de un rango de edades y fechas de consulta.
     *
     * @param fecha1  Fecha de inicio del rango.
     * @param fecha2  Fecha de fin del rango.
     * @param edad1   Edad mínima del rango.
     * @param edad2   Edad máxima del rango.
     * @return El número de pacientes que cumplen con los criterios de edad y fechas de consulta especificados.
     */
    public static int CalcularPacPorEdadesyFechas(LocalDate fecha1, LocalDate fecha2, String edad1, String edad2) {
    String barra = File.separator;
    int edad1Int = Integer.parseInt(edad1);
    int edad2Int = Integer.parseInt(edad2);
    int cont = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/Archivos/Triage.txt"))) {
        String linea = br.readLine();
        LocalDate fechaActual = LocalDate.now();
        while (linea != null) {
            String[] array = linea.split(",");
            if (array.length >= 4) {
                String[] splitFecha = array[0].split("-");
                LocalDate fechaConsulta = LocalDate.of(Integer.parseInt(splitFecha[0]), Integer.parseInt(splitFecha[1]), Integer.parseInt(splitFecha[2]));                
                
                Paciente paci=DatosTaller.getPacientes().getPorDni(Integer.parseInt(array[3]));
                
                String fecha=paci.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                
                String []vector = fecha.split("/");

                LocalDate fechaNac= LocalDate.of(Integer.parseInt(vector[2]),Integer.parseInt(vector[1]) , Integer.parseInt(vector[0]));
                
                
                if (fechaConsulta.isAfter(fecha1) && fechaConsulta.isBefore(fecha2)) {
                    if (fechaNac.isBefore(fechaActual)) {
                        int edad = fechaNac.until(fechaActual).getYears();
                        if (fechaNac.getMonthValue() == fechaActual.getMonthValue() && fechaNac.getDayOfMonth() > fechaActual.getDayOfMonth()) {
                            edad=-1;
                        }
                        if (edad >= edad1Int && edad <= edad2Int) {
                            cont++;
                        }
                    }
                }
            }
            linea = br.readLine();
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    return cont;
}

    /**
     * Devuelve una representación en forma de cadena de un objeto RegistroMedico.
     *
     * @return Una cadena que representa el objeto RegistroMedico.
     */

    @Override
    public String toString() {
        return "RegistroMedico{" + "fecha=" + fecha + ", hora=" + hora + ", lugarAtendido=" + lugarAtendido + ", diagnostico=" + diagnostico + ", diagnosticoClinico=" + diagnosticoClinico + '}';
    }
    
}