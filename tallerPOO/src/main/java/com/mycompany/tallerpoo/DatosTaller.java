package com.mycompany.tallerpoo;

/**
 * Clase que almacena todas las listas con los datos que son leidos desde
 * almacenamiento y luego usados en todo el programa.
 *
 * @author Lucas
 */
public abstract class DatosTaller {

    private static ListaPacientes pacientes = new ListaPacientes();
    private static ListaMedicos medicos = new ListaMedicos();
    private static ListaResEstudios resultados = new ListaResEstudios();
    private static ListaAdmisiones admisiones = new ListaAdmisiones();
    private static ListaEspecialidades especialidades = new ListaEspecialidades();
    private static ListaBox boxes = new ListaBox();

    /**
     * Lista que almacena a los pacientes que son admitidos, y estan a la espera
     * de un triage.
     */
    private static ListaPacientes pacientesSinTriage = new ListaPacientes();

    /**
     * Lista que almacena a los pacientes que se han realizado el triage, y
     * estan a la espera de ser atendidos por un medico.
     */
    private static ListaPacientes pacientesTriageados = new ListaPacientes();
    private static ListaAsignacionBox asignaciones = new ListaAsignacionBox();
    private static ListaEnfermeros enfermeros = new ListaEnfermeros();
    private static ListaTriage triages = new ListaTriage();

    /**
     * Obtiene la lista de triages.
     *
     * @return lista de triages.
     */
    public static ListaTriage getTriages() {
        return triages;
    }

    /**
     * Establece la lista de triages
     *
     * @param triages lista de triages a establecer.
     */
    public static void setTriages(ListaTriage triages) {
        DatosTaller.triages = triages;
    }

    /**
     * Obtiene la lista de pacientes
     *
     * @return lista de pacientes.
     */
    public static ListaPacientes getPacientes() {
        return pacientes;
    }

    /**
     * Establece la lista de pacientes.
     *
     * @param pacientes lista de pacientes a establecer.
     */
    public static void setPacientes(ListaPacientes pacientes) {
        DatosTaller.pacientes = pacientes;
    }

    /**
     * Obtiene la lista de médicos.
     *
     * @return lista de médicos.
     */
    public static ListaMedicos getMedicos() {
        return medicos;
    }

    /**
     * Establece la lista de médicos.
     *
     * @param medicos lista de médicos a establecer.
     */
    public static void setMedicos(ListaMedicos medicos) {
        DatosTaller.medicos = medicos;
    }

    /**
     * Obtiene la lista de resultados de estudios.
     *
     * @return lista de resultados de estudios.
     */
    public static ListaResEstudios getResultados() {
        return resultados;
    }

    /**
     * Establece la lista de resultados de estudios.
     *
     * @param resultados lista de resultados de estudios a establecer.
     */
    public static void setResultados(ListaResEstudios resultados) {
        DatosTaller.resultados = resultados;
    }

    /**
     * Obtiene la lista de admisiones.
     *
     * @return lista de admisiones.
     */
    public static ListaAdmisiones getAdmisiones() {
        return admisiones;
    }

    /**
     * Establece la lista de admisiones.
     *
     * @param admisiones lista de admisiones a establecer.
     */
    public static void setAdmisiones(ListaAdmisiones admisiones) {
        DatosTaller.admisiones = admisiones;
    }

    /**
     * Obtiene la lista de especialidades.
     *
     * @return lista de especialidades.
     */
    public static ListaEspecialidades getEspecialidades() {
        return especialidades;
    }

    /**
     * Establece la lista de especialidades.
     *
     * @param especialidades lista de especialidades a establecer.
     */
    public static void setEspecialidades(ListaEspecialidades especialidades) {
        DatosTaller.especialidades = especialidades;
    }

    /**
     * Obtiene la lista de box.
     *
     * @return lista de boxes.
     */
    public static ListaBox getBoxes() {
        return boxes;
    }

    /**
     * Establece la lista de boxes.
     *
     * @param boxes lista de boxes a establecer.
     */
    public static void setBoxes(ListaBox boxes) {
        DatosTaller.boxes = boxes;
    }

    /**
     * Obtiene la lista de pacientes sin triage.
     *
     * @return lista de pacientes sin triage.
     */
    public static ListaPacientes getPacientesSinTriage() {
        return pacientesSinTriage;
    }

    /**
     * Establece la lista de pacientes sin triage.
     *
     * @param pacientesSinTriage lista de pacientes sin triage a establecer.
     */
    public static void setPacientesSinTriage(ListaPacientes pacientesSinTriage) {
        DatosTaller.pacientesSinTriage = pacientesSinTriage;
    }

    /**
     * Obtiene la lista de pacientes triageados.
     *
     * @return lista de pacientes triageados.
     */
    public static ListaPacientes getPacientesTriageados() {
        return pacientesTriageados;
    }

    /**
     * Establece la lista de pacientes triageados.
     *
     * @param pacientesTriageados lista de pacientes triageados a establecer.
     */
    public static void setPacientesTriageados(ListaPacientes pacientesTriageados) {
        DatosTaller.pacientesTriageados = pacientesTriageados;
    }

    /**
     * Obtiene la lista de asignaciones de boxes.
     *
     * @return lista de asignaciones de boxes.
     */
    public static ListaAsignacionBox getAsignaciones() {
        return asignaciones;
    }

    /**
     * Establece la lista de asignaciones de boxes.
     *
     * @param asignaciones lista de asignaciones de boxes a establecer.
     */
    public static void setAsignaciones(ListaAsignacionBox asignaciones) {
        DatosTaller.asignaciones = asignaciones;
    }

    /**
     * Obtiene la lista de enfermeros.
     *
     * @return lista de enfermeros.
     */
    public static ListaEnfermeros getEnfermeros() {
        return enfermeros;
    }

    /**
     * Establece la lista de enfermeros.
     *
     * @param enfermeros lista de enfermeros a establecer.
     */
    public static void setEnfermeros(ListaEnfermeros enfermeros) {
        DatosTaller.enfermeros = enfermeros;
    }

    /**
     * Agrega un paciente a la lista general de pacientes.
     *
     * @param paci paciente a agregar.
     */
    public static void agregarPaciente(Paciente paci) {
        pacientes.agregar(paci);
    }

    /**
     * Agrega un paciente a la lista de pacientes a la espera del triage.
     *
     * @param paci paciente a agregar.
     */
    public static void agregarPacienteAdmision(Paciente paci) {
        pacientesSinTriage.agregar(paci);
    }

    /**
     * Elimina un paciente de la lista de pacientes en espera de ser triageados
     *
     * @param paci paciente a agregar.
     */
    public static void eliminarPacienteAdmision(Paciente paci) {
        pacientesSinTriage.eliminar(paci);
    }

    /**
     * Agrega un paciente a la lista de pacientes a la espera de ser atendidos.
     *
     * @param paci paciente a agregar.
     */
    public static void agregarPacienteTriage(Paciente paci) {
        pacientesTriageados.agregar(paci);
    }

    /**
     * Elimina un paciente de la lista de pacientes en espera de ser atendidos.
     *
     * @param paci paciente a agregar.
     */
    public static void eliminarPacienteTriage(Paciente paci) {
        pacientesTriageados.eliminar(paci);
    }

}
