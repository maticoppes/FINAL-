package persistencia;

import com.mycompany.tallerpoo.AdmisionDeEmergencia;
import com.mycompany.tallerpoo.DatosTaller;
import com.mycompany.tallerpoo.Paciente;
import com.mycompany.tallerpoo.Persona;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que permite cargar datos de pacientes desde un archivo CSV y almacenarlos en una lista.
 * Estos datos pueden ser utilizados para consultas en una tabla o en una aplicación de gestión médica.
 * Los datos de los pacientes deben estar en un formato específico en el archivo CSV.
 * 
 * @author Valen
 * 
 */
public class CargarDatosPacientesConsultasTabla {
    /**
     * Una lista que almacena objetos de tipo Paciente.
     */    
   public ArrayList<Paciente> pacientes;

    /**
     * Constructor por defecto de la clase que inicializa la lista de pacientes vacía.
     */   
   
   public CargarDatosPacientesConsultasTabla() {
        this.pacientes = new ArrayList<Paciente>();
    }
    
    /**
     * Constructor que permite inicializar la clase con una lista de pacientes existente.
     *
     * @param pacientes La lista de pacientes a cargar.
     */ 
   
    public CargarDatosPacientesConsultasTabla(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    /**
     * Obtiene la lista de pacientes cargada o almacenada en esta clase.
     *
     * @return La lista de pacientes.
     */    
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Establece la lista de pacientes en esta clase.
     *
     * @param pacientes La lista de pacientes a establecer.
     */    
    
    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    /**
     * Agrega un paciente a la lista de pacientes cargada o almacenada en esta clase.
     *
     * @param paci El paciente a agregar a la lista.
     */      
    public void agregar(Paciente paci) {
        pacientes.add(paci);
    }

    /**
     * Lee datos de pacientes desde un archivo CSV y los agrega a la lista de pacientes en esta clase.
     * El formato del archivo TXT debe ser específico, y se esperan al menos 4 elementos por línea.
     *
     * @param archivo La ruta al archivo CSV que contiene los datos de pacientes.
     * @return La lista de pacientes actualizada después de cargar datos desde el archivo.
     */    
    
    public ArrayList<Paciente> leer(String archivo) {

        try {
            try(BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea= reader.readLine()) != null) {
                    String[] split = linea.split(",");
                    if (split.length >= 4) { // Verifica que haya al menos 4 elementos en la línea
                        Paciente paci = new Paciente();
                        paci.setNombre(split[1]);
                        paci.setDocumento(Integer.parseInt(split[0]));
                        paci.setMotivo(split[4]);
                        this.agregar(paci);
                    } else {
                        // Manejar el caso donde la línea no tiene suficientes elementos
                        System.err.println("Línea incorrecta: " + linea);
                    }
                    
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(pacientes.size());
        return pacientes;
    }
    
    /**
     * Devuelve una representación en forma de cadena de esta clase.
     *
     * @return Una cadena que representa la instancia de la clase.
     */
    
    @Override
    public String toString() {
        return "CargarDatosPacientesConsultas{" + "pacientes=" + pacientes + '}';
    }
    
}
