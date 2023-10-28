package logica;

import com.mycompany.tallerpoo.FuncionarioGeneral;
import com.mycompany.tallerpoo.Medico;
import interfas.IngresoDNI;
import interfas.InterfazDoc;
import interfas.InterfazEnferm;
import interfas.PantallaAdminSist;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import persistencia.LecturaDatosFuncionariosGenerales;

/**
 *
 * @author Alumno
 */
public class Mostrar {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Archivos" + barra + "Medicos.txt";

    public void valido() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ubicacion));
        String linea = reader.readLine();

        while (linea != null) {
            String[] split = linea.split(",");
            Medico roles = new Medico();
            roles.setRol(split[9]);
                
            if (roles.getRol().equals("Medico")) {
                InterfazDoc doc = new InterfazDoc();
                doc.setVisible(true);
                doc.setLocationRelativeTo(null);
                System.out.println("a");
                break;
            } else {
                if (roles.getRol().equals("Enfermero")) {
                    InterfazEnferm doc = new InterfazEnferm();
                    doc.setVisible(true);
                    doc.setLocationRelativeTo(null);
                     System.out.println("b");
                    break;
                } else {
                    if (roles.getRol().equals("Administrador de Sistemas")) {
                        PantallaAdminSist doc = new PantallaAdminSist();
                        doc.setVisible(true);
                        doc.setLocationRelativeTo(null);
                         System.out.println("c");
                        break;
                    } else {
                        if (roles.getRol().equals("Sector")) {
                            IngresoDNI doc = new IngresoDNI();
                            doc.setVisible(true);
                            doc.setLocationRelativeTo(null);
                             System.out.println("d");
                            break;
                        }
                        break;

                    }
                }
            }
        }
    }
}
