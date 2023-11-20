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
    
    public static int [] numeros(String [] valores){
        int [] array = new int [valores.length];
        switch (valores[0]) {
            case "Normal":
                array[0] = 0;
                break;
            case "Moderada":
                array[0] = 1;
                break;
            default:
                array[0] = 2;
        }

        switch (valores[1]) {
            case "Normal":
                array[1] = 0;
                break;
            default:
                array[1] = 1;
        }
        
        switch (valores[2]) {
            case "Normal":
                array[2] = 0;
                break;
            case "Leve":
                array[2] = 1;
                break;
            default:
                array[2] = 2;
        }

        /*switch (valores[9]) {
            case "No presente":
                array[2] = 0;
                break;
            case "Moderado":
                array[2] = 1;
                break;
            default:
                array[2] = 2;
        }
*/
        switch (valores[3]) {
            case "No presente":
                array[3] = 0;
                break;
            default:
                array[3] = 1;
        }

        switch (valores[4]) {
            case "No presente":
                array[4] = 0;
                break;
            default:
                array[4] = 2;
        }

        switch (valores[5]) {
            case "Adulto":
                array[5] = 0;
                break;
            default:
                array[5] = 1;
        }

        switch (valores[6]) {
            case "Sin fiebre":
                array[6] = 0;
                break;
            case "Moderada":
                array[6] = 1;
                break;
            default:
                array[6] = 2;
        }

        switch (valores[7]) {
            case "No presentes":
                array[7] = 0;
                break;
            default:
                array[7] = 3;
        }

        switch (valores[8]) {
            case "No presentes":
                array[8] = 0;
                break;
            default:
                array[8] = 1;
        }

        switch (valores[9]) {
             case "No presente":
                array[9] = 0;
                break;
            case "Moderado":
                array[9] = 1;
                break;
            default:
                array[9] = 2;
        }

        switch (valores[10]) {
            case "Conciente y alerta":
                array[10] = 0;
                break;
            default:
                array[10] = 3;
        }

        switch (valores[11]) {
            case "Sin vomitos":
                array[11] = 0;
                break;
            case "Moderado":
                array[11] = 1;
                break;
            default:
                array[11] = 2;
        }

        switch (valores[12]) {
            case "No Presente":
                array[12] = 0;
                break;
            case "Sangrado moderado":
                array[12] = 1;
                break;
            default:
                array[12] = 2;
        }

        return array;
    }
     
    public String color(String[] obtener) {
        //int res, pulso, dolorPe, lesionGrav, edadd, fiebree, shockk, lesionesLev, estadoMen, concienciaa, vomitoss, sangrado, dolorAb;

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

        switch (obtener[9]) {
            case "No presente":
                estadoMen = 0;
                break;
            case "Moderado":
                estadoMen = 1;
                break;
            default:
                estadoMen = 2;
        }

        switch (obtener[3]) {
            case "No presente":
                dolorPe = 0;
                break;
            default:
                dolorPe = 1;
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
            case "No presentes":
                shockk = 0;
                break;
            default:
                shockk = 3;
        }

        switch (obtener[8]) {
            case "No presentes":
                lesionesLev = 0;
                break;
            default:
                lesionesLev = 1;
        }

        switch (obtener[9]) {
            case "Normal":
                estadoMen = 0;
                break;
            case "Leve":
                estadoMen = 1;
                break;
            default:
                estadoMen = 2;
        }

        switch (obtener[10]) {
            case "Conciente y alerta":
                concienciaa = 0;
                break;
            default:
                concienciaa = 3;
        }

        switch (obtener[11]) {
            case "Sin vomitos":
                vomitoss = 0;
                break;
            case "Moderado":
                vomitoss = 1;
                break;
            default:
                vomitoss = 2;
        }

        switch (obtener[12]) {
            case "No Presente":
                sangrado = 0;
                break;
            case "Sangrado moderado":
                sangrado = 1;
                break;
            default:
                sangrado = 2;
        }

        switch (obtener[2]) {
            case "No presente":
                dolorAb = 0;
                break;
            case "Moderado":
                dolorAb = 1;
                break;
            default:
                dolorAb = 2;
        }

        //resultado = 0;
        //resultado = res + pulso + dolorPe + lesionGrav + edadd + fiebree + shockk + lesionesLev + estadoMen + concienciaa + vomitoss + sangrado + dolorAb;
        Triage var = new Triage();
        String devolver = var.obtenerColorSugerido  (res,pulso 
                                          ,estadoMen,dolorPe,concienciaa, lesionGrav
                                          ,edadd,fiebree,vomitoss,dolorAb
                                          ,shockk,lesionesLev,sangrado);
        return devolver;
    }

}
