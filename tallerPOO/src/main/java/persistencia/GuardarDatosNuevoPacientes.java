
package persistencia;
import interfas.IngresoInfoFuncionario;
import interfas.RegistrarNuevoPaciente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class GuardarDatosNuevoPacientes {

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
