package com.mycompany.tallerpoo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase representa a un enfermero.
 *
 * @see Medico
 * @see ListaEnfermeros
 * @author Santi
 */
public class Enfermero extends Persona {
    
    /**
     * Constructor por defecto de la clase.
     */
    public Enfermero() {
        super();
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
     */
    public Enfermero(String nombre, LocalDate fechaNacimiento, String domicilio, int documento, int telefoFijo, int telefonoCelular, String estadoCivil, String correoElectronico) {
        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo,
                telefonoCelular, estadoCivil, correoElectronico);
    }

    /**
     * Se crea un triage y se calcula el color del mismo en base a los datos que
     * se pasen por parametro. Tambien añade al paciente a la lista de pacientes
     * triageados sin atender.
     *
     * @param Fecha Fecha.
     * @param hora Hora.
     * @param respiracion Respiracion
     * @param pulso Pulso
     * @param estadoMental Estado mental.
     * @param conciencia Conciencia.
     * @param lesionesGraves Lesiones Graves.
     * @param edad Edad.
     * @param fiebre Fiebre.
     * @param vomitos Vomitos.
     * @param dolorAbdominal Dolor abdominal.
     * @param signosShock Signos de Shock.
     * @param lesionesLeves Lesiones Leves.
     * @param sangrado Sagrado
     * @param admision Admision.
     * @return Objeto tipo Triage con los datos pasados por parametro, y con el
     * color ya calculado.
     * @see #modificarTriage(com.mycompany.tallerpoo.Triage, java.lang.String,
     * java.lang.String)
     * @see ListaTriage
     */
    public Triage hacerTriage(LocalDate Fecha, LocalTime hora, int respiracion, int pulso, int estadoMental, int dolorPe, int conciencia, int lesionesGraves, int edad, int fiebre, int vomitos, int dolorAbdominal, int signosShock, int lesionesLeves, int sangrado, AdmisionDeEmergencia admision) {
        Triage triage = new Triage();

        triage.setFecha(LocalDate.now());
        triage.setHora(LocalTime.now());
        triage.setRespiracion(respiracion);
        triage.setPulso(pulso);
        triage.setEstadoMental(estadoMental);
        triage.setConsciencia(conciencia);
        triage.setLesionesGraves(lesionesGraves);
        triage.setEdad(edad);
        triage.setFiebre(fiebre);
        triage.setVomitos(vomitos);
        triage.setDolorAbdominal(dolorAbdominal);
        triage.setSignosShock(signosShock);
        triage.setLesionesLeves(lesionesLeves);
        triage.setSangrado(sangrado);
        triage.setDolorPe(dolorPe);

        String color = triage.obtenerColorSugerido(respiracion, pulso, estadoMental, dolorPe, conciencia, lesionesGraves, edad, fiebre, vomitos, dolorAbdominal, signosShock, lesionesLeves, sangrado);

        triage.setColorSugerido(color);
        triage.setColorFinal(color);

        Paciente paci = admision.getPaciente();
        DatosTaller.eliminarPacienteAdmision(paci);
        DatosTaller.agregarPacienteTriage(paci);

        return triage;
    }

    /**
     * Modifica el color de un triage.
     *
     * @param triage Triage.
     * @param color color a seleccionar, debe ser uno de los siguientes: Rojo,
     * Naranja, Amarillo, Verde, Azul
     * @param motivo motivo por el cual se realizo el cambio.
     *
     */
    public void modificarTriage(Triage triage, String color, String motivo) {
        triage.setColorFinal(color);
        triage.setMotivoCambio(motivo);
    }

    /**
     * Intenta asignar un box a una admision. Este metodo deberia ser llamado al
     * atender a un paciente para asignarle un box.
     *
     * @param admi admision a la que se le desea asignar un box.
     * @param box box que desea asignarse.
     * @return devuelve true si pudo asignarse correctamente, devuelve false si
     * el box está ocupado.
     * @see Box
     * @see AdmisionDeEmergencia
     * @see ListaBox
     */
    public boolean asignarBox(AdmisionDeEmergencia admi, Box box) {
        if (box.isOcupado()) {
            return false;
        }
        admi.setBox(box);
        box.setOcupado(true);

        return true;
    }

}
