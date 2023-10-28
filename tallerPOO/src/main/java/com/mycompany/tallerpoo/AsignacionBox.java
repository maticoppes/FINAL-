
package com.mycompany.tallerpoo;
import java.time.*;
        
/**
 * Esta clase representa la relacion que hay entre un box y una admision.
 * @author Lucas
 */
public class AsignacionBox {
    /**
     * Fecha a la que se asignó el box.
     */
    private LocalDate fecha;
    /**
     * Hora a la que se asignó el box.
     */
    private LocalTime hora;
    private Box box;
    private AdmisionDeEmergencia admision;

    /**
     * Constructor parametrizado de la clase. 
     * @param fecha fecha de la asignacion.
     * @param hora hora de la asignacion
     */
    public AsignacionBox(LocalDate fecha, LocalTime hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.box=new Box();
        this.admision=new AdmisionDeEmergencia();
    }
    
    /**
     * Constructor parametrizado de la clase.
     * @param fecha fecha de la asignacion.
     * @param hora hora de la asignacion
     * @param box box
     * @param admision admision de emergencia
     */
    public AsignacionBox(LocalDate fecha, LocalTime hora, Box box, AdmisionDeEmergencia admision) {
        this.fecha = fecha;
        this.hora = hora;
        this.box = box;
        this.admision = admision;
    }
        
    /**
     * Obtiene la fecha de asignacion.
     *
     * @return {@link LocalDate} - fecha de asignacion.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de asignacion
     *
     * @param fecha fecha del evento a establecer.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de asignacion.
     *
     * @return {@link LocalTime} - hora de asignacion.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora de asignacion.
     *
     * @param hora hora de asignacion.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el Box que se esta asignando.
     *
     * @return {@link Box} Box asignado.
     */
    public Box getBox() {
        return box;
    }

    /**
     * Establece el Box asignado.
     *
     * @param box Box a asignar.
     */
    public void setBox(Box box) {
        this.box = box;
    }

    /**
     * Obtiene la admisión asiganda.
     *
     * @return {@link AdmisionDeEmergencia} admision asignada.
     */
    public AdmisionDeEmergencia getAdmision() {
        return admision;
    }

    /**
     * Establece la admisión de emergencia asignada.
     *
     * @param admision Admision de emergencia a asignar.
     */
    public void setAdmision(AdmisionDeEmergencia admision) {
        this.admision = admision;
    }

}
