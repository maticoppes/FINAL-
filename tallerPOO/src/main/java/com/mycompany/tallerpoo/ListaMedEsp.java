
package com.mycompany.tallerpoo;

import java.util.ArrayList;

/**
 * La clase `ListaMedEsp` presenta una lista de relaciones entre médicos y especialidades.
 * cada elemento de la lista es una instancia de la clase `MedicoEspecialidad`.
 *
 * Esta clase permite almacenar y gestionar estas relaciones, lo que es útil para
 * llevar un registro de las especialidades que un médico tiene y las fechas en que
 * se asignaron.
 *
 * @author Lucas
 */

public class ListaMedEsp {
   /**
    *Esta lista se utiliza en la clase `ListaMedEsp` para llevar un registro de las relaciones entre médicos
    * y especialidades, permitiendo el seguimiento y la gestión de estas asignaciones.
    */
    private ArrayList<MedicoEspecialidad> medespe;
    
    /** 
     * Constructor parametrizado.
     * @param medespe 
     */
    public ListaMedEsp(ArrayList<MedicoEspecialidad> medespe) {
        this.medespe = medespe;
    }

    /**
     * Constructor de la clase `ListaMedEsp`.
     * Crea una instancia de `ListaMedEsp` inicializada con una lista vacía de relaciones
     * entre médicos y especialidades.
     */    
    public ListaMedEsp() {
        this.medespe=new ArrayList<MedicoEspecialidad>();
    }

    /**
     * Obtiene la lista de relaciones entre médicos y especialidades.
     *
     * @return La lista de relaciones entre médicos y especialidades.
     */    
    
    public ArrayList<MedicoEspecialidad> getMedespe() {
        return medespe;
    }
    /**
     * Establece la lista de relaciones entre médicos y especialidades.
     *
     * @param medespe La lista de relaciones entre médicos y especialidades a establecer.
     */
    public void setMedespe(ArrayList<MedicoEspecialidad> medespe) {
        this.medespe = medespe;
    }
    
    /**
     * Agrega una relación entre médico y especialidad a la lista.
     *
     * @param espe La relación entre médico y especialidad a agregar a la lista.
     */    
    
    public void agregarEspe(MedicoEspecialidad espe){
        this.medespe.add(espe);
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de `ListaMedEsp`.
     *
     * @return cadena que representa la instancia de `ListaMedEsp`, incluyendo información
     *         sobre las relaciones entre médicos y especialidades almacenadas en la lista.
     */    
    
    @Override
    public String toString() {
        return "ListaMedEsp{" + "medespe=" + medespe + '}';
    }
   
    
}
