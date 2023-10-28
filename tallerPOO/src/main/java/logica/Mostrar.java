package logica;

import com.mycompany.tallerpoo.FuncionarioGeneral;
import interfas.InterfazDoc;
import interfas.PantallaAdminSist;
import java.io.File;
import java.util.ArrayList;
import persistencia.LecturaDatosFuncionariosGenerales;

/**
 *
 * @author Alumno
 */
public class Mostrar {
    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir");
    public void valido() {
        FuncionarioGeneral funcionario= new FuncionarioGeneral();
        ArrayList <FuncionarioGeneral> rol = funcionario.leer(ubicacion);
        for(FuncionarioGeneral roles : rol){
        if (roles.getRol().equals("medico")) {
            InterfazDoc doc = new InterfazDoc();
            doc.setVisible(true);
            doc.setLocationRelativeTo(null);
        } else {
            if (roles.getRol().equals("Enfermero")) {
                InterfazEnferm doc = new InterfazEnferm();
                doc.setVisible(true);
                doc.setLocationRelativeTo(null);
            } else {
                if (roles.getRol().equals("AdministradorSistemas")) {
                    PantallaAdminSist doc = new PantallaAdminSist();
                    doc.setVisible(true);
                    doc.setLocationRelativeTo(null);
                } else {
                    if (roles.getRol().equals("Sector")) {
                        InterfazSector doc = new InterfazSector();
                        doc.setVisible(true);
                        doc.setLocationRelativeTo(null);
                    }

                }
            }
        }
    }
}
}
