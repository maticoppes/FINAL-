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
 *
 * @author Usuario
 */

public class LecturaDatosFuncionariosGenerales {
    public ArrayList <FuncionarioGeneral> pacientes;
    private String Ubicacion = System.getProperty("user.dir") + "/Archivo/Funcionario.txt";
    
    public LecturaDatosFuncionariosGenerales() {
        this.pacientes = new ArrayList<FuncionarioGeneral>();
    }
    
    public LecturaDatosFuncionariosGenerales(ArrayList<FuncionarioGeneral> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<FuncionarioGeneral> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<FuncionarioGeneral> pacientes) {
        this.pacientes = pacientes;
    }
    
    public void agregar(FuncionarioGeneral paci){
        pacientes.add(paci);
    }
    
    public void eliminar(FuncionarioGeneral paci){
        pacientes.remove(paci);
    }
    
    public FuncionarioGeneral getPorDni(int dni){
        pacientes = this.leer(Ubicacion);
        for (FuncionarioGeneral paci : this.pacientes){
           if (paci.getDocumento()==dni){
                return paci;
            }        
        }
        return null;
    }
    
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
                paci.setTelefoFijo(Integer.parseInt(split[4]));
                paci.setTelefonoCelular(Integer.parseInt(split[5]));
                paci.setEstadoCivil(split[6]);
                paci.setCorreoElectronico(split[7]);
                paci.setRol(split[8]);
                paci.setContrasenia(split[9]);
                paci.setSector(split[10]);
                
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

    @Override
    public String toString() {
        return "ListaPacientes{" + "pacientes=" + pacientes + '}';
    }
}
