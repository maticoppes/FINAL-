
package com.mycompany.tallerpoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ListaEspecialidades {
    protected ArrayList <Especialidad> especialidades;

    public ListaEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public ListaEspecialidades() {
        this.especialidades=new ArrayList <Especialidad>();
    }

    public ArrayList<Especialidad> getResultados() {
        return especialidades;
    }

    public void setResultados(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
    
    public void agregar(Especialidad espe){
        especialidades.add(espe);
    }
    
    public void eliminar(Especialidad espe){
        especialidades.remove(espe);
    }
    
    public void leer(String archivo){
        leerInterno(archivo,null,null);
    }
    
    public void leer(String archivo, ListaMedicos listamed, ListaMedEsp listamedesp){
        leerInterno(archivo,listamed,listamedesp);
    }
        
    private void leerInterno(String archivo, ListaMedicos listamed, ListaMedEsp listamedesp){
        
        try {
            BufferedReader reader= new BufferedReader (new FileReader(archivo));
            String linea = reader.readLine();
            
            while (linea!=null && !linea.isBlank()){
                String[] split=linea.split(",");//splitea la linea                
                String infoMedico= split[0].replace("[", "");
                infoMedico= infoMedico.replace("]", "");
                
                String [] splitInfoMed= infoMedico.split(";");
                

                
                Especialidad espe=new Especialidad();
                
                espe.setTitulo(split[1]);
                espe.setEspecialidad(split[2]);
                
                /*si se paso la lista de medicos por parametro, se busca por dni al medico
                y hace un agregarMedico.
                */
                if (listamed!=null){     
                    
                    for (String datos : splitInfoMed){
                        
                        String[] splitDatos=datos.split("-");
                        Medico medi=listamed.getPorDni(Integer.parseInt(splitDatos[0]));

                        /*si el medico existe, se añade esta especialidad la lista del medico, y al atributo medico
                        de la clase dependencia MedicoEspecialdad*/
                        if (medi!=null){
                            espe.agregarMedico(medi);
                            medi.agregarEspecialidad(espe);
                            String[] splitFecha=splitDatos[1].split("/");
                            //se inicializa la fecha y hora
                            LocalDate fecha= LocalDate.of(Integer.parseInt(splitFecha[2]),
                                                         Integer.parseInt(splitFecha[1]),
                                                     Integer.parseInt(splitFecha[0]));

                            MedicoEspecialidad medicoesp=new MedicoEspecialidad(fecha,splitDatos[2],medi,espe);
                            listamedesp.agregarEspe(medicoesp);
                        }
                    }
                }
                
                this.agregar(espe);
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "ListaEspecialidades{" + "especialidades=" + especialidades + '}';
    }
}
