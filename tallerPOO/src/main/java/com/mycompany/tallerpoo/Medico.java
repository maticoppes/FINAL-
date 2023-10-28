

package com.mycompany.tallerpoo;
import java.time.*;
import java.util.*;

/**
 * Esta clase representa un médico, y hereda los atributos de una persona.
 * @see     Persona
 * @see     Enfermero
 * @see     ListaMedicos
 * @author Lucas
 */
public class Medico extends Persona{
    
    /**
     * Matricula de un medico.
     * @see #getMatricula()
     * @see #setMatricula(int)  
     */
    private int matricula;
    /**
     * Lista de especialidades de un medico.
     * @see Especialidad
     * @see #getEspecialidad() 
     * @see #setEspecialidad(java.util.ArrayList) 
     * @see #agregarEspecialidad(com.mycompany.tallerpoo.Especialidad) 
     */
    private ArrayList<Especialidad> especialidad;
  
    /**
     * Constructor parametrizado de medico.
     * @param nombre
     * @param fechaNacimiento
     * @param domicilio
     * @param documento
     * @param telefoFijo
     * @param telefonoCelular
     * @param estadoCivil
     * @param correoElectronico
     * @param matricula 
     */
    public Medico(String nombre, LocalDate fechaNacimiento, String domicilio, 
                  int documento, int telefoFijo, int telefonoCelular, 
                  String estadoCivil, String correoElectronico, int matricula) {
        
        super(nombre, fechaNacimiento, domicilio, documento, telefoFijo, telefonoCelular, estadoCivil, correoElectronico);
        this.matricula=matricula;
        this.especialidad=new ArrayList<Especialidad>();
    }
    
    /**
     * Constructor por defecto de médico.
     */
    public Medico() {
        this.especialidad=new ArrayList<Especialidad>();
    }

    /**
    * Obtiene la matrícula del médico.
    *
    * @return {@link int} - matricula
    */
   public int getMatricula() {
       return matricula;
   }

   /**
    * Establece la matrícula del médico.
    *
    * @param matricula La matrícula del médico a establecer.
    */
   public void setMatricula(int matricula) {
       this.matricula = matricula;
   }

   /**
    * Obtiene la lista de especialidades del médico.
    *
    * @return {@link ArrayList} - lista de especialidades del medico.
    */
   public ArrayList<Especialidad> getEspecialidad() {
       return especialidad;
   }

   /**
    * Establece la lista de especialidades del médico.
    *
    * @param especialidad La lista de especialidades a establecer.
    */
   public void setEspecialidad(ArrayList<Especialidad> especialidad) {
       this.especialidad = especialidad;
   }
    
    /**
     * Agrega una especialidad a la lista de especialidades del medico
     * <pre>
     * Medico medico = new Medico();
     * medico.agregarEspecialidad(new Especialidad());
     * </pre>
     * @param espe 
     */
    public void agregarEspecialidad(Especialidad espe){
        this.especialidad.add(espe);
    }
    
    /**
     * Metodo que se utiliza por un medico a la hora de atender un paciente, lo
     * cual implica que se lo quita de la lista de los pacientes en espera.
     * @param paciente paciente a atender
     * @see SectorAdmision#hacerAdmision(com.mycompany.tallerpoo.Paciente, java.lang.String) 
     */
    public void atenderPaciente(Paciente paciente){
        DatosTaller.eliminarPacienteTriage(paciente); 
    }
 
    
    /**
     * Se crea un triage y se calcula el color del mismo en base a los datos que
     * se pasen por parametro. Tambien añade al paciente a la lista de pacientes
     * triageados sin atender.
     * @param respiracion
     * @param pulso
     * @param estadoMental
     * @param conciencia
     * @param lesionesGraves
     * @param edad
     * @param fiebre
     * @param vomitos
     * @param dolorAbdominal
     * @param signosShock
     * @param lesionesLeves
     * @param sangrado
     * @param admision
     * @return Objeto tipo Triage con los datos pasados por parametro, y con el color ya calculado.
     * @see #modificarTriage(com.mycompany.tallerpoo.Triage, java.lang.String, java.lang.String) 
     * @see ListaTriage
     */
    public Triage hacerTriage(int respiracion, int pulso, int estadoMental, int conciencia, int lesionesGraves, int edad, int fiebre, int vomitos, int dolorAbdominal, int signosShock, int lesionesLeves, int sangrado, AdmisionDeEmergencia admision){
        Triage triage=new Triage();
        
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
        triage.setAdmision(admision);
        
        String color=triage.obtenerColorSugerido(respiracion, pulso, estadoMental, conciencia, lesionesGraves, edad, fiebre, vomitos, dolorAbdominal, signosShock, lesionesLeves, sangrado);
        
        triage.setColorSugerido(color);
        triage.setColorFinal(color);
        triage.setMedico(this);
        
        admision.setTriage(triage);
        triage.setAdmision(admision);
        
        Paciente paci=admision.getPaciente();
        DatosTaller.eliminarPacienteAdmision(paci);
        DatosTaller.agregarPacienteTriage(paci);
        
        
        
        DatosTaller.getTriages().agregarArchivo("Archivos/Triage.txt",triage);
        
        return triage;
    }
    /**
     * Modifica el color de un triage.
     * @param triage triage a modificar
     * @param color color a seleccionar, debe ser uno de los siguientes: Rojo, Naranja, Amarillo, Verde, Azul
     * @param motivo motivo por el cual se realizo el cambio.
     * @see #hacerTriage(int, int, int, int, int, int, int, int, int, int, int, int, int, com.mycompany.tallerpoo.AdmisionDeEmergencia) 
     */
    public void modificarTriage(Triage triage, String color, String motivo){
        triage.setColorFinal(color);
        triage.setMotivoCambio(motivo);
    }
    
    /**
     * Concatena toda la informacion de el medico y la retorna como un string.
     * @return {@link String} con toda la informacion concatenada.
     */
    @Override
    public String toString() {
        return "Medico{" + "matricula=" + matricula + ", especialidad=" + especialidad + '}';
    }
    
    /**
     * Intenta asignar un box a una admision. Este metodo deberia ser llamado al
     * atender a un paciente para asignarle un box.
     * @param admi admision a la que se le desea asignar un box.
     * @param box box que desea asignarse.
     * @return devuelve true si pudo asignarse correctamente, devuelve false si el
     * box está ocupado.
     * @see Box
     * @see AdmisionDeEmergencia
     * @see ListaBox
     */
    public boolean asignarBox(AdmisionDeEmergencia admi, Box box){
        if (box.isOcupado()){
            return false;
        }
        admi.setBox(box);
        box.setOcupado(true);
        
        return true;
    }
    
    /**
     * Intenta asignar un box a una admision. Este metodo deberia ser llamado al
     * atender a un paciente para asignarle un box.
     * @param admi admision a la que se le desea asignar un box.
     * @param numero numero de box que desea asignarse.
     * @return devuelve true si pudo asignarse correctamente, devuelve false si el
     * box está ocupado o si no existe.
     * @see Box
     * @see AdmisionDeEmergencia
     * @see ListaBox
     */
    public boolean asignarBox(AdmisionDeEmergencia admi, int numero){
        
        Box box=DatosTaller.getBoxes().getPorNumero(numero);
        
        if (box==null || box.isOcupado()){
            return false;
        }
        admi.setBox(box);
        box.setOcupado(true);
        
        return true;
    }
}
