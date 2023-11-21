/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import interfas.PantallaAdminSist;
import com.mycompany.tallerpoo.FuncionarioGeneral;
import com.mycompany.tallerpoo.ListaMedicos;
import java.awt.Component;
import java.io.File;
import com.mycompany.tallerpoo.ListaMedicos;
import com.mycompany.tallerpoo.Medico;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import logica.Mostrar;
//

/**
 * La clase ValidarSesion realiza la validación de la sesión de un usuario.
 *
 * @author Alumno
 */
public class ValidarSesion {

    String barra = File.separator;
    // Ruta relativa a la carpeta "TallerPoovvvv/Registro" dentro del proyecto
    String Ubicacion = System.getProperty("user.dir") + barra + "Archivos" + barra + "Funcionario.txt";
    private Component rootPane;

    /**
     * Valida la sesión del usuario comparando los datos ingresadas con los
     * datos almacenados.
     *
     * @param usuario Nombre de usuario proporcionado.
     * @param contrasenia Contraseña proporcionada.
     * @throws FileNotFoundException Si el archivo con los datos no se
     * encuentra.
     * @throws IOException Si ocurre un error de lectura.
     */
    public void sesion(String usuario, String contrasenia) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Ubicacion));
        String linea = reader.readLine();

        if (usuario.equals("") || contrasenia.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Complete los campos");

        } else {

            try {
                while (linea != null) {
                    String[] split = linea.split(",");
                    FuncionarioGeneral funci = new FuncionarioGeneral();
                    funci.setDocumento(Integer.parseInt(split[0]));
                    funci.setContrasenia(split[10]);

                    if (funci.getDocumento() == (Integer.parseInt(usuario)) && funci.getContrasenia().equals(contrasenia)) {
                        System.out.println("aaaaasdaasdas");
                        Mostrar mostrar = new Mostrar();
                        mostrar.valido(split[8]);
                        break;
                    } else {
                        linea = reader.readLine();

                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrecto");
            }

        }

    }
}
