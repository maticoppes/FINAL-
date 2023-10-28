
package persistencia;
import interfas.IngresoInfoFuncionario;
import interfas.RegistrarNuevoPaciente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Esta clase se encarga de guardar los datos de nuevos pacientes en un archivo.
 * Puede recibir una ubicación y los datos a guardar, y los agrega al archivo.
 * 
 * @see interfas.IngresoInfoFuncionario
 * @see interfas.RegistrarNuevoPaciente
 */

public class GuardarDatosNuevoPacientes {
    /**
     * Carga los datos proporcionados en un archivo especificado por la ubicación.
     * 
     * @param Ubicacion La ubicación del archivo donde se guardarán los datos.
     * @param datos     Los datos a guardar en el archivo.
     */
    public void Carga(String Ubicacion, String datos) {
        System.out.println(Ubicacion);
        File archivo = new File(Ubicacion);
              IngresoInfoFuncionario a = new IngresoInfoFuncionario();

        try {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))) {
                escritor.write(datos);
                escritor.newLine();
                escritor.close();
                a.correcto();
            }
        } catch (IOException e) {
            System.err.println("Error al cargar datos en el archivo: " + e.getMessage());
        }
    }
}
