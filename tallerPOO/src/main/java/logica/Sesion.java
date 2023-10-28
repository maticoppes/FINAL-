package logica;

import Interfas.PantallaAdminSist;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Sesion {

    String barra = File.separator;
    // Ruta relativa a la carpeta "TallerPoovvvv/Registro" dentro del proyecto
    String Ubicacion = System.getProperty("user.dir") + barra + "BaseDatos" + barra;
    private Component rootPane;

    public void sesion(String usuario, String contrasenia) {

        //obtengo el nombre del usuario dentro del archivo
        File direccion = new File(Ubicacion + usuario + ".txt");
        if (usuario.equals("") || contrasenia.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Complete los campos");

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
