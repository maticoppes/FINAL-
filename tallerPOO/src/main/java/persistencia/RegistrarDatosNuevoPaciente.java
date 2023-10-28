/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import interfas.RegistrarNuevoPaciente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Matías
 */
public class RegistrarDatosNuevoPaciente {
      public void Carga(String Ubicacion, String datos) {
        System.out.println(Ubicacion);
        File archivo = new File(Ubicacion);

        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
            escritor.write(datos);
            escritor.newLine();
            escritor.close();
            RegistrarNuevoPaciente a = new RegistrarNuevoPaciente();
            a.correcto();
        } catch (IOException e) {
            System.err.println("Error al cargar datos en el archivo: " + e.getMessage());
        }
    }
    
    
}
