
package com.mycompany.tallerpoo;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ListaMedEsp {
    private ArrayList<MedicoEspecialidad> medespe;

    public ListaMedEsp(ArrayList<MedicoEspecialidad> medespe) {
        this.medespe = medespe;
    }

    public ListaMedEsp() {
        this.medespe=new ArrayList<MedicoEspecialidad>();
    }

    
    public ArrayList<MedicoEspecialidad> getMedespe() {
        return medespe;
    }

    public void setMedespe(ArrayList<MedicoEspecialidad> medespe) {
        this.medespe = medespe;
    }
    
    public void agregarEspe(MedicoEspecialidad espe){
        this.medespe.add(espe);
    }

    @Override
    public String toString() {
        return "ListaMedEsp{" + "medespe=" + medespe + '}';
    }
   
    
}
