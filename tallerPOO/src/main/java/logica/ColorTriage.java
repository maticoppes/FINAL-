package logica;


import com.mycompany.taller.Triage;
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

    public void color(String[] obtener) {
        if ("Normal".equals(obtener[0])) {
            res = 0;
        } else {
            if ("Moderada".equals(obtener[0])) {
                res = 1;
            } else {
                res = 2;
            }
        }
        if ("Normal".equals(obtener[1])) {
            pulso = 0;
        } else {
            pulso = 1;
        }
        if ("No presente".equals(obtener[9])) {
            estadoMen = 0;
        } else {
            if ("Moderado".equals(obtener[9])) {
                estadoMen = 1;
            } else {
                estadoMen = 2;
            }
        }
        if ("No presente".equals(obtener[3])) {
            dolorPe = 0;
        } else {
            dolorPe = 1;
        }
        if ("No presente".equals(obtener[4])) {
            lesionGrav = 0;
        } else {
            lesionGrav = 2;
        }
        if ("Adulto".equals(obtener[5])) {
            edadd = 0;
        } else {
            edadd = 1;
        }
        if (obtener[6].equals("Sin fiebre")) {
            fiebree = 0;
        } else {
            if ("Moderada".equals(obtener[6])) {
                fiebree = 1;
            } else {
                fiebree = 2;
            }
        }
        if ("No presentes".equals(obtener[7])) {
            shockk = 0;
        } else {
            shockk = 3;
        }
        if ("No presentes".equals(obtener[8])) {
            lesionesLev = 0;
        } else {
            lesionesLev = 1;
        }
        if ("Normal".equals(obtener[9])) {
            estadoMen = 0;
        } else {
            if ("Leve".equals(obtener[9])) {
                estadoMen = 1;
            } else {
                estadoMen = 2;
            }
        }
        if ("Conciente y alerta".equals(obtener[10])) {
            concienciaa = 0;
        } else {
            concienciaa = 3;
        }
        if ("Sin vomitos".equals(obtener[11])) {
            vomitoss = 0;
        } else {
            if ("Moderado".equals(obtener[11])) {
                vomitoss = 1;
            } else {
                vomitoss = 2;
            }
              if(obtener[12].equals("No Presente")){   
                    sangrado = 0;
                    }else{
                            if(obtener[12].equals("Sangrado moderado")){
                            sangrado = 1;
                            }else{
                            sangrado = 2;
                            
                            }
                            }
              if("No presente".equals(obtener[2])){
              dolorAb=0;
              }else{
                  if("Moderado".equals(obtener[2])){
                      dolorAb=1;
              }else{
                      dolorAb=2;
                      }
            
        }
        resultado = res + pulso + dolorPe + lesionGrav + edadd
         + fiebree + shockk + lesionesLev + estadoMen + concienciaa + vomitoss+sangrado;
      Triage obt = new Triage();
      String a = obt.obtenerColorSugerido(res,pulso,estadoMen,concienciaa,lesionGrav,
              edadd,fiebree,vomitoss,dolorAb,shockk,lesionesLev,sangrado);
            System.out.println(a);
      PantallaTriage result = new PantallaTriage();
      result.cargar(a); 
      
      
      
    }
    
}
}
        

