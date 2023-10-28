package logica;

import com.mycompany.tallerpoo.FuncionarioGeneral;
import interfas.InterfazDoc;
import interfas.PantallaAdminSist;

/**
 *
 * @author Alumno
 */
public class Mostrar {

    public void valido(FuncionarioGeneral rol) {
        if (rol.getRol().equals("Medico")) {
            InterfazDoc doc = new InterfazDoc();
            doc.setVisible(true);
            doc.setLocationRelativeTo(null);
        } else {
            if (rol.getRol().equals("Enfermero")) {
                InterfazEnferm doc = new InterfazEnferm();
                doc.setVisible(true);
                doc.setLocationRelativeTo(null);
            } else {
                if (rol.getRol().equals("AdministradorSistemas")) {
                    PantallaAdminSist doc = new PantallaAdminSist();
                    doc.setVisible(true);
                    doc.setLocationRelativeTo(null);
                } else {
                    if (rol.getRol().equals("Sector")) {
                        InterfazSector doc = new InterfazSector();
                        doc.setVisible(true);
                        doc.setLocationRelativeTo(null);
                    }

                }
            }
        }
    }
}
