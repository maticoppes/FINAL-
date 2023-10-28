
package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManejoArchivo {
    public static void escribirArchivo(String nombreArchivo, String contenido){
    File archivo = new File(nombreArchivo);//recibe la ruta del archivo
        try {
            //se utiliza para escribir si existe o crear un archivo si no existe
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            //cierra el flujo
            salida.close();
           
        } catch (FileNotFoundException ex) {
            //muestra la ruta de ejecucion hasta el error del codigo
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
           ex.printStackTrace(System.out);
        }
    
            
    
    }
}
