package logica;

import Interfas.MenuGestorCentro;
import interfas.IngresoDNI;
import interfas.InterfazDoc;
import interfas.InterfazEnferm;
import interfas.PantallaAdminSist;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * La clase Mostrar se encarga de mostrar interfaces gráficas específicas según
 * el rol proporcionado como parámetro. Lee información del archivo de Funcionario
 * para determinar el tipo de interfaz que debe mostrarse.
 *
 * @author Alumno
 */
public class Mostrar {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Archivos" + barra + "Funcionario.txt";

    /**
     * Muestra la interfaz correspondiente al rol proporcionado.
     *
     * @param rol El rol del usuario autenticado.
     * @throws IOException Si hay un problema al leer el archivo de médicos.
     */
    public void valido(String rol) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ubicacion));
        String linea = reader.readLine();

        while (linea != null) {
            String[] split = linea.split(",");
            if (rol.equals("Medico")) {
                InterfazDoc doc = new InterfazDoc();
                doc.setVisible(true);
                doc.setLocationRelativeTo(null);

                break;
            } else {
                if (rol.equals("Enfermero")) {
                    InterfazEnferm doc = new InterfazEnferm();
                    doc.setVisible(true);
                    doc.setLocationRelativeTo(null);

                    break;
                } else {
                    if (rol.equals("Administrador de Sistemas")) {

                        PantallaAdminSist doc = new PantallaAdminSist();
                        doc.setVisible(true);
                        doc.setLocationRelativeTo(null);

                        break;
                    } else {
                        if (rol.equals("Sector")) {
                            IngresoDNI doc = new IngresoDNI();
                            doc.setVisible(true);
                            doc.setLocationRelativeTo(null);

                            break;
                        } else {
                            if (rol.equals("Gestor")) {
                                MenuGestorCentro doc = new MenuGestorCentro();
                                doc.setVisible(true);
                                doc.setLocationRelativeTo(null);

                                break;
                            }
                            break;

                        }
                    }
                }
            }
        }
    }
}
