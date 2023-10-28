package com.mycompany.tallerpoo;

import java.util.ArrayList;

/**
 * Clase que representa una espacialidad medica. Los medico tienen una especialidad asignada a ellos.
 * @author Santi
 */
public class Especialidad {
    
    private String titulo;
    private String especialidad;
    private ArrayList<Medico> medicos;

    /**
     * Constructor parametrizado de la clase.
     * @param titulo titulo
     * @param especialidad especialidad
     */
    public Especialidad(String titulo, String especialidad) {
        this.titulo = titulo;
        this.especialidad = especialidad;
        this.medicos=new ArrayList<Medico>();
    }
    
    /**
     * Constructor por defecto de la clase.
     */
    public Especialidad() {
        this.titulo = "";
        this.especialidad = "";
        this.medicos=new ArrayList<Medico>();
    }

    /**
     * Obtiene el título definido.
     *
     * @return {@link String} titulo otorgado.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título.
     *
     * @param titulo El título a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la especialidad medica.
     *
     * @return El nombre de la especialidad medica.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece el nombre de la especialidad medica.
     *
     * @param especialidad El nombre de la especialidad a establecer.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la lista de medicos que tengan esta especialidad.
     *
     * @return {@link ArrayList} Una lista de médicos.
     */
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    /**
     * Establece la lista de médicos con esta especialidad.
     *
     * @param medicos La lista de médicos especializados a establecer.
     */
    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    /**
     * Agrega un médico a la lista de médicos especializados en esta especialidad.
     *
     * @param medico El médico a agregar a la lista.
     */
    public void agregarMedico(Medico medico) {
        this.medicos.add(medico);
    }
    
    /**
     * Concatena toda la informacion a un string
     * @return {@link String} con toda la informacion concatenada.
     */
    @Override
    public String toString() {
        return "Especialidad{" + "titulo=" + titulo + ", especialidad=" + especialidad + '}';
    }

}