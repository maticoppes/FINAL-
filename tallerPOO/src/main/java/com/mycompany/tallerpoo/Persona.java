
package com.mycompany.tallerpoo;
import java.time.*;

/**
 *Esta clase abstracta representa a una persona y almacena información básica sobre ella,
 * como nombre, fecha de nacimiento, domicilio, documento de identidad, números de teléfono,
 * estado civil y correo electrónico.*
 * @author Matias
 * 
 */
public abstract class Persona {
    
    private String nombre;
    private LocalDate fechaNacimiento;
    private String domicilio;
    private int documento;
    private int telefoFijo;
    private int telefonoCelular;
    private String  estadoCivil;
    private String correoElectronico;

    /**
     * Constructor predeterminado.
     */
    public Persona() {
    }
    
    /**
     * Constructor que crea una instancia de Persona con la información proporcionada.
     * 
     * @param nombre           El nombre de la persona.
     * @param fechaNacimiento  La fecha de nacimiento de la persona.
     * @param domicilio        El domicilio de la persona.
     * @param documento        El número de documento de identidad de la persona.
     * @param telefoFijo       El número de teléfono fijo de la persona.
     * @param telefonoCelular  El número de teléfono celular de la persona.
     * @param estadoCivil      El estado civil de la persona.
     * @param correoElectronico El correo electrónico de la persona.
     */
    
    public Persona(String nombre, LocalDate fechaNacimiento, String domicilio, int documento, int telefoFijo, int telefonoCelular, String estadoCivil, String correoElectronico) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.documento = documento;
        this.telefoFijo = telefoFijo;
        this.telefonoCelular = telefonoCelular;
        this.estadoCivil = estadoCivil;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nombre de la persona a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return fecha de nacimiento de la persona.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La fecha de nacimiento a asignar.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el domicilio de la persona.
     *
     * @return domicilio de la persona.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio de la persona.
     *
     * @param domicilio domicilio a asignar.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Obtiene el número de documento de la persona.
     *
     * @return número de documento de la persona.
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * Establece el número de documento de la persona.
     *
     * @param documento número de documento a asignar.
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * Obtiene el número de teléfono fijo de la persona.
     *
     * @return Número de teléfono fijo de la persona.
     */
    public int getTelefoFijo() {
        return telefoFijo;
    }

    /**
     * Establece el número de teléfono fijo de la persona.
     *
     * @param telefoFijo Número de teléfono fijo a asignar.
     */
    public void setTelefoFijo(int telefoFijo) {
        this.telefoFijo = telefoFijo;
    }

    /**
     * Obtiene el número de teléfono celular de la persona.
     *
     * @return número de teléfono celular de la persona.
     */
    public int getTelefonoCelular() {
        return telefonoCelular;
    }

    /**
     * Establece el número de teléfono celular de la persona.
     *
     * @param telefonoCelular Número de teléfono celular a asignar.
     */
    public void setTelefonoCelular(int telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    /**
     * Obtiene el estado civil de la persona.
     *
     * @return Estado civil de la persona.
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Establece el estado civil de la persona.
     *
     * @param estadoCivil Estado civil a asignar.
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * Obtiene la dirección de correo electrónico de la persona.
     *
     * @return La dirección de correo electrónico de la persona.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece la dirección de correo electrónico de la persona.
     *
     * @param correoElectronico La dirección de correo electrónico de la persona a establecer.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
    * Concatena toda la informacion de la persona en un string.
    * @return String con todos los datos concatenados.
    */
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + ", documento=" + documento + ", telefoFijo=" + telefoFijo + ", telefonoCelular=" + telefonoCelular + ", estadoCivil=" + estadoCivil + ", correoElectronico=" + correoElectronico + '}';
    } 
}