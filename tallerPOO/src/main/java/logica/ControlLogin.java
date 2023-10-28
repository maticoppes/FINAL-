
package logica;
import interfas.OpcionesDoc;
import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;
public class ControlLogin {
        
     String barra = File.separator;
    // Ruta relativa a la carpeta "TallerPoovvvv/Registro" dentro del proyecto
    String Ubicacion = System.getProperty("user.dir") + barra + "BaseDatos"+barra+"Roles"+barra+"Medico"+barra;
    private Component rootPane;
    public void rol(String usuario){
        
        //obtengo el nombre del usuario dentro del archivo
        File direccion = new File(Ubicacion + usuario+ ".txt" );
            if(direccion.exists()){
 
                    OpcionesDoc cambio = new OpcionesDoc();
                    cambio.setVisible(true);
                    cambio.setLocationRelativeTo(null);
            }else{
                
                JOptionPane.showMessageDialog(rootPane, "Personal sin autorizacion");
                
            }
                
        }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  } 
    

