package com.mycompany.tallerpoo;

import java.time.LocalDate;
import persistencia.LecturaDatosFuncionariosGenerales;
import java.util.ArrayList;

/**
 * Esta clase representa a un funcionario general que forma parte del personal
 * del hospital. Un funcionario general hereda atributos y métodos de la clase
 * Persona y agrega información específica relacionada con su rol, sector y
 * contraseña.
 *
 * @see Persona
 * @see LecturaDatosFuncionariosGenerales
 * @author 54345
 */
public class FuncionarioGeneral extends Persona {

    /**
     *
     */
    private String rol;
    private String sector;
    private String contrasenia;

    /**
     * Constructor por defecto de la clase FuncionarioGeneral.
     */

    public FuncionarioGeneral() {
        super();

    }

    /**
     * Constructor parametrizado de la clase FuncionarioGeneral.
     *
     * @param nombre El nombre del funcionario general.
     * @param fechaNacimiento La fecha de nacimiento del funcionario general.
     * @param domicilio El domicilio del funcionario general.
     * @param documento El número de documento del funcionario general.
     * @param telefoFijo El número de teléfono fijo del funcionario general.
     * @param telefonoCelular El número de teléfono celular del funcionario
     * general.
     * @param estadoCivil El estado civil del funcionario general.
     * @param correoElectronico La dirección de correo electrónico del
     * funcionario general.
     * @param rol El rol o cargo del funcionario general.
     * @param sector El sector o área al que pertenece el funcionario general.
     * @param contrasenia La contraseña del funcionario general.
     */

    public FuncionarioGeneral(String nombre, LocalDate fechaNacimiento, String domicilio,
            int documento, int telefoFijo, int telefonoCelular,
            String estadoCivil, String correoElectronico,
            String rol, String sector, String contrasenia) {
        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico);
        this.rol = rol;
        this.sector = sector;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene la el rol del funcionario general.
     *
     * @return el rol.
     */

    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol del funcionario general.
     *
     * @param rol el rol del funcionario general.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Obtiene el sector o área al que pertenece el funcionario general.
     *
     * @return El sector o área del funcionario general.
     */
    public String getSector() {
        return sector;
    }

    /**
     * Establece el sector o área al que pertenece el funcionario general.
     *
     * @param sector El sector o área del funcionario general.
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * Obtiene la contraseña del funcionario general.
     *
     * @return La contraseña del funcionario general.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del funcionario general.
     *
     * @param contrasenia La contraseña del funcionario general.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Lee los datos de funcionarios generales desde un archivo ubicado en la
     * ruta especificada.
     *
     * @param ubicacion La ubicación o ruta del archivo que contiene los datos
     * de funcionarios generales.
     * @return Una lista de objetos FuncionarioGeneral que representa a los
     * funcionarios leídos desde el archivo.
     * @see LecturaDatosFuncionariosGenerales
     */
    public ArrayList<FuncionarioGeneral> leer(String ubicacion) {
        LecturaDatosFuncionariosGenerales algo = new LecturaDatosFuncionariosGenerales();
        algo.leer(ubicacion);
        return null;
    }

}
