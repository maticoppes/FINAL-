
package com.mycompany.tallerpoo;

import java.time.LocalDate;
 
/**
 * Esta clasa depende de un Medico y su Especialidad, y guarda la informacion
 * que vincula a ambos.
 * @author Santi
 */
public class MedicoEspecialidad {
    
    private LocalDate fecha;
    private String Universidad; 
    private Medico medico;
    private Especialidad especialidad;    
    
    /**
     * Constructor parametrizado de la clase.
     * @param fecha
     * @param Universidad 
     */
    public MedicoEspecialidad(LocalDate fecha, String Universidad) {
        this.fecha = fecha;
        this.Universidad = Universidad;
    }
    
    /**
     * Constructor parametrizado de la clase.
     * @param fecha fecha a establecer
     * @param Universidad universidad
     * @param medico medico
     * @param especialidad especialidad
     */
    public MedicoEspecialidad(LocalDate fecha, String Universidad, Medico medico, Especialidad especialidad) {
        this.fecha = fecha;
        this.Universidad = Universidad;
        this.medico = medico;
        this.especialidad = especialidad;
    }
    /**
     * Constructor por defecto de la clase
     */
    public MedicoEspecialidad(){
        this.fecha = LocalDate.of(1, 1, 1);
        this.Universidad = "";
    }

    /**
     * Obtiene la fecha de cuando se especializó.
     *
     * @return {@code LocalDate} fecha de especializacion.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de especialización.
     *
     * @param fecha La fecha a establecer.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre de la universidad donde se especializó.
     *
     * @return {@code String} nombre de la universidad.
     */
    public String getUniversidad() {
        return Universidad;
    }

    /**
     * Establece el nombre de la universidad donde se especializó.
     *
     * @param Universidad El nombre de la universidad.
     */
    public void setUniversidad(String Universidad) {
        this.Universidad = Universidad;
    }

    /**
     * Obtiene el médico al cual esta vinculado.
     *
     * @return {@code Medico} Medico vinculado
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico vinculado.
     *
     * @param medico El médico a establecer.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Obtiene la especialidad médica obtenida.
     *
     * @return especialidad médica obtenida.
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad médica obtenida.
     *
     * @param especialidad La especialidad médica a establecer.
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Concatena los datos y los representa como una cadena.
     *
     * @return Una representación en forma de cadena de la instancia de MedicoEspecialidad.
     */
    @Override
    public String toString() {
        return "MedicoEspecialidad{" + "fecha=" + fecha + ", Universidad=" + Universidad + '}';
    }
}