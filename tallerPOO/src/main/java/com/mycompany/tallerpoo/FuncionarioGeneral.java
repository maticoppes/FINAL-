
package com.mycompany.tallerpoo;

import java.time.LocalDate;

/**
 *
 * @author 54345
 */
public abstract class FuncionarioGeneral extends Persona{
    
    
    
    public FuncionarioGeneral(){
        super();
    }
    
    public FuncionarioGeneral(String nombre, LocalDate fechaNacimiento, String domicilio,
                              int documento, int telefoFijo, int telefonoCelular,
                              String estadoCivil, String correoElectronico){
        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico);
    }
    
}
