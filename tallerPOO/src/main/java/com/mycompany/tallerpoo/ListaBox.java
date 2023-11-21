package com.mycompany.tallerpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * La clase ListaBox es una colección que almacena instancias de la clase Box.
 * Permite agregar boxes a la lista, buscar boxes por número, eliminar boxes y
 * gestionar su ocupación. También proporciona métodos para leer y escribir
 * datos de boxes desde/hacia un archivo.
 *
 * @author Usuario
 */
public class ListaBox {

    /**
     * Lista que almacena instancias de la clase Box.
     */
    private ArrayList<Box> boxes;

    /**
     * Constructor de la clase ListaBox que permite inicializar la lista con una
     * lista existente de boxes.
     *
     * @param boxes La lista de boxes para inicializar.
     */
    public ListaBox(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    /**
     * Constructor de la clase ListaBox que crea una lista vacia de boxes.
     */
    public ListaBox() {
        this.boxes = new ArrayList<Box>();
    }

    /**
     * Obtiene la lista de boxes.
     *
     * @return La lista de boxes almacenada en esta instancia.
     */
    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    /**
     * Setea la lista de boxes con una nueva lista.
     *
     * @param boxes La nueva lista de boxes a establecer.
     */
    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    /**
     * Agrega una instancia de Box a la lista de boxes.
     *
     * @param box La instancia de Box que se agregará a la lista.
     */
    public void agregarBox(Box box) {
        boxes.add(box);
    }

    /**
     * Busca un box por su número.
     *
     * @param numero El número del box a buscar.
     * @return La instancia de Box con el número especificado, o null si no se
     * encuentra.
     */
    public Box getPorNumero(int numero) {
        for (Box box : this.boxes) {
            if (box.getNumero() == numero) {
                return box;
            }
        }
        return null;
    }

    /**
     * Elimina un box de la lista de boxes.
     *
     * @param box La instancia de Box que se eliminará de la lista.
     */
    public void eliminarBox(Box box) {
        boxes.remove(box);
    }

    /**
     * Agrega información de un box a un archivo especificado.
     *
     * @param archivoNombre El nombre del archivo en el que se agregará la
     * información del box.
     * @param box El box cuya información se agregará al archivo.
     */
    public void agregarAlArchivo(String archivoNombre, Box box) {
        PrintWriter salida = null;
        try {
            File archivo = new File(archivoNombre);
            salida = new PrintWriter(new FileWriter(archivo, true));

            salida.println(box.getNumero() + "," + (box.isOcupado() ? 1 : 0));

        } catch (IOException ex) {

        } finally {
            salida.close();
        }
    }

    /**
     * Lee información de boxes desde un archivo especificado y agrega los boxes
     * a la lista.
     *
     * @param archivo El nombre del archivo del cual se leerá la información de
     * los boxes.
     */
    public void leer(String archivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea = reader.readLine();

            while (linea != null && !linea.trim().isEmpty()) {
                String[] split = linea.split(",");//splitea la linea

                Box box = new Box();

                box.setNumero(Integer.parseInt(split[0]));

                if ("0".equals(split[1])) {
                    box.setOcupado(false);
                } else {
                    box.setOcupado(true);
                }

                this.agregarBox(box);
                linea = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
