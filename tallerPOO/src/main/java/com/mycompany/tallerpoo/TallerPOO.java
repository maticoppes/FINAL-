package com.mycompany.tallerpoo;

/**
 *
 * @author 54345
 */
import InterfazUsuario.*;
import static com.mycompany.tallerpoo.ManejoArchivos.*;
import static com.mycompany.tallerpoo.RegistroMedico.CalcularPacPorEdadesyFechas;
import static com.mycompany.tallerpoo.RegistroMedico.calcularMasConsPorFecha;
import static com.mycompany.tallerpoo.RegistroMedico.calcularMedMasPacPorFecha;
//import static com.mycompany.tallerpoo.Triage.cantTriagePorFecha;

import java.time.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class TallerPOO {

    public static void main(String[] args) throws IOException {        
       
        Medico medi=new Medico("Lucas Nuñez",LocalDate.of(2022,1,1),"Alegria 123",44092390,4438354,3454343,"Soltero","lucasmagiconunez@gmail.com",7827);
        LocalDate fecha1 = LocalDate.of(2000, 7, 15);
        LocalDate fecha2 = LocalDate.of(2025, 10, 24);
       
        String barra= File.separator;
        
        ListaBox listaBox=new ListaBox();
        ListaPacientes listapaci=new ListaPacientes();
        ListaResEstudios listaresu=new ListaResEstudios();
        ListaAdmisiones listaAdmisiones=new ListaAdmisiones();
        ListaMedicos listamedi=new ListaMedicos();
        ListaEspecialidades listaespe= new ListaEspecialidades();
        ListaMedEsp listamedesp=new ListaMedEsp();
        ListaPacientes listaPaciSinTriage=new ListaPacientes();
        ListaPacientes listaPaciTriageados=new ListaPacientes();
        ListaTriage prueba = new ListaTriage();
        ListaEnfermeros listaenfermeros=new ListaEnfermeros();
        ////////////////////////////////////////////////
//        ListaPVarias listavarias=new ListaPVarias();
        
        String userDir=System.getProperty("user.dir");
        
        listaBox.leer(userDir+"\\Archivos\\Boxes.txt");
        listapaci.leer(userDir+"\\Archivos\\Pacientes.txt");
        listaresu.leer(userDir+"\\Archivos\\ResEstudios.txt");
        listaAdmisiones.leer(userDir+"\\Archivos\\Admisiones.txt",listapaci);
        listamedi.leer(userDir+"\\Archivos\\Medicos.txt");
        listaespe.leer(userDir+"\\Archivos\\Especialidades.txt",listamedi,listamedesp);
        listaPaciSinTriage.leer(userDir+"\\Archivos\\EnEsperaAlTriage.txt");
        listaPaciTriageados.leer(userDir+"\\Archivos\\EnEsperaPorAtender.txt");
        listaenfermeros.leer(userDir+"\\Archivos\\Enfermeros.txt");
        prueba.leer(userDir+"\\Archivos\\Triage.txt");
        
        DatosTaller.setPacientes(listapaci);
        DatosTaller.setMedicos(listamedi);
        DatosTaller.setResultados(listaresu);
        DatosTaller.setAdmisiones(listaAdmisiones);
        DatosTaller.setEspecialidades(listaespe);
        DatosTaller.setBoxes(listaBox);
        DatosTaller.setTriages(prueba);
        DatosTaller.setPacientesSinTriage(listaPaciSinTriage);
        DatosTaller.setPacientesTriageados(listaPaciTriageados);
        DatosTaller.setEnfermeros(listaenfermeros);
        
        /*
        LocalTime hora=LocalTime.of(1, 2,3);
        AdmisionDeEmergencia admi=new AdmisionDeEmergencia(fecha1, hora, "ahsdsa");
        
        medi.hacerTriage(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,admi);/
        /////////////////////////////////////////////////////////////////////
        /*
        DatosTaller.setTriages(prueba);
                AdmisionDeEmergencia admision2 = new AdmisionDeEmergencia(
            LocalDate.of(2023, 10, 26),
            LocalTime.of(15, 30,30),
            "Dolor en el pecho", Paciente,Triage);
        
        
        //listaAdmisiones.agregar(primera);
        //listaAdmisiones.agregarAlArchivo("Archivos/Admisiones.txt", primera);
        ListaAdmisiones adm = DatosTaller.getAdmisiones();        
        
        
        for (AdmisionDeEmergencia paciente : adm.getAdmisiones()) {
            System.out.println("Fecha de admision: " + paciente.getFecha());
        }
        */
        
        
        /////////////////////////////////////////////////////////
       //METODOS TRIAGE
        
        Triage hola= new Triage();
        Triage opa= new Triage();
        ArrayList<Integer> resultado = hola.cantTriagePorFecha(fecha1,fecha2);
        
        String colour="";    
        for (int i = 0; i < resultado.size(); i++) {
                if (i==0){colour="Rojo";}if (i==1){colour="Naranja";}
                if (i==2){colour="Amarillo";}if (i==3){colour="Verde";}
                if (i==4){colour="Azul";}
                System.out.println
        ("Recuento de categoría " + colour + ": " + resultado.get(i));}
        
        
        
        ArrayList<String> res=opa.obtenerTriageCambiadosPorFecha(fecha1,fecha2);
        for( int i=0; i<res.size() ;i++){
            System.out.println( res.get(i));}                
        
       
       ////////////////////////////////////////////////////////////////////
       
       ///////////////////////////////////////////////////////////////////
       //METODOS DE REGISTRO MEDICO        
         
        String dniMedico="42218299"; //DNI DE UN MEDICO DE LA LISTA DE MEDICOS
       
       int numPacientes= RegistroMedico.calcularNumPacDeMedPorFecha(fecha1, fecha2, dniMedico); //MUESTRA CUANTOS PACIENTES ATENDIO ESE MEDICO PASADO POR PARAMETROS
        System.out.println("Número de pacientes atendidos por el médico en el rango de fechas: " + numPacientes);
        
        String medicoConMasPacientes = calcularMedMasPacPorFecha(fecha1, fecha2);// MUESTRA QUE MEDICO ATENCOP MAS PACIENTES EN UN RANGO DE FECHAS
        System.out.println("El DNI del médico que atendió a la mayoría de pacientes entre las fechas: "+ fecha1+" - "+fecha2+" es: " + medicoConMasPacientes);        
       
        ArrayList<String> personasConMasConsultas = calcularMasConsPorFecha(fecha1, fecha2);//MUESTRA DNI DE  PERSONAS QUE MAS CONSULTARON EN UN RANGO DE FECHAS
            for (String dni : personasConMasConsultas) {
                 System.out.println("DNI/s de personas que mas consultaron en las fechas: "+fecha1+" y " +fecha2 +": "+ dni);
                                        }
        
        String edad1 = "18"; // Edad mínima
        String edad2 = "60"; // Edad máxima

        // Llama al método CalcularPacPorEdadesyFechas y almacena el resultado en una variable
        int resultadoS = CalcularPacPorEdadesyFechas(fecha1, fecha2, edad1, edad2);        
        System.out.println("Número de pacientes en el rango de edades entre: "+edad1 + "  y   "+ edad2 +" en las fechas: "+ fecha1+"-"+fecha2+" es de: " +resultadoS);
       
       
        //////////////////////////////////////////////////////////////////////////////////////           
        MenuGestorCentro abc=new MenuGestorCentro();
        abc.setVisible(true);
        abc.setLocationRelativeTo(null);
        
//        ArrayList lista=ResultadoEstudios.obtenerResultadoEstudios(LocalDate.of(2023,5,10));
        
//        System.out.println(lista);

        BuscarEstFecha buscar=new BuscarEstFecha();
        buscar.setVisible(true);
        buscar.setLocationRelativeTo(null); 
    }
}
