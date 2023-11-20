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
                array[0] = 0;
                break;
            case "Moderada":
                array[0] = 1;
                break;
            default:
                array[0] = 2;
        }

        switch (obtener[1]) {
            case "Normal":
                array[1] = 0;
                break;
            default:
                array[1] = 1;
        }

        switch (obtener[2]) {
            case "Normal":
                array[2] = 0;
                break;
            case "Leve":
                array[2] = 1;
                break;
            default:
                array[2] = 2;
        }
        
        switch (obtener[3]) {
            case "Conciente y alerta":
                array[3] = 0;
                break;
            default:
                array[3] = 3;
        }
        
        switch (obtener[4]) {
            case "No presente":
                array[4] = 0;
                break;
            default:
                array[4] = 2;
        }

        switch (obtener[5]) {
            case "Adulto":
                array[5] = 0;
                break;
            default:
                array[5] = 1;
        }

        switch (obtener[6]) {
            case "Sin fiebre":
                array[6] = 0;
                break;
            case "Moderada":
                array[6] = 1;
                break;
            default:
                array[6] = 2;
        }

        switch (obtener[7]) {
            case "Sin vomitos":
                array[7] = 0;
                break;
            case "Moderado":
                array[7] = 1;
                break;
            default:
                array[7] = 2;
        }
        
        switch (obtener[8]){
            case "Nopresente":
                array[8] = 0;
                break;
            case "Moderado":
                array[8] = 1;    
            default:
                array[8] = 2;
        }
        
        switch (obtener[9]) {
            case "No presentes":
                array[9] = 0;
                break;
            default:
                array[9] = 3;
        }

        switch (obtener[10]) {
            case "No presentes":
                array[10] = 0;
                break;
            default:
                array[10] = 1;
        }

         switch (obtener[11]) {
            case "No Presente":
                array[11] = 0;
                break;
            case "Sangrado moderado":
                array[11] = 1;
                break;
            default:
                array[11] = 2;
        }
        
         switch (obtener[12]) {
            case "No presente":
                array[12] = 0;
                break;
            default:
                array[12] = 1;
        }
         System.out.println("arraynumeroooos" + array[0]+array[1]+array[2]+array[3]+array[4]+array[5]+array[6]);
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
