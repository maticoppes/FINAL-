package logica;

import com.mycompany.tallerpoo.Triage;
import interfas.PantallaTriage;

public class ColorTriage {

    int res;
    int pulso;
    int dolorPe;
    int lesionGrav;
    int edadd;
    int fiebree;
    int shockk;
    int lesionesLev;
    int estadoMen;
    int concienciaa;
    int vomitoss;
    int sangrado;
    int resultado;
    int dolorAb;
    String triage;
    
    public int [] numeros(String [] obtener){
        int [] array = new int [obtener.length];
        switch (obtener[0]) {
            case "Normal":
                res = 0;
                break;
            case "Moderada":
                res = 1;
                break;
            default:
                res = 2;
        }

        switch (obtener[1]) {
            case "Normal":
                pulso = 0;
                break;
            default:
                pulso = 1;
        }

        switch (obtener[2]) {
            case "Normal":
                estadoMen = 0;
                break;
            case "Leve":
                estadoMen = 1;
                break;
            default:
                estadoMen = 2;
        }
        
        switch (obtener[3]) {
            case "Conciente y alerta":
                concienciaa = 0;
                break;
            default:
                concienciaa = 3;
        }
        
        switch (obtener[4]) {
            case "No presente":
                lesionGrav = 0;
                break;
            default:
                lesionGrav = 2;
        }

        switch (obtener[5]) {
            case "Adulto":
                edadd = 0;
                break;
            default:
                edadd = 1;
        }

        switch (obtener[6]) {
            case "Sin fiebre":
                fiebree = 0;
                break;
            case "Moderada":
                fiebree = 1;
                break;
            default:
                fiebree = 2;
        }

        switch (obtener[7]) {
            case "Sin vomitos":
                vomitoss = 0;
                break;
            case "Moderado":
                vomitoss = 1;
                break;
            default:
                vomitoss = 2;
        }
        
        switch (obtener[8]){
            case "Nopresente":
                dolorAb = 0;
                break;
            case "Moderado":
                dolorAb = 1;    
            default:
                dolorAb = 2;
        }
        
        switch (obtener[9]) {
            case "No presentes":
                shockk = 0;
                break;
            default:
                shockk = 3;
        }

        switch (obtener[10]) {
            case "No presentes":
                lesionesLev = 0;
                break;
            default:
                lesionesLev = 1;
        }

         switch (obtener[11]) {
            case "No Presente":
                sangrado = 0;
                break;
            case "Sangrado moderado":
                sangrado = 1;
                break;
            default:
                sangrado = 2;
        }
        
         switch (obtener[12]) {
            case "No presente":
                dolorPe = 0;
                break;
            default:
                dolorPe = 1;
        }

        return array;
    }
     
    public String color(String[] obtener) {
        //int res, pulso, dolorPe, lesionGrav, edadd, fiebree, shockk, lesionesLev, estadoMen, concienciaa, vomitoss, sangrado, dolorAb;
        int [] array = this.numeros(obtener);
       

        //resultado = 0;
        //resultado = res + pulso + dolorPe + lesionGrav + edadd + fiebree + shockk + lesionesLev + estadoMen + concienciaa + vomitoss + sangrado + dolorAb;
        Triage var = new Triage();
        String devolver = var.obtenerColorSugerido (array[0],array[1] 
                                          ,array[2],array[3],array[4],array[5]
                                          ,array[6],array[7],array[8]
                                          ,array[9],array[10],array[11],array[12]);
        return devolver;
    }

}
