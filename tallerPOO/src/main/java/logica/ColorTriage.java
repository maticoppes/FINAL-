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
