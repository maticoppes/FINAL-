package com.mycompany.tallerpoo;

import java.time.*;

/**
 * Clase que representan las admisiones de los pacientes.
 *
 * @author Lucas
 * @see ListaAdmisiones
 */
public class AdmisionDeEmergencia {

    private LocalDate fecha;
    private LocalTime hora;
    private String motivoDeConsulta;
    private Paciente paciente;
    /**
     * Triage que es realizado luego de la admision. Se inicializa vacio hasta
     * que un medico/enfermero decida realizar el triage.
     *
     * @see Triage
     */
    private Triage triage;
    /**
     * Box que es asignado una vez que un medico decida atender al paciente
     * vinculado a esta admision. Se inicializa vacio hasta que un medico decida
     * realizar la atencion.
     */
    private Box box;

    /**
     * Cnstructor por defecto de la claseo
     */
    public AdmisionDeEmergencia() {
        this.fecha = LocalDate.of(1, 1, 1);
        this.hora = LocalTime.of(0, 0, 0);
        this.motivoDeConsulta = "";
        this.paciente = new Paciente();
        this.triage = null;
        this.box = new Box();
    }

    /**
     * Contructor parametrizado de la clase.
     *
     * @param fecha Fecha pasada por parametros.
     * @param hora Hora pasada por parametros.
     * @param motivoDeConsulta Motivo por el cual se atiende pasada por
     * parametros.
     */
    public AdmisionDeEmergencia(LocalDate fecha, LocalTime hora, String motivoDeConsulta) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivoDeConsulta = motivoDeConsulta;
        this.paciente = new Paciente();
        this.triage = null;
        this.box = new Box();
    }

    /**
     * Contructor parametrizado de la clase, con el paciente incluido.
     *
     * @param fecha La fecha de la admisión.
     * @param hora La hora de la admisión.
     * @param motivoDeConsulta El motivo por el cual se atiende al paciente.
     * @param paciente El paciente relacionado con la admisión.
     */
    public AdmisionDeEmergencia(LocalDate fecha, LocalTime hora, String motivoDeConsulta, Paciente paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivoDeConsulta = motivoDeConsulta;
        this.paciente = paciente;
        this.triage = null;
        this.box = new Box();
    }

    /**
     * Contructor parametrizado de la clase, con el triage y el paciente
     * incluidos.
     *
     * @param fecha La fecha de la admisión.
     * @param hora La hora de la admisión.
     * @param motivoDeConsulta El motivo por el cual se atiende al paciente.
     * @param paciente El paciente relacionado con la admisión.
     * @param triage El triage realizado después de la admisión.
     */

    public AdmisionDeEmergencia(LocalDate fecha, LocalTime hora, String motivoDeConsulta, Paciente paciente, Triage triage) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivoDeConsulta = motivoDeConsulta;
        this.paciente = paciente;
        this.triage = triage;
        this.box = new Box();

    }

    /**
     * Obtiene la fecha de la admision.
     *
     * @return {@link LocalDate} fecha de la admision.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la admision.
     *
     * @param fecha fecha a establecer.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la admision.
     *
     * @return hora de la admision.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora de la admision.
     *
     * @param hora La hora a establecer.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el motivo de consulta.
     *
     * @return motivo de consulta.
     */
    public String getMotivoDeConsulta() {
        return motivoDeConsulta;
    }

    /**
     * Establece el motivo de consulta.
     *
     * @param motivoDeConsulta motivo de consulta a establecer.
     */
    public void setMotivoDeConsulta(String motivoDeConsulta) {
        this.motivoDeConsulta = motivoDeConsulta;
    }

    /**
     * Obtiene el paciente asociado a la admision.
     *
     * @return El paciente asociado.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado a la admision.
     *
     * @param paciente El paciente a asociar.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Obtiene el triage asociado a la admision.
     *
     * @return triage asociado a la admision.
     */
    public Triage getTriage() {
        return triage;
    }

    /**
     * Establece el triage asociado a la admision.
     *
     * @param triage triage asociado a la admision.
     */
    public void setTriage(Triage triage) {
        this.triage = triage;
    }

    /**
     * Obtiene el box asociado a la admision.
     *
     * @return El box asociado a la admision.
     */
    public Box getBox() {
        return box;
    }

    /**
     * Establece el box asociado a la admision.
     *
     * @param box box asociado a la admision.
     */
    public void setBox(Box box) {
        this.box = box;
    }

    /**
     * Concatena la informacion de la admision en un unico string.
     *
     * @return String con la informacion concatenada.
     */
     @Override
    public String toString() {
        return "AdmisionDeEmergencia{" + "fecha=" + fecha + ", hora=" + hora + ", motivoDeConsulta=" + motivoDeConsulta + ", paciente=" + paciente + ", triage=" + triage + ", box=" + box + '}';
    }

}
