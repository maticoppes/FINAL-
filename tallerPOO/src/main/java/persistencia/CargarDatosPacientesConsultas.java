package persistencia;

import com.mycompany.taller.Paciente;
import com.mycompany.taller.Persona;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CargarDatosPacientesConsultas {

   public ArrayList<Paciente> pacientes;
   
   public CargarDatosPacientesConsultas() {
        this.pacientes = new ArrayList<Paciente>();
    }
    
    public CargarDatosPacientesConsultas(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
      
    public void agregar(Paciente paci) {
        pacientes.add(paci);
    }

    public ArrayList<Paciente> leer(String archivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            System.out.println();
            String linea; 
            while ((linea= reader.readLine()) != null) {
                String[] split = linea.split(",");
                     if (split.length >= 4) { // Verifica que haya al menos 4 elementos en la línea
                Paciente paci = new Paciente();
                paci.setNombre(split[0]);
                paci.setMotivo(split[3]);
                this.agregar(paci);
            } else {
                // Manejar el caso donde la línea no tiene suficientes elementos
                System.err.println("Línea incorrecta: " + linea);
            }
                   
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(pacientes.size());
        return pacientes;
    }

    @Override
    public String toString() {
        return "CargarDatosPacientesConsultas{" + "pacientes=" + pacientes + '}';
    }
    
}
