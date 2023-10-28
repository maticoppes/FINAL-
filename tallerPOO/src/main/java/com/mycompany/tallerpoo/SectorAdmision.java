
package com.mycompany.tallerpoo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * @author Lucas
 */
public class SectorAdmision extends FuncionarioGeneral{
    
    /**
     * Constructor por defecto de la clase.
     */
    public SectorAdmision() {
        super();
    }

    /**
     * Constructor parametrizado de la clase.
     * @param nombre nombre
     * @param fechaNacimiento fecha de nacimiento
     * @param domicilio domicilio
     * @param documento documento/dni
     * @param telefoFijo telefono fijo
     * @param telefonoCelular telefono celular
     * @param estadoCivil estado civil
     * @param correoElectronico correo electronico
     */
    public SectorAdmision(String nombre, LocalDate fechaNacimiento, String domicilio, int documento, int telefoFijo, int telefonoCelular, String estadoCivil, String correoElectronico) {
        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico);
    }
    
    /**
     * Crea un objeto de tipo AdmisionDeEmergencia haciendo uso de los datos que
     * se pasan por parametro, y esa misma admision se le asigna al paciente.
     * Tambien añade al paciente en la lista de pacientes sin triage por atender.
     * @param paci Paciente al que se le quiere hacer la admision
     * @param motivo Motivo por el cual el paciente llego al sector de admision
     * @return Objeto AdmisionDeEmergencia con los datos proporcionados.
     */
    public AdmisionDeEmergencia hacerAdmision(Paciente paci, String motivo){
        
        AdmisionDeEmergencia admi=new AdmisionDeEmergencia(LocalDate.now(),LocalTime.now(),motivo,paci);
        paci.agregarAdmision(admi);
        
        DatosTaller.agregarPacienteAdmision(paci);
        
        return admi;
    }
    
    /**
     * Se guarda en la lista de pacientes y en el archivo correspondiente
     * el paciente pasado por parametro.
     * @param paci Paciente a registrar.
     */
    public void registrarPaciente (Paciente paci){
        DatosTaller.agregarPaciente(paci);
    }
    
    /**
     * Se crea un objeto tipo Paciente con los datos que se pasan por parametro,
     * y se lo registra (es decir, se lo guarda en la lista de pacientes y en el
     * archivo correspondiente).
     * @param nombre
     * @param fechaNacimiento
     * @param domicilio
     * @param documento
     * @param telefoFijo 
     * @param telefonoCelular
     * @param estadoCivil
     * @param correoElectronico
     * @param personaContacto
     * @return Objeto tipo paciente con los datos pasados por parametro.
     */
    public Paciente registrarPaciente(String nombre, LocalDate fechaNacimiento, String domicilio,
                                      int documento, int telefoFijo, int telefonoCelular, 
                                      String estadoCivil, String correoElectronico,
                                      String personaContacto){
        
        Paciente paci=new Paciente(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico, personaContacto);
        
        DatosTaller.agregarPaciente(paci);
        
        return paci;
    }
}
