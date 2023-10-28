
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
        
    // A continuación se presentan los métodos getter y setter de los atributos de la clase.


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTelefoFijo() {
        return telefoFijo;
    }

    public void setTelefoFijo(int telefoFijo) {
        this.telefoFijo = telefoFijo;
    }

    public int getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(int telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Sobrescribe el método toString para obtener una representación en cadena de la
     * instancia de la clase Persona.
     * 
     * @return Una cadena que representa los atributos de la persona.
     */
    
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + ", documento=" + documento + ", telefoFijo=" + telefoFijo + ", telefonoCelular=" + telefonoCelular + ", estadoCivil=" + estadoCivil + ", correoElectronico=" + correoElectronico + '}';
    }
    
    
}