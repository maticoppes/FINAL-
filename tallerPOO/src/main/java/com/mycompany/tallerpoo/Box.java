
package com.mycompany.tallerpoo;


/**
 * Esta clase representa un box, el cual tiene un numero y puede estar ocupado o
 * desocupado. Un medico puede asignar un box a un paciente a la hora de atenderlo.
 * @author Lucas
 * @see Medico
 * @see AdmisionDeEmergencia
 * @see Paciente
 */
public class Box {
    private int numero;
    private boolean ocupado;

    /**
     * Constructor por defecto de la clase.
     */
    public Box() {      
    }
    
    /**
     * Constructor parametrizado de la clase.
     * @param numero numero de box
     * @param ocupado establece si esta ocupado o no.
     */
    public Box(int numero, boolean ocupado) {
        this.numero = numero;
        this.ocupado = ocupado;
    }
    
    /**
     * Constructor parametrizado de la clase. Se establece el box como desocupado.
     * @param numero numero de box
     * @param ocupado establece si esta ocupado o no.
     */
    public Box(int numero) {
        this.numero = numero;
        this.ocupado = false;
    }

    /**
     * Obtiene el número asociado a este box.
     *
     * @return {@link int} El número asociado.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número asociado a este box.
     *
     * @param numero El número a establecer.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Comprueba si este box está ocupado.
     *
     * @return "true" si el objeto está ocupado, "false" si no lo está.
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * Establece el estado del box (ocupado o no).
     *
     * @param ocupado "true" para asignarlo como ocupado, "false" para caso contrario.
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }


}
