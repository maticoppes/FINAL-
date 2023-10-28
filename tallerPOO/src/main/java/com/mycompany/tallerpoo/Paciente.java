package com.mycompany.tallerpoo;

import java.time.*;
import java.util.ArrayList;

/**
 * Esta clase representa un objeto de tipo paciente, y es donde se almacena toda
 * la informacion con respecto a el.
 *
 * @author Usuario
 */
public class Paciente extends Persona { //extender de persona

    private String personaContacto;
    private ArrayList<ResultadoEstudios> estudios;
    private ArrayList<AdmisionDeEmergencia> admisiones;
    private String motivo;

    /**
     * Constructor por defecto de la clase.
     */
    public Paciente() {
        super();
        
    
        this.estudios = new ArrayList<ResultadoEstudios>();
        this.admisiones = new ArrayList<AdmisionDeEmergencia>();
    }

    /**
     * Constructor parametrizado de la clase
     *
     * @param nombre nombre
     * @param fechaNacimiento fecha de nacimiento
     * @param domicilio domicilio
     * @param documento documento/dni
     * @param telefoFijo telefono fijo
     * @param telefonoCelular telefono celular
     * @param estadoCivil estado civil
     * @param correoElectronico correo electronico
     * @param personaContacto nombre persona de contacto
     * @param motivo motivo de consulta
     */
    public Paciente(String nombre, LocalDate fechaNacimiento, String domicilio,
            int documento, int telefoFijo, int telefonoCelular,
            String estadoCivil, String correoElectronico,
            String personaContacto, String motivo) {

        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico);
        this.personaContacto = personaContacto;
        this.motivo = motivo;
        this.estudios = new ArrayList<ResultadoEstudios>();
        this.admisiones = new ArrayList<AdmisionDeEmergencia>();

    }

    /**
     * Constructor parametrizado de la clase.
     *
     * @param nombre nombre
     * @param fechaNacimiento fecha de nacimiento
     * @param domicilio domicilio
     * @param documento documento/dni
     * @param telefoFijo telefono fijo
     * @param telefonoCelular telefono celular
     * @param estadoCivil estado civil
     * @param correoElectronico correo electronico
     * @param personaContacto nombre persona de contacto
     * @param estudios Lista de estudios
     * @param admisiones Lista de admisiones
     */
    public Paciente(String nombre, LocalDate fechaNacimiento, String domicilio,
            int documento, int telefoFijo, int telefonoCelular,
            String estadoCivil, String correoElectronico,
            String personaContacto, ArrayList<ResultadoEstudios> estudios,
            ArrayList<AdmisionDeEmergencia> admisiones) {

        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico);
        this.personaContacto = personaContacto;
        this.motivo = "";
        this.estudios = estudios;
        this.admisiones = admisiones;
    }

    /**
     * Obtiene el nombre de la persona de contacto.
     *
     * @return El nombre de la persona de contacto.
     */
    public String getPersonaContacto() {
        return personaContacto;
    }

    /**
     * Establece el nombre de la persona de contacto.
     *
     * @param personaContacto El nombre de la persona de contacto a establecer.
     */
    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    /**
     * Obtiene una lista de resultados de estudios
     *
     * @return {@link ArrayList<ResultadoEstudios>} Una lista de resultados de
     * estudios.
     */
    public ArrayList<ResultadoEstudios> getEstudios() {
        return estudios;
    }

    /**
     * Establece una lista de resultados de estudios al paciente.
     *
     * @param estudios La lista de resultados de estudios a establecer.
     */
    public void setEstudios(ArrayList<ResultadoEstudios> estudios) {
        this.estudios = estudios;
    }

    /**
     * Obtiene la lista de admisiones del paciente.
     *
     * @return {@link ArrayList<AdmisionDeEmergencia>} lista de admisiones.
     */
    public ArrayList<AdmisionDeEmergencia> getAdmisiones() {
        return admisiones;
    }

    /**
     * Obtiene el motivo de consulta del paciente.
     *
     * @return El motivo de consulta del paciente.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo de consulta del paciente.
     *
     * @param motivo El motivo de consulta a establecer.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Establece una lista de admisiones al paciente.
     *
     * @param admisiones La lista de admisiones de emergencia a establecer.
     */
    public void setAdmisiones(ArrayList<AdmisionDeEmergencia> admisiones) {
        this.admisiones = admisiones;
    }

    /**
     * Metodo que agrega un estudio a la lista de estudios del paciente
     *
     * @param resu tipo {@link ResultadoEstudios}
     * @see #agregarAdmision(com.mycompany.tallerpoo.AdmisionDeEmergencia)
     */
    public void agregarEstudio(ResultadoEstudios resu) {
        this.estudios.add(resu);
    }

    /**
     * Metodo que agrega una admision a la lista de admisiones del paciente
     *
     * @param adm tipo {@link AdmisionDeEmergencia}
     */
    public void agregarAdmision(AdmisionDeEmergencia adm) {
        this.admisiones.add(adm);
    }

    /**
     * Metodo para calcular la edad del paciente en base a su fecha de
     * nacimiento.
     *
     * @return {@link int} - edad del paciente
     */
    public int obtenerEdad() {

        int edad;
        LocalDate fechaActual = LocalDate.now(); //LocalDate.now() retorna la fecha local actual.
        LocalDate fechaNac = getFechaNacimiento();

        if (fechaActual.isAfter(fechaNac)) { //devuelve true si la fechaActual el mayor a la fechaNac.

            edad = fechaActual.getYear() - fechaNac.getYear(); //Se restan los años de cada fecha

            if (fechaActual.getMonthValue() < fechaNac.getMonthValue()) { //si el mes es menor, no cumplió años aun
                edad -= 1;
            } else {
                if (fechaActual.getMonth() == fechaNac.getMonth()) {
                    if (fechaActual.getDayOfMonth() < fechaNac.getDayOfMonth()) {
                        edad -= 1;
                    }
                }
            }
        } else {
            return -1; //retorna -1 si la fecha de nacimento es mayor a la fecha actual.
        }
        return edad;
    }

    /**
     * Concatena toda la informacion del paciente en un string.
     *
     * @return {@link String} con toda la informacion del paciente
     */

    @Override
    public String toString() {
        return "Paciente{" + "personaContacto=" + personaContacto + ", estudios=" + estudios + ", admisiones=" + admisiones + ", motivo=" + motivo + '}';
    }

}
