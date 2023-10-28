/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Interfaz.PantallaAdminSist;
import com.mycompany.taller.FuncionarioGeneral;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import logica.Mostrar;

/**
 *
 * @author Alumno
 */
public class ValidarSesion {

    String barra = File.separator;
    // Ruta relativa a la carpeta "TallerPoovvvv/Registro" dentro del proyecto
    String Ubicacion = System.getProperty("user.dir") + barra + "BaseDatos" + barra;
    private Component rootPane;
    String[] documentos = new String[]{"Medico.txt", "Enfermero.txt", "AdminSistem.txt",
        "GestorCentro.txt,Sector.txt"};

    public void sesion(String usuario, String contrasenia) {
        for (int i = 0; i < documentos.length; i++) {
            String archivo = (Ubicacion + documentos[i]);
            File direccion = new File(archivo);
            if (usuario.equals("") || contrasenia.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Complete los campos");

            } else {
                if (direccion.exists()) {
                    try {
                        LecturaDatosFuncionariosGenerales buscar = new LecturaDatosFuncionariosGenerales();
                        ArrayList<FuncionarioGeneral> funci = buscar.leer(archivo);
                        for (FuncionarioGeneral funcionario : funci) {
                            if (funcionario.getDocumento() == (Integer.parseInt(usuario))) {
                                if (funcionario.getContrasenia().equals(contrasenia)) {
                                    
                                    Mostrar mostrar = new Mostrar();
                                    mostrar.valido(funcionario);
                                  continue;
                                    

                                }

                            } else {

                                JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrecto");
                            }

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
