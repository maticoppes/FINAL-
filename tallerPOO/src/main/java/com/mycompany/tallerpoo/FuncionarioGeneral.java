
package com.mycompany.tallerpoo;

import java.time.LocalDate;
import persistencia.LecturaDatosFuncionariosGenerales;
import java.util.ArrayList;

/**
 *
 * @author 54345
 */
public class FuncionarioGeneral extends Persona{
    private String rol;
    private String sector;
    private String contrasenia;
    
    
    public FuncionarioGeneral(){
        super();
    }
    
    public FuncionarioGeneral(String nombre, LocalDate fechaNacimiento, String domicilio,
                              int documento, int telefoFijo, int telefonoCelular,
                              String estadoCivil, String correoElectronico){
        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico);
        this.rol = rol;
        this.sector=sector;
        this.contrasenia=contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public ArrayList<FuncionarioGeneral> leer(String ubicacion){
        LecturaDatosFuncionariosGenerales algo = new LecturaDatosFuncionariosGenerales();
        algo.leer(ubicacion);
        return null;
    }
    
}
