package persistencia;
import com.mycompany.tallerpoo.FuncionarioGeneral;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * La clase LecturaDatosFuncionariosGenerales se encarga de leer datos de funcionarios generales desde un archivo
 * de texto y cargarlos en una lista de objetos FuncionarioGeneral.
 * Además de la lectura de datos, la clase proporciona métodos para agregar, eliminar y buscar funcionarios generales
 * en la lista.
 * 
 * @author Usuario
 */
public class LecturaDatosFuncionariosGenerales {
    
     /**
     * Lista que almacena objetos de la clase FuncionarioGeneral.
     */
    public ArrayList <FuncionarioGeneral> pacientes;
    
    /**
     * Ruta del archivo que contiene los datos de los funcionarios generales.
     */
    private String Ubicacion = System.getProperty("user.dir") + "/Archivos/Funcionario.txt";
    
    /**
     * Constructor por defecto que inicializa la lista de funcionarios generales.
     */
    public LecturaDatosFuncionariosGenerales() {
        this.pacientes = new ArrayList<FuncionarioGeneral>();
    }
    
     /**
     * Constructor que permite inicializar la lista de funcionarios generales con una lista existente.
     * 
     * @param pacientes Lista de funcionarios generales.
     */
    public LecturaDatosFuncionariosGenerales(ArrayList<FuncionarioGeneral> pacientes) {
        this.pacientes = pacientes;
    }

    /**
     * Obtiene la lista de funcionarios generales.
     * 
     * @return Lista de funcionarios generales.
     */
    public ArrayList<FuncionarioGeneral> getPacientes() {
        return pacientes;
    }

    /**
     * Establece la lista de funcionarios generales.
     * 
     * @param pacientes Lista de funcionarios generales.
     */
    public void setPacientes(ArrayList<FuncionarioGeneral> pacientes) {
        this.pacientes = pacientes;
    }
    
    /**
     * Agrega un funcionario general a la lista.
     * 
     * @param paci Funcionario general a agregar.
     */
    public void agregar(FuncionarioGeneral paci){
        pacientes.add(paci);
    }
    
    /**
     * Elimina un funcionario general de la lista.
     * 
     * @param paci Funcionario general a eliminar.
     */
    public void eliminar(FuncionarioGeneral paci){
        pacientes.remove(paci);
    }
    
    /**
     * Busca un funcionario general por su número de documento en la lista.
     * 
     * @param dni Número de documento del funcionario a buscar.
     * @return Funcionario general encontrado o null si no se encuentra.
     */
    public FuncionarioGeneral getPorDni(int dni){
        pacientes = this.leer(Ubicacion);
        for (FuncionarioGeneral paci : this.pacientes){
           if (paci.getDocumento()==dni){
                return paci;
            }        
        }
        return null;
    }
    
    /**
     * Lee los datos de funcionarios generales desde un archivo y los almacena en la lista.
     * 
     * @param archivo Ruta del archivo que contiene los datos.
     * @return Lista de funcionarios generales con los datos leídos.
     */
    public ArrayList<FuncionarioGeneral> leer(String archivo){
        String barra  = File.separator;
        
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivo));
            String linea = reader.readLine();
            
            while (linea!=null){
                String[] split=linea.split(",");//splitea la linea
                String[] splitFecha=split[2].split("/");//splitea la fecha 
                //System.out.println(Arrays.toString(splitFecha));
                FuncionarioGeneral paci=new FuncionarioGeneral();
                
                LocalDate fechanac= LocalDate.of(Integer.parseInt(splitFecha[0]),
                                                Integer.parseInt(splitFecha[1]),
                                                Integer.parseInt(splitFecha[2]));
                
                paci.setDocumento(Integer.parseInt(split[0]));
                paci.setNombre(split[1]);
               
                paci.setFechaNacimiento(fechanac);
                paci.setDomicilio(split[3]);
                paci.setTelefoFijo(Long.parseLong(split[4]));
                paci.setTelefonoCelular(Long.parseLong(split[5]));
                paci.setEstadoCivil(split[6]);
                paci.setCorreoElectronico(split[7]);
                paci.setRol(split[8]);
                paci.setContrasenia(split[10]);
                paci.setSector(split[9]);
                
                this.agregar(paci);
                
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(pacientes.size());
     return pacientes;
             
     }

    /**
     * Devuelve una representación en cadena de la lista de funcionarios generales.
     * 
     * @return Representación en cadena de la lista de funcionarios generales.
     */
    @Override
    public String toString() {
        return "ListaPacientes{" + "pacientes=" + pacientes + '}';
    }
}
