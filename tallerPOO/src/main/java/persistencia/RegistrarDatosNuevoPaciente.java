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
 * La clase RegistrarDatosNuevoPaciente permite la carga de nuevos datos de
 * pacientes a un archivo específico. Los datos se proporcionan como una cadena
 * de texto y se agregan al archivo existente.
 *
 * @author Matías
 */
public class RegistrarDatosNuevoPaciente {

    /**
     * Carga los datos de un nuevo paciente en el archivo especificado.
     *
     * @param Ubicacion Ruta del archivo donde se almacenarán los datos.
     * @param datos Cadena de texto que contiene la información del nuevo
     * paciente.
     */
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
