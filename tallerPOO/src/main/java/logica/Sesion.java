package logica;

import interfas.PantallaAdminSist;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * La clase Sesion gestiona el proceso de inicio de sesión de usuarios.
 *
 * @author Alumno
 */
public class Sesion {

    String barra = File.separator;
    // Ruta relativa a la carpeta "TallerPoovvvv/Registro" dentro del proyecto
    String Ubicacion = System.getProperty("user.dir") + barra + "BaseDatos" + barra;
    private Component rootPane;
    String patron = "\\d{7,8}";

    /**
     * Realiza el proceso de inicio de sesión.
     *
     * @param usuario     El nombre de usuario ingresado.
     * @param contrasenia La contraseña ingresada.
     */
    public void sesion(String usuario, String contrasenia) {

        //obtengo el nombre del usuario dentro del archivo
        File direccion = new File(Ubicacion + usuario + ".txt");
        if (usuario.equals("") || contrasenia.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Complete los campos");

        } else {
            if (usuario != patron) {
                JOptionPane.showMessageDialog(rootPane, "Ingrese el usuario en un formato valido");
            } else {

                if (direccion.exists()) {
                    try {

                        FileInputStream aValidar = new FileInputStream(direccion);
                        Properties validar = new Properties();
                        validar.load(aValidar);
                        String contraseniA = validar.getProperty("Contraseña");
                        if (contraseniA.equals(contrasenia)) {

                            //ControlLogin control = new ControlLogin();
                            PantallaAdminSist control = new PantallaAdminSist();
                            //control.rol(usuario);
                            control.setVisible(true);
                            control.setLocationRelativeTo(null);
                        } else {

                            JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrecto");
                        }
                    } catch (Exception e) {
                    }
                } else {

                    JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrecto");

                }

            }

        }

    }
}
