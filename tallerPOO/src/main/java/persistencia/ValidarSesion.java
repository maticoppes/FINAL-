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
    String Ubicacion = System.getProperty("user.dir")+barra+"Archivos" + barra+"Medicos.txt";
    private Component rootPane;
    
       

    public void sesion(String usuario, String contrasenia) {
        
            String archivo = (Ubicacion);
            File direccion = new File(archivo);
            if (usuario.equals("") || contrasenia.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Complete los campos");

            } else {
                System.out.println(archivo);
             
                    try {
                        
                        ListaMedicos funci = new ListaMedicos();
                        ArrayList <Medico> funca = funci.leer(archivo);
                        
                        for (Medico funcionario : funca) {
                            if (funcionario.getDocumento() == (Integer.parseInt(usuario))) {
                                if (funcionario.getContrasenia().equals(contrasenia)) {
                                    
                                    Mostrar mostrar = new Mostrar();
                                    mostrar.valido();
                                 
                                    

                                }

                            } else {

                                JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrecto");
                            }

                        }
                    } catch (Exception e) {
                    }
               

            }
       
    }
}
