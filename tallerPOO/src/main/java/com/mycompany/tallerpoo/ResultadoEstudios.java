
package com.mycompany.tallerpoo;
import java.time.*;
import java.util.*;
import java.io.*;

/**
 * Clase en donde se almacenan los datos de los resultados de estudios.
 * @author Lucas
 */
public class ResultadoEstudios {
    private LocalDate fecha;
    private LocalTime hora;
    private String tipoDeEstudio;
    private String informeDeEstudio;
    /**
     * Paciente al cual le pertenece el resultado de estudio.
     * @see #setPaciente(com.mycompany.tallerpoo.Paciente) 
     * @see #getPaciente() 
     *
     */
    private Paciente paciente;
    
    /**
     * Constructor por defecto de la clase
     */
    public ResultadoEstudios(){
        this.fecha=LocalDate.of(1, 1, 1);
        this.hora=LocalTime.of(0, 0,0);
        this.informeDeEstudio="";
        this.paciente=null;
    }
    /**
     * Constructor parametrizado de la clase.
     * @param fecha
     * @param hora
     * @param tipoDeEstudio
     * @param informeDeEstudio 
     */
    public ResultadoEstudios(LocalDate fecha, LocalTime hora, String tipoDeEstudio, String informeDeEstudio) {
 
        this.fecha = fecha;
        this.hora = hora;
        this.tipoDeEstudio = tipoDeEstudio;
        this.informeDeEstudio = informeDeEstudio;
        this.paciente=null;
    }
    
    /**
     * Constructor parametrizado de la clase, con el paciente incluido.
     * @param fecha
     * @param hora
     * @param tipoDeEstudio
     * @param informeDeEstudio
     * @param paciente 
     */
    public ResultadoEstudios(LocalDate fecha, LocalTime hora, String tipoDeEstudio, String informeDeEstudio, Paciente paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoDeEstudio = tipoDeEstudio;
        this.informeDeEstudio = informeDeEstudio;
        this.paciente=paciente;
    }
    
    /**
     * Obtiene la fecha del estudio.
     *
     * @return {@link LocalDate} - La fecha del estudio.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del estudio.
     *
     * @param fecha La fecha a establecer.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora del estudio.
     *
     * @return {@link LocalTime} - La hora del estudio.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora del estudio.
     *
     * @param hora La hora a establecer.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el tipo de estudio.
     *
     * @return {@link String} tipo de estudio.
     */
    public String getTipoDeEstudio() {
        return tipoDeEstudio;
    }

    /**
     * Establece el tipo de estudio.
     *
     * @param tipoDeEstudio tipo de estudio a establecer.
     */
    public void setTipoDeEstudio(String tipoDeEstudio) {
        this.tipoDeEstudio = tipoDeEstudio;
    }

    /**
     * Obtiene el informe del estudio.
     *
     * @return {@link String} Informe del estudio médico.
     */
    public String getInformeDeEstudio() {
        return informeDeEstudio;
    }

    /**
     * Establece el informe del estudio
     *
     * @param informeDeEstudio Informe del estudio a establecer.
     */
    public void setInformeDeEstudio(String informeDeEstudio) {
        this.informeDeEstudio = informeDeEstudio;
    }

    /**
     * Obtiene el paciente asociado al estudio.
     *
     * @return {@link Paciente} asociado al estudio.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado al estudio.
     *
     * @param paciente El paciente asociado al estudio.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}